public class TP01Q011 
{
    public static void main(String[] args) 
    {
        boolean var = true;
        rodarPrograma(var);
    }

    public static boolean isFim(String str){
        return(str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M');
    }
    
    public static boolean rodarPrograma(boolean var)
    {
        
        if (var!=true)
        {
            return var;
        }
        else
        {
            String linha[] = new String[999];
            int numLinha = 0;
            
            linha[numLinha] = MyIO.readLine();
            // max=linha.length();
    
          if (isFim(linha[numLinha]))
          {
              var = false;
          }
          else
          {
            if (checarPalindromo(linha[numLinha])) 
            {
                System.out.println("SIM");
            } 
            else 
            {
                System.out.println("NAO");
            }
            numLinha++;
          }
          return rodarPrograma(var);
        }




    }


    public static boolean checarPalindromo(String linha) 
    {
        // System.out.println("CHEGOU");
        String inversa = "";
        for (int i = linha.length() - 1; i >= 0; i--) 
        {
            inversa += linha.charAt(i);
        }
        if (inversa.equals(linha)) 
        {
            return true;
            
        } 
        else 
        {
            return false;
        }

    }
}
