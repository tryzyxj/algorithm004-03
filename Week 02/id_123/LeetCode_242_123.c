//˼·��������һ������������� s ��ĸ��Ƶ�ʣ��� t ���ټ��������е�ÿ����ĸ�ļ�������Ȼ����������Ƿ�ص��㡣
// bool isAnagram(char * s, char * t){
//     int n = strlen(s);
//     int m = strlen(t);
//     if(n!=m)
//         return false;
//     int map[26]={0};
//     for(int i=0; i<n ;i++){
//         map[s[i]-'a']++;
//         map[t[i]-'a']--;
//         }
//     for(int i=0; i<26; i++){
//         if(map[i]!=0)
//             return false;
//     }
//     return true;
   

// }
//˼·��
//1.�����ж������ַ��������Ƿ���ȣ��������ֱ�ӷ��� false��
//2.�����򣬺��ж��Ƿ����
//��̾��飺
//����֤c�⺯����qsortΪ�Ż����ȶ��Ŀ���
int cmp(const void* a, const void* b){
    return *(char*)a - *(char*)b;
}

bool isAnagram(char * s, char * t){
    int n = strlen(s);
    int m = strlen(t);
    if(n!=m)
        return false;
    qsort(s,n,sizeof(char),cmp);
    qsort(t,n,sizeof(char),cmp);   
    printf("%s",s);
    printf("%s",t);
    if(strcmp(s,t))
        return false;
    else 
        return true;
    

}