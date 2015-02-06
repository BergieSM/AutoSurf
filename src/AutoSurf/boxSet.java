package AutoSurf;

/**
 * This class used for storing the box set, aka, Sandbox Dev UAT Stage Prod<br>
 * Stores as both an int 1-5, and a String "1"-"5"<br>
 * Includes a returnDomain() function which returns the domain and sub-domain sections of the web address.
 * @author Bergie
 */
class boxSet {
	String boxSetAsString;
	int boxSetAsInt;

	protected boxSet() {
		boxSetAsString = "";
		boxSetAsInt = 0;
	}

	protected boxSet(int i) {
		boxSetAsInt = i;
		boxSetAsString = Integer.toString(i);
	}

	protected boxSet(String s) {
		boxSetAsString = s;
		boxSetAsInt = Integer.valueOf(s);
	}

	protected int getBoxSetAsInt() {
		return boxSetAsInt;
	}

	protected String getBoxSetAsString() {
		return boxSetAsString;
	}

	/**
	 * @return The sub-domain, domain, and top level domain, as string, for the given box set.
	 */
	protected String returnDomain() {
		String SBUserName = Parameters.getSandboxUserName();
		String returnString = "";
		switch (boxSetAsInt) {
		case 1:
			returnString = SBUserName + ".sassiedev.com";
			break;
		case 2:
			returnString = "www.sassiedev.com";
			break;
		case 3:
			returnString = "uat.sassieshop.com";
			break;
		case 4:
			returnString = "stage.sassieshop.com";
			break;
		case 5:
			returnString = "www.sassieshop.com";
			break;
		default:
			returnString = "www.sassiedev.com";
			break;
		}
		return returnString;
	}
	
	/**
	 * @return The sub-domain, domain, and top level domain, as string, for the given box set.
	 */
	protected String returnDomain(int i) {
		String SBUserName = Parameters.getSandboxUserName();
		String returnString = "";
		switch (i) {
		case 1:
			returnString = SBUserName + ".sassiedev.com";
			break;
		case 2:
			returnString = "www.sassiedev.com";
			break;
		case 3:
			returnString = "uat.sassieshop.com";
			break;
		case 4:
			returnString = "stage.sassieshop.com";
			break;
		case 5:
			returnString = "www.sassieshop.com";
			break;
		default:
			returnString = "www.sassiedev.com";
			break;
		}
		return returnString;
	}
	
	/**
	 * @return The sub-domain, domain, and top level domain, as string, for the given box set.
	 */
	protected String returnDomain(String s) {
		String SBUserName = Parameters.getSandboxUserName();
		String returnString = "";
		switch (Integer.valueOf(s)) {
		case 1:
			returnString = SBUserName + ".sassiedev.com";
			break;
		case 2:
			returnString = "www.sassiedev.com";
			break;
		case 3:
			returnString = "uat.sassieshop.com";
			break;
		case 4:
			returnString = "stage.sassieshop.com";
			break;
		case 5:
			returnString = "www.sassieshop.com";
			break;
		default:
			returnString = "www.sassiedev.com";
			break;
		}
		return returnString;
	}

	/**
	 * Set the current box set by passing an int
	 * @param i The int [1-5] to set as the current box set.
	 */
	protected void setBoxSetAsInt(int i) {
		this.boxSetAsInt = i;
		boxSetAsString = String.valueOf(i);
	}

	/**
	 * Set the current box set by passing a String
	 * @param s The String ["1"-"5"] to set as the current box set.
	 */
	protected void setBoxSetAsString(String s) {
		this.boxSetAsString = s;
		boxSetAsInt = Integer.valueOf(s);

	}

	//TODO: If this runs without these two, delete them soon.  Parameters was using them, but they may be unnecessary
	/*protected void update(int i) {
		boxSet n = new boxSet(i);
		boxSetAsInt = n.getBoxSetAsInt();
		boxSetAsString = n.getBoxSetAsString();
	}*/

	/*protected void update(String s) {
		boxSet n = new boxSet(s);
		boxSetAsInt = n.getBoxSetAsInt();
		boxSetAsString = n.getBoxSetAsString();
	}*/

	/**
	 * Returns the name of the current box set.<br>
	 * This is for debugging and reporting purposes.
	 * @return String containing the current box set name.
	 */
	protected String getBoxSetName() {
		switch (boxSetAsInt) {
		case 1:
			return "Sandbox";
		case 2:
			return "DEV";
		case 3:
			return "UAT";
		case 4:
			return "Stage";
		case 5:
			return "PROD";
		default:
			return "";
		}
	}
}
