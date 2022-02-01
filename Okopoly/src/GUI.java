
import java.awt.AlphaComposite;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.filechooser.FileSystemView;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;

public class GUI extends javax.swing.JFrame {
    
    BufferedImage tablakep;
    Vector <Jatekos> jatekosok;
    Tabla tabla;
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();   // A képernyő nagyságának lekérése 
   // final int magassag=(int)(dim.height);
   // final int szelesseg=(int)(dim.width);
    final int magassag=700;
    final int szelesseg=1100;
   static int kor=0;
    int aktualisjatekos;
    static Boolean dobott=false;
    Boolean kilepes=false;
    long ido=3000;
    String allattartastanacs[];
    String fenntarthatosagtanacs[];
    String gazdasagtanacs[];
    String kornyezetvedelemtanacs[];
    
    DefaultTreeModel model;
    String nyertes;
    Boolean gepi;
    BufferedImage haziko;
    //amiket meg kell venni:
    BufferedImage sima,napelem,furdo,konyha,butor1,butor2, butor3,butor4, benzines,elektromos,huto,bicikli, mikro;
    String dobottak[]={"☻","<html>☻<br>☻</htlm>","<html>☻ &nbsp &nbsp <br>  &nbsp ☻ &nbsp  <br>  &nbsp &nbsp    ☻</htlm>","<html>☻      ☻<br>       <br>☻     ☻</htlm>","<html>☻      ☻<br>  &nbsp ☻ &nbsp  <br>☻     ☻</htlm>","<html>☻      ☻<br>☻      ☻<br>☻     ☻</htlm>"};
     Thread t=null;
    Vector <Quiz> quiz;
   // final int kepszelesseg=((int)szelesseg*(2/3));
    Graphics g;
    public GUI() {
        initComponents();
        g=jPanel2.getGraphics();
        jatekosok=new Vector <Jatekos>();
        tabla=new Tabla();
        
        
    }
    public GUI(Vector <String> vector, Boolean b) {
        try{
            tablakep= ImageIO.read(GUI.class.getResource("/kepek/tabla.png"));
            haziko= ImageIO.read(GUI.class.getResource("/kepek/Keret.png") );
            sima=ImageIO.read(GUI.class.getResource("/kepek/Haz.png") );
            napelem=ImageIO.read(GUI.class.getResource("/kepek/Haz.png") ); //?
            furdo=ImageIO.read(GUI.class.getResource("/kepek/Furdo.png") );
            konyha=ImageIO.read(GUI.class.getResource("/kepek/Konyha.png") );
            butor1=ImageIO.read(GUI.class.getResource("/kepek/Gyerek.png") );
            butor2=ImageIO.read(GUI.class.getResource("/kepek/Iroda.png") );
            butor3=ImageIO.read(GUI.class.getResource("/kepek/Nappali.png") );
            butor4=ImageIO.read(GUI.class.getResource("/kepek/Szoba.png") );
            benzines=ImageIO.read(GUI.class.getResource("/kepek/benzin.png") );
            elektromos=ImageIO.read(GUI.class.getResource("/kepek/elektromos.png") );
            huto=ImageIO.read(GUI.class.getResource("/kepek/Huto.png") );
            bicikli=ImageIO.read(GUI.class.getResource("/kepek/bicikli.png") );
            mikro=ImageIO.read(GUI.class.getResource("/kepek/Mikro.png") );
            
            
            
       
           
        }
        catch(Exception e){
        }
        Color szinek[]={Color.green,Color.yellow,Color.blue,Color.red};
        String magyarszinek[]={"Zöld","Sárga","Kék","Piros"};
        jatekosok=new Vector <Jatekos>();
        for (int i=0;i<vector.size();i++){    // A nevek feltöltése
            Jatekos jatekos=new Jatekos(vector.get(i),0,500000,0,szinek[i],magyarszinek[i]);
            jatekosok.add(jatekos);
        }
        allattartastanacs=Beolvas("Allattartas.txt");
        aktualisjatekos=0;
        fenntarthatosagtanacs=Beolvas("Fenttarthatosag.txt");
        gazdasagtanacs=Beolvas("Gazdasag.txt");
        kornyezetvedelemtanacs=Beolvas("Kornyezetvedelem.txt");
        
        quiz=new Vector<Quiz>();
        QuizBeolvas("quizkerdesek.txt");
        gepi=b;
        initComponents();
        setSize(szelesseg,magassag);   // A program teljes képernyőssé tétele
        
        
       // jPanel1.setSize((int)szelesseg*(2/3)-10,(int) (magassag*(3/4)-15));
        setLocationRelativeTo(null);
        setResizable(false);
        
        g= jPanel2.getGraphics();
        
         
        jLabel2.setText(" ");
        jLabel3.setText(" ");
        jLabel4.setText(jatekosok.get(0).getNev());
        jPanel2.setBackground(jatekosok.get(aktualisjatekos).getSzin());
      //  jTree1.setBackground(jPanel2.getBackground());
        //if (jPanel2.getBackground()==Color.blue && jPanel2.getBackground()==Color.red){jTree1.setForeground(Color.white);} else{jTree1.setForeground(Color.white);}
        tabla=new Tabla();
   
       DefaultMutableTreeNode jat=new DefaultMutableTreeNode("Játékosok");
        if (jatekosok.size()==2){
            DefaultMutableTreeNode n1=new DefaultMutableTreeNode(jatekosok.get(0).getNev()+" ("+jatekosok.get(0).getSzinM()+" játékos)");
            DefaultMutableTreeNode mezo1=new DefaultMutableTreeNode("Mező: "+Integer.toString(jatekosok.get(0).getMezo()+1));
            DefaultMutableTreeNode penz1=new DefaultMutableTreeNode("Bankszámla: "+Integer.toString(jatekosok.get(0).getPenz())+" Ft");
            DefaultMutableTreeNode pont1=new DefaultMutableTreeNode("Ökopont: "+Integer.toString(jatekosok.get(0).getPont()));
            n1.add(mezo1);n1.add(penz1);n1.add(pont1);
            DefaultMutableTreeNode n2=new DefaultMutableTreeNode(jatekosok.get(1).getNev()+" ("+jatekosok.get(1).getSzinM()+" játékos)");
            DefaultMutableTreeNode mezo2=new DefaultMutableTreeNode("Mező: "+Integer.toString(jatekosok.get(1).getMezo()+1));
            DefaultMutableTreeNode penz2=new DefaultMutableTreeNode("Bankszámla: "+Integer.toString(jatekosok.get(1).getPenz())+" Ft");
            DefaultMutableTreeNode pont2=new DefaultMutableTreeNode("Ökopont: "+Integer.toString(jatekosok.get(1).getPont()));
            n2.add(mezo2);n2.add(penz2);n2.add(pont2);jat.add(n1);jat.add(n2);
            
            
        }
        else if (jatekosok.size()==3){
            DefaultMutableTreeNode n1=new DefaultMutableTreeNode(jatekosok.get(0).getNev()+" ("+jatekosok.get(0).getSzinM()+" játékos)");
            DefaultMutableTreeNode mezo1=new DefaultMutableTreeNode("Mező: "+Integer.toString(jatekosok.get(0).getMezo()+1));
            DefaultMutableTreeNode penz1=new DefaultMutableTreeNode("Bankszámla: "+Integer.toString(jatekosok.get(0).getPenz())+" Ft");
            DefaultMutableTreeNode pont1=new DefaultMutableTreeNode("Ökopont: "+Integer.toString(jatekosok.get(0).getPont()));
            n1.add(mezo1);n1.add(penz1);n1.add(pont1);
            DefaultMutableTreeNode n2=new DefaultMutableTreeNode(jatekosok.get(1).getNev()+" ("+jatekosok.get(1).getSzinM()+" játékos)");
            DefaultMutableTreeNode mezo2=new DefaultMutableTreeNode("Mező: "+Integer.toString(jatekosok.get(1).getMezo()+1));
            DefaultMutableTreeNode penz2=new DefaultMutableTreeNode("Bankszámla: "+Integer.toString(jatekosok.get(1).getPenz())+" Ft");
            DefaultMutableTreeNode pont2=new DefaultMutableTreeNode("Ökopont: "+Integer.toString(jatekosok.get(1).getPont()));
            n2.add(mezo2);n2.add(penz2);n2.add(pont2);
            DefaultMutableTreeNode n3=new DefaultMutableTreeNode(jatekosok.get(2).getNev()+" ("+jatekosok.get(2).getSzinM()+" játékos)");
            DefaultMutableTreeNode mezo3=new DefaultMutableTreeNode("Mező: "+Integer.toString(jatekosok.get(2).getMezo()+1));
            DefaultMutableTreeNode penz3=new DefaultMutableTreeNode("Bankszámla: "+Integer.toString(jatekosok.get(2).getPenz())+" Ft");
            DefaultMutableTreeNode pont3=new DefaultMutableTreeNode("Ökopont: "+Integer.toString(jatekosok.get(2).getPont()));
            n3.add(mezo3);n3.add(penz3);n3.add(pont3);
            
            jat.add(n1);jat.add(n2);jat.add(n3);
            
        }
        else {
            DefaultMutableTreeNode n1=new DefaultMutableTreeNode(jatekosok.get(0).getNev()+" ("+jatekosok.get(0).getSzinM()+" játékos)");
            DefaultMutableTreeNode mezo1=new DefaultMutableTreeNode("Mező: "+Integer.toString(jatekosok.get(0).getMezo()+1));
            DefaultMutableTreeNode penz1=new DefaultMutableTreeNode("Bankszámla: "+Integer.toString(jatekosok.get(0).getPenz())+" Ft");
            DefaultMutableTreeNode pont1=new DefaultMutableTreeNode("Ökopont: "+Integer.toString(jatekosok.get(0).getPont()));
            n1.add(mezo1);n1.add(penz1);n1.add(pont1);
            DefaultMutableTreeNode n2=new DefaultMutableTreeNode(jatekosok.get(1).getNev()+" ("+jatekosok.get(1).getSzinM()+" játékos)");
            DefaultMutableTreeNode mezo2=new DefaultMutableTreeNode("Mező: "+Integer.toString(jatekosok.get(1).getMezo()+1));
            DefaultMutableTreeNode penz2=new DefaultMutableTreeNode("Bankszámla: "+Integer.toString(jatekosok.get(1).getPenz())+" Ft");
            DefaultMutableTreeNode pont2=new DefaultMutableTreeNode("Ökopont: "+Integer.toString(jatekosok.get(1).getPont()));
            n2.add(mezo2);n2.add(penz2);n2.add(pont2);
            DefaultMutableTreeNode n3=new DefaultMutableTreeNode(jatekosok.get(2).getNev()+" ("+jatekosok.get(2).getSzinM()+" játékos)");
            DefaultMutableTreeNode mezo3=new DefaultMutableTreeNode("Mező: "+Integer.toString(jatekosok.get(2).getMezo()+1));
            DefaultMutableTreeNode penz3=new DefaultMutableTreeNode("Bankszámla: "+Integer.toString(jatekosok.get(2).getPenz())+" Ft");
            DefaultMutableTreeNode pont3=new DefaultMutableTreeNode("Ökopont: "+Integer.toString(jatekosok.get(2).getPont()));
            n3.add(mezo3);n3.add(penz3);n3.add(pont3);
            DefaultMutableTreeNode n4=new DefaultMutableTreeNode(jatekosok.get(3).getNev()+" ("+jatekosok.get(3).getSzinM()+" játékos)");
            DefaultMutableTreeNode mezo4=new DefaultMutableTreeNode("Mező: "+Integer.toString(jatekosok.get(3).getMezo()+1));
            DefaultMutableTreeNode penz4=new DefaultMutableTreeNode("Bankszámla: "+Integer.toString(jatekosok.get(3).getPenz())+" Ft");
            DefaultMutableTreeNode pont4=new DefaultMutableTreeNode("Ökopont: "+Integer.toString(jatekosok.get(3).getPont()));
            n4.add(mezo4);n4.add(penz4);n4.add(pont4);jat.add(n1);jat.add(n2);jat.add(n3);jat.add(n4);
        
        }
        model=new DefaultTreeModel(jat);
        jTree1.setModel(model);
        for (int i = 0; i < jTree1.getRowCount(); i++) {
            jTree1.expandRow(i);
        }
      
        
        
        
    }
    public GUI(GUI g){ 
      try{
            tablakep= ImageIO.read(GUI.class.getResource("/kepek/tabla.png"));
            haziko= ImageIO.read(GUI.class.getResource("/kepek/Keret.png") );
            sima=ImageIO.read(GUI.class.getResource("/kepek/Haz.png") );
            napelem=ImageIO.read(GUI.class.getResource("/kepek/Haz.png") ); //?
            furdo=ImageIO.read(GUI.class.getResource("/kepek/Furdo.png") );
            konyha=ImageIO.read(GUI.class.getResource("/kepek/Konyha.png") );
            butor1=ImageIO.read(GUI.class.getResource("/kepek/Gyerek.png") );
            butor2=ImageIO.read(GUI.class.getResource("/kepek/Iroda.png") );
            butor3=ImageIO.read(GUI.class.getResource("/kepek/Nappali.png") );
            butor4=ImageIO.read(GUI.class.getResource("/kepek/Szoba.png") );
            benzines=ImageIO.read(GUI.class.getResource("/kepek/benzin.png") );
            elektromos=ImageIO.read(GUI.class.getResource("/kepek/elektromos.png") );
            huto=ImageIO.read(GUI.class.getResource("/kepek/Huto.png") );
            bicikli=ImageIO.read(GUI.class.getResource("/kepek/bicikli.png") );
            mikro=ImageIO.read(GUI.class.getResource("/kepek/Mikro.png") );
           
        }
        catch(Exception e){
        }
        allattartastanacs=g.allattartastanacs;
        jatekosok=g.jatekosok;
        aktualisjatekos=g.aktualisjatekos;
        
        kor=g.kor;
        fenntarthatosagtanacs=g.fenntarthatosagtanacs;
        gazdasagtanacs=g.gazdasagtanacs;
        kornyezetvedelemtanacs=g.kornyezetvedelemtanacs;
        tabla=g.tabla;
        gepi=g.gepi;
        quiz=g.quiz; 
        
        initComponents();
        
        setEnabled(false);
        jButton1.setText(g.jButton1.getText());
        this.g=g.jPanel2.getGraphics();
        setSize(szelesseg,magassag);   // A program teljes képernyőssé tétele
        jPanel2.setBackground(g.jPanel2.getBackground());
       
        
        jButton1.setEnabled(false);
        jLabel2.setText(g.jLabel2.getText());
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 10));
        jLabel3.setText(g.jLabel3.getText());
        jLabel4.setText(g.jLabel4.getText());
        if (t!=null){
            t.stop();
        }
         t=new Thread(new Runnable() {
            @Override
            public void run() {
                
                try {
                    Thread.sleep(ido);
                } catch (InterruptedException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                jPanel2.setBackground(jatekosok.get(aktualisjatekos).getSzin());
              //  if (jPanel2.getBackground()==Color.blue && jPanel2.getBackground()==Color.red){jTree1.setForeground(Color.white);} else{jTree1.setForeground(Color.white);}
              //  jTree1.setBackground(jPanel2.getBackground());
                jLabel2.setText(" ");
                jLabel3.setText(" ");
                jLabel4.setText(jatekosok.get(aktualisjatekos).getNev());
                jButton1.setEnabled(true);
                setEnabled(true);
                 Kesz(Vege());
                 if (aktualisjatekos==1 && gepi){
                     
                     Gep();
                 
                 }
                 }});
         t.start();
        
         
   
         g.Frissit();
        // g.jPanel5.getGraphics().drawImage(benzines, 164, 8, this);
         jTree1.setModel(g.jTree1.getModel());
         
         
         for (int i = 0; i < jTree1.getRowCount(); i++) {
            jTree1.expandRow(i);
        }
        
        setLocationRelativeTo(null);
        //Gépi
        
        
        
    }
       

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                //jPanel2.setSize((int)(szelesseg*2/3),(int)(magassag));
                super.paintComponent(g);
                Image newImage = tablakep.getScaledInstance((int)(szelesseg*2/3), (int)(magassag*3/4), Image.SCALE_DEFAULT);
                //  tablakep=(BufferedImage)newImage;
                g.drawImage(newImage ,0 , 0, this);
                for (int i=0;i<jatekosok.size();i++){
                    g.setColor(jatekosok.get(i).getSzin());
                    int x=tabla.getTabla().get(jatekosok.get(i).getMezo()).getHelyek()[i].getX();
                    int y=tabla.getTabla().get(jatekosok.get(i).getMezo()).getHelyek()[i].getY();
                    g.fillOval(x-5, y-5, 15, 15);
                }

            }}
            ;
            jPanel1 = new javax.swing.JPanel();
            jLabel2 = new javax.swing.JLabel();
            jLabel3 = new javax.swing.JLabel();
            jLabel4 = new javax.swing.JLabel();
            filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
            jButton1 = new javax.swing.JButton();
            jPanel5 = new javax.swing.JPanel(){
                @Override
                protected void paintComponent(Graphics g) {
                    //jPanel2.setSize((int)(szelesseg*2/3),(int)(magassag));
                    super.paintComponent(g);
                    Image newImage = haziko.getScaledInstance(334,243, Image.SCALE_DEFAULT);
                    //tablakep=(BufferedImage)newImage;
                    g.drawImage(newImage ,0 , 0, this);
                    //ifekkel hogy kinek milye van
                    if (jatekosok.get(aktualisjatekos).getHaz().getVane()){
                        Image newImage2 = sima.getScaledInstance((int)(249*0.85),(int)(115*0.71), Image.SCALE_DEFAULT);
                        g.drawImage(newImage2, 5 , 5, this);
                    }
                    if (jatekosok.get(aktualisjatekos).getHaz().getFurdoszoba()){
                        Image newImage3 = furdo.getScaledInstance((int)((74*0.85))+1,(int)(55*0.71), Image.SCALE_DEFAULT);
                        g.drawImage(newImage3, 119 , 133, this);}
                    if (jatekosok.get(aktualisjatekos).getHaz().getButorok()){

                        Image newImage5 = butor1.getScaledInstance((int)((127*0.85)+2),(int)(79*0.71), Image.SCALE_DEFAULT);
                        g.drawImage(newImage5, 220 , 75, this);
                        Image newImage6 = butor2.getScaledInstance((int)((116*0.85)+1),(int)(60*0.71)+1, Image.SCALE_DEFAULT);
                        g.drawImage(newImage6, 119 , 88, this);
                        Image newImage7 = butor3.getScaledInstance((int)((132*0.85)),(int)(74*0.71), Image.SCALE_DEFAULT);
                        g.drawImage(newImage7, 5 , 122, this);
                        Image newImage8 = butor4.getScaledInstance((int)((128*0.85)+1),(int)(96*0.71)+1, Image.SCALE_DEFAULT);
                        g.drawImage(newImage8, 220 , 4, this);}
                    if (jatekosok.get(aktualisjatekos).getAuto() && !jatekosok.get(aktualisjatekos).getElektromos()){
                        Image newImage9 = benzines.getScaledInstance((int)((132*0.85)),(int)(45*0.71)+1, Image.SCALE_DEFAULT);
                        g.drawImage(newImage9, 5 , 88, this);
                    }
                    else if (jatekosok.get(aktualisjatekos).getElektromos()){
                        // vagy elektromos iffel
                        Image newImage9 = elektromos.getScaledInstance((int)((132*0.85)),(int)(45*0.71)+1, Image.SCALE_DEFAULT);
                        g.drawImage(newImage9, 5 , 88, this);}
                    if (jatekosok.get(aktualisjatekos).getHaz().getHuto()){
                        Image newImage10 = huto.getScaledInstance((int)((52*0.85)),(int)(98*0.71)+1, Image.SCALE_DEFAULT);
                        g.drawImage(newImage10, 184 , 133, this);
                        Image newImage12 = mikro.getScaledInstance((int)((74*0.85)+1),(int)(41*0.71)+1, Image.SCALE_DEFAULT);
                        g.drawImage(newImage12, 119 , 174, this);
                        Image newImage4 = konyha.getScaledInstance((int)((131*0.85)+1),(int)(85*0.71)+1, Image.SCALE_DEFAULT);
                        g.drawImage(newImage4, 5 , 178, this);
                    }
                    if (jatekosok.get(aktualisjatekos).getBicikli()){

                        Image newImage11 = bicikli.getScaledInstance((int)((74*0.85)),(int)(48*0.71)+1, Image.SCALE_DEFAULT);
                        g.drawImage(newImage11, 119 , 205, this);}

                }

            };
            jScrollPane1 = new javax.swing.JScrollPane();
            jTree1 = new javax.swing.JTree();
            jPanel3 = new javax.swing.JPanel();
            jMenuBar1 = new javax.swing.JMenuBar();
            jMenu1 = new javax.swing.JMenu();
            jMenu2 = new javax.swing.JMenu();
            jMenu6 = new javax.swing.JMenu();
            jMenu7 = new javax.swing.JMenu();
            jMenu3 = new javax.swing.JMenu();
            jMenu5 = new javax.swing.JMenu();
            jMenu4 = new javax.swing.JMenu();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            setTitle("Ökonomy");
            setMaximumSize(new java.awt.Dimension(1100, 800));
            setUndecorated(true);
            setPreferredSize(new java.awt.Dimension(1100, 800));
            addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyReleased(java.awt.event.KeyEvent evt) {
                    formKeyReleased(evt);
                }
            });

            jPanel2.setBackground(java.awt.Color.blue);
            jPanel2.setPreferredSize(new java.awt.Dimension(1100, 800));
            jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jPanel2MouseClicked(evt);
                }
            });

            jPanel1.setFocusable(false);
            jPanel1.setMaximumSize(new java.awt.Dimension(1000, 150));
            jPanel1.setMinimumSize(new java.awt.Dimension(1000, 150));
            jPanel1.setRequestFocusEnabled(false);

            jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
            jLabel2.setForeground(java.awt.Color.darkGray);
            jLabel2.setText("greg");
            jLabel2.setFocusable(false);

            jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
            jLabel3.setForeground(java.awt.Color.darkGray);
            jLabel3.setText("greg");
            jLabel3.setFocusable(false);

            jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
            jLabel4.setForeground(java.awt.Color.darkGray);
            jLabel4.setText("greg");
            jLabel4.setFocusable(false);

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel4)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel3)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLabel2)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            jButton1.setBackground(java.awt.Color.white);
            jButton1.setText("☻");
            jButton1.setFocusable(false);
            jButton1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1ActionPerformed(evt);
                }
            });

            jPanel5.setFocusable(false);
            jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jPanel5MouseClicked(evt);
                }
            });

            javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
            jPanel5.setLayout(jPanel5Layout);
            jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 334, Short.MAX_VALUE)
            );
            jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 243, Short.MAX_VALUE)
            );

            jTree1.setBackground(new java.awt.Color(204, 204, 204));
            jTree1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
            jTree1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
            javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
            javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("JTree");
            treeNode1.add(treeNode2);
            treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("h");
            javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("blue");
            treeNode2.add(treeNode3);
            treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("violet");
            treeNode2.add(treeNode3);
            treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("red");
            treeNode2.add(treeNode3);
            treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("yellow");
            treeNode2.add(treeNode3);
            treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("sports");
            javax.swing.tree.DefaultMutableTreeNode treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("basketball");
            treeNode3.add(treeNode4);
            treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("soccer");
            treeNode3.add(treeNode4);
            treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("football");
            treeNode3.add(treeNode4);
            treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("hockey");
            treeNode3.add(treeNode4);
            treeNode2.add(treeNode3);
            treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("food");
            treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("hot dogs");
            treeNode3.add(treeNode4);
            treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("pizza");
            treeNode3.add(treeNode4);
            treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("ravioli");
            treeNode3.add(treeNode4);
            treeNode4 = new javax.swing.tree.DefaultMutableTreeNode("bananas");
            treeNode3.add(treeNode4);
            treeNode2.add(treeNode3);
            treeNode1.add(treeNode2);
            jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
            jTree1.setFocusable(false);
            jScrollPane1.setViewportView(jTree1);

            javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
            jPanel2.setLayout(jPanel2Layout);
            jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(359, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(392, 392, 392))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(15, 15, 15))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap())))))
            );
            jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGap(19, 19, 19))
            );

            javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
            jPanel3.setLayout(jPanel3Layout);
            jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 360, Short.MAX_VALUE)
            );
            jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 100, Short.MAX_VALUE)
            );

            jMenuBar1.setFocusable(false);
            jMenuBar1.setMinimumSize(new java.awt.Dimension(1030, 22));

            jMenu1.setText("Mentés");
            jMenu1.setAlignmentX(1800.0F);
            jMenu1.setFocusable(false);
            jMenu1.setMinimumSize(new java.awt.Dimension(47, 0));
            jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jMenu1MouseClicked(evt);
                }
            });
            jMenuBar1.add(jMenu1);

            jMenu2.setText("Új játék");
            jMenu2.setFocusable(false);
            jMenu2.setMinimumSize(new java.awt.Dimension(47, 0));
            jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jMenu2MouseClicked(evt);
                }
            });
            jMenuBar1.add(jMenu2);

            jMenu6.setText("Súgó");
            jMenu6.setFocusable(false);
            jMenu6.setMinimumSize(new java.awt.Dimension(35, 0));
            jMenu6.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jMenu6MouseClicked(evt);
                }
            });
            jMenuBar1.add(jMenu6);

            jMenu7.setText("Bolt");
            jMenu7.setFocusable(false);
            jMenu7.setMinimumSize(new java.awt.Dimension(29, 0));
            jMenu7.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jMenu7MouseClicked(evt);
                }
            });
            jMenuBar1.add(jMenu7);

            jMenu3.setFocusable(false);
            jMenu3.setMinimumSize(new java.awt.Dimension(600, 20));
            jMenu3.setPreferredSize(new java.awt.Dimension(940, 20));
            jMenu3.setEnabled(false);
            jMenuBar1.add(jMenu3);

            jMenu5.setText("_");
            jMenu5.setFocusable(false);
            jMenu5.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jMenu5MouseClicked(evt);
                }
            });
            jMenuBar1.add(jMenu5);

            jMenu4.setBackground(java.awt.Color.red);
            jMenu4.setText("X");
            jMenu4.setFocusable(false);
            jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jMenu4MouseClicked(evt);
                }
            });
            jMenuBar1.add(jMenu4);

            setJMenuBar(jMenuBar1);

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 729, Short.MAX_VALUE)
            );

            setSize(new java.awt.Dimension(1100, 751));
            setLocationRelativeTo(null);
        }// </editor-fold>//GEN-END:initComponents

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        if(evt.getKeyCode()==27){
           new MentesGUI(this).setVisible(true);
      
        }
    }//GEN-LAST:event_formKeyReleased

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        new MentesGUI(this).setVisible(true);
    }//GEN-LAST:event_jMenu4MouseClicked

    private void jMenu5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu5MouseClicked
        setExtendedState(JFrame.ICONIFIED);
        setExtendedState(getExtendedState() | JFrame.ICONIFIED);
    }//GEN-LAST:event_jMenu5MouseClicked

    private void jMenu6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu6MouseClicked
        new SugoGUI(this).setVisible(true);
    }//GEN-LAST:event_jMenu6MouseClicked

    private void jMenu7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu7MouseClicked
        new BoltGUI(this).setVisible(true);
    }//GEN-LAST:event_jMenu7MouseClicked

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
       Mentes();
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        new MentesGUI(this,true).setVisible(true);
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
         System.out.println("X: "+evt.getX()+" Y: "+evt.getY());
        //  jatekosok.get(aktualisjatekos).addPenz(1500000000);
    }//GEN-LAST:event_jPanel2MouseClicked
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jButton1.setEnabled(false);
        setEnabled(false);
        kor++;
        int dobottertek=Dobas();
       
        jButton1.setText(dobottak[dobottertek-1]);
        jButton1.setSize(75, 75);
        jatekosok.get(aktualisjatekos).setMezo(jatekosok.get(aktualisjatekos).getMezo()+dobottertek); //Ha a dobott érték+jelenlegihely nagyobb mint a legnagyobb mező helye akkor az elejére dobja
        if (jatekosok.get(aktualisjatekos).getMezo()>=tabla.getTabla().size()){
            jatekosok.get(aktualisjatekos).setMezo(jatekosok.get(aktualisjatekos).getMezo()-tabla.getTabla().size());
            Cselekves(100);
            Frissit();
        }
        Frissit();
        jLabel4.setText(jatekosok.get(aktualisjatekos).getNev());
        jLabel2.setText("");
        /* for (int i=0;i<jatekosok.size();i++){
            if (!tabla.getTabla().get(jatekosok.get(aktualisjatekos).getMezo()).getFoglal(i)){
                tabla.getTabla().get(jatekosok.get(aktualisjatekos).getMezo()).setFoglal(i,true);
                //  System.out.println(g);
                // g.drawOval(100, 200, 5, 5);

                break;
            }
        }*/

        Cselekves(jatekosok.get(aktualisjatekos).getMezo()-1);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        // System.out.println("X: "+evt.getX()+" Y: "+evt.getY());
    }//GEN-LAST:event_jPanel5MouseClicked
