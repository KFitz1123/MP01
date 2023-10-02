import java.io.PrintWriter;
import java.lang.String;

public class  VigenereCipher{
    public static void main (String[] args) throws Exception {
        PrintWriter pen = new PrintWriter(System.out, true); if(args.length != 3) {
            System.err.println("Incorrect number of parameters");
            System.exit(1);
        }//parametercheck
         if (args[0].equals("encode")){
             VigenereCipher.encode(pen, args[1], args[2]);
        }//if encode
        else if (args[0].equals("decode")){
            VigenereCipher.decode(pen, args[1],args[2]);
    } // if decode
    else {
        System.err.println("Valid options are 'encode' or 'decode'");
    } // if neither encode or decode

  }//main
    public static void encode (PrintWriter pen, String init,String cipher) throws Exception {
         char basearr[] = init.toCharArray();
         char cipharr[] =  cipher.toCharArray();
         int initlen = init.length();
         int cipherlen = cipher.length();
         int base = 97;
         if(init.length() == 0){
             pen.println(init);}
         else{
             for (int j = 0 ; j < initlen ; j++){
                 int ciphernum = j % cipherlen;     
                 int cipherchar = (int) cipharr[ciphernum]; 
                 int newint = (int) basearr[j];              
                 int trnsint =(((newint + cipherchar - (2 * base)) % 26)+ base);
                 char fin = (char) trnsint;
                 pen.print(fin);            
             }//for loop 
             pen.println("");
         }
    }// encode
    
    public static void decode (PrintWriter pen, String init, String cipher) throws Exception {
         
        char basearr[] = init.toCharArray();
        char cipharr[] =  cipher.toCharArray();
        int len = init.length();
        int cipherlen = cipher.length();
        int base = 97;
        if(init.length() == 0){
                 pen.println(init);}
        else{
            for (int j = 0 ; j < len ; j++){
                int newint = (int)  basearr[j];
                int ciphernum = j % cipherlen;
                int cipherchar = (int) cipharr[ciphernum];
                int alter = (newint - cipherchar);
                
                if (alter < 0){
                    char fin = (char) ((26 + alter) + base);
                    pen.print(fin); 
                 } //if>0
                else{
                    char fin = (char) (alter + base);
                    pen.print(fin);
                }//if<=0
            }//for loop j
            pen.println("");
        }
    } // decode 
} // class VigenereCipher

