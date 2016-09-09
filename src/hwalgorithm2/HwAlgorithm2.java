/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hwalgorithm2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Yo
 */
public class HwAlgorithm2 {

    /**
     * @param args the command line arguments
     */
    static float RanNum(){
        Random ran = new Random();
        return ran.nextFloat(); 
    }
    static float[] CreateNum(int N){
         float[] myList = new float[N];
        
        for(int i=0;i<N;i++){
            float rN = RanNum();
            myList[i] = rN;
            //myList.add(rN);
        }
        
        return myList;        
    }
     public static float[] QSort(float[] array)
    {
        QSort(array, 0, array.length - 1);
        return array;
    }

    public static void QSort(float[] array, int left, int right)
    {
        if (right <= left)
            return;

        // random pivot
        //int pivotIndex = left + random.nextInt(right - left + 1);

        // middle pivot
        int pivotIndex = (left + right) / 2;
        float pivot = array[pivotIndex];
        Swap(array, pivotIndex, right);
        int swapIndex = left;
        for (int i = left; i < right; ++i)
        {
            if (array[i] <= pivot)
            {
                Swap(array, i, swapIndex);
                ++swapIndex;
            }
        }
        Swap(array, swapIndex, right);

        QSort(array, left, swapIndex - 1);
        QSort(array, swapIndex + 1, right);
    }
    public static float[] RP(float[] array,int k)
    {
        RP(array, 0, array.length - 1,k);
        return array;
    }
    public static int RP(float[] array, int left, int right,int k)
    {
        if (right <= left)
            return 0;
        int pivotIndex = (left + right) / 2;
        float pivot = array[pivotIndex];
        Swap(array, pivotIndex, right);
        int swapIndex = left;
        for (int i = left; i < right; ++i)
        {
            if (array[i] <= pivot)
            {
                Swap(array, i, swapIndex);
                ++swapIndex;
            }
        }
        Swap(array, swapIndex, right);
        if(swapIndex == k )
        {
            System.out.println(k);
            return k;
        }
        RP(array, left, swapIndex - 1,k);
        RP(array, swapIndex + 1, right,k);
        return k;
    }
    private static void Swap(float[] array, int indexA, int indexB)
    {
        float tmp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = tmp;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("Enter N to generate numbers:");
        Scanner sc = new Scanner(System.in);
        int enternum = sc.nextInt();
        float[] cnList = CreateNum(enternum);
        for (int i = 0; i < enternum; i++) {
            System.out.print(cnList[i] + "\t");
        }
        System.out.println("");
        System.out.println("Sorted by QuickSort:"); 
        long startTime = System.currentTimeMillis();
        float[] newarray = new float[enternum];
        System.arraycopy(cnList, 0, newarray, 0, enternum);
        float[] qarray = QSort(newarray);
        long endTime = System.currentTimeMillis();
        for (int i = 0; i < enternum; i++) {
            System.out.print(qarray[i] + "\t");
        }
        long totTime = endTime - startTime;
        System.out.println("");
        System.out.println("Using Time:" + totTime + "  millisecond");
        
        System.out.println("");
        System.out.println("use recursive randomized partitioning algorithm");
        long startTime1 = System.currentTimeMillis();
        Random rank = new Random();
        int k = rank.nextInt(enternum)+1;
        //Scanner ksc = new Scanner(System.in);
        //int k = sc.nextInt();
        float[] RParray = new float[enternum];
        System.arraycopy(cnList, 0, RParray, 0, enternum);
        float[] RParrayRE = RP(RParray,k-1);
       long endTime2 = System.currentTimeMillis();
        for (int i = 0; i < k; i++) {
            System.out.print(RParrayRE[i] + "\t");
        }
        long totTime2 = endTime2 - startTime1;
        System.out.println("");
        System.out.println("Using Time:" + totTime2 + "  millisecond");
        System.out.println("kth is " + k );
        System.out.println(RParrayRE[k-1]);
         
    }
}
