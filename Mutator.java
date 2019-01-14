import java.util.*;

public class Mutator {

    private Random _rand;

    public Mutator(Random rand) {
        _rand = rand;
    }

    public int[] randomDNA() {
        int[] randDNA = new int[C.NUM_NEUR * C.CONS];
        for (int i = 0; i < randDNA.length; i++) {
            randDNA[i] = _rand.nextInt(C.NUM_NEUR);
        }
        for (int i = 0; i < randDNA.length; i++) {
            // System.out.println(randDNA[i]);
        }
        return randDNA;
    }

    public void MutateClass(Lizard[] lizards) {
        int count = 1;
        // First 5 get 8 offspring (1 clone 7 siblings)

        // Second 20 get (1 clone 1 sibling)
        // Third 20 get (1 clone)
        // Bottom 55 are discarded
    }
}