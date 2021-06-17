package com.fan.basic;

import java.util.PriorityQueue;

/**
 * 中位数 优先队列
 */
public class MedianFinder {
	private PriorityQueue<Integer> queueMax = new PriorityQueue<>((x,y) -> (y-x));//最大堆  1,2,3,4 maxqueue最大值小于minQueue的最小值
	private PriorityQueue<Integer> queueMin = new PriorityQueue<>();//最小堆 5,6,7
	int count ;

	public MedianFinder(){

	}
	public void addNum(int a){
		//自动排序
		count++;
		/*queueMax.offer(a);
		queueMin.add(queueMax.poll());
		// 如果两个堆合起来的元素个数是奇数，小顶堆要拿出堆顶元素给大顶堆
		if ((count & 1) != 0) {
			queueMax.add(queueMin.poll());
		}*/

		if(count % 2 == 0){
			queueMin.add(a);
		}else{
			queueMax.add(a);
		}
		if(!queueMax.isEmpty() && !queueMin.isEmpty() &&  queueMax.peek() > queueMin.peek()){
			int max = queueMax.poll();
			int min = queueMin.poll();
			queueMax.add(min);
			queueMin.add(max);
		}

	}

	public double findMedian(){
		if((count & 1) == 0){
			return (double)(queueMax.peek()+queueMin.peek())/2;
		}
		return (double)queueMax.peek();
	}

	public static void main(String[] args) {
		MedianFinder medianFinder = new MedianFinder();
		//12,4,5,20,2,1
		medianFinder.addNum(12);
		medianFinder.addNum(9);
		medianFinder.addNum(2);
		medianFinder.addNum(13);
		medianFinder.addNum(2);
		medianFinder.addNum(56);
		medianFinder.addNum(1);
		System.out.println("中位数"+medianFinder.findMedian());
		while(!medianFinder.queueMax.isEmpty()){
			System.out.println(medianFinder.queueMax.poll());

		}
		System.out.println("-------------");
		while (!medianFinder.queueMin.isEmpty()){
			System.out.println(medianFinder.queueMin.poll());

		}

	}

}
