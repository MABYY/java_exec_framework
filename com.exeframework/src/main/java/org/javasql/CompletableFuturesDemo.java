package org.javasql;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class CompletableFuturesDemo {
    public static void show() {
        var future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Executing task....");
            throw new IllegalStateException();
        });
        try {
            // returns a new completable future if an exception is thrown
           var temp = future.exceptionally(ex ->1).get();
            System.out.println("temp: " + temp);
           // future.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
