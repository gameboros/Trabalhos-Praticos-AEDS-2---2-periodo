import java.io.*;
import java.util.*;

class TP04Q09 {
    public static void main(String[] args) throws NoSuchElementException {
        Scanner sc = new Scanner(System.in);
        String entrada = new String();
        int testes = 0;
        int controlador = 1;
        String numeros = new String();
        try {
            entrada = "";
            ArvoreBinaria arvore = new ArvoreBinaria();

            do {
                entrada = sc.nextLine();
                entrada = entrada.trim();
                char operacao = 'a';
                char entradaOperacao = 'a';
                int j = 0;
                try {
                    if (entrada.length() <= 3) {
                        operacao = entrada.charAt(0);
                        entradaOperacao = entrada.charAt(2);

                        switch (operacao) {
                            case 'I':
                                arvore.inserir((entradaOperacao));
                                break;
                            case 'P':
                                if (arvore.pesquisar(entradaOperacao)) {
                                    System.out.println(entradaOperacao + " existe");
                                } else {
                                    System.out.println(entradaOperacao + " nao existe");
                                }
                                break;

                        }
                    } else {
                        switch (entrada) {
                            case "INFIXA":
                                arvore.caminharCentral();
                                break;
                            case "PREFIXA":
                                arvore.caminharPre();
                                break;
                            case "POSFIXA":
                                arvore.caminharPos();
                                break;

                        }
                    }
                } catch (Exception e) {

                }

                /*
                 * -------------------TESTE 1 -----------------------
                 * 
                 * for (int i = 0; i < numeros.length(); i++) {
                 * if (numeros.charAt(i) != ' ' && numeros.charAt(i) >= 48 && numeros.charAt(i)
                 * <= 57) {
                 * arvore.inserir(Character.getNumericValue(numeros.charAt(i)));
                 * }
                 * }
                 * -----------------------TESTE 2 ------------------------
                 */
            } while (sc.hasNext());
        } catch (Exception e) {
            e.printStackTrace();
        }
        sc.close();
    }

    public static boolean isFim(String s) { // teste para determinar se a linha Ã© "FIM"
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

}

class No {
    public Filme elemento; // Conteudo do no.
    public No esq, dir; // Filhos da esq e dir.

    /**
     * Construtor da classe.
     * 
     * @param elemento Conteudo do no.
     */
    public No(Filme elemento) {
        this((Filme.clonador(elemento)), null, null);
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
}

class ArvoreBinaria {
    private No raiz; // Raiz da arvore.

    /**
     * Construtor da classe.
     */
    public ArvoreBinaria() {
        raiz = null;
    }

    /**
     * Metodo publico iterativo para pesquisar elemento.
     * 
     * @param x Elemento que sera procurado.
     * @return <code>true</code> se o elemento existir,
     *         <code>false</code> em caso contrario.
     */
    public boolean pesquisar(char x) {
        return pesquisar(x, raiz);
    }

