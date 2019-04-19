package com.wujun.common.thread.chapter5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wujun
 * @description
 * @date 19/4/10.
 */
public class ParallelSearch {
    private static int[] arr = {1, 3, 2, 5, 7, 4, 6, 9, 8};
    private static ExecutorService pool = Executors.newCachedThreadPool();
    private static final int THREAD_NUM = 2;
    private static AtomicInteger result = new AtomicInteger(-1);

    private static class SearchTask implements Callable<Integer> {
        private int begin;
        private int end;
        private int searchValue;

        public SearchTask(int begin, int end, int searchValue) {
            this.begin = begin;
            this.end = end;
            this.searchValue = searchValue;
        }

        @Override
        public Integer call() throws Exception {
            int result = search(searchValue, begin, end);
            return result;
        }
    }

    /**
     * 查询到后返回数组下标
     *
     * @param searchValue
     * @param begin
     * @param end
     * @return
     */
    private static int search(int searchValue, int begin, int end) {
        int i;
        for (i = begin; i < end; i++) {
            if (result.get() >= 0) {
                return result.get();
            }
            if (arr[i] == searchValue) {
                if (!result.compareAndSet(-1, i)) {
                    return result.get();
                }
                return i;
            }
        }
        return -1;
    }

    private static int pSearch(int searchValue) throws ExecutionException, InterruptedException {
        int subArrSize =  arr.length/THREAD_NUM +1;
        List<Future<Integer>> futureList = new ArrayList<>(2);
        for (int i=0;i<arr.length;i+=subArrSize){
            int end = i+subArrSize;
            if (end >arr.length){
                end = arr.length;
            }
            futureList.add(pool.submit(new SearchTask(i,end,searchValue)));
        }
        for (Future<Integer> future : futureList){
            if (future.get()>=0){
                return future.get();
            }
        }
        return  -1;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(pSearch(4));
        pool.shutdown();
    }
}































