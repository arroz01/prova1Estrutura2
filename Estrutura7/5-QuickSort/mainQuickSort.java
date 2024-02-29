import java.util.Random;

public class mainQuickSort {

    public static void quickSort(int[] array, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(array, begin, end);

            quickSort(array, begin, partitionIndex-1);
            quickSort(array, partitionIndex+1, end);
        }
    }

    private static int partition(int[] array, int begin, int end) {
        int pivot = array[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (array[j] <= pivot) {
                i++;

                int swapTemp = array[i];
                array[i] = array[j];
                array[j] = swapTemp;
            }
        }

        int swapTemp = array[i+1];
        array[i+1] = array[end];
        array[end] = swapTemp;

        return i+1;
    }

    public static void main(String[] args) {
        final int SIZE = 12999;
        int[] orderedArray = new int[SIZE];
        for (int i = 0; i < SIZE; i++) orderedArray[i] = i;

        int[] reversedArray = new int[SIZE];
        for (int i = 0; i < SIZE; i++) reversedArray[i] = SIZE - i - 1;

        int[] randomArray = new int[SIZE];
        Random rand = new Random();
        for (int i = 0; i < SIZE; i++) randomArray[i] = rand.nextInt(SIZE);

        // Ordenado
        long startTime = System.currentTimeMillis();
        quickSort(orderedArray, 0, orderedArray.length - 1);
        long endTime = System.currentTimeMillis();
        System.out.println("Vetor Ordenado - Tempo de execução: " + (endTime - startTime) + "ms");

        // Invertido
        startTime = System.currentTimeMillis();
        quickSort(reversedArray, 0, reversedArray.length - 1);
        endTime = System.currentTimeMillis();
        System.out.println("Vetor Invertido - Tempo de execução: " + (endTime - startTime) + "ms");

        // Aleatório
        startTime = System.currentTimeMillis();
        quickSort(randomArray, 0, randomArray.length - 1);
        endTime = System.currentTimeMillis();
        System.out.println("Vetor Aleatório - Tempo de execução: " + (endTime - startTime) + "ms");
    }
}
