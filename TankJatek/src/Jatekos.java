
import java.net.URL;

public class Jatekos implements Cloneable{
            
            //Példány változók
    
    private final String nev; //A játékos neve, ha a felhasználó nem adja meg, akkor automatikusan a kiválasztott karakter neve
    private int elet; //A játkos életerejének darab száma. Alapból és maximum 5
    private int pajzs; //Alapból és maximum 5
    private int fegyver; //Alapból és maximum 5
    private int modosito;
    private int helyzet; //A játékos helye a táblán
    private int hanykorbol; //Hány körből marad ki az adott játékos
    private final URL karakter;  // kép
    private Boolean harcole;
    private Boolean kikerul;
  
    
    
            //Konstruktorok
    
    public Jatekos(String nev, URL kep, int modosito, int hely) {    //Használata akkor ha ÚJ játékot kezdünk
        this.nev=nev;
        this.elet=3;
        this.pajzs=5;
        this.fegyver=5;
        this.helyzet=hely;
        this.hanykorbol=0;
        this.karakter=kep;
        this.modosito=modosito;
        this.harcole=false;
        this.kikerul=false;
    }
    
    public Jatekos(String nev, int elet, int pajzs, int fegyver, int helyzet, int hanykorbol, URL kep, int modosito, Boolean h, Boolean k){   //Használata akkor ha mentet játékot nyitunk
        this.nev=nev;
        this.elet=elet;
        this.pajzs=pajzs;
        this.fegyver=fegyver;
        this.helyzet=helyzet;
        this.hanykorbol=hanykorbol;
        this.karakter=kep;
        this.modosito=modosito;
        this.harcole=h;
        this.kikerul=k;
    }
    
    public Jatekos(String nev, int pajzs, int fegyver, URL kep, int modosito){ //Használata akkor, mikor egy játékos a gép ellen csatázik
        this.nev=nev;
        this.pajzs=pajzs;
        this.fegyver=fegyver;
        this.karakter=kep;
        this.modosito=modosito;
    }
    
            //Setterek
  
    //Használata ha a játékosnak ki kell maradnia utána egy/pár körből
    public void setKimarad(int mennyi){ 
        this.hanykorbol=mennyi;
    }
    
    //Akkor használjuk amikor a játékos lép
    public void setHelyzet(int hely){
        this.helyzet=hely;
    }
    
    //Használata ha a játékos ÉLET toltő mezőre lép 
    public void setToltElet(){
        if (this.elet<3){
            this.elet++;
        }
    }
    //Használata ha a játékos PAJZS toltő mezőre lép
    public void setToltPajzs(){
        if (this.pajzs<5){
            this.pajzs++;
        }
    }
    //Használata ha a játékos FEGYVER toltő mezőre lép
    public void setToltFegyver(){
        if (this.fegyver<5){
            this.fegyver++;
        }
    }
    
    //Használata ha a játékos veszít a csatában VÉDEKEZŐKÉNT és nincs több pajzsa
    public void setVeszitElet(){
        this.elet--;
        
    }
    //Használata ha a játékos veszít a csatában VÉDEKEZŐKÉNT
    public void setVeszitPajzs(){
        this.pajzs--;
    }
    //Használata ha a játékos veszít a csatában TÁMADÓKÉNT
    public void setVeszitFegyver(){
        this.fegyver--;    
    }
    
    
    //Ha a játékos "meghal" a startmezőre képéskor kell használni
    public void setToltMinden(){ 
        this.elet=3;
        this.pajzs=5;
        this.fegyver=5;
    }
    
    public void setHarcol(Boolean h){
        this.harcole=h;
    }
    
    public void setKikerul(Boolean h){
        this.kikerul=h;
    }
            //Getterek 
    
    public String getNev(){
        return this.nev;
    }
    public int getElet(){
        return this.elet;
    }
    public int getPajzs(){
        return this.pajzs;
    }
    public int getFegyver(){
        return this.fegyver;
    }
    public int getHelyzet(){
        return this.helyzet;
    }
    public int getHanykorbol(){
        return this.hanykorbol;
    }
    public URL getKarakter(){
        return this.karakter;
    }
    public int getModosito(){
        return this.modosito;
    }
    public Boolean getHarcol(){
        return this.harcole;
    }
    public Boolean getKikerul(){
        return this.kikerul;
    }
    

    //Dobhat-e az adott játékos
    public boolean getDobhate(){    
        if (this.hanykorbol==0){
            return true;
        }
        else {
            this.hanykorbol--;
            return false;
            
        }
    }
    
     protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

