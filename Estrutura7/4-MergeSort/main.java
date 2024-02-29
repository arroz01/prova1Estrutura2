import java.util.Arrays;
import java.util.Random;

public class main {

    public static void main(String[] args) {
        int tamanho = 1000000; // 1 milhão de elementos
        MergeSort mergeSort = new MergeSort();

        // Vetor já ordenado
        int[] vetorOrdenado = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetorOrdenado[i] = i;
        }
        System.out.println("Vetor Ordenado:");
        mergeSort.sort(vetorOrdenado);

        // Vetor invertido
        int[] vetorInvertido = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetorInvertido[i] = tamanho - i;
        }
        System.out.println("\nVetor Invertido:");
        mergeSort.sort(vetorInvertido);

        // Vetor aleatório
        int[] vetorAleatorio = new int[tamanho];
        Random random = new Random();
        for (int i = 0; i < tamanho; i++) {
            vetorAleatorio[i] = random.nextInt(tamanho);
        }
        System.out.println("\nVetor Aleatório:");
        mergeSort.sort(vetorAleatorio);
    }

    static class MergeSort {
        private long comparacoes = 0;
        private long trocas = 0;
        private long tempoInicio = 0;

        // iniciar a ordenação
        public void sort(int[] vetor) {
            comparacoes = 0;
            trocas = 0;
            tempoInicio = System.currentTimeMillis();
            mergeSort(vetor, 0, vetor.length - 1);
            System.out.println("Tempo de execução (ms): " + (System.currentTimeMillis() - tempoInicio));
            System.out.println("Comparações: " + comparacoes);
            System.out.println("Trocas: " + trocas);
        }

        // Implementação do Merge Sort
        private void mergeSort(int[] vetor, int inicio, int fim) {
            if (inicio < fim) {
                int meio = (inicio + fim) / 2;
                mergeSort(vetor, inicio, meio);
                mergeSort(vetor, meio + 1, fim);
                merge(vetor, inicio, meio, fim);
            }
        }

        // combinar as duas metades ordenadas
        private void merge(int[] vetor, int inicio, int meio, int fim) {
            int[] esquerda = new int[meio - inicio + 1];
            int[] direita = new int[fim - meio];

            System.arraycopy(vetor, inicio, esquerda, 0, esquerda.length);
            System.arraycopy(vetor, meio + 1, direita, 0, direita.length);

            int i = 0, j = 0;

            int k = inicio;
            while (i < esquerda.length && j < direita.length) {
                comparacoes++;
                if (esquerda[i] <= direita[j]) {
                    vetor[k] = esquerda[i];
                    i++;
                } else {
                    vetor[k] = direita[j];
                    j++;
                    trocas++;
                }
                k++;
            }

            while (i < esquerda.length) {
                vetor[k] = esquerda[i];
                i++;
                k++;
            }

            while (j < direita.length) {
                vetor[k] = direita[j];
                j++;
                k++;
                trocas++;
            }
        }
    }
}
