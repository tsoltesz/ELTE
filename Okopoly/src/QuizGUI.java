
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
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
public class QuizGUI extends javax.swing.JFrame {

    BufferedImage hatter;
    Quiz quiz;
    GUI gui;
    Boolean vege=false;
    
    public QuizGUI() {
        initComponents();
    }
    public QuizGUI(Quiz q, GUI f){
        gui=f;
        quiz=q;
        gui.setEnabled(false);
        gui.setVisible(true);
        try{
    
            hatter=ImageIO.read(QuizGUI.class.getResource("/kepek/quizGUI.jpg"));
        }
        catch(Exception e){
        
        }
        initComponents();
        
        jButton2.setBackground(Color.yellow);
        jButton3.setBackground(Color.yellow);
        jButton4.setBackground(Color.yellow);
        jButton5.setBackground(Color.yellow);
        
        jTextArea1.setText(quiz.getKerdes());
        if(quiz.rosszvalasz2!=null){
            String valaszok[]={quiz.jovalasz,quiz.rosszvalasz1,quiz.rosszvalasz2,quiz.rosszvalasz3};
            
            int szamok[]={0,1,2,3};
            //Elso valasz
            int r=(int)(Math.random()*4);
            jButton2.setText(valaszok[szamok[r]]);
            for(int i=r;i<szamok.length-1;i++){
                szamok[i]=szamok[i+1];
            }
            //masodik valasz
            r=(int)(Math.random()*3);
            jButton3.setText(valaszok[szamok[r]]);
            for(int i=r;i<szamok.length-2;i++){
                szamok[i]=szamok[i+1];
            }
            //harmadik valasz
            r=(int)(Math.random()*2);
            jButton4.setText(valaszok[szamok[r]]);
            for(int i=r;i<szamok.length-3;i++){
                szamok[i]=szamok[i+1];
            }
            //negyedik valasz
            jButton5.setText(valaszok[szamok[0]]);
        }
        else {
            String valaszok[]={quiz.jovalasz,quiz.rosszvalasz1};
            int r=(int)(Math.random()*2);
            if(r==1){
                jButton2.setText(valaszok[0]);
                jButton3.setText(valaszok[1]);
                
            }
            else {
                jButton3.setText(valaszok[0]);
                jButton2.setText(valaszok[1]);
            }
            jButton4.setVisible(false);
            jButton5.setVisible(false);
            
        }
        setLocationRelativeTo(null);
        setVisible(true);
       
        
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
                Image newImage = hatter.getScaledInstance(853,476,Image.SCALE_DEFAULT);
                g.drawImage(newImage,0,0,null);
            }

        };
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(853, 476));
        setMinimumSize(new java.awt.Dimension(853, 476));
        setUndecorated(true);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jPanel1.setMaximumSize(new java.awt.Dimension(853, 476));
        jPanel1.setMinimumSize(new java.awt.Dimension(853, 476));

        jButton4.setText("jButton4");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("jButton5");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("jButton3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(240, 240, 240));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextArea1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(74, 74, 74))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (!vege){
        jButton2.setBackground(Color.yellow);
        try{TimeUnit.SECONDS.sleep(1);}catch(Exception e){}
        if(quiz.Helyese(jButton2.getText())){
            jButton2.setBackground(Color.green);
            gui.jatekosok.get(gui.aktualisjatekos).addPont(5);
            gui.setTextJLabel("+5 ??kopont");
        }
        else {
            jButton2.setBackground(Color.red);
            gui.setTextJLabel("A quiz k??rd??sre helytelen??l v??laszolt");
            HelyesKeres();
            
        }
        vege=true;
        }
        else{
            try{TimeUnit.SECONDS.sleep(1);}catch(Exception e){}
            gui.setEnabled(true);
            gui.setVisible(true);
            dispose();
            
        }
        
        
        
       
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        if (vege){
            new GUI(gui).setVisible(true);
           
            dispose();
        }
    }//GEN-LAST:event_formMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       if(!vege){
        jButton3.setBackground(Color.yellow);
        try{TimeUnit.SECONDS.sleep(1);}catch(Exception e){}
        if(quiz.Helyese(jButton3.getText())){
            jButton3.setBackground(Color.green);
            gui.jatekosok.get(gui.aktualisjatekos).addPont(5);
        }
        else {
            jButton3.setBackground(Color.red);
            HelyesKeres();
            
        }
        vege=true;
       }
        else{
            try{TimeUnit.SECONDS.sleep(1);}catch(Exception e){}
            new GUI(gui).setVisible(true);
           
            dispose();
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(!vege){
        jButton4.setBackground(Color.yellow);
        try{TimeUnit.SECONDS.sleep(1);}catch(Exception e){}
        if(quiz.Helyese(jButton4.getText())){
            jButton4.setBackground(Color.green);
            gui.jatekosok.get(gui.aktualisjatekos).addPont(5);
        }
        else {
            jButton4.setBackground(Color.red);
            HelyesKeres();
            
        }
        vege=true;
        }
        else{
            try{TimeUnit.SECONDS.sleep(1);}catch(Exception e){}
           new GUI(gui).setVisible(true);
           
            dispose();
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if(!vege){
        jButton5.setBackground(Color.yellow);
        try{TimeUnit.SECONDS.sleep(1);}catch(Exception e){}
        if(quiz.Helyese(jButton5.getText())){
            jButton5.setBackground(Color.green);
            gui.jatekosok.get(gui.aktualisjatekos).addPont(5);
        }
        else {
            jButton5.setBackground(Color.red);
            HelyesKeres();
            
        }
        vege=true;
        }
        else{
            try{TimeUnit.SECONDS.sleep(1);}catch(Exception e){}
            new GUI(gui).setVisible(true);
           
            dispose();
        }
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextArea1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextArea1MouseClicked
        if (vege){
            
            new GUI(gui).setVisible(true);
           
            dispose();
        }
    }//GEN-LAST:event_jTextArea1MouseClicked

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
            java.util.logging.Logger.getLogger(QuizGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuizGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuizGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuizGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuizGUI().setVisible(true);
            }
        });
    }
    public void HelyesKeres(){
        if(quiz.Helyese(jButton2.getText())){
            jButton2.setBackground(Color.green);
        }
        else if (quiz.Helyese(jButton3.getText())){
            jButton3.setBackground(Color.green);
        }
        else if(quiz.Helyese(jButton4.getText())){
            jButton4.setBackground(Color.green);
        }
        else if (quiz.Helyese(jButton5.getText())){
            jButton5.setBackground(Color.green);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
