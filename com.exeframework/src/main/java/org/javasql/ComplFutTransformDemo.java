package org.javasql;

import java.util.concurrent.CompletableFuture;

public class ComplFutTransformDemo {
    public static int toFar(int cel) {
        var result = (cel * 1.8) + 32;
        return (int) result;
    };
    public static void show() {


        // Map or transform into a different type
        var future = CompletableFuture.supplyAsync(()-> 20);
        future
                .thenApply(ComplFutTransformDemo::toFar)
                .thenAccept(System.out::println);


//        try {
//            var result = future.thenApply(cel -> (cel * 1.8) + 32 ).get();
//            System.out.println(result);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } catch (ExecutionException e) {
//            throw new RuntimeException(e);
//        }

    };
}
