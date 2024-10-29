package org.javasql;

import java.util.concurrent.CompletableFuture;

public class ComplFutExceptionsDemo {
    public static void show(){
        // Run code after an async task is completed
        // i.e display result after a task finishes

        var future = CompletableFuture.supplyAsync(()-> 1);
        future.thenRunAsync(()-> System.out.println(
                Thread.currentThread().getName()
        ));
        future.thenRun(()-> System.out.println(
                Thread.currentThread().getName() + "  DONE"));

    }
//        // CompletableFuture is a class introduced in Java 8
//        // that allows us to write asynchronous, non-blocking code.
//
//        Runnable task = () -> System.out.println("Task");
//        var future = CompletableFuture.runAsync(task); // dues not return a value
//
//        Supplier<Integer> task_int = () -> (1);
//        var future_var = CompletableFuture.supplyAsync(task_int);
//        try {
//            var result_var = future_var.get();
//        } catch (InterruptedException | ExecutionException e) {
//            throw new RuntimeException(e);
//        }
//    }


//    public static void show() {
//        var start = LocalTime.now();
//
//        var service = new FlightService();
//        var futures = service.getQuotes()
//                .map(future -> future.thenAccept(System.out::println))
//                .collect(Collectors.toList());
//
//        CompletableFuture
//                .allOf(futures.toArray(new CompletableFuture[0]))
//                .thenRun(() -> {
//                    var end = LocalTime.now();
//                    var duration = Duration.between(start, end);
//                    System.out.println("Retrieved all quotes in " + duration.toMillis() + " msec.");
//                });
//
//        try {
//            Thread.sleep(10_000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
}
