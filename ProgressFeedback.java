package learn1java;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import static learn1java.PrimeFactors.PR;

public class ProgressFeedback extends Application {
    private static final double EPSILON = 0.1;
   //private static final double EPSILON = 0.0000005;
    @Override
    public void start(Stage stage) throws Exception {
        Task<Integer> task = new Task<Integer>() {
            @Override protected Integer call() throws Exception {
                int iterations;
                for (iterations = 0; iterations < 10000000; iterations++) {
                    if (isCancelled()) {
                        updateMessage("Cancelled");
                        break;
                    }
                    updateMessage("Iteration " + iterations);
                    updateProgress(iterations, 10000000);
                }
                return iterations;
            }
        };





        final ProgressBar progress = new ProgressBar();
        progress.progressProperty().bind(
                task.progressProperty()
        );
        // color the bar green when the work is complete.
        progress.progressProperty().addListener(observable -> {
            if (progress.getProgress() >= 1 - EPSILON) {
                progress.setStyle("-fx-accent: forestgreen;");
            }
        });

        // layout the app
        final StackPane layout = new StackPane(progress);
        layout.setPadding(new Insets(10));
        stage.setScene(new Scene(layout));
        stage.show();

        final Thread thread = new Thread(task, "task-thread");
        thread.setDaemon(true);
        thread.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
