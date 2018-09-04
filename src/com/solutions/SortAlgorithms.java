package com.solutions;

/**
 * 常见排序算法实现
 * */
public class SortAlgorithms {

	public static void main(String[] args) {
		int[] arr = { 55, 11, 655, 92, 4, 10, 1, 9, 31, 7 };

		SortAlgorithms ob = new SortAlgorithms();
		int[] result;
		// result = ob.insertion_sort(arr);
		// result = ob.shell_sort(arr);
		// result = ob.selection_sort(arr);
		// result = ob.bubble_sort(arr);
		// result = ob.quick_sort(arr);
		// result = ob.heap_sort(arr);
		// result = ob.merge_sort(arr);
//		 result = ob.counting_sort(arr);
		result = ob.radix_sort(arr, ob.getMaxDigit(arr, arr.length));
		ob.printArray(result);

	}

	private void printArray(int[] arr) {
		for (int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

	/*
	 * insertion sort Insertion sort is a simple sorting algorithm that works the
	 * way we sort playing cards in our hands.
	 * 遍历数组，遍历到i时，a0,a1...ai-1是已经排好序的，取出ai，从ai-1开始向前和每个比较大小，如果小于，
	 * 则将此位置元素向后移动，继续先前比较，如果不小于，则放到正在比较的元素之后。可见相等元素比较是， 原来靠后的还是拍在后边，所以插入排序是稳定的。
	 */
	int[] insertion_sort(int a[]) {
		int n = a.length;
		for (int i = 1; i < n; i++) {
			int v = a[i];
			int j = i - 1;
			while (j >= 0 && a[j] > v) {
				a[j + 1] = a[j];
				j--;
			}
			a[j] = v;
		}
		return a;
	}

	/*
	 * shell sort 希尔排序也是一种插入排序，它是简单插入排序经过改进之后的一个更高效的版本，也称为缩小增量排序.
	 * 希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；随着增量逐渐减少，
	 * 每组包含的关键词越来越多，当增量减至1时，整个文件恰被分成一组，算法便终止
	 */
	public int[] shell_sort(int[] arr) {
		// 增量gap，并逐步缩小增量
		for (int gap = arr.length / 2; gap > 0; gap = gap / 2) {
			// 从第gap个元素，逐个对其所在组进行直接插入排序操作
			for (int i = gap; i < arr.length; i++) {
				int j = i;
				int temp = arr[j];
				while (j - gap >= 0 && temp < arr[j - gap]) {
					// 移动法
					arr[j] = arr[j - gap];
					j -= gap;
				}
				arr[j] = temp;
			}
		}
		return arr;
	}

	/*
	 * selection sort The selection sort algorithm sorts an array by repeatedly
	 * finding the minimum element (considering ascending order) from unsorted part
	 * and putting it at the beginning. The algorithm maintains two subarrays in a
	 * given array. 1) The subarray which is already sorted. 2) Remaining subarray
	 * which is unsorted.
	 */
	int[] selection_sort(int a[]) {
		int n = a.length;
		for (int i = 0; i < n - 1; i++) {
			int pos = i;
			for (int j = i + 1; j < n; j++) {
				if (a[j] < a[pos]) {
					pos = j;
				}
			}
			int temp = a[pos];
			a[pos] = a[i];
			a[i] = temp;
		}
		return a;
	}

	/*
	 * 冒泡排序的名字很形象，实际实现是相邻两节点进行比较，大的向后移一个，经过第一轮两两比较和移动，
	 * 最大的元素移动到了最后，第二轮次大的位于倒数第二个，依次进行。这是最基本的冒泡排序，还可以进行一些优化。
	 * 如果某一轮两两比较中没有任何元素交换，这说明已经都排好序了，算法结束，可以使用一个Flag做标记，默认为false，
	 * 如果发生交互则置为true，每轮结束时检测Flag，如果为true则继续，如果为false则返回。
	 */

	int[] bubble_sort(int[] a) {
		int n = a.length;
		boolean swapped;
		for (int i = 0; i < n - 1; i++) {
			swapped = false;
			for (int j = 0; j < n - 1 - i; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					swapped = true;
				}
			}
			if (swapped == false)
				break;
		}
		return a;
	}

	int[] quick_sort(int[] a) {
		quick_sort(a, 0, a.length - 1);
		return a;
	}

	void quick_sort(int[] a, int left, int right) {
		if (left < right) {
			int pi = partition(a, left, right);
			quick_sort(a, left, pi - 1); // 对基准元素左边的元素进行递归排序
			quick_sort(a, pi + 1, right); // 对基准元素右边的进行递归排序
		}
	}

	// 快速排序联想成东拆西补或西拆东补，一边拆一边补，直到所有元素达到有序状态。
	// 快速排序 - 挖坑法
	int partition(int[] a, int left, int right) {
		int pivot = a[left]; // 选取一个第一个数作为枢轴
		while (left < right) { // 从左右两边交替扫描，直到left = right
			while (left < right && a[right] >= pivot) {
				right--; // 从右往左扫描，找到第一个比基准元素小的元素
			}
			a[left] = a[right];// 找到这种元素a[right]后与a[left]交换

			while (left < right && a[left] <= pivot) {
				left++; // 从左往右扫描，找到第一个比基准元素大的元素
			}
			a[right] = a[left]; // 找到这种元素a[left]后，与a[right]交换
		}
		a[left] = pivot; // 基准元素归位, 此时left == right
		return left;
	}

	/*
	 * 堆排序 作为选择排序的改进版，堆排序可以把每一趟元素的比较结果保存下来，以便我们在选择最小/大元素时对已经比较过的元素做出相应的调整。
	 * 堆排序是一种树形选择排序，在排序过程中可以把元素看成是一颗完全二叉树，每个节点都大（小）于它的两个子节点，当每个节点都大于等于它的两个子节点时，
	 * 就称为大顶堆，也叫堆有序； 当每个节点都小于等于它的两个子节点时，就称为小顶堆。 算法思想(以大顶堆为例)：
	 * 1.将长度为n的待排序的数组进行堆有序化构造成一个大顶堆 2.将根节点与尾节点交换并输出此时的尾节点 3.将剩余的n -1个节点重新进行堆有序化
	 * 4.重复步骤2，步骤3直至构造成一个有序序列
	 * 
	 */

	private int[] heap_sort(int[] arr) {
		int n = arr.length;
		for (int i = n / 2 - 1; i >= 0; i--) { // 堆构造
			heapAdjust(arr, i, n);
		}
		while (n - 1 >= 0) { // 节点的index从0到n-1
			swap(arr, 0, n - 1); // 将堆顶元素与尾节点交换后，长度减1，尾元素最大
			n--;
			heapAdjust(arr, 0, n); // 再次对堆进行调整
		}
		return arr;
	}

	public void heapAdjust(int[] arr, int i, int n) {
		int left, right, j;
		while ((left = 2 * i + 1) < n) { // 判断当前父节点有无左节点（即有无孩子节点，left为左节点）
			j = left; // j"指针指向左节点"
			right = left + 1; // 右节点
			if (right < n) { // 考虑没有右节点的情况
				if (j < n && arr[left] < arr[right]) // 右节点大于左节点
					j++; // 当前把"指针"指向右节点
			}

			if (arr[i] < arr[j]) // 将父节点与孩子节点交换（如果上面if为真，则arr[j]为右节点，如果为假arr[j]则为左节点）
				swap(arr, i, j);
			else // 说明比孩子节点都大，直接跳出循环语句
				break;
			i = j;
		}
	}

	public void swap(int[] arr, int i, int len) {
		int temp = arr[i];
		arr[i] = arr[len];
		arr[len] = temp;
	}

	/*
	 * Merge Sort Like QuickSort, Merge Sort is a Divide and Conquer algorithm. It
	 * divides input array in two halves, calls itself for the two halves and then
	 * merges the two sorted halves. The merge() function is used for merging two
	 * halves.
	 */
	public int[] merge_sort(int[] arr) {
		int[] temp = new int[arr.length];// 在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
		merge_sort(arr, 0, arr.length - 1, temp);
		return arr;
	}

	private void merge_sort(int[] arr, int left, int right, int[] temp) {
		if (left < right) {
			int mid = (left + right) / 2;
			merge_sort(arr, left, mid, temp);// 左边归并排序，使得左子序列有序
			merge_sort(arr, mid + 1, right, temp);// 右边归并排序，使得右子序列有序
			merge(arr, left, mid, right, temp);// 将两个有序子数组合并操作
		}
	}

	private void merge(int[] arr, int left, int mid, int right, int[] temp) {
		int i = left;// 左序列指针
		int j = mid + 1;// 右序列指针
		int t = 0;// 临时数组指针
		while (i <= mid && j <= right) {
			if (arr[i] <= arr[j]) {
				temp[t++] = arr[i++];
			} else {
				temp[t++] = arr[j++];
			}
		}
		while (i <= mid) {// 将左边剩余元素填充进temp中
			temp[t++] = arr[i++];
		}
		while (j <= right) {// 将右序列剩余元素填充进temp中
			temp[t++] = arr[j++];
		}
		t = 0;
		// 将temp中的元素全部拷贝到原数组中
		while (left <= right) {
			arr[left++] = temp[t++];
		}
	}

	/*
	 * counting sort 在给定的一组序列中，先找出该序列中的最大值和最小值，从而确定需要开辟多大的辅助空间，每一个数在对应的辅助空间中都有唯一的下标。
	 * 找出序列中最大值和最小值，开辟Max-Min+1的辅助空间 最小的数对应下标为0的位置，遇到一个数就给对应下标处的值+1,。
	 * 遍历一遍辅助空间，就可以得到有序的一组序列
	 */
	int[] counting_sort(int[] arr) {

		int max = arr[0];// 序列中的最大值
		int min = arr[0];// 序列中的最小值
		for (int i = 0; i < arr.length; ++i) {
			if (arr[i] >= max) {
				max = arr[i];
			} else if (arr[i] < min) {
				min = arr[i];
			}
		}
		int range = max - min + 1;// 需要开辟的空间大小
		int count[] = new int[range];
		for (int i = 0; i < arr.length; i++) {
			count[arr[i] - min]++; // //array[i]-min是将该数对应到辅助空间的下标
		}

		// sort the arr and output it to result array.
		int[] result = new int[arr.length];
		int t = 0;
		for (int i = 0; i < count.length; i++) { // //遍历辅助空间
			for (int j = 0; j < count[i]; j++) { // 下标处的数值是几，说明该数出现了几次
				result[t++] = i + min; // 将下标处的数对应回原数组
			}
		}

		return result;
	}
	
	
	/*
	 * Bucket Sort
	 * 桶排序(Bucket Sort)假设输入数据服从均匀分布，然后将输入数据均匀地分配到有限数量的桶中，然后对每个桶再分别排序，
	 * 对每个桶再使用插入排序算法，最后将每个桶中的数据有序的组合起来。前面了解到基数排序假设输入数据属于一个小区间内的整数，
	 * 而桶排序则是假设输入是由一个随机过程生成，该过程将元素均匀的分布在一个区间[a,b]上。
	 * 由于桶排序和计数排序一样均对输入的数据进行了某些假设限制，因此比一般的基于比较的排序算法复杂度低。
	 * 桶排序过程:
	 * 1.初始化装入连续区间元素的n个桶，每个桶用来装一段区间中的元素。
	 * 2.遍历待排序的数据，将其映射到对应的桶中，保证每个桶中的元素都在同一个区间范围中。
	 * 3.对每个桶进行排序，最终将所有桶中排好序的元素连起来。
	 * 计数排序是桶排序的一个特例，一个数据一个桶
	 * */
	private class Node {
        int key;
        Node next;
    }
 
    public void bucket_sort(int arr[], int bucketsize) {
        int size = arr.length;
        Node[] bucket_table = new Node[bucketsize];
        for (int i = 0; i < bucketsize; i++) {
            bucket_table[i] = new Node();
            bucket_table[i].key = 0;//链表第一个节点的key记录当前桶中的数据量
            bucket_table[i].next = null;
        }
 
        for (int j = 0; j < size; j++) {
            Node node = new Node();
            node.key = arr[j];
            node.next = null;
            int index = arr[j] / 10;   //计算各元素放入对应桶的编号  自行定义规则
            Node p = bucket_table[index];
            if (p.key == 0) {
                bucket_table[index].next = node;
                bucket_table[index].key++;
            } else {
                //链表插入排序
                while (p.next != null && p.next.key <= node.key) p = p.next;
                node.next = p.next;
                p.next = node;
                bucket_table[index].key++;
            }
        }
        //输出排序结果
        for (int b = 0; b < bucketsize; b++) {
            for (Node a = bucket_table[b].next; a != null; a = a.next) {
                System.out.print(a.key + " ");
            }
        }
    }
    
    /*
     * Radix Sort
     * 基数排序是对桶排序的一种改进，这种改进是让“桶排序”适合于更大的元素值集合的情况，而不是提高性能。
     * 我们先看看扑克牌的例子。一张牌有两个关键字组成：花色(桃<心<梅<方)+面值(2<3<4<...<A)。假如一张牌的大小首先被花色决定，同花色的牌有数字决定的话。我们就有两种算法来解决这个问题。
     * (1) 首先按照花色对所有牌进行稳定排序，这样就可以将所有牌分成4组。然后同组的牌(同花色)再按照面值进行排序。
     * (2) 首先按照面值对所有牌进行稳定排序，然后按照花色再次对所有牌进行稳定排序。
     * 在这里的第二种方法就是基数排序！————也就是从最次的关键字开始排序，再从第二次的关键字排序，过程中参考第一次排序后元素间的相对顺序，以此类推直到最高关键字参考了次高关键的顺序而排序完成，排序结束。

     * 比如字符串“abcd” “aesc” "dwsc" "rews"就可以把每个字符看成一个关键字。另外还有整数 425、321、235、432也可以每个位上的数字为一个关键字。
     * */
    
    /* 参数含义分别为：待排序数组；待排序数组首元素下标；待排序数组末元素下标；数组元素最大的位数，此处假设最大是百位数（3位数） */
	int[] radix_sort(int arry[], int digitLen) {
		int size = arry.length;
		int radix = 10; // 基数
		int i = 0, j = 0;
		int[] count = new int[radix]; // 存放各个桶的数据统计个数,即同一位上数字相等的数字个数
		int[] start = new int[radix]; // 按位上数字所对应的起始位置
		int[] assit = new int[size];

		// 按照从低位到高位的顺序执行排序过程
		for (int d = 1; d <= digitLen; d++) {

			// 置空各个桶的数据统计
			for (i = 0; i < radix; i++)
				count[i] = 0;

			// 统计各个桶将要装入的数据个数
			for (i = 0; i < size; i++) {
				j = getDigit(arry[i], d);
				count[j]++;
			}

			// 排序后各个数字起始位置索引
			for (i = 0; i < radix; i++) {
				if (i == 0) {
					start[i] = 0;
				} else {
					start[i] = start[i - 1] + count[i - 1];
				}
			}
			
			// 将数据依次装入桶中
			for (i = 0; i < size; i++)
			  {
				j = getDigit(arry[i], d); // 求出关键码的第k位的数字， 例如：576的第3位是5
				assit[start[j]++] = arry[i]; // 放入对应的桶中
			  }

			// 将已分配好的桶中数据再倒出来，此时已是对应当前位数有序的表
			for (i = 0, j = 0; i < size; i++, j++)
				arry[i] = assit[j];
		}
			return arry;
	}

	/* 获取x这个数的第d位数上的数字,比如获取123的第1位数,结果返回3 */
	int getDigit(int x, int d) {
		return (x / (int)Math.pow(10, d-1)) % 10;
	}

	int getMaxDigit(int[] a, int size)// 取数组中最大值的位数
	{
		int num = 0; // 特殊： 数字0的位数是0
		int count = 1;
		for (int i = 0; i < size; i++) {
			while ((int)(a[i] / count) > 0) {
				count *= 10;
				num++;
			}
		}
		return num;
	}

}
