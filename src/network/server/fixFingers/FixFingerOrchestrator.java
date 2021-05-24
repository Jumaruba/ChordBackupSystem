package network.server.fixFingers;

import network.etc.Singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * This class is responsible for running the FixFingers for an entire cycle and
 * then waits a certain amount of time to execute it again.
 */
public class FixFingerOrchestrator implements Runnable {

    @Override
    public void run() {
        try {
            for (int i = 0; i < Singleton.m; i++) {
                ExecutorService executorService = Executors.newSingleThreadExecutor();
                executorService.submit(new FixFingers());
                executorService.awaitTermination(500, TimeUnit.MILLISECONDS);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}