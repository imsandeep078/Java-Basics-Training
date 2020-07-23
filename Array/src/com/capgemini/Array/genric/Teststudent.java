package com.capgemini.Array.genric;

public class Teststudent {
	public static void main(String[] args) {
		Student[] s=new Student[4];
		
		Student s1=new Student(1,"sam",55.10);
		Student s2=new Student(2,"ram",65.20);
		Student s3=new Student(3,"dam",75.30);
		Student s4=new Student(4,"mam",85.40);
		
		s[0]=s1;
		s[1]=s2;
		s[2]=s3;
		s[3]=s4;
		
		
		recieve(s);
		
	}
	
	static void recieve(Student[] m)
	{
		for(Student st : m)
		{
			System.out.println(st.id);
			System.out.println(st.name);
			System.out.println(st.percentage);
			System.out.println(".........................");
		}
	}

}


