// def BFS(graph, start, end):
// queue = []?
// queue.append([start])?
// while queue:?
// node = queue.pop()?
// visited.add(node)
// process(node)?
// nodes = generate_related_nodes(node)?
// queue.push(nodes)
// # other processing work?
// ...

/*
 * �㷨˼�룺
 * �������������
 * 1. ��Ҫһ�����и���������ʹ��������棬head��rear��ʾ������β��
 * 2. check()�������ڼ�����������Ƿ������ת����������������һ����ĸ��ͬ��
 * 3. vst[]���ڼ�¼��index�����Ƿ��Ѿ����ʹ���
 *
 */

bool check(char *s1, char *s2, int len){
    int i, flag = 0;

    for(i=0; i<len; i++){
        if(s1[i] != s2[i]){
            if(!flag) {
                flag = 1;
            }else{
                return false;
            }
        }
    }

    return flag;
}

typedef struct wd{
    int index;
    int d;
} Node;

#define LEN 0xfffff
int ladderLength(char * first, char * last, 
                 char ** wds, int wnum){
    Node que[LEN], *node;
    int head = 0, rear=0, i, j, len = strlen(wds[0]), last_index=INT_MAX;
    bool vst[wnum];
    
    memset(vst, 0, sizeof(vst));
    
    for(i=0; i<wnum; i++) {
        if(!strcmp(last, wds[i])){
            last_index = i;
            break;
        }
    }
    
    if(last_index==INT_MAX) {
        return 0;
    }
    
    que[head].index = last_index;
    que[head++].d = 1;
    vst[last_index] = 1;
    
    while(head > rear){
        node = &que[rear++];
        
        if(check(wds[node->index], first, len)){
            return node->d + 1;
        }
        
        for(i=0; i<wnum; i++) {
            if(!vst[i] && check(wds[node->index], wds[i], len)){
                que[head].index = i;
                que[head++].d = node->d + 1;
                vst[i] = 1;
            }
        }        
        
    }
    
    return 0;
}