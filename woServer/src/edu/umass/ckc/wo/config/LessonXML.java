package edu.umass.ckc.wo.config;

import edu.umass.ckc.wo.tutor.probSel.LessonModelParameters;
import edu.umass.ckc.wo.tutor.probSel.PedagogicalModelParameters;
import edu.umass.ckc.wo.tutor.probSel.TopicModelParameters;
import org.jdom.Element;

/**
 * Created with IntelliJ IDEA.
 * User: david
 * Date: 4/3/15
 * Time: 3:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class LessonXML {
    private Element interventions;
    private Element control;
    private String name;
    private String style;

    public LessonXML(Element interventions, Element control, String name, String style) {
        this.interventions = interventions;
        this.control = control;
        this.name = name;
        this.style = style;
    }

    public Element getInterventions() {
        return interventions;
    }

    public void setInterventions(Element interventions) {
        this.interventions = interventions;
    }

    public Element getControl() {
        return control;
    }

    public void setControl(Element control) {
        this.control = control;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LessonModelParameters getLessonModelParams () {
        if (style.equalsIgnoreCase("topics"))
            return new TopicModelParameters(this.control);
        else return new LessonModelParameters(this.control);
    }


}