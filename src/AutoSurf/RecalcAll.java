package AutoSurf;

//import org.openqa.selenium.Alert;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * TODO: IN PROGRESS
 * The idea behind this class is a file-configurable run that runs sequential recalcs, as requested by support.  
 * 
 * @author Bergie
 */
public class RecalcAll {
	static List<String> fromFile = new ArrayList<String>();
	static List<String> optionList = new ArrayList<String>();
	static List<String> recalcList = new ArrayList<String>();

	/**
	 * Checks for the existence of the RecalcAllOptions and RecalcAllResults
	 * files, calls to create them if they are not found.
	 */
	public static void checkForFiles() {
		Character sc = File.separatorChar;
		String userDirectory = System.getProperty("user.dir");
		String recalcOptionsFile = userDirectory.replace('\\', sc).concat(
				sc + "RecalcAllOptions" + ".txt");
		File f = new File(recalcOptionsFile);
		String recalcResultsFile = userDirectory.replace('\\', sc).concat(
				sc + "RecalcAllResults" + ".txt");
		File g = new File(recalcResultsFile);
		if (!f.exists()) {
			makeRecalcOptionsFile(f);
			System.out.println("RecalcAllOptions.txt file created at: "
					+ recalcOptionsFile);
		} else if (!g.exists()) {
			makeRecalcResultsFile(g);
		}

	}

	public static void main(String[] args) {
		// WebDriver driver = Master.getDriver();
		// WebDriverWait wait = Master.getWait();
		String runCheck = "Run: True";
		checkForFiles();
		readFromFile();
		if (fromFile.contains(runCheck)) {// Simple check to make sure this is
											// not a newly made options file.
											// Also, if the user can follow
											// directions.
			// Sort into the two lists.
			// Recalc!
		}
		System.out.println("Complete!");
	}

	/**
	 * Creates the RecalcAllOptions.txt file. Call only if the file does not
	 * exist.
	 * 
	 * @param f
	 *            The file to be created (file path already set).
	 */
	public static void makeRecalcOptionsFile(File f) {
		try {
			f.createNewFile();
			PrintWriter out = new PrintWriter(new BufferedWriter(
					new FileWriter(f, false)));
			out.println("How to use this file: \nThe lines below are your options, such as what boxset to recalc on.  Plese, only edit the specific option after the colon, and not the text of the file itself.");
			out.println("OPTIONS:");
			out.println("The run option is just a simple check to make sure this file has been edited.  Set it to True to allow the recalc to run. (True/False)");
			out.println("Run: False");
			out.println("Boxset determines which level you want to recalc on.  1 is Sandbox, 2 is Dev, 3 is UAT, 4 is Stage, and 5 is Production. (1-5)");
			out.println("Boxset: 0");
			out.println("Sandbox Username is only needed if Boxset is set to 1.  Only input your sandbox name prefix. ");
			out.println("Sandbox Username: jdoe");
			out.println("End on failed recalc determines if the program should continue to try to recalc the list of surveys after one has failed. (True/False)");
			out.println("End on failure: False");
			out.println("Close failed tabs determines if the program should leave tabs where a recalc failed open when continuing, or should close them and move on.  The final list of recalcs performed will state a failure if one occurs regardless.  This should likely be set to true for larger sets of recalcs, as each open tab will continue to consume memory.  (True/False)");
			out.println("Close failed tabs: False");
			out.println("Close completed tabs determines if the program should leave tabs open after a recalc completes successfully.  False = Leave them open on completion.  (True/False)");
			out.println("Close completed tabs: True");
			out.println();
			out.println("How to use this section:");
			out.println("MSP,ClientID,SurveyID");
			out.println("To individually list surveys for recalc, use the MSP directory name, the ClientID or 0, and the SurveyID. Example:");
			out.println("2qa,0,9076");
			out.println("To recalc all surveys for a particular client, list the MSP directory name and the ClientID, and then ALL.  Example:");
			out.println("2qa,113,ALL");
			out.println("To recalc all surveys for an MSP (Good Luck), list the MSP directory name and ALL,ALL. Example:");
			out.println("2qa,ALL,ALL");
			out.println("SURVEY LIST:");
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creates the RecalcAllResults.txt file. Call only if the file does not
	 * exist.
	 * 
	 * @param g
	 *            The file to be created (file path already set).
	 */
	public static void makeRecalcResultsFile(File g) {
		try {
			g.createNewFile();
			PrintWriter out = new PrintWriter(new BufferedWriter(
					new FileWriter(g, false)));
			out.println(LocalDate.now().toString());
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Reads the contents of the RecalcAllOptions file into the fromFile List.
	 */
	@SuppressWarnings("unchecked")
	public static void readFromFile() {
		Character sc = File.separatorChar;
		String userDirectory = System.getProperty("user.dir");
		String recalcOptionsFile = userDirectory.replace('\\', sc).concat(
				sc + "RecalcAllOptions" + ".txt");
		File f = new File(recalcOptionsFile);

		try {
			fromFile.addAll((Collection<? extends String>) Files.lines(f
					.toPath()));
		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * try{ long numberOfLines = Files.lines(f.toPath()).count();
		 * BufferedReader in = new BufferedReader(new FileReader(f)); for(int
		 * i=0;i<numberOfLines;i++){ optionList.add(in.readLine()); }
		 * in.close(); } catch(Exception e){ e.printStackTrace(); }
		 */

		return;
	}

	public static void splitContents() {

	}

}
