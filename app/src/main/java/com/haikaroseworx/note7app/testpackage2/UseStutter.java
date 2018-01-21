package com.haikaroseworx.note7app.testpackage2;

public class UseStutter {
	public static void main(String[] args) {
		StutterIntList list = new StutterIntList(5);

		list.add(7);     // [7, 7, 7]
		System.out.println(list);
		
		list.add(-1);    // [7, 7, 7, -1, -1, -1]
		System.out.println(list);
		
		list.add(2, 5);  // [7, 7, 5, 5, 5, 7, -1, -1, -1]
		System.out.println(list);

		list.remove(4);  // [7, 7, 5, 5, 7, -1, -1, -1]
		System.out.println(list);

		System.out.println(list.getStretch());   // 3
	}
}
