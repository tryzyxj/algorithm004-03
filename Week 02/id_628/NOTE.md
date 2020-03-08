# NOTE
# ���ڶ���ѧϰ�ܽ᡿

## ������֪ʶ�㡿

���ܽ�����5-8�ڵ�ѧϰ�������ݽṹת�뵽���µ��㷨ѧϰ����Ҫѧϰ�����µ�֪ʶ�㡣

- ��ϣ�����ϵ�ʵ��ԭ�����������Ŀ���н���

- �������ĸ�������˶����������������Ƚṹ��������ʵս
- �����˵ݹ�ģ�壬��ݹ�Ļ�������˼·���Լ��ݹ��ϼ�֦���Ż�
- �ӵݹ�������Ρ����ݵ��㷨˼ά�������˶���������Ŀ

## ������ѧϰ�ܽ᡿

### ���ݹ�ģ�塿

д�ݹ������Ҫ��ȷ����ֹ�����Լ�ÿһ��������ĺ��壬ͬʱ���Ի�ѧ���û��ģ�壬ģ�����͵�˼ά�޽�����������ʦ���ĵݹ�ģ��

```java
public void recur(int level, int param) { 

  // terminator -- �ݹ���ֹ����
  if (level > MAX_LEVEL) { 
    // process result 
    return; 
  } 

  // process current logic -- ����ǰ���ҵ���߼�
  process(level, param); 

  // drill down 	-- ������һ��
  recur( level: level + 1, newParam); 

  // restore current status --���ʹ����ȫ�ֱ����򹫹���������Ҫ������ʹ�úۼ�������Ӱ�������㡣
 
}
```

������ģ�塿

���ε�˼������Դ�С��Ѱ���ظ���Ԫ��֮��ַֺϺ�ȥ���м��㡣

```python
def divide_conquer(problem, param1, param2, ...): 
  # recursion terminator -- ��ֹ����
  if problem is None: 
	print_result 
	return 

  # prepare data -- Ԥ�������ݣ��ֽ�������
  data = prepare_data(problem) 
  subproblems = split_problem(problem, data) 

  # conquer subproblems -- �ֿ����ÿһ��������
  subresult1 = self.divide_conquer(subproblems[0], p1, ...) 
  subresult2 = self.divide_conquer(subproblems[1], p1, ...) 
  subresult3 = self.divide_conquer(subproblems[2], p1, ...) 
  ��

  # process and generate the final result -- �ϲ�������������
  result = process_result(subresult1, subresult2, subresult3, ��)
	
  # revert the current level states
```




# ��Դ���ܽ᡿�ڶ���-map��jdk1.8�汾��

���˽�hashmap����Ҫ���˽�java�е�hash�����Զ����µ��˽�map������ݽṹ��

## ��1��Object  ���ж������ʦү

java�����ж����Ǵ�Object���ģ���涨������������һ����hashCode�Ǽ�������ַ��hashֵ��һ����equals�������ǱȽ϶����Ƿ���ȣ����������==���Ƚϵ�����ʵ��������JVM���з����ڴ�ĵ�ַ�Ƿ���ͬ��

```java
//����
public native int hashCode();
//�Ƚ��ڴ��ַ�Ƿ�һ��
public boolean equals(Object obj) {
	return (this == obj);	
}

```

## ��2��String �����Ӱ��ŵ�������

����Object��equals�Ƚϵ����ڴ��ַ��������String�Ļ�������������д��equals��hashcode�������������¡�equals��Ҫ�����Ƚ��ڲ��ַ��Ƿ�ÿһ������ͬ����hashcode���Ǹ�ÿ���ַ����hash�����ܺͣ������ͻ����hashcode��ͬ��equals��ͬ�ĳ�����

