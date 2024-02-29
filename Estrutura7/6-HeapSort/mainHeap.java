import java.util.Random;

public class mainHeap {
    public static void sort(int arr[]) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    static void heapify(int arr[], int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }

        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        int size = 1000000; // Tamanho dos vetores
        Random rand = new Random();

        // Geração dos vetores de teste
        int[] orderedArray = new int[size];
        int[] reversedArray = new int[size];
        int[] randomArray = new int[size];
        
        for (int i = 0; i < size; i++) {
            orderedArray[i] = i;
            reversedArray[i] = size - i - 1;
            randomArray[i] = rand.nextInt(size);
        }

        // Teste de desempenho
        testPerformance("Vetor Ordenado", orderedArray);
        testPerformance("Vetor Invertido", reversedArray);
        testPerformance("Vetor Aleatório", randomArray);
    }

    private static void testPerformance(String description, int[] array) {
        long startTime = System.nanoTime();
        sort(array);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000; // Convertendo para milissegundos
        
        System.out.println(description + " - Tempo de execução: " + duration + " ms");
    }
}
