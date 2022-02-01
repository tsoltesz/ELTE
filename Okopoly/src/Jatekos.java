
import java.awt.Color;

public class Jatekos {
    
    // Adatok 
    private String nev, magyarszin;
    private int pont, penz, kornyezetilabnyom;
    private Color szin;
    
    int fizetes;
    private int mezo;
    
    //Játékmenetét befolyásoló tényezők
    private Boolean lepes;
    
    //Vásárolható dolgok
    private Haz haz;
    private Boolean auto, bicikli;
    private int autobiztositasertek, hitelertek;
    //Energiatakarékos-e
    private Boolean elektromos;
    
    //Ellenörzők
    private Boolean minden=false, max=false;
    
    //Adatokbeállítása
    public final void setNev(String s){this.nev=s;}
    public String getNev(){return this.nev;}
    
    public final void setSzin(String s){this.magyarszin=s;}
    public String getSzinM(){return this.magyarszin;}
    
    public final void setPont(int p){this.pont=p;}
    public int getPont(){return this.pont;}
    public void addPont(int p){this.pont+=p;}
    
    public final void setSzin(Color c){this.szin=c;}
    public Color getSzin(){return this.szin;}
    
    public final void setPenz(int p){this.penz=p;}
    public int getPenz(){return this.penz;}
    public void addPenz(int p){this.penz=this.penz+p;}
    
    public final void setFizetes(int p){this.fizetes=p;}
    public int getFizetes(){return this.fizetes;}
    
    public final void setKornyezetilabnyom(int k){this.kornyezetilabnyom=k;}
    public int getKornyezetilabnyom(){return this.kornyezetilabnyom;}
    
    public final void setMezo(int p){this.mezo=p;}
    public int getMezo(){return this.mezo;}
    
    public final void setLepes(Boolean b){this.lepes=b;}
    public Boolean getLepes(){return this.lepes;}
    
    //Kötelezőek
    public final void setHaz(){this.haz=new Haz();}
    public Haz getHaz(){return this.haz;}
    
    public final void setAuto(Boolean b){this.auto=b;setMinden();}
    public Boolean getAuto(){return this.auto;}
    
    public final void setBicikli(Boolean b){this.bicikli=b;setMinden();}
    public Boolean getBicikli(){return this.bicikli;}
    
    public final void setAutobiztertek(int e){this.autobiztositasertek=e;}
    public int getAutobiztertek(){return this.autobiztositasertek;}
    
    public final void setHitelertek(int e){this.hitelertek=e;}
    public int getHitelertek(){return this.hitelertek;}
    
    // Energiatakarékos dolgok
    public final void setElektromos(Boolean b){this.elektromos=b;}
    public Boolean getElektromos(){return this.elektromos;}
    
    //Ellenörizzük, hogy minden kötelezően megvásárolható elem megvane?
    public void setMinden(){
        if (haz.getTeljes() && getAuto() && getBicikli()){
            this.minden=true;
        }
    }
    public Boolean getMinden(){return this.minden;}
    
    //Ellenörizzük, hogy Mindenből a legtakarékosabb vane meg
    
    
    //Konstruktor
    Jatekos (String nev, int pont, int penz, int k, Color c, String s) {
        setFizetes(500000);
        setNev(nev);
        setPont(pont);
        setPenz(penz);
        setKornyezetilabnyom(k);
        setLepes(true);
        setHaz();
        this.auto=false;
        setElektromos(false);
        setAutobiztertek(0);
        this.bicikli=false;
        setHitelertek(0);
        setSzin(c);
        setSzin(s);
    }
    Jatekos(String t[]){
        this.nev=t[0];
   
        this.penz=Integer.parseInt(t[1]);
     
        this.pont=Integer.parseInt(t[2]);

        this.mezo=Integer.parseInt(t[3]);
     
        this.fizetes=Integer.parseInt(t[4]);
    
        this.kornyezetilabnyom=Integer.parseInt((t[5]));
     
        this.lepes=Boolean.valueOf(t[6]);
        this.haz=new Haz();
        this.haz.setVane(Boolean.valueOf(t[7]));

        this.haz.setNapelem(Boolean.valueOf(t[8]));

        this.haz.setButorok(Boolean.valueOf(t[9]));
    
        this.haz.setMosogato(Boolean.valueOf(t[10]));

        this.haz.setMosogep(Boolean.valueOf(t[11]));
 
        this.haz.setHuto(Boolean.valueOf(t[12]));
       
        this.haz.setMikro(Boolean.valueOf(t[13]));
      
        this.haz.setFurdoszoba(Boolean.valueOf(t[14]));

        this.haz.setFabutor(Boolean.valueOf(t[15]));

        this.haz.setZuhanyzo(Boolean.valueOf(t[16]));
   
        this.haz.setMosogatogep(Boolean.valueOf(t[17]));
      
        this.magyarszin=(t[18]);
        
        this.auto=(Boolean.valueOf(t[19]));
         this.bicikli=(Boolean.valueOf(t[20].trim()));
        
         this.elektromos=(Boolean.valueOf(t[21]));
         
        if (this.magyarszin.equals("Zöld")){
            this.szin=Color.green;
        }
        else if (this.magyarszin.equals("Sárga")){
            this.szin=Color.yellow;
        }
        else if (this.magyarszin.equals("Kék")){
            this.szin=Color.blue;
        }
        else if (this.magyarszin.equals("Piros")){
            this.szin=Color.red;
        }
    }
    
}