    /**
     * Metodo privado recursivo para pesquisar elemento.
     * 
     * @param x Elemento que sera procurado.
     * @param i No em analise.
     * @return <code>true</code> se o elemento existir,
     *         <code>false</code> em caso contrario.
     */
    private boolean pesquisar(char x, No i) {
        boolean resp;
        if (i == null) {
            resp = false;

        } else if (x == i.elemento) {
            resp = true;

        } else if (x < i.elemento) {
            resp = pesquisar(x, i.esq);

        } else {
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
    public void inserir(char x) throws Exception {
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
            System.out.println(x);
            throw new Exception("Erro ao inserir!");
        }

        return i;
    }

    /**
     * Metodo publico para inserir elemento.
     * 
     * @param x Elemento a ser inserido.
     * @throws Exception Se o elemento existir.
     */
    public void inserirPai(char x) throws Exception {
        if (raiz == null) {
            raiz = new No(x);
        } else if (x < raiz.elemento) {
            inserirPai(x, raiz.esq, raiz);
        } else if (x > raiz.elemento) {
            inserirPai(x, raiz.dir, raiz);
        } else {
            throw new Exception("Erro ao inserirPai!");
        }
    }

    /**
     * Metodo privado recursivo para inserirPai elemento.
     * 
     * @param x   Elemento a ser inserido.
     * @param i   No em analise.
     * @param pai No superior ao em analise.
     * @throws Exception Se o elemento existir.
     */
    private void inserirPai(char x, No i, No pai) throws Exception {
        if (i == null) {
            if (x < pai.elemento) {
                pai.esq = new No(x);
            } else {
                pai.dir = new No(x);
            }
        } else if (x < i.elemento) {
            inserirPai(x, i.esq, i);
        } else if (x > i.elemento) {
            inserirPai(x, i.dir, i);
        } else {
            throw new Exception("Erro ao inserirPai!");
        }
    }

    /**
     * Metodo publico iterativo para remover elemento.
     * 
     * @param x Elemento a ser removido.
     * @throws Exception Se nao encontrar elemento.
     */
    public void remover(int x) throws Exception {
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
    private No remover(int x, No i) throws Exception {

        if (i == null) {
            throw new Exception("Erro ao remover!");

        } else if (x < i.elemento) {
            i.esq = remover(x, i.esq);

        } else if (x > i.elemento) {
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

        return i;
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
    public int getMaior() {
        int resp = -1;

        if (raiz != null) {
            No i;
            for (i = raiz; i.dir != null; i = i.dir)
                ;
            resp = i.elemento;
        }

        return resp;
    }

    /**
     * Metodo que retorna o menor elemento da árvore
     * 
     * @return int menor elemento da árvore
     */
    public int getMenor() {
        int resp = -1;

        if (raiz != null) {
            No i;
            for (i = raiz; i.esq != null; i = i.esq)
                ;
            resp = i.elemento;
        }

        return resp;
    }

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
    public void remover2(int x) throws Exception {
        if (raiz == null) {
            throw new Exception("Erro ao remover2!");
        } else if (x < raiz.elemento) {
            remover2(x, raiz.esq, raiz);
        } else if (x > raiz.elemento) {
            remover2(x, raiz.dir, raiz);
        } else if (raiz.dir == null) {
            raiz = raiz.esq;
        } else if (raiz.esq == null) {
            raiz = raiz.dir;
        } else {
            raiz.esq = maiorEsq(raiz, raiz.esq);
        }
    }

    /**
     * Metodo privado recursivo para remover elemento.
     * 
     * @param x   Elemento a ser removido.
     * @param i   No em analise.
     * @param pai do No em analise.
     * @throws Exception Se nao encontrar elemento.
     */
    private void remover2(int x, No i, No pai) throws Exception {
        if (i == null) {
            throw new Exception("Erro ao remover2!");
        } else if (x < i.elemento) {
            remover2(x, i.esq, i);
        } else if (x > i.elemento) {
            remover2(x, i.dir, i);
        } else if (i.dir == null) {
            pai = i.esq;
        } else if (i.esq == null) {
            pai = i.dir;
        } else {
            i.esq = maiorEsq(i, i.esq);
        }
    }

    public int getRaiz() throws Exception {
        return raiz.elemento;
    }

    public static boolean igual(ArvoreBinaria a1, ArvoreBinaria a2) {
        return igual(a1.raiz, a2.raiz);
    }

    private static boolean igual(No i1, No i2) {
        boolean resp;
        if (i1 != null && i2 != null) {
            resp = (i1.elemento == i2.elemento) && igual(i1.esq, i2.esq) && igual(i1.dir, i2.dir);
        } else if (i1 == null && i2 == null) {
            resp = true;
        } else {
            resp = false;
        }
        return resp;
    }

    public int soma() {
        return soma(raiz);
    }

    public int soma(No i) {
        int resp = 0;
        if (i != null) {
            resp = i.elemento + soma(i.esq) + soma(i.dir);
        }
        return resp;
    }

    public int quantidadePares() {
        return quantidadePares(raiz);
    }

    public int quantidadePares(No i) {
        int resp = 0;
        if (i != null) {
            resp = ((i.elemento % 2 == 0) ? 1 : 0) + quantidadePares(i.esq) + quantidadePares(i.dir);
        }
        return resp;
    }

    public boolean hasDiv11() {
        return hasDiv11(raiz);
    }

    public boolean hasDiv11(No i) {
        boolean resp = false;
        if (i != null) {
            resp = (i.elemento % 11 == 0) || hasDiv11(i.esq) || hasDiv11(i.dir);
        }
        return resp;
    }
}

