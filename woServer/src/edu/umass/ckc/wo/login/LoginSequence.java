package edu.umass.ckc.wo.login;

import ckc.servlet.servbase.ServletParams;
import edu.umass.ckc.wo.config.LoginXML;
import edu.umass.ckc.wo.event.SessionEvent;
import edu.umass.ckc.wo.login.interv.LoginIntervention;
import edu.umass.ckc.wo.login.interv.LoginInterventionSelector;
import edu.umass.ckc.wo.smgr.SessionManager;
import edu.umass.ckc.wo.tutor.Pedagogy;
import edu.umass.ckc.wo.tutor.intervSel2.InterventionSelector;
import edu.umass.ckc.wo.tutor.intervSel2.InterventionSelectorSpec;
import edu.umass.ckc.wo.tutor.model.InterventionGroup;
import edu.umass.ckc.wo.tutor.pedModel.PedagogicalModel;
import edu.umass.ckc.wo.woserver.ServletInfo;

import javax.servlet.RequestDispatcher;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: david
 * Date: 4/13/15
 * Time: 3:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginSequence {
    public static final String INNERJSP = "innerjsp";
    public static final String SKIN = "skin";
    public static final String SERVLET_CONTEXT = "servletContext";
    public static final String SERVLET_NAME = "servletName";
    public static final String SESSION_ID = "sessionId";
    private SessionManager smgr;
    private PedagogicalModel pedagogicalModel;
    private InterventionGroup interventionGroup;
    private ServletInfo servletInfo;
    private Connection conn;
    private int sessId;
    private int studId;


     // need to be able to use this class before there is a sessionId passed on the params

    public LoginSequence(ServletInfo servletInfo, int sessId) throws Exception {
        this.servletInfo = servletInfo;
        this.conn = servletInfo.getConn();
        ServletParams params = servletInfo.getParams();
        this.sessId = sessId;
        this.smgr = new SessionManager(servletInfo.getConn(),sessId,servletInfo.getHostPath(),servletInfo.getContextPath()).buildExistingSession();
        pedagogicalModel = smgr.getPedagogicalModel();
        Pedagogy ped = pedagogicalModel.getPedagogy();
        buildInterventions(ped);


    }

    private void buildInterventions (Pedagogy ped) throws Exception {
        LoginXML loginXML = ped.getLoginXML();
        interventionGroup = new InterventionGroup(loginXML.getInterventions());
        interventionGroup.buildInterventions(smgr,pedagogicalModel);
        for (InterventionSelector s : interventionGroup.getAllInterventions()) {
            LoginInterventionSelector ls = (LoginInterventionSelector) s;
            ls.setServletInfo(servletInfo);
        }
    }

    public LoginIntervention getNextIntervention (ServletParams params) throws Exception {
        LoginIntervention li = (LoginIntervention) interventionGroup.selectIntervention(smgr,new SessionEvent(params,this.sessId),"Login");
        return li;
    }


    public void processAction (ServletParams params, LoginIntervention li) throws Exception {

        if (li != null) {
            String innerJSP = li.getView();
            String skin = params.getString(SKIN);
            String loginJSP="login/logink12Outer.jsp" ;
            if (skin != null && skin.equalsIgnoreCase("adult"))
                loginJSP = "login/loginAdultOuter.jsp";
            servletInfo.getRequest().setAttribute(INNERJSP,innerJSP);
            servletInfo.getRequest().setAttribute(SERVLET_CONTEXT,servletInfo.getServletContext().getContextPath());
            servletInfo.getRequest().setAttribute(SERVLET_NAME,servletInfo.getServletName());
            servletInfo.getRequest().setAttribute(SESSION_ID,smgr.getSessionNum());
            RequestDispatcher disp = servletInfo.getRequest().getRequestDispatcher(loginJSP);
            disp.forward(servletInfo.getRequest(),servletInfo.getResponse());
        }
        else {
            // At the end of the login sequence, remove any state in interventions that were specified as ONCE_PER_SESSION
            // so that the next login will run them again.
            clearInterventionState();
            new LandingPage(servletInfo,smgr).handleRequest();
        }
    }

    public void clearInterventionState() throws SQLException {
        List<InterventionSelectorSpec> specs = interventionGroup.getInterventionsSpecs();
        for (InterventionSelectorSpec s: specs) {
//            if (s.getRunFreq().equals(InterventionSelectorSpec.ONCE_PER_SESSION)) {
                LoginInterventionSelector lis = (LoginInterventionSelector) s.getSelector();
                lis.clearState();
//            }

        }

    }
}
