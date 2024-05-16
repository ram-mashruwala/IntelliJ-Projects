package Main;

public class Main {

    public static void countdown(){

        for(int i = 120; i > 0; i--){

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i);

        }

    }

    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < 10; i++){
            System.out.println("Start Jogging at 0% incline");
            countdown();
            System.out.println("Start Walking at 10% incline");
            countdown();
        }


    }

}
