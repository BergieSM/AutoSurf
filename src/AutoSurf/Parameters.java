/**
 * 
 */
package AutoSurf;

import java.util.List;

/**
 * @author Bergie
 * 
 */
public class Parameters {
	static String sqlUserName;
	static String sqlPassword;
	static String sandboxUserName;
	static String MSP;
	static String client;
	static String sessionName;
	static String survey;
	static boxSet boxSet;
	static Parameters parameters = null;
	// TestResult current = null;
	static String remoteURL;

	/**
	 * @return the parameters
	 */
	protected static Parameters getParameters() {
		return parameters;
	}

	/**
	 * @param parameters
	 *            the parameters to set
	 */
	protected static void setParameters(Parameters p) {
		parameters = p;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Parameters [sqlUserName=" + sqlUserName + ", sqlPassword="
				+ sqlPassword + ", sandboxUserName=" + sandboxUserName
				+ ", MSP=" + MSP + ", client=" + client + ", sessionName="
				+ sessionName + ", survey=" + survey + ", boxSet=" + boxSet
				+ "]";
	}

	protected Parameters() {
		sqlUserName = "sql";
		sqlPassword = "";
		sandboxUserName = "jbergstrom";
		MSP = "2_qa";
		client = "Bergie";
		sessionName = "Automation";
		survey = "Test1";
		boxSet = new boxSet(2);
		remoteURL = "http://localhost:4444";
	}

	/**
	 * @param p
	 *            List<String>, with these strings in order:</br> sqlUserName,
	 *            sqlPassword, sandboxUserName, MSP, client, sessionName,
	 *            survey, boxSet
	 */
	protected static void update(List<String> p) {
		sqlUserName = p.get(0);
		sqlPassword = p.get(1);
		sandboxUserName = p.get(2);
		MSP = p.get(3);
		client = p.get(4);
		sessionName = p.get(5);
		survey = p.get(6);
		//boxSet.update(p.get(7)); //If below function works, delete asap.
		boxSet.setBoxSetAsString(p.get(7));
	}

	/**
	 * @return the sqlUserName
	 */
	protected static String getSqlUserName() {
		return sqlUserName;
	}

	/**
	 * @param sqlUserName
	 *            the sqlUserName to set
	 */
	protected static void setSqlUserName(String sqlUserName) {
		Parameters.sqlUserName = sqlUserName;
	}

	/**
	 * @return the sqlPassword
	 */
	protected static String getSqlPassword() {
		return sqlPassword;
	}

	/**
	 * @param sqlPassword
	 *            the sqlPassword to set
	 */
	protected static void setSqlPassword(String s) {
		sqlPassword = s;
	}

	/**
	 * @return the sandboxUserName
	 */
	protected static String getSandboxUserName() {
		return sandboxUserName;
	}

	/**
	 * @param sandboxUserName
	 *            the sandboxUserName to set
	 */
	protected static void setSandboxUserName(String sandboxUserName) {
		Parameters.sandboxUserName = sandboxUserName;
	}

	/**
	 * @return the mSP
	 */
	protected static String getMSP() {
		return MSP;
	}

	/**
	 * @param mSP
	 *            the mSP to set
	 */
	protected static void setMSP(String mSP) {
		MSP = mSP;
	}

	/**
	 * @return the client
	 */
	protected static String getClient() {
		return client;
	}

	/**
	 * @param client
	 *            the client to set
	 */
	protected static void setClient(String client) {
		Parameters.client = client;
	}

	/**
	 * @return the sessionName
	 */
	protected static String getSessionName() {
		return sessionName;
	}

	/**
	 * @param sessionName
	 *            the sessionName to set
	 */
	protected static void setSessionName(String sessionName) {
		Parameters.sessionName = sessionName;
	}

	/**
	 * @return the survey
	 */
	protected static String getSurvey() {
		return survey;
	}

	/**
	 * @param survey
	 *            the survey to set
	 */
	protected static void setSurvey(String survey) {
		Parameters.survey = survey;
	}

	/**
	 * @return the boxSet
	 */
	protected static boxSet getBoxSet() {
		return boxSet;
	}

	/**
	 * @param boxSet
	 *            the boxSet to set
	 */
	protected static void setBoxSet(boxSet boxSet) {
		Parameters.boxSet = boxSet;
	}

	/**
	 * 
	 * @return the client/survey pair
	 */
	protected static String getClientSurvey() {
		String clientSurvey = client + ": " + survey;
		return clientSurvey;
	}

	protected static void setBoxSet(int i) {
		Parameters.boxSet = new boxSet(i);
	}

	protected static void setBoxSet(String s) {
		Parameters.boxSet = new boxSet(s);
	}

	protected static void print() {
		FileOutput.throwInResults(parameters.toString());
	}

	/**
	 * @return the remoteURL
	 */
	protected static String getRemoteURL() {
		return remoteURL;
	}

	/**
	 * @param remoteURL
	 *            the remoteURL to set
	 */
	protected static void setRemoteURL(String remoteURL) {
		Parameters.remoteURL = remoteURL;
	}
}
