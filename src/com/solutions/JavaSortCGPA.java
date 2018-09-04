package com.solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Student2 {
	private int id;
	private String fname;
	private double cgpa;

	public Student2(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}

	public int getId() {
		return id;
	}

	public String getFname() {
		return fname;
	}

	public double getCgpa() {
		return cgpa;
	}
}

public class JavaSortCGPA {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testCases = Integer.parseInt(scan.nextLine());

		List<Student2> studentList = new ArrayList<Student2>();
		while (testCases-- > 0) {
			int id = scan.nextInt();
			String fname = scan.next();
			double cgpa = scan.nextDouble();
			Student2 st = new Student2(id, fname, cgpa);
			studentList.add(st);
		}
		scan.close();
		

		Collections.sort(studentList, new Student2Comparator());
		for (Student2 st : studentList) {
			System.out.println(st.getFname());
		}
	}
}



class Student2Comparator implements Comparator<Student2> {
	double epsilon = 0.001; // since we shouldn't use "==" with doubles

	@Override
	public int compare(Student2 s1, Student2 s2) {
		if (Math.abs(s1.getCgpa() - s2.getCgpa()) > epsilon) {//cpga is not equal
			return s1.getCgpa() < s2.getCgpa() ? 1 : -1; // descending order
		} else if (!s1.getFname().equals(s2.getFname())) {//cpga is equal
			return s1.getFname().compareTo(s2.getFname());// ascending order by fname when cpga is equal 
		} else {
			return s1.getId() - s2.getId();
		}
	}
}