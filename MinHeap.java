package trees;
import java.util.Arrays;

public class MinHeap {
	int capacity = 10;
	int size = 0;
	int[] heap = new int[capacity];
	
	public int getLeftChildIndex(int parentIndex){
		return 2*parentIndex+1;
	}
	
	public int getRightChildIndex(int parentIndex){
		return 2*parentIndex+2;
	}
	
	public int getParentIndex(int childIndex){
		return (childIndex-1)/2;
	}
	
	public boolean hasLeftChild(int parentIndex){
		return getLeftChildIndex(parentIndex)<size;
	}
	
	public boolean hasRightChild(int parentIndex){
		return getRightChildIndex(parentIndex)<size;
	}
	
	public boolean hasParent(int childIndex){
		return getParentIndex(childIndex)>0;
	}
	
	public int getLeft(int parent){return heap[getLeftChildIndex(parent)];}
	public int getRight(int parent){return heap[getRightChildIndex(parent)];}
	public int getParent(int child){return heap[getParentIndex(child)];}
	
	public void swap(int index1, int index2){
		if(index1<capacity&&index2<capacity){
			int temp = heap[index2];
			heap[index2] = heap[index1];
			heap[index1] = temp;
		}	
	}
	
	
	private void ensureHeapCapacity(){
		if(size==capacity){
			heap = Arrays.copyOf(heap, capacity*2);
			capacity *= 2;
		}
	}
	
	public int peek(){
		if(size==0) throw new IllegalStateException();
		
		return heap[0];
	}
	
	public int remove(){
		if(size==0) throw new IllegalStateException();
		int item = heap[0];
		heap[0] = heap[size-1];
		size--;
		heapifyDown();
		return item;
	}
	
	public void add(int val){
		ensureHeapCapacity();
		size++;
		heap[size-1] = val;
		heapifyUp(size-1);
	}
	
	public void heapifyUp(int index){
		while(hasParent(index) && getParent(index)>heap[index]){
			swap(index, getParentIndex(index));
			index = getParentIndex(index);
		}	
	}
	
	public void heapifyDown(){
		int index = 0;
		while(hasLeftChild(index)){
			int minChild = getLeftChildIndex(index);
			if(hasRightChild(index) && getRight(index)<getLeft(index)){
				minChild = getRightChildIndex(index);
			}
			if(heap[index]<heap[minChild]){
				break;
			}
			swap(index, minChild);
			index = minChild;
		}
	}
	
}
