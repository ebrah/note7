package com.haikaroseworx.note7app.testpackage2;

public class StutterIntList extends ArrayIntList {
	// "stretch factor" - number of copies of each element that will be added
	private int stretch;
	
	// Constructs a new list of a default capacity with the given stretch factor.
	// Precondition: stretch >= 0
	public StutterIntList(int stretch) {
		this(stretch, INITIAL_CAPACITY);
	}
	
	// Constructs a new list of the given capacity with the given stretch factor.
	// Precondition: stretch >= 0 && capacity >= 0
	public StutterIntList(int stretch, int capacity) {
		super(capacity);
		if (stretch < 0) {
			throw new IllegalArgumentException("bad stretch factor: " + stretch);
		}
		this.stretch = stretch;
	}
	
	// we don't need to write the one-parameter add method below, because the inherited
	// one from ArrayIntList will already call our new two-parameter add method,
	// add(size, value); , which will do the right thing (adding multiple copies).
	
//  public void add(int value) {
//		for (int i = 1; i <= stutter; i++) {
//			super.add(value);
//		}
//		add(size, value);
//	}

	// Adds 'stretch' copies of the given value at the given index.
	// Precondition: 0 <= index <= size()
	// Throws an IndexOutOfBoundsException if the index is out of range.
	public void add(int index, int value) {
		for (int i = 1; i <= stretch; i++) {
			super.add(index, value);
			// index++;
		}
	}

	// Returns this list's stretch factor that was passed at construction.
	public int getStretch() {
		return stretch;
	}
}