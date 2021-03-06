package main;

public class Merge extends Sort {

    private static Comparable[] aux;

    private static void merge(Comparable[] a, int low, int mid, int high) {
        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++)
            aux[k] = a[k];
        for (int k = low; k <= high; k++) {
            if (i > mid){
                for(int t=k;t<=high;t++)
                    a[t]=aux[j++];
                return;
            }
            if(j > high) {
                for(int t=k;t<=high;t++)
                    a[t]=aux[i++];
                return;
            }
            if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int low, int high) {
        if (high <= low) return;
        int mid = (low + high) / 2;
        sort(a, low, mid);
        sort(a, mid + 1, high);
        merge(a, low, mid, high);
    }

}