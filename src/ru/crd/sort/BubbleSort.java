package ru.crd.sort;

/**
 * Created by user on 14.01.2018.
 */
public class BubbleSort {
    private static int[] a={5,4,3,2,9};
    public static void main(String[] args) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if(a[j]>a[i]){
                    int t=a[i];
                    a[i]=a[j];
                    a[j]=t;
                }
            }
        }

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
