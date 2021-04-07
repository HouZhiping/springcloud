package com.hou.gy;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
class GyApplicationTests {

	@Test
	void contextLoads() {
	}


	@Test
	public void testLimit1() {
		List<String> list = new ArrayList<>();
		list.add("张三三");
		list.add("李四");
		list.add("王五");
		list.add("孙七");
		list.add("赵八");
		list.stream().limit(2).forEach(System.out::println);
//		list.stream().filter(e -> e.contains("张")).forEach(System.out::println);
	}



	/**
	 * list集合stream流式操作
	 */
	@Test
	public void testStreamList() {
		List<String> list = new ArrayList<>();
		list.add("张三三");
		list.add("李四");
		list.add("王五");
		list.add("孙七");
		list.add("赵八");
		list.stream().filter(e -> e.startsWith("张")) //过滤所有姓张的人
				.filter(e -> e.length() == 3) //过滤所有姓名是3个字的人
				.forEach(System.out::println); //遍历打印,System.out::println表明System.out调用println打印方法
	}

	/**
	 * stream，获取各种集合的stream流
	 */
	@Test
	public void testCollectionStream() {
		List<String> stringList = new ArrayList<>();
		Set<String> stringSet = new HashSet<>();
		Map<String, Object> stringObjectMap = new HashMap<>();
		String[] stringArray = {"张三三", "李四", "王五", "王五", "赵八",};

		//通过list获取stream流
		Stream<String> streamList = stringList.stream();
		//通过set获取stream流
		Stream<String> streamSet = stringSet.stream();
		//通过map获取stream流
		Stream<String> streamMap = stringObjectMap.keySet().stream();
		//通过array获取stream流
		Stream<String> streamArray1 = Stream.of(stringArray);

	}

	/**
	 * forEach， ForEach流式遍历list集合
	 */
	@Test
	public void testForEach() {
		List<String> list = new ArrayList<>();
		list.add("张三三");
		list.add("李四");
		list.add("王五");
		list.add("孙七");
		list.add("赵八");
		list.stream().forEach(System.out::println);
	}

	/**
	 * filter 方法 ， 返回符合过滤条件的值
	 */
	@Test
	public void testFilter() {
		List<String> list = new ArrayList<>();
		list.add("张三三");
		list.add("李四");
		list.add("王五");
		list.add("孙七");
		list.add("赵八");
		list.stream().filter(e -> e.contains("张")).forEach(System.out::println);
	}

	/**
	 * 遍历map集合，截取substring(2)开始的值
	 */
	@Test
	public void testMap() {
		List<String> list = new ArrayList<>();
		list.add("张三三");
		list.add("李四");
		list.add("王五");
		list.add("孙七");
		list.add("赵八");
		list.add("王二麻子");
		Stream<String> stream = list.stream().map(e -> e.substring(2));
		stream.forEach(System.out::println);
	}

	/**
	 * count，获取List集合的长度
	 */
	@Test
	public void testCount() {
		List<String> list = new ArrayList<>();
		list.add("张三三");
		list.add("李四");
		list.add("王五");
		list.add("孙七");
		list.add("赵八");
		list.add("王二麻子");
		long count = list.stream().count();
		System.out.println("count = " + count);
		int size = list.size();
		System.out.println("size = " + size);
	}

	/**
	 * limit 方法 ，返回前n个元素数据值组成的Stream。
	 */
	@Test
	public void testLimit() {
		List<String> list = new ArrayList<>();
		list.add("张三三");
		list.add("李四");
		list.add("王五");
		list.add("孙七");
		list.add("赵八");
		list.add("王二麻子");
		list.stream().limit(3).forEach(System.out::println); //取前3个
	}

	/**
	 * skip方法 ，跳过前n个元素的中间流操作，返回剩下的值。
	 */
	@Test
	public void testSkip() {
		List<String> list = new ArrayList<>();
		list.add("张三三");
		list.add("李四");
		list.add("王五");
		list.add("孙七");
		list.add("赵八");
		list.add("王二麻子");
		//list.stream().skip(3).forEach(System.out::println); //跳过前3个
		list.stream().skip(3).limit(2).forEach(System.out::println); //skip+limit实现分页
	}

	/**
	 * collect，将流转化为集合
	 */
	@Test
	public void testCollect() {
		List<String> list = new ArrayList<>();
		list.add("张三三");
		list.add("李四");
		list.add("王五");
		list.add("孙七");
		list.add("赵八");
		list.add("王二麻子");
		List<String> collect = list.stream().skip(3).limit(2).collect(Collectors.toList());
		collect.forEach(System.out::println);
	}

