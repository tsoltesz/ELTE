
public class HarcMezo extends Mezo{

    public HarcMezo(int allas) {
        super(allas);
    }
    
    

    @Override
    public void Feladat(Jatekos jatekos, int aktualisjatekos, Jatekos j) throws CloneNotSupportedException {
        super.Feladat(jatekos, aktualisjatekos, j); //To change body of generated methods, choose Tools | Templates.
        this.jatekos.setHarcol(true);
        setSzoveg("Lépett");
         // ide az ellenörzés hogy mehete a harc
         if (j.getHarcol()){
             // indul a harc
         }
    }
    
    
    
}
