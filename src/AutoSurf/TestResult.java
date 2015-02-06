package AutoSurf;

/**
 * A class consisting of a String Boolean pairing, which stores a test name and
 * a test result inseparably.
 * 
 * @author Bergie
 * 
 */
public class TestResult {
	String testName;
	Boolean result;

	protected TestResult() {
		testName = "";
		result = null;
	}

	protected TestResult(String s, Boolean b) {
		testName = s;
		result = b;
	}

	protected TestResult(String s) {
		testName = s;
		result = null;
	}

	protected Boolean getResult() {
		return result;
	}

	protected String getTestName() {
		return testName;
	}

	protected void setResult(Boolean b) {
		result = b;
	}

	protected void setTestName(String s) {
		testName = s;
	}

	/**
	 * NOT switches the last result (True -> False, False -> True).
	 */
	protected void toggleResult() {
		result = !result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TestResult [testName=" + testName + ", result=" + result + "]";
	}
}
