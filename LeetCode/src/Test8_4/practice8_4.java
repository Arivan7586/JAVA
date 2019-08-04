package Test8_4;

import java.net.Socket;
import java.util.*;

public class practice8_4 {

    public static void main(String[] args) {
//        Solution solution = new Solution();
//
//        int[][] arr = {{1,2}};
//        int[][] arr1 = {{2,1,1},{1,1,0},{0,1,1}};
//        System.out.println(solution.orangesRotting(arr));
//        System.out.println(solution.orangesRotting(arr1));

        List<String> list = new ArrayList<>();
        list.add("hot");
//        list.add("dot");
        list.add("dog");
//        list.add("lot");
//        list.add("log");
//        list.add("cog");
        Solution1 solution1 = new Solution1();
        System.out.println(
                solution1.ladderLength("hot","dog",list));
    }
}

//腐烂的橘子（广度优先搜索）
class Solution {
    class Location {
        int x;
        int y;
        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int orangesRotting(int[][] grid) {
        int[][] arr = {{0,1},{0,-1},{1,0},{-1,0}};
        Queue<Location> queue = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;
        //找到所有腐烂橘子的坐标
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Location(i,j));
                }
            }
        }
        int minTime = 0;
        while (!queue.isEmpty()) {
            int n = queue.size();
            boolean flag = false;
            while (n-- > 0) {
                //判断当前橘子的上下左右是否存在新鲜的橘子
                Location location = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int x = location.x + arr[i][0];
                    int y = location.y + arr[i][1];
                    if (x < 0 || x >= row || y < 0 || y >= col) {
                        continue;
                    }
                    //如果存在新鲜的橘子，则将该新鲜橘子坐标加入队列中，并将值改为2
                    if (grid[x][y] == 1) {
                        flag = true;
                        grid[x][y] = 2;
                        queue.add(new Location(x,y));
                    }
                }
            }
            //如果此次遍历，有将新鲜橘子变为腐烂橘子，次数就加1
            if (flag) {
                minTime++;
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return minTime;
    }
}

//单词接龙
class Solution1 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord) || !wordList.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        List<String> list = new ArrayList<>();
        queue.add(beginWord);
        list.add(beginWord);
        int minLength = 1;
        while (!queue.isEmpty()) {
            int n = queue.size();
            while (n-- > 0) {
                String value = queue.poll();
                for (int i = 0; i < value.length(); i++) {
                    String newValue = value;
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (i == 0) {
                            newValue = j + newValue.substring(i+1);
                        } else if (i == value.length() - 1) {
                            newValue = newValue.substring(0,i) + j;
                        } else {
                            newValue = newValue.substring(0,i) + j
                                    + newValue.substring(i + 1);
                        }
                        if (!wordList.contains(newValue) || list.contains(newValue)) {
                            continue;
                        }
                        if (newValue.equals(endWord)) {
                            return minLength + 1;
                        }
                        list.add(newValue);
                        queue.add(newValue);
                    }
                }
            }
            minLength++;
        }
        return 0;
    }
}

