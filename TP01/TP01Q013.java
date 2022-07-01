public class TP01Q013 {

    public static boolean isFim(String str) {
        return (str.length() == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M');
    }

    public static boolean rodarPrograma(boolean var) {

        if (var != true) {
            return var;
        } else 
        {
            String linha[] = new String[999];
            int numLinha = 0;

            linha[numLinha] = MyIO.readLine();
            // max=linha.length();

            if (isFim(linha[numLinha])) {
                var = false;
            } else {
                MyIO.println(ciframentoCesar(linha[numLinha]));
                numLinha++;
            }
            return rodarPrograma(var);
        }
    }

    public static void main(String[] args) {
        boolean var = true;
        rodarPrograma(var);

    }

    public static String ciframentoCesar(String str) {
        String novaString = "";

        for (int i = 0; i < str.length(); i++) {
            novaString += ((char) (str.charAt(i) + 3));

        }

        return novaString;
    }

}
