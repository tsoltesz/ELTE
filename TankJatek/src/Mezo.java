public class Mezo {
    
            //Osztály változók
    
    private final int szam; //A mező száma
    private final String tipus; //A mező típusa
    private String szoveg; //A mező szövege
    private final Pont pozicio[];//2 pont koordinátáit tároljuk benne, melyek a bábuk kirajzolásánál segítenek
    private final int allas; //a tankok állása fokban 0 lefeke
    
    protected Jatekos jatekos;
    protected int aktualisjatekos;
    
            //Konstruktor
    
    public Mezo(int szam, String tipus, String szoveg, Pont p1, Pont p2, int allas){
        this.szam=szam;
        this.tipus=tipus;
        this.szoveg=szoveg;
        this.pozicio=new Pont[2];
        pozicio[0]=p1;
        pozicio[1]=p2;
        this.allas=allas;
    }
    public Mezo(int allas){
        this.szam=0;
        this.tipus="0";
        this.szoveg="0";
        this.pozicio=new Pont[2];
        pozicio[0]=new Pont(0,0);
        pozicio[1]=new Pont(0,0);
        this.allas=allas;
        this.aktualisjatekos=-1;
        jatekos=null;
    }
    
            //Getterek
    
    public int getSzam(){
        return this.szam;
    }
    public String getTipus(){
        return this.tipus;
    }
    public String getSzoveg(){
        return this.szoveg;
    }
    //Első játékos lehetséges helyzete a táblán ha erre a mezőre lép
    public int getElsoPontX(){
        return pozicio[0].getX();
    }
    public int getElsoPontY(){
        return pozicio[0].getY();
    }
    //Második játékos lehetséges helyzete a táblán ha erre a mezőre lép
    public int getMasodikPontX(){
        return pozicio[1].getX();
    }
    public int getMasodikPontY(){
        return pozicio[1].getY();
    }
    public int getAllas(){
        return this.allas;
    }
    
    public Jatekos getJatekos(){
        return jatekos;
    }
    
    public void setSzoveg(String s){
        this.szoveg=s;
    }
    
            //Adott Mezőhöz tarozó feladat, mely minden típusnál mást "művel"
    public void Feladat(Jatekos jatekos, int aktualisjatekos, Jatekos j) throws CloneNotSupportedException{
        this.jatekos=(Jatekos)jatekos.clone();
        this.jatekos.setHarcol(false);
        this.aktualisjatekos=aktualisjatekos;
    }
}
