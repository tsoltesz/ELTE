
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

public class TablaGUI extends javax.swing.JFrame {

    String dobnak[]={"●","<html>●<br>●</html>","<html>● &nbsp &nbsp <br>  &nbsp ● &nbsp  <br>  &nbsp &nbsp    ●</html>","<html>●      ●<br>       <br>●     ●</html>","<html>●      ●<br>  &nbsp ● &nbsp  <br>●     ●</html>","<html>●      ●<br>●      ●<br>●     ●</html>"};
    JLabel mezok1[], mezok2[];
    Mezok mezok [];
    Jatekos jatekosok[];
    static int kor;
    Thread t;
    Boolean nyomhatoe;
    int ido=3000;
    
    Clip clip;
        
    KeyListener kilepes;
    /* String[] kektankut = {"00","0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31",
        "32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60","61","62","63","64","65",
        "66","67","68","69","70","71","72","73","74","75","76","77","78","79","80","81","82","83","84","85","86","87","88","89","90","90","92","93","94","95","96","97","98","99",
        "100","101","102","103","104","105","106","107","108","109","110","111","112","113","114","115","116","117","118","119","120","121","122","123","124","125","126","127",
        "128","129","130","131"};
    String[] pirostankut = {"131","130","129","128","127","126","125","124","123","122","121","120","119","118","117","116","115","114","113","112","111","110","109","108","107",
        "106","105","104","103","102","101","100","99","98","97","96","95","94","93","92","91","90","89","88","87","86","85","84","83","82","81","80","79","78","77","76","75","74",
        "73","72","71","70","69","68","67","66","65","64","63","62","61","60","59","58","57","56","55","54","53","52","51","50","49","48","47","46","45","44","43","42","41","40","39",
        "38","37","36","35","34","33","32","31","30","29","28","27","26","25","24","23","22","21","20","19","18","17","16","15","14","13","12","11","10","9","8","7","6","5","4","3","2",
        "1","0","00"};
    String[] kezdo = {"00","131"};
    String[] zaro = {"131","00"};
    String[] teleport = {"60","73"};
    String[] gyorsito = {"65"};
    String[] gepimezo = {"74","75","76","77","78","79","80","81","82","83","84","85","86"};
    String[] harcmezo = {"0","4","5","10","11","19","22","23","30","31","32","33","38","39","40","41","48","49","52","62","63","64","69","91","97","98","99","100","107","108",
        "111","119","120","125","126","130"};
    String[] tolto = {"1","8","12","13","17","18","27","44","53","54","58","61","72","90","92","93","103","112","113","117","118","122","129"};
    String[] akadaly = {"2","3","9","20","21","28","29","42","43","50","51","67","68","70","89","101","102","109","110","121","127","128"};
    String[] lepteto = {"6","7","14","15","16","24","25","26","34","35","36","37","45","46","47","55","56","57","59","66","71","87","88","94","95","96","104","105","106","114",
        "115","116","123","124"};
    String[] kekjobbra = {"8","19","30","41","52","61","62","63","64","66","81","82","89","100","111","122"};
    String[] kekbalra = {"72","73","74","75","76"};
    String[] pirosjobbra = {"81","82"};
    String[] pirosbalra = {"122","111","100","89","72","73","74","75","76","66","64","63","62","61","52","41","30","19","8"};
    String[] kekle = {"00","0","1","2","3","4","5","6","7","20","21","22","23","24","25","26","27","28","29","42","43","44","45","46","47","48","49","50","51","67","68","69",
        "70","71","83","84","85","86","87","88","101","102","103","104","105","106","107","108","109","110","123","124","125","126","127","128","129","130","131"};
    String[] kekfel = {"9","10","11","12","13","14","15","16","17","18","31","32","33","34","35","36","37","38","39","40","53","54","55","56","57","58","59","60","77","78","79",
        "80","90","91","92","93","94","95","96","97","98","99","112","113","114","115","116","117","118","119","120","121"};
    String[] pirosle = {"121","120","119","118","117","116","115","114","113","112","99","98","97","96","95","94","93","92","91","90","83","84","85","86","60","59","58","57","56",
        "55","54","53","40","39","38","37","36","35","34","33","32","31","18","17","16","15","14","13","12","11","10","9"};
    String[] pirosfel = {"131","130","129","128","127","126","125","124","123","110","109","108","107","106","105","104","103","102","101","88","87","77","76","75","74","71","70",
        "69","68","67","51","50","49","48","47","46","45","44","43","42","29","28","27","26","25","24","23","22","21","20","7","6","5","4","3","2","1","0","00"}; */
    
    
    public TablaGUI() {
        initComponents();
        
        Boolean kekittall = false;
        Boolean pirosittall = false;
        Boolean egyezonallnak = false; // csak kő mezőn számít, ha true: harc; 
        Boolean gepinall = false; // csak fém belső körön számít, ha true: gépiharc
        Boolean fuvenall = false; // ha true: +10% hp regeneráció, de max 100%-ra!.
        Boolean kovonall = false; // ha csak egy áll itt, akor semi, ha mindkettő --> egyezonallnak
        Boolean agyagonall = false; // ha true: a gyorsaság(1 vagy 2) * dobott szám
        Boolean homokonall = false; // ha true: -10% páncél romlás
        Boolean teleportonall = false; // ha true: akkor random mezőre rak
        Boolean trukkosonall = false; // csak 1 mező, a 68. ha true: vissza dob az elejére
        Boolean vegenall = false; // ha true: beért az ellenfél bázisára
        Boolean pirosnyert = false;
        Boolean keknyert = false;
        
        
        /// 
        
        setLocationRelativeTo(null);
       /* mezok1=new JLabel[116];
        mezok2=new JLabel[13];
        mezok=new Object[116];
        Mezo1Feltoltese();*/
        
        
        
        
        
        ////
        /*
        Vector v = new Vector();
      
        v.add(k1); v.add(k2); v.add(k3); v.add(k4); v.add(k5); v.add(k6); v.add(k7); v.add(k8); v.add(k9); v.add(k10); v.add(k11); v.add(k12);
        v.add(k13); v.add(k14); v.add(k15); v.add(k16); v.add(k17); v.add(k18); v.add(k19); v.add(k20); v.add(k21); v.add(k22); v.add(k23);
        v.add(k24); v.add(k25); v.add(k26); v.add(k27); v.add(k28); v.add(k29); v.add(k30); v.add(k31); v.add(k32); v.add(k33); v.add(k34); v.add(k35); v.add(k36);
        v.get(1); v.get(2); v.get(3); v.get(4); v.get(5); v.get(6); v.get(7); v.get(8); v.get(9); v.get(10); v.get(11); v.get(12);
        v.get(13); v.get(14); v.get(15); v.get(16); v.get(17); v.get(18); v.get(19); v.get(20); v.get(21); v.get(22); v.get(23);
        v.get(24); v.get(25); v.get(26); v.get(27); v.get(28); v.get(29); v.get(30); v.get(31); v.get(32); v.get(33); v.get(34); v.get(35); v.get(36);
        v.add(f1); v.add(f2); v.add(f3); v.add(f4); v.add(f5); v.add(f6); v.add(f7); v.add(f8); v.add(f9); v.add(f10); v.add(f11); v.add(f12);
        v.add(f13); v.add(f4); v.add(f15); v.add(f16); v.add(f17); v.add(f18); v.add(f19); v.add(f20); v.add(f21); v.add(f22); v.add(f23);
        v.get(37); v.get(38); v.get(39); v.get(40); v.get(41); v.get(42); v.get(43); v.get(44); v.get(45); v.get(46); v.get(47); v.get(48);
        v.get(49); v.get(50); v.get(51); v.get(52); v.get(53); v.get(54); v.get(55); v.get(56); v.get(57); v.get(58); v.get(59);
        v.add(h1); v.add(h2); v.add(h3); v.add(h4); v.add(h5); v.add(h6); v.add(h7); v.add(h8); v.add(h9); v.add(h10); v.add(h11); v.add(h12);
        v.add(h13); v.add(h14); v.add(h15); v.add(h16); v.add(h17); v.add(h18); v.add(h19); v.add(h20); v.add(h21); v.add(h22);
        v.get(60); v.get(61); v.get(62); v.get(63); v.get(64); v.get(65); v.get(66); v.get(67); v.get(68); v.get(69); v.get(70); v.get(71);
        v.get(72); v.get(73); v.get(74); v.get(75); v.get(76); v.get(77); v.get(78); v.get(79); v.get(80); v.get(81);
        v.add(a1); v.add(a2); v.add(a3); v.add(a4); v.add(a5); v.add(a6); v.add(a7); v.add(a8); v.add(a9); v.add(a10); v.add(a11); v.add(a12);
        v.add(a13); v.add(a14); v.add(a15); v.add(a16); v.add(a17); v.add(a18); v.add(a19); v.add(a20); v.add(a21); v.add(a22); v.add(a23);
        v.add(a24); v.add(a25); v.add(a26); v.add(a27); v.add(a28); v.add(a29); v.add(a30); v.add(a31); v.add(a32); v.add(a33); v.add(a34);
        v.get(82); v.get(83); v.get(84); v.get(85); v.get(86); v.get(87); v.get(88); v.get(89); v.get(90); v.get(91); v.get(92); v.get(93);
        v.get(94); v.get(95); v.get(96); v.get(97); v.get(98); v.get(99); v.get(100); v.get(101); v.get(102); v.get(103); v.get(104);
        v.get(105); v.get(106); v.get(107); v.get(108); v.get(109); v.get(110); v.get(111); v.get(112); v.get(113); v.get(114); v.get(115);
        v.add(g1); v.add(g2); v.add(g3); v.add(g4); v.add(g5); v.add(g6); v.add(g7); v.add(g8); v.add(g9); v.add(g10); v.add(g11); v.add(g12); v.add(g13);
        v.get(116); v.get(117); v.get(118); v.get(119); v.get(120); v.get(121); v.get(122); v.get(123); v.get(124); v.get(125); v.get(126); v.get(127); v.get(128);
        v.add(i1); v.add(i2);
        v.get(129); v.get(130);
        v.add(t1); v.add(t2);
        v.get(131); v.get(132);
        v.add(cs);
        v.get(133);
    
        Vector ko = new Vector();
        ko.add(k1); ko.add(k2); ko.add(k3); ko.add(k4); ko.add(k5); ko.add(k6); ko.add(k7); ko.add(k8); ko.add(k9); ko.add(k10); ko.add(k11); ko.add(k12); ko.add(k13);
        ko.add(k14); ko.add(k15); ko.add(k16); ko.add(k17); ko.add(k18); ko.add(k19); ko.add(k20); ko.add(k21); ko.add(k22); ko.add(k23); ko.add(k24); ko.add(k25);
        ko.add(k26); ko.add(k27); ko.add(k28); ko.add(k29); ko.add(k30); ko.add(k31); ko.add(k32); ko.add(k33); ko.add(k34); ko.add(k35); ko.add(k36);
        
        Vector fu = new Vector();
        fu.add(f1); fu.add(f2); fu.add(f3); fu.add(f4); fu.add(f5); fu.add(f6); fu.add(f7); fu.add(f8); fu.add(f9); fu.add(f10); fu.add(f11); fu.add(f12); fu.add(f13); fu.add(f14);
        fu.add(f15); fu.add(f16); fu.add(f17); fu.add(f18); fu.add(f19); fu.add(f20); fu.add(f21); fu.add(f22); fu.add(f23);
        
        Vector homok = new Vector();
        homok.add(h1); homok.add(h2); homok.add(h3); homok.add(h4); homok.add(h5); homok.add(h6); homok.add(h7); homok.add(h8); homok.add(h9); homok.add(h10); homok.add(h11);
        homok.add(h12); homok.add(h13); homok.add(h14); homok.add(h15); homok.add(h16); homok.add(h17); homok.add(h18); homok.add(h19); homok.add(h20); homok.add(h21); homok.add(h22);
        
        Vector agyag = new Vector();
        agyag.add(a1); agyag.add(a2); agyag.add(a3); agyag.add(a4); agyag.add(a5); agyag.add(a6); agyag.add(a7); agyag.add(a8); agyag.add(a9); agyag.add(a10); agyag.add(a11);
        agyag.add(a12); agyag.add(a13); agyag.add(a14); agyag.add(a15); agyag.add(a16); agyag.add(a17); agyag.add(a18); agyag.add(a19); agyag.add(a20); agyag.add(a21);
        agyag.add(a22); agyag.add(a23); agyag.add(a24); agyag.add(a25); agyag.add(a26); agyag.add(a27); agyag.add(a28); agyag.add(a29); agyag.add(a30); agyag.add(a31);
        agyag.add(a32); agyag.add(a33); agyag.add(a34);
        
        Vector gep = new Vector();
        gep.add(g1); gep.add(g2); gep.add(g3); gep.add(g4); gep.add(g5); gep.add(g6); gep.add(g7); gep.add(g8); gep.add(g9); gep.add(g10); gep.add(g11); gep.add(g12); gep.add(g13);
        
        Vector indulok = new Vector();
        indulok.add(i1); indulok.add(i2);
        
        Vector teleport = new Vector();
        teleport.add(t1); teleport.add(t2);
        
        Vector csapda = new Vector();
        csapda.add(cs);
        
        Vector kektankut = new Vector();
        kektankut.add(i1); kektankut.add(k1); kektankut.add(f1); kektankut.add(h1); kektankut.add(h2); kektankut.add(k2); kektankut.add(k3); kektankut.add(a1); kektankut.add(a2);
        kektankut.add(f2);
        kektankut.add(h3); kektankut.add(k4); kektankut.add(k5); kektankut.add(f3); kektankut.add(f3); kektankut.add(a3); kektankut.add(a4); kektankut.add(a5); kektankut.add(f5); kektankut.add(f6);
        kektankut.add(k6);
        kektankut.add(h4); kektankut.add(h5); kektankut.add(k7); kektankut.add(k8); kektankut.add(a6); kektankut.add(a7); kektankut.add(a8); kektankut.add(f7); kektankut.add(h6); kektankut.add(h7);
        kektankut.add(k9);
        kektankut.add(k10); kektankut.add(k11); kektankut.add(k12); kektankut.add(a9); kektankut.add(a10); kektankut.add(a11); kektankut.add(a12); kektankut.add(k13); kektankut.add(k14); kektankut.add(k15);
        kektankut.add(k16);
        kektankut.add(h8); kektankut.add(h9); kektankut.add(f8); kektankut.add(a13); kektankut.add(a14); kektankut.add(a15); kektankut.add(k17); kektankut.add(k18); kektankut.add(h10); kektankut.add(h11);
        kektankut.add(k19);
        kektankut.add(f9); kektankut.add(f10); kektankut.add(a16); kektankut.add(a17); kektankut.add(a18); kektankut.add(f11); kektankut.add(a19); kektankut.add(t1);
        kektankut.add(f12); kektankut.add(k20); kektankut.add(k21); kektankut.add(k22); kektankut.add(cs); kektankut.add(a20);
        kektankut.add(h12); kektankut.add(h13); kektankut.add(k23); kektankut.add(h14); kektankut.add(a21); kektankut.add(f13); 
        kektankut.add(t2); kektankut.add(g1); kektankut.add(g2); kektankut.add(g3); kektankut.add(g4); kektankut.add(g5); kektankut.add(g6); kektankut.add(g7);
        kektankut.add(g8); kektankut.add(g9); kektankut.add(g10); kektankut.add(g11); kektankut.add(g12); kektankut.add(g13);
        kektankut.add(a22); kektankut.add(a23);
        kektankut.add(h15);
        kektankut.add(f14); kektankut.add(k24); kektankut.add(f15); kektankut.add(f16); kektankut.add(a24); kektankut.add(a25); kektankut.add(a26); kektankut.add(k25); kektankut.add(k26); kektankut.add(k27);
        kektankut.add(k28);
        kektankut.add(h16); kektankut.add(h17); kektankut.add(f17); kektankut.add(a27); kektankut.add(a28); kektankut.add(a29); kektankut.add(k29); kektankut.add(k30); kektankut.add(h18); kektankut.add(h19);
        kektankut.add(k31);
        kektankut.add(f18); kektankut.add(f19); kektankut.add(a30); kektankut.add(a31); kektankut.add(a32); kektankut.add(f20); kektankut.add(f21); kektankut.add(k22); kektankut.add(k23); kektankut.add(h20);
        kektankut.add(f22);
        kektankut.add(a33); kektankut.add(a34); kektankut.add(k34); kektankut.add(k35); kektankut.add(h21); kektankut.add(h22); kektankut.add(f23); kektankut.add(k36); kektankut.add(i2);
        
        Vector kektankjobra = new Vector();
        kektankjobra.add(f2); kektankjobra.add(k6); kektankjobra.add(k9); kektankjobra.add(k16); kektankjobra.add(k19); kektankjobra.add(f12); kektankjobra.add(k20); kektankjobra.add(k21); kektankjobra.add(k22);
        kektankjobra.add(cs); kektankjobra.add(a20); kektankjobra.add(g8); kektankjobra.add(g9); kektankjobra.add(h15); kektankjobra.add(k28); kektankjobra.add(k31); kektankjobra.add(f22);
        
        Vector kektankbalra = new Vector();
        kektankbalra.add(f13); kektankbalra.add(t2); kektankbalra.add(g1); kektankbalra.add(g2); kektankbalra.add(g3);
        
        Vector kektankle = new Vector();
        kektankle.add(i1); kektankle.add(k1); kektankle.add(f1); kektankle.add(h1); kektankle.add(h2); kektankle.add(k2); kektankle.add(k3); kektankle.add(a1); kektankle.add(a2);
        kektankle.add(h4); kektankle.add(h5); kektankle.add(k7); kektankle.add(k8); kektankle.add(a6); kektankle.add(a7); kektankle.add(a8); kektankle.add(f7); kektankle.add(h6); kektankle.add(h7);
        kektankle.add(h8); kektankle.add(h9); kektankle.add(f8); kektankle.add(a13); kektankle.add(a14); kektankle.add(a15); kektankle.add(k17); kektankle.add(k18); kektankle.add(h10); kektankle.add(h11);
        kektankle.add(h12); kektankle.add(h13); kektankle.add(k23); kektankle.add(h14); kektankle.add(a21); kektankle.add(g10); kektankle.add(g11); kektankle.add(g12); kektankle.add(g13); kektankle.add(a22); kektankle.add(a23);
        kektankle.add(h16); kektankle.add(h17); kektankle.add(f17); kektankle.add(a27); kektankle.add(a28); kektankle.add(a29); kektankle.add(k29); kektankle.add(k30); kektankle.add(h18); kektankle.add(h19);
        kektankle.add(a33); kektankle.add(a34); kektankle.add(k34); kektankle.add(k35); kektankle.add(h21); kektankle.add(h22); kektankle.add(f23); kektankle.add(k36); kektankle.add(i2);
        
        Vector kektankfel = new Vector();
        kektankfel.add(h3); kektankfel.add(k4); kektankfel.add(k5); kektankfel.add(f3); kektankfel.add(f4); kektankfel.add(a3); kektankfel.add(a4); kektankfel.add(a5); kektankfel.add(f5); kektankfel.add(f6);
        kektankfel.add(k10); kektankfel.add(k11); kektankfel.add(k12); kektankfel.add(a9); kektankfel.add(a10); kektankfel.add(a11); kektankfel.add(a12); kektankfel.add(k13); kektankfel.add(k14); kektankfel.add(k15);
        kektankfel.add(f9); kektankfel.add(f10); kektankfel.add(a16); kektankfel.add(a17); kektankfel.add(a18); kektankfel.add(f11); kektankfel.add(a19); kektankfel.add(t1);
        kektankfel.add(g4); kektankfel.add(g5); kektankfel.add(g6); kektankfel.add(g7);
        kektankfel.add(f14); kektankfel.add(k24); kektankfel.add(f15); kektankfel.add(f16); kektankfel.add(a24); kektankfel.add(a25); kektankfel.add(a26); kektankfel.add(k25); kektankfel.add(k26); kektankfel.add(k27);
        kektankfel.add(f18); kektankfel.add(f19); kektankfel.add(a30); kektankfel.add(a31); kektankfel.add(a32); kektankfel.add(f20); kektankfel.add(f21); kektankfel.add(k31); kektankfel.add(k33); kektankfel.add(h20);
        
        Vector pirostankut = new Vector();
        pirostankut.add(i2); pirostankut.add(k36); pirostankut.add(f23); pirostankut.add(h22); pirostankut.add(h21); pirostankut.add(k35); pirostankut.add(k34); pirostankut.add(a34); pirostankut.add(a33);
        pirostankut.add(f22);
        pirostankut.add(h20); pirostankut.add(k33); pirostankut.add(k32); pirostankut.add(f21); pirostankut.add(f20); pirostankut.add(a32); pirostankut.add(a31); pirostankut.add(a30); pirostankut.add(f19); pirostankut.add(f18);
        pirostankut.add(k31);
        pirostankut.add(h19); pirostankut.add(h18); pirostankut.add(k30); pirostankut.add(k29); pirostankut.add(a29); pirostankut.add(a28); pirostankut.add(a27); pirostankut.add(f17); pirostankut.add(h17); pirostankut.add(h16);
        pirostankut.add(k28);
        pirostankut.add(k27); pirostankut.add(k26); pirostankut.add(k25); pirostankut.add(a26); pirostankut.add(a25); pirostankut.add(a24); pirostankut.add(f16); pirostankut.add(f15); pirostankut.add(k24); pirostankut.add(f14);
        pirostankut.add(h15);
        pirostankut.add(a23); pirostankut.add(a22); pirostankut.add(f13); pirostankut.add(t2); pirostankut.add(g1); pirostankut.add(g2); pirostankut.add(g3); pirostankut.add(g4); pirostankut.add(g5);
        pirostankut.add(g6); pirostankut.add(g7); pirostankut.add(g8); pirostankut.add(g9); pirostankut.add(g10); pirostankut.add(g11); pirostankut.add(g12); pirostankut.add(g13);
        pirostankut.add(a21); pirostankut.add(h14); pirostankut.add(k23); pirostankut.add(h13); pirostankut.add(h12); pirostankut.add(a20); pirostankut.add(cs); pirostankut.add(k22); pirostankut.add(k21); pirostankut.add(k20);
        pirostankut.add(f12); pirostankut.add(t1); pirostankut.add(a19); pirostankut.add(f11); pirostankut.add(a18); pirostankut.add(a17); pirostankut.add(a16); pirostankut.add(f10); pirostankut.add(f9);
        pirostankut.add(k19);
        pirostankut.add(h11); pirostankut.add(h10); pirostankut.add(k18); pirostankut.add(k17); pirostankut.add(a15); pirostankut.add(a14); pirostankut.add(a13); pirostankut.add(f8); pirostankut.add(h9); pirostankut.add(h8);
        pirostankut.add(k16);
        pirostankut.add(k15); pirostankut.add(k15); pirostankut.add(k13); pirostankut.add(a12); pirostankut.add(a11); pirostankut.add(a10); pirostankut.add(a9); pirostankut.add(k12); pirostankut.add(k11); pirostankut.add(k10);
        pirostankut.add(k9);
        pirostankut.add(h7); pirostankut.add(h6); pirostankut.add(f7); pirostankut.add(a8); pirostankut.add(a7); pirostankut.add(a6); pirostankut.add(k8); pirostankut.add(k7); pirostankut.add(h5); pirostankut.add(h4);
        pirostankut.add(k6);
        pirostankut.add(f6); pirostankut.add(f5); pirostankut.add(a5); pirostankut.add(a4); pirostankut.add(a3); pirostankut.add(f4); pirostankut.add(f3); pirostankut.add(k5); pirostankut.add(k4); pirostankut.add(h3);
        pirostankut.add(f2);
        pirostankut.add(a2); pirostankut.add(a1); pirostankut.add(k3); pirostankut.add(k2); pirostankut.add(h2); pirostankut.add(h1); pirostankut.add(f1); pirostankut.add(k1); pirostankut.add(i1);
        
        Vector pirostankjobra = new Vector();
        pirostankjobra.add(g8); pirostankjobra.add(g9);
        
        Vector pirostankbalra = new Vector();
        pirostankbalra.add(f22); pirostankbalra.add(k31); pirostankbalra.add(k28); pirostankbalra.add(h15); pirostankbalra.add(f13); pirostankbalra.add(t2); pirostankbalra.add(g1); pirostankbalra.add(g2); pirostankbalra.add(g3); pirostankbalra.add(a20);
        pirostankbalra.add(cs); pirostankbalra.add(k22); pirostankbalra.add(k21); pirostankbalra.add(k20); pirostankbalra.add(f12); pirostankbalra.add(k19); pirostankbalra.add(k16); pirostankbalra.add(k9); pirostankbalra.add(k6); pirostankbalra.add(f2);
        
        Vector pirostankfel = new Vector();
        pirostankfel.add(i2); pirostankfel.add(k36); pirostankfel.add(f23); pirostankfel.add(h22); pirostankfel.add(h21); pirostankfel.add(k35); pirostankfel.add(k34); pirostankfel.add(a34); pirostankfel.add(a33);
        pirostankfel.add(h19); pirostankfel.add(h18); pirostankfel.add(k30); pirostankfel.add(k29); pirostankfel.add(a29); pirostankfel.add(a28); pirostankfel.add(a27); pirostankfel.add(f17); pirostankfel.add(h17); pirostankfel.add(h16);
        pirostankfel.add(a23); pirostankfel.add(a22); pirostankfel.add(g4); pirostankfel.add(g5); pirostankfel.add(g6); pirostankfel.add(g7); pirostankfel.add(a21); pirostankfel.add(h14); pirostankfel.add(k23); pirostankfel.add(h13); pirostankfel.add(h12);
        pirostankfel.add(h11); pirostankfel.add(h10); pirostankfel.add(k18); pirostankfel.add(k17); pirostankfel.add(a15); pirostankfel.add(a14); pirostankfel.add(a13); pirostankfel.add(f8); pirostankfel.add(h9); pirostankfel.add(h8);
        pirostankfel.add(h7); pirostankfel.add(h6); pirostankfel.add(f7); pirostankfel.add(a8); pirostankfel.add(a7); pirostankfel.add(a6); pirostankfel.add(k8); pirostankfel.add(k7); pirostankfel.add(h5); pirostankfel.add(h4);
        pirostankfel.add(a2); pirostankfel.add(a1); pirostankfel.add(k3); pirostankfel.add(k2); pirostankfel.add(h2); pirostankfel.add(h1); pirostankfel.add(f1); pirostankfel.add(k1); pirostankfel.add(i1);
        
        Vector pirostankle = new Vector();
        pirostankle.add(h20); pirostankle.add(k33); pirostankle.add(k32); pirostankle.add(f21); pirostankle.add(f20); pirostankle.add(a32); pirostankle.add(a31); pirostankle.add(a30); pirostankle.add(f19); pirostankle.add(f18);
        pirostankle.add(k27); pirostankle.add(k26); pirostankle.add(k25); pirostankle.add(a26); pirostankle.add(a25); pirostankle.add(a24); pirostankle.add(f16); pirostankle.add(f15); pirostankle.add(k24); pirostankle.add(f14);
        pirostankle.add(g10); pirostankle.add(g11); pirostankle.add(g12); pirostankle.add(g13);
        pirostankle.add(t1); pirostankle.add(a19); pirostankle.add(f11); pirostankle.add(a18); pirostankle.add(a17); pirostankle.add(a16); pirostankle.add(f10); pirostankle.add(f9);
        pirostankle.add(k15); pirostankle.add(k14); pirostankle.add(k13); pirostankle.add(a12); pirostankle.add(a11); pirostankle.add(a10); pirostankle.add(a9); pirostankle.add(k12); pirostankle.add(k11); pirostankle.add(k10);
        pirostankle.add(f6); pirostankle.add(f5); pirostankle.add(a5); pirostankle.add(a4); pirostankle.add(a3); pirostankle.add(f4); pirostankle.add(f3); pirostankle.add(k5); pirostankle.add(k4); pirostankle.add(h3);
    */
        }

