public class Haz {
    
    private Boolean vane, butorok, mosogato, mosogep, huto, mikro, furdoszoba; // Ezeket kötelező beszerezni a kérdés melyik fajtája van meg
    private Boolean napelem, fabutor, mosogatogep, zuhanyzo; // Melyik van meg? True: az energiatakarékosabb (változó neve) van meg, False: a másik
    private Boolean teljes=false, kimaxolva=false; // teljes: a ház összes kötelező eleme megvan-e? kimaxolva: mindenből a legtakarékosabb van meg és teljes is True
    
    //Kötelezőek
    public final void setVane(Boolean b){this.vane=b;}
    public Boolean getVane(){return this.vane;}
    
    public final void setButorok(Boolean b){this.butorok=b;}
    public Boolean getButorok(){return this.butorok;}
    
    public final void setMosogato(Boolean b){this.mosogato=b;}
    public Boolean getMosogato(){return this.mosogato;}
    
    public final void setMosogep(Boolean b){this.mosogep=b;}
    public Boolean getMosogep(){return this.mosogep;}
    
    public final void setHuto(Boolean b){this.huto=b;;}
    public Boolean getHuto(){return this.huto;}
    
    public final void setMikro(Boolean b){this.mikro=b;}
    public Boolean getMikro(){return this.mikro;}
    
    public final void setFurdoszoba(Boolean b){this.furdoszoba=b;}
    public Boolean getFurdoszoba(){return this.furdoszoba;}
    
    //Energiatakarékosak, "hosszú életűek"
    public final void setNapelem(Boolean b){this.napelem=b;}
    public Boolean getNapelem(){return this.napelem;}
    
    public final void setFabutor(Boolean b){this.fabutor=b;}
    public Boolean getFabutor(){return this.fabutor;}
    
    public final void setMosogatogep(Boolean b){this.mosogatogep=b;}
    public Boolean getMosogatogep(){return this.mosogatogep;}
    
    public final void setZuhanyzo(Boolean b){this.zuhanyzo=b;}
    public Boolean getZuhanyzo(){return this.zuhanyzo;}
    
    // Ellenőrizzük, hogy a ház minden eleme meg van-e
    public void setTeljes(){
        if (butorok && mosogato && huto && mikro && furdoszoba){
            this.teljes=true;
        }
    }
    public Boolean getTeljes(){return this.teljes;}
    
    // Ellenőrizzük, hogy a ház maximálisan energia takarékos-e
    public void setKimaxolva(){
        if (getTeljes() && napelem && fabutor && zuhanyzo && mosogatogep){
            this.kimaxolva=true;
        }
    }
    public Boolean getKimaxolva(){return this.kimaxolva;}
    
    //Konstruktor
    Haz () {
        setButorok(false);
        setFabutor(false);
        setFurdoszoba(false);
        setHuto(false);
        setMikro(false);
        setMosogato(false);
        setMosogatogep(false);
        setMosogep(false);
        setNapelem(false);
        setVane(false);
        setZuhanyzo(false);
    }
    
    
}
