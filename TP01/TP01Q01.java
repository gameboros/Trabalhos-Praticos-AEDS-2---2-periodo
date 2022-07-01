class TP01Q01  
{
    
    public static boolean isFim(String str){
        return(str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M');
    }
    public static void main(String[] args) 
    {
  
        String linha[] = new String[999];
        int numLinha = 0;
        do {
            linha[numLinha] = MyIO.readLine();
            // max=linha.length();

            if (checarPalindromo(linha[numLinha])) 
            {
                System.out.println("SIM");
            } 
            else 
            {
                System.out.println("NAO");
            }
        } while (isFim(linha[numLinha++]) == false);
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
