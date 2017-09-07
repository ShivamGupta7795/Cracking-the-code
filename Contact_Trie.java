
public class Contact_Trie {
	public static void main(String[] ar){
		
	}
	
	public static class Node{
		int size = 0;
		private static int totalCharacters = 26;
		Node[] contacts = new Node[totalCharacters];
		
		public Node getNode(char ch){
			return contacts[ch-'a'];
		}
		
		public void setNode(char ch, Node node){
			node = contacts[ch-'a'];
		}
		
		/*add a string to trie*/
		public void addString(String str){
			addString(str, 0);
		}
		private void addString(String str, int index){
			
			if(index==str.length()){
				return;
			}else{
				size++;
				Node node= getNode(str.charAt(index));
				if(node==null){
					node = new Node();
					setNode(str.charAt(index),node);
				}
				addString(str,index+1);
			}
		}
		
		
		/*returns the number of strings formed with the SubString str*/
		public int getStringCount(String str, int index){
			if(index==str.length()){
				return size;
			}
				Node node = getNode(str.charAt(index));
				if(node==null){
					return 0;
				}else{
					return getStringCount(str, index+1);
				}
		}
		
		
		
	}
	
}
