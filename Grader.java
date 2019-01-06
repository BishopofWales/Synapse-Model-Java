import java.util.*;

public class Grader {
    private static final int TIME_GIVEN = 100;
    private static final double MIN_DIST_SQ = 11 * 11;
    private static final double DIST_TO_GOAL = 30;
    private Random _rand;

    public void gradeLizards(Lizard[] lizards) {
        for (Lizard lizard : lizards) {
            testLizard(lizard);
        }
        Arrays.sort(lizards);
    }

    public Grader(Random rand) {
        _rand = rand;
    }

    // Assigns a grade to a lizard, based on performance of the task.
    private void testLizard(Lizard lizard) {
        Circle[] worldGeom = new Circle[1];
        double randAng = _rand.nextDouble() % Math.PI;
        worldGeom[0] = new Circle(Math.cos(randAng), Math.sin(randAng), 5);
        for (int i = 0; i < TIME_GIVEN; i++) {
            lizard.proccessInput(worldGeom, i);
            if (Raycast.distSq(lizard.getX(), lizard.getY(), worldGeom[0].getX(), worldGeom[0].getY()) > MIN_DIST_SQ) {
                lizard.setScore(TIME_GIVEN - i);
                return;
            }
        }
        lizard.setScore(Raycast.dist(lizard.getX(), lizard.getY(), worldGeom[0].getX(), worldGeom[0].getY()));
    }
}