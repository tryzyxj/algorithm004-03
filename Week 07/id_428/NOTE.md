# Week_07_学习总结

## 1、学习过程

​	1）位运算 2）算法题目演练

## 2、本周学习内容（待细化）

​	1）位运算

	

​	2）布隆过滤器

​	3）LRU缓存

​	4）排序算法

## 3、布隆过滤器

本质上布隆过滤器是一种数据结构，比较巧妙的概率型数据结构（probabilistic data structure），特点是高效地插入和查询，可以用来告诉你 “某样东西一定不存在或者可能存在”。

相比于传统的 List、Set、Map 等数据结构，它更高效、占用空间更少，但是缺点是其返回的结果是概率性的，而不是确切的。

## 实现原理

### HashMap 的问题

讲述布隆过滤器的原理之前，我们先思考一下，通常你判断某个元素是否存在用的是什么？应该蛮多人回答 HashMap 吧，确实可以将值映射到 HashMap 的 Key，然后可以在 O(1) 的时间复杂度内返回结果，效率奇高。但是 HashMap 的实现也有缺点，例如存储容量占比高，考虑到负载因子的存在，通常空间是不能被用满的，而一旦你的值很多例如上亿的时候，那 HashMap 占据的内存大小就变得很可观了。

还比如说你的数据集存储在远程服务器上，本地服务接受输入，而数据集非常大不可能一次性读进内存构建 HashMap 的时候，也会存在问题。

### 布隆过滤器数据结构

布隆过滤器是一个 bit 向量或者说 bit 数组，长这样：





