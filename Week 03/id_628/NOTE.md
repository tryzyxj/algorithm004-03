# �������ܽ�

## ������֪ʶ�㡿

1������--������ȣ��������

2��̰��-�ֲ����Ž���ȫ�����Ž�

3�����ֲ���-ţ�� ������

## ������ѧϰ�ܽ᡿

������ģ�塿

1��DFS

�ݹ�ģ��

```python
visited = set() 

def dfs(node, visited):
if node in visited: # terminator
	# already visited 
	return 

	visited.add(node) 

	# process current node here. 
	...
	for next_node in node.children(): 
		if not next_node in visited: 
			dfs(next_node, visited)
```

�ǵݹ�ģ��

```python
def DFS(self, tree): 

	if tree.root is None: 
		return [] 

	visited, stack = [], [tree.root]

	while stack: 
		node = stack.pop() 
		visited.add(node)

		process (node) 
		nodes = generate_related_nodes(node) 
		stack.push(nodes) 

	# other processing work 
	...
```



```java
//�����ݽṹ�㷨֮����
boolean found = false; // ȫ�ֱ����������Ա����

public void dfs(int s, int t) {
  found = false;
  boolean[] visited = new boolean[v];
  int[] prev = new int[v];
  for (int i = 0; i < v; ++i) {
    prev[i] = -1;
  }
  recurDfs(s, t, visited, prev);
  print(prev, s, t);
}

private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
  if (found == true) return;
  visited[w] = true;
  if (w == t) {
    found = true;
    return;
  }
  for (int i = 0; i < adj[w].size(); ++i) {
    int q = adj[w].get(i);
    if (!visited[q]) {
      prev[q] = w;
      recurDfs(q, t, visited, prev);
    }
  }
}
```

2��BFS

```python
def BFS(graph, start, end):

	queue = [] 
	queue.append([start]) 
	visited.add(start)

	while queue: 
		node = queue.pop() 
		visited.add(node)

		process(node) 
		nodes = generate_related_nodes(node) 
		queue.push(nodes)

	# other processing work 
	...
```



```java
//�����ݽṹ�㷨֮����

public void bfs(int s, int t) {
  if (s == t) return;
  boolean[] visited = new boolean[v];
  visited[s]=true;
  Queue<Integer> queue = new LinkedList<>();
  queue.add(s);
  int[] prev = new int[v];
  for (int i = 0; i < v; ++i) {
    prev[i] = -1;
  }
  while (queue.size() != 0) {
    int w = queue.poll();
   for (int i = 0; i < adj[w].size(); ++i) {
      int q = adj[w].get(i);
      if (!visited[q]) {
        prev[q] = w;
        if (q == t) {
          print(prev, s, t);
          return;
        }
        visited[q] = true;
        queue.add(q);
      }
    }
  }
}

private void print(int[] prev, int s, int t) { // �ݹ��ӡs->t��·��
  if (prev[t] != -1 && t != s) {
    print(prev, s, prev[t]);
  }
  System.out.print(t + " ");
}
```

3������

```python
//ģ��
left, right = 0, len(array) - 1 
while left <= right: 
	  mid = (left + right) / 2 
	  if array[mid] == target: 
		    # find the target!! 
		    break or return result 
	  elif array[mid] < target: 
		    left = mid + 1 
	  else: 
		    right = mid - 1
```



```java
//�����ݽṹ�㷨֮����
// ���ֲ��ҵĵݹ�ʵ��
public int bsearch(int[] a, int n, int val) {
  return bsearchInternally(a, 0, n - 1, val);
}

private int bsearchInternally(int[] a, int low, int high, int value) {
  if (low > high) return -1;

  int mid =  low + ((high - low) >> 1);
  if (a[mid] == value) {
    return mid;
  } else if (a[mid] < value) {
    return bsearchInternally(a, mid+1, high, value);
  } else {
    return bsearchInternally(a, low, mid-1, value);
  }
}
```



## �������Ž��ջ�

1������ʽ��Ŀ�������̷�ʽ���н�ά����ķ�����

2�������ݽṹ���㷨ӳ�䵽���������ԭ����ջ�

## ��ѧϰ�ܽ���ҵ�⡿

> �κ���ҵ��Ŀ
>
> ʹ�ö��ֲ��ң�Ѱ��һ������������ [4, 5, 6, 7, 0, 1, 2] �м�����ĵط� 

ԭ��

����м������ת����ߣ���һ���������һ���㡣

����м������ת���ұߣ���һ��С�����һ���㡣

����ʹ��������ʿ��Խ��ж��ֲ���

����

����м��midֵС���ұ߽�ֵ����˵����ת�����м��mid��ߣ���������߽���м��俪ʼ��һ�ζ��֡�

����м��midֵ�����ұ߽�ֵ����˵����ת�����м��mid�ұߣ��������м����ұ߽�俪ʼ��һ�ζ��֡�



���룺

```java
public int search(int[] nums) {

    int left = 0;
    int right = nums.length - 1;

    while (left < right) {
        int mid = left + ((right - left) >> 1);

        if (nums[mid] < nums[right])
            right = mid;
        else
            left = mid + 1;
    }
    return nums[left];
}
```

