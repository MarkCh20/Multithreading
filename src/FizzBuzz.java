import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

class FizzBuzz {
    private final int n;
    private int current = 1;
    private boolean finished = false;

    private final BlockingQueue<String> queue = new LinkedBlockingQueue<>();
    private final Semaphore fizzSem = new Semaphore(0);
    private final Semaphore buzzSem = new Semaphore(0);
    private final Semaphore fizzbuzzSem = new Semaphore(0);
    private final Semaphore numberSem = new Semaphore(1);

    public FizzBuzz(int n) {
        this.n = n;
    }

    public void fizz() throws InterruptedException {
        while (true) {
            fizzSem.acquire();
            if (finished) return;
            queue.put("fizz");
            nextStep();
        }
    }

    public void buzz() throws InterruptedException {
        while (true) {
            buzzSem.acquire();
            if (finished) return;
            queue.put("buzz");
            nextStep();
        }
    }

    public void fizzbuzz() throws InterruptedException {
        while (true) {
            fizzbuzzSem.acquire();
            if (finished) return;
            queue.put("fizzbuzz");
            nextStep();
        }
    }

    public void number() throws InterruptedException {
        while (true) {
            numberSem.acquire();
            if (current > n) {
                finished = true;
                fizzSem.release();
                buzzSem.release();
                fizzbuzzSem.release();
                return;
            }

            if (current % 3 == 0 && current % 5 == 0) {
                fizzbuzzSem.release();
            } else if (current % 3 == 0) {
                fizzSem.release();
            } else if (current % 5 == 0) {
                buzzSem.release();
            } else {
                queue.put(String.valueOf(current));
                nextStep();
            }
        }
    }

    private void nextStep() {
        current++;
        if (current > n) {
            finished = true;
            fizzSem.release();
            buzzSem.release();
            fizzbuzzSem.release();
            numberSem.release();
        } else {
            numberSem.release();
        }
    }

    public void printResults() throws InterruptedException {
        while (!finished || !queue.isEmpty()) {
            System.out.print(queue.take());
            if (!queue.isEmpty()) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

}

class FizzBuzzRunner {
    public static void run(int n) {
        FizzBuzz fizzBuzz = new FizzBuzz(n);

        Thread threadA = new Thread(() -> {
            try {
                fizzBuzz.fizz();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                fizzBuzz.buzz();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread threadC = new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread threadD = new Thread(() -> {
            try {
                fizzBuzz.number();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread printerThread = new Thread(() -> {
            try {
                fizzBuzz.printResults();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
        printerThread.start();

        try {
            threadA.join();
            threadB.join();
            threadC.join();
            threadD.join();
            printerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
