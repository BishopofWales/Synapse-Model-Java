import java.util.*;

public class Brain{
    public static final int NUM_NEUR = 1000;
    private Neuron[] _neurons;
    public Brain(Random rand)
    {
        _neurons = new Neuron[NUM_NEUR];
        //First we intitate all the neurons
        for (int i = 0; i < NUM_NEUR; i++)
        {
            _neurons[i] = new Neuron();
        }
        //Next we randomly assign connections
        for (int i = 0; i < NUM_NEUR; i++)
        {
            for (int k = 0; k < C.INI_CONS; k++)
            {
                _neurons[i].addConnection(_neurons[rand.nextInt(NUM_NEUR)]);
            }
        }
    }
    public void stimulateNeur(int neurIndex, long time)
    {
        _neurons[neurIndex].release(time);
    }
    public boolean readNeur(int neurIndex)
    {
        return _neurons[neurIndex].readFired();
    }
}

