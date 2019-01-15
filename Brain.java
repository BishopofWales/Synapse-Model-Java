import java.util.*;

public class Brain {

    private Neuron[] _neurons;
    private Queue<Neuron> _stimList;
    private long _time;

    public Brain(int[] dna) {
        _neurons = new Neuron[C.NUM_NEUR];
        _stimList = new ArrayDeque<Neuron>();
        for (int i = 0; i < C.NUM_NEUR; i++) {
            _neurons[i] = new Neuron(_stimList);
            // System.out.println(i + " " + _neurons[i]);
        }
        // Interpret dna into neuron connections.
        readDNA(dna);
        _time = 0;
    }

    public void readDNA(int[] dna){
        for (int i = 0; i < C.NUM_NEUR; i++) {
            Neuron[] cons = new Neuron[C.CONS];
            for (int k = 0; k < C.CONS; k++) {
                cons[k] = _neurons[dna[i * C.CONS + k]];
            }
            _neurons[i].setCons(cons);
        }
    }

    public void releaseNeur(int neurIndex) {
        _neurons[neurIndex].release(_time);
    }

    public void update() {
        // Takes all the neurons that went over their action potential the last run and
        // makes them fire.
        // Any neurons addded this cycle will fire in the next.
        int size = _stimList.size();
        for (int i = 0; i < size; i++) {
            Neuron neuron = _stimList.poll();
            neuron.release(_time);
        }
        _time++;
    }

    public double readNeur(int neurIndex) {
        return _neurons[neurIndex].getPol();
    }

    public void printNeurs() {
        for (int i = 0; i < _neurons.length; i++) {
            System.out.print("Neuron: " + i);
            _neurons[i].printCons();
            System.out.println();
        }
    }

}