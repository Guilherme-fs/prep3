/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prep3;

/**
 *
 * @author 
 */
public class BubbleSort extends Thread {
    private int[] array;
    
    public BubbleSort(int[] array) {
        this.array = array;
    }
    
    @Override
    public void run() {
        bubbleSort(array);
    }
    
    private void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
}
