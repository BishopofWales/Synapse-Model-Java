import java.util.*;

public class Lizard {
    public static final double LIN_SPD = 5.0; // m/s
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
    private Random _rand;

    public Lizard(double xPos, double yPos, double rotation, Random rand) {
        _lizBrain = new Brain(rand);
        _xPos = xPos;
        _yPos = yPos;
        _rotation = rotation;
        _rand = rand;
    }

    void proccessInput(Circle[] worldGeom, long time) {
        // First we check if we see any geometry and stimulate the eye neuron if we do.
        for (Circle circle : worldGeom) {
            if (Raycast.circleRayCol(circle.getRadius(), circle.getX(), circle.getY(), _xPos, _yPos, _rotation)) {
                _lizBrain.stimulateNeur(EYE_NEUR, time);
            }
        }
        // Next we check to see if the muscle neurons have fired and move the creature
        // accordingly.
        if (_lizBrain.readNeur(LEFT_NEUR)) {
            _rotation -= ANG_SPD;
        }
        if (_lizBrain.readNeur(RIGHT_NEUR)) {
            _rotation += ANG_SPD;
        }
        if (_lizBrain.readNeur(FORWARD_NEUR)) {
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

    public void becomeChildOf(Lizard parent) {
        _lizBrain.copyAndMutate(parent._lizBrain);
        /*
         * for (int i = 0; i < parent._lizBrain.getSize(); i++) { Neuron[] cons =
         * parent._lizBrain.getConsAt(i); for (int k = 0; k < neurons.length; k++) { if
         * (_rand.nextDouble() < C.MUTATION_CHANCE) { cons[i] = } } }
         */
    }

}
