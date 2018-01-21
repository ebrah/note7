package com.haikaroseworx.note7app.testpackage3;

import java.util.ArrayList;

public class ArrayIntList {
	ArrayList<Integer> data = null;
	
	ArrayIntList() {
		data = new ArrayList<Integer>();
	}
	
	void add(Integer i) {
		data.add(i);
	}
	
	void remove(int i) {
		data.remove(i);
	}
	
	int get(int i) {
		return data.get(i);
	}
	
	boolean isEmpty() {
		return data.isEmpty();
	}
}
