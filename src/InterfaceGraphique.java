import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;


public class    InterfaceGraphique implements Runnable {
    Jeu j;
    private boolean maximized = false; // Déclaration de la variable fullscreen
    JFrame frame;

    public InterfaceGraphique(Jeu jeu){
        this.j=jeu;
    }
    public void toggleFullscreen() {
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = env.getDefaultScreenDevice();
        if (maximized) {
            device.setFullScreenWindow(null);
            maximized = false;
        } else {
            device.setFullScreenWindow(frame);
            maximized = true;
        }
    }
    static void launcher(Jeu j){

        SwingUtilities.invokeLater(new InterfaceGraphique(j));
    }
    public void run() {
        frame = new JFrame("Ma fenetre a moi");
        // Ajout de notre composant de dessin dans la fenetre
        NiveauGraphique niveauGraphique=new NiveauGraphique(j);
        //niveauGraphique.addMouseListener(new AdaptateurS(j,niveauGraphique));
        frame.addKeyListener(new AdaptateurC(j,niveauGraphique,this));
        frame.add(niveauGraphique);
        toggleFullscreen();


        // Un clic sur le bouton de fermeture clos l'application
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // On fixe la taille et on demarre
        frame.setSize(1500, 1000);
        frame.setVisible(true);

    }


}
