
public class Quiz {
	public static void main(String[] args) {
		Question question = new TrueFalseQuestion(
				"Sky is blue", "y");
		question.check();
		Question question1 = new TrueFalseQuestion(
				"I like an apple", "y");
		question1.check();
		Question question2 = new TrueFalseQuestion(
				"I like a banana", "n");
		question2.check();
		Question question3 = new TrueFalseQuestion(
				"I like ice-cream", "y");
		question3.check();
		Question question4 = new TrueFalseQuestion(
				"I like cake", "y");
		question4.check();
		Question question5 = new TrueFalseQuestion(
				"I like spicy noodle", "n");
		question5.check();
		
		Question question6 = new MultipleChoiceQuestion(
				"What is a quiz?",
				"a test of knowledge, especially a brief informal test given students",
				"42",
				"a duck",
				"to get to the other side",
				"To be or not to be, that is the question.",
				"a");
		question6.check();
		question6.showResults();
		
		Question question7 = new MultipleChoiceQuestion(
				"What is a kind of fruit?",
				"wood",
				"bicycle",
				"car",
				"apple",
				"dog",
				"d");
		question7.check();
		question7.showResults();
		
		Question question8 = new MultipleChoiceQuestion(
				"What is my father name?",
				"Jhon Dee",
				"Jhon Doe",
				"Jhon Lay",
				"Jhon Gyi",
				"Jhon Pho",
				"a");
		question8.check();
		question8.showResults();
		
		Question question9 = new MultipleChoiceQuestion(
				"Who is Jackie Chan?",
				"An actor",
				"A doctor",
				"A scientise",
				"A bad guy",
				"A singer",
				"a");
		question9.check();
		question9.showResults();
		
		Question question10 = new MultipleChoiceQuestion(
				"What color is banana?",
				"Black",
				"White",
				"Orange",
				"Grey",
				"Yellow",
				"e");
		question10.check();
		question10.showResults();
	}

}
