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

class TP03Q016 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        String entrada = new String();
        Filme filmes = new Filme();
        Filme[] arrayFilmes = new Filme[50];
        String[] nomesPesquisa = new String[50];
        Lista listafilmes = new Lista();
        int controlador = 0;
        int numEntradas = 0;
        int pesquisaCont = 0;
        entrada = "";
        entrada = sc.nextLine();
        do {
            try {

                // filmes.ler("/mnt/c/temp/2022-1/AULAS/TP03/filmes/" + entrada);

                filmes.ler("/tmp/filmes/" + entrada);
                // System.out.println("Entrada " + controlador + ":" + "Nome: " +
                // filmes.getNome());
                arrayFilmes[controlador] = Filme.clonador(filmes);
                listafilmes.inserirFim(filmes);
                controlador++;
                // System.out.println("Nome do filme: " + filmes.getNome() + "Controlador: " +
                // controlador);
                entrada = sc.nextLine();
                // System.out.println("1 Nome no indice zero: " + arrayFilmes[0].getNome() +
                // "Controlador: " + controlador);
            } catch (Exception e) {
                e.printStackTrace();
                entrada = sc.nextLine();
            }
            // System.out.println(filmes.getDataLancamento());
            // System.out.println(filmes.imprimir());

        } while (isFim(entrada) == false);

        listafilmes.quickSort(listafilmes.primeiro, listafilmes.ultimo);

        listafilmes.mostrar();
        sc.close();
    }

    public static boolean isFim(String s) { // teste para determinar se a linha é "FIM"
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static void mergeSort(Filme[] arrayFilmes, int inputCounter) {
        if (inputCounter < 2) {
            return;
        }
        int mid = inputCounter / 2;
        Filme[] esquerda = new Filme[mid];
        Filme[] direita = new Filme[inputCounter - mid];

        for (int i = 0; i < mid; i++) {
            esquerda[i] = Filme.clonador(arrayFilmes[i]);
        }
        for (int i = mid; i < inputCounter; i++) {
            direita[i - mid] = Filme.clonador(arrayFilmes[i]);
        }
        mergeSort(esquerda, mid);
        mergeSort(direita, inputCounter - mid);

        merge(arrayFilmes, esquerda, direita, mid, inputCounter - mid);
    }

    public static void merge(Filme[] arrayFilmes, Filme[] l, Filme[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if ((l[i].getOrcamento() < r[j].getOrcamento()) || l[i].getOrcamento() == r[j].getOrcamento()
                    && l[i].getNome().compareToIgnoreCase(r[j].getNome()) < 0) {
                arrayFilmes[k++] = l[i++];
            } else {
                arrayFilmes[k++] = r[j++];
            }
        }
        while (i < left) {
            arrayFilmes[k++] = l[i++];
        }
        while (j < right) {
            arrayFilmes[k++] = r[j++];
        }
    }

    /*
     * public static void quicksort(int esq, int dir, Filme array[]) {
     * int i = esq, j = dir;
     * Filme pivo = Filme.clonador(array[(esq + dir) / 2]);
     * while (i <= j) {
     * while (array[i].getSituacao().compareTo(pivo.getSituacao()) < 0)
     * i++;
     * while (array[j].getSituacao().compareTo(pivo.getSituacao()) > 0)
     * j--;
     * 
     * if (i <= j) {
     * Filme aux = Filme.clonador(array[i]);
     * array[i] = Filme.clonador(array[j]);
     * array[j] = Filme.clonador(aux);
     * i++;
     * j--;
     * }
     * }
     * if (esq < j)
     * quicksort(esq, j, array);
     * if (i < dir)
     * quicksort(i, dir, array);
     * 
     * }
     */
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

    public static Filme clonador(Filme filme) {
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

    public Date getDataLancamentoDate() {
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
        char teste = 'h';
        int resultado = 0;
        int i = 0;
        s = (s.trim()).replace(" ", "");
        if (s.indexOf(teste) != -1) {
            try {
                while (s.charAt(i) != 'h' && s.charAt(i) != 'm') {
                    horas += s.charAt(i);
                    i++;
                }
                i++;
                while (s.charAt(i) != 'm') {
                    minutos += s.charAt(i);
                    i++;
                }
            } catch (Exception e) {
                return 0;
            }
            resultado = ((Integer.parseInt(horas) * 60) + Integer.parseInt(minutos));
        } else {
            while (s.charAt(i) != 'm') {
                minutos += s.charAt(i);
                i++;
            }
            resultado = Integer.parseInt(minutos);
        }

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
                + " Lançado " + situacao + " " + String.valueOf(orcamento) + " " + Arrays.toString(palavrasChave);
    }

}

class CelulaDupla {
    public Filme elemento;
    public CelulaDupla ant;
    public CelulaDupla prox;

    /**
     * Construtor da classe.
     */
    public CelulaDupla() {
        this.elemento = new Filme();
    }

    /**
     * Construtor da classe.
     * 
     * @param elemento int inserido na celula.
     */
    public CelulaDupla(Filme elemento) {
        this.elemento = Filme.clonador(elemento);
        this.ant = this.prox = null;
    }
}

class Lista {
    CelulaDupla primeiro;
    CelulaDupla ultimo;
    private int n;
    int nomesRemovidosCount = 0;
    private String[] nomesRemovidos = new String[9];

    /**
     * Construtor da classe que cria uma lista sem elementos (somente no cabeca).
     */
    public Lista() {
        primeiro = new CelulaDupla();
        ultimo = primeiro;
    }

    public Lista(Filme[] arrayFilme, int m) {
        primeiro = new CelulaDupla();
        ultimo = primeiro;
        for (int i = 0; i < m; i++) {
            ultimo.prox = new CelulaDupla(Filme.clonador(arrayFilme[i]));
            ultimo.prox.ant = ultimo;
            ultimo = ultimo.prox;
            n++;
        }

    }

    /**
     * Insere um elemento na primeira posicao da lista.
     * 
     * @param x int elemento a ser inserido.
     */
    public void inserirInicio(Filme x) {
        CelulaDupla tmp = new CelulaDupla(Filme.clonador(x));
        tmp.ant = primeiro;
        tmp.prox = primeiro.prox;
        primeiro.prox = tmp;
        if (primeiro == ultimo) {
            ultimo = tmp;
        } else {
            tmp.prox.ant = tmp;
        }
        tmp = null;
        n++;
    }

    /**
     * Insere um elemento na ultima posicao da lista.
     * 
     * @param x int elemento a ser inserido.
     */
    public void inserirFim(Filme x) {
        ultimo.prox = new CelulaDupla(Filme.clonador(x));
        ultimo = ultimo.prox;
        n++;
    }

    /**
     * Remove um elemento da primeira posicao da lista.
     * 
     * @return resp int elemento a ser removido.
     * @throws Exception Se a lista nao contiver elementos.
     */
    public Filme removerInicio() throws Exception {
        if (primeiro == ultimo) {
            throw new Exception("Erro ao remover (vazia)!");
        }

        CelulaDupla tmp = primeiro;
        primeiro = primeiro.prox;
        Filme resp = Filme.clonador(primeiro.elemento);
        tmp.prox = primeiro.ant = null;
        tmp = null;
        nomesRemovidos[nomesRemovidosCount] = resp.getNome();
        nomesRemovidosCount++;
        n--;
        return resp;

    }

    /**
     * Remove um elemento da ultima posicao da lista.
     * 
     * @return resp int elemento a ser removido.
     * @throws Exception Se a lista nao contiver elementos.
     */
    public Filme removerFim() throws Exception {
        if (primeiro == ultimo) {
            throw new Exception("Erro ao remover (vazia)!");
        }

        // Caminhar ate a penultima celula:

        Filme resp = Filme.clonador(ultimo.elemento);
        ultimo = ultimo.ant;
        ultimo.prox.ant = null;
        ultimo.prox = null;
        nomesRemovidos[nomesRemovidosCount] = resp.getNome();
        nomesRemovidosCount++;
        n--;
        return resp;

    }

    /**
     * Insere um elemento em uma posicao especifica considerando que o
     * primeiro elemento valido esta na posicao 0.
     * 
     * @param x   int elemento a ser inserido.
     * @param pos int posicao da insercao.
     * @throws Exception Se <code>posicao</code> invalida.
     */
    public void inserir(Filme x, int pos) throws Exception {

        int tamanho = tamanho();

        if (pos < 0 || pos > tamanho) {
            throw new Exception("Erro ao inserir posicao (" + pos + " / tamanho = " + tamanho + ") invalida!");
        } else if (pos == 0) {
            inserirInicio(x);
        } else if (pos == tamanho) {
            inserirFim(x);
        } else {
            // Caminhar ate a posicao anterior a insercao
            CelulaDupla i = primeiro;
            for (int j = 0; j < pos; j++, i = i.prox)
                ;

            CelulaDupla tmp = new CelulaDupla(Filme.clonador(x));
            tmp.ant = i;
            tmp.prox = i.prox;
            tmp.ant.prox = tmp.prox.ant = tmp;
            tmp = i = null;
        }
        n++;
    }

    /**
     * Remove um elemento de uma posicao especifica da lista
     * considerando que o primeiro elemento valido esta na posicao 0.
     * 
     * @param posicao Meio da remocao.
     * @return resp int elemento a ser removido.
     * @throws Exception Se <code>posicao</code> invalida.
     */
    public Filme remover(int pos) throws Exception {
        Filme resp;
        int tamanho = tamanho();

        if (primeiro == ultimo) {
            throw new Exception("Erro ao remover (vazia)!");

        } else if (pos < 0 || pos >= tamanho) {
            throw new Exception("Erro ao remover (posicao " + pos + " / " + tamanho + " invalida!");
        } else if (pos == 0) {
            resp = Filme.clonador(removerInicio());
        } else if (pos == tamanho - 1) {
            resp = Filme.clonador(removerFim());
        } else {
            // Caminhar ate a posicao anterior a insercao
            CelulaDupla i = primeiro;
            for (int j = 0; j < pos; j++, i = i.prox)
                ;

            i.ant.prox = i.prox;
            i.prox.ant = i.ant;
            resp = Filme.clonador(i.elemento);
            i.prox = i.ant = null;
            i = null;
        }
        nomesRemovidos[nomesRemovidosCount] = resp.getNome();
        nomesRemovidosCount++;
        n--;
        return resp;
    }

    /**
     * Mostra os elementos da lista separados por espacos.
     */
    public void mostrar() {
        int control = 0;
        for (int i = 0; i < nomesRemovidosCount; i++) {
            System.out.println("(R) " + nomesRemovidos[i]);
        }
        for (CelulaDupla i = primeiro.prox; i != null; i = i.prox) {
            System.out.println("[" + control + "]" + i.elemento.imprimir() + " ");
            control++;
        }
        System.out.println("] ");
    }

    public boolean pesquisar(Filme x) {
        boolean resp = false;
        for (CelulaDupla i = primeiro.prox; i != null; i = i.prox) {
            if (i.elemento == Filme.clonador(x)) {
                resp = true;
                i = ultimo;
            }
        }
        return resp;
    }

    public CelulaDupla partition(CelulaDupla primeiro, CelulaDupla ultimo) {
        CelulaDupla atual = primeiro;
        CelulaDupla tmp = primeiro.ant;
        Filme temp = new Filme();
        try {

            while (atual != null && atual != ultimo) {
                if ((atual.elemento.getNome()).compareTo(ultimo.elemento.getNome()) < 0) {
                    if (tmp == null) {
                        tmp = primeiro;
                    } else {
                        tmp = tmp.prox;
                    }
                    temp = atual.elemento;
                    atual.elemento = tmp.elemento;
                    tmp.elemento = temp;
                }
                atual = atual.prox;
            }
            if (tmp == null) {
                tmp = primeiro;
            } else {
                tmp = tmp.prox;
            }
            temp = ultimo.elemento;
            ultimo.elemento = tmp.elemento;
            tmp.elemento = temp;
            return tmp;

        } catch (Exception npe) {
            return tmp;
        }
    }

    public void quickSort(CelulaDupla primeiro, CelulaDupla ultimo) {
        try {
            if (primeiro != ultimo && primeiro != null &&
                    ultimo != null && ultimo.prox != primeiro) {
                CelulaDupla no = this.partition(primeiro, ultimo);
                if (no != null) {
                    // Recursively sort elements
                    this.quickSort(no.prox, ultimo);
                    this.quickSort(primeiro, no.ant);
                }
            }
        } catch (Exception e) {

        }
    }

    public int tamanho() {
        int tamanho = 0;
        for (CelulaDupla i = primeiro; i != ultimo; i = i.prox, tamanho++)
            ;
        return tamanho;
    }
}
