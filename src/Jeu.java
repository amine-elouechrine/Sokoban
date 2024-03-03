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

    public boolean deplace(int x,int y){
         boolean a=niveau.deplace(x,y);
         if(niveau.estTermine()){
             prochainNiveau();
         }
         return a;
    }

    public int ligneP(){
        return niveau.getPL();
    }

    public int ColonneP(){
        return niveau.getPC();
    }


}
