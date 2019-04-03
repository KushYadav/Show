package upgrad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Upgrad {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner scn = new Scanner(System.in);
		PriorityQueue<student> pq = new PriorityQueue<>();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		for (int i = 0; i < n; i++) {
			String[] input = new String[4];
			input = in.readLine().split(" ");
			if (input[0].equals("ENTER")) {
				String name = input[1];
				Double cgpa = Double.valueOf(input[2]);
				int token = Integer.parseInt(input[3]);
				pq.add(new student(name, cgpa, token));
			} else if (input[0].equals("SERVED")) {
				pq.remove();
			}
		}
		if (pq.isEmpty()) {
			System.out.println("EMPTY");
		} else {
			int size = pq.size();
			for (int j = 0; j < size; j++) {
				System.out.println(pq.remove().name);
			}
		}

	}

	public static class student implements Comparable<student> {
		String name;
		double cgpa;
		int token;

		public student(String name, double cgpa, int token) {
			this.name = name;
			this.cgpa = cgpa;
			this.token = token;
		}

		@Override
		public int compareTo(student o) {
			if (o.cgpa > this.cgpa) {
				return 1;
			} else if (o.cgpa < this.cgpa) {
				return -1;
			} else {
				if (o.name.compareTo(this.name) == 0) {
					return o.token - this.token;
				} else {
					return this.name.compareTo(o.name);
				}
			}
		}
	}
}
//12
//ENTER John 3.75 50 
//ENTER Mark 3.8 24 
//ENTER Shafaet 3.7 35 
//SERVED 
//SERVED
//ENTER Samiha 3.85 36 
//SERVED 
//ENTER Ashley 3.9 42 
//ENTER Maria 3.6 46 
//ENTER Anik 3.95 49 
//ENTER Dan 3.95 50 
//SERVED