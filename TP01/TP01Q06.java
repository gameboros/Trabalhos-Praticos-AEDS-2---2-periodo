class TP01Q06 {

    
    public static void main(String[] args) 
    {
        String linha = "";
        linha = MyIO.readLine();
        while (isFim(linha) == false)
        {
            if (isVowels(linha) == true)
            {
                System.out.print("SIM ");
            }
            else
            {
                System.out.print("NAO ");
            }
            
            if (isConsonants(linha) == true)
            {
                System.out.print("SIM ");
            }
            else
            {
                System.out.print("NAO ");
            }

            if (isNumbers(linha) == true)
            {
                System.out.print("SIM ");
            }
            else
            {
                System.out.print("NAO ");
            }

            if (isRoyalNumbers(linha) == true)
            {
                System.out.println("SIM ");
            }
            else
            {
                System.out.println("NAO ");
            }
            linha = MyIO.readLine();
        }
    }

    public static boolean isFim(String str)
    {
        return(str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M');
    }

    public static boolean isVowels(String linha) 
    {
        boolean checkStatus = true;
        for (int i = 0; i < linha.length(); i++) 
        {
            if (linha.charAt(i) == 'a' || linha.charAt(i) == 'e' || linha.charAt(i) == 'i' || linha.charAt(i) == 'o'|| linha.charAt(i) == 'u' || linha.charAt(i) == 'A' || linha.charAt(i) == 'E'|| linha.charAt(i) == 'I' || linha.charAt(i) == 'O' || linha.charAt(i) == 'U') 
            {
                checkStatus = true;
            } else 
            {
                checkStatus = false;
                return checkStatus;
            }
        }

        return checkStatus;
    }

    public static boolean isConsonants(String linha) 
    {
        boolean checkStatus = true;
        for (int i = 0; i < linha.length(); i++) {
            if (linha.charAt(i) == 'a' || linha.charAt(i) == 'e' || linha.charAt(i) == 'i' || linha.charAt(i) == 'o'|| linha.charAt(i) == 'u' || linha.charAt(i) == 'A' || linha.charAt(i) == 'E'|| linha.charAt(i) == 'I' || linha.charAt(i) == 'O' || linha.charAt(i) == 'U') 
            {
                checkStatus = false;
                return checkStatus;
            } else 
            {
                checkStatus = true;

            }
        }

        return checkStatus;
    }

    public static boolean isNumbers(String linha) 
    {
        boolean checkStatus = true;
        for (int i=0;i<linha.length();i++)
        {
            if((linha.charAt(i) >= '0' && linha.charAt(i) <= '9'))
            {
                checkStatus=true;
            }
            else
            {
                checkStatus=false;
                return checkStatus;
            }
        }
        return checkStatus;
    }

    public static boolean isRoyalNumbers(String linha) 
    {
        boolean checkStatus = true;
        for (int i=0;i<linha.length();i++)
        {
            if((linha.charAt(i) >= '0' && linha.charAt(i) <= '9')||(linha.charAt(i) == ',' || linha.charAt(i) == '.'))
            {
                checkStatus=true;
            }
            else
            {
                checkStatus=false;
                return checkStatus;
            }
        }
        return checkStatus;

    }

    public static boolean isLetra(char x)
    {
         boolean ret1 = false;
        if(x >= 'A' && x <= 'Z' || x >= 'a' && x <= 'z')
            ret1 = true;

        return ret1;
    }




}