import java.io.*;
import java.net.*;
// import java.nio.charset.Charset;
// import java.nio.charset.StandardCharsets;

class leituraHTML {

  //  private static String charset = "ISO-8859-1";
    
    public static boolean teste(String linha) {
        
        
        return (linha.length() == 3 && linha.charAt(0) == 'F' && linha.charAt(1) == 'I' && linha.charAt(2) == 'M');
    }
    
    
    public static boolean tste(char ch){
       
        boolean saber =true;
          
        if(ch=='<'||ch=='>'){
            
            saber = false;
          
        }
        
        return saber;
    }
    
    public static boolean isTable(String linha) {
        
        
        return (linha.length() == 7 && linha.charAt(0) == '<' && linha.charAt(1) == 't' && linha.charAt(2) == 'a' && linha.charAt(3) == 'b' && linha.charAt(4) == 'l' && linha.charAt(5) == 'e' && linha.charAt(6) == '>');
    }
    
    public static boolean isBr(String linha) 
    {
        
        
        return (linha.length() == 4 && linha.charAt(0) == '<' && linha.charAt(1) == 'b' && linha.charAt(2) == 'r' && linha.charAt(3) == '>');

    }
    
    
    
    public static int[] getHtml(String endereco) {
        URL url;
        InputStream is = null;
        BufferedReader br;

        int br1 = 0;
        int table = 0;
        
       
  
        int[] array = new int[25];
        try {
            String linha = "";
            url = new URL(endereco);
            is = (url.openStream());  
            br = new BufferedReader(new InputStreamReader(is));
            while ((linha = br.readLine()) != null) {

                if (isTable(linha)) {
                    table++;
                } else if (isTable(linha)) {

                    br1++;
                } else {
                    for (int z = 0; z < linha.length(); z++) {
                        int e = 0;
                        if (linha.charAt(z) == 'a') {
                          e = 1;
                            array[0] += e;
                        } else if (linha.charAt(z) == 'e') {
                             e = 1;
                            array[1] += e;
                        } else if (linha.charAt(z) == 'i') {
                             e = 1;
                            array[2] += e;
                        } else if (linha.charAt(z) == 'o') {
                              e = 1;
                            array[3] += e;
                        } else if (linha.charAt(z) == 'u') {
                              e = 1;
                            array[4] += e;
                        } else if (linha.charAt(z) == 225) {
                              e = 1;
                            array[5] += e;
                        } else if (linha.charAt(z) == 233) {
                              e = 1;
                            array[6] += e;
                        } else if (linha.charAt(z) == 237) {
                              e = 1;
                            array[7] += e;
                        } else if (linha.charAt(z) == 243) {
                              e = 1;
                            array[8] += e;
                        } else if (linha.charAt(z) == 250) {
                              e = 1;
                            array[9] += e;
                        } else if (linha.charAt(z) == 224) {
                             e = 1;
                            array[10] += e;
                        } else if (linha.charAt(z) == 232) {
                              e = 1;
                            array[11] += e;
                        } else if (linha.charAt(z) == 236) {
                              e = 1;
                            array[12] += e;
                        } else if (linha.charAt(z) == 242) {
                              e = 1;
                            array[13] += e;
                        } else if (linha.charAt(z) == 249) {
                              e = 1;
                            array[14] += e;
                        } else if (linha.charAt(z) == 227) {
                             e = 1;
                            array[15] += e;
                        } else if (linha.charAt(z) == 245) {
                              e = 1;
                            array[16] += e;
                        } else if (linha.charAt(z) == 226) {
                              e = 1;
                            array[17] += e;
                        } else if (linha.charAt(z) == 234) {
                              e = 1;
                            array[18] += e;
                        } else if (linha.charAt(z) == 238) {
                              e = 1;
                            array[19] += e;
                        } else if (linha.charAt(z) == 244) {
                              e = 1;
                            array[20] += e;
                        } else if (linha.charAt(z) == 251) {
                             e = 1;
                            array[21] += e;
                        } else {

                          if(linha.charAt(z)>=97 && 122 >=linha.charAt(z) && linha.charAt(z) != 65 &&  linha.charAt(z) != 69&&  linha.charAt(z) != 73&&  linha.charAt(z) != 79 &&  linha.charAt(z) != 85)
                            if(tste(linha.charAt(z))){
                                   e = 1;
                            array[22] += e;
                          
                            }
                            
                        }
                    }
                }


            }
           
            array[23] = br1;
           
            array[24] = table; 
        } catch (MalformedURLException mue) {
           
            mue.printStackTrace();
        } catch (IOException ioe) {
           
            ioe.printStackTrace();
        }

        try {
            
            is.close();
        } catch (IOException ioe) {
            



        }

        return array;
    }



    public static void main(String[] args) throws Exception 
    {
        
      //  System.setProperty("file.encoding", "ISO-8859-1"); 
        String pag = MyIO.readLine();


        
        
        while (teste(pag) != true) {
            
            String endereco = MyIO.readLine();
            
            int[] array = getHtml(endereco);
     
          
            System.out.println("a(" + array[0] + ") e(" + array[1] + ") i(" + array[2] + ") o(" + array[3] + ") u(" + array[4] + ") á(" + array[5] + ") é(" + array[6] + ") í(" + array[7] + ") ó(" + array[8] + ") ú(" + array[9] + ") à(" + array[10] + ") è(" + array[11] + ") ì(" + array[12] + ") ò(" + array[13] + ") ù(" + array[14] + ") ã(" + array[15] + ") õ(" + array[16] + ") â(" + array[17] + ") ê(" + array[18] + ") î(" + array[19] + ") ô(" + array[20] + ") û(" + array[21] + ") consoante(" + array[22] + ") <br>(" + array[23] + ") <table>(" + array[24] + ") " + pag);
  
           
            pag = MyIO.readLine();


        }

    }

}