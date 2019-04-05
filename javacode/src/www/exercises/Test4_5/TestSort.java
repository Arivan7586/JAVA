package www.exercises.Test4_5;

public class TestSort {

    /**
     * 冒泡排序
     * @param arr 待排序数组
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            boolean falg = false;
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    falg = true;
                }
            }
            if (!falg) {
                break;
            }
        }
    }

    /**
     * 选择排序
     * @param arr 待排序数组
     */
    public static void chooseSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * 插入排序
     * @param arr 待排序数组
     */
    public static void insertSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        for (int i = 1; i < n; i++) {
            int value = arr[i];
            int j = i - 1;
            while (j >= 0) {
                if (value < arr[j]) {
                    arr[j+1] = arr[j];
                    j--;
                }else {
                    break;
                }
            }
            arr[j+1] = value;
        }
    }

    /**
     * 折半插入排序
     * @param arr 待排序数组
     */
    public static void binaryInsertSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        for (int i = 1; i < n; i++) {
            int value = arr[i];
            int l = 0;
            int r = i - 1;
            while (r >= l) {
                int mid = l + (r-l)/2;
                if (value > arr[mid]) {
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }
            }
            int k = i - 1;
            while (k > r) {
                arr[k+1] = arr[k];
                k--;
            }
            arr[k+1] = value;
        }
    }

    /**
     * 归并排序
     * @param arr 待排序数组
     */
    public static void mergeSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        mergeMethod(arr,0,n-1);
    }

    /**
     * 将数组分为近乎等长的两部分，然后在按照升序合并
     * @param arr 待分数组
     * @param l 数组最左边元素下标
     * @param r 数组最右边元素下标
     */
    public static void mergeMethod(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r-l)/2;
        mergeMethod(arr,l,mid);
        mergeMethod(arr,mid+1,r);
        if (arr[mid] >= arr[mid+1]) {
            merge(arr,l,mid,r);
        }
    }

    /**
     * @param arr 将给定数组按照升序组合成起来
     */
    public static void merge(int[] arr, int l, int mid, int r) {
        int[] array = new int[r-l+1];
        int i = l;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= r) {
            if (arr[i] < arr[j]) {
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
        for (int m = 0; m < array.length; m++) {
            arr[l+m] = array[m];
        }
    }

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
        int midIndex = findMidIndex3(arr,l,r);
        quickSortInternal(arr,l,midIndex-1);
        quickSortInternal(arr,midIndex+1,r);
    }
    public static int findMidIndex1(int[] arr, int l, int r) {
        int randomIndex = (int) (Math.random()*(r-l+1) + l);
        swap(arr,l,randomIndex);
        int value = arr[l];
        int i = l + 1;
        int j = l;
        while (i <= r) {
            if (arr[i] < value) {
                swap(arr,i,j+1);
                j++;
            }
            i++;
        }
        swap(arr,l,j);
        return j;
    }
    public static int findMidIndex2(int[] arr, int l, int r) {
        int randomIndex = (int)Math.random()*(r-l+1) + l;
        swap(arr,l,randomIndex);
        int value = arr[l];
        int i = l + 1;
        int j = r;
        while (true) {
            while (i <= r && arr[i] < value) {
                i++;
            }
            while (j >= l+1 && arr[j] > value) {
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
    public static int findMidIndex3(int[] arr, int l, int r) {
        int randomIndex = (int)Math.random()*(r-l+1) + l;
        swap(arr,l,randomIndex);
        int value = arr[l];
        int i = l + 1;
        int j = l;
        int k = r + 1;
        while (i < k) {
            if (arr[i] < value) {
                swap(arr,i,l+1);
                i++;
                j++;
            }else if (arr[i] > value) {
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

    public static void main(String[] args) {
        int[] arr = new int[]{2,4,9,0,3,6,7,1,5};
        //bubbleSort(arr);
        //chooseSort(arr);
        //insertSort(arr);
        //binaryInsertSort(arr);
        mergeSort(arr);
        //quickSort(arr);
        print(arr);

    }

    public static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