ps��hashcode��������еĳ���31��ѡ��Ҳ����һ�����ݵģ�����Ȥ�ɲο���[�������](https://www.cnblogs.com/nullllun/archive/2018/01/25/8350178.html)��

```java
//String��д���hashCode----��ϣ��ʵ�ʹ���
public int hashCode() {
    int h = hash;
    if (h == 0 && value.length > 0) {
        char val[] = value;
       	//�ܼ���ʽ��s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]
        for (int i = 0; i < value.length; i++) {
            //��ѡ31��ԭ��
            //		1����������ͻ�ֲ���Ծ���
            //		2.JVM���Ż�  31 * i = (i << 5) - i
            h = 31 * h + val[i];
        }
        hash = h;
    }
    return h;
}
//String��д���equals
public boolean equals(Object anObject) {
    if (this == anObject) {
        return true;
    }
    if (anObject instanceof String) {
        String anotherString = (String)anObject;
        int n = value.length;
        //���жϳ����Ƿ�һ��
        if (n == anotherString.value.length) {
            char v1[] = value;
            char v2[] = anotherString.value;
            int i = 0;
            //����ַ��ж��Ƿ����
            while (n-- != 0) {
                if (v1[i] != v2[i])
                    return false;
                i++;
            }
            return true;
        }
    }
    return false;
}
```

## ��3��Map  ���й�ϣ����游

java�ж�����Map����ӿڣ�����Ҫ������ӳ���Ĺ��������������������кܶ�����ʵ���ڣ���ӳ�����ϵ�е��游���ӿڣ����ķ������£�

```java
 	//��ǰӳ���ʵ�ʴ��Ԫ�ض���
	int size();
	//��ǰ������Ƿ��ǿյ�
    boolean isEmpty();
	//��ǰӳ������Ƿ����key
    boolean containsKey(Object key);
	//��ǰӳ������Ƿ����value
    boolean containsValue(Object value);
	//��ȡ��ֵΪkey��Ӧ��value
    V get(Object key);
	//�����Ϊkey��ֵΪvalue�ļ�ֵ��
    V put(K key, V value);
	//ɾ����Ϊkey�ļ�ֵ��
    V remove(Object key);
	//����һ��mapȫ�����뵱ǰmap
    void putAll(Map<? extends K, ? extends V> m);
	//����ǰmap��Ԫ��
    void clear();
	//��ȡ��ǰmap�����е�key����
    Set<K> keySet();
	//��ȡ��ǰmap�����е�values����
    Collection<V> values();
```

���˺��ķ����⣬�����������ڲ���entry�Ľṹ�ͷ�����entry��Ϊ��ֵ�Ե������������������ķ�ʽ�����map�У���������

```java
 
interface Entry<K,V> {
    
    //��ȡ��ǰentry�ڵ��key
    K getKey();
    //��ȡ��ǰentry�ڵ��value
    V getValue();
    //���õ�ǰ�ڵ��value
    V setValue(V value);
    //�жϵ�ǰ�ڵ���o�Ƿ���ͬ     
    boolean equals(Object o);
    //���㵱ǰ�ڵ��hashֵ
    int hashCode();
    
    //���һ��ͨ��key�ȽϵıȽ���
     public static <K extends Comparable<? super K>, V> Comparator<Map.Entry<K,V>> comparingByKey() {
         return (Comparator<Map.Entry<K, V>> & Serializable)
             (c1, c2) -> c1.getKey().compareTo(c2.getKey());
     }
	//��ȡһ��ͨ��value�ȽϵıȽ���
    public static <K, V extends Comparable<? super V>> Comparator<Map.Entry<K,V>> comparingByValue() {
         return (Comparator<Map.Entry<K, V>> & Serializable)
             (c1, c2) -> c1.getValue().compareTo(c2.getValue());
     }

    //��ȡһ��ͨ��key�ȽϵıȽ���
    public static <K, V> Comparator<Map.Entry<K, V>> comparingByKey(Comparator<? super K> cmp) {
         Objects.requireNonNull(cmp);
         return (Comparator<Map.Entry<K, V>> & Serializable)
             (c1, c2) -> cmp.compare(c1.getKey(), c2.getKey());
     }

     //��ȡһ��ͨ��value�ȽϵıȽ���
     public static <K, V> Comparator<Map.Entry<K, V>> comparingByValue(Comparator<? super V> cmp) {
         Objects.requireNonNull(cmp);
         return (Comparator<Map.Entry<K, V>> & Serializable)
             (c1, c2) -> cmp.compare(c1.getValue(), c2.getValue());
     }
 }
```



## ��4��AbstractMap  Map������������

��map������еĹ������࣬���Ǽ����峤���ʵ������ͨ���Լ�����ĳ��󷽷�entrySet������ʵ���˴����map�ж���Ľӿڷ���������������󷽷���map�ж�����ڲ�������������ʵ��������ʵ�����ȥʵ�֡�

```java
//�Զ���ĳ��󷽷�
public abstract Set<Entry<K,V>> entrySet();
//����entrySet������ͨ����������ʵ��ͨ��get����
public V get(Object key) {
     Iterator<Entry<K,V>> i = entrySet().iterator();
     if (key==null) {
         while (i.hasNext()) {
             Entry<K,V> e = i.next();
             if (e.getKey()==null)
                 return e.getValue();
         }
     } else {
         while (i.hasNext()) {
             Entry<K,V> e = i.next();
             //�Ƚϱ���ʱ�ڵ��key�Ƿ���������keyһ���ж�
             if (key.equals(e.getKey()))
                 return e.getValue();
         }
     }
     return null;
 }
```

## ��5��hashMap   Map���������ѡ��

�ĵ�hashmap������˵�ľͶ��ˣ���ʽ���������ǹ⻷���Ǿʹ�Դ������һ���⻷�ɡ�

### ��5.1����������



```java
    //Ĭ�������ĳ�ʼ����
	static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
	//�������������
    static final int MAXIMUM_CAPACITY = 1 << 30;
	//����Ĭ�ϵļ�������
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
	//����ڵ�ת��Ϊ������ڵ����ֵ
    static final int TREEIFY_THRESHOLD = 8;
	//������ڵ��˻�Ϊ����ڵ����ֵ
    static final int UNTREEIFY_THRESHOLD = 6;
	//ת��Ϊ������ڵ�ʱtable����С����
    static final int MIN_TREEIFY_CAPACITY = 64;
```



### ��5.2�����Խ���



```java
 	
 	transient Node<K,V>[] table;
   
    transient Set<Map.Entry<K,V>> entrySet;
    //ʵ�ʴ洢�ļ�ֵ�Եĸ���
    transient int size;
    //�����ڱ��������������Ե���ʱ���Ʊ仯�ĸ�֪
    transient int modCount;
    //���ݴ�����ֵ����table == {}ʱ����ֵΪ��ʼ��������ʼ����Ĭ��Ϊ16����
    int threshold;
    //�������ӣ�������table�������ж��٣�Ĭ����0.75��75%��
    final float loadFactor;

```



### ��5.3���ڲ������

��ͨ�ڵ�

```java
//�̳�map�ӿ��ڵ�entry�ڵ�
static class Node<K,V> implements Map.Entry<K,V> {
    final int hash;		//hashֵ
    final K key;		//��
    V value;			//ֵ
    Node<K,V> next;		//��һ���ڵ�

    Node(int hash, K key, V value, Node<K,V> next) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public final K getKey()        { return key; }
    public final V getValue()      { return value; }
    public final String toString() { return key + "=" + value; }

    //�����ڲ���Ŷ����hashcode����
    public final int hashCode() {
        //^������������1^0 = 1 , 1^1 = 0 , 0^1 = 1 , 0^0 = 0
        return Objects.hashCode(key) ^ Objects.hashCode(value);
    }
	
    public final V setValue(V newValue) {
        V oldValue = value;
        value = newValue;
        return oldValue;
    }

    public final boolean equals(Object o) {
        if (o == this)
            return true;
        if (o instanceof Map.Entry) {
            Map.Entry<?,?> e = (Map.Entry<?,?>)o;
            //�ֱ�Ƚ�key��value��ȫ����ͬ������ͬ
            if (Objects.equals(key, e.getKey()) &&
                Objects.equals(value, e.getValue()))
                return true;
        }
        return false;
    }
}
```

������ڵ�

```java
static final class TreeNode<K,V> extends LinkedHashMap.Entry<K,V> {
        TreeNode<K,V> parent;  // red-black tree links
        TreeNode<K,V> left;
        TreeNode<K,V> right;
        TreeNode<K,V> prev;    // needed to unlink next upon deletion
        boolean red;
        TreeNode(int hash, K key, V val, Node<K,V> next) {
            super(hash, key, val, next);
        }


        final TreeNode<K,V> root() {
            for (TreeNode<K,V> r = this, p;;) {
                if ((p = r.parent) == null)
                    return r;
                r = p;
            }
        }

		��������
            
}

```



### ��5.4�����췽��



```java
   //���췽��һ   ��ʼ����initialCapacity����������loadFactor
   public HashMap(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0)
            //��ʼ����������Ϊ����
            throw new IllegalArgumentException("Illegal initial capacity: " +
                                               initialCapacity);
        if (initialCapacity > MAXIMUM_CAPACITY)
            //�����ʼ�����������ֵ����ֱ�����ʼ����Ϊ�������ֵ
            initialCapacity = MAXIMUM_CAPACITY;
        if (loadFactor <= 0 || Float.isNaN(loadFactor))
            //У��������Ӹ�ʽ�ͷ�Χ
            throw new IllegalArgumentException("Illegal load factor: " +
                                               loadFactor);
        this.loadFactor = loadFactor;
       	//���ݳ�ʼ����������ֵ
        this.threshold = tableSizeFor(initialCapacity);
    }

	//���ش�����������������2���������ݵ���������10���򷵻�16
    static final int tableSizeFor(int cap) {
        //��������n�Ķ�����Ϊ01xxx...xxx��
        int n = cap - 1;
		//��n����1λ��001xx...xxx����λ��011xx...xxx
        n |= n >>> 1;
		//��n����2Ϊ��00011...xxx����λ��01111...xxx
        n |= n >>> 2;
        //��n����4Ϊ��000001111...xxx����λ��011111111...xxx
        n |= n >>> 4;
        //ͬ����8��1������8λ�϶����ú��λҲΪ1��
        n |= n >>> 8;
		//ͬ����16��1������16λ�϶����ú�16λҲΪ1��
        n |= n >>> 16;
        //���ˣ�����java��intΪ���ֽڣ�Ҳ����32λ������ȷ��ԭ�����λ�ұ�ȫΪ1��Ҳ���Ǵ�ʱn+1Ϊ������ȡ����ӽ���2��x���ݡ�
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
	
	//���췽���� Ĭ�ϼ�������0.75
    public HashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }
	//���췽���� Ĭ�ϼ�������0.75
    public HashMap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR; // all other fields defaulted
    }
	//���췽���ģ�ͨ��map����map
    public HashMap(Map<? extends K, ? extends V> m) {
        //���ü�������ΪĬ�ϼ�������
        this.loadFactor = DEFAULT_LOAD_FACTOR;
		//��ԭmap��Ԫ�ص��빹���map��
        putMapEntries(m, false);
    }
	

    final void putMapEntries(Map<? extends K, ? extends V> m, boolean evict) {
       //��ȡԭhash���Ԫ������
        int s = m.size();
        if (s > 0) {
            //�������Ϊ��
            if (table == null) { // pre-size
                //����±�δ����ռ䣬����з���ռ�
                //������Ҫ����Ŀռ�������С
                float ft = ((float)s / loadFactor) + 1.0F;
                //���ݱ߽��ж�ʵ�ʷ���������С
                int t = ((ft < (float)MAXIMUM_CAPACITY) ?
                         (int)ft : MAXIMUM_CAPACITY);
                if (t > threshold)
                    //����������ֵ
                    threshold = tableSizeFor(t);
            }
            else if (s > threshold)
                resize();//����ڵ��������ڵ�ǰ��ֵ�������ݣ��μ�5.5
            for (Map.Entry<? extends K, ? extends V> e : m.entrySet()) {
                K key = e.getKey();
                V value = e.getValue();
                //copy�ڵ㣬�μ�5.6
                putVal(hash(key), key, value, false, evict);
            }
        }
    }

```



### ��5.5�����ݻ���

```java
//��������������
final Node<K,V>[] resize() {
    //�½��ɽڵ��������� -- ��oldTab��
    Node<K,V>[] oldTab = table;
    //��ȡ�ɽڵ���������� -- ��oldCap��
    int oldCap = (oldTab == null) ? 0 : oldTab.length;
    //��ȡ��ǰ�ɽڵ�����ʱ��������ֵ -- ��oldThr��
    int oldThr = threshold;
    //�������ݺ��½ڵ������������newCap�������ݴ�����ֵ��newThr��
    int newCap, newThr = 0;
    if (oldCap > 0) {
        if (oldCap >= MAXIMUM_CAPACITY) {
            //�����������������������򴥷���ֵ����Ϊ�������ֵ����ֱ�ӷ���ԭ����--����������
            threshold = Integer.MAX_VALUE;
            return oldTab;
        }
        else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                 oldCap >= DEFAULT_INITIAL_CAPACITY)
            //��newCap��= 2 * ��oldCap�� 
            //�����½ڵ�����Ϊ�ɵĽڵ���������������û������������Ҿɽڵ��������ڳ�ʼ��������ֵҲ�ӱ�
            newThr = oldThr << 1; //��newThr��= 2 * ��oldThr�� 
    }
    else if (oldThr > 0) // initial capacity was placed in threshold
        newCap = oldThr;
    else {               // zero initial threshold signifies using defaults
        newCap = DEFAULT_INITIAL_CAPACITY;
        newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
    }
    if (newThr == 0) {
        float ft = (float)newCap * loadFactor;
        newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                  (int)ft : Integer.MAX_VALUE);
    }
    threshold = newThr;
    @SuppressWarnings({"rawtypes","unchecked"})
    Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
    table = newTab;
    if (oldTab != null) {
        for (int j = 0; j < oldCap; ++j) {
            //����table���б���
            Node<K,V> e;
            if ((e = oldTab[j]) != null) {
                //�������ĸ���e�����ݴ棬ͬʱ����table��Ӧ�ֵΪnull
                oldTab[j] = null;
                if (e.next == null)//����Ϊ�յ�Ԫ�ظ��Ƶ���table��
                	//�����Ǵ���һ���µĿ�tableȻ�����½���Ԫ�ص�put�������table������ԭtable������
                    newTab[e.hash & (newCap - 1)] = e;
                
                else if (e instanceof TreeNode)
                    ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
                else { // preserve order
                    Node<K,V> loHead = null, loTail = null;//���ڱ���put����λ������
                    Node<K,V> hiHead = null, hiTail = null;//���ڱ���put����λ������
                    Node<K,V> next;
                    do {
                        next = e.next;
                        if ((e.hash & oldCap) == 0) {
                           //�����Ľ��Ϊ0����ʾ����λ����Ͱ�е�ͷ�����ӵ�lohead��lotail�У��������Ͱ�л��в���λ�Ľ�㣬����tail�������
                            if (loTail == null)
                                //�ں������lohead��lotail���浽table��ʱ��lohead���ڱ���ͷ����λ�ã�lotail�����ж��Ƿ���ĩβ
                                loHead = e;
                            else
                                loTail.next = e;
                            loTail = e;
                        }
                        else {
                            if (hiTail == null)
                                hiHead = e;
                            else
                                hiTail.next = e;
                            hiTail = e;
                        }
                    } while ((e = next) != null);
                    if (loTail != null) {
                        //�Ѳ���λ�Ľ����ӵ���Ӧ������������ȥ
                        loTail.next = null;
                        newTab[j] = loHead;
                    }
                    if (hiTail != null) {
                        //����λ�Ľ����ӵ���Ӧ������������ȥ
                        hiTail.next = null;
                        newTab[j + oldCap] = hiHead;
                    }
                }
            }
        }
    }
    return newTab;
}
 


```



### ��5.6���ڵ����

```java
 public V put(K key, V value) {
     return putVal(hash(key), key, value, false, true);
 }

final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {

    Node<K,V>[] tab; Node<K,V> p; int n, i;
    // ��ʼ��Ͱ���� table
    if ((tab = table) == null || (n = tab.length) == 0)
        //���ݷ���
        n = (tab = resize()).length;
    // ��ǰkey�����ڣ��½���ֵ�Լ���
    if ((p = tab[i = (n - 1) & hash]) == null)

        tab[i] = newNode(hash, key, value, null);

    else {
        Node<K,V> e; K k;
        // �������ֵ�Լ��ڵ� hash ���������еĵ�һ����ֵ�Խڵ�ʱ���� e ָ��ü�ֵ��
        if (p.hash == hash &&
            ((k = p.key) == key || (key != null && key.equals(k))))
            e = p;
        //����ڵ����������ݽṹΪ����������ú�������뷨
        else if (p instanceof TreeNode)
            e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
        else {
            // ����ṹ������
            for (int binCount = 0; ; ++binCount) {
                //�����ڵ�ǰ��Ҫ����Ľڵ�  
                if ((e = p.next) == null) {
                    //�½�һ���ڵ����
                    p.next = newNode(hash, key, value, null);
                    //�����ȳ��������������ֵ��8�����������������
                    if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                        treeifyBin(tab, hash);
                    break;
                }
                //��Ҫ����Ľڵ��Ѿ�������
                if (e.hash == hash &&
                    ((k = e.key) == key || (key != null && key.equals(k))))
                    break;
                p = e;
            }
        }
        if (e != null) { // existing mapping for key
            V oldValue = e.value;
            if (!onlyIfAbsent || oldValue == null)//1.onlyIfAbsent �ж�
                e.value = value;
            afterNodeAccess(e);
            return oldValue;
        }
    }
    ++modCount;
    if (++size > threshold)
        resize();
    afterNodeInsertion(evict);
    return null;
}

```



### ��5.7���ڵ����



```java
   //��ȡԪ�أ�ͨ��key
	public V get(Object key) {
        Node<K,V> e;
        return (e = getNode(hash(key), key)) == null ? null : e.value;
    }
	//ͨ��key����hashֵ
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

   
    final Node<K,V> getNode(int hash, Object key) {
        Node<K,V>[] tab; //Entry����
        Node<K,V> first, e; 
        int n; //���鳤��
        K k;
        // 1. ��λ��ֵ������Ͱ��λ�ã�(n - 1) & hash �ȼ��ڶ� length ȡ�ࣩ
        if ((tab = table) != null && (n = tab.length) > 0 &&
            (first = tab[(n - 1) & hash]) != null) {
            //2.�жϼ�ֵ��hashcode��ȣ��������
            if (first.hash == hash && // always check first node
                ((k = first.key) == key || (key != null && key.equals(k))))
                return first;
            if ((e = first.next) != null) {
                // 3..��� first �� TreeNode ���ͣ�����úں������ҷ���
                if (first instanceof TreeNode)
                    return ((TreeNode<K,V>)first).getTreeNode(hash, key);
                do {
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        return e;
                } while ((e = e.next) != null);
            }
        }
        return null;
    }


```




  