public void Mentes(){
     try{
            String sor="";
            
            String cim=FileSystemView.getFileSystemView().getDefaultDirectory().getPath()+"\\Okopoly";
            new File(cim).mkdir();
        //    BufferedWriter bw=new BufferedWriter(new FileWriter(new File(cim+"\\Mentes")));
            Writer bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(cim+"\\Mentes.txt"), "UTF-8"));
         //   System.out.println(cim);
         //   GUI.class.getResourceAsStream("/feliratok/Mentes.tyt")
            for (int i=0;i<jatekosok.size();i++){
                sor=jatekosok.get(i).getNev()+"\t"+jatekosok.get(i).getPenz()+"\t"+jatekosok.get(i).getPont()+"\t"+jatekosok.get(i).getMezo()+"\t"+jatekosok.get(i).getFizetes()+"\t"+jatekosok.get(i).getKornyezetilabnyom()+"\t"+jatekosok.get(i).getLepes()+"\t";
                sor+=(jatekosok.get(i).getHaz().getVane()+"\t"+jatekosok.get(i).getHaz().getNapelem()+"\t"+jatekosok.get(i).getHaz().getButorok()+"\t"+jatekosok.get(i).getHaz().getMosogato()+"\t"+jatekosok.get(i).getHaz().getMosogep()+"\t"+jatekosok.get(i).getHaz().getHuto()+"\t"+jatekosok.get(i).getHaz().getMikro()+"\t"+jatekosok.get(i).getHaz().getFurdoszoba()+"\t"+jatekosok.get(i).getHaz().getFabutor()+"\t"+jatekosok.get(i).getHaz().getZuhanyzo()+"\t"+jatekosok.get(i).getHaz().getMosogatogep()+"\t"+jatekosok.get(i).getSzinM()+"\t"+jatekosok.get(i).getAuto()+"\t"+jatekosok.get(i).getBicikli()+"\t"+jatekosok.get(i).getElektromos()+"\n");
                bw.write(sor);
      
            }
            bw.write("guitul"+"\n");
                bw.write(aktualisjatekos+"\n");
                bw.write(kor+"\n");
                bw.write(jButton1.getText()+"\n");
                bw.write(jLabel2.getText()+"\n");
                bw.write(jLabel3.getText()+"\n");
                bw.write(jLabel4.getText()+"\n");
                bw.write(gepi+"\n");
                bw.write(jPanel1.getBackground()+"");
                bw.close();
                jLabel3.setText("Sikeres Mentés");
                
        }
        catch(Exception e){
            jLabel3.setText("A mentés sikertelen");
        }
}
    public static void main(String args[]) {
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(false);
                KezdoGUI kezdo=new KezdoGUI();
                kezdo.setVisible(true);      
            }
        });
        
    }
    
    public int Dobas(){
        int dobott=(int)(Math.random()*6)+1;
        return dobott;
    }
    public Boolean Vege(){
       // System.out.println(aktualisjatekos);
        if (jatekosok.size()==1 || (jatekosok.get(aktualisjatekos).getAuto() && jatekosok.get(aktualisjatekos).getBicikli() && jatekosok.get(aktualisjatekos).getHaz().getHuto() && jatekosok.get(aktualisjatekos).getHaz().getButorok() && jatekosok.get(aktualisjatekos).getHaz().getFurdoszoba() && jatekosok.get(aktualisjatekos).getPenz()>0)){
           int maxpont=-1;
            for (int i=0;i<jatekosok.size();i++){
                if (i!=aktualisjatekos){
                    if (jatekosok.get(i).getPont()>jatekosok.get(aktualisjatekos).getPont()){
                        maxpont=1;
                        break;
                    }
                }
            }
            if (maxpont==-1){nyertes=jatekosok.get(aktualisjatekos).getNev();return true;}
        }
            
 
        return false;
    }
    public void Kesz(Boolean b){
        if (b){
            try{
            File mentes=new File("Mentes.txt");
            mentes.delete();
            }
            catch(Exception e){
                
            }
            new VegeGUI(nyertes).setVisible(true);
            dispose();
        }
    }
   
    
    public void Cselekves(int mezoszam){
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 10));
        if(mezoszam==100){
              //Áthaladás a startmezőn
              
         t=new Thread(new Runnable() {
            @Override
            public void run() {
                jatekosok.get(aktualisjatekos).addPenz((jatekosok.get(aktualisjatekos).getFizetes()-(jatekosok.get(aktualisjatekos).getHitelertek()+jatekosok.get(aktualisjatekos).getAutobiztertek())));
                jLabel2.setText("+"+(jatekosok.get(aktualisjatekos).getFizetes()-(jatekosok.get(aktualisjatekos).getHitelertek()+jatekosok.get(aktualisjatekos).getAutobiztertek()))); 
                jLabel4.setText(jatekosok.get(aktualisjatekos).getNev());
                jLabel3.setText(tabla.getTabla().get(1).getSzoveg());
              //  if (jPanel2.getBackground()==Color.blue && jPanel2.getBackground()==Color.red){jTree1.setForeground(Color.white);} else{jTree1.setForeground(Color.white);}
                try {
                    Thread.sleep(ido);
                } catch (InterruptedException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }});
         t.start();
        }
        else{
        
            
        jLabel3.setText(tabla.getTabla().get(mezoszam).getSzoveg());
        switch (mezoszam){
            case 0:{
                jLabel3.setText("Az átlag fizetése mellé bonuszt is kapott");
                jatekosok.get(aktualisjatekos).addPenz(((jatekosok.get(aktualisjatekos).getFizetes())*2-(jatekosok.get(aktualisjatekos).getHitelertek()+jatekosok.get(aktualisjatekos).getAutobiztertek())));
                jLabel2.setText("+"+((jatekosok.get(aktualisjatekos).getFizetes())*2-(jatekosok.get(aktualisjatekos).getHitelertek()+jatekosok.get(aktualisjatekos).getAutobiztertek()))); 
                aktualisjatekos++;
                if(aktualisjatekos>=jatekosok.size()){
                    aktualisjatekos=0;
                }
              
                new GUI(this).setVisible(true);
                dispose();
        
                break;
            }
            case 1 :{
                int r=(int)(Math.random()*kornyezetvedelemtanacs.length);
                new Tanacs(kornyezetvedelemtanacs[r],"KornyezetvedelemHatter.jpg",this);
                break;
            }
            case 2:{ // Ide valami felugró ablakot kéne még csinálni
                if (!gepi || aktualisjatekos==0){
                this.setEnabled(false);
                UjAllasGUI allas=new UjAllasGUI(this,jatekosok.get(aktualisjatekos).getNev());
                allas.setVisible(true);
                }
                else {
                    jLabel2.setText("De elutasította");
                    aktualisjatekos++;
                    if(aktualisjatekos>=jatekosok.size()){
                    aktualisjatekos=0;
                }
                    new GUI(this).setVisible(true);
                    dispose();
                }
                break;
                
            }
            case 4 :{
                int r=(int)(Math.random()*fenntarthatosagtanacs.length);
                new Tanacs(fenntarthatosagtanacs[r],"FenntarthatosagGUI.jpg",this);
                break;
            }
            case 5:{
                if (!gepi || aktualisjatekos==0){
                this.setEnabled(false);
                LottozoGUI lotto=new LottozoGUI(this);
                lotto.setVisible(true);
                }
                else{ //gép lotto
                    //feladott gen
                    int eddigi=0;
                    int feladott[]=new int[7];
                    for (int i=0;i<7;i++){
                        feladott[i]=(int)(Math.random()*35+1);  
                
                        for(int j=0;j<eddigi;j++){
                            while(feladott[i]==feladott[j]){
                            feladott[i]=(int)(Math.random()*35+1);
                            j=0;
                        }
                    }
                    eddigi++;
                    }
                    // huzás és ell
                    int nyere=(int)(Math.random()*10);
        if(nyere%3==0){ //Nem nyert semmit
            setTextJLabel("de nem nyert semmit");
        }
        else{
            int egyik=(int)(Math.random()*7); // A felhasználó által kiválasztott egyik szám mely benne lesz a lottohuzásban
            int masik=(int)(Math.random()*7);
            while(egyik==masik){
                masik=(int)(Math.random()*7);
            }
            int harmadik=(int)(Math.random()*7);
            while(egyik==harmadik || masik==harmadik){
                harmadik=(int)(Math.random()*7);
            }
            int lottoszamok[]=new int[feladott.length];
            lottoszamok[0]=feladott[egyik];
            lottoszamok[1]=feladott[masik];
            lottoszamok[2]=feladott[harmadik];
            eddigi=3;
            for (int i=3;i<feladott.length;i++){
                lottoszamok[i]=(int)(Math.random()*35+1);  
                for(int j=0;j<eddigi;j++){
                    while(lottoszamok[i]==lottoszamok[j]){
                        lottoszamok[i]=(int)(Math.random()*35+1);
                        j=0;
                    }
                }
                
            }
            int seged;
            
            
            for(int i=0;i<lottoszamok.length-1;i++){
                for(int j=i+1;j<lottoszamok.length;j++){
                    if(lottoszamok[i]>lottoszamok[j]){
                        seged=lottoszamok[i];
                        lottoszamok[i]=lottoszamok[j];
                        lottoszamok[j]=seged;
                    }
                }
            }

  
            int talalat=0;
            for (int i=0;i<lottoszamok.length;i++){
                for(int j=0;j<feladott.length;j++){
                    if (lottoszamok[i]==feladott[j]){
                        talalat++;
                       // break;
                    }
                }
            }
           
            
            switch (talalat){
                    case 3:{
                        setTextJLabel("+1.000 Ft");
                        jatekosok.get(aktualisjatekos).addPenz(1000);
                        break;
                    }
                    case 4:{
                        setTextJLabel("+10.000 Ft");
                        jatekosok.get(aktualisjatekos).addPenz(10000);
                        break;
                    }
                    case 5:{
                        setTextJLabel("+100.000 Ft");
                        jatekosok.get(aktualisjatekos).addPenz(100000);
                        break;
                    }
                    case 6:{
                        setTextJLabel("+1.000.000 Ft");
                        jatekosok.get(aktualisjatekos).addPenz(1000000);
                        break;
                    }
                    case 7:{
                        setTextJLabel("+10.000.000 Ft");
                        jatekosok.get(aktualisjatekos).addPenz(10000000);
                        break;
                    }
            }
        }
        aktualisjatekos++;
        if(aktualisjatekos>=jatekosok.size()){
            aktualisjatekos=0;
        }
        new GUI(this).setVisible(true);
        dispose();
                }
                break;
            }
            case 7: {
                //Ide 2 esemény 1 nem kap semmit, 2 nyert a szegény ember és te is kaptűl belőle
                int r=(int)(Math.random()*2);
                if (r==0){
                    setTextJLabel("A szegény ember nyert a lottón így a nyeremény egy része a tiéd: +1.000.000 Ft");
                    jatekosok.get(aktualisjatekos).addPenz(1000000);
                }
                aktualisjatekos++;
                if(aktualisjatekos>=jatekosok.size()){
            aktualisjatekos=0;
        }
        new GUI(this).setVisible(true);
                dispose();
         
                break;
            }
            case 8: {
                int r=(int)(Math.random()*100+100);
                jatekosok.get(aktualisjatekos).addPenz(r);
                setTextJLabel("+"+r+" Ft");
                aktualisjatekos++;
                if(aktualisjatekos>=jatekosok.size()){
                    aktualisjatekos=0;
                }
                
         new GUI(this).setVisible(true);
                dispose();
         
                break;
            }
            case 10:{
                int r=(int)(Math.random()*allattartastanacs.length);
                new Tanacs(allattartastanacs[r],"AllattartasHatter.jpg",this);
                break;
            }
            case 11:{
                new SzerencsekerekGUI(this).setVisible(true);
                break;
            }
            case 12:{
                int r=(int)(Math.random()*gazdasagtanacs.length);
                new Tanacs(gazdasagtanacs[r],"GazdasagHatter.png",this);
                break;
            }
            case 15:{
                int r=(int)(Math.random()*500+100);
                jatekosok.get(aktualisjatekos).addPenz(r);
                setTextJLabel("+"+r+" Ft");
                aktualisjatekos++;
                if(aktualisjatekos>=jatekosok.size()){
                    aktualisjatekos=0;
                }
                
        new GUI(this).setVisible(true);
                dispose();
      
                break;
            }
            case 16:{
                if (gepi && aktualisjatekos==1){
                    
                
                int r=(int)(Math.random()*2);
            if(r==0){
               
                    jatekosok.get(aktualisjatekos).addPenz(1000000);
                    jLabel2.setText("1.000.000 Ft");
                    aktualisjatekos++;
                    if(aktualisjatekos>=jatekosok.size()){
                        aktualisjatekos=0;
                    }
                    new GUI(this).setVisible(true);
                    setVisible(false);
                    dispose();
                  
                }
                
            
            else{
                jLabel2.setText("Nem nyert semmit");
                aktualisjatekos++;
                if(aktualisjatekos>=jatekosok.size()){
                    aktualisjatekos=0;
                }
                new GUI(this).setVisible(true);
                setVisible(false);
                dispose();
            }}
                else{
                new SportszeletGUI(this).setVisible(true);
                }
                
                break;
            }
            case 18 :{
                int r=(int)(Math.random()*fenntarthatosagtanacs.length);
                new Tanacs(fenntarthatosagtanacs[r],"FenntarthatosagGUI.jpg",this);
                break;
            }
            case 21:{
                int r=(int)(Math.random()*10000+5000);
                jatekosok.get(aktualisjatekos).addPenz(r);
                setTextJLabel("+"+r+" Ft");
                aktualisjatekos++;
                if(aktualisjatekos>=jatekosok.size()){
                    aktualisjatekos=0;
                }
                
         new GUI(this).setVisible(true);
                dispose();
       
                break;
            }
             
            default:{
                aktualisjatekos++;
                if(aktualisjatekos>=jatekosok.size()){
                    aktualisjatekos=0;
                }
                
        new GUI(this).setVisible(true);
                dispose();
         
                break;
            }
        }
        }
        
        
                
    }
    
    public void setTextJLabel(String s){jLabel2.setText(s);}
    
    public String[] Beolvas(String filenev) { // Hiba azzal hogy a t tömb nullára mutat
        Vector <String> v=new Vector <String>();
        String sor;
        BufferedReader br;
        try{
            br=new BufferedReader(new InputStreamReader(GUI.class.getResourceAsStream("/feliratok/"+filenev), "UTF8"));
         
            while((sor=br.readLine())!=null){
                v.add(sor);
            }
        }
        catch(Exception e){e.printStackTrace();}
        String t[]=new String [v.size()];
        for (int i=0;i<v.size();i++){
            t[i]=v.get(i);
        }
         return t;
         
    }
    
    public void QuizBeolvas(String s){
        BufferedReader br;
        
        String sor;
        try{
            br=new BufferedReader(new InputStreamReader(GUI.class.getResourceAsStream("/feliratok/"+s), "UTF8"));
            
            while((sor=br.readLine())!=null){
               
                String t[]=sor.split("\t");
                Quiz q;
                if(t.length==5){
                    q=new Quiz(t[0],t[1],t[2],t[3],t[4]);
                   
                }
                else  {
                    q=new Quiz(t[0],t[1],t[2]);  
                }
                quiz.add(q);
                
            }
            
        }
        catch(IOException e){
            System.out.println("hiba23");
        }
    }
    int i=0;
    public void Frissit(){
 
        DefaultMutableTreeNode jat=new DefaultMutableTreeNode("Játékosok");
        for (int i=0;i<jatekosok.size();i++){
            jatekosok.get(i).setKornyezetilabnyom((int)((jatekosok.get(i).getPont()/140)*100));
        }
       if (jatekosok.size()==2){
            DefaultMutableTreeNode n1=new DefaultMutableTreeNode(jatekosok.get(0).getNev()+" ("+jatekosok.get(0).getSzinM()+" játékos)");
            DefaultMutableTreeNode mezo1=new DefaultMutableTreeNode("Mező: "+Integer.toString(jatekosok.get(0).getMezo()+1));
            DefaultMutableTreeNode penz1=new DefaultMutableTreeNode("Bankszámla: "+Integer.toString(jatekosok.get(0).getPenz())+" Ft");
            DefaultMutableTreeNode pont1=new DefaultMutableTreeNode("Ökopont: "+Integer.toString(jatekosok.get(0).getPont()));
            n1.add(mezo1);n1.add(penz1);n1.add(pont1);
            DefaultMutableTreeNode n2=new DefaultMutableTreeNode(jatekosok.get(1).getNev()+" ("+jatekosok.get(1).getSzinM()+" játékos)");
            DefaultMutableTreeNode mezo2=new DefaultMutableTreeNode("Mező: "+Integer.toString(jatekosok.get(1).getMezo()+1));
            DefaultMutableTreeNode penz2=new DefaultMutableTreeNode("Bankszámla: "+Integer.toString(jatekosok.get(1).getPenz())+" Ft");
            DefaultMutableTreeNode pont2=new DefaultMutableTreeNode("Ökopont: "+Integer.toString(jatekosok.get(1).getPont()));
            n2.add(mezo2);n2.add(penz2);n2.add(pont2);jat.add(n1);jat.add(n2);
            
           
        }
        else if (jatekosok.size()==3){
            DefaultMutableTreeNode n1=new DefaultMutableTreeNode(jatekosok.get(0).getNev()+" ("+jatekosok.get(0).getSzinM()+" játékos)");
            DefaultMutableTreeNode mezo1=new DefaultMutableTreeNode("Mező: "+Integer.toString(jatekosok.get(0).getMezo()+1));
            DefaultMutableTreeNode penz1=new DefaultMutableTreeNode("Bankszámla: "+Integer.toString(jatekosok.get(0).getPenz())+" Ft");
            DefaultMutableTreeNode pont1=new DefaultMutableTreeNode("Ökopont: "+Integer.toString(jatekosok.get(0).getPont()));
            n1.add(mezo1);n1.add(penz1);n1.add(pont1);
            DefaultMutableTreeNode n2=new DefaultMutableTreeNode(jatekosok.get(1).getNev()+" ("+jatekosok.get(1).getSzinM()+" játékos)");
            DefaultMutableTreeNode mezo2=new DefaultMutableTreeNode("Mező: "+Integer.toString(jatekosok.get(1).getMezo()+1));
            DefaultMutableTreeNode penz2=new DefaultMutableTreeNode("Bankszámla: "+Integer.toString(jatekosok.get(1).getPenz())+" Ft");
            DefaultMutableTreeNode pont2=new DefaultMutableTreeNode("Ökopont: "+Integer.toString(jatekosok.get(1).getPont()));
            n2.add(mezo2);n2.add(penz2);n2.add(pont2);
            DefaultMutableTreeNode n3=new DefaultMutableTreeNode(jatekosok.get(2).getNev()+" ("+jatekosok.get(2).getSzinM()+" játékos)");
            DefaultMutableTreeNode mezo3=new DefaultMutableTreeNode("Mező: "+Integer.toString(jatekosok.get(2).getMezo()+1));
            DefaultMutableTreeNode penz3=new DefaultMutableTreeNode("Bankszámla: "+Integer.toString(jatekosok.get(2).getPenz())+" Ft");
            DefaultMutableTreeNode pont3=new DefaultMutableTreeNode("Ökopont: "+Integer.toString(jatekosok.get(2).getPont()));
            n3.add(mezo3);n3.add(penz3);n3.add(pont3);
            
            jat.add(n1);jat.add(n2);jat.add(n3);
            
        }
        else if (jatekosok.size()==4) {
            DefaultMutableTreeNode n1=new DefaultMutableTreeNode(jatekosok.get(0).getNev()+" ("+jatekosok.get(0).getSzinM()+" játékos)");
            DefaultMutableTreeNode mezo1=new DefaultMutableTreeNode("Mező: "+Integer.toString(jatekosok.get(0).getMezo()+1));
            DefaultMutableTreeNode penz1=new DefaultMutableTreeNode("Bankszámla: "+Integer.toString(jatekosok.get(0).getPenz())+" Ft");
            DefaultMutableTreeNode pont1=new DefaultMutableTreeNode("Ökopont: "+Integer.toString(jatekosok.get(0).getPont()));
            n1.add(mezo1);n1.add(penz1);n1.add(pont1);
            DefaultMutableTreeNode n2=new DefaultMutableTreeNode(jatekosok.get(1).getNev()+" ("+jatekosok.get(1).getSzinM()+" játékos)");
            DefaultMutableTreeNode mezo2=new DefaultMutableTreeNode("Mező: "+Integer.toString(jatekosok.get(1).getMezo()+1));
            DefaultMutableTreeNode penz2=new DefaultMutableTreeNode("Bankszámla: "+Integer.toString(jatekosok.get(1).getPenz())+" Ft");
            DefaultMutableTreeNode pont2=new DefaultMutableTreeNode("Ökopont: "+Integer.toString(jatekosok.get(1).getPont()));
            n2.add(mezo2);n2.add(penz2);n2.add(pont2);
            DefaultMutableTreeNode n3=new DefaultMutableTreeNode(jatekosok.get(2).getNev()+" ("+jatekosok.get(2).getSzinM()+" játékos)");
            DefaultMutableTreeNode mezo3=new DefaultMutableTreeNode("Mező: "+Integer.toString(jatekosok.get(2).getMezo()+1));
            DefaultMutableTreeNode penz3=new DefaultMutableTreeNode("Bankszámla: "+Integer.toString(jatekosok.get(2).getPenz())+" Ft");
            DefaultMutableTreeNode pont3=new DefaultMutableTreeNode("Ökopont: "+Integer.toString(jatekosok.get(2).getPont()));
            n3.add(mezo3);n3.add(penz3);n3.add(pont3);
            DefaultMutableTreeNode n4=new DefaultMutableTreeNode(jatekosok.get(3).getNev()+" ("+jatekosok.get(3).getSzinM()+" játékos)");
            DefaultMutableTreeNode mezo4=new DefaultMutableTreeNode("Mező: "+Integer.toString(jatekosok.get(3).getMezo()+1));
            DefaultMutableTreeNode penz4=new DefaultMutableTreeNode("Bankszámla: "+Integer.toString(jatekosok.get(3).getPenz())+" Ft");
            DefaultMutableTreeNode pont4=new DefaultMutableTreeNode("Ökopont: "+Integer.toString(jatekosok.get(3).getPont()));
            n4.add(mezo4);n4.add(penz4);n4.add(pont4);jat.add(n1);jat.add(n2);jat.add(n3);jat.add(n4);
        
        }
     
        model=new DefaultTreeModel(jat);
        jTree1.setModel(model);
       
        for (int i = 0; i < jTree1.getRowCount(); i++) {
            jTree1.expandRow(i);
        }
     
        i++;
      
    }
    public void Gep(){
        
        
         t=new Thread(new Runnable() {
            @Override
            public void run() {
                jButton1.setEnabled(false);
                String s="";
       if (!jatekosok.get(1).getBicikli() && jatekosok.get(1).getPenz()>10000){
           jatekosok.get(1).addPenz(-10000);
           jatekosok.get(1).setBicikli(true);
           jatekosok.get(1).addPont(30);
           s="Vásárolt";
       }
       if (!jatekosok.get(1).getAuto()&& jatekosok.get(1).getPenz()>5000000){
           jatekosok.get(1).addPenz(-5000000);
           jatekosok.get(1).setAuto(true);
           
           s="Vásárolt";
       }
       if (!jatekosok.get(1).getHaz().getVane() && jatekosok.get(1).getPenz()>15000000){
           jatekosok.get(1).addPenz(-15000000);
           jatekosok.get(1).getHaz().setVane(true);
           s="Vásárolt";
       }
       if (!jatekosok.get(1).getHaz().getHuto() && jatekosok.get(1).getPenz()>150000){
           jatekosok.get(1).addPenz(-150000);
           jatekosok.get(1).getHaz().setHuto(true);
           jatekosok.get(1).getHaz().setMikro(true);
           jatekosok.get(1).getHaz().setMosogato(true);
           jatekosok.get(1).getHaz().setMosogatogep(true);
           jatekosok.get(1).getHaz().setMosogep(true);
           s="Vásárolt";
       }
       if (!jatekosok.get(1).getHaz().getFurdoszoba()&& jatekosok.get(1).getPenz()>200000){
           jatekosok.get(1).addPenz(-200000);
           jatekosok.get(1).getHaz().setFurdoszoba(true);
           jatekosok.get(1).getHaz().setZuhanyzo(true);
           s="Vásárolt";
       }
       if (!jatekosok.get(1).getHaz().getButorok()&& jatekosok.get(1).getPenz()>500000){
           jatekosok.get(1).addPenz(-500000);
           jatekosok.get(1).getHaz().setButorok(true);
           jatekosok.get(1).getHaz().setFabutor(true);
           s="Vásárolt";
       }
       if (!jatekosok.get(1).getElektromos()&& jatekosok.get(1).getPenz()>10000000){
           jatekosok.get(1).addPenz(-10000000);
           jatekosok.get(1).setElektromos(true);
           jatekosok.get(1).addPont(50);
           s="Vásárolt";
       }
       if (!jatekosok.get(1).getHaz().getNapelem()&& jatekosok.get(1).getPenz()>20000000){
           jatekosok.get(1).addPenz(-20000000);
           jatekosok.get(1).getHaz().setNapelem(true);
           jatekosok.get(1).addPont(60);
           s="Vásárolt";
       }
        
       if (s.equals("Vásárolt")){
           jLabel2.setText(s);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
               
                 Kesz(Vege());}
       
       
                 Frissit();
                 jButton1.setEnabled(true);
                 jButton1.doClick();
              //   kilepes=true;
                 
                 }});
         t.start();
         if (kilepes){t.stop();kilepes=false;}
         
      
    }
    public JButton getJButton1(){return jButton1;}
    public JLabel getJLabel2(){return jLabel2;}
    public JLabel getJLabel3(){return jLabel3;}
    public JLabel getJLabel4(){return jLabel4;}
    public JPanel getJPanel2(){return jPanel2;}
    public void setBG(Color c){jPanel2.setBackground(c);}
   
    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables
}
