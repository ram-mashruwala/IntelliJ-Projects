public class Project extends Assignment {

    boolean group;
    boolean presentation;

    public Project(String n, String d, double a, double e, boolean g, boolean p){
        super(n, d, a, e);
        group = g;
        presentation = p;
    }

    public boolean hasGroups(){return group;}
    public boolean hasPresentation(){return presentation;}
    public void setGroups(boolean g){group = g;}
    public void setPresentation(boolean p){presentation = p;}

}
