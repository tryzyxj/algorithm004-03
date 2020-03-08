# �������ܽ�

## ������֪ʶ�㡿

1���ֵ���

2�����鼯

3���߼�����-��֦

4���߼�����-˫��bfs

5���߼�����-����ʽ������A*��

6��AVL��������

## ������ѧϰ�ܽ᡿

������ģ�塿

�ֵ���

```java
class TrieNode {
    public char val;
    public boolean isWord; 
    public TrieNode[] children = new TrieNode[26];
    public TrieNode() {}
    TrieNode(char c){
        TrieNode node = new TrieNode();
        node.val = c;
    }
}

public class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
        root.val = ' ';
    }

    public void insert(String word) {
        TrieNode ws = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(ws.children[c - 'a'] == null){
                ws.children[c - 'a'] = new TrieNode(c);
            }
            ws = ws.children[c - 'a'];
        }
        ws.isWord = true;
    }

    public boolean search(String word) {
        TrieNode ws = root; 
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(ws.children[c - 'a'] == null) return false;
            ws = ws.children[c - 'a'];
        }
        return ws.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode ws = root; 
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(ws.children[c - 'a'] == null) return false;
            ws = ws.children[c - 'a'];
        }
        return true;
    }
}
```

���鼯

```java
class UnionFind { 
	private int count = 0; 
	private int[] parent; 
	public UnionFind(int n) { 
		count = n; 
		parent = new int[n]; 
		for (int i = 0; i < n; i++) { 
			parent[i] = i;
		}
	} 
	public int find(int p) { 
		while (p != parent[p]) { 
			parent[p] = parent[parent[p]]; 
			p = parent[p]; 
		}
		return p; 
	}
	public void union(int p, int q) { 
		int rootP = find(p); 
		int rootQ = find(q); 
		if (rootP == rootQ) return; 
		parent[rootP] = rootQ; 
		count--;
	}
}
```

˫��BFS

```java
public void bfs(String start, String end) {
		Set<String> s1 = new HashSet<String>();
		Set<String> s2 = new HashSet<String>();
		s1.add(start);
		s2.add(end);
		Set<String> temp = new HashSet<String>();
		while (!s1.isEmpty() && !s2.isEmpty()) {
			for (String word : s1) {
				if (s2.contains(word)) {
                    //TODO
                    process(word);
					temp.add(word);
				}
			}
			s1 = temp;
			if (s1.size() > s2.size()) {
				Set tmp = s1;
				s1 = s2;
				s2 = tmp;
			}
		}
	}
```

