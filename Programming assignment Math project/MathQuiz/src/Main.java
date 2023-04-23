
public class Main {

	public static void main(String[] args) {
		System.out.println("What's your name?");
		String name = TextIO.getln();
		System.out.println("Pleased to meet you, " + name);
		AdditionProblem test = new AdditionProblem(10, 11);
		test.getProblem();
		test.getAnswer();
	}

}
