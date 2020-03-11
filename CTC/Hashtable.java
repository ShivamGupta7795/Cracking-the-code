package CTC;
import java.util.ArrayList;

public class Hashtable<K,V> {
	K key;
	V val;
	Hashtable<K,V> next;
	
	public Hashtable(K key, V val){
		this.key = key;
		this.val = val;
	}
}

class Map<K,V>{
	ArrayList<Hashtable<K,V>> bucketList;
	int size;
	int numBuckets;
	public Map(int size, int numBuckets){
		bucketList = new ArrayList<Hashtable<K,V>>();
		this.size= size;
		this.numBuckets = numBuckets;
		for(int i=0;i<numBuckets;i++){
			bucketList.add(null);
		}
	}
	
	public int getindex(K key){
		int hashcode= key.hashCode();
		int index= hashcode%numBuckets;
		return index;
	}
	
	public V getVal(K key){
		int index = getindex(key);
		Hashtable<K,V> node = bucketList.get(index);
		while(node!=null){
			if(node.key==key){
				return node.val;
			}
			node = node.next;
		}
		return null;
	}
	
	
	public void addNode(K key, V val){
		int index = getindex(key);
		Hashtable<K,V> head  = bucketList.get(index);
		/*check if key is already present*/
		while(head!=null){
			if(head.key.equals(key)){
				head.val = val;
				return;
			}
			head = head.next;
		}
		/*add new key, val pair*/
		size++;
		Hashtable<K,V> node = new Hashtable<K,V>(key,val);
		head = bucketList.get(index);
		node.next = head;
		bucketList.set(index, node);
		/*check if buckets are overloaded, if so double the size of list*/
		if((size/numBuckets)>0.7){
			int prevsize = numBuckets;
			numBuckets *= 2;
			size = 0;
			for(int i=prevsize;i<numBuckets;i++){
				bucketList.set(i,null);
			}
		}
	}
	
	public Hashtable<K,V> removenode(K key){
		int index = getindex(key);
		Hashtable<K,V> head = bucketList.get(index);
		Hashtable<K,V> prev = null;
		while(head!=null){
			if(head.key.equals(key)){
				size--;
				if(prev!=null){
					prev.next =head.next;
				}else{
					bucketList.set(index, head.next);
				}
				return head;
			}
			prev = head;
			head = head.next;
		}
		return null;
	}
}