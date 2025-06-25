package viva_code;

public class EduQuiz {
	
	

	 
    public static int calculateScore(String[] correct, String[] student) {
        int score = 0;
        
       //match length
        if (correct.length != student.length) {
            System.out.println("Error: The number of student answers does not match the number of questions.");
            return score;
        }
        
        
        for (int i = 0; i < correct.length; i++) {
            if (student[i] == null) {
                System.out.println("Question " + (i + 1) + ": No answer provided");
            } else if (correct[i].equalsIgnoreCase(student[i])) {
                System.out.println("Question " + (i + 1) + ": Correct");
                score++;
            } else {
                System.out.println("Question " + (i + 1) + ": Incorrect");
            }
        }
        return score;
        
        
    }
    public static void main(String[] args) {
        // Example correct answers and student answers
        String[] correctAnswers = {"A", "B", "C", "D", "A", "B", "C", "D", "A", "B"};
        String[] studentAnswers = {"a", "b", "d", "d", "A", "B", null, "D", "A", "c"};

        int totalQuestions = correctAnswers.length;

        // Call method only if both arrays are valid
        if (studentAnswers != null && correctAnswers != null && studentAnswers.length == totalQuestions) {
        	
            int score = calculateScore(correctAnswers, studentAnswers);
            double percentage = (score * 100.0) / totalQuestions;

            System.out.println("\nScore: " + score + "/" + totalQuestions);
            System.out.print("Percentage: "+ percentage);
            
            if (percentage >= 50) {
                System.out.println("\nResult: Pass");
            } else {
                System.out.println("\nResult: Fail");
            }
        } else {
            System.out.println("Error: Arrays are not of equal length or null.");
        }
    }
}


	

    
