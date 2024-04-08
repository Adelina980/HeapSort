import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HeapSort {

    private static int iterations = 0;

    public void heapSort(int[] arr) {
        int n = arr.length;

        // Построение кучи (Heap)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Извлечение элементов из кучи по одному
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    void heapify(int[] arr, int n, int i) {
        iterations++;
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:/Users/pro/IdeaProjects/HeapSort/src/InputData"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] strArr = line.split(" ");
                int[] arr = new int[strArr.length];
                for (int i = 0; i < strArr.length; i++) {
                    arr[i] = Integer.parseInt(strArr[i]);
                }

                HeapSort heapSort = new HeapSort();

                long startTime = System.nanoTime();
                heapSort.heapSort(arr);
                long endTime = System.nanoTime();

                System.out.print("Sorted array: ");
                int k = 0;
                for (int num : arr) {
                    System.out.print(num + " ");
                    k++;
                }
                System.out.println();

                System.out.println("Time taken: " + (endTime - startTime) + " nanoseconds");
                System.out.println("Number of iterations: " + iterations);
                System.out.println("Number of data: " + k);
                iterations = 0; // Сброс количества итераций для следующего набора данных
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
