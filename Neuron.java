import java.util.*;

public class Neuron {

    public static final double PULSE_POWER = 10.0;
    public static final double ACTION_POT = 33.0;
    public static final double FALL_OFF = 1.0;

    private double _polarL;
    private long _lastStimmed;
    private Neuron[] _cons;
    private Queue<Neuron> _relQueue;
    boolean _addedtoRel;

    public Neuron(Queue<Neuron> relQueue) {
        _polarL = 0;
        _lastStimmed = 0;
        _cons = new Neuron[C.CONS];
        _relQueue = relQueue;
        _addedtoRel = false;
    }

    public void stimulate(long time) {
        // System.out.println("Stimmed " + this);
        // First we calculate the falloff since the last time the neuron was touched.
        _polarL = Math.max(0.0, _polarL - (time - _lastStimmed) * FALL_OFF);
        // Next we add the pulse to the neuron
        _polarL += PULSE_POWER;
        if (_polarL > ACTION_POT && !_addedtoRel) {
            // System.out.println("added to rel list " + this);
            _relQueue.add(this);
            _addedtoRel = true;
        }
        _lastStimmed = time;
    }

    public double getPol() {
        return _polarL;
    }

    public void release(long time) {
        _addedtoRel = false;
        // System.out.println("released " + this);
        for (int i = 0; i < _cons.length; i++) {
            // Stimulate neurons here.
            _cons[i].stimulate(time);
        }
        _polarL = 0.0;
    }

    public Neuron[] getCons() {
        return Arrays.copyOf(_cons, _cons.length);
    }

    public void setCons(Neuron[] cons) {
        _cons = cons;
    }

    public void printCons() {
        for (Neuron neuron : _cons) {
            System.out.print(neuron);
        }
    }

    public void reset() {
        _polarL = 0;
    }

}