![img](https:////upload-images.jianshu.io/upload_images/2785001-07e149c32a2608fa.jpg?imageMogr2/auto-orient/strip|imageView2/2/w/600/format/webp)

image

如果我们要映射一个值到布隆过滤器中，我们需要使用多个不同的哈希函数生成多个哈希值，并对每个生成的哈希值指向的 bit 位置 1，例如针对值 “baidu” 和三个不同的哈希函数分别生成了哈希值 1、4、7，则上图转变为：





![img](https:////upload-images.jianshu.io/upload_images/2785001-12449becdb038afd.jpg?imageMogr2/auto-orient/strip|imageView2/2/w/600/format/webp)

image

Ok，我们现在再存一个值 “tencent”，如果哈希函数返回 3、4、8 的话，图继续变为：





![img](https:////upload-images.jianshu.io/upload_images/2785001-802577f6332d76b4.jpg?imageMogr2/auto-orient/strip|imageView2/2/w/600/format/webp)

image

值得注意的是，4 这个 bit 位由于两个值的哈希函数都返回了这个 bit 位，因此它被覆盖了。现在我们如果想查询 “dianping” 这个值是否存在，哈希函数返回了 1、5、8三个值，结果我们发现 5 这个 bit 位上的值为 0，说明没有任何一个值映射到这个 bit 位上，因此我们可以很确定地说 “dianping” 这个值不存在。而当我们需要查询 “baidu” 这个值是否存在的话，那么哈希函数必然会返回 1、4、7，然后我们检查发现这三个 bit 位上的值均为 1，那么我们可以说 “baidu” 存在了么？答案是不可以，只能是 “baidu” 这个值可能存在。

这是为什么呢？答案跟简单，因为随着增加的值越来越多，被置为 1 的 bit 位也会越来越多，这样某个值 “taobao” 即使没有被存储过，但是万一哈希函数返回的三个 bit 位都被其他值置位了 1 ，那么程序还是会判断 “taobao” 这个值存在。

## 支持删除么

目前我们知道布隆过滤器可以支持 add 和 isExist 操作，那么 delete 操作可以么，答案是不可以，例如上图中的 bit 位 4 被两个值共同覆盖的话，一旦你删除其中一个值例如 “tencent” 而将其置位 0，那么下次判断另一个值例如 “baidu” 是否存在的话，会直接返回 false，而实际上你并没有删除它。

如何解决这个问题，答案是计数删除。但是计数删除需要存储一个数值，而不是原先的 bit 位，会增大占用的内存大小。这样的话，增加一个值就是将对应索引槽上存储的值加一，删除则是减一，判断是否存在则是看值是否大于0。

## 如何选择哈希函数个数和布隆过滤器长度

很显然，过小的布隆过滤器很快所有的 bit 位均为 1，那么查询任何值都会返回“可能存在”，起不到过滤的目的了。布隆过滤器的长度会直接影响误报率，布隆过滤器越长其误报率越小。

另外，哈希函数的个数也需要权衡，个数越多则布隆过滤器 bit 位置位 1 的速度越快，且布隆过滤器的效率越低；但是如果太少的话，那我们的误报率会变高。





![img](https:////upload-images.jianshu.io/upload_images/2785001-76dccfbdc9d7bdb1.jpg?imageMogr2/auto-orient/strip|imageView2/2/w/600/format/webp)

image

k 为哈希函数个数，m 为布隆过滤器长度，n 为插入的元素个数，p 为误报率。
 至于如何推导这个公式，我在知乎发布的[文章](https://zhuanlan.zhihu.com/p/43263751)有涉及，感兴趣可以看看，不感兴趣的话记住上面这个公式就行了。

## 最佳实践

常见的适用常见有，利用布隆过滤器减少磁盘 IO 或者网络请求，因为一旦一个值必定不存在的话，我们可以不用进行后续昂贵的查询请求。

另外，既然你使用布隆过滤器来加速查找和判断是否存在，那么性能很低的哈希函数不是个好选择，推荐 MurmurHash、Fnv 这些。

### 大Value拆分

Redis 因其支持 setbit 和 getbit 操作，且纯内存性能高等特点，因此天然就可以作为布隆过滤器来使用。但是布隆过滤器的不当使用极易产生大 Value，增加 Redis 阻塞风险，因此生成环境中建议对体积庞大的布隆过滤器进行拆分。

拆分的形式方法多种多样，但是本质是不要将 Hash(Key) 之后的请求分散在多个节点的多个小 bitmap 上，而是应该拆分成多个小 bitmap 之后，对一个 Key 的所有哈希函数都落在这一个小 bitmap 上。

参考：

https://www.jianshu.com/p/2104d11ee0a2

https://blog.csdn.net/a308601801/article/details/87074273

https://blog.csdn.net/maizi1045/article/details/80652351

## 4、LRU缓存

[LRU缓存原理](https://www.cnblogs.com/Jackie-zhang/p/9869652.html)

LRU(Least Recently Used)  LRU是近期最少使用的算法，它的核心思想是当缓存满时，会优先淘汰那些近期最少使用的缓存对象。

采用LRU算法的缓存有两种：**LrhCache和DisLruCache**，分别用于实现内存缓存和硬盘缓存，其核心思想都是LRU缓存算法。

##### 1.LruCache的介绍

LruCache是个泛型类，主要算法原理是把最近使用的对象用强引用（即我们平常使用的对象引用方式）存储在 LinkedHashMap 中。当缓存满时，

把最近最少使用的对象从内存中移除，并提供了get和put方法来完成缓存的获取和添加操作。

##### 2.LruCache的使用

LruCache的使用非常简单，我们就已图片缓存为例。

[![复制代码](https://common.cnblogs.com/images/copycode.gif)](javascript:void(0);)

```
 int maxMemory = (int) (Runtime.getRuntime().totalMemory()/1024);
        int cacheSize = maxMemory/8;
        mMemoryCache = new LruCache<String,Bitmap>(cacheSize){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes()*value.getHeight()/1024;
            }
        };
```

[![复制代码](https://common.cnblogs.com/images/copycode.gif)](javascript:void(0);)

①设置LruCache缓存的大小，一般为当前进程可用容量的1/8。

②重写sizeOf方法，计算出要缓存的每张图片的大小。

**注意：**缓存的总容量和每个缓存对象的大小所用单位要一致。

### 三、LruCache的实现原理

LruCache的核心思想很好理解，就是要维护一个缓存对象列表，其中对象列表的排列方式是按照访问顺序实现的，

即一直没访问的对象，将放在队首，即将被淘汰。而最近访问的对象将放在队头，最后被淘汰。

![img](https://img2018.cnblogs.com/blog/891527/201810/891527-20181029112357695-129541770.png)

**这个队列是由LinkedHashMap来维护。**

LinkedHashMap是由数组+双向链表

其中双向链表的结构可以实现访问顺序和插入顺序，使得LinkedHashMap中的<key,value>对按照一定顺序排列起来。

 

通过下面构造函数来指定LinkedHashMap中双向链表的结构是访问顺序还是插入顺序。

```
public LinkedHashMap(int initialCapacity,
                         float loadFactor,
                         boolean accessOrder) {
        super(initialCapacity, loadFactor);
        this.accessOrder = accessOrder;
    }
```

其中accessOrder设置为true则为访问顺序，为false，则为插入顺序。LruCache的构造函数中可以看到**正是用了LinkedHashMap的访问顺序**。

以具体例子解释：
当设置为true时

[![复制代码](https://common.cnblogs.com/images/copycode.gif)](javascript:void(0);)

```
public static final void main(String[] args) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>(0, 0.75f, true);
        map.put(0, 0);
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 4);
        map.put(5, 5);
        map.put(6, 6);
        map.get(1);
        map.get(2);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());

        }
    }
```

[![复制代码](https://common.cnblogs.com/images/copycode.gif)](javascript:void(0);)

输出结果：

> 0:0
> 3:3
> 4:4
> 5:5
> 6:6
> 1:1
> 2:2

即最近访问的最后输出，那么这就正好满足的LRU缓存算法的思想。可见**LruCache巧妙实现，就是利用了LinkedHashMap的这种数据结构。**下面我们在LruCache源码中具体看看，怎么应用LinkedHashMap来实现缓存的添加，获得和删除的。

[![复制代码](https://common.cnblogs.com/images/copycode.gif)](javascript:void(0);)

```
public LruCache(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.maxSize = maxSize;
        this.map = new LinkedHashMap<K, V>(0, 0.75f, true);
    }
```

[![复制代码](https://common.cnblogs.com/images/copycode.gif)](javascript:void(0);)

从LruCache的构造函数中可以看到**正是用了LinkedHashMap的访问顺序**。

### 3.1  put() 方法

[![复制代码](https://common.cnblogs.com/images/copycode.gif)](javascript:void(0);)

```
public final V put(K key, V value) {
         //不可为空，否则抛出异常
        if (key == null || value == null) {
            throw new NullPointerException("key == null || value == null");
        }
        V previous;
        synchronized (this) {
            //插入的缓存对象值加1
            putCount++;
            //增加已有缓存的大小
            size += safeSizeOf(key, value);
           //向map中加入缓存对象
            previous = map.put(key, value);
            //如果已有缓存对象，则缓存大小恢复到之前
            if (previous != null) {
                size -= safeSizeOf(key, previous);
            }
        }
        //entryRemoved()是个空方法，可以自行实现
        if (previous != null) {
            entryRemoved(false, key, previous, value);
        }
        //调整缓存大小(关键方法)
        trimToSize(maxSize);
        return previous;
    }
```

[![复制代码](https://common.cnblogs.com/images/copycode.gif)](javascript:void(0);)

可以看到put()方法并没有什么难点，重要的就是在添加过缓存对象后，调用 trimToSize()方法，来判断缓存是否已满，如果满了就要删除近期最少使用的算法。

trimToSize()方法（LRU的核心算法）

[![复制代码](https://common.cnblogs.com/images/copycode.gif)](javascript:void(0);)

```
public void trimToSize(int maxSize) {
        //死循环
        while (true) {
            K key;
            V value;
            synchronized (this) {
                //如果map为空并且缓存size不等于0或者缓存size小于0，抛出异常
                if (size < 0 || (map.isEmpty() && size != 0)) {
                    throw new IllegalStateException(getClass().getName()
                            + ".sizeOf() is reporting inconsistent results!");
                }
                //如果缓存大小size小于最大缓存，或者map为空，不需要再删除缓存对象，跳出循环
                if (size <= maxSize || map.isEmpty()) {
                    break;
                }
                //迭代器获取第一个对象，即队尾的元素，近期最少访问的元素
                Map.Entry<K, V> toEvict = map.entrySet().iterator().next();
                key = toEvict.getKey();
                value = toEvict.getValue();
                //删除该对象，并更新缓存大小
                map.remove(key);
                size -= safeSizeOf(key, value);
                evictionCount++;
            }
            entryRemoved(true, key, value, null);
        }
    }
```

[![复制代码](https://common.cnblogs.com/images/copycode.gif)](javascript:void(0);)

trimToSize()方法不断地删除LinkedHashMap中队尾的元素，即近期最少访问的，直到缓存大小小于最大值。

当调用LruCache的get()方法获取集合中的缓存对象时，就代表访问了一次该元素，将会更新队列，保持整个队列是按照访问顺序排序。这个更新过程就是在LinkedHashMap中的get()方法中完成的。

### 3.2  get() 方法

[![复制代码](https://common.cnblogs.com/images/copycode.gif)](javascript:void(0);)

```
public final V get(K key) {
        //key为空抛出异常
        if (key == null) {
            throw new NullPointerException("key == null");
        }

        V mapValue;
        synchronized (this) {
            //获取对应的缓存对象
            //get()方法会实现将访问的元素更新到队列头部的功能
            mapValue = map.get(key);
            if (mapValue != null) {
                hitCount++;
                return mapValue;
            }
            missCount++;
        }
```

[![复制代码](https://common.cnblogs.com/images/copycode.gif)](javascript:void(0);)

其中LinkedHashMap的get()方法如下：

[![复制代码](https://common.cnblogs.com/images/copycode.gif)](javascript:void(0);)

```
public V get(Object key) {
        LinkedHashMapEntry<K,V> e = (LinkedHashMapEntry<K,V>)getEntry(key);
        if (e == null)
            return null;
        //实现排序的关键方法
        e.recordAccess(this);
        return e.value;
    }
```

 **recordAccess()方法**如下：

```
void recordAccess(HashMap<K,V> m) {
            LinkedHashMap<K,V> lm = (LinkedHashMap<K,V>)m;
            //判断是否是访问排序
            if (lm.accessOrder) {
                lm.modCount++;
                //删除此元素
                remove();
                //将此元素移动到队列的头部
                addBefore(lm.header);
            }
        }
```

**总结**：由此可见LruCache中维护了一个集合LinkedHashMap，该LinkedHashMap是以访问顺序排序的。当调用put()方法时，就会在结合中添加元素，并调用trimToSize()判断缓存是否已满，如果满了就用LinkedHashMap的迭代器删除队尾元素，即近期最少访问的元素。当调用get()方法访问缓存对象时，就会调用LinkedHashMap的get()方法获得对应集合元素，同时会更新该元素到队头。

参考：

https://www.cnblogs.com/Jackie-zhang/p/9869652.html

https://www.jb51.net/article/134282.htm