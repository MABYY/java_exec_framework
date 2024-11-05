package org.javasql;

public class LongTask {
    public static void simulate() {
        try {
            Thread.sleep(1000); // put the current thread to sleep
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void simulate(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
