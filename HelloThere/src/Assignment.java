public class Assignment
{

    String name;
    String dueDate;
    double availablePoints;
    double earnPoints;

    public Assignment(String n, String d, double a, double e){
        name = n;
        dueDate = d;
        availablePoints = a;
        earnPoints = e;
    }

    public String getName(){return name;}
    public void setName(String n){name = n;}
    public String getDueDate(){return dueDate;}
    public void setDueDate(String d){dueDate = d;}
    public double getAvailablePoints(){return availablePoints;}
    public void setAvailablePoints(double a){availablePoints = a;}
    public double getEarnedPoints(){return earnPoints;}
    public void setEarnedPoints(double e){earnPoints = e;}

}
