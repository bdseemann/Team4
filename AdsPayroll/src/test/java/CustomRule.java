import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class CustomRule implements TestRule {
	@Override
	public Statement apply(Statement statement, Description description) {
		return new CustomStatement(statement);
	}

	private class CustomStatement extends Statement {
		private final Statement test;

		public CustomStatement(Statement statement) {
			this.test = statement;
		}

		@Override
		public void evaluate() throws Throwable {
			System.out.println("this is custom code executing before the test");
			test.evaluate();
			System.out.println("this is custom code executing after the test");
		}
	}
}
