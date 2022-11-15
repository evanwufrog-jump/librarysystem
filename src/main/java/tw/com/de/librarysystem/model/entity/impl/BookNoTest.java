package tw.com.de.librarysystem.model.entity.impl;

import java.text.SimpleDateFormat;
import java.util.Date;


public class BookNoTest {
	
	
	public static void main(String[] args) {
		Date today = new Date();
//		Date date 
		SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-mm-dd");
//		 = sdf.format(today);
//		Date date = SimpleDateFormat;
//		Date date = new SimpleDateFormat("yyyy-mm-dd").parse(sdf);
		System.out.println(sdf.format(today).getClass().getName());
		System.out.println(today);
		System.out.println(today.getYear() + 1900);
		int bookNo = (today.getYear() + 1900) * 1000 + 2;
		System.out.println("bookNo = " + ((today.getYear() + 1900) * 1000 + 2));
		
	}

}
