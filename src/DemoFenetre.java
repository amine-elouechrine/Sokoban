
import javax.swing.*;

// L'interface runnable déclare une méthode run
public class DemoFenetre implements Runnable {
    public void run() {
        // Creation d'une fenetre
        JFrame frame = new JFrame("Ma fenetre a moi");

        // Ajout de notre composant de dessin dans la fenetre
        AireDeDessin aire = new AireDeDessin();
        frame.add(aire);

        // Ecoute des évènements liés à la souris dans l'AireDeDessin
        aire.addMouseListener(new EcouteurDeSouris(aire));

        // Un clic sur le bouton de fermeture clos l'application
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // On fixe la taille et on demarre
        frame.setSize(500, 300);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Swing s'exécute dans un thread séparé. En aucun cas il ne faut accéder directement
        // aux composants graphiques depuis le thread principal. Swing fournit la méthode
        // invokeLater pour demander au thread de Swing d'exécuter la méthode run d'un Runnable.
        SwingUtilities.invokeLater(new DemoFenetre());
    }
}


