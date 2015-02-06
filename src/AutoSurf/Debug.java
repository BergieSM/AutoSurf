package AutoSurf;

/**
 * This class is used to throw debug info into a separate debug results file, to keep the results file clean.<br>
 * Set debug to on before a class run, before a testcase, or before a single function call, and turn it off when you've passed the problem area.<br>
 * Simple boolean, true = on.
 * @author Bergie
 *
 */
public class Debug {
	static Boolean debug = null;

	/**
	 * Returns the current debug state, true = on.
	 * @return Boolean True = Debug State On.
	 */
	protected static Boolean getDebugState() {
		return debug;
	}

	protected static void setDebugOff() {
		debug = false;
	}

	protected static void setDebugOn() {
		FileOutput.throwInDebug("Debug Mode: ON");
		debug = true;
	}

	/**
	 * Throws a single String into the debug file.
	 * @param s  The String to be thrown to debug.
	 */
	protected static void throwInDebug(String s) {
		FileOutput.throwInDebug(s);
	}

	/**
	 * Throws a single String into the debug file, after checking if debug mode is turned on.
	 * @param s The String to be thrown to debug.
	 */
	protected static void throwInDebugIfOn(String s) {
		if (debug == true) {
			FileOutput.throwInDebug(s);
		}
	}
}
