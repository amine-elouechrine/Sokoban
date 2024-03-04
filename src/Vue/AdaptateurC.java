package Vue;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import Modele.Jeu;

public class AdaptateurC extends KeyAdapter {
    Jeu j;
    NiveauGraphique niveauGraphique;
    InterfaceGraphique f;


    public AdaptateurC(Jeu jeu,NiveauGraphique n,InterfaceGraphique i){
        j=jeu;
        niveauGraphique=n;
        f=i;
    }

    void deplace(int x,int y ){
        j.deplace(x,y);
        niveauGraphique.repaint();
    }


    @Override
    public void keyPressed(KeyEvent e) {
        int key=e.getKeyCode();
        switch (key){
            case KeyEvent.VK_LEFT :
                deplace(0,-1);
                break;
            case KeyEvent.VK_RIGHT:

                deplace(0,1);
                break;
            case KeyEvent.VK_DOWN:

                deplace(1,0);
                break;
            case KeyEvent.VK_UP:
                deplace(-1,0);
                break;
            case KeyEvent.VK_Q:
            case KeyEvent.VK_A:
                System.exit(0);
                break;
            case KeyEvent.VK_ESCAPE:
                f.toggleFullscreen();
                break;

        }
    }
}
