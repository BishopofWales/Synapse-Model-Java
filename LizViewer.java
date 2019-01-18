import javax.swing.JPanel;
import java.awt.*;
import java.awt.geom.*;

public class LizViewer extends JPanel{
    private Circle[] _worldGeom;
    private Lizard _lizard;
    public LizViewer(Lizard lizard, Circle[] geom){
        super();
        _lizard = lizard;
        _worldGeom = geom; 
        //System.out.println(panel==null);
        //S
    }
    public void drawLine(){
        System.out.println(this.getGraphics()==null);
        System.out.println(this.getGraphics().getColor());
        this.getGraphics().drawLine(100, 100, 250, 250);
    }
    public void runView(){
        
    }

}