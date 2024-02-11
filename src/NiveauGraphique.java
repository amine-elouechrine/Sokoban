import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class NiveauGraphique extends JComponent {
    int counter;
    Image Pousseur;
    Image But,Caisse,Caisse_sur_but,Mur,Sol;
    Jeu j;

    public NiveauGraphique(Jeu jeu) {

        this.j=jeu;
        try {
            // Chargement de l'image de la même manière que le fichier de niveaux
            InputStream pousseur = new FileInputStream("/home/amine/IdeaProjects/SokobanPousseur.png");
            InputStream but = new FileInputStream("/home/amine/IdeaProjects/SokobanBut.png");
            InputStream caisse = new FileInputStream("/home/amine/IdeaProjects/Sokoban/Caisse.png");
            InputStream caisse_sur_but = new FileInputStream("/home/amine/IdeaProjects/Sokoban/Caisse_sur_but.png");
            InputStream mur = new FileInputStream("/home/amine/IdeaProjects/Sokoban/mur.png");
            InputStream sol = new FileInputStream("/home/amine/IdeaProjects/Sokoban/sol.png");


            // Chargement d'une image utilisable dans Swing
            Pousseur = ImageIO.read(pousseur);
            But = ImageIO.read(but);
            Caisse=ImageIO.read(caisse);
            Caisse_sur_but=ImageIO.read(caisse_sur_but);
            Mur=ImageIO.read(mur);
            Sol=ImageIO.read(sol);

        } catch (FileNotFoundException e) {
            System.err.println("ERREUR : impossible de trouver le fichier du pousseur");
            System.exit(2);
        } catch (IOException e) {
            System.err.println("ERREUR : impossible de charger l'image");
            System.exit(3);
        }
        counter = 1;
    }
    public void tracer(Graphics2D g,int ligne,int colonne,int longeur_case,int hauteur,Image i){

    }

    @Override
    public void paintComponent(Graphics g) {
        //if(!j.prochainNiveau()){
          //  System.out.println("Erreur lors du chargement ...");
           // System.exit(2);
        //}
        Niveau n=j.niveau;
        Graphics2D dessin=(Graphics2D) g;
        int largeur = getSize().width;
        int hauteur =getSize().height;
        int larageur_case=largeur/n.colonnes();
        int hauteur_case=hauteur/n.lignes();


        for (int i=0;i<n.lignes();i++){
            for(int j=0;i<n.colonnes();j++){
                if(n.aBut(i,j)){
                    tracer(dessin,i,j,hauteur_case,larageur_case,But);
                }else{
                    tracer(dessin,i,j,hauteur_case,larageur_case,Sol);
                }
                 if(n.aPousseur(i,j)){
                     tracer(dessin,i,j,hauteur_case,larageur_case,Pousseur);
                }else if(n.aMur(i,j)){
                     tracer(dessin,i,j,hauteur_case,larageur_case,Mur);
                }else if(n.aCaisse(i,j)){

                    if(n.aBut(i,j)){
                        tracer(dessin,i,j,hauteur_case,larageur_case,Caisse_sur_but);
                    }else{
                            //caisse
                        tracer(dessin,i,j,hauteur_case,larageur_case,Caisse);
                    }
                }

            }
        }
    }
}
