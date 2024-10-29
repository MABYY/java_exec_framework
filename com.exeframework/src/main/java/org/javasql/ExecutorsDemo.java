package org.javasql;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class ExecutorsDemo {
    public static void show() {

        var executor = Executors.newFixedThreadPool(2);

        try {
            var future = executor.submit(() -> {
                LongTask.simulate(); // simulate an operation that will take 3'
                return 1;
            });

            System.out.println("Do more work");

            try {
                var result = future.get(); // get the result of the operation
                                           // the thread is blocked until the
                                            // result is avalable
                System.out.println(result);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        finally {
            executor.shutdown();
        }

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
