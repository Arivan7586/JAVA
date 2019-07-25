package Test7_25;

import java.net.Socket;
import java.util.*;

public class practice7_25 {

    public static void main(String[] args) {

//        Solution.solution();

//        Solution1.solution();

        Solution2 solution2 = new Solution2();
        int[] arr = {1,2,3,2,2,2,5,4,2};
        System.out.println(solution2.MoreThanHalfNum_Solution(arr));

        Solution3.solution();

        System.out.println("E:\\V1R2\\product\\fpgadrive.c   1325".indexOf(" "));
        System.out.println("E:\\V1R2\\product\\fpgadrive.c   1325".substring(0,27));
        System.out.println("E:\\V1R2\\product\\fpgadrive.c   1325".substring(27).trim());

    }
}

// ABCDFYE CDE<br/>ABCDGEAS CDECDE

//乒乓球框
class Solution {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String A = in.next();
            String B = in.next();

            boolean res = true;
            for (int i = 0; i < B.length(); i++) {
                char value = B.charAt(i);
                boolean flag = true;
                for (int j = 0; j < A.length(); j++) {
                    if (value == A.charAt(j)) {
                        A = A.replaceFirst(String.valueOf(value), "");
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    System.out.println("No");
                    res = false;
                    break;
                }
            }
            if (res) {
                System.out.println("Yes");
            }
        }
        in.close();
    }
}

//查找兄弟单词
class Solution1 {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.next();
            }
            //待查找单词
            String value = in.next();
            int index = in.nextInt();

            char[] charValue = value.toCharArray();
            Arrays.sort(charValue);

            List<String> list = new ArrayList<>();

            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                if (isTrue(value, arr[i], charValue)) {
                    list.add(arr[i]);
                    count++;
                }
            }

            System.out.println(count);
            Collections.sort(list);
            if (index <= count) {
                System.out.println(list.get(index - 1));
            }

        }
        in.close();
    }

    private static boolean isTrue(String key, String word, char[] chars) {
        if (key.equals(word) || key.length() != word.length()) {
            return false;
        }

        char[] arr2 = word.toCharArray();

        Arrays.sort(arr2);

        return Arrays.equals(chars, arr2);
    }
}

//数组中出现次数超过一半的数字
class Solution2 {
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length < 1) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        Arrays.sort(array);
        int n = array.length;
        int length = n / 2;
        for (int i = 0; i < n - length; i++) {
            if (array[i] == array[i+length]) {
                return array[i];
            }
        }
        return 0;
    }
}

//简单错误记录
class Solution3 {
    public static void solution() {
        Scanner in = new Scanner(System.in);
        LinkedHashMap<String,Integer> map = new LinkedHashMap();
        while (in.hasNext()) {
            String input = in.nextLine();
            int space = input.indexOf(" ");
            String fileName = input.substring(0,space);
            String rows = input.substring(space).trim();
            String[] arr = fileName.trim().split("\\\\");
            fileName = arr[arr.length - 1];
            if (fileName.length() > 16) {
                fileName = fileName.substring(fileName.length() - 16);
            }
            String key = fileName + " " + rows;
            if (!map.containsKey(key)) {
                map.put(key,1);
            } else {
                int value = map.get(key);
                map.put(key,value+1);
            }
        }
        int count = 0;
        for (String key : map.keySet()) {
            count++;
            if (count > map.keySet().size() - 8) {
                System.out.println(key + " " + map.get(key));
            }
        }
        in.close();
    }
}