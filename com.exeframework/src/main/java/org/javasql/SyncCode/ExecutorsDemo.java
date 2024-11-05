package org.javasql;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class ExecutorsDemo {
    public static void show() {

        var executor = Executors.newFixedThreadPool(2);

        try {
            var future = executor.submit(() -> {
                // We don't explicitly create the thread.
                // We submit the task to the thread pool and it will
                /// choose which thread will perform the task
                System.out.println(Thread.currentThread().getName());
                LongTask.simulate(); // simulate an operation that will take 3'
                return 1; // represents a callable object
            });

            System.out.println("Do more work");

            try {
                var result = future.get(); // get the result of the operation
                                           // the thread is blocked until the
                                            // result is available
                System.out.println("Result: " + result);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        finally {
            executor.shutdown();
            // shutdown the executor to terminate the program
            // Does not force the existing tasks to close.
            // Wait until the other tasks are finished
            // It prevents future tasks to be addressed bt the pool of threads
        };

        // CALLABLES AND FUTURES
//        var executor = Executors.newFixedThreadPool(2);
//        try {
//           var future =  executor.submit(()->{ // Pass callable object
//                System.out.println(Thread.currentThread().getName());
//                return 1;
//            }); // it returns a future which will not be calculated immediately
//
////            executor.submit(()->{ // Pass runnable object
////                System.out.println(Thread.currentThread().getName());
////            });
//        } finally {
//            executor.shutdownNow();
//        }

        // EXECUTORS: Two threads available that execute ten tasks
//        var executor = Executors.newFixedThreadPool(2);
//        try {
//            executor.submit(()->{
//                System.out.println(Thread.currentThread().getName());
//            });
//        } finally {
//            executor.shutdownNow();
//        }

//        for (var i=0 ; i<=10; i++){
//            executor.submit(()->{
//                System.out.println(Thread.currentThread().getName());
//            });
//        }
//        executor.shutdownNow(); // force the existing tasks to close




    }
}
