public class Test extends Assignment {

    String testType;

    public Test(String n, String d, double a, double e, String t){
        super(n, d, a, e);
        testType = t;
    }

    public String getTestType(){return testType;}
    public void setTestType(String t){testType = t;}

}