    public TablaGUI(Jatekos egy, Jatekos ketto,int kor) throws CloneNotSupportedException{
        
        jatekosok=new Jatekos[2];
        jatekosok[0]=(Jatekos)egy.clone();
        jatekosok[1]=(Jatekos)ketto.clone();
        
        nyomhatoe=true;
        
        this.kor=kor;
        
        kilepes=new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyPressed(KeyEvent ke) {
               if (ke.getKeyCode()==27){
            setVisible(false);
            new KilepoGUI(jatekosok, TablaGUI.this,TablaGUI.kor).setVisible(true);
            
        }
            }

            @Override
            public void keyReleased(KeyEvent ke) {
              //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        
        
        initComponents();
        
       setIconImage(new ImageIcon(getClass().getResource("/kepek/ikon.png")).getImage());
   
        
        setLocationRelativeTo(null);
        mezok1=new JLabel[133];
        
        mezok=new Mezok[133];
        Mezo1Feltoltese();
        
        if (kor%2==0){
        jTextField19.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.yellow, java.awt.Color.yellow, java.awt.Color.yellow, java.awt.Color.yellow));
        jLabel3.setText(jatekosok[0].getNev()+" következik!");
        }
        else {
            jTextField20.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.yellow, java.awt.Color.yellow, java.awt.Color.yellow, java.awt.Color.yellow));
        jLabel3.setText(jatekosok[1].getNev()+" következik!");
        }
        jLabel2.requestFocus();
        kiRajz();
       
        addKeyListener();
        
        
        URL hang=getClass().getResource("/zene/zene.wav");
        
        
        
        AudioInputStream stream = null;
                
                

        try {
            stream = AudioSystem.getAudioInputStream((hang));
            clip = AudioSystem.getClip();

            clip.open(stream);
         clip.loop(Clip.LOOP_CONTINUOUSLY);
                clip.start();
                clip.drain();
        }
        catch(Exception e){JOptionPane.showMessageDialog(this, "Hiba a zene lejátszása közben!");}
        
        
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        k1 = new javax.swing.JLabel();
        i1 = new javax.swing.JLabel();
        f1 = new javax.swing.JLabel();
        h1 = new javax.swing.JLabel();
        h2 = new javax.swing.JLabel();
        k2 = new javax.swing.JLabel();
        k3 = new javax.swing.JLabel();
        a1 = new javax.swing.JLabel();
        a2 = new javax.swing.JLabel();
        f2 = new javax.swing.JLabel();
        h3 = new javax.swing.JLabel();
        k4 = new javax.swing.JLabel();
        k5 = new javax.swing.JLabel();
        f3 = new javax.swing.JLabel();
        f4 = new javax.swing.JLabel();
        a3 = new javax.swing.JLabel();
        a4 = new javax.swing.JLabel();
        a5 = new javax.swing.JLabel();
        f5 = new javax.swing.JLabel();
        f6 = new javax.swing.JLabel();
        k6 = new javax.swing.JLabel();
        h4 = new javax.swing.JLabel();
        h5 = new javax.swing.JLabel();
        k7 = new javax.swing.JLabel();
        k8 = new javax.swing.JLabel();
        a6 = new javax.swing.JLabel();
        a7 = new javax.swing.JLabel();
        a8 = new javax.swing.JLabel();
        f7 = new javax.swing.JLabel();
        h6 = new javax.swing.JLabel();
        h7 = new javax.swing.JLabel();
        k9 = new javax.swing.JLabel();
        k10 = new javax.swing.JLabel();
        k11 = new javax.swing.JLabel();
        k12 = new javax.swing.JLabel();
        a9 = new javax.swing.JLabel();
        a10 = new javax.swing.JLabel();
        a11 = new javax.swing.JLabel();
        a12 = new javax.swing.JLabel();
        k13 = new javax.swing.JLabel();
        k14 = new javax.swing.JLabel();
        k15 = new javax.swing.JLabel();
        k16 = new javax.swing.JLabel();
        h8 = new javax.swing.JLabel();
        h9 = new javax.swing.JLabel();
        f8 = new javax.swing.JLabel();
        a13 = new javax.swing.JLabel();
        a14 = new javax.swing.JLabel();
        a15 = new javax.swing.JLabel();
        k17 = new javax.swing.JLabel();
        k18 = new javax.swing.JLabel();
        h10 = new javax.swing.JLabel();
        h11 = new javax.swing.JLabel();
        k19 = new javax.swing.JLabel();
        f9 = new javax.swing.JLabel();
        f10 = new javax.swing.JLabel();
        a16 = new javax.swing.JLabel();
        a17 = new javax.swing.JLabel();
        a18 = new javax.swing.JLabel();
        f11 = new javax.swing.JLabel();
        a19 = new javax.swing.JLabel();
        t1 = new javax.swing.JLabel();
        f12 = new javax.swing.JLabel();
        k20 = new javax.swing.JLabel();
        k21 = new javax.swing.JLabel();
        k22 = new javax.swing.JLabel();
        cs = new javax.swing.JLabel();
        a20 = new javax.swing.JLabel();
        h12 = new javax.swing.JLabel();
        h13 = new javax.swing.JLabel();
        k23 = new javax.swing.JLabel();
        h14 = new javax.swing.JLabel();
        a21 = new javax.swing.JLabel();
        f13 = new javax.swing.JLabel();
        t2 = new javax.swing.JLabel();
        g2 = new javax.swing.JLabel();
        g1 = new javax.swing.JLabel();
        g3 = new javax.swing.JLabel();
        g4 = new javax.swing.JLabel();
        g5 = new javax.swing.JLabel();
        g6 = new javax.swing.JLabel();
        g7 = new javax.swing.JLabel();
        g13 = new javax.swing.JLabel();
        g12 = new javax.swing.JLabel();
        g11 = new javax.swing.JLabel();
        g10 = new javax.swing.JLabel();
        g9 = new javax.swing.JLabel();
        g8 = new javax.swing.JLabel();
        a22 = new javax.swing.JLabel();
        a23 = new javax.swing.JLabel();
        h15 = new javax.swing.JLabel();
        f14 = new javax.swing.JLabel();
        k24 = new javax.swing.JLabel();
        f15 = new javax.swing.JLabel();
        f16 = new javax.swing.JLabel();
        a24 = new javax.swing.JLabel();
        a25 = new javax.swing.JLabel();
        a26 = new javax.swing.JLabel();
        k25 = new javax.swing.JLabel();
        k26 = new javax.swing.JLabel();
        k27 = new javax.swing.JLabel();
        k28 = new javax.swing.JLabel();
        h16 = new javax.swing.JLabel();
        h17 = new javax.swing.JLabel();
        f17 = new javax.swing.JLabel();
        a27 = new javax.swing.JLabel();
        a28 = new javax.swing.JLabel();
        a29 = new javax.swing.JLabel();
        k29 = new javax.swing.JLabel();
        k30 = new javax.swing.JLabel();
        h18 = new javax.swing.JLabel();
        h19 = new javax.swing.JLabel();
        k31 = new javax.swing.JLabel();
        f18 = new javax.swing.JLabel();
        f19 = new javax.swing.JLabel();
        a30 = new javax.swing.JLabel();
        a31 = new javax.swing.JLabel();
        a32 = new javax.swing.JLabel();
        f20 = new javax.swing.JLabel();
        f21 = new javax.swing.JLabel();
        k32 = new javax.swing.JLabel();
        k33 = new javax.swing.JLabel();
        h20 = new javax.swing.JLabel();
        f22 = new javax.swing.JLabel();
        a33 = new javax.swing.JLabel();
        a34 = new javax.swing.JLabel();
        k34 = new javax.swing.JLabel();
        k35 = new javax.swing.JLabel();
        h21 = new javax.swing.JLabel();
        h22 = new javax.swing.JLabel();
        f23 = new javax.swing.JLabel();
        k36 = new javax.swing.JLabel();
        i2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jProgressBar1 = new javax.swing.JProgressBar();
        jTextField6 = new javax.swing.JTextField();
        jProgressBar2 = new javax.swing.JProgressBar();
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTextField19 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        setMinimumSize(new java.awt.Dimension(1535, 865));
        setModalExclusionType(null);
        setUndecorated(true);
        setSize(new java.awt.Dimension(1, 865));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });
        getContentPane().setLayout(null);

        k1.setName("0"); // NOI18N
        getContentPane().add(k1);
        k1.setBounds(136, 310, 25, 50);

        i1.setName("00"); // NOI18N
        getContentPane().add(i1);
        i1.setBounds(124, 213, 50, 87);

        f1.setName("1"); // NOI18N
        getContentPane().add(f1);
        f1.setBounds(136, 367, 25, 50);

        h1.setName("2"); // NOI18N
        getContentPane().add(h1);
        h1.setBounds(136, 424, 25, 50);

        h2.setName("3"); // NOI18N
        getContentPane().add(h2);
        h2.setBounds(136, 481, 25, 50);

        k2.setName("4"); // NOI18N
        getContentPane().add(k2);
        k2.setBounds(136, 540, 25, 50);

        k3.setName("5"); // NOI18N
        getContentPane().add(k3);
        k3.setBounds(136, 600, 25, 50);

        a1.setName("6"); // NOI18N
        getContentPane().add(a1);
        a1.setBounds(136, 660, 25, 50);

        a2.setToolTipText("");
        a2.setName("7"); // NOI18N
        getContentPane().add(a2);
        a2.setBounds(136, 718, 25, 50);

        f2.setName("8"); // NOI18N
        getContentPane().add(f2);
        f2.setBounds(171, 775, 50, 25);

        h3.setName("9"); // NOI18N
        getContentPane().add(h3);
        h3.setBounds(229, 719, 25, 50);

        k4.setName("10"); // NOI18N
        getContentPane().add(k4);
        k4.setBounds(230, 660, 25, 50);

        k5.setName("11"); // NOI18N
        getContentPane().add(k5);
        k5.setBounds(229, 600, 25, 50);

        f3.setName("12"); // NOI18N
        getContentPane().add(f3);
        f3.setBounds(229, 543, 25, 50);

        f4.setName("13"); // NOI18N
        getContentPane().add(f4);
        f4.setBounds(229, 490, 25, 50);

        a3.setName("14"); // NOI18N
        getContentPane().add(a3);
        a3.setBounds(229, 433, 25, 50);

        a4.setName("15"); // NOI18N
        getContentPane().add(a4);
        a4.setBounds(229, 378, 25, 50);

        a5.setName("16"); // NOI18N
        getContentPane().add(a5);
        a5.setBounds(229, 322, 25, 50);

        f5.setName("17"); // NOI18N
        getContentPane().add(f5);
        f5.setBounds(229, 268, 25, 50);

        f6.setName("18"); // NOI18N
        getContentPane().add(f6);
        f6.setBounds(229, 213, 25, 50);

        k6.setName("19"); // NOI18N
        getContentPane().add(k6);
        k6.setBounds(265, 182, 50, 25);

        h4.setName("20"); // NOI18N
        getContentPane().add(h4);
        h4.setBounds(326, 213, 25, 50);

        h5.setName("21"); // NOI18N
        getContentPane().add(h5);
        h5.setBounds(326, 268, 25, 50);

        k7.setName("22"); // NOI18N
        getContentPane().add(k7);
        k7.setBounds(326, 321, 25, 50);

        k8.setName("23"); // NOI18N
        getContentPane().add(k8);
        k8.setBounds(326, 377, 25, 50);

        a6.setName("24"); // NOI18N
        getContentPane().add(a6);
        a6.setBounds(326, 432, 25, 50);

        a7.setName("25"); // NOI18N
        getContentPane().add(a7);
        a7.setBounds(326, 489, 25, 50);

        a8.setName("26"); // NOI18N
        getContentPane().add(a8);
        a8.setBounds(326, 543, 25, 50);

        f7.setName("27"); // NOI18N
        getContentPane().add(f7);
        f7.setBounds(326, 600, 25, 50);

        h6.setName("28"); // NOI18N
        getContentPane().add(h6);
        h6.setBounds(326, 660, 25, 50);

        h7.setName("29"); // NOI18N
        getContentPane().add(h7);
        h7.setBounds(326, 718, 25, 50);

        k9.setName("30"); // NOI18N
        getContentPane().add(k9);
        k9.setBounds(361, 773, 50, 25);

        k10.setName("31"); // NOI18N
        getContentPane().add(k10);
        k10.setBounds(420, 718, 25, 50);

        k11.setName("32"); // NOI18N
        getContentPane().add(k11);
        k11.setBounds(420, 662, 25, 50);

        k12.setName("33"); // NOI18N
        getContentPane().add(k12);
        k12.setBounds(420, 603, 25, 50);

        a9.setName("34"); // NOI18N
        getContentPane().add(a9);
        a9.setBounds(420, 546, 25, 50);

        a10.setName("35"); // NOI18N
        getContentPane().add(a10);
        a10.setBounds(420, 492, 25, 50);

        a11.setName("36"); // NOI18N
        getContentPane().add(a11);
        a11.setBounds(420, 436, 25, 50);

        a12.setName("37"); // NOI18N
        getContentPane().add(a12);
        a12.setBounds(420, 383, 25, 50);

        k13.setName("38"); // NOI18N
        getContentPane().add(k13);
        k13.setBounds(420, 325, 25, 50);

        k14.setName("39"); // NOI18N
        getContentPane().add(k14);
        k14.setBounds(420, 269, 25, 50);

        k15.setName("40"); // NOI18N
        getContentPane().add(k15);
        k15.setBounds(420, 213, 25, 50);

        k16.setName("41"); // NOI18N
        getContentPane().add(k16);
        k16.setBounds(456, 182, 50, 25);

        h8.setName("42"); // NOI18N
        getContentPane().add(h8);
        h8.setBounds(515, 210, 25, 50);

        h9.setName("43"); // NOI18N
        getContentPane().add(h9);
        h9.setBounds(515, 269, 25, 50);

        f8.setToolTipText("");
        f8.setName("44"); // NOI18N
        getContentPane().add(f8);
        f8.setBounds(516, 328, 25, 50);

        a13.setName("45"); // NOI18N
        getContentPane().add(a13);
        a13.setBounds(515, 387, 25, 50);

        a14.setName("46"); // NOI18N
        getContentPane().add(a14);
        a14.setBounds(515, 442, 25, 50);

        a15.setName("47"); // NOI18N
        getContentPane().add(a15);
        a15.setBounds(515, 498, 25, 50);

        k17.setName("48"); // NOI18N
        getContentPane().add(k17);
        k17.setBounds(515, 552, 25, 50);

        k18.setName("49"); // NOI18N
        getContentPane().add(k18);
        k18.setBounds(515, 608, 25, 50);

        h10.setName("50"); // NOI18N
        getContentPane().add(h10);
        h10.setBounds(515, 664, 25, 50);

        h11.setName("51"); // NOI18N
        getContentPane().add(h11);
        h11.setBounds(515, 718, 25, 50);

        k19.setName("52"); // NOI18N
        getContentPane().add(k19);
        k19.setBounds(551, 773, 50, 25);

        f9.setName("53"); // NOI18N
        getContentPane().add(f9);
        f9.setBounds(612, 717, 25, 50);

        f10.setName("54"); // NOI18N
        getContentPane().add(f10);
        f10.setBounds(612, 663, 25, 50);

        a16.setName("55"); // NOI18N
        getContentPane().add(a16);
        a16.setBounds(612, 608, 25, 50);

        a17.setToolTipText("");
        a17.setName("56"); // NOI18N
        getContentPane().add(a17);
        a17.setBounds(612, 553, 25, 50);

        a18.setName("57"); // NOI18N
        getContentPane().add(a18);
        a18.setBounds(612, 497, 25, 50);

        f11.setName("58"); // NOI18N
        getContentPane().add(f11);
        f11.setBounds(612, 443, 25, 50);

        a19.setName("59"); // NOI18N
        getContentPane().add(a19);
        a19.setBounds(612, 384, 25, 50);

        t1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        t1.setName("60"); // NOI18N
        getContentPane().add(t1);
        t1.setBounds(590, 310, 70, 60);

        f12.setName("61"); // NOI18N
        getContentPane().add(f12);
        f12.setBounds(648, 277, 50, 25);

        k20.setName("62"); // NOI18N
        getContentPane().add(k20);
        k20.setBounds(712, 277, 50, 25);

        k21.setName("63"); // NOI18N
        getContentPane().add(k21);
        k21.setBounds(776, 277, 50, 25);

        k22.setName("64"); // NOI18N
        getContentPane().add(k22);
        k22.setBounds(842, 277, 50, 25);

        cs.setName("65"); // NOI18N
        getContentPane().add(cs);
        cs.setBounds(902, 277, 25, 25);

        a20.setName("66"); // NOI18N
        getContentPane().add(a20);
        a20.setBounds(940, 277, 50, 25);

        h12.setName("67"); // NOI18N
        getContentPane().add(h12);
        h12.setBounds(1000, 308, 25, 50);

        h13.setName("68"); // NOI18N
        getContentPane().add(h13);
        h13.setBounds(1000, 366, 25, 50);

        k23.setName("69"); // NOI18N
        getContentPane().add(k23);
        k23.setBounds(1000, 423, 25, 50);

        h14.setName("70"); // NOI18N
        getContentPane().add(h14);
        h14.setBounds(1000, 482, 25, 50);

        a21.setName("71"); // NOI18N
        getContentPane().add(a21);
        a21.setBounds(1000, 540, 25, 50);

        f13.setName("72"); // NOI18N
        getContentPane().add(f13);
        f13.setBounds(970, 596, 50, 25);

        t2.setName("73"); // NOI18N
        getContentPane().add(t2);
        t2.setBounds(894, 578, 70, 60);

        g2.setName("75"); // NOI18N
        getContentPane().add(g2);
        g2.setBounds(778, 597, 50, 25);

        g1.setName("74"); // NOI18N
        getContentPane().add(g1);
        g1.setBounds(842, 597, 50, 25);

        g3.setName("76"); // NOI18N
        getContentPane().add(g3);
        g3.setBounds(714, 595, 50, 25);

        g4.setName("77"); // NOI18N
        getContentPane().add(g4);
        g4.setBounds(679, 540, 25, 50);

        g5.setName("78"); // NOI18N
        getContentPane().add(g5);
        g5.setBounds(678, 480, 25, 50);

        g6.setName("79"); // NOI18N
        getContentPane().add(g6);
        g6.setBounds(678, 420, 25, 50);

        g7.setName("80"); // NOI18N
        getContentPane().add(g7);
        g7.setBounds(678, 360, 25, 50);

        g13.setName("86"); // NOI18N
        getContentPane().add(g13);
        g13.setBounds(839, 539, 25, 50);

        g12.setName("85"); // NOI18N
        getContentPane().add(g12);
        g12.setBounds(839, 480, 25, 50);

        g11.setName("84"); // NOI18N
        getContentPane().add(g11);
        g11.setBounds(839, 420, 25, 50);

        g10.setName("83"); // NOI18N
        getContentPane().add(g10);
        g10.setBounds(839, 360, 25, 50);

        g9.setName("82"); // NOI18N
        getContentPane().add(g9);
        g9.setBounds(778, 328, 50, 25);

        g8.setName("81"); // NOI18N
        getContentPane().add(g8);
        g8.setBounds(714, 328, 50, 25);

        a22.setName("87"); // NOI18N
        getContentPane().add(a22);
        a22.setBounds(1000, 627, 25, 50);

        a23.setName("88"); // NOI18N
        getContentPane().add(a23);
        a23.setBounds(1000, 686, 25, 50);

        h15.setName("89"); // NOI18N
        getContentPane().add(h15);
        h15.setBounds(1036, 743, 50, 25);

        f14.setName("90"); // NOI18N
        getContentPane().add(f14);
        f14.setBounds(1093, 688, 25, 50);

        k24.setName("91"); // NOI18N
        getContentPane().add(k24);
        k24.setBounds(1093, 630, 25, 50);

        f15.setName("92"); // NOI18N
        getContentPane().add(f15);
        f15.setBounds(1093, 574, 25, 50);

        f16.setName("93"); // NOI18N
        getContentPane().add(f16);
        f16.setBounds(1093, 518, 25, 50);

        a24.setName("94"); // NOI18N
        getContentPane().add(a24);
        a24.setBounds(1093, 462, 25, 50);

        a25.setName("95"); // NOI18N
        getContentPane().add(a25);
        a25.setBounds(1093, 408, 25, 50);

        a26.setName("96"); // NOI18N
        getContentPane().add(a26);
        a26.setBounds(1093, 352, 25, 50);

        k25.setName("97"); // NOI18N
        getContentPane().add(k25);
        k25.setBounds(1093, 295, 25, 50);

        k26.setName("98"); // NOI18N
        getContentPane().add(k26);
        k26.setBounds(1093, 238, 25, 50);

        k27.setName("99"); // NOI18N
        getContentPane().add(k27);
        k27.setBounds(1093, 180, 25, 50);

        k28.setName("100"); // NOI18N
        getContentPane().add(k28);
        k28.setBounds(1127, 152, 50, 25);

        h16.setName("101"); // NOI18N
        getContentPane().add(h16);
        h16.setBounds(1186, 180, 25, 50);

        h17.setName("102"); // NOI18N
        getContentPane().add(h17);
        h17.setBounds(1186, 240, 25, 50);

        f17.setName("103"); // NOI18N
        getContentPane().add(f17);
        f17.setBounds(1186, 298, 25, 50);

        a27.setName("104"); // NOI18N
        getContentPane().add(a27);
        a27.setBounds(1186, 357, 25, 50);

        a28.setName("105"); // NOI18N
        getContentPane().add(a28);
        a28.setBounds(1186, 412, 25, 50);

        a29.setName("106"); // NOI18N
        getContentPane().add(a29);
        a29.setBounds(1186, 467, 25, 50);

        k29.setName("107"); // NOI18N
        getContentPane().add(k29);
        k29.setBounds(1186, 524, 25, 50);

        k30.setName("108"); // NOI18N
        getContentPane().add(k30);
        k30.setBounds(1186, 579, 25, 50);

        h18.setName("109"); // NOI18N
        getContentPane().add(h18);
        h18.setBounds(1186, 633, 25, 50);

        h19.setName("110"); // NOI18N
        getContentPane().add(h19);
        h19.setBounds(1186, 687, 25, 50);

        k31.setName("111"); // NOI18N
        getContentPane().add(k31);
        k31.setBounds(1222, 742, 50, 25);

        f18.setName("112"); // NOI18N
        getContentPane().add(f18);
        f18.setBounds(1283, 688, 25, 50);

        f19.setName("113"); // NOI18N
        getContentPane().add(f19);
        f19.setBounds(1283, 632, 25, 50);

        a30.setName("114"); // NOI18N
        getContentPane().add(a30);
        a30.setBounds(1283, 578, 25, 50);

        a31.setName("115"); // NOI18N
        getContentPane().add(a31);
        a31.setBounds(1283, 520, 25, 50);

        a32.setName("116"); // NOI18N
        getContentPane().add(a32);
        a32.setBounds(1283, 468, 25, 50);

        f20.setName("117"); // NOI18N
        getContentPane().add(f20);
        f20.setBounds(1283, 410, 25, 50);

        f21.setName("118"); // NOI18N
        getContentPane().add(f21);
        f21.setBounds(1283, 357, 25, 50);

        k32.setName("119"); // NOI18N
        getContentPane().add(k32);
        k32.setBounds(1283, 300, 25, 50);

        k33.setName("120"); // NOI18N
        getContentPane().add(k33);
        k33.setBounds(1283, 240, 25, 50);

        h20.setName("121"); // NOI18N
        getContentPane().add(h20);
        h20.setBounds(1283, 180, 25, 50);

        f22.setName("122"); // NOI18N
        getContentPane().add(f22);
        f22.setBounds(1318, 150, 50, 25);

        a33.setName("123"); // NOI18N
        getContentPane().add(a33);
        a33.setBounds(1377, 180, 25, 50);

        a34.setName("124"); // NOI18N
        getContentPane().add(a34);
        a34.setBounds(1377, 240, 25, 50);

        k34.setName("125"); // NOI18N
        getContentPane().add(k34);
        k34.setBounds(1377, 300, 25, 50);

        k35.setName("126"); // NOI18N
        getContentPane().add(k35);
        k35.setBounds(1377, 360, 25, 50);

        h21.setName("127"); // NOI18N
        getContentPane().add(h21);
        h21.setBounds(1377, 419, 25, 50);

        h22.setName("128"); // NOI18N
        getContentPane().add(h22);
        h22.setBounds(1377, 477, 25, 50);

        f23.setName("129"); // NOI18N
        getContentPane().add(f23);
        f23.setBounds(1377, 532, 25, 50);

        k36.setName("130"); // NOI18N
        getContentPane().add(k36);
        k36.setBounds(1377, 590, 25, 50);

        i2.setName("131"); // NOI18N
        getContentPane().add(i2);
        i2.setBounds(1360, 650, 50, 87);

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(36, 41, 44));
        jTextField1.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setText("Palyer Blue");
        jTextField1.setText(jatekosok[0].getNev());
        jTextField1.setBorder(null);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(32, 62, 130, 30);

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(36, 41, 44));
        jTextField2.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextField2.setText("Player Red");
        jTextField2.setText(jatekosok[1].getNev());
        jTextField2.setBorder(null);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(1375, 62, 130, 30);

        jTextField3.setEditable(false);
        jTextField3.setBackground(new java.awt.Color(36, 41, 44));
        jTextField3.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(255, 255, 255));
        jTextField3.setText("♥♥♥♥♥♥♥♥♥♥");
        jTextField3.setText(Integer.toString(jatekosok[0].getElet()+jatekosok[0].getPajzs()));
        jTextField3.setToolTipText("");
        jTextField3.setBorder(null);
        getContentPane().add(jTextField3);
        jTextField3.setBounds(250, 80, 110, 10);

        jTextField4.setEditable(false);
        jTextField4.setBackground(new java.awt.Color(36, 41, 44));
        jTextField4.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(255, 255, 255));
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextField4.setText("♥♥♥♥♥♥♥♥♥♥");
        jTextField4.setText(Integer.toString(jatekosok[1].getElet()+jatekosok[1].getPajzs()));
        jTextField4.setToolTipText("");
        jTextField4.setBorder(null);
        getContentPane().add(jTextField4);
        jTextField4.setBounds(1179, 80, 110, 10);

        jTextField5.setEditable(false);
        jTextField5.setBackground(new java.awt.Color(36, 41, 44));
        jTextField5.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(255, 255, 255));
        jTextField5.setText("♥♥♥♥♥♥♥♥♥♥");
        jTextField5.setText(Integer.toString(jatekosok[0].getFegyver()));
        jTextField5.setBorder(null);
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField5);
        jTextField5.setBounds(250, 97, 90, 10);
        getContentPane().add(jProgressBar1);
        jProgressBar1.setBounds(542, 63, 480, 8);

        jTextField6.setEditable(false);
        jTextField6.setBackground(new java.awt.Color(36, 41, 44));
        jTextField6.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(255, 255, 255));
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextField6.setText("♥♥♥♥♥♥♥♥♥♥");
        jTextField6.setText(Integer.toString(jatekosok[1].getFegyver()));
        jTextField6.setBorder(null);
        getContentPane().add(jTextField6);
        jTextField6.setBounds(1199, 97, 90, 10);
        getContentPane().add(jProgressBar2);
        jProgressBar2.setBounds(542, 91, 480, 8);

        jTextField7.setEditable(false);
        jTextField7.setBackground(new java.awt.Color(36, 41, 44));
        jTextField7.setFont(new java.awt.Font("Bahnschrift", 1, 10)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(255, 255, 255));
        jTextField7.setText("Élet erő:");
        jTextField7.setBorder(null);
        getContentPane().add(jTextField7);
        jTextField7.setBounds(30, 23, 50, 10);

        jTextField8.setEditable(false);
        jTextField8.setBackground(new java.awt.Color(36, 41, 44));
        jTextField8.setFont(new java.awt.Font("Bahnschrift", 1, 10)); // NOI18N
        jTextField8.setForeground(new java.awt.Color(255, 255, 255));
        jTextField8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField8.setText("100%");
        jTextField8.setBorder(null);
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField8);
        jTextField8.setBounds(93, 23, 30, 10);

        jTextField9.setEditable(false);
        jTextField9.setBackground(new java.awt.Color(36, 41, 44));
        jTextField9.setFont(new java.awt.Font("Bahnschrift", 1, 10)); // NOI18N
        jTextField9.setForeground(new java.awt.Color(255, 255, 255));
        jTextField9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField9.setText("1000");
        jTextField9.setText(Integer.toString(jatekosok[0].getElet()));
        jTextField9.setBorder(null);
        getContentPane().add(jTextField9);
        jTextField9.setBounds(130, 23, 30, 10);

        jTextField10.setEditable(false);
        jTextField10.setBackground(new java.awt.Color(36, 41, 44));
        jTextField10.setFont(new java.awt.Font("Bahnschrift", 1, 10)); // NOI18N
        jTextField10.setForeground(new java.awt.Color(255, 255, 255));
        jTextField10.setText("Pajzs:");
        jTextField10.setBorder(null);
        getContentPane().add(jTextField10);
        jTextField10.setBounds(30, 43, 50, 10);

        jTextField11.setEditable(false);
        jTextField11.setBackground(new java.awt.Color(36, 41, 44));
        jTextField11.setFont(new java.awt.Font("Bahnschrift", 1, 10)); // NOI18N
        jTextField11.setForeground(new java.awt.Color(255, 255, 255));
        jTextField11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField11.setText("100%");
        jTextField11.setBorder(null);
        getContentPane().add(jTextField11);
        jTextField11.setBounds(93, 43, 30, 10);

        jTextField12.setEditable(false);
        jTextField12.setBackground(new java.awt.Color(36, 41, 44));
        jTextField12.setFont(new java.awt.Font("Bahnschrift", 1, 10)); // NOI18N
        jTextField12.setForeground(new java.awt.Color(255, 255, 255));
        jTextField12.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField12.setText("1000");
        jTextField12.setText(Integer.toString(jatekosok[0].getPajzs()));
        jTextField12.setBorder(null);
        jTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField12);
        jTextField12.setBounds(130, 43, 30, 10);

        jTextField13.setEditable(false);
        jTextField13.setBackground(new java.awt.Color(36, 41, 44));
        jTextField13.setFont(new java.awt.Font("Bahnschrift", 1, 10)); // NOI18N
        jTextField13.setForeground(new java.awt.Color(255, 255, 255));
        jTextField13.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextField13.setText(":Élet erő");
        jTextField13.setBorder(null);
        getContentPane().add(jTextField13);
        jTextField13.setBounds(1458, 23, 50, 10);

        jTextField14.setEditable(false);
        jTextField14.setBackground(new java.awt.Color(36, 41, 44));
        jTextField14.setFont(new java.awt.Font("Bahnschrift", 1, 10)); // NOI18N
        jTextField14.setForeground(new java.awt.Color(255, 255, 255));
        jTextField14.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField14.setText("100%");
        jTextField14.setBorder(null);
        getContentPane().add(jTextField14);
        jTextField14.setBounds(1418, 23, 26, 10);

        jTextField15.setEditable(false);
        jTextField15.setBackground(new java.awt.Color(36, 41, 44));
        jTextField15.setFont(new java.awt.Font("Bahnschrift", 1, 10)); // NOI18N
        jTextField15.setForeground(new java.awt.Color(255, 255, 255));
        jTextField15.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField15.setText("1000");
        jTextField15.setText(Integer.toString(jatekosok[1].getElet()));
        jTextField15.setBorder(null);
        getContentPane().add(jTextField15);
        jTextField15.setBounds(1380, 23, 30, 10);

        jTextField16.setEditable(false);
        jTextField16.setBackground(new java.awt.Color(36, 41, 44));
        jTextField16.setFont(new java.awt.Font("Bahnschrift", 1, 10)); // NOI18N
        jTextField16.setForeground(new java.awt.Color(255, 255, 255));
        jTextField16.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextField16.setText(":Pajzs");
        jTextField16.setBorder(null);
        getContentPane().add(jTextField16);
        jTextField16.setBounds(1448, 43, 60, 10);

        jTextField17.setEditable(false);
        jTextField17.setBackground(new java.awt.Color(36, 41, 44));
        jTextField17.setFont(new java.awt.Font("Bahnschrift", 1, 10)); // NOI18N
        jTextField17.setForeground(new java.awt.Color(255, 255, 255));
        jTextField17.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField17.setText("100%");
        jTextField17.setBorder(null);
        getContentPane().add(jTextField17);
        jTextField17.setBounds(1418, 43, 26, 10);

        jTextField18.setEditable(false);
        jTextField18.setBackground(new java.awt.Color(36, 41, 44));
        jTextField18.setFont(new java.awt.Font("Bahnschrift", 1, 10)); // NOI18N
        jTextField18.setForeground(new java.awt.Color(255, 255, 255));
        jTextField18.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField18.setText("1000");
        jTextField18.setText(Integer.toString(jatekosok[0].getPajzs()));
        jTextField18.setBorder(null);
        getContentPane().add(jTextField18);
        jTextField18.setBounds(1380, 43, 30, 10);

        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jButton1.setName("dobkek"); // NOI18N
        getContentPane().add(jButton1);
        jButton1.setBounds(278, 8, 27, 27);

        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jButton2.setName("dobpiros"); // NOI18N
        getContentPane().add(jButton2);
        jButton2.setBounds(1231, 8, 27, 27);

        jButton3.setBorder(null);
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jButton3.setName("sugo"); // NOI18N
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(235, 8, 27, 27);

        jButton4.setBorder(null);
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jButton4.setName(""); // NOI18N
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(1275, 8, 27, 27);

        jTextField19.setEditable(false);
        jTextField19.setBackground(new java.awt.Color(36, 41, 44));
        jTextField19.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jTextField19.setForeground(new java.awt.Color(255, 255, 255));
        jTextField19.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField19.setText("●");
        jTextField19.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.white, java.awt.Color.gray, java.awt.Color.white));
        jTextField19.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTextField19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField19MouseClicked(evt);
            }
        });
        getContentPane().add(jTextField19);
        jTextField19.setBounds(410, 30, 75, 75);

        jTextField20.setEditable(false);
        jTextField20.setBackground(new java.awt.Color(36, 41, 44));
        jTextField20.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jTextField20.setForeground(new java.awt.Color(255, 255, 255));
        jTextField20.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField20.setText("●");
        jTextField20.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.white, java.awt.Color.gray, java.awt.Color.white));
        jTextField20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTextField20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField20MouseClicked(evt);
            }
        });
        getContentPane().add(jTextField20);
        jTextField20.setBounds(1070, 30, 75, 75);

        jLabel1.setName("6"); // NOI18N
        jLabel1.setOpaque(true);
        jLabel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jLabel1KeyReleased(evt);
            }
        });
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 0, 0);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(660, 834, 320, 30);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kepek/as.png"))); // NOI18N
        jLabel2.setToolTipText("");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel2KeyPressed(evt);
            }
        });
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1530, 870);
        jLabel2.requestFocus();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel1KeyReleased
       
    }//GEN-LAST:event_jLabel1KeyReleased

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        
    }//GEN-LAST:event_formKeyReleased

    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField19MouseClicked
        if (kor%2==0 && nyomhatoe){
            jTextField19.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.white, java.awt.Color.gray, java.awt.Color.white));
            nyomhatoe=false;
            t=new Thread(new Runnable() {
                @Override
                public void run() {
                    int eredeti;
                    int dob=(int)(Math.random()*6+1);
                   
                    jTextField19.setText(Integer.toString(dob));
                    
                    if (jatekosok[0].getHelyzet()==-1){ i1.setIcon(new ImageIcon());}
                    else {
                            mezok1[jatekosok[0].getHelyzet()].setIcon(new ImageIcon());}
                    
                   jatekosok[0].setHelyzet(jatekosok[0].getHelyzet()+dob);
                
                    if (jatekosok[1].getHelyzet()<=-1 || jatekosok[0].getHelyzet()>=133){
                        Vege();
                        return;
                    }
             
                try {
                    if(jatekosok[0].getHelyzet()<=-1){i1.setIcon(new ImageIcon(new URL(jatekosok[0].getKarakter()+"/"+mezok[jatekosok[0].getHelyzet()].getAllas()+".png")));}
                    else{
                    mezok1[jatekosok[0].getHelyzet()].setIcon(new ImageIcon(new URL(jatekosok[0].getKarakter()+"/"+mezok[jatekosok[0].getHelyzet()].getAllas()+".png"))); }
                } catch (MalformedURLException ex) {
                    Logger.getLogger(TablaGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    eredeti=jatekosok[0].getHelyzet();
                   if (jatekosok[0].getHelyzet()>72 && jatekosok[0].getHelyzet()<87){
                       setVisible(false); 
                       nyomhatoe=true;mezok1[jatekosok[0].getHelyzet()].setIcon(new ImageIcon());
                       HarcPvG(0);
                       return;
                   }
                   else{
                    mezok[jatekosok[0].getHelyzet()].Feladat(jatekosok[0], 1, jatekosok[1]);
                   }
                    jLabel3.setText(jatekosok[0].getNev()+": "+mezok[jatekosok[0].getHelyzet()].getSzoveg());
                    jatekosok[0]=mezok[jatekosok[0].getHelyzet()].getJatekos();
                    Thread.sleep(ido);
                    if (eredeti!=jatekosok[0].getHelyzet()){
                        mezok1[eredeti].setIcon(new ImageIcon());
                        mezok1[jatekosok[0].getHelyzet()].setIcon(new ImageIcon(new URL(jatekosok[0].getKarakter()+"/"+mezok[jatekosok[0].getHelyzet()].getAllas()+".png")));
                      
                        if (mezok[jatekosok[0].getHelyzet()].getTipus()!=null){
                           mezok[jatekosok[0].getHelyzet()].Feladat(jatekosok[0], 1, jatekosok[1]);
                           //harcmezo megnyitása ha kell
                           if (jatekosok[0].getHarcol() && jatekosok[1].getHarcol()){nyomhatoe=true;mezok1[jatekosok[0].getHelyzet()].setIcon(new ImageIcon());mezok1[jatekosok[1].getHelyzet()].setIcon(new ImageIcon()); setVisible(false); HarcPvP(); return;}
                          
                        }
                    }
                    else if (jatekosok[0].getHarcol() && jatekosok[1].getHarcol()){nyomhatoe=true;mezok1[jatekosok[0].getHelyzet()].setIcon(new ImageIcon());mezok1[jatekosok[1].getHelyzet()].setIcon(new ImageIcon()); setVisible(false); HarcPvP(); return;}
            } catch (CloneNotSupportedException ex) {
                ex.printStackTrace();
            }catch (MalformedURLException ex) {
                Logger.getLogger(TablaGUI.class.getName()).log(Level.SEVERE, null, ex);
            }       catch (InterruptedException ex) {
                        Logger.getLogger(TablaGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }

               // Játék végének ellenörzése
               kor++;

               if (jatekosok[1].getHanykorbol()>0){
                   kor++;
                   jatekosok[1].setKimarad(jatekosok[1].getHanykorbol()-1);
                   jLabel3.setText(jatekosok[0].getNev()+" következik!");
                  jTextField19.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.yellow, java.awt.Color.yellow, java.awt.Color.yellow, java.awt.Color.yellow));
               }
               
               else if (jatekosok[0].getHanykorbol()>0 && jatekosok[1].getHanykorbol()>0){
                   if (jatekosok[0].getHanykorbol()<jatekosok[1].getHanykorbol()){
                       jatekosok[1].setKimarad(jatekosok[1].getHanykorbol()-jatekosok[0].getHanykorbol());
                       jatekosok[0].setKimarad(0);
                       if (kor%2!=0){kor++;}
                       jLabel3.setText(jatekosok[0].getNev()+" következik!");
                        jTextField19.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.yellow, java.awt.Color.yellow, java.awt.Color.yellow, java.awt.Color.yellow));
                   }
                   else if (jatekosok[0].getHanykorbol()>jatekosok[1].getHanykorbol()){
                       jatekosok[0].setKimarad(jatekosok[0].getHanykorbol()-jatekosok[1].getHanykorbol());
                       jatekosok[1].setKimarad(0);
                       if (kor%2==0){kor++;}
                       jLabel3.setText(jatekosok[1].getNev()+" következik!");
                        jTextField20.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.yellow, java.awt.Color.yellow, java.awt.Color.yellow, java.awt.Color.yellow));
                   }
                   else{
                       jatekosok[0].setKimarad(0);
                       jatekosok[1].setKimarad(0);
                       if (kor%2==0){kor++;}
                        jLabel3.setText(jatekosok[1].getNev()+" következik!");
                    jTextField20.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.yellow, java.awt.Color.yellow, java.awt.Color.yellow, java.awt.Color.yellow));
                   }
               }
               
               
               
               else{
                   jLabel3.setText(jatekosok[1].getNev()+" következik!");
            jTextField20.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.yellow, java.awt.Color.yellow, java.awt.Color.yellow, java.awt.Color.yellow));}
            nyomhatoe=true;
            
            
            
            fildek();
                }
            });
            t.start();
            
          

              
        }
    }//GEN-LAST:event_jTextField19MouseClicked

    private void jTextField20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField20MouseClicked
        if (kor%2==1 && nyomhatoe){
           jTextField20.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.white, java.awt.Color.gray, java.awt.Color.white));
            nyomhatoe=false;
            t=new Thread(new Runnable() {
                @Override
                public void run() {
                    int eredeti;
                    int dob=(int)(Math.random()*6+1);
             
                    jTextField20.setText(Integer.toString(dob));
                    
                    if (jatekosok[1].getHelyzet()==133){ i2.setIcon(new ImageIcon());System.out.println("be");}
                    else {
                            mezok1[jatekosok[1].getHelyzet()].setIcon(new ImageIcon());}
                    
                   jatekosok[1].setHelyzet(jatekosok[1].getHelyzet()-dob);
                  
                    if (jatekosok[1].getHelyzet()<=-1 || jatekosok[0].getHelyzet()>=133){
                        Vege();
                        return;
                    }
            
                try {
                    if(jatekosok[1].getHelyzet()>=133){i2.setIcon(new ImageIcon(new URL(jatekosok[1].getKarakter()+"/"+mezok[jatekosok[1].getHelyzet()].getAllas()+".png")));}
                    else{
                    mezok1[jatekosok[1].getHelyzet()].setIcon(new ImageIcon(new URL(jatekosok[1].getKarakter()+"/"+mezok[jatekosok[1].getHelyzet()].getAllas()+".png")));} 
                } catch (MalformedURLException ex) {
                    ex.printStackTrace();
                }
                try {
                    eredeti=jatekosok[1].getHelyzet();
                    if (jatekosok[1].getHelyzet()>72 && jatekosok[1].getHelyzet()<87){
                        setVisible(false);
                       nyomhatoe=true;mezok1[jatekosok[1].getHelyzet()].setIcon(new ImageIcon());
                       HarcPvG(1);
                       return;
                   }
                   else{
                    mezok[jatekosok[1].getHelyzet()].Feladat(jatekosok[1], -1, jatekosok[0]);}
                    jLabel3.setText(jatekosok[1].getNev()+": "+mezok[jatekosok[1].getHelyzet()].getSzoveg());
                    jatekosok[1]=mezok[jatekosok[1].getHelyzet()].getJatekos();
                    Thread.sleep(ido);
                    if (eredeti!=jatekosok[1].getHelyzet()){
                        mezok1[eredeti].setIcon(new ImageIcon());
                        mezok1[jatekosok[1].getHelyzet()].setIcon(new ImageIcon(new URL(jatekosok[1].getKarakter()+"/"+mezok[jatekosok[1].getHelyzet()].getAllas()+".png")));
                      
                        if (mezok[jatekosok[1].getHelyzet()].getTipus()!=null){
                           mezok[jatekosok[1].getHelyzet()].Feladat(jatekosok[1], -1, jatekosok[0]);
                           if (jatekosok[0].getHarcol() && jatekosok[1].getHarcol()){setVisible(false);mezok1[jatekosok[0].getHelyzet()].setIcon(new ImageIcon());mezok1[jatekosok[1].getHelyzet()].setIcon(new ImageIcon());nyomhatoe=true;HarcPvP(); return;}
                        }
                    }
                    else if (jatekosok[0].getHarcol() && jatekosok[1].getHarcol()){setVisible(false);mezok1[jatekosok[0].getHelyzet()].setIcon(new ImageIcon());mezok1[jatekosok[1].getHelyzet()].setIcon(new ImageIcon());nyomhatoe=true;HarcPvP();return;}
            } catch (CloneNotSupportedException ex) {
                ex.printStackTrace();
            }catch (MalformedURLException ex) {
                Logger.getLogger(TablaGUI.class.getName()).log(Level.SEVERE, null, ex);
            }       catch (InterruptedException ex) {
                        Logger.getLogger(TablaGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
               kor++;
               if (jatekosok[0].getHanykorbol()>0 && jatekosok[1].getHanykorbol()<=0){
                   kor++;
                   jatekosok[0].setKimarad(jatekosok[0].getHanykorbol()-1);
                   jLabel3.setText(jatekosok[1].getNev()+" következik!");
                   jTextField20.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.yellow, java.awt.Color.yellow, java.awt.Color.yellow, java.awt.Color.yellow));
               }
               else if (jatekosok[0].getHanykorbol()>0 && jatekosok[1].getHanykorbol()>0){
                   if (jatekosok[0].getHanykorbol()<jatekosok[1].getHanykorbol()){
                       jatekosok[1].setKimarad(jatekosok[1].getHanykorbol()-jatekosok[0].getHanykorbol());
                       jatekosok[0].setKimarad(0);
                       if (kor%2!=0){kor++;}
                       jLabel3.setText(jatekosok[0].getNev()+" következik!");
                        jTextField19.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.yellow, java.awt.Color.yellow, java.awt.Color.yellow, java.awt.Color.yellow));
                   }
                   else if (jatekosok[0].getHanykorbol()>jatekosok[1].getHanykorbol()){
                       jatekosok[0].setKimarad(jatekosok[0].getHanykorbol()-jatekosok[1].getHanykorbol());
                       jatekosok[1].setKimarad(0);
                       if (kor%2==0){kor++;}
                       jLabel3.setText(jatekosok[1].getNev()+" következik!");
                        jTextField20.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.yellow, java.awt.Color.yellow, java.awt.Color.yellow, java.awt.Color.yellow));
                   }
                   else{
                       jatekosok[0].setKimarad(0);
                       jatekosok[1].setKimarad(0);
                       if (kor%2!=0){kor++;}
                        jLabel3.setText(jatekosok[0].getNev()+" következik!");
                    jTextField19.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.yellow, java.awt.Color.yellow, java.awt.Color.yellow, java.awt.Color.yellow));
                   }
               }
               
               else{
               jLabel3.setText(jatekosok[0].getNev()+" következik!");
            jTextField19.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.yellow, java.awt.Color.yellow, java.awt.Color.yellow, java.awt.Color.yellow));}
            nyomhatoe=true;
            //ell
            fildek();
                }
            });
            t.start();
        }
    }//GEN-LAST:event_jTextField20MouseClicked

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jLabel2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel2KeyPressed
        
                           
    }//GEN-LAST:event_jLabel2KeyPressed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
       new SugoGUI().setVisible(true);
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        new SugoGUI().setVisible(true);
    }//GEN-LAST:event_jButton4MouseClicked

   
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
            java.util.logging.Logger.getLogger(TablaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TablaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TablaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TablaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TablaGUI().setVisible(true);
            }
        });
    }
    public void Mezo1Feltoltese(){
        int i=0;
        
        
        
        mezok1[i]=k1;
        mezok1[i].setBounds(k1.getBounds().x, k1.getBounds().y, k1.getBounds().width, k1.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        mezok1[i]=f1;
        mezok1[i].setBounds(f1.getBounds().x, f1.getBounds().y, f1.getBounds().width, f1.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        mezok1[i]=h1;
        mezok1[i].setBounds(h1.getBounds().x, h1.getBounds().y, h1.getBounds().width, h1.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
                
        mezok1[i]=h2;
        mezok1[i].setBounds(h2.getBounds().x, h2.getBounds().y, h2.getBounds().width, h2.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        mezok1[i]=k2;
        mezok1[i].setBounds(k2.getBounds().x, k2.getBounds().y, k2.getBounds().width, k2.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        mezok1[i]=k3;
        mezok1[i].setBounds(k3.getBounds().x, k3.getBounds().y, k3.getBounds().width, k3.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        mezok1[i]=a1;
        mezok1[i].setBounds(a1.getBounds().x, a1.getBounds().y, a1.getBounds().width, a1.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        mezok1[i]=a2;
        mezok1[i].setBounds(a2.getBounds().x, a2.getBounds().y, a2.getBounds().width, a2.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        
        
        ///////////////////////////////////////////
        
        
        
        mezok1[i]=f2;
        mezok1[i].setBounds(f2.getBounds().x, f2.getBounds().y, f2.getBounds().width, f2.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        
        
        /////////////////////////////////////////////////
        
        
        
        mezok1[i]=h3;
        mezok1[i].setBounds(h3.getBounds().x, h3.getBounds().y, h3.getBounds().width, h3.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        mezok1[i]=k4;
        mezok1[i].setBounds(k4.getBounds().x, k4.getBounds().y, k4.getBounds().width, k4.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        mezok1[i]=k5;
        mezok1[i].setBounds(k5.getBounds().x, k5.getBounds().y, k5.getBounds().width, k5.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        mezok1[i]=f3;
        mezok1[i].setBounds(f3.getBounds().x, f3.getBounds().y, f3.getBounds().width, f3.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        mezok1[i]=f4;
        mezok1[i].setBounds(f4.getBounds().x, f4.getBounds().y, f4.getBounds().width, f4.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        
        //A3
        mezok1[i]=a3;
        mezok1[i].setBounds(a3.getBounds().x, a3.getBounds().y, a3.getBounds().width, a3.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        mezok1[i]=a4;
        mezok1[i].setBounds(a4.getBounds().x, a4.getBounds().y, a4.getBounds().width, a4.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        mezok1[i]=a5;
        mezok1[i].setBounds(a5.getBounds().x, a5.getBounds().y, a5.getBounds().width, a5.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        mezok1[i]=f5;
        mezok1[i].setBounds(f5.getBounds().x, f5.getBounds().y, f5.getBounds().width, f5.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        mezok1[i]=f6;
        mezok1[i].setBounds(f6.getBounds().x, f6.getBounds().y, f6.getBounds().width, f6.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        
        
        //////////////////////////
        
        
        
        
        mezok1[i]=k6;
        mezok1[i].setBounds(k6.getBounds().x, k6.getBounds().y, k6.getBounds().width, k6.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        
        
        //////////////////////
        
        
        //h4 h5 k7 k8 a6 a7 a8 f7 h6 h7 // k9
        mezok1[i]=h4;
        mezok1[i].setBounds(h4.getBounds().x, h4.getBounds().y, h4.getBounds().width, h4.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        mezok1[i]=h5;
        mezok1[i].setBounds(h5.getBounds().x, h5.getBounds().y, h5.getBounds().width, h5.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        mezok1[i]=k7;
        mezok1[i].setBounds(k7.getBounds().x, k7.getBounds().y, k7.getBounds().width, k7.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        mezok1[i]=k8;
        mezok1[i].setBounds(k8.getBounds().x, k8.getBounds().y, k8.getBounds().width, k8.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        mezok1[i]=a6;
        mezok1[i].setBounds(a6.getBounds().x, a6.getBounds().y, a6.getBounds().width, a6.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        mezok1[i]=a7;
        mezok1[i].setBounds(a7.getBounds().x, a7.getBounds().y, a7.getBounds().width, a7.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        mezok1[i]=a8;
        mezok1[i].setBounds(a8.getBounds().x, a8.getBounds().y, a8.getBounds().width, a8.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        mezok1[i]=f7;
        mezok1[i].setBounds(f7.getBounds().x, f7.getBounds().y, f7.getBounds().width, f7.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        mezok1[i]=h6;
        mezok1[i].setBounds(h6.getBounds().x, h6.getBounds().y, h6.getBounds().width, h6.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        mezok1[i]=h7;
        mezok1[i].setBounds(h7.getBounds().x, h7.getBounds().y, h7.getBounds().width, h7.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        mezok1[i]=k9;
        mezok1[i].setBounds(k9.getBounds().x, k9.getBounds().y, k9.getBounds().width, k9.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        mezok1[i]=k10;
        mezok1[i].setBounds(k10.getBounds().x, k10.getBounds().y, k10.getBounds().width, k10.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        mezok1[i]=k11;
        mezok1[i].setBounds(k11.getBounds().x, k11.getBounds().y, k11.getBounds().width, k11.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        mezok1[i]=k12;
        mezok1[i].setBounds(k12.getBounds().x, k12.getBounds().y, k12.getBounds().width, k12.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        mezok1[i]=a9;
        mezok1[i].setBounds(a9.getBounds().x, a9.getBounds().y, a9.getBounds().width, a9.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        mezok1[i]=a10;
        mezok1[i].setBounds(a10.getBounds().x, a10.getBounds().y, a10.getBounds().width, a10.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        mezok1[i]=a11;
        mezok1[i].setBounds(a11.getBounds().x, a11.getBounds().y, a11.getBounds().width, a11.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        mezok1[i]=a12;
        mezok1[i].setBounds(a12.getBounds().x, a12.getBounds().y, a12.getBounds().width, a12.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        mezok1[i]=k13;
        mezok1[i].setBounds(k13.getBounds().x, k13.getBounds().y, k13.getBounds().width, k13.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        mezok1[i]=k14;
        mezok1[i].setBounds(k14.getBounds().x, k14.getBounds().y, k14.getBounds().width, k14.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        
        
        //////////////////////
        
        
        
        mezok1[i]=k15;
        mezok1[i].setBounds(k15.getBounds().x, k15.getBounds().y, k15.getBounds().width, k15.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        mezok1[i]=k16;
        mezok1[i].setBounds(k16.getBounds().x, k16.getBounds().y, k16.getBounds().width, k16.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        mezok1[i]=h8;
        mezok1[i].setBounds(h8.getBounds().x, h8.getBounds().y, h8.getBounds().width, h8.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        mezok1[i]=h9;
        mezok1[i].setBounds(h9.getBounds().x, h9.getBounds().y, h9.getBounds().width, h9.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        mezok1[i]=f8;
        mezok1[i].setBounds(f8.getBounds().x, f8.getBounds().y, f8.getBounds().width, f8.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        mezok1[i]=a13;
        mezok1[i].setBounds(a13.getBounds().x, a13.getBounds().y, a13.getBounds().width, a13.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        mezok1[i]=a14;
        mezok1[i].setBounds(a14.getBounds().x, a14.getBounds().y, a14.getBounds().width, a14.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        mezok1[i]=a15;
        mezok1[i].setBounds(a15.getBounds().x, a15.getBounds().y, a15.getBounds().width, a15.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        mezok1[i]=k17;
        mezok1[i].setBounds(k17.getBounds().x, k17.getBounds().y, k17.getBounds().width, k17.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        mezok1[i]=k18;
        mezok1[i].setBounds(k18.getBounds().x, k18.getBounds().y, k18.getBounds().width, k18.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        
        
        mezok1[i]=h10;
        mezok1[i].setBounds(h10.getBounds().x, h10.getBounds().y, h10.getBounds().width, h10.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        mezok1[i]=h11;
        mezok1[i].setBounds(h11.getBounds().x, h11.getBounds().y, h11.getBounds().width, h11.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        
        
        
        ///////////////////////////////////////
        
        
        
        
        mezok1[i]=k19;
        mezok1[i].setBounds(k19.getBounds().x, k19.getBounds().y, k19.getBounds().width, k19.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        
        
        //////////////////////////////////////
        
        
        
        mezok1[i]=f9;
        mezok1[i].setBounds(f9.getBounds().x, f9.getBounds().y, f9.getBounds().width, f9.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        mezok1[i]=f10;
        mezok1[i].setBounds(f10.getBounds().x, f10.getBounds().y, f10.getBounds().width, f10.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        mezok1[i]=a16;
        mezok1[i].setBounds(a16.getBounds().x, a16.getBounds().y, a16.getBounds().width, a16.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        mezok1[i]=a17;
        mezok1[i].setBounds(a17.getBounds().x, a17.getBounds().y, a17.getBounds().width, a17.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        mezok1[i]=a18;
        mezok1[i].setBounds(a18.getBounds().x, a18.getBounds().y, a18.getBounds().width, a18.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        mezok1[i]=f11;
        mezok1[i].setBounds(f11.getBounds().x, f11.getBounds().y, f11.getBounds().width, f11.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        mezok1[i]=a19;
        mezok1[i].setBounds(a19.getBounds().x, a19.getBounds().y, a19.getBounds().width, a19.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        
        
        /////////////////////////////////////////
        
        
        
        
        mezok1[i]=t1;
        mezok1[i].setBounds(t1.getBounds().x, t1.getBounds().y, t1.getBounds().width, t1.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        mezok1[i]=f12;
        mezok1[i].setBounds(f12.getBounds().x, f12.getBounds().y, f12.getBounds().width, f12.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        mezok1[i]=k20;
        mezok1[i].setBounds(k20.getBounds().x, k20.getBounds().y, k20.getBounds().width, k20.getBounds().height);
        mezok1[i].setVisible(true);
        i++;

        mezok1[i]=k21;
        mezok1[i].setBounds(k21.getBounds().x, k21.getBounds().y, k21.getBounds().width, k21.getBounds().height);
        mezok1[i].setVisible(true);
        i++;

        mezok1[i]=k22;
        mezok1[i].setBounds(k22.getBounds().x, k22.getBounds().y, k22.getBounds().width, k22.getBounds().height);
        mezok1[i].setVisible(true);
        i++;

        mezok1[i]=a20;
        mezok1[i].setBounds(a20.getBounds().x, a20.getBounds().y, a20.getBounds().width, a20.getBounds().height);
        mezok1[i].setVisible(true);
        i++;

        mezok1[i]=h12;
        mezok1[i].setBounds(h12.getBounds().x, h12.getBounds().y, h12.getBounds().width, h12.getBounds().height);
        mezok1[i].setVisible(true);
        i++;

        mezok1[i]=h13;
        mezok1[i].setBounds(h13.getBounds().x, h13.getBounds().y, h13.getBounds().width, h13.getBounds().height);
        mezok1[i].setVisible(true);
        i++;

        mezok1[i]=k23;
        mezok1[i].setBounds(k23.getBounds().x, k23.getBounds().y, k23.getBounds().width, k23.getBounds().height);
        mezok1[i].setVisible(true);
        i++;

        mezok1[i]=h14;
        mezok1[i].setBounds(h14.getBounds().x, h14.getBounds().y, h14.getBounds().width, h14.getBounds().height);
        mezok1[i].setVisible(true);
        i++;

        mezok1[i]=a21;
        mezok1[i].setBounds(a21.getBounds().x, a21.getBounds().y, a21.getBounds().width, a21.getBounds().height);
        mezok1[i].setVisible(true);
        i++;

        mezok1[i]=f13;
        mezok1[i].setBounds(f13.getBounds().x, f13.getBounds().y, f13.getBounds().width, f13.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        mezok1[i]=t2;
        mezok1[i].setBounds(t2.getBounds().x, t2.getBounds().y, t2.getBounds().width, t2.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        
        mezok1[i]=g1;
        mezok1[i].setBounds(g1.getBounds().x, g1.getBounds().y, g1.getBounds().width, g1.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        mezok1[i]=g2;
        mezok1[i].setBounds(g2.getBounds().x, g2.getBounds().y, g2.getBounds().width, g2.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        mezok1[i]=g3;
        mezok1[i].setBounds(g3.getBounds().x, g3.getBounds().y, g3.getBounds().width, g3.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        mezok1[i]=g4;
        mezok1[i].setBounds(g4.getBounds().x, g4.getBounds().y, g4.getBounds().width, g4.getBounds().height);
        mezok1[i].setVisible(true);
        i++;

        mezok1[i]=g5;
        mezok1[i].setBounds(g5.getBounds().x, g5.getBounds().y, g5.getBounds().width, g5.getBounds().height);
        mezok1[i].setVisible(true);
        i++;

        mezok1[i]=g6;
        mezok1[i].setBounds(g6.getBounds().x, g6.getBounds().y, g6.getBounds().width, g6.getBounds().height);
        mezok1[i].setVisible(true);
        i++;

        mezok1[i]=g7;
        mezok1[i].setBounds(g7.getBounds().x, g7.getBounds().y, g7.getBounds().width, g7.getBounds().height);
        mezok1[i].setVisible(true);
        i++;

        mezok1[i]=g8;
        mezok1[i].setBounds(g8.getBounds().x, g8.getBounds().y, g8.getBounds().width, g8.getBounds().height);
        mezok1[i].setVisible(true);
        i++;

        mezok1[i]=g9;
        mezok1[i].setBounds(g9.getBounds().x, g9.getBounds().y, g9.getBounds().width, g9.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        mezok1[i]=g10;
        mezok1[i].setBounds(g10.getBounds().x, g10.getBounds().y, g10.getBounds().width, g10.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        mezok1[i]=g11;
        mezok1[i].setBounds(g11.getBounds().x, g11.getBounds().y, g11.getBounds().width, g11.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        mezok1[i]=g12;
        mezok1[i].setBounds(g12.getBounds().x, g12.getBounds().y, g12.getBounds().width, g12.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        mezok1[i]=g13;
        mezok1[i].setBounds(g13.getBounds().x, g13.getBounds().y, g13.getBounds().width, g13.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        mezok1[i]=g1;
        mezok1[i].setBounds(g1.getBounds().x, g1.getBounds().y, g1.getBounds().width, g1.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        
        
        
        mezok1[i]=t2;
        mezok1[i].setBounds(t2.getBounds().x, t2.getBounds().y, t2.getBounds().width, t2.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
         mezok1[i]=f13;
        mezok1[i].setBounds(f13.getBounds().x, f13.getBounds().y, f13.getBounds().width, f13.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        

        mezok1[i]=a22;
        mezok1[i].setBounds(a22.getBounds().x, a22.getBounds().y, a22.getBounds().width, a22.getBounds().height);
        mezok1[i].setVisible(true);
        i++;

        mezok1[i]=a23;
        mezok1[i].setBounds(a23.getBounds().x, a23.getBounds().y, a23.getBounds().width, a23.getBounds().height);
        mezok1[i].setVisible(true);
        i++;

        mezok1[i]=h15;
        mezok1[i].setBounds(h15.getBounds().x, h15.getBounds().y, h15.getBounds().width, h15.getBounds().height);
        mezok1[i].setVisible(true);
        i++;

        mezok1[i]=f14;
        mezok1[i].setBounds(f14.getBounds().x, f14.getBounds().y, f14.getBounds().width, f14.getBounds().height);
        mezok1[i].setVisible(true);
        i++;

        mezok1[i]=k24;
        mezok1[i].setBounds(k24.getBounds().x, k24.getBounds().y, k24.getBounds().width, k24.getBounds().height);
        mezok1[i].setVisible(true);
        i++;

        mezok1[i]=f15;
        mezok1[i].setBounds(f15.getBounds().x, f15.getBounds().y, f15.getBounds().width, f15.getBounds().height);
        mezok1[i].setVisible(true);
        i++;

        mezok1[i]=f16;
        mezok1[i].setBounds(f16.getBounds().x, f16.getBounds().y, f16.getBounds().width, f16.getBounds().height);
        mezok1[i].setVisible(true);
        i++;

        mezok1[i]=a24;
        mezok1[i].setBounds(a24.getBounds().x, a24.getBounds().y, a24.getBounds().width, a24.getBounds().height);
        mezok1[i].setVisible(true);
        i++;

        mezok1[i]=a25;
        mezok1[i].setBounds(a25.getBounds().x, a25.getBounds().y, a25.getBounds().width, a25.getBounds().height);
        mezok1[i].setVisible(true);
        i++;

        mezok1[i]=a26;
        mezok1[i].setBounds(a26.getBounds().x, a26.getBounds().y, a26.getBounds().width, a26.getBounds().height);
        mezok1[i].setVisible(true);
        i++;

        mezok1[i]=k25;
        mezok1[i].setBounds(k25.getBounds().x, k25.getBounds().y, k25.getBounds().width, k25.getBounds().height);
        mezok1[i].setVisible(true);
        i++;

        mezok1[i]=k26;
        mezok1[i].setBounds(k26.getBounds().x, k26.getBounds().y, k26.getBounds().width, k26.getBounds().height);
        mezok1[i].setVisible(true);
        i++;

        mezok1[i]=k27;
        mezok1[i].setBounds(k27.getBounds().x, k27.getBounds().y, k27.getBounds().width, k27.getBounds().height);
        mezok1[i].setVisible(true);
        i++;

        mezok1[i]=k28;
        mezok1[i].setBounds(k28.getBounds().x, k28.getBounds().y, k28.getBounds().width, k28.getBounds().height);
        mezok1[i].setVisible(true);
        i++;

        mezok1[i]=h16;
        mezok1[i].setBounds(h16.getBounds().x, h16.getBounds().y, h16.getBounds().width, h16.getBounds().height);
        mezok1[i].setVisible(true);
        i++;

        mezok1[i]=h17;
        mezok1[i].setBounds(h17.getBounds().x, h17.getBounds().y, h17.getBounds().width, h17.getBounds().height);
        mezok1[i].setVisible(true);
        i++;

        mezok1[i]=f17;
        mezok1[i].setBounds(f17.getBounds().x, f17.getBounds().y, f17.getBounds().width, f17.getBounds().height);
        mezok1[i].setVisible(true);
        i++;

        mezok1[i]=a27;
        mezok1[i].setBounds(a27.getBounds().x, a27.getBounds().y, a27.getBounds().width, a27.getBounds().height);
        mezok1[i].setVisible(true);
        i++;

        mezok1[i]=a28;
        mezok1[i].setBounds(a28.getBounds().x, a28.getBounds().y, a28.getBounds().width, a28.getBounds().height);
        mezok1[i].setVisible(true);
        i++;

        mezok1[i]=a29;
        mezok1[i].setBounds(a29.getBounds().x, a29.getBounds().y, a29.getBounds().width, a29.getBounds().height);
        mezok1[i].setVisible(true);
        i++;

        mezok1[i]=k29;
        mezok1[i].setBounds(k29.getBounds().x, k29.getBounds().y, k29.getBounds().width, k29.getBounds().height);
        mezok1[i].setVisible(true);
        i++;

        mezok1[i]=k30;
        mezok1[i].setBounds(k30.getBounds().x, k30.getBounds().y, k30.getBounds().width, k30.getBounds().height);
        mezok1[i].setVisible(true);
        i++;

        mezok1[i]=h18;
        mezok1[i].setBounds(h18.getBounds().x, h18.getBounds().y, h18.getBounds().width, h18.getBounds().height);
        mezok1[i].setVisible(true);
        i++;

        mezok1[i]=h19;
        mezok1[i].setBounds(h19.getBounds().x, h19.getBounds().y, h19.getBounds().width, h19.getBounds().height);
        mezok1[i].setVisible(true);
        i++;

        mezok1[i]=k31;
        mezok1[i].setBounds(k31.getBounds().x, k31.getBounds().y, k31.getBounds().width, k31.getBounds().height);
        mezok1[i].setVisible(true);
        i++;

        mezok1[i]=f18;
        mezok1[i].setBounds(f18.getBounds().x, f18.getBounds().y, f18.getBounds().width, f18.getBounds().height);
        mezok1[i].setVisible(true);
        i++;

        mezok1[i]=f19;
        mezok1[i].setBounds(f19.getBounds().x, f19.getBounds().y, f19.getBounds().width, f19.getBounds().height);
        mezok1[i].setVisible(true);
        i++;

        mezok1[i]=a30;
        mezok1[i].setBounds(a30.getBounds().x, a30.getBounds().y, a30.getBounds().width, a30.getBounds().height);
        mezok1[i].setVisible(true);
        i++;

        mezok1[i]=a31;
        mezok1[i].setBounds(a31.getBounds().x, a31.getBounds().y, a31.getBounds().width, a31.getBounds().height);
        mezok1[i].setVisible(true);
        i++;

        mezok1[i]=a32;
        mezok1[i].setBounds(a32.getBounds().x, a32.getBounds().y, a32.getBounds().width, a32.getBounds().height);
        mezok1[i].setVisible(true);
        i++;

        mezok1[i]=f20;
        mezok1[i].setBounds(f20.getBounds().x, f20.getBounds().y, f20.getBounds().width, f20.getBounds().height);
        mezok1[i].setVisible(true);
        i++;

        mezok1[i]=f21;
        mezok1[i].setBounds(f21.getBounds().x, f21.getBounds().y, f21.getBounds().width, f21.getBounds().height);
        mezok1[i].setVisible(true);
        i++;

        mezok1[i]=k32;
        mezok1[i].setBounds(k32.getBounds().x, k32.getBounds().y, k32.getBounds().width, k32.getBounds().height);
        mezok1[i].setVisible(true);
        i++;

        mezok1[i]=k33;
        mezok1[i].setBounds(k33.getBounds().x, k33.getBounds().y, k33.getBounds().width, k33.getBounds().height);
        mezok1[i].setVisible(true);
        i++;

        mezok1[i]=h20;
        mezok1[i].setBounds(h20.getBounds().x, h20.getBounds().y, h20.getBounds().width, h20.getBounds().height);
        mezok1[i].setVisible(true);
        i++;

        mezok1[i]=f22;
        mezok1[i].setBounds(f22.getBounds().x, f22.getBounds().y, f22.getBounds().width, f22.getBounds().height);
        mezok1[i].setVisible(true);
        i++;

        mezok1[i]=a33;
        mezok1[i].setBounds(a33.getBounds().x, a33.getBounds().y, a33.getBounds().width, a33.getBounds().height);
        mezok1[i].setVisible(true);
        i++;

        mezok1[i]=a34;
        mezok1[i].setBounds(a34.getBounds().x, a34.getBounds().y, a34.getBounds().width, a34.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
//System.out.println(i);
        mezok1[i]=k34;
        mezok1[i].setBounds(k34.getBounds().x, k34.getBounds().y, k34.getBounds().width, k34.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
//System.out.println(i);
        mezok1[i]=k35;
        mezok1[i].setBounds(k35.getBounds().x, k35.getBounds().y, k35.getBounds().width, k35.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
        //System.out.println(i);
        mezok1[i]=h21;
        mezok1[i].setBounds(h21.getBounds().x, h21.getBounds().y, h21.getBounds().width, h21.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
//System.out.println(i);
        mezok1[i]=h22;
        mezok1[i].setBounds(h22.getBounds().x, h22.getBounds().y, h22.getBounds().width, h22.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
//System.out.println(i);
        mezok1[i]=f23;
        mezok1[i].setBounds(f23.getBounds().x, f23.getBounds().y, f23.getBounds().width, f23.getBounds().height);
        mezok1[i].setVisible(true);
        i++;

        mezok1[i]=k36;
        mezok1[i].setBounds(k36.getBounds().x, k36.getBounds().y, k36.getBounds().width, k36.getBounds().height);
        mezok1[i].setVisible(true);
        i++;
System.out.println(i);

  /*      i=0;

        mezok2[i]=g1;
        mezok2[i].setBounds(g1.getBounds().x, g1.getBounds().y, g1.getBounds().width, g1.getBounds().height);
        mezok2[i].setVisible(true);
        i++;

        mezok2[i]=g2;
        mezok2[i].setBounds(g2.getBounds().x, g2.getBounds().y, g2.getBounds().width, g2.getBounds().height);
        mezok2[i].setVisible(true);
        i++;

        mezok2[i]=g3;
        mezok2[i].setBounds(g3.getBounds().x, g3.getBounds().y, g3.getBounds().width, g3.getBounds().height);
        mezok2[i].setVisible(true);
        i++;

        mezok2[i]=g4;
        mezok2[i].setBounds(g4.getBounds().x, g4.getBounds().y, g4.getBounds().width, g4.getBounds().height);
        mezok2[i].setVisible(true);
        i++;

        mezok2[i]=g5;
        mezok2[i].setBounds(g5.getBounds().x, g5.getBounds().y, g5.getBounds().width, g5.getBounds().height);
        mezok2[i].setVisible(true);
        i++;

        mezok2[i]=g6;
        mezok2[i].setBounds(g6.getBounds().x, g6.getBounds().y, g6.getBounds().width, g6.getBounds().height);
        mezok2[i].setVisible(true);
        i++;

        mezok2[i]=g7;
        mezok2[i].setBounds(g7.getBounds().x, g7.getBounds().y, g7.getBounds().width, g7.getBounds().height);
        mezok2[i].setVisible(true);
        i++;

        mezok2[i]=g8;
        mezok2[i].setBounds(g8.getBounds().x, g8.getBounds().y, g8.getBounds().width, g8.getBounds().height);
        mezok2[i].setVisible(true);
        i++;

        mezok2[i]=g9;
        mezok2[i].setBounds(g9.getBounds().x, g9.getBounds().y, g9.getBounds().width, g9.getBounds().height);
        mezok2[i].setVisible(true);
        i++;*/

        jatekMezok();

    }
    
    public void jatekMezok(){
        mezok[0]=new Mezok(new HarcMezo(0));
        mezok[1]=new Mezok(new ToltoMezo(0));
        mezok[2]=new Mezok(new AkadalyMezo(0));
        mezok[3]=new Mezok(new AkadalyMezo(0));
        mezok[4]=new Mezok(new HarcMezo(0));
        mezok[5]=new Mezok(new HarcMezo(0));
        mezok[6]=new Mezok(new LeptetoMezo(0));
        mezok[7]=new Mezok(new LeptetoMezo(0));
        mezok[8]=new Mezok(new ToltoMezo(90));
        mezok[9]=new Mezok(new AkadalyMezo(180));
        mezok[10]=new Mezok(new HarcMezo(180));
        mezok[11]=new Mezok(new HarcMezo(180));
        mezok[12]=new Mezok(new ToltoMezo(180));
        mezok[13]=new Mezok(new ToltoMezo(180));
        mezok[14]=new Mezok(new LeptetoMezo(180));
        mezok[15]=new Mezok(new LeptetoMezo(180));
        mezok[16]=new Mezok(new LeptetoMezo(180));
        mezok[17]=new Mezok(new ToltoMezo(180));
        mezok[18]=new Mezok(new ToltoMezo(180));
        mezok[19]=new Mezok(new HarcMezo(90));
        mezok[20]=new Mezok(new AkadalyMezo(0));
        mezok[21]=new Mezok(new AkadalyMezo(0));
        mezok[22]=new Mezok(new HarcMezo(0));
        mezok[23]=new Mezok(new HarcMezo(0));
        mezok[24]=new Mezok(new LeptetoMezo(0));
        mezok[25]=new Mezok(new LeptetoMezo(0));
        mezok[26]=new Mezok(new LeptetoMezo(0));
        mezok[27]=new Mezok(new ToltoMezo(0));
        mezok[28]=new Mezok(new AkadalyMezo(0));
        mezok[29]=new Mezok(new AkadalyMezo(0));
        mezok[30]=new Mezok(new HarcMezo(90));
        mezok[31]=new Mezok(new HarcMezo(180));
        mezok[32]=new Mezok(new HarcMezo(180));
        mezok[33]=new Mezok(new HarcMezo(180));
        mezok[34]=new Mezok(new LeptetoMezo(180));
        mezok[35]=new Mezok(new LeptetoMezo(180));
        mezok[36]=new Mezok(new LeptetoMezo(180));
        mezok[37]=new Mezok(new LeptetoMezo(180));
        mezok[38]=new Mezok(new HarcMezo(180));
        mezok[39]=new Mezok(new HarcMezo(180));
        mezok[40]=new Mezok(new HarcMezo(180));
        mezok[41]=new Mezok(new HarcMezo(90));
        mezok[42]=new Mezok(new AkadalyMezo(0));
        mezok[43]=new Mezok(new AkadalyMezo(0));
        mezok[44]=new Mezok(new ToltoMezo(0));
        mezok[45]=new Mezok(new LeptetoMezo(0));
        mezok[46]=new Mezok(new LeptetoMezo(0));
        mezok[47]=new Mezok(new LeptetoMezo(0));
        mezok[48]=new Mezok(new HarcMezo(0));
        mezok[49]=new Mezok(new HarcMezo(0));
        mezok[50]=new Mezok(new AkadalyMezo(0));
        mezok[51]=new Mezok(new AkadalyMezo(0));
        mezok[52]=new Mezok(new HarcMezo(90));
        mezok[53]=new Mezok(new ToltoMezo(180));
        mezok[54]=new Mezok(new ToltoMezo(180));
        mezok[55]=new Mezok(new LeptetoMezo(180));
        mezok[56]=new Mezok(new LeptetoMezo(180));
        mezok[57]=new Mezok(new LeptetoMezo(180));
        mezok[58]=new Mezok(new ToltoMezo(180));
        mezok[59]=new Mezok(new LeptetoMezo(180));
        mezok[60]=new Mezok(new ElkuldoMezo(180));
        mezok[61]=new Mezok(new ToltoMezo(90));
        mezok[62]=new Mezok(new HarcMezo(90));
        mezok[63]=new Mezok(new HarcMezo(90));
        mezok[64]=new Mezok(new HarcMezo(90));
        mezok[65]=new Mezok(new LeptetoMezo(90));
        mezok[66]=new Mezok(new AkadalyMezo(0));
        mezok[67]=new Mezok(new AkadalyMezo(0));
        mezok[68]=new Mezok(new HarcMezo(0));
        mezok[69]=new Mezok(new AkadalyMezo(0));
        mezok[70]=new Mezok(new LeptetoMezo(0));
        //
        mezok[71]=new Mezok(new ToltoMezo(270));
        //
        mezok[72]=new Mezok(new ElkuldoMezo(270));
        mezok[73]=new Mezok(new Mezo(270));
        mezok[74]=new Mezok(new Mezo(270));
        mezok[75]=new Mezok(new Mezo(270));
        mezok[76]=new Mezok(new Mezo(180));
        mezok[77]=new Mezok(new Mezo(180));
        mezok[78]=new Mezok(new Mezo(180));
        mezok[79]=new Mezok(new Mezo(180));
        mezok[80]=new Mezok(new Mezo(90));
        mezok[81]=new Mezok(new Mezo(90));
        mezok[82]=new Mezok(new Mezo(0));
        mezok[83]=new Mezok(new Mezo(0));
        mezok[84]=new Mezok(new Mezo(0));
        mezok[85]=new Mezok(new Mezo(0));
        mezok[86]=new Mezok(new Mezo(90));
        mezok[87]=new Mezok(new ElkuldoMezo(90));
        //
        mezok[88]=new Mezok(new ToltoMezo(90));
        
        
        //
        mezok[89]=new Mezok(new LeptetoMezo(0));
        mezok[90]=new Mezok(new LeptetoMezo(0));
        mezok[91]=new Mezok(new AkadalyMezo(90));
        mezok[92]=new Mezok(new ToltoMezo(180));
        mezok[93]=new Mezok(new HarcMezo(180));
        mezok[94]=new Mezok(new ToltoMezo(180));
        mezok[95]=new Mezok(new ToltoMezo(180));
        mezok[96]=new Mezok(new LeptetoMezo(180));
        mezok[97]=new Mezok(new LeptetoMezo(180));
        mezok[98]=new Mezok(new LeptetoMezo(180));
        mezok[99]=new Mezok(new HarcMezo(180));
        mezok[100]=new Mezok(new HarcMezo(180));
        mezok[101]=new Mezok(new HarcMezo(180));
        mezok[102]=new Mezok(new HarcMezo(90));
        mezok[103]=new Mezok(new AkadalyMezo(0));
        mezok[104]=new Mezok(new AkadalyMezo(0));
        mezok[105]=new Mezok(new ToltoMezo(0));
        mezok[106]=new Mezok(new LeptetoMezo(0));
        mezok[107]=new Mezok(new LeptetoMezo(0));
        mezok[108]=new Mezok(new LeptetoMezo(0));
        mezok[109]=new Mezok(new HarcMezo(0));
        mezok[110]=new Mezok(new HarcMezo(0));
        mezok[111]=new Mezok(new AkadalyMezo(0));
        mezok[112]=new Mezok(new AkadalyMezo(0));
        mezok[113]=new Mezok(new HarcMezo(90));
        mezok[114]=new Mezok(new ToltoMezo(180));
        mezok[115]=new Mezok(new ToltoMezo(180));
        mezok[116]=new Mezok(new LeptetoMezo(180));
        mezok[117]=new Mezok(new LeptetoMezo(180));
        mezok[118]=new Mezok(new LeptetoMezo(180));
        mezok[119]=new Mezok(new ToltoMezo(180));
        mezok[120]=new Mezok(new ToltoMezo(180));
        mezok[121]=new Mezok(new HarcMezo(180));
        mezok[122]=new Mezok(new HarcMezo(180));
        mezok[123]=new Mezok(new AkadalyMezo(180));
        mezok[124]=new Mezok(new ToltoMezo(90));
        mezok[125]=new Mezok(new LeptetoMezo(0));
        mezok[126]=new Mezok(new LeptetoMezo(0));
        mezok[127]=new Mezok(new HarcMezo(0));
        mezok[128]=new Mezok(new HarcMezo(0));
        mezok[129]=new Mezok(new AkadalyMezo(0));
        mezok[130]=new Mezok(new AkadalyMezo(0));
        mezok[131]=new Mezok(new ToltoMezo(0));
        mezok[132]=new Mezok(new HarcMezo(0));
        
    }
    
    public void kiRajz(){
       /* mezok=new Mezok[116];
        mezok1=new JLabel[116];
        mezok2=new JLabel[9];
        
        Mezo1Feltoltese();
        */
        if (jatekosok[0].getHelyzet()==-1){
            try{
                i1.setIcon(new ImageIcon(new URL(jatekosok[0].getKarakter()+"/k.png")));
            }
            catch(Exception e){}
        }
        else {
            
                try{
                   
                 mezok1[jatekosok[0].getHelyzet()].setIcon(new ImageIcon(new URL(jatekosok[0].getKarakter()+"/"+mezok[jatekosok[0].getHelyzet()].getAllas()+".png")));
                }
                catch(Exception e){ System.out.println("igen");}
                    
        }
        
        if (jatekosok[1].getHelyzet()==133){
            try{
                i2.setIcon(new ImageIcon(new URL(jatekosok[1].getKarakter()+"/p.png")));
            }
            catch(Exception e){}
        }
        else {
            
                try{
                 mezok1[jatekosok[1].getHelyzet()].setIcon(new ImageIcon(new URL(jatekosok[1].getKarakter()+"/"+mezok[jatekosok[1].getHelyzet()].getAllas()+".png")));
                }
                catch(Exception e){}
                    
        }
        
        
        
        
        
    }
    public void HarcPvP() throws CloneNotSupportedException, InterruptedException, MalformedURLException{
        //ember vs ember közötti csata
        if (jatekosok[0].getHarcol() && jatekosok[1].getHarcol()){
            BattlemapGUI b=new BattlemapGUI(jatekosok);
            Object o=new Object();
            b.setVisible(true);
            
            Thread t = new Thread() {
        public void run() {
            synchronized(o) {
                while (b.isVisible())
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                setVisible(true);
                try {
                    jatekosok[0]=(Jatekos) (b.jatekosok[0].clone());
                    jatekosok[1]=(Jatekos) (b.jatekosok[1].clone());
                } catch (CloneNotSupportedException ex) {
                    Logger.getLogger(TablaGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                // a bábuk helyére tétele frissitések
               kor++;
               kiRajz();
               if (kor%2==0){jLabel3.setText(jatekosok[0]+"következik"); jTextField19.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.yellow, java.awt.Color.yellow, java.awt.Color.yellow, java.awt.Color.yellow));}
               else { jLabel3.setText(jatekosok[1]+"következik");jTextField20.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.yellow, java.awt.Color.yellow, java.awt.Color.yellow, java.awt.Color.yellow));}
               fildek();
            }
        }
    };
    t.start();
            
            
            b.addWindowListener(new WindowAdapter() {
                 @Override
        public void windowClosed(WindowEvent arg0) {
            synchronized (o) {
                
                b.setVisible(false);
                o.notify();
            }
        }
            });
        
        t.join();
        }
        
        
    }
    
    public void HarcPvG(int i) throws InterruptedException, MalformedURLException, CloneNotSupportedException{
        Object o=new Object();
        AutobattleGUI b=new AutobattleGUI(jatekosok[i]);
        b.setVisible(true);
             Thread t = new Thread() {
        public void run() {
            synchronized(o) {
                while (b.isVisible())
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                setVisible(true);
                System.out.println(b.j.getKikerul());
                try {
                    jatekosok[i]=(Jatekos) (b.j.clone());
                    System.out.println(jatekosok[i].getKikerul());
                    
                } catch (CloneNotSupportedException ex) {
                    Logger.getLogger(TablaGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                // a bábuk helyére tétele frissitések
               kor++;
               kiRajz();
                
               if (kor%2==0){jLabel3.setText(jatekosok[0].getNev()+" következik"); jTextField19.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.yellow, java.awt.Color.yellow, java.awt.Color.yellow, java.awt.Color.yellow));}
               else { jLabel3.setText(jatekosok[1].getNev()+" következik");jTextField20.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.yellow, java.awt.Color.yellow, java.awt.Color.yellow, java.awt.Color.yellow));}
               fildek();
            }
        }
    };
    t.start();
            
            
            b.addWindowListener(new WindowAdapter() {
                 @Override
        public void windowClosed(WindowEvent arg0) {
            synchronized (o) {
                
                b.setVisible(false);
                o.notify();
            }
        }
            });
        
        t.join();
        
        }
    
    public void Vege(){
        if(jatekosok[0].getHelyzet()>=133){
           new WingameGUI(jatekosok[0].getNev()).setVisible(true);
           clip.stop();
           dispose();
        }
        else if(jatekosok[1].getHelyzet()<=-1){
            new WingameGUI(jatekosok[1].getNev()).setVisible(true);
            clip.stop();
            dispose();
        }
    }
    
    public void fildek(){
        jTextField8.setText((Integer.toString((int)(jatekosok[0].getElet()/3)*100)));
        jTextField11.setText((Integer.toString((int)(jatekosok[0].getPajzs()/3)*100)));
        jTextField9.setText(Integer.toString((int)(jatekosok[0].getElet()+jatekosok[0].getPajzs())));
        jTextField12.setText((Integer.toString((int)(jatekosok[0].getFegyver()))));
        
        jTextField14.setText((Integer.toString((int)(jatekosok[1].getElet()/3)*100)));
        jTextField17.setText((Integer.toString((int)(jatekosok[1].getPajzs()/3)*100)));
        jTextField15.setText(Integer.toString((int)(jatekosok[1].getElet()+jatekosok[1].getPajzs())));
        jTextField18.setText((Integer.toString((int)(jatekosok[1].getFegyver()))));
    }
    
    public void addKeyListener(){
       /*for (int i=0;i<mezok1.length;i++){
            mezok1[i].addKeyListener(kilepes);
        }*/
        jButton1.addKeyListener(kilepes);
        jButton2.addKeyListener(kilepes);
        jButton3.addKeyListener(kilepes);
        jButton4.addKeyListener(kilepes);
        jLabel1.addKeyListener(kilepes);
        jLabel2.addKeyListener(kilepes);
        jLabel3.addKeyListener(kilepes);
        jProgressBar1.addKeyListener(kilepes);
        jProgressBar2.addKeyListener(kilepes);
        jTextField1.addKeyListener(kilepes);
        jTextField10.addKeyListener(kilepes);
        jTextField11.addKeyListener(kilepes);
        jTextField12.addKeyListener(kilepes);
        jTextField13.addKeyListener(kilepes);
        jTextField14.addKeyListener(kilepes);
        jTextField15.addKeyListener(kilepes);
        jTextField16.addKeyListener(kilepes);
        jTextField17.addKeyListener(kilepes);
        jTextField18.addKeyListener(kilepes);
        jTextField19.addKeyListener(kilepes);
        jTextField2.addKeyListener(kilepes);
        jTextField20.addKeyListener(kilepes);
        jTextField3.addKeyListener(kilepes);
        jTextField4.addKeyListener(kilepes);
        jTextField5.addKeyListener(kilepes);
        jTextField6.addKeyListener(kilepes);
        jTextField7.addKeyListener(kilepes);
        jTextField8.addKeyListener(kilepes);
        jTextField9.addKeyListener(kilepes);
        
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel a1;
    private javax.swing.JLabel a10;
    private javax.swing.JLabel a11;
    private javax.swing.JLabel a12;
    private javax.swing.JLabel a13;
    private javax.swing.JLabel a14;
    private javax.swing.JLabel a15;
    private javax.swing.JLabel a16;
    private javax.swing.JLabel a17;
    private javax.swing.JLabel a18;
    private javax.swing.JLabel a19;
    private javax.swing.JLabel a2;
    private javax.swing.JLabel a20;
    private javax.swing.JLabel a21;
    private javax.swing.JLabel a22;
    private javax.swing.JLabel a23;
    private javax.swing.JLabel a24;
    private javax.swing.JLabel a25;
    private javax.swing.JLabel a26;
    private javax.swing.JLabel a27;
    private javax.swing.JLabel a28;
    private javax.swing.JLabel a29;
    private javax.swing.JLabel a3;
    private javax.swing.JLabel a30;
    private javax.swing.JLabel a31;
    private javax.swing.JLabel a32;
    private javax.swing.JLabel a33;
    private javax.swing.JLabel a34;
    private javax.swing.JLabel a4;
    private javax.swing.JLabel a5;
    private javax.swing.JLabel a6;
    private javax.swing.JLabel a7;
    private javax.swing.JLabel a8;
    private javax.swing.JLabel a9;
    private javax.swing.JLabel cs;
    private javax.swing.JLabel f1;
    private javax.swing.JLabel f10;
    private javax.swing.JLabel f11;
    private javax.swing.JLabel f12;
    private javax.swing.JLabel f13;
    private javax.swing.JLabel f14;
    private javax.swing.JLabel f15;
    private javax.swing.JLabel f16;
    private javax.swing.JLabel f17;
    private javax.swing.JLabel f18;
    private javax.swing.JLabel f19;
    private javax.swing.JLabel f2;
    private javax.swing.JLabel f20;
    private javax.swing.JLabel f21;
    private javax.swing.JLabel f22;
    private javax.swing.JLabel f23;
    private javax.swing.JLabel f3;
    private javax.swing.JLabel f4;
    private javax.swing.JLabel f5;
    private javax.swing.JLabel f6;
    private javax.swing.JLabel f7;
    private javax.swing.JLabel f8;
    private javax.swing.JLabel f9;
    private javax.swing.JLabel g1;
    private javax.swing.JLabel g10;
    private javax.swing.JLabel g11;
    private javax.swing.JLabel g12;
    private javax.swing.JLabel g13;
    private javax.swing.JLabel g2;
    private javax.swing.JLabel g3;
    private javax.swing.JLabel g4;
    private javax.swing.JLabel g5;
    private javax.swing.JLabel g6;
    private javax.swing.JLabel g7;
    private javax.swing.JLabel g8;
    private javax.swing.JLabel g9;
    private javax.swing.JLabel h1;
    private javax.swing.JLabel h10;
    private javax.swing.JLabel h11;
    private javax.swing.JLabel h12;
    private javax.swing.JLabel h13;
    private javax.swing.JLabel h14;
    private javax.swing.JLabel h15;
    private javax.swing.JLabel h16;
    private javax.swing.JLabel h17;
    private javax.swing.JLabel h18;
    private javax.swing.JLabel h19;
    private javax.swing.JLabel h2;
    private javax.swing.JLabel h20;
    private javax.swing.JLabel h21;
    private javax.swing.JLabel h22;
    private javax.swing.JLabel h3;
    private javax.swing.JLabel h4;
    private javax.swing.JLabel h5;
    private javax.swing.JLabel h6;
    private javax.swing.JLabel h7;
    private javax.swing.JLabel h8;
    private javax.swing.JLabel h9;
    private javax.swing.JLabel i1;
    private javax.swing.JLabel i2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
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
    private javax.swing.JLabel k1;
    private javax.swing.JLabel k10;
    private javax.swing.JLabel k11;
    private javax.swing.JLabel k12;
    private javax.swing.JLabel k13;
    private javax.swing.JLabel k14;
    private javax.swing.JLabel k15;
    private javax.swing.JLabel k16;
    private javax.swing.JLabel k17;
    private javax.swing.JLabel k18;
    private javax.swing.JLabel k19;
    private javax.swing.JLabel k2;
    private javax.swing.JLabel k20;
    private javax.swing.JLabel k21;
    private javax.swing.JLabel k22;
    private javax.swing.JLabel k23;
    private javax.swing.JLabel k24;
    private javax.swing.JLabel k25;
    private javax.swing.JLabel k26;
    private javax.swing.JLabel k27;
    private javax.swing.JLabel k28;
    private javax.swing.JLabel k29;
    private javax.swing.JLabel k3;
    private javax.swing.JLabel k30;
    private javax.swing.JLabel k31;
    private javax.swing.JLabel k32;
    private javax.swing.JLabel k33;
    private javax.swing.JLabel k34;
    private javax.swing.JLabel k35;
    private javax.swing.JLabel k36;
    private javax.swing.JLabel k4;
    private javax.swing.JLabel k5;
    private javax.swing.JLabel k6;
    private javax.swing.JLabel k7;
    private javax.swing.JLabel k8;
    private javax.swing.JLabel k9;
    private javax.swing.JLabel t1;
    private javax.swing.JLabel t2;
    // End of variables declaration//GEN-END:variables
}
