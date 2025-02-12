class TimePrinter implements Runnable {
    private final long startTime;

    public TimePrinter() {
        this.startTime = System.currentTimeMillis();
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                long elapsedSeconds = (System.currentTimeMillis() - startTime) / 1000;
                System.out.println(elapsedSeconds + " seconds" + " passed after TimePrinter started!");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("TimePrinter interrupted");
            Thread.currentThread().interrupt();
        }
    }
}



class MessagePrinter implements Runnable {
    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(5000);
                System.out.println("5 seconds passed after MessagePrinter started!");
            }
        } catch (InterruptedException e) {
            System.out.println("MessagePrinter interrupted");
            Thread.currentThread().interrupt();
        }
    }
}
