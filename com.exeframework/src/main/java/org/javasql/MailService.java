package org.javasql;

import java.util.concurrent.CompletableFuture;

// IMPLEMENT ASYNC API

public class MailService {
    public void send() {
        LongTask.simulate(); // Simulate long task
        System.out.println("Mail was sent.");
    }

    public CompletableFuture<Void> sendAsync() {

        return CompletableFuture.runAsync(() -> send());
    }
}
