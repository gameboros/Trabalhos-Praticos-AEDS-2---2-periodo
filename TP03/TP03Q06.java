import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.File;
import java.nio.charset.*;

class TP03Q06 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        String entrada = new String();
        Filme filmes = new Filme();
        Filme[] arrayFilmes = new Filme[50];
        String[] nomesPesquisa = new String[50];
        int controlador = 0;
        int numEntradas = 0;
        int pesquisaCont = 0;
        entrada = "";
        entrada = sc.nextLine();
        do{
            try {

               // filmes.ler("/mnt/c/temp/2022-1/AULAS/TP03/filmes/" + entrada);

                filmes.ler("/tmp/filmes/"+ entrada);
               // System.out.println("Entrada " + controlador + ":" + "Nome: " + filmes.getNome());
                arrayFilmes[controlador] = Filme.clonador(filmes);
                controlador++;
               // System.out.println("Nome do filme: " + filmes.getNome() + "Controlador: " + controlador);
                entrada = sc.nextLine();
               // System.out.println("1 Nome no indice zero: " + arrayFilmes[0].getNome() + "Controlador: " + controlador);
            } catch (Exception e) {
                e.printStackTrace();
              entrada = sc.nextLine();
            }
            // System.out.println(filmes.getDataLancamento());
           // System.out.println(filmes.imprimir());

        }while (isFim(entrada) == false);

       // quicksort(0, controlador - 1, arrayFilmes);
    

        for(int i = 0; i < controlador; i++)
        {
            System.out.println(arrayFilmes[i].imprimir());
        }

       // Lista listafilmes = new Lista(arrayFilmes, controlador);     
        //Lista.reordenarSelection(listafilmes);
        int contadorRep = 0;


       // System.out.println("filmecont: " + controlador);
        // System.out.println("pesquisacont: " + pesquisaCont);
        // System.out.println("CONTROLA MERDA: " + controlaMERDA);
       // listafilmes.listaImprimir();
        sc.close();
    }

    public static boolean isFim(String s) { // teste para determinar se a linha é "FIM"
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static void quicksort(int esq, int dir, Filme array[]) {
		int i = esq, j = dir;
        Filme pivo = Filme.clonador(array[(esq+dir)/2]);
		while (i <= j) {
				while (array[i].getSituacao().compareTo(pivo.getSituacao()) < 0 )
						i++;
				while (array[j].getSituacao().compareTo(pivo.getSituacao()) > 0) 
						j--;

				if (i <= j){ 
                    Filme aux = Filme.clonador(array[i]);
                    array[i] = Filme.clonador(array[j]);
                    array[j] = Filme.clonador(aux);
                    i++; 
                    j--; 
                }
		}
		if (esq < j)
				quicksort(esq, j, array);
		if (i < dir)
				quicksort(i, dir, array);

    }
}

class Filme {
    private String nome;
    private String tituloOriginal;
    private Date dataLancamento;
    private int duracao;
    private String genero;
    private String idiomaOriginal;
    private String situacao;
    private float orcamento;
    private String[] palavrasChave;

    public Filme() {
    }

    public Filme(String nome, String tituloOriginal, Date dataLancamento, int duracao, String genero,
            String idiomaOriginal,
            String situacao, float orcamento, String[] palavrasChave) {
        this.nome = nome;
        this.tituloOriginal = tituloOriginal;
        this.dataLancamento = dataLancamento;
        this.duracao = duracao;
        this.genero = genero;
        this.idiomaOriginal = idiomaOriginal;
        this.situacao = situacao;
        this.orcamento = orcamento;
        this.palavrasChave = palavrasChave;
    }

    public static Filme clonador(Filme filme){
        Filme temporario = new Filme();

        temporario.nome = filme.nome;
        temporario.tituloOriginal = filme.tituloOriginal;
        temporario.dataLancamento = filme.dataLancamento;
        temporario.duracao = filme.duracao;
        temporario.genero = filme.genero;
        temporario.idiomaOriginal = filme.idiomaOriginal;
        temporario.situacao = filme.situacao;
        temporario.orcamento = filme.orcamento;
        temporario.palavrasChave = filme.palavrasChave;


        return temporario;
    }
    
    public String getNome() {
        return nome;
    }

    public String getTituloOriginal() {
        return tituloOriginal;
    }

    public String getDataLancamento() {
        String newdate = new SimpleDateFormat("dd/MM/yyyy").format(dataLancamento);
        return newdate;
    }

    public Date getDataLancamentoDate(){
        return dataLancamento;
    }

    public int getDuracao() {
        return duracao;
    }

    public String getGenero() {
        return genero;
    }

    public String getIdiomaOriginal() {
        return idiomaOriginal;
    }

    public String getSituacao() {
        return situacao;
    }

    public float getOrcamento() {
        return orcamento;
    }

