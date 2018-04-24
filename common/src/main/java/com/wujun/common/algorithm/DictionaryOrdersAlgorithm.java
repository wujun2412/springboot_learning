package com.wujun.common.algorithm;

import java.util.Arrays;

/**
 * @author wujun
 * @description 字典序算法
 * 主流程，返回最近一个大于自身的相同数字组成的整数。
 * 如：12345 ->12354
 *    12354 ->12435
 * 步骤：
 * 1.从后向前查看逆序区域，找到逆序区域的前一位，也就是数字置换的边界
 * 2.把逆序区域的前一位和逆序区域中刚刚大于它的数字交换位置
 * 3.把原来的逆序区域转为顺序
 * @date 18/4/10.
 */
public class DictionaryOrdersAlgorithm {

    public static void main(String[] args) {
        int[] numbers = new int[]{1,2,5,4,3};

        outPutNumbers(findNearestNumber(numbers));
        //System.out.println(findNearestNumber(numbers));


    }

    private static void outPutNumbers(int[]numbers){
        for (int i:numbers){
            System.out.print(i);
        }
        System.out.println();
    }

    private static int[] findNearestNumber(int[] numbers){
        //拷贝入参，避免直接修改入参
        int[] numbersCopy = Arrays.copyOf(numbers,numbers.length);
        //1.从后向前查看逆序区域，找到逆序区域的前一位，也就是数字置换的边界
        int index = findTransferPoint(numbersCopy);
        //如果数字置换边界是0，说明整个数组已经逆序，无法得到更大的相同数字组成的整数，返回自身
        if(index==0){
            return numbersCopy;
        }
        //2.把逆序区域的前一位和逆序区域中刚刚大于它的数字交换位置
        exchangeHead(numbersCopy,index);
        //3.把原来的逆序区域转为顺序
        reverse(numbersCopy,index);

        return numbersCopy;
    }

    private static int[]reverse(int[] numbers,int index){
        for (int i =index,j=numbers.length-1;i<j;i++,j--){
            int temp = numbers[i];
            numbers[i]=numbers[j];
            numbers[j]=temp;
        }
        return numbers;
    }

    private static int[] exchangeHead(int[] numbers,int index){
        int head = numbers[index -1];
        for (int i = numbers.length -1; i >0 ; i--) {
            if (head<numbers[i]){
                numbers[index -1]= numbers[i];
                numbers[i]= head;
                break;
            }
        }
        return numbers;
    }


    private static int findTransferPoint(int[] numbersCopy) {
        for (int i = numbersCopy.length-1; i >0 ; i--) {
            if (numbersCopy[i] > numbersCopy[i-1]){
                return i;
            }
        }
        return 0;
    }




}
