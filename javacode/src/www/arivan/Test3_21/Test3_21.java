package www.arivan.Test3_21;

public class Test3_21 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.romanToInt("LVIII"));
        System.out.println(solution.romanToInt("MCMXCIV"));

        String[] arr = new String[]{"test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.numUniqueEmails(arr));

//        System.out.println(Math1.one(2001));
//        System.out.println(Math1.numberOfOne(2048));
        System.out.println("--------------------");
        Solution3 solution3 = new Solution3();
//        System.out.println(solution3.change("speak",1));
        String str1 = "I speak Goat Latin";
        String str2 = "The quick brown fox jumped over the lazy dog";
        System.out.println(solution3.toGoatLatin(str1));
        System.out.println(solution3.toGoatLatin(str2));

//        System.out.println('b'-97);
//        Solution2 solution2 = new Solution2();
//        System.out.println(solution2.change("gig"));
//        System.out.println(solution2.uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
    }
}

//罗马数字转成整数
class Solution {
//    通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。
//    数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。
//    这个特殊的规则只适用于以下六种情况：
//    I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
//    X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
//    C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
//    给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
    public int romanToInt(String s) {
        int value = 0;
        char[] arr = s.toCharArray();
        int i = 0;
        while (i < arr.length-1) {
            char c = arr[i];
            switch (c) {
                case 'I':
                    if (arr[i+1] == 'V') {
                        value += 4;
                        i++;
                    }else if (arr[i+1] == 'X') {
                        value += 9;
                        i++;
                    }else {
                        value++;
                    }
                    break;
                case 'V':
                    value += 5;
                    break;
                case 'X':
                    if (arr[i+1] == 'L') {
                        value += 40;
                        i++;
                    }else if (arr[i+1] == 'C') {
                        value += 90;
                        i++;
                    }else {
                        value += 10;
                    }
                    break;
                case 'L':
                    value += 50;
                    break;
                case 'C':
                    if (arr[i+1] == 'D') {
                        value += 400;
                        i++;
                    }else if (arr[i+1] == 'M') {
                        value += 900;
                        i++;
                    }else {
                        value += 100;
                    }
                    break;
                case 'D':
                    value += 500;
                    break;
                case 'M':
                    value += 1000;
                    break;
                default:
                    break;

            }
            i++;
        }
        if (i < arr.length) {
            char cc = arr[i];
            switch (cc) {
                case 'I':
                    value++;
                    break;
                case 'V':
                    value += 5;
                    break;
                case 'X':
                    value += 10;
                    break;
                case 'L':
                    value += 50;
                    break;
                case 'C':
                    value += 100;
                    break;
                case 'D':
                    value += 500;
                    break;
                case 'M':
                    value += 1000;
                    break;
                default:
                    break;
            }
        }
        return value;
    }
}

//独特的电子邮件地址
class Solution1 {
//    如果在电子邮件地址的本地名称部分中的某些字符之间添加句点（'.'），
//    则发往那里的邮件将会转发到本地名称中没有点的同一地址。（请注意，此规则不适用于域名。）
//    如果在本地名称中添加加号（'+'），则会忽略第一个加号后面的所有内容。
//    这允许过滤某些电子邮件，（同样，此规则不适用于域名。）
//    可以同时使用这两个规则。
//    给定电子邮件列表 emails，我们会向列表中的每个地址发送一封电子邮件。实际收到邮件的不同地址有多少？
    public int numUniqueEmails(String[] emails) {
        int n = emails.length;
        int num = 0;
        if (n < 1) {
            return 0;
        }else if (n == 1) {
            return 1;
        }else {
            int k = 0;
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                String val = change(emails[i]);
                //将不重复的字符串存在新数组中
                if (ensureSame(arr,val)) {
                    arr[k++] = val;
                }
            }
            //计算新数组中有效字符串的个数
            int count = 0;
            while (count < n) {
                if (arr[count] == null) {
                    break;
                }
                count++;
            }
            return count;
        }
    }
    //判断数组arr中是否存在元素str，存在返回false，不存在返回true
    public boolean ensureSame(String[] arr,String str) {
        for (int i = 0; i < arr.length; i++) {
            if (str.equals(arr[i]) && arr[i] != null) {
                return false;
            }
        }
        return true;
    }
    //将给定的字符串转换为题目给定的电子邮箱地址格式（去除@前面的“.”和“+”后面的字符串）
    public String change(String str) {
        //将地址按@分隔开
        String[] arr = str.split("@");
        //去除“+”后面的字符串
        arr[0] = arr[0].split("\\+")[0];
        //去除本地名称中的“.”
        arr[0] = arr[0].replace(".","");
        return arr[0]+"@"+arr[1];
    }
}

