package AutoSurf;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class FileOutput {
	static Instant startTime = null;
	static Instant endTime = null;

	
	/**
	 * This function checks the length of the passed .txt file, and if it is
	 * greater than 1MB, it makes a new .txt file with the current date after
	 * the filename and returns an empty .txt file.
	 * 
	 * @param f The .txt file to be checked.
	 * @return
	 */
	protected static File checkForArchive(File f) {
		if (f.length() >= 1024576) {
			String newName = f.getPath().replace(".txt",
					" " + LocalDate.now().toString() + ".txt");
			File g = new File(newName);
			if (!g.exists()) {
				try {
					g.createNewFile();
					PrintWriter out = new PrintWriter(new BufferedWriter(
							new FileWriter(g, true)));
					out.println(FileUtils.readFileToString(f));
					out.close();
					f.delete();
					f.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				try {
					PrintWriter out = new PrintWriter(new BufferedWriter(
							new FileWriter(g, true)));
					out.println(FileUtils.readFileToString(f));
					out.close();
					f.delete();
					f.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return f;
	}

	/**
	 * This function takes a list of TestResults and outputs them to the
	 * Results.txt file.
	 * 
	 * @param results
	 */
	protected static void printResults(List<TestResult> results) {
		Character sc = File.separatorChar;
		String userDirectory = System.getProperty("user.dir");
		File f = new File(userDirectory.replace('\\', sc).concat(
				sc + "Results.txt"));
		try (PrintWriter out = new PrintWriter(new BufferedWriter(
				new FileWriter(f, true)))) {
			if (!f.exists()) {
				f.createNewFile();
			}
			if (Debug.getDebugState() == true) {
				FileOutput.throwInDebug(ZonedDateTime.now().toString());
			} else {
				endTime = Instant.now();
				String d = Duration.between(startTime, endTime).toString();
				out.println("Run ended:\t\t" + endTime);
				out.println("Run started:\t" + startTime);
				out.println("Run duration:\t" + d);
			}

			int passes = 0;
			int fails = 0;
			for (int i = 0; i < results.size(); i++) {
				if (results.get(i).getResult() == true) {
					if (Debug.getDebugState() == true) {
						FileOutput.throwInDebug(results.get(i).getTestName()
								+ ": Pass");
					} else {
						out.println(results.get(i).getTestName() + ": Pass");
					}
					passes++;
				} else {
					if (Debug.getDebugState() == true) {
						FileOutput.throwInDebug(results.get(i).getTestName()
								+ ": Fail");
					} else {
						out.println(results.get(i).getTestName() + ": Fail");
					}
					fails++;
				}
			}
			if (Debug.getDebugState() == true) {
				FileOutput.throwInDebug("Run Complete: " + passes + " passed, "
						+ fails + " failed.");
				FileOutput.throwInDebug("");
			} else {
				out.println("Run Complete: " + passes + " passed, " + fails
						+ " failed.");
				out.println();
			}
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		checkForArchive(f);

	}

	/**
	 * Takes a list of strings and a file name and creates a .txt file with the
	 * contents. Adds the current time and date to the top of the file. If
	 * called with the same file name repeatedly, appends to the end of the
	 * file.
	 * 
	 * @param contents
	 *            The list of strings to be put into the file.
	 * @param fileName
	 *            The file name.
	 */
	protected static void printTextFile(List<String> contents, String fileName) {
		Character sc = File.separatorChar;
		String userDirectory = System.getProperty("user.dir");
		File f = new File(userDirectory.replace('\\', sc).concat(
				sc + fileName + ".txt"));
		try (PrintWriter out = new PrintWriter(new BufferedWriter(
				new FileWriter(f, true)))) {
			if (!f.exists()) {
				f.createNewFile();
			}
			out.println(ZonedDateTime.now());
			for (String s : contents) {
				out.println(s);
			}
			out.println();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		checkForArchive(f);
	}

	/**
	 * This function outputs a single string to the Debug.txt file.
	 * 
	 * @param s
	 */
	protected static void throwInDebug(String s) {
		Character sc = File.separatorChar;
		String userDirectory = System.getProperty("user.dir");
		File f = new File(userDirectory.replace('\\', sc).concat(
				sc + "Debug.txt"));
		try (PrintWriter out = new PrintWriter(new BufferedWriter(
				new FileWriter(f, true)))) {
			if (!f.exists()) {
				f.createNewFile();
				out.println(ZonedDateTime.now());
			}
			out.println(s);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This function takes a string and outputs it to the Results.txt file.
	 * 
	 * @param s
	 */
	protected static void throwInResults(String s) {
		Character sc = File.separatorChar;
		String userDirectory = System.getProperty("user.dir");
		File f = new File(userDirectory.replace('\\', sc).concat(
				sc + "Results.txt"));
		try (PrintWriter out = new PrintWriter(new BufferedWriter(
				new FileWriter(f, true)))) {
			if (!f.exists()) {
				f.createNewFile();
				out.println(ZonedDateTime.now());
			}
			out.println(s);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the startTime
	 */
	protected static Instant getStartTime() {
		return startTime;
	}

	/**
	 * Send this the start time for the full test, which currently is set for just after the user enters the Main sql password manually.<br>
	 * The printResults() function ends the time itself and prints the resulting time with the result list.
	 * @param startTime
	 */
	protected static void setStartTime(Instant startTime) {
		FileOutput.startTime = startTime;
		// sw = new StopWatch();
		// sw.start();
	}
}
