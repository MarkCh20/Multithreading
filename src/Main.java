public class Main {
    public static void main(String[] args) {
        System.out.println("\n--Test Task 1--\n");

        Thread timeThread = new Thread(new TimePrinter());
        Thread messageThread = new Thread(new MessagePrinter());

        timeThread.start();
        messageThread.start();

        try {
            Thread.sleep(11000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        timeThread.interrupt();
        messageThread.interrupt();

        try {
            timeThread.join();
            messageThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n--Test Task 2--\n");

        FizzBuzzRunner.run(15);
    }
}
