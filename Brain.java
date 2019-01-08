import java.util.*;

public class Brain {

    private Neuron[] _neurons;
    private Random _rand;
    private int[] _potList;

    public Brain(Random rand) {
        _neurons = new Neuron[NUM_NEUR];
        _rand = rand;
        // First we intitate all the neurons
        for (int i = 0; i < NUM_NEUR; i++) {
            _neurons[i] = new Neuron();
        }
        // Next we randomly assign connections
        for (int i = 0; i < NUM_NEUR; i++) {
            for (int k = 0; k < C.INI_CONS; k++) {
                _neurons[i].addConnection(_neurons[_rand.nextInt(NUM_NEUR)]);
            }
        }
    }

    public void stimulateNeur(int neurIndex) {
        _neurons[neurIndex].release(_potList);
    }

    public void update() {

    }

    public double readNeur(int neurIndex) {
        return _neurons[neurIndex].getPol();
    }

    /*
     * void copyAndMutate(Brain parentBrain) { for (int i = 0; i <
     * parentBrain._neurons.length; i++) { Neuron[] cons =
     * parentBrain._neurons[i].getCons(); for (int k = 0; k < cons.length; k++) { if
     * (_rand.nextDouble() < C.MUTATION_CHANCE) { cons[k] =
     * _neurons[_rand.nextInt(NUM_NEUR)]; } } } }
     */
    public void printNeurs() {
        for (int i = 0; i < _neurons.length; i++) {
            System.out.print("Neuron: " + i);
            _neurons[i].printCons();
            System.out.println();
        }
    }

}