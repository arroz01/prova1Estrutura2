import java.util.Random;

public class main {

    public static void sort(int[] array) {
        int n = array.length;
        int totalComparacoes = 0;
        int totalTrocas = 0;
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                totalComparacoes++;
                if (array[j] < array[minIdx]) {
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                // Troca
                int temp = array[minIdx];
                array[minIdx] = array[i];
                array[i] = temp;
                totalTrocas++;
            }
        }

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        System.out.println("Número de comparações: " + totalComparacoes);
        System.out.println("Número de trocas: " + totalTrocas);
        System.out.println("Tempo de execução (ms): " + totalTime);
    }

    public static void main(String[] args) {
        int size = 1000000; // Tamanho do vetor
        int[] vetorOrdenado = new int[size];
        int[] vetorInvertido = new int[size];
        int[] vetorAleatorio = new int[size];

        // vetor ordenado
        for (int i = 0; i < size; i++) {
            vetorOrdenado[i] = i;
        }

        // vetor invertido
        for (int i = 0; i < size; i++) {
            vetorInvertido[i] = size - i - 1;
        }

        // vetor aleatório
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            vetorAleatorio[i] = random.nextInt(size);
        }

        // Testando o Selection Sort com o vetor ordenado
        System.out.println("Ordenando vetor ordenado...");
        sort(vetorOrdenado);

        // Testando o Selection Sort com o vetor invertido
        System.out.println("Ordenando vetor invertido...");
        sort(vetorInvertido);

        // Testando o Selection Sort com o vetor aleatório
        System.out.println("Ordenando vetor aleatório...");
        sort(vetorAleatorio);
    }
}
