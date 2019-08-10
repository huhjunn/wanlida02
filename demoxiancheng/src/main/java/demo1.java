public class demo1{

    public static void main(String[] args) {
        Thread welcomeApp = new WelcomeApp();

        welcomeApp.start();

        System.out.println(
            "1.Welcome!"+ Thread.currentThread().getName());

    }
}

class WelcomeApp extends Thread{

    @Override
    public void run() {
        System.out.println(
                "2.Welcome! I'm%s.%n"+Thread.currentThread().getName());

    }
}