package com.xjj.util;

import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * 随机数工具，单例模式
 * @author XuJijun
 *
 */
public class RandomUtils {
	private static Random random;

	//双重校验锁获取一个Random单例
	public static Random getRandom() {
		if(random==null){
			synchronized (RandomUtils.class) {
				if(random==null){
					random =new Random();
				}
			}
		}
		
		return random;
	}

	/**
	 * 获得一个[0,max)之间的整数。
	 * @param max
	 * @return
	 */
	public static int getRandomInt(int max) {
		return Math.abs(getRandom().nextInt())%max;
	}
	
	/**
	 * 获得一个[0,max)之间的整数。
	 * @param max
	 * @return
	 */
	public static long getRandomLong(long max) {
		return Math.abs(getRandom().nextInt())%max;
	}
	
	/**
	 * 从list中随机取得一个元素
	 * @param list
	 * @return
	 */
	public static <E> E getRandomElement(List<E> list){
		return list.get(getRandomInt(list.size()));
	}
	
	/**
	 * 从set中随机取得一个元素
	 * @param set
	 * @return
	 */
	public static <E> E getRandomElement(Set<E> set){
		int rn = getRandomInt(set.size());
		int i = 0;
		for (E e : set) {
			if(i==rn){
				return e;
			}
			i++;
		}
		return null;
	}
}
