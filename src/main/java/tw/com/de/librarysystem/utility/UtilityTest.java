package tw.com.de.librarysystem.utility;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class UtilityTest {
	
	public static void main(String[] args) {
		int year = new Date().getYear();
		System.out.println(year + 1900);
		LocalDate currentDate = LocalDate.now();
		int currentYear = currentDate.getYear();
		int thisYear = LocalDate.now().getYear();
		System.out.println(thisYear);
		/*
		List<String> strings = Arrays.asList("小狗", "", "小貓", "小豬", "小鳥","");
		// 獲取非空字串數量
		long animalCount = strings.stream().filter(string -> !string.isEmpty()).count();
		System.out.println(animalCount);
		
		List<Integer> list = Arrays.asList(1, 2, 3);
//		list.stream().map((x) -> x*3).forEach(System.out :: println);
	
		List<Integer> suqareList = list.stream().map((x) -> x*3).collect(Collectors.toList());
//		System.out.println(list[1]);
		for(int i = 0; i < suqareList.size(); i++ ) {
			System.out.println(i + "" +suqareList.get(i));
		}
//		for (Integer integer : suqareList) {
//			System.out.println(integer);}
		Integer[] array = {1, 2, 3};
//		List<Integer> list = new ArrayList<>();
//		list.add(10);
//		list.add(19);
//		list.add(9);
//		list.add(300);
//		list.forEach(x -> System.out:: print);
////		list.forEach(x -> return x*x;);
//		System.out.println(list[0]);
//		array.stream
		//[1, 2, 3].forEach()
		 */
	}

}
