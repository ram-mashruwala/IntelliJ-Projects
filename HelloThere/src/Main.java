import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Assignment> as = new ArrayList<Assignment>();
        Scanner scan = new Scanner(System.in);
        // Start here
        while(true){
            System.out.print("Enter the assignment's name (exit to quit):");
            String n = scan.nextLine();
            if(n.equals("exit")){
                break;
            }

            System.out.print("Enter the due date:");
            String d = scan.nextLine();
            System.out.print("How many points is the assignment worth?");
            double a = scan.nextDouble();
            System.out.print("How many points were earned?");
            double e = scan.nextDouble();
            System.out.print("Is this a (T)est or a (P)roject?");
            String str = scan.nextLine();
            str = scan.nextLine();
            if(str.equalsIgnoreCase("T")){
                System.out.print("What type of test is it?");
                String t = scan.nextLine();
                as.add(new Test(n, d, a, e, t));
            } else if(str.toUpperCase().equals("P")){
                System.out.println("Does this project require (true/false) ...");
                System.out.print("Groups?");
                boolean b = scan.nextBoolean();
                System.out.print("A presentation?");
                boolean p = scan.nextBoolean();
                as.add(new Project(n, d, a, e, b, p));
            }
            System.out.println();
        }
        printSummary(as);

    }

    // Print due date and score percentage on the assignment
    public static void printSummary(ArrayList<Assignment> assignments) {

        for(Assignment a : assignments){
            System.out.println(a.getName() + " - " + ((a.getEarnedPoints() / a.getAvailablePoints()) * 100));
        }

    }
}