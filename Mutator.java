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
        return randDNA;
    }

    public void mutateClass(Lizard[] lizards) {
        // Top 20 lizards get 9 offspring each
        for (int i = 0; i < 20; i++) {
            for (int k = 0; k < 9; k++) {
                copyAndMutate(lizards[i].getDNA(), lizards[i * 9 + k].getDNA());
                // lizards[i*9+k]
                lizards[i * 9 + k].readDNA();
            }

        }
    }

    void copyAndMutate(int[] parentDNA, int[] childDNA) {
        for (int i = 0; i < parentDNA.length; i++) {
            if (_rand.nextDouble() < C.MUTATION_CHANCE) {
                childDNA[i] = _rand.nextInt(C.NUM_NEUR);
            } else {
                childDNA[i] = parentDNA[i];
            }
        }
    }
}