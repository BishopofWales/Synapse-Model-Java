import javax.swing.JPanel;
import java.awt.*;
import java.awt.geom.*;

public class LizViewer extends JPanel {
    private Circle[] _worldGeom;
    private Lizard _lizard;
    private static final int LIZ_RAD = 5;
    private static final double LIZ_LINE_LEN = 8.0;

    public LizViewer(Lizard lizard, Circle[] geom) {
        super();
        _lizard = lizard;
        _worldGeom = geom;
    }

    public void drawLine() {
        System.out.println(this.getGraphics() == null);
        System.out.println(this.getGraphics().getColor());
        this.getGraphics().drawLine(100, 100, 250, 250);
    }

    public void runView() {

        for (int i = 0; i < Grader.TIME_GIVEN; i++) {
            Graphics imageGraphics = this.getGraphics();
            imageGraphics.setColor(Color.WHITE);
            imageGraphics.fillRect(0, 0, this.getHeight(), this.getHeight());
            imageGraphics.setColor(Color.BLUE);
            imageGraphics.drawOval((int) _lizard.getX(), (int) _lizard.getY(), LIZ_RAD * 2, LIZ_RAD * 2);

            imageGraphics.setColor(Color.BLACK);
            imageGraphics.drawLine((int) _lizard.getX(), (int) _lizard.getY(),
                    (int) (_lizard.getX() + Math.cos(_lizard.getAng() * LIZ_LINE_LEN)),
                    (int) (_lizard.getY() + Math.sin(_lizard.getAng() * LIZ_LINE_LEN)));

            imageGraphics.setColor(Color.BLACK);
            imageGraphics.drawOval((int) _worldGeom[0].getX(), (int) _worldGeom[0].getY(),
                    (int) _worldGeom[0].getRadius() * 2, (int) _worldGeom[0].getRadius() * 2);

            _lizard.proccessInput(_worldGeom);
            System.out.println("Lizard x: " + _lizard.getX());
            System.out.println("Lizard y: " + _lizard.getY());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
                System.exit(0);
            }
        }

    }

}