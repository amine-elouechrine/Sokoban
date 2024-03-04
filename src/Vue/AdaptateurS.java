package Vue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Modele.*;

public class AdaptateurS extends MouseAdapter {
    Jeu j;
    NiveauGraphique niveauGraphique;

    public AdaptateurS(Jeu jeu,NiveauGraphique n){
        j=jeu;
        niveauGraphique=n;
    }

    @Override
    public void mousePressed(MouseEvent e) {

        int l=e.getX()/niveauGraphique.hauteur_case();
        int h=e.getY()/niveauGraphique.largeur_case();

        //calculer la difference entre le Pousseur et le l'edroit clique

        int diffligne=l-j.ColonneP();
        int diffcolonne=h-j.ligneP();



        int somme=diffcolonne+diffligne;

        if((diffligne*diffcolonne==0) && (somme*somme==1)){
            j.deplace(diffligne,diffcolonne);
            niveauGraphique.repaint();
        }

    }
}
