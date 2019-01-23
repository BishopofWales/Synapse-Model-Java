import java.util.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Grader {

    public static final int TIME_GIVEN = 100;
    private static final double MIN_DIST_SQ = 11.0 * 11.0;
    public static final double DIST_TO_GOAL = 300.0;
    public static final double CIRCLE_SIZE = 50.0;
    private Random _rand;

    public void gradeLizards(Lizard[] lizards) {

        for (Lizard lizard : lizards) {
            testLizard(lizard);
            lizard.resetLizard();
        }
        Arrays.sort(lizards);
    }

    public Grader(Random rand) {
        _rand = rand;
    }

    // Assigns a grade to a lizard, based on performance of the task.
    private void testLizard(Lizard lizard) {
        System.out.println("Testing lizard:" + lizard);
        Circle[] worldGeom = new Circle[1];
        double randAng = 0;// _rand.nextDouble() % Math.PI;
        worldGeom[0] = new Circle(CIRCLE_SIZE, Math.cos(randAng) * DIST_TO_GOAL, Math.sin(randAng) * DIST_TO_GOAL);
        /*
         * System.out.println("Food angle:" + randAng); System.out.println("Food X: " +
         * worldGeom[0].getX()); System.out.println("Food Y: " + worldGeom[0].getY());
         * System.out.println( "Dist before: " + Raycast.dist(lizard.getX(),
         * lizard.getY(), worldGeom[0].getX(), worldGeom[0].getY()));
         */

        for (int i = 0; i < TIME_GIVEN; i++) {
            lizard.proccessInput(worldGeom);
            if (Raycast.distSq(lizard.getX(), lizard.getY(), worldGeom[0].getX(), worldGeom[0].getY()) < MIN_DIST_SQ) {
                System.out.println("Dist to goal: "
                        + Raycast.dist(lizard.getX(), lizard.getY(), worldGeom[0].getX(), worldGeom[0].getY()));
                lizard.setScore(TIME_GIVEN - i);
                return;
            }
        }
        lizard.setScore(-1 * Raycast.dist(lizard.getX(), lizard.getY(), worldGeom[0].getX(), worldGeom[0].getY()));
        // System.out.println(
        // "Dist after: " + Raycast.dist(lizard.getX(), lizard.getY(),
        // worldGeom[0].getX(), worldGeom[0].getY()));
        // System.out.println("_________________");
    }

}