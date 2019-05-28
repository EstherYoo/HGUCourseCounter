package edu.handong.analysis.datamodel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Student {
	private String studentId;
	private ArrayList<Course> coursesTaken;
	private HashMap<String,Integer> semestersByYearAndSemester;
	
	//컨스트럭터 - 인스턴스를 다 생성해준다.
	public Student(String studentId) {
		this.studentId = studentId;
		this.coursesTaken = new ArrayList<Course>();
		this.semestersByYearAndSemester = new HashMap<String,Integer>();
	}
	

	// Course 값 전체를 coursesTaken에 넣어준다. 이를 바탕으로 HashMap을 만들어준다.
	public void addCourse(Course newRecord) {
		this.coursesTaken.add(newRecord);
	}
	
	// HashMap에서 key값을 돌면서 학기수를 부여한다.
	public HashMap<String,Integer> getSemesterByYearAndSemester() {
		int year;
		int semester;
		int totalNumOfSemester = 1;
		for (String data : this.semestersByYearAndSemester.keySet()) {
			year = this.coursesTaken.get(7).getYearTaken();
			semester = this.coursesTaken.get(8).getSemesterCourseTaken();
			String key = year + "-" + semester;
			this.semestersByYearAndSemester.put(key, totalNumOfSemester);
			totalNumOfSemester++;
		}
		return semestersByYearAndSemester;
	}
	
	public int getNumCourseInNthSemester(int semester) {
		int numCourseInNthSemester = 0;
		for (String key : this.semestersByYearAndSemester.keySet()) {
			   if (this.semestersByYearAndSemester.get(key).equals(semester)) {
				   for (Course line: coursesTaken) {
					   int year = line.getYearTaken();
					   int semesters = line.getSemesterCourseTaken();
					   String data = year + "-" + semesters;
					   if(key.equals(data)) {
						   numCourseInNthSemester++;
						   //System.out.println(numCourseInNthSemester);
					   }
				   }
			   }
		}
		return numCourseInNthSemester;
	}
}
