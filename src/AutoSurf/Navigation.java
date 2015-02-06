package AutoSurf;

import java.util.List;

import org.openqa.jetty.util.URI;

public class Navigation {
	/**
	 * Takes the url and encodes it, changing special characters like '#' and
	 * replacing them with URL appropriate code like '%26'
	 * 
	 * @param toEncode
	 *            The URL to be encoded
	 * @return The now properly encoded URL
	 */
	protected static String encodeURL(String toEncode) {
		// return URLEncoder.encode(toEncode);
		return URI.encodePath(toEncode);
	}

	/**
	 * Pulls the sqlUserName, sqlPassword, and boxSet from the Master Parameters
	 * and uses them to navigate to the selected box set's Super Global Admin
	 * page
	 */
	protected static void goToSuperGlobal() {
		String address = "http://" + Parameters.getSqlUserName() + ":"
				+ Parameters.getSqlPassword() + "@"
				+ Parameters.getBoxSet().returnDomain()
				+ "/admin/SuperGlobalAdmin.php/";
		// String address = "http://" + Master.getSQLUserName() + ":" +
		// Master.getSQLPassword() + "@" +
		// Navigation.boxSet(Master.getBoxSetAsInt()) +
		// "/admin/SuperGlobalAdmin.php/";
		String encodedAddress = encodeURL(address);
		Debug.throwInDebugIfOn("encodedAddress: " + encodedAddress);
		try {
			Driver.getCurrentDriver().get(encodedAddress);
		} catch (Exception e) {
			recovery(e);
		}
	}

	/**
	 * Call Only from a broken run (catch block)<br>
	 * Called to check if the driver is linked to a good page, and if not,
	 * attempts to load from the current stored window handle. If that fails,
	 * throw a custom exception.<br>
	 * TODO: When priorities shift, this could use some love.
	 * @param e
	 *            The exception to be passed in, typically passed from the catch
	 *            block exception.
	 */
	protected static void recovery(Exception e) {
		List<String> testNames = Results.getTestNames();
		try {
			if (testNames.size() > 0) {
				System.out.println("Exception thrown by "
						+ testNames.get(testNames.size() - 1) + ": "
						+ e.getLocalizedMessage());
				if (e.getLocalizedMessage()
						.contains(
								"Error communicating with the remote browser. It may have died.")) {
					Driver.reactivate();
				}
				return;
			} else {
				System.out.println("Exception called without testName");
				return;
			}
		} catch (Exception f) {
			System.out.println("Recovery failed, aborting");
			Driver.cleanUp();
			RemoteDriver.remoteCleanUp();
			Results.printResults();
			System.exit(0);
		}
	}
}
