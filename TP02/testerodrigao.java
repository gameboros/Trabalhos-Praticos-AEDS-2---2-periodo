package sempassado.tp2;
import java.io.*;
import java.util.*;

class tp2ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Series serie = new Series();
        String entrada = "";
        do {
            try {
                entrada = "";
                entrada += sc.nextLine();
                serie.ler(/*"/tmp/" +*/ "series/" + entrada); // TODO retirar o comentario pra entregar no verde
                System.out.println(serie.imprimir());
            } catch (Exception e) {
                // e.printStackTrace();
            }
        } while (isFim(entrada) == false);
        sc.close();
    }

    public static boolean isFim(String s) { // teste para determinar se a linha é "FIM"
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

}

class Series {
    private String nome;
    private String formato;
    private String duracao;
    private String paisDeOrigem;
    private String idiomaOriginal;
    private String emissoraOriginal;
    private String transmissaoOriginal;
    private Integer numTemporadas;
    private Integer numEpisodios;

    public Series() {
    }

    public Series(String nome, String formato, String duracao, String paisDeOrigem, String idiomaOriginal,
            String emissoraOriginal, String transmissaoOriginal, int numTemporadas, int numEpisodios) {
        this.nome = nome;
        this.formato = formato;
        this.duracao = duracao;
        this.paisDeOrigem = paisDeOrigem;
        this.idiomaOriginal = idiomaOriginal;
        this.emissoraOriginal = emissoraOriginal;
        this.transmissaoOriginal = transmissaoOriginal;
        this.numTemporadas = numTemporadas;
        this.numEpisodios = numEpisodios;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getPaisDeOrigem() {
        return paisDeOrigem;
    }

    public void setPaisDeOrigem(String paisDeOrigem) {
        this.paisDeOrigem = paisDeOrigem;
    }

    public String getIdiomaOriginal() {
        return idiomaOriginal;
    }

    public void setIdiomaOriginal(String idiomaOriginal) {
        this.idiomaOriginal = idiomaOriginal;
    }

    public String getEmissoraOriginal() {
        return emissoraOriginal;
    }

    public void setEmissoraOriginal(String emissoraOriginal) {
        this.emissoraOriginal = emissoraOriginal;
    }

    public String getTransmissaoOriginal() {
        return transmissaoOriginal;
    }

    public void setTransmissaoOriginal(String transmissaoOriginal) {
        this.transmissaoOriginal = transmissaoOriginal;
    }

    public int getNumTemporadas() {
        return numTemporadas;
    }

    public void setNumTemporadas(int numTemporadas) {
        this.numTemporadas = numTemporadas;
    }

    public int getNumEpisodios() {
        return numEpisodios;
    }

    public void setNumEpisodios(int numEpisodios) {
        this.numEpisodios = numEpisodios;
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

    String removeTagsPais(String line) {
        String newline = "";
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '<') {
                i++;
                while (line.charAt(i) != '>') {
                    i++;
                }
            } else {// &#160;
                if (line.charAt(i) == '&') {
                    do {
                        i++;
                    } while (line.charAt(i) != ';');
                }
                newline += line.charAt(i);
            }
        }
        newline = newline.replace(";", "");
        return newline;
    }

    String removeTagsNum(String line) {
        String newline = "";
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '<') {
                i++;
                while (line.charAt(i) != '>') {
                    i++;
                }
            } else {
                if (line.charAt(i) < 48 || line.charAt(i) > 57) {
                    return newline;
                }
                newline += line.charAt(i);
            }
        }
        return newline;

    }

    public void ler(String nomeArquivo) throws Exception {
        InputStreamReader isr = new InputStreamReader(new FileInputStream(nomeArquivo));

        BufferedReader br = new BufferedReader(isr);
        while (!br.readLine().contains("infobox_v2"))
            ;
        br.readLine();
        this.nome = removeTags(br.readLine());

        while (!br.readLine().contains("Formato"))
            ;
        this.formato = removeTags(br.readLine());

        while (!br.readLine().contains("Duração"))
            ;
        this.duracao = removeTags(br.readLine());

        while (!br.readLine().contains("País de origem"))
            ;
        this.paisDeOrigem = removeTagsPais(br.readLine());

        while (!br.readLine().contains("Idioma original"))
            ;
        this.idiomaOriginal = removeTags(br.readLine());

        while (!br.readLine().contains("Emissora de televisão original"))
            ;
        this.emissoraOriginal = removeTags(br.readLine());

        while (!br.readLine().contains("Transmissão original"))
            ;
        this.transmissaoOriginal = removeTagsPais(br.readLine());

        while (!br.readLine().contains("N.º de temporadas"))
            ;
        this.numTemporadas = Integer.parseInt(removeTagsNum(br.readLine()));

        while (!br.readLine().contains("N.º de episódios"))
            ;
        this.numEpisodios = Integer.parseInt(removeTagsNum(br.readLine()));

        br.close();
    }

    public Series clone() {
        Series resp = new Series();
        resp.nome = this.nome;
        resp.formato = this.formato;
        resp.duracao = this.duracao;
        resp.paisDeOrigem = this.paisDeOrigem;
        resp.idiomaOriginal = this.idiomaOriginal;
        resp.emissoraOriginal = this.emissoraOriginal;
        resp.transmissaoOriginal = this.transmissaoOriginal;
        resp.numTemporadas = this.numTemporadas;
        resp.numEpisodios = this.numEpisodios;
        return resp;
    }

    public String imprimir() {
        return nome + " " + formato + " " + duracao + " " + paisDeOrigem + " " + idiomaOriginal + " " + emissoraOriginal
                + " " + transmissaoOriginal + " " + numTemporadas + " " + numEpisodios;
    }
}