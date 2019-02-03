import java.io.*;
import java.util.*;
import javafx.application.*;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;

public class Main extends Application {

    public static final int EVO_RUNS = 10;

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("A good title.");
        Group root = new Group();
        LizViewer lizViewer = new LizViewer(500, 250);
        root.getChildren().add(lizViewer);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        Random rand = new Random();
        Mutator mut = new Mutator(rand);
        Lizard[] lizards = new Lizard[C.CLASS_SIZE];

        Scanner kbd = new Scanner(System.in);

        for (int i = 0; i < C.CLASS_SIZE; i++) {
            lizards[i] = new Lizard(0, 0, 0, mut.randomDNA());
        }

        Grader grader = new Grader(rand);
        Mutator mutator = new Mutator(rand);

        for (int i = 0; i < EVO_RUNS; i++) {
            grader.gradeLizards(lizards);
            mutator.mutateClass(lizards);
            for (int k = 0; k < lizards.length; k++) {
                System.out.println(k + " " + lizards[k].getScore());
            }
            System.out.println("________________________________________" + i);

        }

        while (true) {
            System.out.println("Which lizard would you like to see?");
            int index = kbd.nextInt();

            System.out.println("What angle of food would you like?");
            double angle = kbd.nextDouble();
            double angleRad = angle * Math.PI / 180;
            // Run the lizard viewer
            Circle[] worldGeom = new Circle[1];
            worldGeom[0] = new Circle(Grader.CIRCLE_SIZE, Grader.DIST_TO_GOAL * Math.cos(angleRad),
                    Grader.DIST_TO_GOAL * Math.sin(angleRad));
            lizViewer.runView(lizards[index], worldGeom);
            System.out.println("(R)un another lizard or (q)uit?");
            String runAgain = kbd.next();

            if (runAgain.charAt(0) == 'q') {
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
        /*
         * int[] sampleDNA = { 1, 1, 1, 2, 2, 0, 0, 0, 0 }; Brain brain = new
         * Brain(sampleDNA); brain.releaseNeur(1); brain.update();
         * System.out.println("Neuron 1: " + brain.readNeur(0));
         * System.out.println("Neuron 2: " + brain.readNeur(1));
         * System.out.println("Neuron 3: " + brain.readNeur(2));
         * 
         * brain.releaseNeur(1); System.out.println("Update!"); brain.update();
         * 
         * System.out.println("Neuron 1: " + brain.readNeur(0));
         * System.out.println("Neuron 2: " + brain.readNeur(1));
         * System.out.println("Neuron 3: " + brain.readNeur(2));
         * 
         * brain.releaseNeur(1); System.out.println("Update!"); brain.update();
         * 
         * System.out.println("Neuron 1: " + brain.readNeur(0));
         * System.out.println("Neuron 2: " + brain.readNeur(1));
         * System.out.println("Neuron 3: " + brain.readNeur(2));
         * 
         * brain.releaseNeur(1); System.out.println("Update!"); // 4 releases...
         * brain.update();
         * 
         * System.out.println("Neuron 1: " + brain.readNeur(0));
         * System.out.println("Neuron 2: " + brain.readNeur(1));
         * System.out.println("Neuron 3: " + brain.readNeur(2));
         */

    }

}