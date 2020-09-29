
public class Student implements Comparable<Student>{
	
	private String name;						// private instance variables
	private int score;
	
	public Student(String name, int score) {	// Constructor using fields
		this.name = name;
		this.score = score;
	}
	
	public int getScore() {						// getter to be used in the compareTo method
		return score;
	}
	
	@Override
	public String toString() {					//auto-generated toString plus the output requested in the instructions
		return name + " " + score;
	}

	@Override
	public int compareTo(Student o) {			// compareto method that compares students  by score
		if(this.score > o.getScore()) {			// if students has a higher score it gives a -1
			return -1;
		}
		else if(this.score < o.getScore()) {	// if student has a lower score it gives a 1
			return 1;
		}
		return 0;								// if student has the same score return 0
	}											// the result is sorting students from greatest score to least score

}
