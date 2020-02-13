/**
 * @author txg170003 & dxk180015
 *
 */

package ShortProject_3;

import java.util.Random;

public class MergeSortOptimization {
    public static Random random = new Random();
    public static int numTrials = 50;

    public static void main(String[] args) {
//        Integer n = 16777216;
//        Integer n = 33554432;
//        Integer n = 67108864;
        Integer n = 134217728;
//        int choice = 1 + random.nextInt(4);
        int choice = 3;

        if (args.length > 0) {
            n = Integer.parseInt(args[0]);
        }
        if (args.length > 1) {
            choice = Integer.parseInt(args[1]);
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        Timer timer = new Timer();
        switch (choice) {
            case 2:
                for (int i = 0; i < numTrials; i++) {
                    Shuffle.shuffle(arr);
                    mergeSort2(arr);
                }
                break;
            case 3:
                for (int i = 0; i < numTrials; i++) {
                    Shuffle.shuffle(arr);
                    mergeSort3(arr);
                }
                break;
            case 4:
                for (int i = 0; i < numTrials; i++) {
                    Shuffle.shuffle(arr);
                    mergeSort4(arr, 16);
                }
                break;
            case 6:
                for (int i = 0; i < numTrials; i++) {
                    try{
                        Shuffle.shuffle(arr);
                        mergeSort6(arr, 4);
                    }
                    catch (Exception e){
                        System.out.println("Size of Array should be in power of 2.");
                    }

                }
                break;
        }
        timer.end();
        timer.scale(numTrials);

        System.out.println("Choice: " + choice + "\n" + timer);

    }

    public static void insertionSort(int[] arr) {
        Integer size = arr.length;   // Size of the input array

        for(Integer i = 0; i < size; i++){
            int key = arr[i];
            Integer j = i - 1;

            while(j >= 0 && arr[j] > key) {
                //Loop Invariant: 0 <= j <= i <= size
                //LI: key || arr[i] < arr[j]
                //LI: key = arr[i]

                arr[j + 1] = arr[j];
                j--;
            }

            arr[j+1] = key;
        }

    }

    public static void insertionSort(int[] arr, Integer p, Integer r) {
        for (Integer i = p; i <= r; i++) {
            int key = arr[i];
            Integer j = i - 1;

            while (j >= p && arr[j] > key) {
                //Loop Invariant: p <= j <= i <= r
                //LI: key || arr[i] < arr[j]
                //LI: key = arr[i]
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }


    public static void mergeSort2(int[] arr) {
        int[] B = new int[arr.length];
        mergeSort2(arr, B, 0, arr.length-1);
    }

    public static void mergeSort2(int[] A, int[] B, Integer p, Integer r){
        Integer q;
        if(p < r){
            q = p + (r - p)/2;
            mergeSort2(A, B, p, q);
            mergeSort2(A, B, q+1, r);
            merge2(A, B, p, q, r);
        }
    }

    public static void merge2(int[] A, int[] B, Integer p, Integer q, Integer r) {
        System.arraycopy(A, p, B, p, r-p+1);
        Integer i = p, k = p, j = q+1;
        while(i <= q && j <= r){
            if(B[i] <= B[j])
                A[k++] = B[i++];
            else
                A[k++] = B[j++];
        }
        while(i <= q){
            A[k++] = B[i++];
        }
        while(j <= r){
            A[k++] = B[j++];
        }
    }

    public static void mergeSort3(int[] arr) {
        int[] B = new int[arr.length];
        System.arraycopy(arr, 0, B, 0, arr.length);
        mergeSort3(arr, B, 0, arr.length-1);
    }

    public static void mergeSort3(int[] A, int[] B, Integer p, Integer r){
        Integer q;
        if(p < r){
            q = p + (r - p)/2;
            mergeSort3(B, A, p, q);
            mergeSort3(B, A, q+1, r);
            merge3(A, B, p, q, r);
        }
    }

    public static void merge3(int[] A, int[] B, Integer p, Integer q, Integer r) {
        Integer i = p, k = p, j = q+1;
        while(i <= q && j <= r){
            if(B[i] <= B[j])
                A[k++] = B[i++];
            else
                A[k++] = B[j++];
        }
        while(i <= q){
            A[k++] = B[i++];
        }
        while(j <= r){
            A[k++] = B[j++];
        }
    }

    public static void mergeSort4(int[] arr, Integer T) {
        int[] B = new int[arr.length];
        System.arraycopy(arr, 0, B, 0, arr.length);
        mergeSort4(arr, B, 0, arr.length-1, T);
    }

    public static void mergeSort4(int[] A, int[] B, Integer p, Integer r, Integer T){
        if(r-p+1 < T){
            insertionSort(A, p, r);
        }
        Integer q;
        if(p < r){
            q = p + (r - p)/2;
            mergeSort4(B, A, p, q, T);
            mergeSort4(B, A, q+1, r, T);
            merge4(A, B, p, q, r);
        }
    }

    public static void merge4(int[] A, int[] B, Integer p, Integer q, Integer r) {
        Integer i = p, k = p, j = q+1;
        while(i <= q && j <= r){
            if(B[i] <= B[j])
                A[k++] = B[i++];
            else
                A[k++] = B[j++];
        }
        while(i <= q){
            A[k++] = B[i++];
        }
        while(j <= r){
            A[k++] = B[j++];
        }
    }

    public static void mergeSort6(int[] A, Integer T) {
        int[] B = new int[A.length];
//        System.arraycopy(arr, 0, B, 0, arr.length);

        Integer n = A.length;
        int[] inp = A;

        for(Integer j= 0; j < n; j = j + T){
            insertionSort(A, j, j + T - 1);
        }
        for(Integer i = T; i < n; i = 2*i){
            for(Integer j = 0; j < n; j = j+2*i){
                merge6(B, inp, j, j+i-1, j+2*i-1);
            }
            int [] t = inp;
            inp = B;
            B = t;
        }
        if(A != inp){
            System.arraycopy(inp, 0, A, 0, A.length);
        }
    }

    public static void merge6(int[] A, int[] B, Integer p, Integer q, Integer r) {
        Integer i = p, k = p, j = q+1;
        while(i <= q && j <= r){
            if(B[i] <= B[j])
                A[k++] = B[i++];
            else
                A[k++] = B[j++];
        }
        while(i <= q){
            A[k++] = B[i++];
        }
        while(j <= r){
            A[k++] = B[j++];
        }
    }

    /** Timer class for roughly calculating running time of programs
     *  @author rbk
     *  Usage:  Timer timer = new Timer();
     *          timer.start();
     *          timer.end();
     *          System.out.println(timer);  // output statistics
     */

    public static class Timer {
        long startTime, endTime, elapsedTime, memAvailable, memUsed;
        boolean ready;

        public Timer() {
            startTime = System.currentTimeMillis();
            ready = false;
        }

        public void start() {
            startTime = System.currentTimeMillis();
            ready = false;
        }

        public Timer end() {
            endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
            memAvailable = Runtime.getRuntime().totalMemory();
            memUsed = memAvailable - Runtime.getRuntime().freeMemory();
            ready = true;
            return this;
        }

        public long duration() {
            if (!ready) {
                end();
            }
            return elapsedTime;
        }

        public long memory() {
            if (!ready) {
                end();
            }
            return memUsed;
        }

        public void scale(int num) {
            elapsedTime /= num;
        }

        public String toString() {
            if (!ready) {
                end();
            }
            return "Time: " + elapsedTime + " msec.\n" + "Memory: " + (memUsed / 1048576) + " MB / " + (memAvailable / 1048576) + " MB.";
        }
    }

    /** @author rbk : based on algorithm described in a book
     */


    /* Shuffle the elements of an array arr[from..to] randomly */
    public static class Shuffle {

        public static void shuffle(int[] arr) {
            shuffle(arr, 0, arr.length - 1);
        }

        public static <T> void shuffle(T[] arr) {
            shuffle(arr, 0, arr.length - 1);
        }

        public static void shuffle(int[] arr, int from, int to) {
            int n = to - from + 1;
            for (int i = 1; i < n; i++) {
                int j = random.nextInt(i);
                swap(arr, i + from, j + from);
            }
        }

        public static <T> void shuffle(T[] arr, int from, int to) {
            int n = to - from + 1;
            Random random = new Random();
            for (int i = 1; i < n; i++) {
                int j = random.nextInt(i);
                swap(arr, i + from, j + from);
            }
        }

        static void swap(int[] arr, int x, int y) {
            int tmp = arr[x];
            arr[x] = arr[y];
            arr[y] = tmp;
        }

        static <T> void swap(T[] arr, int x, int y) {
            T tmp = arr[x];
            arr[x] = arr[y];
            arr[y] = tmp;
        }

        public static <T> void printArray(int[] arr, String message) {
            printArray(arr, 0, arr.length - 1, message);
        }

        public static <T> void printArray(int[] arr, int from, int to, String message) {
            System.out.print(message);
            for (int i = from; i <= to; i++) {
                System.out.print(" " + arr[i]);
            }
            System.out.println();
        }
    }
}