    public String[] getPalavrasChave() {
        return palavrasChave;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTituloOriginal(String tituloOriginal) {
        this.tituloOriginal = tituloOriginal;
    }

    public void setDataLancamento(String s) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            this.dataLancamento = dateFormat.parse(s);
        } catch (ParseException pe) {
            System.out.println(pe.getMessage());
        }
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setIdiomaOriginal(String idiomaOriginal) {
        this.idiomaOriginal = idiomaOriginal;
    }

    public void setOrcamento(float orcamento) {
        this.orcamento = orcamento;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public void setPalavrasChave(String[] palavrasChave) {
        this.palavrasChave = palavrasChave;
    }

    String removeTags(String line) {
        String newline = "";
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '<') {
                i++;
                while (line.charAt(i) != '>') {
                    i++;
                }
            } else {
                newline += line.charAt(i);
            }
        }
        return newline;
    }

    /**
     * String removeTagsInverso(String line) {
     * String newline = "";
     * for (int i = 0; i < line.length(); i++) {
     * if (line.charAt(i) == '>') {
     * i++;
     * while (line.charAt(i) != '<') {
     * newline += line.charAt(i);
     * i++;
     * }
     * } else {
     * 
     * }
     * }
     * return newline;
     * }
     **/
    String removeTagsDois(String line) {
        String newline = "";
        int i = 0;
        while (line.charAt(i) != '(') {
            newline += line.charAt(i);
            i++;
        }

        newline.trim();
        return newline;
    }

    int duracaoTreat(String s) {
        String horas = "";
        String minutos = "";
        int resultado = 0;
        int i = 0;
        s = (s.trim()).replace(" ", "");
        try{
        while (s.charAt(i) != 'h') {
            horas += s.charAt(i);
            i++;
        }
        i++;
        while (s.charAt(i) != 'm') {
            minutos += s.charAt(i);
            i++;
        }
    } catch (Exception e){
        return 0;
    }
        resultado = ((Integer.parseInt(horas) * 60) + Integer.parseInt(minutos));

        return resultado;
    }

    String removeUmZero(String s) {
        String newstring = new String();
        for (int i = 0; i < (s.length() - 1); i++) {
            newstring += s.charAt(i);
        }

        return newstring;
    }

    /**
     * void refineArray(String[] linha)
     * {
     * String[] refinedArray = new String[linha.length];
     * int cont = 0;
     * for(int i = 0,j=0; i <= linha.length -1; i++)
     * {
     * if(linha[i].equals(null))
     * {
     * cont++;
     * }
     * else
     * {
     * refinedArray[j] = linha[i];j++;
     * }
     * linha = Arrays.copyOf(refinedArray,linha.length-cont);
     * }
     * }
     */

    public void ler(String nomeArquivo) throws Exception {
        InputStreamReader isr = new InputStreamReader(new FileInputStream(nomeArquivo), Charset.forName("UTF-8"));
        int controlador = 0;

        BufferedReader br = new BufferedReader(isr);
        String linhatemp = new String();

        linhatemp = br.readLine();
        while (!(linhatemp.contains("<title>"))) {
            linhatemp = br.readLine();
        }

        this.nome = removeTagsDois(removeTags(linhatemp));
        this.nome = nome.trim();

        while (!(linhatemp.contains("\"release\""))) {
            linhatemp = br.readLine();
        }
        linhatemp = br.readLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.dataLancamento = dateFormat.parse((removeTagsDois(removeTags(linhatemp))).trim());

        while (!(linhatemp.contains("\"genres\""))) {
            linhatemp = br.readLine();
        }
        linhatemp = br.readLine();
        linhatemp = br.readLine();
        this.genero = ((removeTags(linhatemp).replace("&nbsp;", "")).trim());

        while (!(linhatemp.contains("\"runtime\""))) {
            linhatemp = br.readLine();
        }
        linhatemp = br.readLine();
        linhatemp = br.readLine();
        this.duracao = duracaoTreat(linhatemp);

        try {
            while (!(linhatemp.contains("\"wrap\""))) {
                linhatemp = br.readLine();
            }
            this.tituloOriginal = ((removeTags(linhatemp).replace("Título original", "")).trim());
        } catch (NullPointerException npe) {
            this.tituloOriginal = this.nome;
        }
        br.close();
        isr.close();
        isr = new InputStreamReader(new FileInputStream(nomeArquivo), Charset.forName("UTF-8"));
        br = new BufferedReader(isr);
        linhatemp = br.readLine();

        while (!(linhatemp.contains("Situação"))) {
            linhatemp = br.readLine();
        }
        this.situacao = ((removeTags(linhatemp).replace("Situação", "")).trim());

        while (!(linhatemp.contains("Idioma original"))) {
            linhatemp = br.readLine();
        }
        this.idiomaOriginal = ((removeTags(linhatemp).replace("Idioma original", "")).trim());

        while (!(linhatemp.contains("Orçamento"))) {
            linhatemp = br.readLine();
        }
        linhatemp = ((removeTags(linhatemp).replace("Orçamento", "")).trim());
        linhatemp = (linhatemp.replace(",", "").replace("$", ""));
        try {
            linhatemp = removeUmZero(linhatemp);
            this.orcamento = Float.parseFloat(linhatemp);
        } catch (NumberFormatException nfe) {
            this.orcamento = 0;
        }

        palavrasChave = new String[100];
        try {
            while (!linhatemp.contains("/keyword/")) {
                linhatemp = br.readLine();
            }
            while (linhatemp.contains("/keyword/")) {
                this.palavrasChave[controlador] = (removeTags(linhatemp).trim());
                controlador++;
                linhatemp = br.readLine();
                linhatemp = br.readLine();
            }
        } catch (NullPointerException npe) {
        }
        String[] tempArray = new String[controlador];
        for (int i = 0; i < controlador; i++) {
            tempArray[i] = palavrasChave[i];
        }
        palavrasChave = Arrays.copyOf(tempArray, tempArray.length);
        br.close();

    }

    public String imprimir() {
        return nome + " " + tituloOriginal + " " + getDataLancamento() + " " + String.valueOf(duracao) + " " + genero
                + " " + idiomaOriginal
                + " " + situacao + " " + String.valueOf(orcamento) + " " + Arrays.toString(palavrasChave);
    }

}

