package Test7_29;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class practice7_29 {

    public static void main(String[] args) {

//        int c = '5' - '0';
//        System.out.println('5' - '0');

//        Solution solution = new Solution();
//        System.out.println(solution.letterCombinations("23"));

        Solution1 solution1 = new Solution1();
        int[][] arr = new int[][]{{0,0,0},{0,1,1}};
        int[][] res = solution1.floodFill(arr,1,1,1);

        Solution2 solution2 = new Solution2();
        System.out.println(solution2.islandPerimeter(new int[][]{{1}}));
    }
}

//电话号码的字母组合
class Solution {
    private final static String[] arr = new String[]
            {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits == null) {
            return list;
        }
        String str = "";
        run(digits,0,str,list);
        return list;
    }
    private void run(String num, int i, String str, List<String> list) {
        if (i >= num.length()) {
            if (str.length() > 0) {
                list.add(str);
            }
            return;
        }
        int index = num.charAt(i) - '0';
        String value = arr[index];

        char[] chars = value.toCharArray();
        for (int j = 0; j < chars.length; j++) {
            String string = str + chars[j];
            run(num,i+1,string,list);
        }
    }
}

//图像渲染
class Solution1 {
    private List<String> list = new ArrayList<>();
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (list.contains(sr+""+sc)) {
            return image;
        }
        int value = image[sr][sc];
        image[sr][sc] = newColor;
        list.add(sr + "" + sc);
        if (sr - 1 >= 0 && image[sr-1][sc] == value) {
            image = floodFill(image,sr - 1,sc,newColor);
        }
        if (sr + 1 < image.length && image[sr+1][sc] == value) {
            image = floodFill(image,sr + 1,sc,newColor);
        }
        if (sc - 1 >= 0 && image[sr][sc-1] == value) {
            image = floodFill(image,sr,sc-1,newColor);
        }
        if (sc + 1 < image[0].length && image[sr][sc+1] == value) {
            image = floodFill(image,sr,sc+1,newColor);
        }
        return image;
    }
}

//岛屿的周长
class Solution2 {
    public int islandPerimeter(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                if (i - 1 >= 0 && grid[i-1][j] == 0 || i - 1 < 0) {
                    sum += 1;
                }
                if (i + 1 < grid.length && grid[i+1][j] == 0 || i + 1 >= grid.length) {
                    sum += 1;
                }
                if (j - 1 >= 0 && grid[i][j-1] == 0 || j - 1 < 0) {
                    sum += 1;
                }
                if (j + 1 < grid[0].length && grid[i][j+1] == 0 || j + 1 >= grid[0].length) {
                    sum += 1;
                }
            }
        }
        return sum;
    }
}

