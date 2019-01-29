import java.awt.geom.Point2D;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.Scene;
import javafx.scene.canvas.*;
import javafx.scene.shape.*;
import javafx.scene.Group;
import javafx.scene.paint.Color;

public class LizViewer extends Canvas {
    private Circle[] _worldGeom;
    private Lizard _lizard;
    private static final int LIZ_RAD = 5;
    private static final double LIZ_LINE_LEN = 8.0;

    public LizViewer(Lizard lizard, Circle[] geom) {
        super();
        _lizard = lizard;
        _worldGeom = geom;
    }

    public void runView() {

        for (int i = 0; i < 10/* Grader.TIME_GIVEN */; i++) {
            GraphicsContext imageGraphics = this.getGraphicsContext2D();
            imageGraphics.setFill(Color.WHITE);
            imageGraphics.fillRect(0, 0, this.getHeight(), this.getHeight());
            imageGraphics.setFill(Color.BLUE);
            imageGraphics.fillOval((int) _lizard.getX(), (int) _lizard.getY(), LIZ_RAD * 2, LIZ_RAD * 2);

            imageGraphics.setStroke(Color.BLACK);
            imageGraphics.strokeLine((int) _lizard.getX(), (int) _lizard.getY(),
                    (int) (_lizard.getX() + Math.cos(_lizard.getAng() * LIZ_LINE_LEN)),
                    (int) (_lizard.getY() + Math.sin(_lizard.getAng() * LIZ_LINE_LEN)));

            imageGraphics.setFill(Color.BLACK);
            imageGraphics.fillOval((int) _worldGeom[0].getX(), (int) _worldGeom[0].getY(),
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