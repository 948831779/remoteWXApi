package com.tianlong.asystem.weixin.web.jdk8.test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

public class Java8Tester01 {
	 public static void main(String[] args){
	      List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
	        
	      // Predicate<Integer> predicate = n -> true
	      // n 是一个参数传递到 Predicate 接口的 test 方法
	      // n 如果存在则 test 方法返回 true
	        
	      System.out.println("输出所有数据:");
	        
	      // 传递参数 n
	      eval(list, n->true);
	        
	      // Predicate<Integer> predicate1 = n -> n%2 == 0
	      // n 是一个参数传递到 Predicate 接口的 test 方法
	      // 如果 n%2 为 0 test 方法返回 true
	        
	      System.out.println("输出所有偶数:");
	      eval(list, n-> n%2 == 0 );
	        
	      // Predicate<Integer> predicate2 = n -> n > 3
	      // n 是一个参数传递到 Predicate 接口的 test 方法
	      // 如果 n 大于 3 test 方法返回 true
	        
	      System.out.println("输出大于 3 的所有数字:");
	      eval(list, n-> n > 3 );
	      
	      
	      
	      List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl",null,"  ","abca", "", "bca", "efga", "abcda","", "jkla",null,"  ");
	      List<String> filtered = strings.stream().filter(string ->  StringUtils.isNotBlank(string)).limit(5).collect(Collectors.toList());
	      List<String> filtered2 = strings.parallelStream().filter(string ->  StringUtils.isNotBlank(string)).limit(7).collect(Collectors.toList());
	      System.out.println(filtered.toString());
	      System.out.println(filtered2.toString());
	      strings.forEach(System.out::println);
	      
	      
	      
	      
	      List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
	   // 获取对应的平方数
	   List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
	   
	   
	   System.out.println(squaresList.toString());
	   }
	    
	   public static void eval(List<Integer> list, Predicate<Integer> predicate) {
	      for(Integer n: list) {
	        
	         if(predicate.test(n)) {
	            System.out.println(n + " ");
	         }
	      }
	   }
}
