package leetcode;
import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;
public class leftShiftArray {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        new leftShiftArray().leftShift(n, k,a );
    }
    
    public void leftShift(int size, int shift, int[] array){
        Queue<Integer> queue = new LinkedList<Integer>();
        int j=0;
        shift = shift%size;
        for(int i=0;i<size;i++){
            if(i<shift){
                queue.add(array[i]);
            }else{
                new leftShiftArray().swap(j,i,array);
                j++;
            }
        }
        for(int i=j;i<size;i++){
            array[i] = queue.poll();
        }
        
        for(int i=0;i<size;i++){
            System.out.print(array[i]+" ");
        }
        
    }
    public void swap(int i, int j, int[] array){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
