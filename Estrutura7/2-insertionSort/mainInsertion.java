public class mainInsertion {

    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            // Move os elementos de array, que são  maiores que a chave, para uma posição à frente da sua posição atual
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    // imprimir os elementos do vetor
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // testar a ordenação
    public static void main(String[] args) {
        // Definindo e preenchendo os vetores
        int size = 1000000; // 1 milhão
        int[] sortedArray = new int[size];
        int[] reversedArray = new int[size];
        int[] randomArray = new int[size];

        for (int i = 0; i < size; i++) {
            sortedArray[i] = i;
            reversedArray[i] = size - i;
            randomArray[i] = (int) (Math.random() * size);
        }

        // vetor já ordenado
        long startTime = System.currentTimeMillis();
        sort(sortedArray);
        long endTime = System.currentTimeMillis();
        System.out.println("Tempo de execução para o vetor ordenado: " + (endTime - startTime) + "ms");

        //  vetor invertido
        startTime = System.currentTimeMillis();
        sort(reversedArray);
        endTime = System.currentTimeMillis();
        System.out.println("Tempo de execução para o vetor invertido: " + (endTime - startTime) + "ms");

        // vetor aleatório
        startTime = System.currentTimeMillis();
        sort(randomArray);
        endTime = System.currentTimeMillis();
        System.out.println("Tempo de execução para o vetor aleatório: " + (endTime - startTime) + "ms");
    }
}
