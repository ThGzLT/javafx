package learn1java;

import javafx.concurrent.Task;

import java.lang.reflect.Array;
import java.util.Arrays;

public class IteratingTask extends Task<Integer> {
    private final int totalIterations;

    public IteratingTask(int totalIterations) {
        this.totalIterations = totalIterations;
    }

    @Override
    protected Integer call() throws Exception {
        int iterations = 0;
        for (iterations = 0; iterations < totalIterations; iterations++) {
            if (isCancelled()) {
                updateMessage("Cancelled");
                break;
            }
            updateMessage("Iteration " + iterations);
            updateProgress(iterations, totalIterations);
        }
        return iterations;
    }


    public static void main(String[] args) throws Exception {
        IteratingTask task = new IteratingTask(8000000);

    }


}


