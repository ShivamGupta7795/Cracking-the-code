/*Implement a magic directory with buildDict, and search methods.

For the method buildDict, you'll be given a list of non-repetitive words to build a dictionary.

For the method search, you'll be given a word, and judge whether if you modify exactly one character into another character 
in this word, the modified word is in the dictionary you just built.

Example 1:
Input: buildDict(["hello", "leetcode"]), Output: Null
Input: search("hello"), Output: False
Input: search("hhllo"), Output: True
Input: search("hell"), Output: False
Input: search("leetcoded"), Output: False
 * 
 * */

package leetcode;
import java.util.*;
class MagicDictionary {

    /** Initialize your data structure here. */
    public ArrayList dictionary;
    public ArrayList originals;
    public MagicDictionary() {
        dictionary = new ArrayList();
        originals = new ArrayList();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for(String word:dict){
            dictionary.add(word);
        }
        // for(String word: dict){
        //     originals.add(word);
        //     char[] array = word.toCharArray();
        //     for(int i=0;i<word.length();i++){
        //         char temp = array[i];
        //         array[i] = '*';
        //         String mod_word = new String(array);
        //         dictionary.add(mod_word);
        //         array[i] = temp;
        //      }
        // }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        for(int i=0;i<dictionary.size();i++){
            String str = (String)dictionary.get(i);
            if(word.length()==str.length()){
                int check = 0;
                for(int j=0;j<word.length();j++){
                   if(word.charAt(j)!=str.charAt(j)){
                       check++;
                       if(check>1){
                           break;
                       }
                   }
                }
                if(check == 1){
                    return true;
                }
            }
        }
        return false;
        // if(originals.contains(word)){
        //     return false;
        // }
        // char[] array = word.toCharArray();
        // for(int i=0;i<array.length;i++){
        //     char temp = array[i];
        //     array[i] = '*';
        //     word = new String(array);
        //     if(dictionary.contains(word))
        //         return true;
        //     array[i] = temp;
        // }
        // return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */