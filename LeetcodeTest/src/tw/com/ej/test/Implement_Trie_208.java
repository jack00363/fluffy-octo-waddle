package tw.com.ej.test;

import java.util.HashSet;
import java.util.Set;

public class Implement_Trie_208 {
	class Trie_EJ {
	     Set<String> data;

	    public Trie_EJ() {
	        data= new HashSet<String>();
	    }
	    
	    public void insert(String word) {
	        data.add(word);
	    }
	    
	    public boolean search(String word) {
	        return data.contains(word);
	    }
	    
	    public boolean startsWith(String prefix) {
	        for(String s :data)
	            if(s.indexOf(prefix)==0) return true;
	        return false;
	    }
	}
	
	class Trie {
		//類似treeNode 自己可看的見下一個字元
	    
	    private Trie[] children;
	    private boolean isWord;

	    public Trie() {
	        children = new Trie[26];
	    }
	    
	    public void insert(String word) {
	        Trie t = iterateString(word, true);
	        t.isWord = true;
	    }
	    
	    public boolean search(String word) {
	        Trie t = iterateString(word, false);
	        return t != null && t.isWord;
	    }
	    
	    public boolean startsWith(String prefix) {
	        return iterateString(prefix, false) != null;
	    }
	    
	    private Trie iterateString(String s, boolean createIfNull) {
	        Trie cur = this;
	        for (char c : s.toCharArray()) {
	            if (cur.children[c-'a'] == null) {
	                if (createIfNull) {
	                    cur.children[c-'a'] = new Trie();
	                } else {
	                    return null;
	                }
	            }
	            cur = cur.children[c-'a'];
	        }
	        return cur;
	    }
	}
}
