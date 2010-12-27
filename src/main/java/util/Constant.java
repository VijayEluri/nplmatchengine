package util;

/**
 * Constants used throughout the project
 * 
 * @author pd51444
 * 
 */
public final class Constant {

	public static final int METAPHONELENGTH = 15;
	public static final double MATCHSCORETHRESHOLD_TITLE_POST = 0.30;
	public static final double MATCHSCORETHRESHOLD_TITLE = 0.14;

	public static final String host = "jdbc:mysql://localhost/nplmatch";
	public static final String user = "pd51444";
	public static final String password = "pd51444";

	/**
	 * Category 0: NPL and abstracts from the same families Category 1:
	 * BIOSIS,Medline, EMBASE, FSTA Category 2: TDB, INSPEC, COMPDX
	 */

	public final static long BUFFER = 1000;

	public final static int NBABSTRACTS = 8;
	public final static int NPL = 0;
	public final static int TDB = 1;
	public final static int INSPEC = 2;
	public final static int COMPDX = 3;
	public final static int BIOSIS = 4;
	public final static int MEDLINE = 5;
	public final static int EMBASE = 6;
	public final static int FSTA = 7;
	public final static String ABSTRACTS[] = { "NPL       ", "TDB       ",
			"INSPEC    ", "COMPENDEX ", // to comply with Infotel naming
			// convention
			"BIOSIS    ", "MEDLINE   ", "EMBASE    ", "FSTA      " };

	// ranges of XP to be excluded from matching
	public final static int[][] RANGES = { { 14000000, 15000000 }, // ETSI
			{ 15000000, 16000000 }, // IETF
			{ 17000000, 17200000 }, // EIATIA
			{ 17200000, 17400000 }, // JPEG
			{ 17400000, 17600000 }, // ITU
			{ 30000000, 31000000 } // XPVIDEO
	};

	public final static String GROUPMEMBERSEPARATOR = ";";
	public final static String ANDATESEPARATOR = "@";
	public static final String GROUPELTSSEPARATOR = "|";
	public static final String AUTHORTITLESEPARATOR = "-";

	public static String HOMEDIRECTORY = "./";
	public static String DBDIRECTORY = HOMEDIRECTORY + "db/";
	public static String LOGDIRECTORY = HOMEDIRECTORY + "log/";
	public static String CONFDIRECTORY = HOMEDIRECTORY + "conf/";
	public static String DUMPDIRECTORY = HOMEDIRECTORY + "dump/";
	public static String EXPORTDIRECTORY = HOMEDIRECTORY + "export/";

	public static String GROUP_DBNAME = "group.db";
	public static String UPDATE_DBNAME = "update.db";

	public final static String CONFIGURATION_FNAME = ".nplmatch";

	public static boolean DEBUGMODE = false;

	public static final int EPOQUELAYOUT = 0;
	public static final int PADDINGEPOQUE = 20;

	public static final int MASTERLAYOUT = 1;

	public static class PaddingNPLMaster {
		public static final int ACTIONCODE = 1;
		public static final int GROUPNUM = 9;
		public static final int SUPPLIER = 10;
		public static final int MEMBER = 17;
	}

	public static final int BERKELEYLAYOUT = 2;

	public static final int DEBUGLAYOUT = 99;

	public static String TODAY = "19000101";
	public static String EOL = "\n";

	public static class ActionCode {
		public static String INSERT = "I";
		public static String UPDATE = "U";
		public static String DELETE = "D";
	}

	public static void setDirectories(String homeDirectory) {
		HOMEDIRECTORY = homeDirectory;

		DBDIRECTORY = HOMEDIRECTORY + "db/";
		LOGDIRECTORY = HOMEDIRECTORY + "log/";
		DUMPDIRECTORY = HOMEDIRECTORY + "dump/";
		EXPORTDIRECTORY = HOMEDIRECTORY + "export/";
	}

}
