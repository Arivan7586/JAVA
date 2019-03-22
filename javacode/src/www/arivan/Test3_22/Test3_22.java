package www.arivan.Test3_22;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test3_22 {
    public static void main(String[] args) {
//        Computer computer = ComputerFactory.getInstance("www.arivan.Test3_22.LenevoImpl");
//        computer.buyComputer();

        //取得类的父类
        Class<?> a = E.class;
        //取得包的名字
        System.out.println(a.getPackage().getName());
        //取得父类名称
        System.out.println(a.getSuperclass().getName());
        //取得父接口的个数
        System.out.println(a.getInterfaces().length);
        //取得所有的父接口
        Class<?>[] arr = a.getInterfaces();
        for (Class<?> o : arr) {
            System.out.println(o);
        }

        //取得类中所有的构造方法
//        Constructor<?>[] arr = A.class.getDeclaredConstructors();
//        for (Constructor<?> constructor : arr) {
//            System.out.println(constructor);
//        }

        try {
            //取得单个指定参数的构造方法
            Constructor<?> constructor = A.class.getDeclaredConstructor(String.class,int.class);
            constructor.newInstance("小黑",20);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
//
//        //取得无参构造
//        Constructor<?> a = null;
//        try {
//            a = A.class.getDeclaredConstructor();
//            System.out.println(a);
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }

        int[] array = new int[]{1,4,7,5,0,3,4,9};
        //Sorting.insertSort(array);
        //Sorting.mergeSort(array);
        Sorting.quickSort(array);
        for (int i : array) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}


//传统简单工厂模式
interface Computer {
    void buyComputer();
}

class MacBookImpl implements Computer {

    @Override
    public void buyComputer() {
        System.out.println("买一台苹果电脑");
    }
}

class SurfaceBookImpl implements Computer {

    @Override
    public void buyComputer() {
        System.out.println("买一台surfaceBook");
    }
}

class LenevoImpl implements Computer {

    @Override
    public void buyComputer() {
        System.out.println("买一台联想电脑");
    }
}

//通过反射获取
class ComputerFactory {
    private ComputerFactory() {}
    public static Computer getInstance(String computerName) {
        Computer computer = null;
        try {
            computer = (Computer) Class.forName(computerName).
                    getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return computer;
    }
}

class A {
    public A(String string) {
        System.out.println(string);
    }

    public A(String str, int age) {
        System.out.println(str + age+"岁");
    }
    private A() {
        System.out.println("无参构造");
    }
}

interface B {}

interface C {}

interface D {}

class E implements B,C,D {

}

//复习归并排序和快速排序
class Sorting {
    //插入排序
    public static void insertSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        for (int i = 1; i < n; i++) {
            int val = arr[i];
            int j = i-1;
            for (; j>= 0; j--) {
                if (val < arr[j]) {
                    arr[j+1] = arr[j];
                }else {
                    break;
                }
            }
            arr[j+1] = val;
        }
    }

    //归并排序
    public static void mergeSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        mergeInternal(arr,0,n-1);
    }
    public static void mergeInternal(int[] arr, int l, int r) {
        if (r - l <= 15) {
            insertSort(arr);
            return;
        }
        int mid = l + (r - l)/2;
        mergeInternal(arr,l,mid);
        mergeInternal(arr,mid+1,r);
        if (arr[mid] >= arr[mid+1]) {
            merge(arr,l,mid,r);
        }
    }
    public static void merge(int[] arr, int l, int mid, int r) {
        int[] array = new int[r-l+1];
        int i = l;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= r) {
            if (arr[i] <= arr[j]) {
                array[k++] = arr[i++];
            }else {
                array[k++] = arr[j++];
            }
        }
        int start = i;
        int end = mid;
        if (j <= r) {
            start = j;
            end = r;
        }
        while (start <= end) {
            array[k++] = arr[start++];
        }
        for (i = 0; i <= r-l; i++) {
            arr[l+i] = array[i];
        }
    }

    //快速排序
    public static void quickSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        quickSortInternal(arr,0,n-1);
    }
    public static void quickSortInternal(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int value = partition3(arr,l,r);
        quickSortInternal(arr,l,value-1);
        quickSortInternal(arr,value+1,r);
    }
    public static int partition1(int[] arr, int l, int r) {
        int randomIndex = (int) (Math.random()*(r-l+1)) + l;
        swap(arr,l,randomIndex);
        int val = arr[l];
        int i = l + 1;
        int j = l;
        while (i <= r) {
            if (arr[i] < val) {
                swap(arr,i,j+1);
                j++;
            }
            i++;
        }
        swap(arr,l,j);
        return j;
    }
    //二路快排
    public static int partition2(int[] arr, int l, int r) {
        int randomIndex = (int) (Math.random()*(r-l+1)) + l;
        swap(arr,l,randomIndex);
        int val = arr[l];
        int i = l + 1;
        int j = r;
        while (true) {
            while (i <= r && arr[i] < val) {
                i++;
            }
            while (j >= l+1 && arr[j] > val) {
                j--;
            }
            if (i > j) {
                break;
            }
            swap(arr,i,j);
            i++;
            j--;
        }
        swap(arr,l,j);
        return j;
    }
    //三路快排
    public static int partition3(int[] arr, int l, int r) {
        int randomIndex = (int) (Math.random()*(r-l+1)) + l;
        swap(arr,l,randomIndex);
        int val = arr[l];
        int i = l + 1;
        int j = l;
        int k = r + 1;
        while (i < k) {
            if (arr[i] < val) {
                swap(arr,i,j+1);
                j++;
                i++;
            }else if (arr[i] > val) {
                swap(arr,i,k-1);
                k--;
            }else {
                i++;
            }
        }
        swap(arr,l,j);
        return j;
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}