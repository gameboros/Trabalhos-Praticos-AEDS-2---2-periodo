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

class TP04Q03 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in, "ISO-8859-1");
        String entrada = new String();
        Filme filmes = new Filme();
        Filme[] arrayFilmes = new Filme[50];
        String[] nomesPesquisa = new String[50];
        AVL arvore = new AVL();
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
            
        }

        try{
            entrada = sc.nextLine();
            numEntradas = Integer.parseInt(entrada);
        } catch (Exception e){
            
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
                case "R":
                    try {
                        arvore.remover(entradaOperacao);
                    } catch (Exception e) {
                        System.out.println("Deu bug no removerFim no switch case");
                        e.printStackTrace();
                    }

            }

        }

        entrada = sc.nextLine();

        do {
            boolean pesq = false;
            pesq = arvore.pesquisar(entrada.trim());
            System.out.println(entrada);
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
    public Filme elemento; // Conteudo do no.
    public No esq, dir; // Filhos da esq e dir.
    public int nivel;

    /**
     * Construtor da classe.
     * 
     * @param elemento Conteudo do no.
     */
    public No(Filme elemento) {
        this.elemento = Filme.clonador(elemento);
        this.esq = null;
        this.dir = null;
    }

    /**
     * Construtor da classe.
     * 
     * @param elemento Conteudo do no.
     * @param esq      No da esquerda.
     * @param dir      No da direita.
     */
    public No(Filme elemento, No esq, No dir) {
        this.elemento = Filme.clonador(elemento);
        this.esq = esq;
        this.dir = dir;
    }

    public void setNivel() {
		this.nivel = 1 + Math.max(getNivel(esq), getNivel(dir));
	}

	/**
	 * Retorna o número de níveis a partir de um vértice
	 * @param no nó que se deseja o nível.
	 */
	public static int getNivel(No no) {
		return (no == null) ? 0 : no.nivel;
	}
}

class AVL {
    private No raiz; // Raiz da arvore.
    private String resposta = "raiz ";
    private String print = new String();

    /**
     * Construtor da classe.
     */
    public AVL() {
        raiz = null;
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
        return pesquisar(tituloOriginal, raiz);
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
    private boolean pesquisar(String x, No i) {
        boolean resp;
        if (i == null) {
            resp = false;

        } else if (x.compareTo(i.elemento.getTituloOriginal()) == 0) {
            resp = true;

        } else if (x.compareTo(i.elemento.getTituloOriginal()) < 0) {
            resposta += "esq ";
            resp = pesquisar(x, i.esq);

        } else {
            resposta += "dir ";
            resp = pesquisar(x, i.dir);
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
     */
    public void inserir(Filme x) throws Exception {
        raiz = inserir(Filme.clonador(x), raiz);
    }

    /**
     * Metodo privado recursivo para inserir elemento.
     * 
     * @param x Elemento a ser inserido.
     * @param i No em analise.
     * @return No em analise, alterado ou nao.
     * @throws Exception Se o elemento existir.
     */
    private No inserir(Filme x, No i) throws Exception {
        if (i == null) {
            i = new No(Filme.clonador(x));

        } else if (x.getTituloOriginal().compareTo(i.elemento.getTituloOriginal()) < 0) {
            i.esq = inserir(x, i.esq);

        } else if (x.getTituloOriginal().compareTo(i.elemento.getTituloOriginal()) > 0) {
            i.dir = inserir(x, i.dir);

        } else {
            throw new Exception("Erro ao inserir!");
        }

        return balancear(i);    
    }

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
    public void remover(String x) throws Exception {
        raiz = remover(x, raiz);
    }

    /**
     * Metodo privado recursivo para remover elemento.
     * 
     * @param x Elemento a ser removido.
     * @param i No em analise.
     * @return No em analise, alterado ou nao.
     * @throws Exception Se nao encontrar elemento.
     */
    private No remover(String x, No i) throws Exception  {

        if (i == null) {
            

        } else if (x.compareTo(i.elemento.getTituloOriginal()) < 0) {
            i.esq = remover(x, i.esq);

        } else if (x.compareTo(i.elemento.getTituloOriginal()) > 0) {
            i.dir = remover(x, i.dir);

            // Sem no a direita.
        } else if (i.dir == null) {
            i = i.esq;

            // Sem no a esquerda.
        } else if (i.esq == null) {
            i = i.dir;

            // No a esquerda e no a direita.
        } else {
            i.esq = maiorEsq(i, i.esq);
        }

        return balancear(i);
    }

    private No balancear(No no) throws Exception {
		if (no != null) {
			int fator = No.getNivel(no.dir) - No.getNivel(no.esq);
			// Se balanceada
			if (Math.abs(fator) <= 1) {
				no.setNivel();
			// Se desbalanceada para a direita
			} else if (fator == 2) {
				int fatorFilhoDir = No.getNivel(no.dir.dir) - No.getNivel(no.dir.esq);
				// Se o filho a direita tambem estiver desbalanceado
				if (fatorFilhoDir == -1) {
					no.dir = rotacionarDir(no.dir);
				}
				no = rotacionarEsq(no);
			// Se desbalanceada para a esquerda
			} else if (fator == -2) {
				int fatorFilhoEsq = No.getNivel(no.esq.dir) - No.getNivel(no.esq.esq);
				// Se o filho a esquerda tambem estiver desbalanceado
				if (fatorFilhoEsq == 1) {
					no.esq = rotacionarEsq(no.esq);
				}
				no = rotacionarDir(no);
			} else {
				throw new Exception(
						"Erro no No(" + no.elemento + ") com fator de balanceamento (" + fator + ") invalido!");
			}
		}
		return no;
	}

    private No rotacionarDir(No no) {
		No noEsq = no.esq;
		No noEsqDir = noEsq.dir;

		noEsq.dir = no;
		no.esq = noEsqDir;
		no.setNivel(); // Atualizar o nivel do no
		noEsq.setNivel(); // Atualizar o nivel do noEsq

		return noEsq;
	}

	private No rotacionarEsq(No no) {
		No noDir = no.dir;
		No noDirEsq = noDir.esq;

		noDir.esq = no;
		no.dir = noDirEsq;

		no.setNivel(); // Atualizar o nivel do no
		noDir.setNivel(); // Atualizar o nivel do noDir
		return noDir;
	}
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
            i.elemento = Filme.clonador(j.elemento); // Substitui i por j.
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
