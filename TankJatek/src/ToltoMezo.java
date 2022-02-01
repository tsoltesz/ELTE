//Típus ismertetés: Aki erre a mezőre lép életerőt/pajzsot/fegyvert tud növelni, mindig csak 1-gyel
public class ToltoMezo extends Mezo{
     
            //Konstruktor
    
    public ToltoMezo(int allas) {
        super(allas);
    }
    
            //Egyszerre csak egy féle erőt tölt, fontossági sorrend: Élet>Pajzs>Fegyver
    @Override
    public void Feladat(Jatekos jatekosok, int aktualisjatekos, Jatekos j) throws CloneNotSupportedException{
        super.Feladat(jatekosok, aktualisjatekos, j);
        jatekos.setHarcol(false);
        if (jatekos.getElet()<3){
            jatekos.setToltElet();
        }
        else if (jatekos.getPajzs()<5){
            jatekos.setToltPajzs();
        }
        else if (jatekos.getFegyver()<5){
            jatekos.setToltFegyver();
        }
        setSzoveg("Tankolt");
        
    }
    
}
