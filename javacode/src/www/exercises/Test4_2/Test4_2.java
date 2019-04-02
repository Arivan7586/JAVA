package www.exercises.Test4_2;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Test4_2 {

    public static void testFile() {
        File file = new File("D:"+File.separator +"迅雷下载");
        System.out.println(file);
        File f1 = new File("D:"+File.separator+"迅雷下载"+File.separator
                +"arivan.java");
        if (f1.exists()) {
            boolean rt = f1.delete();
            System.out.println("删除结果："+rt);
        }else {
            try {
                boolean rt =  f1.createNewFile();
                System.out.println("创建结果："+rt);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void testDirectory() {
        File file = new File("D:"+File.separator +"迅雷下载"
        +File.separator+"Arivan"+File.separator+"hello.java");
        System.out.println(file.getParent());
        if (!file.getParentFile().exists()) {
            boolean rt = file.mkdirs();
            System.out.println("创建结果为："+rt);
        }else {
            boolean rt = file.delete();
            System.out.println("删除结果为："+rt);
        }

    }

    /**
     * 递归打印当前目录下所有层级的文件信息
     * @param file
     */
    public static void listAllFiles(File file) {
        if (file.isDirectory()) { //如果给定的对象是目录
            File[] files = file.listFiles(); //继续列出子目录内容
            if (file != null) {
                for (File f : files) {
                    listAllFiles(f);
                }
            }
        }else {
            //给定的File对象是文件，则直接打印
            System.out.println(file.getName());
        }
    }

    public static void testOutputStream(String path) throws IOException {
        Scanner scanner = new Scanner(System.in);
        File file = new File(path);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        OutputStream out = new FileOutputStream(file,true);
        String buff = scanner.nextLine();
        out.write(buff.getBytes());
        out.close();
    }

    public static void testInputStream(String path) throws IOException {
        File file = new File(path);
        if (file.exists()) {
            InputStream in = new FileInputStream(file);
            byte[] data = new byte[1024];
            int len = in.read(data);
            String result = new String(data,0,len);
            System.out.println("读取内容："+result);
            in.close();
        }
    }

    public static void testWriter() throws IOException {
        File file = new File("D:"+File.separator+"迅雷下载"+File.separator
                +"BIBL"+File.separator+"啦啦啦.txt");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
            System.out.println("新建了文件夹！");
        }
        file.createNewFile();
        Writer out = new FileWriter(file,true);
        String buff = "德玛西亚"+File.separator+'\t'+File.separator+"nfsjkanfj";
        out.write(buff);
        out.close();
    }

    public static void testRead() throws IOException {
        File file = new File("D:"+File.separator+"迅雷下载"+File.separator
                +"BIBL"+File.separator+"啦啦啦.txt");
        File f1 = new File("D:"+File.separator+"迅雷下载"+File.separator
                +"BIBL"+File.separator+"哈哈哈.txt");
        if (!f1.exists()) {
            f1.createNewFile();
        }
        if (file.exists()) {
            Reader in = new FileReader(file);
            Writer out = new FileWriter(f1);
            char[] arr = new char[1024];
            in.read(arr);
            for (int i = 0; i < 5; i++) {
                out.write(String.valueOf(arr));
            }

            out.close();
            in.close();
//            int len = in.read(arr);
//            System.out.println(new String(arr,0,len));
        }else {
            System.out.println("路径错误");
        }
    }

    public static void main(String[] args) throws IOException {
        //testFile();
        //testDirectory();
//        String path = "D:"+File.separator+"迅雷下载";
//        File file = new File(path);
//        listAllFiles(file);

//        String path = "D:"+File.separator+"迅雷下载"+File.separator
//                +"啦啦啦.txt";
//        try {
//            testInputStream(path);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        //testWriter();
        testRead();
    }
}

