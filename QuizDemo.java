import java.util.*;
/**
* Program use to add questions and take quiz when required.
* question class
*/
class Question {

	public int serialNumber;
	public String questionText;
	public int correctAnswer;
	public String[] choices;

	public Question() {
		choices = new String[4];
	}
	/**
	*Question Costructor .
	*	@param serialNumber serialNumber int
	*	@param question question string
	*	@param choices choices array
	*	@param correctAnswer correctAnswer int
	*/
	public Question(int serialNumber , String question , String[] choices , int correctAnswer) {
		this.serialNumber = serialNumber;
		this.questionText = question ;
		this.choices = choices ;
		this.correctAnswer = correctAnswer;
	}
	/**
	*	@return serialNumber serialNumber int
	*/
	public int getSerialNumber() {
		return serialNumber;
	}

	/**
	*	@return questionText questionText string
	*/

	public String getQuestionTest() {
		return questionText;
	}

	/**
	*	@return correctAnswer correctAnswer int
	*/
	public int getAnswer() {
		return correctAnswer;
	}
	/**
	*	@return choices choices array[]
	*/
	public String getChoice(int index) {
		return choices[index];
	}
	/**
	*	@return choices choices String[]
	*/
	public String[] getChoices() {
		return choices;
	}
}
/**
*Quiz class.
*/
class Quiz {
	public int points;
	Question[] totalQuestions ;
	int currentIndex ;
	int size;
	Quiz(final int size) {
		this.size = size;
		currentIndex = 0;
		totalQuestions = new Question[size];
		points = 0;
	}
	/**
	*	@param given given Question 
	*/
	public void addQuestion(Question given) {
		totalQuestions[currentIndex] = given ;
		currentIndex ++ ;
	}
	
	public void startQuiz() {
		int i , ans ;
	 	for(i = 0;i < currentIndex; i++){
	 		System.out.println("serialNumber :"+totalQuestions[i].getSerialNumber());
		 	System.out.println("Questions"+totalQuestions[i].getQuestionTest());
		 	String[] choices = totalQuestions[i].getChoices();
		 		for(int j=0; j<4; j++) {
		 			System.out.println( j+1 + ":"+choices[j]);
		 		}
		 	Scanner kb = new Scanner(System.in);
		 	ans = kb.nextInt();
		 	if(ans == totalQuestions[i].getAnswer()) {
		 		points ++;
		 	}
		} 	
		//System.out.println("points scored " + points);
	}

	public void showReport() {
		System.out.println("Total points Scored ::" + points);
	}
}

class QuizDemo {

	public static void main(String[] args) {
		int sNumber , i , j;
		String q ;
		String choose[];
		int cAnswer;		

		Scanner kb = new Scanner(System.in);
		System.out.println("Enter the nuber of questions ");
		int size = kb.nextInt();

		Quiz main = new Quiz(size);
		Question q1 ;

		for(i = 0 ; i < size ; i++) {
			System.out.println("serial number :");
			sNumber = kb.nextInt();
			kb.nextLine();
			System.out.println("question :");
			q = kb.nextLine();
			System.out.println("options :");
			choose = new String[4];
				for (j = 0; j < 4 ; j++ ) {
					choose[j] = kb.nextLine();
				}
			System.out.println("correctAnswer :");
			cAnswer = kb.nextInt();
			q1 = new Question(sNumber , q , choose , cAnswer);
			main.addQuestion(q1);
		}
		main.startQuiz();
		main.showReport();
	}
}