//摩尔斯密码
class Solution2 {
    public int uniqueMorseRepresentations(String[] words) {
        int n = words.length;
        String[] arr = new String[n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            String val = change(words[i]);
            if (ensureSame(arr,val)) {
                arr[k++] = val;
            }
        }
        //统计摩尔斯密码翻译的类型数目
        //计算新数组中有效字符串的个数
        int count = 0;
        while (count < n) {
            if (arr[count] == null) {
                break;
            }
            count++;
        }
        return count;
    }
    public boolean ensureSame(String[] arr,String str) {
        for (int i = 0; i < arr.length; i++) {
            if (str.equals(arr[i]) && arr[i] != null) {
                return false;
            }
        }
        return true;
    }
    public String change(String str) { //把单词转换为摩尔斯密码词
        String[] MorseCode = new String[]{".-","-...","-.-.","-..",".","..-.","--.",
                "....", "..",".---","-.-",".-..","--","-.","---",".--.","--.-",
                ".-.","...", "-","..-","...-",".--","-..-","-.--","--.."};
        char[] arr = str.toCharArray();
        String[] newArray = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int index = arr[i]-97;
            newArray[i] = MorseCode[index];
        }
        StringBuffer stringBuffer = new StringBuffer(newArray[0]);
        for (int i = 1; i < newArray.length; i++) {
            //用StringBuffer，是因为拼接字符串的时候，StringBuffer比String效率高
            stringBuffer.append(newArray[i]);
        }
        return stringBuffer.toString();
    }
}

//山羊拉丁文
class Solution3 {
    public String toGoatLatin(String S) {
        //把字符串按照“ ”拆分为多个字符串
        String[] arr = S.split(" ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = change(arr[i],i);
        }
        StringBuffer stringBuffer = new StringBuffer(arr[0]);
        for (int i = 1; i < arr.length-1; i++) {
            stringBuffer.append(" ");
            stringBuffer.append(arr[i]);
        }
        if (arr.length > 1) {
            stringBuffer.append(" ");
            stringBuffer.append(arr[arr.length-1]);
        }
        return stringBuffer.toString();
    }
    //把数组中第k单词编程山羊拉丁文
    public String change(String str,int index) {
        int n = str.length();
        StringBuffer stringBuffer = new StringBuffer(str);
        char[] arr = new char[1];
        stringBuffer.getChars(0,1,arr,0);
        switch (arr[0] ) {
            case 'a':
            case 'A':
            case 'e':
            case 'E':
            case 'i':
            case 'I':
            case 'o':
            case 'O':
            case 'u':
            case 'U':
                stringBuffer.append("ma");
                break;
                default:
                    stringBuffer = stringBuffer.delete(0,1);
                    stringBuffer.append(arr[0]);
                    stringBuffer.append("ma");
                    break;
        }
        index += 1;
        int i = 0;
        while (i < index) {
            stringBuffer.append("a");
            i++;
        }
        return stringBuffer.toString();
    }
}

class Math1 {
    //统计 1-n 之间，1出现的次数
    public static int numberOfOne(int n) {
        int num = 0;
        for (int i = 1; i <= n; i++) {
            num += one(i);
        }
        return num;
    }
    //统计一个数中1的个数
    public static int one(int n) {
        int num = 0;
        while (n > 0) {
            if (n%10 == 1) {
                num++;
            }
            n /= 10;
        }
        return num;
    }
}
