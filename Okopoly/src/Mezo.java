public class Mezo {
    
    private int penz;         // A mező által szerzett/levont pénz értéke
    private String nev;       // A mező neve
    private String szoveg;    // A mező leírása
    private int szam;         // A mező száma
    private int esemenyszam; // Ez a szám segít a hivatkozásban esemény keresésnél
    private Pont[]helyek;
    private Boolean[]foglalt;
    
    //Beállító és Lekérő fv-k
    public final void setPenz(int p){this.penz=p;}
    public int getPenz(){return this.penz;}
    
    public final void setNev(String s){this.nev=s;}
    public String getNev(){return this.nev;}
    
    public final void setSzoveg(String s){this.szoveg=s;}
    public String getSzoveg(){return this.szoveg;}
    
    public final void setSzam(int sz){this.szam=sz;}
    public int getSzam(){return this.szam;}
    
    public final void setEsemenyszam(int sz){this.esemenyszam=sz;}
    public int getEsemenyszam(){return this.esemenyszam;}
    
    public final void setHelyek(Pont t[]){helyek=t; foglalt=new Boolean [4]; for(int i=0;i<foglalt.length;i++){foglalt[i]=false;} /*for (int i=0;i<helyek.length;i++){System.out.println(helyek[i].getX()+" y: "+helyek[i].getY());}*/}
    public Pont[] getHelyek(){return helyek;}
    
    public void setFoglal(int i,Boolean f){foglalt[i]=f;}
    public Boolean getFoglal(int i){return foglalt[i];}
    
    
    public Mezo (int penz, String nev, String szoveg, int szam, int esemenyszam, Pont t[]) {
        setPenz(penz);
        setNev(nev);
        setSzoveg(szoveg);
        setSzam(szam);
        setEsemenyszam(esemenyszam);
        setHelyek(t);
        
    }
    
}
