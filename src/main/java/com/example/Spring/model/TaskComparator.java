package com.example.Spring.model;

import java.util.Comparator;
import java.util.Date;

public class TaskComparator implements Comparator<Task>{

	@Override
	public int compare(Task o1, Task o2) {
		// TODO Auto-generated method stub
		Date d1 = o1.getData();
		Date d2 = o2.getData();
		return d1.compareTo(d2);
	}

}
