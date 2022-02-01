public class Mezok {
    AkadalyMezo a;
    ElkuldoMezo e;
    LeptetoMezo l;
    Mezo m;
    ToltoMezo t;
    HarcMezo h;
    
    public Mezok(AkadalyMezo a){
        this.a=a;
        this.e=null;
        this.l=null;
        this.m=null;
        this.t=null;
        this.h=null;

    }
    
    public Mezok(ElkuldoMezo a){
        this.a=null;
        this.e=a;
        this.l=null;
        this.m=null;
        this.t=null;
        this.h=null;
     
    }
    
    public Mezok(LeptetoMezo a){
        this.a=null;
        this.e=null;
        this.l=a;
        this.m=null;
        this.t=null;
        this.h=null;
      
    }
    
    public Mezok(Mezo a){
        this.a=null;
        this.e=null;
        this.l=null;
        this.m=a;
        this.t=null;
        this.h=null;
        
    }
    
    public Mezok(ToltoMezo a){
        this.a=null;
        this.e=null;
        this.l=null;
        this.m=null;
        this.t=a;
        this.h=null;
      
    }
    
    
    public Mezok(HarcMezo a){
        this.a=null;
        this.e=null;
        this.l=null;
        this.m=null;
        this.t=null;
     
        this.h=a;
    }
    
    public Mezok(AutobattleGUI a){
        this.a=null;
        this.e=null;
        this.l=null;
        this.m=null;
        this.t=null;
    
        this.h=null;
    }
    
    public void Feladat(Jatekos jatekosok, int aktj, Jatekos j) throws CloneNotSupportedException{
        if (a!=null){
            a.Feladat(jatekosok,aktj, j);
        }
        else if (e!=null){
            e.Feladat(jatekosok,aktj, j);
        }
        else if (l!=null){
            l.Feladat(jatekosok,aktj, j);
        }
        else if (m!=null){
            m.Feladat(jatekosok,aktj, j);
        }
        else if (t!=null){
            t.Feladat(jatekosok,aktj, j);
        }
        else if (h!=null){
            h.Feladat(jatekosok,aktj, j);
        }
        
    }
    
    public int getAllas(){
        if (a!=null){
            return a.getAllas();
        }
        else if (e!=null){
            return e.getAllas();
        }
        else if (l!=null){
           return l.getAllas();
        }
        else if (m!=null){
            return m.getAllas();
        }
        else if (t!=null){
            return t.getAllas();
        }
        else if (h!=null) {
            return h.getAllas();
            
        }
        else {
            return m.getAllas();
        }
    }
    
    public Jatekos getJatekos(){
         if (a!=null){
           return a.getJatekos();
        }
        else if (e!=null){
           return e.getJatekos();
        }
        else if (l!=null){
           return l.getJatekos();
        }
        else if (m!=null){
           return m.getJatekos();
        }
        else if (t!=null){
           return t.getJatekos();
        }
        else {
  
           return h.getJatekos();
        }
        // return null;
    }
    
    public String getSzoveg(){
        if (a!=null){
            return a.getSzoveg();
        }
        else if (e!=null){
            return e.getSzoveg();
        }
        else if (l!=null){
           return l.getSzoveg();
        }
        else if (m!=null){
            return m.getSzoveg();
        }
        else if (t!=null){
            return t.getSzoveg();
        }
        else {
            return h.getSzoveg();
            
        }
    }
    public String getTipus(){
        if (a!=null){
            return null;
        }
        else if (e!=null){
            return null;
        }
        else if (l!=null){
           return null;
        }
        else if (m!=null){
            return null;
        }
        else if (t!=null){
            return null;
        }
        else {
            return "Harc";
            
        }
    }
}
