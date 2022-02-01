//A segítségével könyebben adhatnuk meg koordinátákat, mit hova helyezzünk a képernyő felületén
public class Pont {
    
            //Osztályváltozók
    
    private final int x;
    private final int y;
    
            //Konstruktor
    
    public Pont(int x, int y){
        this.x=x;
        this.y=y;
    }
    
            //Getterek
    
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
}
