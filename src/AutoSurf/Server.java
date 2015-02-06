/**
 * 
 */
package AutoSurf;

/**
 * This is a test class for use with Selenium Grid, hubs and nodes.<br>  Not ready for any machine but Bergie's laptop, please ignore.  
 * @author Bergie
 * 
 */
public class Server {
	static String seleniumVersion = "2.44.0";
	static String hubHost = "localhost";
	static String hubHostPort = "4444";
	static Process Hub = null;
	static Process Node = null;
	static Runtime rt = null;

	protected static void launchHub() {
		// C:\ProgramData\Oracle\Java\javapath\java.exe -jar
		// selenium-server-standalone-2.44.0.jar -role hub
		// C:\Users\Jonathan\workspace\AutoSurf\misc
		String[] cmd = new String[3];
		cmd[0] = "cmd.exe";
		cmd[1] = "cd C:\\Users\\Jonathan\\workspace\\AutoSurf\\misc";
		String javaPath = "\"";
		javaPath += System.getProperty("sun.boot.library.path");
		javaPath += "\\java.exe\" ";
		String s = "-jar selenium-server-standalone-" + seleniumVersion
				+ ".jar -role hub";
		String processPath = javaPath + s;
		System.out.println(processPath);
		cmd[2] = javaPath;
		System.out.println("javaPath: " + javaPath);
		cmd[2] = processPath;
		System.out.println("processPath: " + processPath);
		try {
			rt = Runtime.getRuntime();
			Hub = rt.exec(cmd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
		}
	}

	protected static void launchNode() {
		// C:\ProgramData\Oracle\Java\javapath\java.exe -jar
		// selenium-server-standalone-2.44.0.jar -role webdriver -hubHost
		// localhost –port 4444
		// C:\Users\Jonathan\workspace\AutoSurf\misc
		String[] cmd = new String[3];
		cmd[0] = "cmd.exe";
		cmd[1] = "cd C:\\Users\\Jonathan\\workspace\\AutoSurf\\misc";
		String javaPath = "\"";
		javaPath += System.getProperty("sun.boot.library.path");
		javaPath += "\\java.exe\" ";
		String s = "-jar selenium-server-standalone-" + seleniumVersion
				+ ".jar -role webdriver -hubHost " + hubHost + " –port "
				+ hubHostPort;
		String processPath = javaPath + s;
		System.out.println(processPath);
		cmd[2] = javaPath;
		cmd[2] = processPath;
		try {
			rt = Runtime.getRuntime();
			Node = rt.exec(cmd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
		}
	}

	protected static void cleanUp() {
		if (Hub != null) {
			Hub.destroy();
		}
		if (Node != null) {
			Node.destroy();
		}
	}

	//
}
