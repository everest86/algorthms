package ru.crd.sort;

import java.util.Arrays;

/**
 * Created by user on 14.01.2018.
 */
public class SortClass {
    private static int[] a = {5, 4, 8, 2, 6, 3};

    public static void main(String[] args) {
        Sort s = new HeapSort(a);
        s.sort();
        s.print();
    }
}

abstract class AbstractSort implements Sort {
    protected int[] a;

    @Override
    public void print() {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}

class BubbleSortClass extends AbstractSort {

    public BubbleSortClass(int[] a) {
        super.a = a;
    }

    @Override
    public void sort() {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[j] > a[i]) {
                    int t = a[i];
                    a[i] = a[j];
                    a[j] = t;
                }
            }
        }
    }
}

class SelectSortClass extends AbstractSort {
    public SelectSortClass(int[] a) {
        super.a = a;
    }

    @Override
    public void sort() {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int t = a[min];
                a[min] = a[i];
                a[i] = t;
            }
        }
    }
}

class InsertSortClass extends AbstractSort {
    public InsertSortClass(int[] a) {
        super.a = a;
    }

    @Override
    public void sort() {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0 && a[j - 1] > a[j]; j--) {
                int t = a[j - 1];
                a[j - 1] = a[j];
                a[j] = t;
            }
        }
    }
}

class ShellSortClass extends AbstractSort {

    public ShellSortClass(int[] a) {
        super.a = a;
    }

    @Override
    public void sort() {
        int N = a.length;
        int k = 3;
        int h = 1;
        while (h <= N / k) h = h * k + 1;
        while (h > 0) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && a[j - h] > a[j]; j -= h) {
                    int t = a[j - h];
                    a[j - h] = a[j];
                    a[j] = t;
                }
            }
            h /= k;
        }
    }
}

class QuickSortClass extends AbstractSort {
    public QuickSortClass(int[] a) {
        super.a = a;
    }

    @Override
    public void sort() {
        innerSort(a, 0, a.length - 1);
    }

    private void innerSort(int[] a, int l, int r) {
        int m = a[l + (r - l) / 2];
        int i = l, j = r;
        while (i <= j) {
            while (a[j] > m) j--;
            while (a[i] < m) i++;
            if (i <= j) {
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
                i++;
                j--;
            }
        }
        if (j > l) innerSort(a, l, j);
        if (i < r) innerSort(a, i, r);
    }
}

class MergeSort extends AbstractSort{
    public MergeSort(int[] a) {
        super.a = a;
    }

    @Override
    public void sort() {
        innerSort(a,0,a.length-1);
    }

    private void innerSort(int[]a, int lo, int hi){
        if(lo>=hi)return;
        int mid=lo+(hi-lo)/2;

        innerSort(a,lo,mid);
        innerSort(a,mid+1,hi);

        int[]buf= Arrays.copyOf(a,a.length);

        int i=lo, j=mid+1;
        for (int k = lo; k <= hi ; k++) {
            if(i>mid)a[k]=buf[j++];
            else if(j>hi)a[k]=buf[i++];
            else if(a[j]>a[i])a[k]=buf[i++];
            else a[k]=buf[j++];
        }
    }
}

class HeapSort extends AbstractSort {

    private int heapSize;

    private int left(int index) {
        return 2*index+2;
    }
    private int right(int index) {
        return 2*index+1;
    }

    private void swap(int[]a,int i,int j){
        int t=a[i];
        a[i]=a[j];
        a[j]=t;
    }

    public HeapSort(int[] a) {
        super.a = a;
    }

    @Override
    public void sort() {
        buildHeap(a);
        while (heapSize>1){
            swap(a,0,heapSize-1);
            --heapSize;
            heapify(a,0);
        }
    }

    private void heapify(int[]a,int i){
        int l=left(i);
        int r=right(i);
        int greater=i;
        if(l<heapSize && a[l]>a[i]){
            greater=l;
        }
        if(r<heapSize && a[r]>a[greater]){
            greater=r;
        }
        if(i!=greater){
            swap(a,i,greater);
            heapify(a,greater);
        }
    }

    private void buildHeap(int[]a){
        heapSize=a.length;
        for (int i = 0; i < heapSize/2; i++) {
            heapify(a,i);
        }
    }
}