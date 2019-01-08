package www.arivan.Test1_8;

//2.题目描述：给定一个英文字符串，写一段代码找出字符串中首先出现三次的英文字母。
//        输入描述：输入数据一个 字符串，包括字母，数字 输出描述：
//        输出首先出现三次的那个英文字符 示例：
//        输入： Have you ever gone shopping and 输出： e
public class Test1_8 {
    public static void main(String[] args){
//        String str = "Have you evre gone shopping and";
//        System.out.println(findThreeTimeChar(str));

//        Find f = new Find();
//        System.out.println(f.findMan());;
    }

    public static char findThreeTimeChar(String str){
        int count = 0;
        char[] data = str.toCharArray();
        int[] arr = new int[250];
        for(int i = 0; i < data.length; i++) {
            char c = data[i];
            if (c > 'a' && c < 'z' || c > 'A' && c < 'Z') {
                arr[c]++;
                if(arr[c] == 3){
                    return c;
                }

            }
        }
        return ' ';
    }
}

//3.题目：有10个人围成一圈，顺序排号。
//        从第一个人开始报数（从1到3报数），凡报到3的人退出圈子，问后留下
//        的是原来第几号的那位

//class Find {
//    public static int findMan(){
//        int[] arr = new int[]{0,1,2,3,4,5,6,7,8,9};//给是个人编号
//        int num = 1; //当num=3时，此时的人出局
//        int isout = 1; //0代表还在圈子里 ，1代表不在圈子里
//        int m = arr.length;
//        for(int i = 0; i < m; i++){
//            int n = arr[i];
//            if(num == 3){
//                isout = 0;
//                /*
//                if(isout == 0){
//                    num = 1;
//                }else{
//                    m--;
//                    continue;
//                }
//                */
//            }else{
//                num++;
//            }
//            if(m == 1){
//                return n;
//            }
//            if(i == m-1){
//                i = 0;
//            }
//        }
//        return 0;
//    }
//}