class Lista {
    private Filme[] array = new Filme[50];
    private String[]  nomesRemovidos = new String[9];
    int nomesRemovidosCount = 0;
    private int n;
 
 
    /**
     * Construtor da classe.
     */
    public Lista () {
    }
 
 
    /**
     * Construtor da classe.
     */
    public Lista (Filme[] filme, int controlador){

        for(int i=0;i<controlador;i++){
            array[i] = Filme.clonador(filme[i]);
            n++;
       }

    }
 
 
    /**
     * Insere um elemento na primeira posicao da lista e move os demais
     * elementos para o fim da lista.
     * @param x int elemento a ser inserido.
     * @throws Exception Se a lista estiver cheia.
     */
    public void inserirInicio(Filme  filme) throws Exception {
 
       //validar insercao
       if(n >= array.length){
          throw new Exception("Erro ao inserir!");
       } 
 
       //levar elementos para o fim do array
       for(int i = n; i > 0; i--){
          array[i] = array[i-1];
       }
 
       array[0] = Filme.clonador(filme);
       n++;
    }
 
 
    /**
     * Insere um elemento na ultima posicao da lista.
     * @param x int elemento a ser inserido.
     * @throws Exception Se a lista estiver cheia.
     */
    public void inserirFim(Filme  filme) throws Exception {
 
       //validar insercao
       if(n >= array.length){
          throw new Exception("Erro ao inserir!");
       }
 
       array[n] = Filme.clonador(filme);
       n++;
    }
 
 
    /**
     * Insere um elemento em uma posicao especifica e move os demais
     * elementos para o fim da lista.
     * @param x int elemento a ser inserido.
     * @param pos Posicao de insercao.
     * @throws Exception Se a lista estiver cheia ou a posicao invalida.
     */
    public void inserir(Filme  filme, int pos) throws Exception {
 
       //validar insercao
       if(n >= array.length || pos < 0 || pos > n){
          throw new Exception("Erro ao inserir!");
       }
 
       //levar elementos para o fim do array
       for(int i = n; i > pos; i--){
          array[i] = array[i-1];
       }
 
       array[pos] = Filme.clonador(filme);
       n++;
    }
 
 
    /**
     * Remove um elemento da primeira posicao da lista e movimenta 
     * os demais elementos para o inicio da mesma.
     * @return resp int elemento a ser removido.
     * @throws Exception Se a lista estiver vazia.
     */
    public Filme removerInicio() throws Exception {
        
       //validar remocao
       if (n == 0) {
          throw new Exception("Erro ao remover!");
       }
 
       Filme resp = Filme.clonador(array[0]);
       n--;
 
       for(int i = 0; i < n; i++){
          array[i] = array[i+1];
       }
       nomesRemovidos[nomesRemovidosCount]   =  resp.getNome();
       nomesRemovidosCount++;
       return resp;
    }
 
 
    /**
     * Remove um elemento da ultima posicao da lista.
     * @return resp int elemento a ser removido.
     * @throws Exception Se a lista estiver vazia.
     */
    public Filme removerFim() throws Exception {
 
       //validar remocao
       if (n == 0) {
          throw new Exception("Erro ao remover!");
       }
       nomesRemovidos[nomesRemovidosCount]   =  array[n-1].getNome();
       nomesRemovidosCount++;
       return array[--n];
    }
 
 
    /**
     * Remove um elemento de uma posicao especifica da lista e 
     * movimenta os demais elementos para o inicio da mesma.
     * @param pos Posicao de remocao.
     * @return resp int elemento a ser removido.
     * @throws Exception Se a lista estiver vazia ou a posicao for invalida.
     */
    public Filme remover(int pos) throws Exception {
 
       //validar remocao
       if (n == 0 || pos < 0 || pos >= n) {
          throw new Exception("Erro ao remover!");
       }
       Filme resp = Filme.clonador(array[pos]);
       n--;
 
       for(int i = pos; i < n; i++){
          array[i] = array[i+1];
       }
       nomesRemovidos[nomesRemovidosCount]   =  resp.getNome();
       nomesRemovidosCount++;
       return resp;
    }
 
 
    /**
     * Mostra os elementos da lista separados por espacos.
     */
    public void mostrar (){
       System.out.print("[ ");
       for(int i = 0; i < n; i++){
          System.out.print(array[i] + " ");
       }
       System.out.println("]");
    }
 
 
    /**
     * Procura um elemento e retorna se ele existe.
     * @param x int elemento a ser pesquisado.
     * @return <code>true</code> se o array existir,
     * <code>false</code> em caso contrario.
     */
    public boolean pesquisar(Filme  filme) {
       boolean retorno = false;
       for (int i = 0; i < n && retorno == false; i++) {
          retorno = (array[i] == filme);
       }
       return retorno;
    }

