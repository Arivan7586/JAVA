package Test7_31;

public class practice7_31 {

    public static void main(String[] args) {

        int[] arr = new int[]{5,7,4,3,9,0,2,8,1,6};
        print(arr);
//        Sort.heapSort(arr);

//        Sort.shellSort(arr);

//        Sort.insertSort(arr);

//        Sort.chooseSort(arr);

//        Sort.bubbleSort(arr);
//        print(arr);

        TestList.ListNode l1 = new TestList.ListNode(1);
        TestList.ListNode l2 = new TestList.ListNode(2);
        TestList.ListNode l3 = new TestList.ListNode(3);
        TestList.ListNode l4 = new TestList.ListNode(4);
        TestList.ListNode l5 = new TestList.ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        TestList.ListNode node = TestList.reverseList(l1);

        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();


    }
    private static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}


class Sort {
    //堆排序
    public static void heapSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        //1.将数组变为大顶堆
        for (int i = (n - 2) / 2; i >= 0; i--) {
            siftDown(arr,n,i);
        }

        for (int i = n - 1; i >= 0; i--) {
            swap(arr,i,0);
            siftDown(arr,i,0);
        }
    }

    /**
     * 元素下沉操作
     * @param arr 下沉数组
     * @param n 下沉数组的元素个数
     * @param index 待下沉元素的下标
     */
    private static void siftDown(int[] arr, int n, int index) {
        while (2 * index + 1 < n) {
            int i = 2 * index + 1;
            if (i + 1 < n) {
                if (arr[i] < arr[i+1]) {
                    i++;
                }
            }
            if (arr[index] > arr[i]) {
                return;
            }
            swap(arr,i,index);
            index = i;
        }
    }
    //交换元素
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //希尔排序
    public static void shellSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        for (int i = n - 1; i >= 1; i /= 2) {
            for (int j = i; j < n; j++) {
                int value = arr[j];
                int k = j - i;
                while (k >= 0) {
                    if (value < arr[k]) {
                        arr[k+i] = arr[k];
                        k -= i;
                    } else {
                        break;
                    }
                }
                arr[k + i] = value;
            }
        }
    }

    //插入排序
    public static void insertSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        for (int i = 1; i < n; i++) {
            int value = arr[i];
            int j = i - 1;
            while (j >= 0) {
                if (arr[j] > value) {
                    arr[j+1] = arr[j];
                    j--;
                } else {
                    break;
                }
            }
            arr[j + 1] = value;
        }
    }

    //选择排序
    public static void chooseSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr,i,j);
                }
            }
        }
    }

    //冒泡排序
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr,j,j+1);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

}

class TestList {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    //翻转链表
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode f = head;
        ListNode s = f.next;
        while (s != null ) {
            f.next = s.next;
            s.next = dummyHead.next;
            dummyHead.next = s;
            s = f.next;
        }
        return dummyHead.next;
    }
}
