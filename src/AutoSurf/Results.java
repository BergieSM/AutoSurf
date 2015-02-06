/**
 * 
 */
package AutoSurf;

import java.util.ArrayList;
import java.util.List;

/**
 * Class built to aggragate a list of test names and results.<br>  This may be replaced with JUnit result reporting in the future.<br>
 * @author Bergie
 * 
 */
public class Results {
	static List<TestResult> results = null;
	static Results r = null;

	public Results() {
		results = new ArrayList<TestResult>();
	}

	/**
	 * Add a single testResult to the list.
	 * 
	 * @param tR
	 */
	protected static void addTestResult(TestResult tR) {
		results.add(tR);
	}

	/**
	 * @return List of Booleans containing all the results
	 */
	protected static List<Boolean> getResultsBoolean() {
		List<Boolean> lB = new ArrayList<Boolean>();
		for (TestResult tR : results) {
			lB.add(tR.getResult());
		}
		return lB;
	}

	/**
	 * @return List of Strings containing all the testNames
	 */
	protected static List<String> getTestNames() {
		List<String> lS = new ArrayList<String>();
		for (TestResult tR : results) {
			lS.add(tR.getTestName());
		}
		return lS;
	}

	/**
	 * @return the results
	 */
	protected static List<TestResult> getResults() {
		return results;
	}

	/**
	 * @param results
	 *            the results to set
	 */
	protected static void setResults(List<TestResult> resultsToSet) {
		Results.results = resultsToSet;
	}

	/**
	 * Sets the last result boolean in the list to a new value.
	 * 
	 * @param result
	 *            The new value for the most recent entry to be set to.
	 */
	protected static void replaceLastResult(Boolean b) {
		TestResult holder = new TestResult();
		holder = results.get(results.size() - 1);
		holder.setResult(b);
		results.set(results.size() - 1, holder);
	}

	protected static void setResults(Results rToSet) {
		Results.r = rToSet;
	}

	/**
	 * Calls FileOutput.printResults() to send all results to the Results.txt
	 * file
	 */
	protected static void printResults() {
		FileOutput.printResults(results);
	}
}
