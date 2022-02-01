public class ElkuldoMezo extends Mezo {
    
    public ElkuldoMezo(int allas) {
        super(allas);
    }

    @Override
    public void Feladat(Jatekos jatekoos, int aktualisjatekos, Jatekos j) throws CloneNotSupportedException {
        super.Feladat(jatekoos, aktualisjatekos, j);
        int szam=(int)(Math.random()*133);
        jatekos.setHelyzet(szam);
        setSzoveg("Teleportált");
    }
    
    
    
}
