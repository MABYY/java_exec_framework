package org.javasql;

public class Main {
    public static void main(String[] args) {
        ExecutorsDemo.show();
        CompletableFuturesDemo.show();

        ComplFutExceptionsDemo.show();

        ComplFutTransformDemo.show();

        ComplFutComposeDemo.show();

        ComplFutCombineDemo.show();



        var service = new MailService();

        service.sendAsync();
        try { // ASYNC APIs don't block the current thread
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

// Let java take care of thread manipulation

// Thread pools
// - availability
// - cost

// Executors
// Callable and future interfaces
// Asyc programs
// Completable futures
