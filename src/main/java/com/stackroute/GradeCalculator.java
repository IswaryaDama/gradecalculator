package com.stackroute;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class GradeCalculator {

	public static Map<Integer, String> calculateGrade(Map<Integer, Integer> scores) {
		if(scores.isEmpty() || null==scores) {
			return null;
		}
		
		Map<Integer, String> grades = new HashMap<>();
		Set<Integer> keys = scores.keySet();
		for(Map.Entry<Integer, Integer> mentry : scores.entrySet()) {
			if(mentry.getValue()>=80) {
				grades.put(mentry.getKey(), "A");
			}
			else if(mentry.getValue()>=60 && mentry.getValue()<80) {
				grades.put(mentry.getKey(), "B");				
			}
			else if(mentry.getValue()>=45 && mentry.getValue()<60) {
				grades.put(mentry.getKey(), "C");
			}
			else {
				grades.put(mentry.getKey(), "D");
			}
		}
		Map<Integer, String> sortedGrades = new TreeMap<>(grades);
		return sortedGrades;
	}

   	//Do not print anything other than what's expected/asked in problem
    public static void main(String[] args) {
    	//Use Scanner to get input from console
      int noOfStudents;
      Map<Integer,Integer> scores = new HashMap<>();
      Map<Integer,String> grades = new HashMap<>();
      int marks;
      
      Scanner s = new Scanner(System.in);
      Scanner s1 = new Scanner(System.in);
      noOfStudents = s.nextInt();
      
      String[] mapDetails = new String[noOfStudents];
      
      for(int i=0;i<noOfStudents;i++) {
    	  
    	  mapDetails[i] = s1.nextLine();
    	  String[] mapDetails1 = mapDetails[i].split(" ");
    	  scores.put(Integer.parseInt(mapDetails1[0]), Integer.parseInt(mapDetails1[1]));
      }
      
     // System.out.println("mapData is " + scores);
      
      grades = calculateGrade(scores);
      for(Map.Entry<Integer, String> entry : grades.entrySet()) {
    	  System.out.println(entry.getKey()+" "+ entry.getValue()); 
      }
      
	}
}