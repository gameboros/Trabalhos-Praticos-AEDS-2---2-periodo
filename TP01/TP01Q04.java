import java.util.Random;

public class TP01Q04 
{
    public static boolean isFim(String str)
    {
        return(str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M');
    }
    
    public static void main(String[] args) 
    {
        String  linha =  "";

        do 
        {
            linha = MyIO.readLine();

            MyIO.println(alteraString(linha));

        } while (isFim(linha)  == false);

    }

    public static String alteraString(String str) 
    {
        Random gerador = new Random();

        gerador.setSeed(4);
        String novaString = "";
        char letraVelha  = ((char)('a'+ (Math.abs(gerador.nextInt()%26))));
        char letraNova  =  ((char)('a'+ (Math.abs(gerador.nextInt()%26))));

        for (int i = 0; i < str.length(); i++) 
        {
            if(str.charAt(i) != letraVelha)
            {
                novaString+=str.charAt(i);
            }
            else
            {
                novaString+=letraNova;
            }
        }

        return novaString;
    }

}
