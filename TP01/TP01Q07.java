import java.io.*;
import java.net.*;

public class TP01Q07 
{
    public static String getHtml(String endereco) 
    {
        URL url;
        InputStream is = null;
        BufferedReader br;
        String resp = "", linha;
        int[] array = new int[25];

        try {
            url = new URL(endereco);
            is = url.openStream(); // throws an IOException
            br = new BufferedReader(new InputStreamReader(is));

            while ((linha = br.readLine()) != null) 
            {
                for(int i=0; i < linha.length();i++)
                {
                    if(linha.charAt(i)== '<' )
                    {
                        if(linha.charAt(i+1) == 't' && linha.charAt(i+2) == 'a' && linha.charAt(i+3) == 'b' && linha.charAt(i+4) == 'l' && linha.charAt(i+5) == 'e' && linha.charAt(i+6) == '>')
                        {
                            array[24] += 1 ;
                        }
                        else if(linha.charAt(i+1) == 'b' &&  linha.charAt(i+2) == 'r' && linha.charAt(i+3) == '>')
                        {
                            array[23] +=1;
                        }
                    }
                    else if(linha.charAt(i) == 'a')
                    {
                        array[0] +=1;
                    }
                    else if(linha.charAt(i) == 'e')
                    {
                        array[1] +=1;
                    }
                    else if(linha.charAt(i) == 'i')
                    {
                        array[2] +=1;
                    }
                    else if(linha.charAt(i) == 'o')
                    {
                        array[3] +=1;
                    }
                    else if(linha.charAt(i) == 'u')
                    {
                        array[4] +=1;
                    }
                    else if(linha.charAt(i) == 225)
                    {
                        array[5] +=1;
                    }
                    else if(linha.charAt(i)  == 233)
                    {
                        array[6] +=1;
                    }
                    else if(linha.charAt(i) == 237)
                    {
                        array[7] +=1;
                    }
                    else if(linha.charAt(i) == 243)
                    {
                        array[8] +=1;
                    }  
                    else if(linha.charAt(i) == 250)
                    {
                        array[9] +=1;
                    }
                    else if(linha.charAt(i) == 224)
                    {
                        array[10] +=1;
                    }
                    else if(linha.charAt(i) == 232)
                    {
                        array[11] +=1;
                    }
                    else if(linha.charAt(i) == 236)
                    {
                        array [12] +=1;
                    }
                    else if(linha.charAt(i) == 242)
                    {
                        array[13] +=1;
                    }
                    else if(linha.charAt(i) == 249)
                    {
                        array[14] +=1;
                    }
                    else if(linha.charAt(i) == 227)
                    {
                        array[15] +=1;
                    }
                    else if(linha.charAt(i) == 245)
                    {
                        array[16] +=1;
                    }
                    else if(linha.charAt(i) == 226)
                    {
                        array[17] +=1;
                    }
                    else if(linha.charAt(i) == 234)
                    {
                        array[18] +=1;
                    }
                    else if(linha.charAt(i) == 238)
                    {
                        array[19] +=1;
                    }
                    else if(linha.charAt(i) == 244)
                    {
                        array[20] +=1;
                    }
                    else if(linha.charAt(i) == 251)
                    {
                        array[21] +=1;
                    }

                }
            }
        } catch (MalformedURLException mue) 
        {
            mue.printStackTrace();
        } catch (IOException ioe) 
        {
            ioe.printStackTrace();
        }

        try {
            is.close();
        } catch (IOException ioe) 
        {
            // nothing to see here

        }

        return resp;
    }

    public static void main(String[] args) throws Exception {

    }
}
