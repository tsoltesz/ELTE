//Típus ismertetés: lassítják a játékos haladását, akár több körből is kimaradhat 
public class AkadalyMezo extends Mezo{
    
            //Konstruktor
    
    public AkadalyMezo(int allas) {
        super(allas);
    }
   
            //Dönt,hogy vissza kelljen lépnie vagy kimaradjon a körből, és mennyivel
    @Override
    public void Feladat(Jatekos jatekook, int akt, Jatekos j) throws CloneNotSupportedException {
        super.Feladat(jatekook, akt, j);
       // jatekosok[aktualisjatekos].setHarcol(false);
        int hogy=(int)(Math.random()*2);
        int mennyi=(int)(Math.random()*3+1);
        String szoveg;
        if (hogy==0 || mennyi<jatekos.getHelyzet()){
            setSzoveg("Kimarad "+mennyi+" körből");
            jatekos.setKimarad(mennyi);
        }
        else {
            setSzoveg("Vissza lép "+mennyi+" mezőt!");
            jatekos.setHelyzet(jatekos.getHelyzet()-(mennyi*akt));
        }
        //Értesítés GUI megnyitása a játékosok átadásával
    }
 
    
    
}
