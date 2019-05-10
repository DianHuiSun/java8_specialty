package com.example.java8_specialty;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author：sdh
 * @description：测试java8新特性Stream
 * @date：
 * @version： 1.0
 */
public class StreamTest {


    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");

        //limit及forEach方法测试
        System.out.println("stream forEach方法测试 method test:");
        new Random().ints().limit(10).forEach(System.out::println);
        //map 方法用于映射每个元素到对应的结果,以下是在每个字符串后面加上tem三个字符
        System.out.println("stream map method test:");
        strings.stream().map(tem->tem+"tem").forEach(System.out::println);
        //distinct 方法去重
        System.out.println("stream distinct method test:");
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        numbers.stream().distinct().forEach(System.out::print);
        //filter
        System.out.println("stream filter method test:");
        long count = strings.stream().filter(el -> el.isEmpty()).count();
        System.out.println(count);
        //sorted
        System.out.println("stream sorted method test:");
        numbers.stream().sorted().forEach(System.out::print);
        //并行（parallel）程序
        System.out.println("stream parallelStream method test:");
        long count1 = strings.parallelStream().filter(string -> string.isEmpty()).count();
        System.out.println(count1);

        //Collectors 类实现了很多归约操作，例如将流转换成集合和聚合元素。Collectors 可用于返回列表或字符串
        System.out.println("stream Collectors method test:");
        List<String> s = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = s.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

        System.out.println("筛选列表: " + filtered);
        String mergedString = s.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + mergedString);



        //统计
        System.out.println("stream summaryStatistics method test:");
        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();

        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());


    }


}
