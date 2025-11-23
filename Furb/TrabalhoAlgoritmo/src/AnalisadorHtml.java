package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnalisadorHtml {

    private final String[] SINGLETON_TAGS = {"meta", "base", "br", "col", "command", "embed", "hr", "img", "input", "link", "param", "source", "!doctype"};
    private Pilha<String> pilha;
    private ListaEncadeada<TagContador> contadores;
    private String resultadoAnalise;

    public AnalisadorHtml() {
        this.pilha = new PilhaLista<>();
        this.contadores = new ListaEncadeada<>();
        this.resultadoAnalise = "";
    }

    public void analisar(String caminhoArquivo) {
        pilha.liberar();
        contadores = new ListaEncadeada<>();
        resultadoAnalise = "";

        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            int numeroLinha = 0;
            Pattern pattern = Pattern.compile("<(/?)(\\w+)([^>]*)>");

            while ((linha = reader.readLine()) != null) {
                numeroLinha++;
                linha = linha.trim();
                if (linha.isEmpty()) {
                    continue;
                }

                Matcher matcher = pattern.matcher(linha);
                while (matcher.find()) {
                    boolean isClosingTag = !matcher.group(1).isEmpty();
                    String tagName = matcher.group(2).toLowerCase();

                    if (isSingleton(tagName)) {
                        contarTag(tagName);
                        continue;
                    }

                    if (isClosingTag) {
                        if (pilha.estaVazia()) {
                            resultadoAnalise = "Erro: Tag final '" + tagName + "' encontrada na linha " + numeroLinha + " mas não há tag inicial correspondente.";
                            return;
                        }
                        String tagAberta = pilha.pop();
                        if (!tagAberta.equals(tagName)) {
                            resultadoAnalise = "Erro: Tag final inesperada. Esperado: '</" + tagAberta + ">', encontrado: '</" + tagName + ">' na linha " + numeroLinha + ".";
                            return;
                        }
                    } else { // Opening tag
                        pilha.push(tagName);
                        contarTag(tagName);
                    }
                }
            }

            if (!pilha.estaVazia()) {
                StringBuilder sb = new StringBuilder("Erro: Fim do arquivo alcançado, mas as seguintes tags não foram fechadas: ");
                while(!pilha.estaVazia()){
                    sb.append("<").append(pilha.pop()).append("> ");
                }
                resultadoAnalise = sb.toString().trim();
            } else {
                resultadoAnalise = "O arquivo está bem formatado.";
            }

        } catch (IOException e) {
            resultadoAnalise = "Erro ao ler o arquivo: " + e.getMessage();
        } catch (PilhaVaziaException e) {
            resultadoAnalise = "Erro de estrutura: " + e.getMessage();
        }
    }

    private void contarTag(String nomeTag) {
        NoLista<TagContador> atual = contadores.getPrimeiro();
        while (atual != null) {
            if (atual.getInfo().getNome().equals(nomeTag)) {
                atual.getInfo().incrementar();
                return;
            }
            atual = atual.getProximo();
        }
        contadores.inserir(new TagContador(nomeTag));
    }

    private boolean isSingleton(String tagName) {
        for (String singleton : SINGLETON_TAGS) {
            if (singleton.equals(tagName)) {
                return true;
            }
        }
        return false;
    }

    public String getResultadoAnalise() {
        return resultadoAnalise;
    }

    public ListaEncadeada<TagContador> getContadores() {
        if (resultadoAnalise.equals("O arquivo está bem formatado.")) {
             return ordenarContadores(contadores);
        }
        return new ListaEncadeada<>();
    }

    private ListaEncadeada<TagContador> ordenarContadores(ListaEncadeada<TagContador> lista) {
        int n = lista.obterComprimento();
        if (n <= 1) {
            return lista;
        }

        TagContador[] array = new TagContador[n];
        NoLista<TagContador> no = lista.getPrimeiro();
        for (int i = 0; i < n; i++) {
            array[i] = no.getInfo();
            no = no.getProximo();
        }

        mergesort(array, 0, n - 1);

        ListaEncadeada<TagContador> sortedList = new ListaEncadeada<>();
        for (TagContador tc : array) {
            sortedList.inserirNoFinal(tc);
        }
        return sortedList;
    }

    private void mergesort(TagContador[] array, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergesort(array, inicio, meio);
            mergesort(array, meio + 1, fim);
            intercalar(array, inicio, meio, fim);
        }
    }

    private void intercalar(TagContador[] array, int inicio, int meio, int fim) {
        TagContador[] temp = new TagContador[array.length];
        for (int i = inicio; i <= fim; i++) {
            temp[i] = array[i];
        }

        int i = inicio;
        int j = meio + 1;
        int k = inicio;

        while (i <= meio && j <= fim) {
            if (temp[i].compareTo(temp[j]) <= 0) {
                array[k] = temp[i];
                i++;
            } else {
                array[k] = temp[j];
                j++;
            }
            k++;
        }

        while (i <= meio) {
            array[k] = temp[i];
            i++;
            k++;
        }
    }
}