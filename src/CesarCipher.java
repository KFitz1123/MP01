

import java.io.PrintWriter;
import java.lang.String;

public class  CesarCipher{
    public static void main (String[] args) throws Exception {
        PrintWriter pen = new PrintWriter(System.out, true);
        if(args.length != 2) {
            System.err.println("Incorrect number of parameters");
            System.exit(1);
        }
        if (args[0].equals("encode")){
            CesarCipher.encode(pen, args[1]);
        }//if encode
        else if (args[0].equals("decode")){
            CesarCipher.decode(pen, args[1]);
    } // if decode
    else {
        System.err.println("Valid options are 'encode' or 'decode'");
    } // if neither encode or decode

  }//main
    
    public static void encode (PrintWriter pen, String init) throws Exception {
         char basearr[] = init.toCharArray();
         int len = init.length();
         int base = 97;
         for (int i = 0 ; i < 26 ; i++){
             pen.println("");         
             for (int j = 0 ; j < len ; j++){               
                 int newint = (int) basearr[j];              
                 int trnsint = (((newint + i - base) % 26) + base);             
                 char fin = (char) trnsint;         
                 pen.print(fin);
             }//for loop j
         }//for loop i
    }// encode
    
    public static void decode (PrintWriter pen, String init) throws Exception {
         
        char basearr[] = init.toCharArray();
        int len = init.length();
        int base = 97;     
        for (int i = 0 ; i < 26 ; i++){
            pen.println("");
            for (int j = 0 ; j < len ; j++){
                int newint = (int)  basearr[j];
                int alter = ((newint - i - base) % 26);
                if (alter < 0){
                    char fin = (char) ((26 + alter) + base);
                    pen.print(fin); 
                } //if>0
                else{
                    char fin = (char) (alter + base);
                    pen.print(fin);
                }//if<=0
            }//for loop j
        }//for loop i
    } // decode
    
} // class CesarCipher