	/**
	 * reduce： 聚合操作，用来做统计，将流中元素反复结合起来统计计算，得到一个值.
	 */
	@Test
	public void testReduce() {
		//1.求集合元素只和
		Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
		Integer result = stream.reduce(0, Integer::sum);
		System.out.println(result);

		//2.求和
		Stream<Integer> stream1 = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
		stream1.reduce((i, j) -> i + j).ifPresent(System.out::println);

		//3.求最大值
		Stream<Integer> stream2 = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
		stream2.reduce(Integer::max).ifPresent(System.out::println);

		//4.求最小值
		Stream<Integer> stream3 = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
		stream3.reduce(Integer::min).ifPresent(System.out::println);

		//5.做逻辑
		Stream<Integer> stream4 = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
		stream4.reduce((i, j) -> i > j ? j : i).ifPresent(System.out::println);

		//6.求逻辑求乘机
		Stream<Integer> stream5 = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 6, 7});
		int result2 = stream5.filter(i -> i % 2 == 0).reduce(1, (i, j) -> i * j);
		Optional.of(result2).ifPresent(System.out::println);
	}

	/**
	 * distinct， 返回去重的Stream
	 */
	@Test
	public void testDistinct() {
		List<String> list = new ArrayList<>();
		list.add("张三三");
		list.add("李四");
		list.add("李四");
		list.add("王五");
		list.add("王五");
		list.add("孙七");
		list.add("赵八");
		list.add("王二麻子");
		list.stream().distinct().collect(Collectors.toList()).forEach(System.out::println);
	}

	/**
	 * sorted: 返回一个排序的Stream
	 */
	@Test
	public void testSorted() {
		List<String> list = new ArrayList<>();
		list.add("张三三");
		list.add("李四");
		list.add("李四");
		list.add("王五");
		list.add("王五");
		list.add("孙七");
		list.add("赵八");
		list.add("王二麻子");
		list.stream().distinct().sorted().collect(Collectors.toList()).forEach(System.out::println);
	}

	/**
	 * anyMatch：接收一个 Predicate 函数，只要流中有一个元素满足该断言则返回true，否则返回false
	 */
	@Test
	public void testAnyMatch() {
		List<String> list = new ArrayList<>();
		list.add("张三三");
		list.add("李四");
		list.add("李四");
		list.add("王五");
		list.add("王五");
		list.add("孙七");
		list.add("赵八");
		list.add("王二麻子");
		boolean b = list.stream().anyMatch(e -> e.equals("王二麻子"));
		System.out.println("b = " + b);
	}

	/**
	 * noneMatch: 接收一个 Predicate 函数，当流中每个元素都不符合该断言时才返回true，否则返回false
	 */
	@Test
	public void testNoneMatch() {
		List<String> list = new ArrayList<>();
		list.add("张三三");
		list.add("李四");
		list.add("李四");
		list.add("王五");
		list.add("王五");
		list.add("孙七");
		list.add("赵八");
		list.add("王二麻子");
		boolean b = list.stream().noneMatch(e->e.equals("张三"));
		System.out.println("b = " + b);
	}

	/**
	 * allMatch：接收一个 Predicate 函数，当流中每个元素都符合该断言时才返回true，否则返回false
	 */
	@Test
	public void testAllMatch() {
		List<String> list = new ArrayList<>();
		list.add("张三三");
		list.add("李四");
		list.add("李四");
		list.add("王五");
		list.add("王五");
		list.add("孙七");
		list.add("赵八");
		list.add("王二麻子");
		boolean b = list.stream()
				.allMatch(e -> list.size() > 8);
		System.out.println("b = " + b);
	}

	/**
	 * findFirst：返回流中第一个元素
	 */
	@Test
	public void testFindFirsth() {
		List<String> list = new ArrayList<>();
		list.add("张三三");
		list.add("李四");
		list.add("李四");
		list.add("王五");
		list.add("王五");
		list.add("孙七");
		list.add("赵八");
		list.add("王二麻子");
		Optional<String> first = list.stream().findFirst();
		System.out.println("first = " + first.get());
	}


	/**
	 * findAny：返回流中第一个元素
	 */
	@Test
	public void testFindAny() {
		List<String> list = new ArrayList<>();
		list.add("张三三");
		list.add("李四");
		list.add("李四");
		list.add("王五");
		list.add("王五");
		list.add("孙七");
		list.add("赵八");
		list.add("王二麻子");
		Optional<String> any = list.stream().findAny();
		System.out.println("any = " + any.get());
	}

	/**
	 * max：返回流中元素最大值
	 */
	@Test
	public void testMax() {
		List<Integer> list = new ArrayList<>();
		list.add(11);
		list.add(22);
		list.add(33);
		list.add(44);
		list.add(55);
		list.add(66);
		list.add(77);
		list.add(88);
		Integer integer = list.stream().max(Integer::compareTo).get();
		System.out.println("integer = " + integer);
	}

	/**
	 * min：返回流中元素最小值
	 */
	@Test
	public void testMin() {
		List<Integer> list = new ArrayList<>();
		list.add(11);
		list.add(22);
		list.add(33);
		list.add(44);
		list.add(55);
		list.add(66);
		list.add(77);
		list.add(88);
		Integer integer = list.stream().min(Integer::compareTo).get();
		System.out.println("integer = " + integer);
		list.stream().limit(1).limit(2).distinct().skip(3).filter(f -> f.equals(55)).forEach(System.out::println);
	}



}
