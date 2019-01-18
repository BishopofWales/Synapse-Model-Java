import java.io.*;
import java.util.*;

import javax.swing.JFrame;


public class Main {
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
        for (int i = 0; i < C.CLASS_SIZE; i++) {
            lizards[i] =  new Lizard(0,0,0,mut.randomDNA());
        }
        
        Grader grader = new Grader(rand);
        Mutator mutator = new Mutator(rand);

        
        /*
        for(int i = 0; i < 100; i++){
            grader.gradeLizards(lizards);
            mutator.mutateClass(lizards);
            for(int k = 0; k < lizards.length; k++){
                System.out.println(k + " " + lizards[k].getScore());
            }
            System.out.println("________________________________________");
           
        }
        */
        JFrame frame = new JFrame();
        
        frame.setSize(1000, 700);
        Circle[] worldGeom = new Circle[1];
        LizViewer panel = new LizViewer(lizards[0], worldGeom);
        frame.add(panel);

        frame.setVisible(true);

        panel.drawLine();

        //Graphics2D g2 = (Graphics2D) panel.getGraphics();
        ///System.out.println(lin==null);
        // System.out.println(g2==null);

       
        
        System.out.println("here!");
        
    }   

  


}