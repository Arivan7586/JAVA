package www.exercises.Test4_2;

import java.io.*;
import java.sql.Time;
import java.util.Date;


public class FileCopyUtil {
    //工具类方法，所以将构造方法私有化
    private FileCopyUtil(){}

    /**
     * 将sourceFilePath地址的文件拷贝到destFilepath路径中
     * @param sourceFilePath 拷贝的源文件路径
     * @param destFilepath //目标路径
     * @throws IOException
     */
    public static void cp(String sourceFilePath, String destFilepath) throws IOException {
        checkArgumentNotEmpty(sourceFilePath,"源路径不能为空");
        checkArgumentNotEmpty(destFilepath,"目标路径不能为空");
        File sourceFile = new File(sourceFilePath);
        File destFile = new File(destFilepath);
        checkFile(sourceFile,"原文件不存在、无法进行拷贝");
        checkAndMkParentFile(destFile,"路径不能为空");
        dataCopy(sourceFile,destFile);
    }

    /**
     * 执行具体的拷贝过程
     * @param source 源文件
     * @param dest 目标文件
     * @throws IOException
     */
    private static void dataCopy(File source, File dest) throws IOException {
        long start = System.currentTimeMillis();
        InputStream in = new FileInputStream(source);
        OutputStream out = new FileOutputStream(dest,true);
        byte[] arr = new byte[1024*2];

        int len = 0;
        while ((len = in.read(arr)) != -1) {
            out.write(arr,0,len);
        }
        in.close();
        out.close();
        long end = System.currentTimeMillis();
        System.out.println("拷贝文件共用时："+(end-start));
    }

    /**
     * 检查传入的参数是否为空
     * @param args 传入的参数
     * @param msg 如果传入的参数为空，则抛出该错误
     */
    private static void checkArgumentNotEmpty(Object args, String msg) {
        if (args == null || String.valueOf(args).length() < 1) {
            throw new IllegalStateException(msg);
        }
    }

    /**
     * 检查源文件是否存在
     * @param file 源文件
     * @param msg 不存在时，扔出该异常
     */
    private static void checkFile(File file, String msg) {
        if (file == null || !file.exists()) {
            throw new IllegalStateException(msg);
        }
    }

    /**
     * 检查目标文件是否存在
     * @param file 目标文件
     * @param msg 如果不存在，则扔出此异常
     * @throws IOException
     */
    private static void checkAndMkParentFile(File file, String msg) throws IOException {
        if (file == null) {
            throw new IllegalStateException(msg);
        }else if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
    }


    public static void main(String[] args) throws IOException {
        //源文件路径
        String path1 = "D:\\迅雷下载\\冰与火之歌 权力的游戏 第二季\\Game.of.Thrones.S02E01.2012.BluRay.1080p.HEVC.AC3.中英特效.mp4";
        //目标文件路径
        String path2 = "D:\\迅雷下载"+File.separator+"MMM"+File.separator+"AAA.mp4";
        //FileCopyUtil.cp(path1,path2);
    }
}
