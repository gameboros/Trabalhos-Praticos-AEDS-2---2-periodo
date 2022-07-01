public class TP01Q05 
{

    public static void main(String[] args)
    {
        String linha = "";
        linha = MyIO.readLine();
        linha = removeEspaco(linha);

    }

    public static  int[] numeroEntrada(String linha)
    {
        int[] entradas = new int  [3];
        if (linha.charAt(0)  ==  '2')
        {
            entradas[0] = linha.charAt(1);
            entradas[1] = linha.charAt(2);
        }
        else if (linha.charAt(0) == '3')
        {
            entradas[0] = linha.charAt(1);
            entradas[1] = linha.charAt(2);
            entradas[2] = linha.charAt(3);
        }




        return entradas;
    }

    public static String  removeEspaco(String  linha)
    {
        String  novaString = "";

        novaString =  linha.replaceAll(" ","");



        return novaString;
    }



    

}
