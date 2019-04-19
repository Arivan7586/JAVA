package www.exercises.Test4_19;

import java.io.*;
import java.util.Scanner;

public class Test4_19 {
    public static void main(String[] args) {
        //CopyFiles.copyFile();

        Solution solution = new Solution();
        System.out.println(solution.peakIndexInMountainArray(new int[]{0,1,0}));
        System.out.println(solution.peakIndexInMountainArray1(new int[]{0,2,1,0}));
    }
}

class CopyFiles {
    private CopyFiles(){}
    /**
     * 用户输入复制操作的源文件路径和目标路径
     * @return 返回输入的路径
     */
    private static String[] enterPath() {
        String[] path = new String[2];
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入源文件路径：");
        path[0] = scanner.nextLine();
        System.out.println("请输入目标路径：");
        path[1] = scanner.nextLine();
        return path;
    }

    /**
     * 文件拷贝的主方法，使用时，调用该方法即可。
     */
    public static void copyFile() {
        String[] path = enterPath();
        String sourse = path[0];
        String target = path[1];
        checkSourseFile(sourse);
        checkTargetFile(target);
        File sourseFile = new File(sourse);
        File targetFile = new File(target);
        long start = System.currentTimeMillis();
        copy(sourseFile,targetFile);
        long end = System.currentTimeMillis();
        System.out.println("文件拷贝成功！"+"耗时"+(end-start)+"毫秒");
    }

    /**
     * 验证源文件路径是否正确
     * @param path 源文件路径
     */
    private static void checkSourseFile(String path) {
        if (path == null) {
            throw new NullPointerException("源文件路径不能为空");
        }
        File file = new File(path);
        if (!file.exists()) {
            throw new NullPointerException("该路径下，源文件不存在！");
        }
    }

    /**
     * 检查目标文件夹是否存在，如果不存在，就创建文件夹
     * @param path 目标文件路径
     */
    private static void checkTargetFile(String path) {
        if (path == null) {
            throw new NullPointerException("目标文件路径不能为空");
        }
        File file = new File(path);
        if (!file.getParentFile().exists()) {
            System.out.println("目标路径不存在，正在新建路径！");
            file.getParentFile().mkdirs();
        }
    }

    /**
     * 执行真正的复制操作
     * @param sourse 源文件
     * @param target 目标文件
     */
    private static void copy(File sourse, File target) {
        System.out.println("开始拷贝文件");
        FileInputStream input = null;
        FileOutputStream output = null;
        try {
            input = new FileInputStream(sourse);
            output = new FileOutputStream(target);
            byte[] data = new byte[1024];
            int len = 0;
            while ((len = input.read(data)) != -1) {
                output.write(data,0,len);
            }
            input.close();
            output.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Solution {
    /**
     * 山脉数组的峰顶索引
     * @param A 山脉数组
     * @return 返回索引
     */
    public int peakIndexInMountainArray(int[] A) {
        for (int i = 1; i < A.length-1; i++) {
            if (A[i] > A[i-1] && A[i] > A[i+1]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 优化版查找最大值 （二分查找）
     * @param A 山峰数组
     * @return 返回索引
     */
    public int peakIndexInMountainArray1(int[] A) {
        int l = 1;
        int r = A.length - 2;
        while (r >= l) {
            int mid = l + (r-l)/2;
            if (A[mid] < A[mid+1]) {
                l = mid + 1;
            }else if (A[mid] < A[mid-1]) {
                r = mid - 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}