package com.tianlong.asystem.weixin.web.jdk8.test;


import org.apache.commons.collections.bidimap.TreeBidiMap;

import java.util.*;
import java.util.stream.Collectors;


public class Java8Tester {
	public static void main(String args[]) {
		List<Persion> list = new ArrayList<>(100);
		  for(int i=1;i<=100;i++){
			  list.add(new Persion("居民"+i,(i%2!=0?"男":"女"),i));
		  }
		for(int i=1;i<=100;i++){
			list.add(new Persion("居民"+i,(i%2!=0?"男":"女"),i));
		}
		list.add(new Persion("居民","男",21));

		list.stream().filter( persion -> persion.getAge() == 20).collect(Collectors.toList());
		Map<String, List<Persion>> collect = list.stream().collect(Collectors.groupingBy(Persion -> Persion.getSex() + "_" + Persion.getAge(), Collectors.toList()));
		System.out.println(collect);
		//System.out.println(list.stream().collect(Collectors.groupingBy(Persion->Persion.getSex())));
//		list.stream().collect(Collectors.groupingBy(Persion ->Persion.getSex(), (TreeMap::new),Collectors.toList())).forEach((k,v)->{
//			System.out.println(k + "  value:  "+v);
//		});
		//System.out.println(list.stream().collect(Collectors.groupingBy(Persion ->Persion.getSex()+"_"+Persion.getAge(),Collectors.counting())));
//		List<Integer> list1 = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//		// identitty 起始值 0  然后与集合中的值进行 相应的运算，再次赋值给 identity 然后 在进行运算。
//		Integer sum = list1.stream().reduce(list1.get(0), (x, y) -> x + y);
//		System.out.println(sum);
//
	//	System.out.println(list.stream().map(Persion::getAge).reduce(0,(x,y)->x+y));
	//	System.out.println(list.stream().collect(Collectors.groupingBy(persion -> persion.getSex(),Collectors.counting())));
//		System.out.println(list.stream().anyMatch(persion -> {
//			return persion.getAge() == 20;
//		}));
//		System.out.println("list 集合中有 "+list.stream().count());
//		System.out.println(""+ list.stream().max((x,y) -> Integer.compare(x.getAge(),y.getAge())));
//		list.stream().filter(persion -> {
//			return persion.getSex().equalsIgnoreCase("男");
//		}).forEach(persion -> {
//			System.out.println(persion.toString());
//		});
//	Map<String,Persion> map = list.stream().filter(persion -> {
//			return persion.getSex().equalsIgnoreCase("男");
//		}).collect(Collectors.toMap(Persion::getName, Function.identity() ,(key1, key2) -> key1));
//		System.out.println(map);


	}

	static class Persion{
		private String name ;
		private String sex;
		private int age;
        public Persion(String name,String sex,int age){
        	this.name=name;
			this.sex=sex;
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getSex() {
			return sex;
		}

		public void setSex(String sex) {
			this.sex = sex;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		@Override
		public String toString() {
			return "Persion{" +
					"name='" + name + '\'' +
					", sex='" + sex + '\'' +
					", age=" + age +
					'}';
		}



	}

}