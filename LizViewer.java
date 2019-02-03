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
    private static final int LIZ_RAD = 5;
    private static final double LIZ_LINE_LEN = 8.0;
    private double x = 0.0;
    /*
    public LizViewer(Lizard lizard, Circle[] geom) {
        super();
        lizard = lizard;
        worldGeom = geom;
    }
    */

    public LizViewer(double width, double height) {
        super(width, height);
        System.out.println("intialized");

    }

    public void runView(Lizard lizard, Circle[] worldGeom) {
        System.out.println("started view");
        GraphicsContext imageGraphics = this.getGraphicsContext2D();
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                doHandle();
            }

            private void doHandle() {
                imageGraphics.setFill(Color.WHITE);
                //imageGraphics.fillRect(0, 0, this.getHeight(), this.getHeight());
                imageGraphics.setFill(Color.BLUE);
                imageGraphics.fillOval((int) lizard.getX(), (int) lizard.getY(), LIZ_RAD * 2, LIZ_RAD * 2);

                imageGraphics.setStroke(Color.BLACK);
                imageGraphics.strokeLine((int) lizard.getX(), (int) lizard.getY(),
                        (int) (lizard.getX() + Math.cos(lizard.getAng() * LIZ_LINE_LEN)),
                        (int) (lizard.getY() + Math.sin(lizard.getAng() * LIZ_LINE_LEN)));

                imageGraphics.setFill(Color.BLACK);
                imageGraphics.fillOval((int) worldGeom[0].getX(), (int) worldGeom[0].getY(),
                        (int) worldGeom[0].getRadius() * 2, (int) worldGeom[0].getRadius() * 2);

                lizard.proccessInput(worldGeom);
                System.out.println("Lizard x: " + lizard.getX());
                System.out.println("Lizard y: " + lizard.getY());
            }
        }.start();
    }

    public void test() {

        GraphicsContext imageGraphics = this.getGraphicsContext2D();
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                doHandle();
            }

            private void doHandle() {
                x += 1.0;
                imageGraphics.setFill(Color.RED);
                imageGraphics.fillOval(0, 0, 10, 0 + x);
            }
        }.start();
    }

}