    public static void reordenarSelection(Lista lista){
        int n = (lista.array).length;
 
        // One by one move boundary of unsorted subarray
        try{
            for (int i = 0; i < n-1; i++)
            {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if ((((lista.array[i]).getTituloOriginal()).compareTo((lista.array[j]).getTituloOriginal()))>0){
                    Filme filmeTemp = Filme.clonador(lista.array[i]);
                    lista.array[i] = Filme.clonador(lista.array[j]);
                    lista.array[j] = Filme.clonador(filmeTemp);
                   // System.out.println("trocou1");
                }
                /*else if ((((lista.array[i]).getTituloOriginal()).compareTo((lista.array[j]).getTituloOriginal()))<0){
                    Filme filmeTemp = Filme.clonador(lista.array[i]);
                        lista.array[i] = Filme.clonador(lista.array[j]);
                        lista.array[j] = Filme.clonador(filmeTemp);
                      //  System.out.println("trocou2");
                }*/
                else if ((((lista.array[i]).getTituloOriginal()).compareTo((lista.array[j]).getTituloOriginal())) == 0){
                    System.out.println("wtf");
                } 

 
            // Swap the found minimum element with the first
            // element
            Filme temp = Filme.clonador(lista.array[min_idx]);
            Filme temp2 = Filme.clonador((lista.array[i]));
            String tituloTemp = "";
            (lista.array[min_idx]) = Filme.clonador((lista.array[i]));
            lista.array[i] = Filme.clonador(temp);
            }
        }catch (NullPointerException npe){

        }
    }
    
    public void listaImprimir() {
        Filme[] tempArray = new Filme[n];
        for (int i=0;i<n;i++){
            tempArray[i]=Filme.clonador(array[i]);
        }
        for (int i = 0; i<nomesRemovidosCount;i++){
            System.out.println("(R) " + nomesRemovidos[i]);
        }
        for (int i=0;i<n;i++){
            System.out.println(tempArray[i].getNome() + " " + tempArray[i].getTituloOriginal() + " " + tempArray[i].getDataLancamento() + " " + String.valueOf(tempArray[i].getDuracao()) + " " + tempArray[i].getGenero()
            + " " + tempArray[i].getIdiomaOriginal()
            + " " + tempArray[i].getSituacao() + " " + String.valueOf(tempArray[i].getOrcamento()) + " " + Arrays.toString(tempArray[i].getPalavrasChave()));
        }
    }

    /*public static void listaImprimir2(Lista lista) {
        Filme[] tempArray = new Filme[(lista.array).length];
        for (int i=0;i<(lista.array).length;i++){
            tempArray[i]=Filme.clonador(lista.array[i]);
        }
        for (int i = 0; i<nomesRemovidosCount;i++){
            System.out.println("(R) " + nomesRemovidos[i]);
        }
        for (int i=0;i<(lista.array).length;i++){
            System.out.println(tempArray[i].getNome() + " " + tempArray[i].getTituloOriginal() + " " + tempArray[i].getDataLancamento() + " " + String.valueOf(tempArray[i].getDuracao()) + " " + tempArray[i].getGenero()
            + " " + tempArray[i].getIdiomaOriginal()
            + " " + tempArray[i].getSituacao() + " Lançado " + String.valueOf(tempArray[i].getOrcamento()) + " " + Arrays.toString(tempArray[i].getPalavrasChave()));
        }
    }*/
 
}

