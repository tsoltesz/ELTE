
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class KezdoGUI extends javax.swing.JFrame {
     boolean kekklikk;
     boolean  pirosklikk;
     Jatekos k[];
     String nev1, nev2, kar1,kar2;
            int elet1,elet2,pajzs1, pajzs2,fegyver1,fegyver2,mod1,mod2,hely1,hely2,hanykor1,hanykor2;
            Boolean harc1,harc2,kikerul1,kikerul2;
            int kor;
    public KezdoGUI() {
        pirosklikk=false;
        kekklikk=false;
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/kepek/ikon.png")).getImage());
        
        if (!betoltes()){
            jButton4.setEnabled(false);
        }
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField6 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jTextField18 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        setMinimumSize(new java.awt.Dimension(1000, 729));
        setName("Lap"); // NOI18N
        setUndecorated(true);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });
        getContentPane().setLayout(null);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kepek/pipa.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setFocusable(false);
        jButton1.setEnabled(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jButton1KeyReleased(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(742, 540, 37, 37);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kepek/pipa.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setFocusable(false);
        jButton2.setEnabled(false);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jButton2KeyReleased(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(297, 539, 37, 37);

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(36, 41, 44));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 8)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("Katona!\nKékke/Piroska Tábornagy inna\negy jó feketét, de nincs\nhozzá cukor a támaszpontján. \nAz Ön és egysége feladata,\nhogyezt a csomagot átjutassa \nhozzá.Indulás!\nCél: juss át a fossztogatókon, \ndezertőrökön keresztűl a túl-\noldalra,és add át a Koronnás \nkristálycukor csomagot.\n");
        jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextArea1KeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(400, 540, 180, 160);

        jTextField6.setEditable(false);
        jTextField6.setBackground(new java.awt.Color(36, 41, 44));
        jTextField6.setForeground(new java.awt.Color(255, 255, 255));
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField6.setText("1000");
        jTextField6.setBorder(null);
        getContentPane().add(jTextField6);
        jTextField6.setBounds(90, 350, 30, 20);

        jTextField5.setEditable(false);
        jTextField5.setBackground(new java.awt.Color(36, 41, 44));
        jTextField5.setForeground(new java.awt.Color(255, 255, 255));
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.setText("100");
        jTextField5.setBorder(null);
        getContentPane().add(jTextField5);
        jTextField5.setBounds(130, 350, 20, 20);

        jTextField7.setEditable(false);
        jTextField7.setBackground(new java.awt.Color(36, 41, 44));
        jTextField7.setForeground(new java.awt.Color(255, 255, 255));
        jTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField7.setText("60");
        jTextField7.setBorder(null);
        getContentPane().add(jTextField7);
        jTextField7.setBounds(162, 350, 30, 20);

        jTextField8.setEditable(false);
        jTextField8.setBackground(new java.awt.Color(36, 41, 44));
        jTextField8.setForeground(new java.awt.Color(255, 255, 255));
        jTextField8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField8.setText("100");
        jTextField8.setBorder(null);
        getContentPane().add(jTextField8);
        jTextField8.setBounds(202, 350, 20, 20);

        jTextField9.setEditable(false);
        jTextField9.setBackground(new java.awt.Color(36, 41, 44));
        jTextField9.setForeground(new java.awt.Color(255, 255, 255));
        jTextField9.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField9.setText("2000");
        jTextField9.setBorder(null);
        getContentPane().add(jTextField9);
        jTextField9.setBounds(313, 350, 30, 20);

        jTextField10.setEditable(false);
        jTextField10.setBackground(new java.awt.Color(36, 41, 44));
        jTextField10.setForeground(new java.awt.Color(255, 255, 255));
        jTextField10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField10.setText("200");
        jTextField10.setBorder(null);
        getContentPane().add(jTextField10);
        jTextField10.setBounds(350, 350, 30, 20);

        jTextField11.setEditable(false);
        jTextField11.setBackground(new java.awt.Color(36, 41, 44));
        jTextField11.setForeground(new java.awt.Color(255, 255, 255));
        jTextField11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField11.setText("30");
        jTextField11.setBorder(null);
        getContentPane().add(jTextField11);
        jTextField11.setBounds(390, 350, 20, 20);

        jTextField12.setEditable(false);
        jTextField12.setBackground(new java.awt.Color(36, 41, 44));
        jTextField12.setForeground(new java.awt.Color(255, 255, 255));
        jTextField12.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField12.setText("50");
        jTextField12.setBorder(null);
        getContentPane().add(jTextField12);
        jTextField12.setBounds(420, 350, 30, 20);

        jTextField13.setEditable(false);
        jTextField13.setBackground(new java.awt.Color(36, 41, 44));
        jTextField13.setForeground(new java.awt.Color(255, 255, 255));
        jTextField13.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField13.setText("2000");
        jTextField13.setBorder(null);
        getContentPane().add(jTextField13);
        jTextField13.setBounds(533, 350, 30, 20);

        jTextField14.setEditable(false);
        jTextField14.setBackground(new java.awt.Color(36, 41, 44));
        jTextField14.setForeground(new java.awt.Color(255, 255, 255));
        jTextField14.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField14.setText("200");
        jTextField14.setBorder(null);
        getContentPane().add(jTextField14);
        jTextField14.setBounds(575, 350, 20, 20);

        jTextField15.setEditable(false);
        jTextField15.setBackground(new java.awt.Color(36, 41, 44));
        jTextField15.setForeground(new java.awt.Color(255, 255, 255));
        jTextField15.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField15.setText("30");
        jTextField15.setToolTipText("");
        jTextField15.setBorder(null);
        getContentPane().add(jTextField15);
        jTextField15.setBounds(610, 350, 20, 20);

        jTextField16.setEditable(false);
        jTextField16.setBackground(new java.awt.Color(36, 41, 44));
        jTextField16.setForeground(new java.awt.Color(255, 255, 255));
        jTextField16.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField16.setText("50");
        jTextField16.setBorder(null);
        getContentPane().add(jTextField16);
        jTextField16.setBounds(645, 350, 20, 20);

        jTextField17.setEditable(false);
        jTextField17.setBackground(new java.awt.Color(36, 41, 44));
        jTextField17.setForeground(new java.awt.Color(255, 255, 255));
        jTextField17.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField17.setText("1000");
        jTextField17.setBorder(null);
        getContentPane().add(jTextField17);
        jTextField17.setBounds(775, 350, 30, 20);

        jTextField18.setEditable(false);
        jTextField18.setBackground(new java.awt.Color(36, 41, 44));
        jTextField18.setForeground(new java.awt.Color(255, 255, 255));
        jTextField18.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField18.setText("100");
        jTextField18.setToolTipText("");
        jTextField18.setBorder(null);
        getContentPane().add(jTextField18);
        jTextField18.setBounds(815, 350, 20, 20);

        jTextField19.setEditable(false);
        jTextField19.setBackground(new java.awt.Color(36, 41, 44));
        jTextField19.setForeground(new java.awt.Color(255, 255, 255));
        jTextField19.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField19.setText("60");
        jTextField19.setBorder(null);
        getContentPane().add(jTextField19);
        jTextField19.setBounds(852, 350, 20, 20);

        jTextField20.setEditable(false);
        jTextField20.setBackground(new java.awt.Color(36, 41, 44));
        jTextField20.setForeground(new java.awt.Color(255, 255, 255));
        jTextField20.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField20.setText("100");
        jTextField20.setBorder(null);
        getContentPane().add(jTextField20);
        jTextField20.setBounds(887, 350, 20, 20);

        jTextField1.setBackground(new java.awt.Color(36, 41, 44));
        jTextField1.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("Ird ide a neved!");
        jTextField1.setBorder(null);
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(113, 285, 91, 32);

        jTextField2.setBackground(new java.awt.Color(36, 41, 44));
        jTextField2.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("Írd ide a neved!");
        jTextField2.setBorder(null);
        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField2MouseClicked(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField2);
        jTextField2.setBounds(335, 285, 92, 32);

        jTextField3.setBackground(new java.awt.Color(36, 41, 44));
        jTextField3.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(255, 255, 255));
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setText("írd ide a neved!");
        jTextField3.setBorder(null);
        jTextField3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField3MouseClicked(evt);
            }
        });
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField3KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField3KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField3);
        jTextField3.setBounds(554, 285, 92, 33);

        jTextField4.setBackground(new java.awt.Color(36, 41, 44));
        jTextField4.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(255, 255, 255));
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setText("Írd ide a neved!");
        jTextField4.setBorder(null);
        jTextField4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField4MouseClicked(evt);
            }
        });
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField4KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField4KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField4KeyTyped(evt);
            }
        });
        getContentPane().add(jTextField4);
        jTextField4.setBounds(798, 285, 90, 32);

        jButton3.setBackground(new java.awt.Color(36, 41, 44));
        jButton3.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("SIR, JES, SIR!");
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setEnabled(false);
        jButton3.setFocusable(false);
        jButton3.setPreferredSize(new java.awt.Dimension(830, 20));
        jButton3.setRolloverEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(85, 45, 830, 20);

        jButton4.setBackground(new java.awt.Color(102, 102, 102));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Mentett játék betöltése");
        jButton4.setMargin(new java.awt.Insets(2, 0, 2, 0));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(803, 690, 180, 21);

        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2);
        jLabel2.setBounds(216, 534, 40, 40);

        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3);
        jLabel3.setBounds(660, 540, 40, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kepek/karaktervalaszto.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jLabel1KeyReleased(evt);
            }
        });
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1000, 730);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        if (evt.getKeyCode()==27){
            System.exit(0);}
    }//GEN-LAST:event_formKeyReleased

    private void jLabel1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel1KeyReleased
       if (evt.getKeyCode()==27){
            System.exit(0);}
    }//GEN-LAST:event_jLabel1KeyReleased

    private void jButton1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyReleased
        if (evt.getKeyCode()==27){
            System.exit(0);}
    }//GEN-LAST:event_jButton1KeyReleased

    private void jTextArea1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyReleased
        if (evt.getKeyCode()==27){
            System.exit(0);}
    }//GEN-LAST:event_jTextArea1KeyReleased

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
      if (!pirosklikk){
        jTextField1.setText(null);       
        if (jTextField1.getText().length()==0 && jTextField2.getText().length()==0){
        jButton2.setFocusable(false);
        jButton2.setEnabled(false); // nem erre gondoltál?
        jButton2.setBorderPainted(false);
        }
    }
    }//GEN-LAST:event_jTextField1MouseClicked

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked
        if (!pirosklikk){
        jTextField2.setText(null);
        if (jTextField1.getText().length()==0 && jTextField2.getText().length()==0){
        jButton2.setFocusable(false);
        jButton2.setEnabled(false); // nem erre gondoltál?
        jButton2.setBorderPainted(false);
        }
    }
    }//GEN-LAST:event_jTextField2MouseClicked

    private void jTextField3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField3MouseClicked
        if (!kekklikk){
        jTextField3.setText(null);
        if (jTextField3.getText().length()==0 && jTextField4.getText().length()==0){
        jButton1.setFocusable(false);
        jButton1.setEnabled(false); // nem erre gondoltál?
        jButton1.setBorderPainted(false);
        }
    }
    }//GEN-LAST:event_jTextField3MouseClicked

    private void jTextField4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField4MouseClicked
        if (!kekklikk){
        jTextField4.setText(null);
        if (jTextField3.getText().length()==0 && jTextField4.getText().length()==0){
        jButton1.setFocusable(false);
        jButton1.setEnabled(false); // nem erre gondoltál?
        jButton1.setBorderPainted(false);
        }
        }
    }//GEN-LAST:event_jTextField4MouseClicked

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
    if (jTextField1.getText().length()==0 && jTextField2.getText().length()==0){
        jButton2.setFocusable(false);
        jButton2.setEnabled(false); // nem erre gondoltál?
        jButton2.setBorderPainted(false);
        jTextField1.setEditable(true);
       
    }
    else{
        if(jTextField1.getText().length()>=12)
    {
        jTextField1.setText(jTextField1.getText().substring(0,12));
        jTextField1.setEditable(false);
    }
        else{
            jTextField1.setEditable(true);
        }
         jTextField2.setText(null);
         jButton2.setFocusable(true);
         jButton2.setEnabled(true);
         jButton2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 0)));
         jButton2.setBorderPainted(true);
    }
    
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        if (jTextField1.getText().length()==0 && jTextField2.getText().length()==0){
        jButton2.setFocusable(false);
        jButton2.setEnabled(false); // nem erre gondoltál?
        jButton2.setBorderPainted(false);
    }
        else {
        
        if(jTextField2.getText().length()>=12)
    {
        jTextField2.setText(jTextField2.getText().substring(0,12));
        jTextField2.setEditable(false);
    }
        else{
            jTextField2.setEditable(true);
        }
        jTextField1.setText(null);
        jButton2.setFocusable(true);
        jButton2.setEnabled(true);
        jButton2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 0)));
        jButton2.setBorderPainted(true);
        }
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jTextField3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyTyped
      if (jTextField3.getText().length()==0 && jTextField4.getText().length()==0){
        jButton1.setFocusable(false);
        jButton1.setEnabled(false); // nem erre gondoltál?
        jButton1.setBorderPainted(false);
    }
      else {
        
        if(jTextField3.getText().length()>=12)
    {
        jTextField3.setText(jTextField3.getText().substring(0,12));
        jTextField3.setEditable(false);
    }
        else {
            jTextField3.setEditable(true);
        }
        jTextField4.setText(null);
        jButton1.setFocusable(true);
        jButton1.setEnabled(true);
        jButton1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 0)));
        jButton1.setBorderPainted(true);
      }
    }//GEN-LAST:event_jTextField3KeyTyped

    private void jTextField4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyTyped
        if (jTextField3.getText().length()==0 && jTextField4.getText().length()==0){
        jButton1.setFocusable(false);
        jButton1.setEnabled(false); // nem erre gondoltál?
        jButton1.setBorderPainted(false);
    }
        else {
        
        
        if(jTextField4.getText().length()>=12)
    {
        jTextField4.setText(jTextField4.getText().substring(0,12));
        jTextField4.setEditable(false);
    }
        else {
            jTextField1.setEditable(true);
        }
        jTextField3.setText(null);
        jButton1.setFocusable(true);
        jButton1.setEnabled(true);
        jButton1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 0)));
        jButton1.setBorderPainted(true);
        }
    }//GEN-LAST:event_jTextField4KeyTyped

    // ___________________________ A kövi résszel szerettem volna indítani a játék képernyőt _____________________________//
    
    
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
            if ((!jTextField1.getText().equals(jTextField3.getText()) || jTextField1.getText().equals("")) && (!jTextField2.getText().equals(jTextField3.getText()) || jTextField2.getText().equals("")) && (!jTextField1.getText().equals(jTextField4.getText()) || jTextField1.getText().equals("")) && (!jTextField2.getText().equals(jTextField4.getText()) || jTextField2.getText().equals(""))){
            jButton1.setBackground(Color.black);
            
            jTextField3.setEditable(false);
            jTextField4.setEditable(false);
            if (pirosklikk){jButton3.setEnabled(true);}
            kekklikk = true;
            jButton1.setIcon(null);
        }
        
    }//GEN-LAST:event_jButton1MouseClicked

    /*if (pirosklikk=true && kekklikk=true){
            new GUI().setVisible(true);
            setVisible(false);
            dispose();}*/
