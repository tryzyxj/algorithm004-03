## Dynamic Programing 动态规划
### 典型问题
* 0-1背包问题

### 思路
> 把问题分解为多个阶段，每个阶段对应一个决策，记录每个阶段可达的状态集合（去重），通过当前阶段的状态集合，来推导下一阶段的状态集合，动态地往前推进。

### 动态规划问题特征
> 一个模型，三个特征
#### 一个模型
**多阶段决策最优解模型**
#### 三个特征
1. 最优子结构
2. 无后效性（只能前进，不能后退）
3. 重复子问题（利用回溯法，画出递归树，其中有重复的状态）

### 动态规划问题核心思维
#### 状态转移表法
> 回溯算法实现 - 定义状态 - 画递归树 - 找重复子问题 - 画状态转移表 - 根据递推关系填表 - 将填表过程翻译成代码
#### 状态转移方程（关键）
> 找最优子结构 - 写状态转移方程 - 将状态转移方程翻译成代码

### 动态规划问题关键点
1. 动态规划和递归/分治没有根本上的区别（关键看有没有最优子结构）
2. 共性：找到重复子问题
3. 差异性：最优子结构，中途可以淘汰次优解

### 工业例子
#### 如何简单实现搜索引擎的拼写纠错功能？
> 关键点：如何量化两个字符串的相似度？

**KEY：编辑距离**
* 莱温斯坦距离（描述差异化，可以进行增、删、改操作）
* 最长公共子串长度（描述相似性，可以进行增、删操作）

----

### 动态规划算法问题解题思路
1. 重复性（将问题分解为子问题）
2. 储存中间状态
3. 递归公式（状态转移方程/DP方程）

### 思维小结
1. 打破思维惯性，形成及其思维
2. 理解复杂逻辑的关键
3. 也是职业进步的药店要领

### LeetCode
* [70.爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/description/)
* [120.三角形最小路径和](https://leetcode-cn.com/problems/triangle/description/)
* [53.最大子序和](https://leetcode-cn.com/problems/maximum-subarray/)
* [64.最小路径和](https://leetcode-cn.com/problems/minimum-path-sum/)
* [221.最小正方形](https://leetcode-cn.com/problems/maximal-square/submissions/)
