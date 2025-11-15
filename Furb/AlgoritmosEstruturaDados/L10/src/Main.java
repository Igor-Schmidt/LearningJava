package src;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Integer[] dados = {70, 2, 88, 15, 90, 30};

        // Caso 1: Validar algoritmo de ordenação Bolha
        Integer[] dadosBolha = Arrays.copyOf(dados, dados.length);
        OrdenacaoBolha<Integer> bolha = new OrdenacaoBolha<>(dadosBolha);
        bolha.ordenar();
        System.out.println("Ordenação Bolha: " + Arrays.toString(bolha.getInfo()));

        // Caso 2: Validar algoritmo de ordenação bolha otimizado
        Integer[] dadosBolhaOtimizada = Arrays.copyOf(dados, dados.length);
        OrdenacaoBolhaOtimizada<Integer> bolhaOtimizada = new OrdenacaoBolhaOtimizada<>(dadosBolhaOtimizada);
        bolhaOtimizada.ordenar();
        System.out.println("Ordenação Bolha Otimizada: " + Arrays.toString(bolhaOtimizada.getInfo()));

        // Caso 3: Validar algoritmo de ordenação Quicksort
        Integer[] dadosQuickSort = Arrays.copyOf(dados, dados.length);
        OrdenacaoQuickSort<Integer> quickSort = new OrdenacaoQuickSort<>(dadosQuickSort);
        quickSort.ordenar();
        System.out.println("Ordenação QuickSort: " + Arrays.toString(quickSort.getInfo()));

        // Caso 4: Validar algoritmo de ordenação MergeSort
        Integer[] dadosMergeSort = Arrays.copyOf(dados, dados.length);
        OrdenacaoMergeSort<Integer> mergeSort = new OrdenacaoMergeSort<>(dadosMergeSort);
        mergeSort.ordenar();
        System.out.println("Ordenação MergeSort: " + Arrays.toString(mergeSort.getInfo()));
    }
}
