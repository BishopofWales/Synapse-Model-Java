import java.util.*;

public class Lizard implements Comparable<Lizard>{

    public static final double LIN_SPD = 5.0; // m/s public
    public static final double ANG_SPD = Math.PI / 2.0; // rad/s
    public static final int EYE_NEUR = 50;
    public static final int RIGHT_NEUR = 51;
    public static final int LEFT_NEUR = 52;
    public static final int FORWARD_NEUR = 53;

    private Brain _lizBrain;
    private double _xPos;
    private double _yPos;
    private double _rotation;
    private double _score;
    //private Random _rand;
    private int[] _dna;

    public Lizard(double xPos, double yPos, double rotation, int[] dna) {
        _lizBrain = new Brain(dna);
        _xPos = xPos;
        _yPos = yPos;
        _rotation = rotation;
        _dna = dna;
        _lizBrain = new Brain(_dna);
    }

    public void readDNA(){
        _lizBrain.readDNA(_dna);
    }
    void proccessInput(Circle[] worldGeom) {
        // First we check if we see any geometry and stimulate the eye neuron if we do.
        for (Circle circle : worldGeom) {
            if (Raycast.circleRayCol(circle.getRadius(), circle.getX(), circle.getY(), _xPos, _yPos, _rotation)) {
                _lizBrain.releaseNeur(EYE_NEUR);
            }
        }
        // Next we check to see if the muscle neurons have fired and move the creature
        // accordingly.
        if (_lizBrain.readNeur(LEFT_NEUR) > Neuron.ACTION_POT) {
            _rotation -= ANG_SPD;
        }
        if (_lizBrain.readNeur(RIGHT_NEUR) > Neuron.ACTION_POT)

        {
            _rotation += ANG_SPD;
        }
        if (_lizBrain.readNeur(FORWARD_NEUR) > Neuron.ACTION_POT) {
            _xPos += Math.cos(_rotation) * LIN_SPD;
            _yPos += Math.sin(_rotation) * LIN_SPD;
        }
    }
    public double getX() {
        return _xPos;
    }

    public double getY() {
        return _yPos;
    }

    public double getScore() {
        return _score;
    }

    public void setScore(double score) {
        _score = score;
    }
    public int[] getDNA(){
        return _dna;
    }
    public void setDNA(int[] dna){
        _dna = dna;
    }
    @Override
    public int compareTo(Lizard arg0) {
        return this.getScore() > arg0.getScore() ? -1:1;
    }
}
