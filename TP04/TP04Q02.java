import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

import javax.xml.stream.events.EntityDeclaration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.File;
import java.nio.charset.*;

class TP04Q02 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in, "ISO-8859-1");
        String entrada = new String();
        Filme filmes = new Filme();
        Filme[] arrayFilmes = new Filme[50];
        String[] nomesPesquisa = new String[50];
        ArvoreBinaria arvore = new ArvoreBinaria();
        int controlador = 0;
        int numEntradas = 0;
        entrada = "";
        entrada = sc.nextLine();

        try {
            do {

                // filmes.ler("/mnt/c/temp/2022-1/AULAS/TP04/filmes/" + entrada);

                filmes.ler("/tmp/filmes/" + entrada);
                arrayFilmes[controlador] = Filme.clonador(filmes);
                arvore.inserir(Filme.clonador(filmes));

                controlador++;
                // System.out.println("Nome do filme: " + filmes.getNome() + "Controlador: " +
                // controlador);
                entrada = sc.nextLine();
                entrada = entrada.trim();
                // System.out.println("1 Nome no indice zero: " + arrayFilmes[0].getNome() +
                // "Controlador: " + controlador);

                // System.out.println(filmes.getDataLancamento());
                // System.out.println(filmes.imprimir());

            } while (isFim(entrada) == false);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            entrada = sc.nextLine();
            numEntradas = Integer.parseInt(entrada);
        } catch (Exception e) {

        }

        for (int i = 0; i < numEntradas; i++) {
            String operacao = "";
            String entradaOperacao = "";
            int j = 0;
            entrada = sc.nextLine();
            entrada = entrada.trim();
            // System.out.println(entrada);
            try {
                while (entrada.charAt(j) != ' ') {
                    operacao += entrada.charAt(j);
                    j++;
                }
                j++;
                while (j != entrada.length()) {
                    entradaOperacao += entrada.charAt(j);
                    j++;
                }
            } catch (Exception e) {

            }
            // System.out.println("OPERAÇÃO: " + operacao);
            // System.out.println("ENTRADA OPERACAO: " + entradaOperacao);

            switch (operacao) {
                case "I":
                    try {
                        // filmes.ler("/mnt/c/temp/2022-1/AULAS/TP04/filmes/" + entradaOperacao);
                        filmes.ler("/tmp/filmes/" + entradaOperacao);
                        arvore.inserir(Filme.clonador(filmes));
                    } catch (Exception e) {
                        System.out.println("Deu bug no InserirFim no switch case");
                        e.printStackTrace();
                    }
                    break;

            }

        }

        entrada = sc.nextLine();

        do {
            boolean pesq = false;
            pesq = arvore.pesquisar(entrada.trim());
            System.out.println("=>" + entrada);
            System.out.print(arvore.getResposta());
            if (pesq) {
                System.out.println("SIM");
            } else {
                System.out.println("NAO");
            }
            entrada = sc.nextLine();
        } while (isFim(entrada) == false);

        sc.close();
    }

    public static boolean isFim(String s) { // teste para determinar se a linha é "FIM"
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
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
        InputStreamReader isr = new InputStreamReader(new FileInputStream(nomeArquivo), Charset.forName("ISO-8859-1"));
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
        isr = new InputStreamReader(new FileInputStream(nomeArquivo), Charset.forName("ISO-8859-1"));
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

class No {
    public char elemento; // Conteudo do no.
    public No esq; // No da esquerda.
    public No dir; // No da direita.
    public No2 outro;

    /**
     * Construtor da classe.
     * 
     * @param elemento Conteudo do no.
     */
    No(Filme filme) {
        this.outro = new No2(Filme.clonador(filme));
        this.elemento = filme.getTituloOriginal().charAt(0);
        this.esq = this.dir = null;
    }

    No(char elemento) {
        this.elemento = elemento;
    }

    /**
     * Construtor da classe.
     * 
     * @param elemento Conteudo do no.
     * @param esq      No da esquerda.
     * @param dir      No da direita.
     */
    No(Filme filme, No esq, No dir) {
        this.outro = new No2(Filme.clonador(filme));
        this.elemento = filme.getTituloOriginal().charAt(0);
        this.esq = esq;
        this.dir = dir;
    }
}

class No2 {
    public Filme elemento; // Conteudo do no.
    public No2 esq; // No da esquerda.
    public No2 dir; // No da direita.

    /**
     * Construtor da classe.
     * 
     * @param elemento Conteudo do no.
     */
    No2(Filme elemento) {
        this.elemento = Filme.clonador(elemento);
        this.esq = this.dir = null;
    }

    /**
     * Construtor da classe.
     * 
     * @param elemento Conteudo do no.
     * @param esq      No2 da esquerda.
     * @param dir      No2 da direita.
     */
    No2(Filme elemento, No2 esq, No2 dir) {
        this.elemento = Filme.clonador(elemento);
        this.esq = esq;
        this.dir = dir;
    }
}

class ArvoreBinaria {
    private No raiz; // Raiz da arvore.
    private String resposta = "raiz ";
    private String print = new String();

    /**
     * Construtor da classe.
     */
    public ArvoreBinaria() {
        raiz = null;
        try {
            inserirc('D');
            inserirc('R');
            inserirc('Z');
            inserirc('X');
            inserirc('V');
            inserirc('B');
            inserirc('F');
            inserirc('P');
            inserirc('U');
            inserirc('I');
            inserirc('G');
            inserirc('E');
            inserirc('J');
            inserirc('L');
            inserirc('H');
            inserirc('T');
            inserirc('A');
            inserirc('W');
            inserirc('S');
            inserirc('O');
            inserirc('M');
            inserirc('N');
            inserirc('K');
            inserirc('C');
            inserirc('Y');
            inserirc('Q');
        } catch (

        Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo publico iterativo para pesquisar elemento.
     * 
     * @param x Elemento que sera procurado.
     * @return <code>true</code> se o elemento existir,
     *         <code>false</code> em caso contrario.
     */
    public boolean pesquisar(String tituloOriginal) {
        resposta = "raiz ";
        return pesquisar(raiz, tituloOriginal);
    }

    public String getResposta() {
        return resposta;
    }

    /**
     * Metodo privado recursivo para pesquisar elemento.
     * 
     * @param x Elemento que sera procurado.
     * @param i No em analise.
     * @return <code>true</code> se o elemento existir,
     *         <code>false</code> em caso contrario.
     */
    private boolean pesquisar(No no, String x) {
        boolean resp;
        if (no == null) {
            resp = false;

        } else if (x.charAt(0) < no.elemento) {
            resposta += "esq ";
            resp = pesquisar(no.esq, x);

        } else if (x.charAt(0) > no.elemento) {
            resposta += "dir ";
            resp = pesquisar(no.dir, x);

        } else {
            resp = pesquisarSegundaArvore(no.outro, x);
        }
        return resp;
    }

    private boolean pesquisarSegundaArvore(No2 no, String x) {
        boolean resp;
        if (no == null) {
            resp = false;

        } else if (x.compareTo(no.elemento.getTituloOriginal()) < 0) {
            resposta += "ESQ ";
            resp = pesquisarSegundaArvore(no.esq, x);

        } else if (x.compareTo(no.elemento.getTituloOriginal()) > 0) {
            resposta += "DIR ";
            resp = pesquisarSegundaArvore(no.dir, x);

        } else {
            resp = true;
        }
        return resp;
    }

    /**
     * Metodo publico iterativo para exibir elementos.
     */
    public void caminharCentral() {
        print = new String();
        caminharCentral(raiz);
        System.out.println(print.trim());
    }

    /**
     * Metodo privado recursivo para exibir elementos.
     * 
     * @param i No em analise.
     */
    private void caminharCentral(No i) {
        if (i != null) {
            caminharCentral(i.esq); // Elementos da esquerda.
            print += i.elemento;
            print += ' ';
            caminharCentral(i.dir); // Elementos da direita.
        }
    }

    /**
     * Metodo publico iterativo para exibir elementos.
     */
    public void caminharPre() {
        print = new String();
        caminharPre(raiz);
        System.out.println(print.trim());
    }

    /**
     * Metodo privado recursivo para exibir elementos.
     * 
     * @param i No em analise.
     */
    private void caminharPre(No i) {
        if (i != null) {
            print += i.elemento;
            print += ' '; // Conteudo do no.
            caminharPre(i.esq); // Elementos da esquerda.
            caminharPre(i.dir); // Elementos da direita.
        }
    }

    /**
     * Metodo publico iterativo para exibir elementos.
     */
    public void caminharPos() {
        print = new String();
        caminharPos(raiz);
        System.out.println(print.trim());
    }

    /**
     * Metodo privado recursivo para exibir elementos.
     * 
     * @param i No em analise.
     */
    private void caminharPos(No i) {
        if (i != null) {
            caminharPos(i.esq); // Elementos da esquerda.
            caminharPos(i.dir); // Elementos da direita.
            print += i.elemento;
            print += ' '; // Conteudo do no.
        }
    }

    /**
     * Metodo publico iterativo para inserir elemento.
     * 
     * @param x Elemento a ser inserido.
     * @throws Exception Se o elemento existir.
     * 
     * 
     */
    public void inserir(Filme x) throws Exception {
        raiz = inserir(Filme.clonador(x), raiz);
    }

    public void inserirc(char x) throws Exception {
        raiz = inserir(x, raiz);
    }

    /**
     * Metodo privado recursivo para inserir elemento.
     * 
     * @param x Elemento a ser inserido.
     * @param i No em analise.
     * @return No em analise, alterado ou nao.
     * @throws Exception Se o elemento existir.
     */
    private No inserir(char x, No i) throws Exception {
        if (i == null) {
            i = new No(x);

        } else if (x < i.elemento) {
            i.esq = inserir(x, i.esq);

        } else if (x > i.elemento) {
            i.dir = inserir(x, i.dir);

        } else {
            throw new Exception("Erro ao inserir!");
        }

        return i;
    }

    /**
     * Metodo privado recursivo para inserir elemento.
     * 
     * @param x Elemento a ser inserido.
     * @param i No em analise.
     * @return No em analise, alterado ou nao.
     * @throws Exception Se o elemento existir.
     */

    private No inserir(Filme x, No i) {
        if (i == null) {
            i = new No(Filme.clonador(x));

        } else if (x.getTituloOriginal().charAt(0) < i.elemento) {
            i.esq = inserir(x, i.esq);

        } else if (x.getTituloOriginal().charAt(0) > i.elemento) {
            i.dir = inserir(x, i.dir);

        } else {
        }

        return i;
    }

    /*
     * private No inserir2(Filme x, No i) {
     * if (i == null) {
     * i = new No(Filme.clonador(x));
     * 
     * } else if (x.getTituloOriginal().compareTo(i.filme.getTituloOriginal()) < 0)
     * {
     * i.esq = inserir2(x, i.esq);
     * 
     * } else if (x.getTituloOriginal().compareTo(i.filme.getTituloOriginal()) > 0)
     * {
     * i.dir = inserir2(x, i.dir);
     * 
     * } else {
     * }
     * 
     * return i;
     * }
     */

    /**
     * Metodo publico para inserir elemento.
     * 
     * @param x Elemento a ser inserido.
     * @throws Exception Se o elemento existir.
     */
    /*
     * public void inserirPai(char x) throws Exception {
     * if (raiz == null) {
     * raiz = new No(x);
     * } else if (x < raiz.elemento) {
     * inserirPai(x, raiz.esq, raiz);
     * } else if (x > raiz.elemento) {
     * inserirPai(x, raiz.dir, raiz);
     * } else {
     * throw new Exception("Erro ao inserirPai!");
     * }
     * }
     */

    /**
     * Metodo privado recursivo para inserirPai elemento.
     * 
     * @param x   Elemento a ser inserido.
     * @param i   No em analise.
     * @param pai No superior ao em analise.
     * @throws Exception Se o elemento existir.
     */

    /*
     * private void inserirPai(char x, No i, No pai) throws Exception {
     * if (i == null) {
     * if (x < pai.elemento) {
     * pai.esq = new No(x);
     * } else {
     * pai.dir = new No(x);
     * }
     * } else if (x < i.elemento) {
     * inserirPai(x, i.esq, i);
     * } else if (x > i.elemento) {
     * inserirPai(x, i.dir, i);
     * } else {
     * throw new Exception("Erro ao inserirPai!");
     * }
     * }
     */

    /**
     * Metodo publico iterativo para remover elemento.
     * 
     * @param x Elemento a ser removido.
     * @throws Exception Se nao encontrar elemento.
     */

    /**
     * Metodo privado recursivo para remover elemento.
     * 
     * @param x Elemento a ser removido.
     * @param i No em analise.
     * @return No em analise, alterado ou nao.
     * @throws Exception Se nao encontrar elemento.
     */

    /**
     * Metodo para trocar o elemento "removido" pelo maior da esquerda.
     * 
     * @param i No que teve o elemento removido.
     * @param j No da subarvore esquerda.
     * @return No em analise, alterado ou nao.
     */
    private No maiorEsq(No i, No j) {

        // Encontrou o maximo da subarvore esquerda.
        if (j.dir == null) {
            i.elemento = j.elemento; // Substitui i por j.
            j = j.esq; // Substitui j por j.ESQ.

            // Existe no a direita.
        } else {
            // Caminha para direita.
            j.dir = maiorEsq(i, j.dir);
        }
        return j;
    }

    /**
     * Metodo que retorna o maior elemento da árvore
     * 
     * @return int maior elemento da árvore
     */
    /*
     * public int getMaior() {
     * int resp = -1;
     * 
     * if (raiz != null) {
     * No i;
     * for (i = raiz; i.dir != null; i = i.dir)
     * ;
     * resp = i.elemento;
     * }
     * 
     * return resp;
     * }
     */

    /**
     * Metodo que retorna o menor elemento da árvore
     * 
     * @return int menor elemento da árvore
     */
    /*
     * public int getMenor() {
     * int resp = -1;
     * 
     * if (raiz != null) {
     * No i;
     * for (i = raiz; i.esq != null; i = i.esq)
     * ;
     * resp = i.elemento;
     * }
     * 
     * return resp;
     * }
     */

    /**
     * Metodo que retorna a altura da árvore
     * 
     * @return int altura da árvore
     */
    public int getAltura() {
        return getAltura(raiz, 0);
    }

    /**
     * Metodo que retorna a altura da árvore
     * 
     * @return int altura da árvore
     */
    public int getAltura(No i, int altura) {
        if (i == null) {
            altura--;
        } else {
            int alturaEsq = getAltura(i.esq, altura + 1);
            int alturaDir = getAltura(i.dir, altura + 1);
            altura = (alturaEsq > alturaDir) ? alturaEsq : alturaDir;
        }
        return altura;
    }

    /**
     * Metodo publico iterativo para remover elemento.
     * 
     * @param x Elemento a ser removido.
     * @throws Exception Se nao encontrar elemento.
     */
    /*
     * public void remover2(int x) throws Exception {
     * if (raiz == null) {
     * throw new Exception("Erro ao remover2!");
     * } else if (x < raiz.elemento) {
     * remover2(x, raiz.esq, raiz);
     * } else if (x > raiz.elemento) {
     * remover2(x, raiz.dir, raiz);
     * } else if (raiz.dir == null) {
     * raiz = raiz.esq;
     * } else if (raiz.esq == null) {
     * raiz = raiz.dir;
     * } else {
     * raiz.esq = maiorEsq(raiz, raiz.esq);
     * }
     * }
     */

    /**
     * Metodo privado recursivo para remover elemento.
     * 
     * @param x   Elemento a ser removido.
     * @param i   No em analise.
     * @param pai do No em analise.
     * @throws Exception Se nao encontrar elemento.
     */
    /*
     * private void remover2(int x, No i, No pai) throws Exception {
     * if (i == null) {
     * throw new Exception("Erro ao remover2!");
     * } else if (x < i.elemento) {
     * remover2(x, i.esq, i);
     * } else if (x > i.elemento) {
     * remover2(x, i.dir, i);
     * } else if (i.dir == null) {
     * pai = i.esq;
     * } else if (i.esq == null) {
     * pai = i.dir;
     * } else {
     * i.esq = maiorEsq(i, i.esq);
     * }
     * }
     */

    /*
     * public String getRaiz() throws Exception {
     * return raiz.elemento.getTituloOriginal();
     * }
     * 
     * public static boolean igual(ArvoreBinaria a1, ArvoreBinaria a2) {
     * return igual(a1.raiz, a2.raiz);
     * }
     * 
     * private static boolean igual(No i1, No i2) {
     * boolean resp;
     * if (i1 != null && i2 != null) {
     * resp = (i1.elemento == i2.elemento) && igual(i1.esq, i2.esq) && igual(i1.dir,
     * i2.dir);
     * } else if (i1 == null && i2 == null) {
     * resp = true;
     * } else {
     * resp = false;
     * }
     * return resp;
     * }
     * 
     * public int soma() {
     * return soma(raiz);
     * }
     * 
     * public int soma(No i) {
     * int resp = 0;
     * if (i != null) {
     * resp = i.elemento + soma(i.esq) + soma(i.dir);
     * }
     * return resp;
     * }
     * 
     * public int quantidadePares() {
     * return quantidadePares(raiz);
     * }
     * 
     * public int quantidadePares(No i) {
     * int resp = 0;
     * if (i != null) {
     * resp = ((i.elemento % 2 == 0) ? 1 : 0) + quantidadePares(i.esq) +
     * quantidadePares(i.dir);
     * }
     * return resp;
     * }
     * 
     * public boolean hasDiv11() {
     * return hasDiv11(raiz);
     * }
     * 
     * public boolean hasDiv11(No i) {
     * boolean resp = false;
     * if (i != null) {
     * resp = (i.elemento % 11 == 0) || hasDiv11(i.esq) || hasDiv11(i.dir);
     * }
     * return resp;
     * }
     */
}
