import java.io.*;
import java.util.*;

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
        for (int i = 0; i < C.CLASS_SIZE; i++) {
            Brain newBrain = new Brain(mut.randomDNA());
        }
    }

}