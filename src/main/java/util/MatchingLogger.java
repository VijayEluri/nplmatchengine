package util;

import java.io.IOException;

import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

public final class MatchingLogger {
	private static Logger logger;
	Appender appender;
	SimpleLayout layout;

	static MatchingLogger matchingLogger = null;

	public static Logger getLogger(String className) {
		if (matchingLogger == null) {
			try {
				// BasicConfigurator.configure();
				matchingLogger = new MatchingLogger(className);
			} catch (IOException e) {
				Toolbox.display(e.toString());
			}
		}
		return logger;

	}

	private MatchingLogger(String className) throws IOException {
		logger = Logger.getLogger(className);
		/*
		 * Set logger priority level programmatically. Though this is better
		 * done externally
		 */
		// if (Constant.DEBUGMODE)
		// logger.setLevel(Level.DEBUG);
		// else
		// logger.setLevel(Level.ERROR);
		/*
		 * Instantiate a layout and an appender, assign layout to appender
		 * programmatically
		 */
		layout = new SimpleLayout();
		// appender = new FileAppender(layout,
		// TestConstant.LOGDIRECTORY+"log.txt");
		appender = new ConsoleAppender(layout); // Appender is Interface
		/* Assign appender to the logger programmatically */
		// logger.addAppender(appender);
	}
	//
	//
	// public static Logger getLogger() {
	// return logger;
	// }

}
