package edu.umass.ckc.wo.interventions;

/**
 * Created with IntelliJ IDEA.
 * User: Melissa
 * Date: 4/7/15
 * Time: 12:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class CollaborationTimeoutIntervention extends InputResponseIntervention implements NextProblemIntervention{

    public static final String OPTION = "option";

    public  CollaborationTimeoutIntervention () {
        super();
    }
    public String getType () {
        return "CollaborationTimeoutIntervention";
    }


    public String getDialogHTML () {
        String str = "<div><p> No partner has been found for you yet. <br>" +
                      "Would you like to continue waiting for a partner?  <br/<br/>" + getFormOpen();
        str += "<input name=\""+OPTION+"\" type=\"radio\" value=\"No\" checked=\"checked\">No</input><br>";
        str += "<input name=\""+OPTION+"\" type=\"radio\" value=\"Yes\">Yes</input><br>";
        str+="</form></div>";
        return str;
    }


    @Override
    public boolean isBuildProblem() {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

}