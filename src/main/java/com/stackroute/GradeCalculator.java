package com.stackroute;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class GradeCalculator {

	public static Map<Integer, String> calculateGrade(Map<Integer, Integer> scores) {
		if(null==scores || scores.isEmpty()) {
			return null;
		}
		
		Map<Integer, String> grades = new HashMap<>();
		Set<Integer> keys = scores.keySet();
		for(Map.Entry<Integer, Integer> mentry : scores.entrySet()) {
			if(mentry.getValue()>=80 && mentry.getValue() <= 100) {
				grades.put(mentry.getKey(), "A");
			}
			else if(mentry.getValue()>=60 && mentry.getValue()<80) {
				grades.put(mentry.getKey(), "B");				
			}
			else if(mentry.getValue()>=45 && mentry.getValue()<60) {
				grades.put(mentry.getKey(), "C");
			}
			else if(mentry.getValue() < 45){
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
      
      Scanner s = new Scanner(System.in);
   
      while(s.hasNextLine()) {
    	  String lne = s.nextLine();
    	  noOfStudents = Integer.parseInt(lne);
      
      //s1.nextLine();
      String[] mapDetails = new String[noOfStudents];
      //System.out.println("Studests " + noOfStudents);

      for(int i=0;i<noOfStudents;i++) {
    	  lne = s.nextLine();
    	  //System.out.println("Details " + lne);
    	  String[] mapDetails1 = lne.split(" ");
    	  //System.out.println("" + mapDetails1[0] + mapDetails1[1]);
    	  //if(mapDetails[0] != "" && mapDetails[1] != null) {
    	  scores.put(Integer.parseInt(mapDetails1[0]), Integer.parseInt(mapDetails1[1]));
    	  //}
    	 }
      
     
      //System.out.println("Scores " + scores);
      grades = calculateGrade(scores);
      //System.out.println("Grades " + grades);
      if(null!= grades) {
    	  StringBuilder sb = new StringBuilder();
      for(Map.Entry<Integer, String> entry : grades.entrySet()) {
    	  
    	  sb.append(entry.getKey()+" "+ entry.getValue() + " "); 
      }
      System.out.println(sb.toString().trim());
      }
      }
	}
}