import java.util.*;

public class Neuron {

    public static final double PULSE_POWER = 10.0;
    public static final double ACTION_POT = 25.0;
    public static final double FALL_OFF = 1.0;

    private double _polarL;
    private int _numCons;
    private long _lastStimmed;
    private boolean _hasFired;
    private Neuron[] _cons;

    public Neuron() {
        _polarL = 0;
        _lastStimmed = 0;
        _numCons = 0;
        _hasFired = false;
        _cons = new Neuron[C.MAX_CONS];
    }

    public void stimulate(long time) {
        // First we calculate the falloff since the last time the neuron was touched.
        _polarL = Math.max(0.0, (time - _lastStimmed) * FALL_OFF);
        // Next we add the pulse to the neuron
        _polarL += PULSE_POWER;
        if (_polarL > ACTION_POT) {
            release(time);
        }
    }

    public boolean readFired() {
        if (_hasFired) {
            _hasFired = false;
            return true;
        }
        return false;
    }

    public double getPol() {
        return _polarL;
    }

    public void release(long time) {

        for (int i = 0; i < _numCons; i++) {
            // Stimulate neurons here.
            _cons[i].stimulate(time);
        }
        // Stim reset goes after, in order to prevent cyclical stimulation
        _polarL = 0;
        _hasFired = true;
    }

    public boolean addConnection(Neuron newCon) {
        // cout << "_numcons:" << _numCons << " " << this << "\n";
        _cons[_numCons] = newCon;
        _numCons++;
        return true;
    }

    public Neuron[] getCons() {
        return Arrays.copyOf(_cons, _cons.length);
    }
}
