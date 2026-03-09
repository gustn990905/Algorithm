import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int subjectNum = 0;
        double result = 0;
        for(int i=0; i<20; i++) {
        	String subject = sc.next();
        	double score = sc.nextDouble();
        	String grade = sc.next();
        	
        	if(grade.equals("P")) continue;
        	
        	double gradeToScore = 0;
        	if(grade.equals("A+")) gradeToScore = 4.5;
        	else if(grade.equals("A0")) gradeToScore = 4.0;
        	else if(grade.equals("B+")) gradeToScore = 3.5;
        	else if(grade.equals("B0")) gradeToScore = 3.0;
        	else if(grade.equals("C+")) gradeToScore = 2.5;
        	else if(grade.equals("C0")) gradeToScore = 2.0;
        	else if(grade.equals("D+")) gradeToScore = 1.5;
        	else if(grade.equals("D0")) gradeToScore = 1.0;
        	else if(grade.equals("F")) gradeToScore = 0.0;
        	
        	subjectNum+=score;
        	result += score * gradeToScore;
        }
        
        System.out.printf("%.6f", result / subjectNum);
    }
}