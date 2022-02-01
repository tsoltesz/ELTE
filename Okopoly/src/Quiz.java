public class Quiz {
    
    String kerdes;
    String jovalasz;
    String rosszvalasz1, rosszvalasz2, rosszvalasz3;
    
    Quiz(String k, String j,String r1,String r2,String r3){
        kerdes=k;
        jovalasz=j;
        rosszvalasz1=r1;
        rosszvalasz2=r2;
        rosszvalasz3=r3;
    }
    Quiz(){
       
    }
    Quiz(String k, String j, String r){
        kerdes=k;
        jovalasz=j;
        rosszvalasz1=r;
        rosszvalasz2=null;
        rosszvalasz3=null;
    }
    Quiz(String t[]){
        kerdes=t[0];
        jovalasz=t[1];
        rosszvalasz1=t[2];
        if(t.length>3){
            rosszvalasz2=t[3];
            rosszvalasz3=t[4];
        }
        else{
            rosszvalasz2=null;
            rosszvalasz3=null;
        }
    }
    public String getKerdes(){return kerdes;}
    public String getJovalasz(){return jovalasz;}
    public String getRosszvalasz1(){return rosszvalasz1;}
    public String getRosszvalasz2(){return rosszvalasz2;}
    public String getRosszvalasz3(){return rosszvalasz3;}
    
    public Boolean Helyese(String valasz){if(valasz==jovalasz){return true;}else{return false;}}
    
}
