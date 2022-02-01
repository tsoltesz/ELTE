//Itt töltjük fel a mezőket

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Vector;
import javax.swing.JOptionPane;

public class Tabla {
    
    private Vector <Mezo> tabla=new Vector <Mezo>();
    
    Tabla(){
      
      try{
          String sor;
          BufferedReader br=new BufferedReader(new InputStreamReader((Tabla.class.getResourceAsStream("/feliratok/Mezoszovegek.txt")), "UTF8"));
          
          while((sor=br.readLine())!=null){
              String t[]=sor.split("\t");
              Pont t2[]={new Pont(Integer.parseInt(t[3]),Integer.parseInt(t[4])),new Pont(Integer.parseInt(t[5]),Integer.parseInt(t[6])),new Pont(Integer.parseInt(t[7]),Integer.parseInt(t[8])), new Pont(Integer.parseInt(t[9]),Integer.parseInt(t[10]))};
             // for (int i=0;i<t2.length;i++){System.out.println("X: "+t2[i].getX());System.out.println("Y: "+t2[i].getY());}
            //  System.out.println(t2.length);
              Mezo m=new Mezo(0,t[1],t[2],Integer.parseInt(t[0]),0,t2);
              tabla.add(m);
          }
          br.close();
      }
      catch(Exception e){
          JOptionPane.showMessageDialog(null, "Sajnálom hiba történt a játék indításakor");
          System.exit(0);
      }
    }
    
    public Vector<Mezo> getTabla(){return this.tabla;}
    
  
}