//_________________________________________________________________________________________________________________________//
    
    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        if (evt.getKeyCode()==27){
            System.exit(0);}
        
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        if (evt.getKeyCode()==27){
            System.exit(0);}
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        if (evt.getKeyCode()==27){
            System.exit(0);}
    }//GEN-LAST:event_jTextField3KeyReleased

    private void jTextField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyReleased
        if (evt.getKeyCode()==27){
            System.exit(0);}
    }//GEN-LAST:event_jTextField4KeyReleased

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
       if (evt.getKeyCode()==8){
           jTextField1.setEditable(true);
       }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
        if (evt.getKeyCode()==8){
           jTextField2.setEditable(true);
       }
    }//GEN-LAST:event_jTextField2KeyPressed

    private void jTextField3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyPressed
        if (evt.getKeyCode()==8){
           jTextField3.setEditable(true);
       }
    }//GEN-LAST:event_jTextField3KeyPressed

    private void jTextField4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyPressed
        if (evt.getKeyCode()==8){
           jTextField4.setEditable(true);
       }
    }//GEN-LAST:event_jTextField4KeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       
        if (pirosklikk && kekklikk){
            Jatekos j1, j2;
            if (jTextField1.getText().equals("")){
                j1=new Jatekos(jTextField2.getText(),getClass().getResource("/kepek/piros2"),2,133);
                
                
            }
            else{
                j1=new Jatekos(jTextField1.getText(),getClass().getResource("/kepek/piros1"),1,133);
            }
            
            if (jTextField3.getText().equals("")){
                j2=new Jatekos(jTextField4.getText(),getClass().getResource("/kepek/kek2"),2,-1);
                

            }
            else{
                j2=new Jatekos(jTextField3.getText(),getClass().getResource("/kepek/kek1"),1,-1);
            }
            
            
            
            TablaGUI t;
            try {
                t = new TablaGUI(j2,j1,0);
                t.setVisible(true);
                dispose();
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(KezdoGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyReleased
        if (evt.getKeyCode()==27){
            System.exit(0);}
    }//GEN-LAST:event_jButton2KeyReleased

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked

        if ((!jTextField1.getText().equals(jTextField3.getText()) || jTextField1.getText().equals("")) && (!jTextField2.getText().equals(jTextField3.getText()) || jTextField2.getText().equals("")) && (!jTextField1.getText().equals(jTextField4.getText()) || jTextField1.getText().equals("")) && (!jTextField2.getText().equals(jTextField4.getText()) || jTextField2.getText().equals(""))){

            jButton2.setBackground(Color.black);
            jTextField1.setEditable(false);
            jTextField2.setEditable(false);
            if (kekklikk){jButton3.setEnabled(true);}
            pirosklikk = true;
            jButton2.setIcon(null);
        }

    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         try {
             Jatekos egy=new Jatekos(nev1,elet1,pajzs1,fegyver1,hely1,hanykor1,new URL(kar1),mod1,harc1,kikerul1);
             Jatekos ketto=new Jatekos(nev2,elet2,pajzs2,fegyver2,hely2,hanykor2,new URL(kar2),mod2,harc2,kikerul2);
             try {
                 new TablaGUI(egy,ketto,kor).setVisible(true);
             } catch (CloneNotSupportedException ex) {
                 Logger.getLogger(KezdoGUI.class.getName()).log(Level.SEVERE, null, ex);
             }
             dispose();
         } catch (MalformedURLException ex) {
             Logger.getLogger(KezdoGUI.class.getName()).log(Level.SEVERE, null, ex);
         }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
       new SugoGUI().setVisible(true);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
       new SugoGUI().setVisible(true);
    }//GEN-LAST:event_jLabel3MouseClicked

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(KezdoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KezdoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KezdoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KezdoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KezdoGUI().setVisible(true);
            }
        });
    }
    
    public Boolean betoltes(){
        try{
           
            
            BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(("Mentes.txt")), "UTF8")); 
            String t[]=br.readLine().split("\t");
            nev1=t[0];nev2=t[1];
            t=br.readLine().split("\t");
            elet1=Integer.parseInt(t[0]);elet2=Integer.parseInt(t[1]);
            t=br.readLine().split("\t");
            pajzs1=Integer.parseInt(t[0]);pajzs2=Integer.parseInt(t[1]);
            t=br.readLine().split("\t");
            fegyver1=Integer.parseInt(t[0]);fegyver2=Integer.parseInt(t[1]);
            t=br.readLine().split("\t");
            mod1=Integer.parseInt(t[0]);mod2=Integer.parseInt(t[1]);
            t=br.readLine().split("\t");
            hely1=Integer.parseInt(t[0]);hely2=Integer.parseInt(t[1]);
            t=br.readLine().split("\t");
            hanykor1=Integer.parseInt(t[0]);hanykor2=Integer.parseInt(t[1]);
            t=br.readLine().split("\t");
            kar1=t[0];kar2=t[1];
            t=br.readLine().split("\t");
            harc1=Boolean.parseBoolean(t[0]);harc2=Boolean.parseBoolean(t[1]);
            t=br.readLine().split("\t");
            kikerul1=Boolean.parseBoolean(t[0]);kikerul2=Boolean.parseBoolean(t[1]);
            kor=Integer.parseInt(br.readLine());
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
       
    }    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
