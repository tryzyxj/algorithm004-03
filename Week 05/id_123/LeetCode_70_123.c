// int climbStairs(int n){
//     //�ݹ�f(2)=2;f(1)=1;f(3)=f(2)+f(1)(��̬�滮)
//     //��쳲���������������ʽ����
//     if(n<=2){
//         return n;
//     }
//     int* stair = (int*)malloc(sizeof(int)*(n+1));
//     stair[1]=1;
//     stair[2]=2;
//     for(int i=3; i<=n; i++){
//         stair[i] = stair[i-1] + stair[i-2];
//     }
//     return stair[n];

// }

// int climbStairs(int n){
//     //�ݹ�f(2)=2;f(1)=1;f(3)=f(2)+f(1)(��̬�滮)
//     //�ǵݹ飬��������ʵ��
//     if(n<=2){
//         return n;
//     }
//     int f1 = 1;
//     int f2 = 2;
//     int f3 = 3;
//     for(int i=3; i<=n; i++){
//         f3 = f1 + f2;
//         f1 = f2;
//         f2 = f3;
//     }
//     return f3;

// }

// FAIL
// //쳲����������Եݹ���ʽʵ�� 
// ////����ʱ������
// int fn(int n)
// {
//     if(n == 0 || n == 1) return 1;//ǰ����̶�ֵ��
//     return fn(n-1)+fn(n-2);// ͨ���ݹ����ʵ��ͨ�ʽ�� 
// }

// int climbStairs(int n){
//     if(n<=2)
//         return n;
//     return fn(n);

// }

int climbStairs(int n){
    //f(2)=2;f(1)=1;f(3)=f(2)+f(1)
    //쳲�����ͨ�ʽ
    //쳲��������������±��Ե��Ƶķ������壺F(1)=1��F(2)=1, F(n)=F(n-1)+F(n-2)��n>=3��n��N*�����뱾���f(1)=1,f(2)=2,��1
    int f=(1/sqrt(5))*(pow(((1+sqrt(5))/2),(n+1))-pow(((1-sqrt(5))/2),(n+1)));
    return f;

}