public class Jeu {
    int num_niveau;
    Niveau niveau;
    LecteurNiveaux lecteurNiveaux;
    public Jeu(LecteurNiveaux lect){
        lecteurNiveaux=lect;
    }
    Niveau niveau(){
        return niveau;
    }
    public boolean prochainNiveau(){
        niveau=lecteurNiveaux.lisProchainNiveau();
        return niveau!=null;
    }


}
