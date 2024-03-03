
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EcouteurDeSouris extends MouseAdapter {
    AireDeDessin aire;

    EcouteurDeSouris(AireDeDessin a) {
        aire = a;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        aire.fixePosition(e.getX(), e.getY());
        aire.repaint();
    }
}

