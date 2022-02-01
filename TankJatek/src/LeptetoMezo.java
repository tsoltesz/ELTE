//Típus leírás: a játékos max 3 mezőt előre léphet
public class LeptetoMezo extends Mezo{
           
            //Konstruktor
    
    public LeptetoMezo(int allas) {
        super(allas);
    }
    
            //Dönt, hogy mennyivel haladhat előre a játékos
    @Override
        public void Feladat(Jatekos jatekoso, int aktualisjatekos, Jatekos j) throws CloneNotSupportedException{
            super.Feladat(jatekoso, aktualisjatekos, j);
            jatekos.setHarcol(false);
            int mennyi=(int)(Math.random()*4+1);
            String szoveg;
            if ((jatekos.getHelyzet()+mennyi>125 && aktualisjatekos>0) || (jatekos.getHelyzet()-mennyi<6 && aktualisjatekos<0)){ //MEGJ A MAXIMÁLIS MEZŐSZÁM
                super.setSzoveg("Lépett");
               //"Sajnálom ez a mező most nem hozott szerencsét számodra";
            }
            else {
                super.setSzoveg("Előre lép "+mennyi+" mezőt!");
              //  this.szoveg="Lépj előre "+mennyi+" mezőt!";
                jatekos.setHelyzet(jatekos.getHelyzet()+(mennyi*aktualisjatekos));
            }
            //Értesités gui meghívása a szöveggel és a jatékosokkal együtt
            //Megj. ne rakjunk a cél mezőtől 5tel közelebre ilyet
    }
       
    
}
