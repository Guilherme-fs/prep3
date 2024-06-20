/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prep3;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author 
 */
public class Prep3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Enumciado:
        Pre P3 - Criar um projeto java que receba um vetor de n posicoes com 
        valores de 1 a 1000, aleatoriamente colocados e 2 threads facam a 
        ordenacao desse vetor. A primeira thread devera usar quick sort e a 
        segunda devera usar bubble sort . No final, devera sair a quantidade 
        de tempo que foi consumida por cada thread para executar a ordenacao. 
        As threads deverao ser inicializadas 3 vezes (Com vetor de 50 posicoes, 
        de 1000 posicoes e 10000 posicoes e apresentar o resultado)*/
        
        
        int[] vets = {50, 1000, 10000};
        
        for (int size : vets) {
            int[] array = new Random().ints(size, 1, 1001).toArray();
 
            int[] arrayQuickSort = Arrays.copyOf(array, array.length);
            int[] arrayBubbleSort = Arrays.copyOf(array, array.length);
            
            QuickSort quickSortThread = new QuickSort(arrayQuickSort);
            BubbleSort bubbleSortThread = new BubbleSort(arrayBubbleSort);
            
            long inicioQuickSort = System.nanoTime();
            quickSortThread.start();
            try {
                quickSortThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long fimQuickSort = System.nanoTime();
            
            long inicioBubbleSort = System.nanoTime();
            bubbleSortThread.start();
            try {
                bubbleSortThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long fimBubbleSort = System.nanoTime();
            
            System.out.println("Tamanho da Array: " + size);
            System.out.println("tempo com o QuickSort: " + (fimQuickSort - inicioQuickSort ) + " ns");
            System.out.println("tempo com o BubbleSort: " + (fimBubbleSort - inicioBubbleSort) + " ns");
            System.out.println();
        }
            
            
        
    }
    
}
