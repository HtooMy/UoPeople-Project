
public class AdditionProblem {
	private int answer;
	
	public AdditionProblem(int x, int y) {
		int test1 = (int) (x + 40 * Math.random());
		int test2 = (int) (y * Math.random());
		answer = x + y;
	}
	
	public void getProblem() {
		System.out.println("Compute the sum: ");
	}
	
	public void getAnswer() {
		System.out.println(answer);
	}
}
