package ru.crd.sort;

/**
 * Created by user on 14.01.2018.
 */
public class SortClass {
    private static int[] a = {5, 4, 8, 2, 6, 3};

    public static void main(String[] args) {
        Sort s = new QuickSortClass(a);
        s.sort();
        s.print();
    }
}

class BubbleSortClass implements Sort {

    private int[] a;

    public BubbleSortClass(int[] a) {
        this.a = a;
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

    @Override
    public void print() {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}

class SelectSortClass implements Sort {
    private int[] a;

    public SelectSortClass(int[] a) {
        this.a = a;
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

    @Override
    public void print() {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}

class InsertSortClass implements Sort {
    private int[] a;

    public InsertSortClass(int[] a) {
        this.a = a;
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

    @Override
    public void print() {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}

class ShellSortClass implements Sort {
    private int[] a;

    public ShellSortClass(int[] a) {
        this.a = a;
    }

    @Override
    public void sort() {
        int h = 1;
        while (h <= a.length / 3) h = h * 3 + 1;
        while (h > 0) {
            for (int i = h; i < a.length; i++) {
                for (int j = i; j >= h && a[j - h] > a[j]; j -= h) {
                    int t = a[j - h];
                    a[j - h] = a[j];
                    a[j] = t;
                }
                h /= 3;
            }
        }
    }

    @Override
    public void print() {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}

class QuickSortClass implements Sort {
    private int[] a;

    public QuickSortClass(int[] a) {
        this.a = a;
    }

    @Override
    public void sort() {
        innerSort(a,0,a.length-1);
    }

    private void innerSort(int[]a,int l, int r){
        int m = a[l+(r-l)/2];
        int i=l,j=r;
        while(i<=j){
            while(a[j]>m)j--;
            while (a[i]<m)i++;
            if(i<=j){
                int t=a[i];
                a[i]=a[j];
                a[j]=t;
                i++;
                j--;
            }
        }
        if(j>l)innerSort(a,l,j);
        if(i<r)innerSort(a,i,r);
    }

    @Override
    public void print() {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}