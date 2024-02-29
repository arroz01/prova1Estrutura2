import java.util.Arrays;
public class main {

    public static long[] bubbleSort(int[] arr) {
        long startTime = System.currentTimeMillis();
        int n = arr.length;
        int temp = 0;
        long swaps = 0; // contar o número de trocas
        long comparisons = 0; // contar o número de comparações

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                comparisons++;
                if (arr[j - 1] > arr[j]) {
                    // Troca os elementos
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    swaps++;
                }
            }
        }
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime; // Tempo de execução em milissegundos
        return new long[]{comparisons, swaps, executionTime};
    }

    public static void main(String[] args) {

        int size = 999999; // nao foi possível por 1.000.000

        // Vetor já ordenado
        int[] ordered = new int[size];
        for (int i = 0; i < size; i++) {
            ordered[i] = i;
        }

        // Vetor invertido
        int[] reversed = new int[size];
        for (int i = 0; i < size; i++) {
            reversed[i] = size - i - 1;
        }

        // Vetor aleatório
        int[] random = new int[size];
        for (int i = 0; i < size; i++) {
            random[i] = (int) (Math.random() * size);
        }

        // Ordenação e Testes de Desempenho
        long[] metricsOrdered = bubbleSort(ordered);
        System.out.println("Vetor Ordenado: Comparisons: " + metricsOrdered[0] + ", Swaps: " + metricsOrdered[1] + ", Execution Time (ms): " + metricsOrdered[2]);

        long[] metricsReversed = bubbleSort(reversed);
        System.out.println("Vetor Invertido: Comparisons: " + metricsReversed[0] + ", Swaps: " + metricsReversed[1] + ", Execution Time (ms): " + metricsReversed[2]);

        long[] metricsRandom = bubbleSort(random);
        System.out.println("Vetor Aleatório: Comparisons: " + metricsRandom[0] + ", Swaps: " + metricsRandom[1] + ", Execution Time (ms): " + metricsRandom[2]);
    }
}
