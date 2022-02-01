
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import javax.swing.JFrame;


public class SzerencsekerekGUI extends javax.swing.JFrame {

    int szog=0;
    Boolean mehet=false;
    Boolean kesz=false;
    int t;
    final int nyer[]={336,324,327,330,333,339};
    double lassulas=1;
    BufferedImage kerek;
    Graphics g;
    BufferedImage hatter;
    GUI gui;
    String szoveg;
    int index = 0;
    JFrame thisframe;
    public SzerencsekerekGUI() {
        try{
            
             kerek=ImageIO.read(SzerencsekerekGUI.class.getResource("/kepek/wheel8.png") );
             hatter=ImageIO.read(SzerencsekerekGUI.class.getResource("/kepek/SzerencsekerekGUI.jpg") );
           
        }catch(Exception e){
            
        }
        
        
        initComponents();
        
        
    }
    public SzerencsekerekGUI(GUI frame){
        gui=frame;
       
        try{
            kerek=ImageIO.read(SzerencsekerekGUI.class.getResource("/kepek/wheel8.png") );
             hatter=ImageIO.read(SzerencsekerekGUI.class.getResource("/kepek/SzerencsekerekGUI.jpg") );
        }catch(Exception e){
            
        }
        
        gui.setEnabled(false);
        if (gui.gepi && gui.aktualisjatekos==1){mehet=true;index=(int)(Math.random()*4); t=nyer[index];}
        initComponents();
        thisframe=this;
        
        setLocationRelativeTo(null);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel(){
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                Image newImage = hatter.getScaledInstance(853,476,Image.SCALE_DEFAULT);
                g.drawImage(newImage,0,0,null);
            }
        };
        jPanel1 = new javax.swing.JPanel(){
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                Image newImage = hatter.getScaledInstance(853,476,Image.SCALE_DEFAULT);
                g.drawImage(newImage,0,0,null);
                Image kerek2 = kerek.getScaledInstance(476,476,Image.SCALE_DEFAULT);
                AffineTransform at= AffineTransform.getTranslateInstance((jPanel2.getWidth()/2)-(476/2),(jPanel2.getHeight()/2)-(476/2));
                if(mehet && t>=0){
                    at.rotate(Math.toRadians(szog)+lassulas, 476/2, 476/2);
                    if(t!=0){
                        lassulas+=t*(0.001);
                        t--;
                    }
                    else{

                        try{TimeUnit.SECONDS.sleep(3);}catch(Exception e){}
                        int r2;
                        switch(index){
                            case 0:{
                                if(gui.jatekosok.get(gui.aktualisjatekos).getElektromos()){
                                    gui.jatekosok.get(gui.aktualisjatekos).addPenz(5000000);
                                    szoveg="elektromos autót nyert volna de már van neki, így megkapta az árát";
                                }
                                else{
                                    gui.jatekosok.get(gui.aktualisjatekos).setAuto(true);
                                    gui.jatekosok.get(gui.aktualisjatekos).setElektromos(true);
                                    gui.jatekosok.get(gui.aktualisjatekos).addPont(50);
                                    szoveg="elektromos autót nyert";
                                }
                                gui.setTextJLabel(szoveg);
                                gui.aktualisjatekos++;
                                if(gui.aktualisjatekos>=gui.jatekosok.size()){
                                    gui.aktualisjatekos=0;
                                }
                                new GUI(gui).setVisible(true);
                                gui.dispose();
                                dispose();
                                break;
                            }
                            case 1:{
                                gui.jatekosok.get(gui.aktualisjatekos).addPenz(1000000);
                                szoveg="+1.000.000 Ft";
                                gui.setTextJLabel(szoveg);
                                gui.aktualisjatekos++;
                                if(gui.aktualisjatekos>=gui.jatekosok.size()){
                                    gui.aktualisjatekos=0;
                                }
                                new GUI(gui).setVisible(true);
                                gui.dispose();
                                dispose();
                                break;
                            }
                            case 2:{
                                gui.jatekosok.get(gui.aktualisjatekos).addPont(100);
                                szoveg="+100 Ökopont";
                                gui.setTextJLabel(szoveg);
                                gui.aktualisjatekos++;
                                if(gui.aktualisjatekos>=gui.jatekosok.size()){
                                    gui.aktualisjatekos=0;
                                }
                                new GUI(gui).setVisible(true);
                                gui.dispose();
                                dispose();
                                break;
                            }
                            case 3:{
                                if (!gui.jatekosok.get(gui.aktualisjatekos).getHaz().getVane() || gui.jatekosok.get(gui.aktualisjatekos).getHaz().getHuto()){
                                    gui.jatekosok.get(gui.aktualisjatekos).addPenz(150000);
                                    gui.setTextJLabel("Megnyerte a háztartási eszközök árát");
                                }
                                else{
                                    gui.jatekosok.get(gui.aktualisjatekos).getHaz().setHuto(true);
                                    gui.jatekosok.get(gui.aktualisjatekos).getHaz().setMikro(true);
                                    gui.jatekosok.get(gui.aktualisjatekos).getHaz().setMosogato(true);
                                    gui.jatekosok.get(gui.aktualisjatekos).getHaz().setMosogatogep(true);
                                    gui.jatekosok.get(gui.aktualisjatekos).getHaz().setMosogep(true);
                                    gui.setTextJLabel("Háztartási eszközöket nyert");
                                }
                                new GUI(gui).setVisible(true);
                                gui.dispose();
                                dispose();
                                break; //Háztartási
                            }
                            case 4:{
                                int r=(int)(Math.random()*4);
                                switch (r){
                                    case 0:{
                                        r2=(int)(Math.random()*gui.allattartastanacs.length);
                                        new Tanacs(gui.allattartastanacs[r2],"AllattartasHatter.jpg",gui).setVisible(true);
                                        break;
                                    }
                                    case 1:{
                                        r2=(int)(Math.random()*gui.fenntarthatosagtanacs.length);
                                        new Tanacs(gui.fenntarthatosagtanacs[r2],"FenntarthatosagGUI.jpg",gui).setVisible(true);
                                        break;
                                    }
                                    case 2:{
                                        r2=(int)(Math.random()*gui.gazdasagtanacs.length);
                                        new Tanacs(gui.gazdasagtanacs[r2],"GazdasagHatter.png",gui).setVisible(true);
                                        break;
                                    }
                                    case 3:{
                                        r2=(int)(Math.random()*gui.kornyezetvedelemtanacs.length);
                                        new Tanacs(gui.kornyezetvedelemtanacs[r2],"KornyezetvedelemHatter.jpg",gui).setVisible(true);
                                        break;
                                    }
                                }
                                break; //jó tanács
                            }
                            case 5:{
                                int rq=(int)(Math.random()*gui.quiz.size());
                                QuizGUI qgui=new QuizGUI(gui.quiz.get(rq),gui);

                                break; //Quiz
                            }
                        }
                        kesz=true;

                        dispose();
                    }
                }
                Graphics2D g2d=(Graphics2D) g;
                g2d.setBackground(java.awt.Color.white);
                g2d.drawImage(kerek2,at,null);
                repaint();
                g2d.setColor(Color.cyan);
                g2d.setStroke(new BasicStroke(10));
                g2d.drawPolygon(new int [] {650,700,700}, new int [] {238,220,256}, 3);
                g.setColor(Color.blue);
                g.fillPolygon(new int [] {650,700,700}, new int [] {238,220,256}, 3);
            }
        };

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(853, 476));
        setMinimumSize(new java.awt.Dimension(853, 476));
        setUndecorated(true);

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 853, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 476, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        if(!mehet){
        int veletlen=(int)(Math.random()*100);
        
        if(veletlen==0 || veletlen==99){
            t=nyer[0];
        }
        else {
            index=(int)(Math.random()*5+1);
            t=nyer[index];
        }
        
        
        mehet=true; 
        }
        
    }//GEN-LAST:event_jPanel1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(SzerencsekerekGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SzerencsekerekGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SzerencsekerekGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SzerencsekerekGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SzerencsekerekGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
