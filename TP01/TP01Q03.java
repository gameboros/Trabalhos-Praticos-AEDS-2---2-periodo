public class TP01Q03 {

    public static boolean isFim(String str)
    {
        return(str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M');
    }
    
    public static void main(String[] args) {
        String linha = "";

        do 
        {
            linha = MyIO.readLine();

            MyIO.println(ciframentoCesar(linha));

        } while (isFim(linha)  == false);

    }

    public static String ciframentoCesar(String str) {
        String novaString = "";

        for (int i = 0; i < str.length(); i++) {
            novaString += ((char) (str.charAt(i) + 3));

        }

        return novaString;
    }

}
