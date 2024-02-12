import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;


public class InterfaceGraphique implements Runnable {
    Jeu j;
    public InterfaceGraphique(Jeu jeu){
        this.j=jeu;
    }

    static void launcher(Jeu j){
        SwingUtilities.invokeLater(new InterfaceGraphique(j));
    }
    public void run() {
        JFrame frame = new JFrame("Ma fenetre a moi");
        // Ajout de notre composant de dessin dans la fenetre
        frame.add(new NiveauGraphique(j));

        // Un clic sur le bouton de fermeture clos l'application
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // On fixe la taille et on demarre
        frame.setSize(500, 300);
        frame.setVisible(true);
    }


}
