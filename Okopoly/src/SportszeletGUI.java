
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import static java.lang.Math.sqrt;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TeszTa
 */
public class SportszeletGUI extends javax.swing.JFrame {

    BufferedImage hatter;
    Graphics g;
    int regix, regiy, ujx, ujy;
    Boolean baloldal=false;
    Boolean jobboldal=false;
    GUI gui;
    public SportszeletGUI() {
        try{
            hatter=ImageIO.read(SportszeletGUI.class.getResource("sportszeletGUI.png") );
            
        }
        catch(Exception e){
        
        }
        
        initComponents();
        g=jPanel1.getGraphics();
        setLocationRelativeTo(null);
    }
    public SportszeletGUI(GUI f) {
        gui=f;
        gui.setEnabled(false);
        try{
             hatter=ImageIO.read(SportszeletGUI.class.getResource("/kepek/sportszeletGUI.png") );
        }
        catch(Exception e){
        
        }
        
        initComponents();
        g=jPanel1.getGraphics();
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

        jPanel1 = new javax.swing.JPanel(){
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                Image newImage = hatter.getScaledInstance(600,500,Image.SCALE_DEFAULT);
                g.drawImage(newImage,125,0,null);
            }

        };
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(853, 476));
        setMinimumSize(new java.awt.Dimension(853, 476));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 102, 51));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel1MouseReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Menj végig a vonalon, miközben nyomva tartod a bal egérgombot. Ezzel kinyitod a csokit");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 734, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addContainerGap(416, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        ujx=evt.getX();
        ujy=evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        jLabel1.setText("Menj végig a vonalon, miközben nyomva tartod a bal egérgombot. Ezzel kinyitod a csokit");
        
        if(evt.getX()>140 && evt.getX()<710 && evt.getY()>240 && evt.getY()<260){
        this.regix=ujx;
        this.regiy=ujy;
        this.ujx=evt.getX();
        this.ujy=evt.getY();
        if (ujx<150 && ujx>140){
            baloldal=true;
            
        }
        if (ujx<710 && ujx>700){
            jobboldal=true;
            
        }
        if(jobboldal && baloldal){
            //ide hogy nyert vagy nem nyert
            setEnabled(false);
            int r=(int)(Math.random()*2);
            if(r==0){
                r=(int)(Math.random()*2);
                if (r==0){
                    gui.jatekosok.get(gui.aktualisjatekos).addPenz(1000000);
                    gui.setTextJLabel("1.000.000 Ft");
                    try{TimeUnit.SECONDS.sleep(1);}catch(Exception e){}
                    gui.aktualisjatekos++;
                    if(gui.aktualisjatekos>=gui.jatekosok.size()){
                        gui.aktualisjatekos=0;
                    }
                    new GUI(gui).setVisible(true);
                    setVisible(false);
                    gui.dispose();
                    dispose();
                }
                else{
                    gui.setTextJLabel("Nyert egy másik Sportszeletet");
                    try{TimeUnit.SECONDS.sleep(1);}catch(Exception e){}
                    new SportszeletGUI(gui).setVisible(true);
                    setVisible(false);
                    dispose();
                }
            }
            else{
                gui.setTextJLabel("Nem nyert semmit");
                try{TimeUnit.SECONDS.sleep(1);}catch(Exception e){}
                gui.aktualisjatekos++;
                if(gui.aktualisjatekos>=gui.jatekosok.size()){
                    gui.aktualisjatekos=0;
                }
                new GUI(gui).setVisible(true);
                setVisible(false);
                gui.dispose();
                dispose();
            }
            
        }
        else {
       
        for (int i=0;i<=tav(ujx,ujy,regix,regiy)+3;i++){
            double xx=(i*ujx+(tav(ujx,ujy,regix,regiy)+3-i)*regix)/(double)(tav(ujx,ujy,regix,regiy)+3);
            double yy=(i*ujy+(tav(ujx,ujy,regix,regiy)+3-i)*regiy)/(double)(tav(ujx,ujy,regix,regiy)+3);
            g.drawOval((int)xx, (int)yy, 5, 5);
        }
        
        }
        }
        else{
            Image newImage = hatter.getScaledInstance(600,500,Image.SCALE_DEFAULT);
            g.drawImage(newImage,125,0,null);
            jobboldal=false;
            baloldal=false;
        }
    
        
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseReleased

            Image newImage = hatter.getScaledInstance(600,500,Image.SCALE_DEFAULT);
            g.drawImage(newImage,125,0,null);
            jobboldal=false;
            baloldal=false;
    }//GEN-LAST:event_jPanel1MouseReleased

    static int tav(int x1, int y1, int x2,int y2){
        return (int) sqrt((double) ((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2)));
    }
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
            java.util.logging.Logger.getLogger(SportszeletGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SportszeletGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SportszeletGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SportszeletGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SportszeletGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}