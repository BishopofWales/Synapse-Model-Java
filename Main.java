import java.io.*;
import java.util.*;

import javax.swing.JFrame;

public class Main {
    public static final int EVO_RUNS = 10;

    public static void main(String[] args) {
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
        JFrame frame = new JFrame();

        frame.setSize(1000, 700);

        frame.setVisible(true);

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

            LizViewer panel = new LizViewer(lizards[index], worldGeom);
            frame.add(panel);
            panel.drawLine();
            panel.runView();

            System.out.println("(R)un another lizard or (q)uit?");
            String runAgain = kbd.next();

            if (runAgain.charAt(0) == 'q') {
                System.exit(0);
            }
            // Perform clean up
            frame.remove(panel);
        }

    }

}