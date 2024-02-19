import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
        int diffligne=l-j.ligneP();
        int diffcolonne=h-j.ColonneP();

        if(j.niveau.estVide(l,h)){

        }else if(j.niveau.aCaisse(l,h)){

        }
    }
}
