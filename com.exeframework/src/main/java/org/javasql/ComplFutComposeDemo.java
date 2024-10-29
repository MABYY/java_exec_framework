package org.javasql;

import java.util.concurrent.CompletableFuture;

public class ComplFutComposeDemo {

    public static CompletableFuture<String> getEmailAsync(){
        return CompletableFuture.supplyAsync(()->"email");
    };

    public static CompletableFuture<String> getPlaylistAsync(String email){
        return CompletableFuture.supplyAsync(()->"playlist");
    };

    public static void show() {
        getEmailAsync().thenCompose(ComplFutComposeDemo::getPlaylistAsync)
                .thenAccept(System.out::println);

    };
};
