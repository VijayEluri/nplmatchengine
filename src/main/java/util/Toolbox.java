package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import exception.ConfigurationException;
import exception.DirException;

public final class Toolbox {

	/**
	 * set the constants from the configuration file
	 * 
	 * @throws Exception
	 * @throws NumberFormatException
	 * @throws IOException
	 * @throws ConfigurationException
	 */
//	public static void readConfigFile() throws NumberFormatException,
//			ConfigurationException, IOException {
//		
//		Constant.TODAY = Toolbox.getDate("yyyyMMdd");
//		Constant.CONFDIRECTORY = Constant.HOMEDIRECTORY + "conf/";
//		// Constant.BUFFER=Long.parseLong(getParam("BUFFER"));
//
//		Constant.DBDIRECTORY = Constant.HOMEDIRECTORY
//				+ getParam("DBSUBDIRECTORY");
//		Constant.LOGDIRECTORY = Constant.HOMEDIRECTORY
//				+ getParam("LOGSUBDIRECTORY");
//		Constant.DUMPDIRECTORY = Constant.HOMEDIRECTORY
//				+ getParam("DUMPSUBDIRECTORY");
//		Constant.EXPORTDIRECTORY = Constant.HOMEDIRECTORY
//				+ getParam("EXPORTSUBDIRECTORY");
//
//		// Constant.NBCATEGORIES=Integer.parseInt(getParam("NBCATEGORIES"));
//		//Constant.NBABSTRACTS = Integer.parseInt(getParam("NBABSTRACTS"));
//
//		// Constant.GROUP_DBNAME = getParam("GROUP_DBNAME");
//		// Constant.UPDATE_DBNAME = getParam("UPDATE_DBNAME");
//
//		if (getParam("DEBUGMODE").equals("ON"))
//			Constant.DEBUGMODE = true;
//
//		// for(int i=0;i<Constant.NBABSTRACTS;i++) {
//		// Constant.SUPPLIERS.add(new
//		// Supplier(i,Constant.ABSTRACTS[i],Constant.CATEGORIES[i]));
//		// }
//
//	}

	public static void display(String str) {
		if (Constant.DEBUGMODE) {
			MatchingLogger.getLogger(Toolbox.class.getName()).debug(str);
		}
	}

	/**
	 ** pad a string S with a size of N with char C on the left (True) or on the
	 * right(false)
	 **/
	public static String paddingString(String s, int n, char c,
			boolean paddingLeft) {
		StringBuilder str = new StringBuilder(s);
		int strLength = str.length();
		if (n > 0 && n > strLength) {
			for (int i = 0; i <= n; i++) {
				if (paddingLeft) {
					if (i < n - strLength) {
						str.insert(0, c);
					}
				} else {
					if (i > strLength) {
						str.append(c);
					}
				}
			}
		}
		return str.toString();
	}

	//
	// /**
	// * Dump the berkeley database db to a ASCII file
	// * @param db
	// * @param databaseFileName
	// * @throws Exception
	// * @throws IOException
	// * @throws DatabaseException
	// * @throws UnsupportedEncodingException
	// */
	//
	// public static void dumpToFile(Transaction txn, Database db) throws
	// ConfigurationException, IOException, DatabaseException {
	// FileWriter fstreamMASTER=null;
	// FileWriter fstreamEPOQUE=null;
	// BufferedWriter fileMASTER = null;
	// BufferedWriter fileEPOQUE = null;
	// Cursor cursor = null;
	//
	// String fileNameMASTER=getParam("MASTER_FNAME");
	// String fileNameEPOQDUE=getParam("EPOQUE_FNAME");
	//
	// System.out.println("Exporting to "+ fileNameMASTER + "/" +
	// fileNameEPOQDUE);
	// fstreamMASTER = new FileWriter(Constant.EXPORTDIRECTORY+fileNameMASTER);
	// fstreamEPOQUE = new FileWriter(Constant.EXPORTDIRECTORY+fileNameEPOQDUE);
	// fileMASTER = new BufferedWriter(fstreamMASTER);
	// fileEPOQUE = new BufferedWriter(fstreamEPOQUE);
	//
	// // Open the cursor.
	// CursorConfig cursorConfig = new CursorConfig();
	// cursorConfig.setReadUncommitted(false);
	// cursor = db.openCursor(txn, cursorConfig);
	//
	// // Cursors need a pair of DatabaseEntry objects to operate. These hold
	// // the key and data found at any given position in the database.
	// DatabaseEntry foundKey = new DatabaseEntry();
	// DatabaseEntry foundData = new DatabaseEntry();
	//
	// TupleBinding groupBinding = new GroupBinding();
	//
	// Group group=null;
	//
	// StringBuffer[] lines=null;
	// StringBuffer[] stringBuffer = new StringBuffer[2];
	// stringBuffer[Constant.MASTERLAYOUT]=new StringBuffer();
	// stringBuffer[Constant.EPOQUELAYOUT]=new StringBuffer();
	//		
	// long nbLines=0;
	//		
	// while (cursor.getNext(foundKey, foundData, LockMode.DEFAULT) ==
	// OperationStatus.SUCCESS) {
	// try {
	// group= (Group)groupBinding.entryToObject(foundData);
	// lines=group.export();
	//				
	//				
	// if(!lines[Constant.MASTERLAYOUT].equals("")) {
	// nbLines++;
	// stringBuffer[Constant.MASTERLAYOUT].append(lines[Constant.MASTERLAYOUT]);
	// stringBuffer[Constant.EPOQUELAYOUT].append(lines[Constant.EPOQUELAYOUT]).
	// append("\r\n");
	// if(nbLines%100000==0) {
	// fileMASTER.write(stringBuffer[Constant.MASTERLAYOUT].toString());
	// fileEPOQUE.write(stringBuffer[Constant.EPOQUELAYOUT].toString());
	// stringBuffer[Constant.MASTERLAYOUT].setLength(0);
	// stringBuffer[Constant.EPOQUELAYOUT].setLength(0);
	// Toolbox.display(nbLines + " exported");
	// }
	// }
	// } catch (IOException e) {
	// e.printStackTrace();
	// } catch (RepException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// }
	// fileMASTER.write(stringBuffer[Constant.MASTERLAYOUT].toString());
	// fileEPOQUE.write(stringBuffer[Constant.EPOQUELAYOUT].toString());
	// Toolbox.display(nbLines + " exported");
	//
	// if(cursor!=null) {
	// cursor.close();
	// cursor=null;}
	// //txn.abort(); txn=null;
	// if(fileEPOQUE!=null) {fileEPOQUE.close();}
	// if(fileMASTER!=null) {fileMASTER.close();}
	// if(fstreamEPOQUE!=null) {fstreamEPOQUE.close();}
	// if(fstreamMASTER!=null) {fstreamMASTER.close();}
	//
	//
	// }
	//
	// public static void dumpToUpdateFile(Transaction txn, Database db) throws
	// ConfigurationException, IOException, DatabaseException {
	// FileWriter fstreamMASTER=null;
	// FileWriter fstreamEPOQUE=null;
	// BufferedWriter updatefileMASTER = null;
	// BufferedWriter updatefileEPOQUE = null;
	// Cursor cursor = null;
	//
	// String fileNameMASTER=getParam("MASTER_FNAME");
	// String fileNameEPOQDUE=getParam("EPOQUE_FNAME");
	//
	// System.out.println("Exporting to "+ fileNameMASTER + "/" +
	// fileNameEPOQDUE);
	// fstreamMASTER = new FileWriter(Constant.EXPORTDIRECTORY+fileNameMASTER);
	// fstreamEPOQUE = new FileWriter(Constant.EXPORTDIRECTORY+fileNameEPOQDUE);
	// updatefileMASTER = new BufferedWriter(fstreamMASTER);
	// updatefileEPOQUE = new BufferedWriter(fstreamEPOQUE);
	//
	// // Open the cursor.
	// CursorConfig cursorConfig = new CursorConfig();
	// cursorConfig.setReadUncommitted(false);
	// cursor = db.openCursor(txn, cursorConfig);
	//
	// // Cursors need a pair of DatabaseEntry objects to operate. These hold
	// // the key and data found at any given position in the database.
	// DatabaseEntry foundKey = new DatabaseEntry();
	// DatabaseEntry foundData = new DatabaseEntry();
	//
	// TupleBinding updateGroupBinding = new UpdateGroupBinding();
	//
	// UpdateGroup updateGroup=null;
	//
	// StringBuffer[] lines=null;
	// StringBuffer[] stringBuffer = new StringBuffer[2];
	// stringBuffer[Constant.MASTERLAYOUT]=new StringBuffer();
	// stringBuffer[Constant.EPOQUELAYOUT]=new StringBuffer();
	//		
	// long nbLines=0;
	//		
	// while (cursor.getNext(foundKey, foundData, LockMode.DEFAULT) ==
	// OperationStatus.SUCCESS) {
	// try {
	// updateGroup= (UpdateGroup)updateGroupBinding.entryToObject(foundData);
	// lines=updateGroup.export();
	//				
	//				
	// if(!lines[Constant.MASTERLAYOUT].equals("")) {
	// nbLines++;
	////stringBuffer[Constant.MASTERLAYOUT].append(updateGroup.getActionCode()).
	// append
	// (updateGroup.getGroupNum()).append(lines[Constant.MASTERLAYOUT]).append
	// ("\n");
	// stringBuffer[Constant.MASTERLAYOUT].append(lines[Constant.MASTERLAYOUT]);
	// stringBuffer[Constant.EPOQUELAYOUT].append(lines[Constant.EPOQUELAYOUT]).
	// append("\r\n");
	// if(nbLines%10000==0) {
	// updatefileMASTER.write(stringBuffer[Constant.MASTERLAYOUT].toString());
	// updatefileEPOQUE.write(stringBuffer[Constant.EPOQUELAYOUT].toString());
	// stringBuffer[Constant.MASTERLAYOUT].setLength(0);
	// stringBuffer[Constant.EPOQUELAYOUT].setLength(0);
	// }
	// }
	// } catch (IOException e) {
	// e.printStackTrace();
	// } catch (RepException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// }
	// updatefileMASTER.write(stringBuffer[Constant.MASTERLAYOUT].toString());
	// updatefileEPOQUE.write(stringBuffer[Constant.EPOQUELAYOUT].toString());
	// if(cursor!=null) {
	// cursor.close();
	// cursor=null;}
	// //txn.abort(); txn=null;
	// if(updatefileEPOQUE!=null) {updatefileEPOQUE.close();}
	// if(updatefileMASTER!=null) {updatefileMASTER.close();}
	// if(fstreamEPOQUE!=null) {fstreamEPOQUE.close();}
	// if(fstreamMASTER!=null) {fstreamMASTER.close();}
	//
	//
	// }

	// public static boolean isValid(String xnpl) {
	// boolean valid=false;
	// if(!xnpl.equals("")) {
	// Matcher matcher = Patterns.INVALIDXNPL.getPattern().matcher(xnpl);
	// valid=!matcher.find();
	// }
	//
	// return valid;
	// }

	// Deletes all files and subdirectories under dir.
	// Returns true if all deletions were successful.
	// If a deletion fails, the method stops attempting to delete and returns
	// false.
	public static boolean deleteDir(File dir) throws DirException {
		if (dir.isDirectory()) {
			if (!dir.getPath().contains("nplmatch"))
				throw new DirException();
			String[] children = dir.list();
			for (int i = 0; i < children.length; i++) {
				boolean success = deleteDir(new File(dir, children[i]));
				if (!success) {
					return false;
				}
			}
		}

		// The directory is now empty so delete it
		return dir.delete();
	}

	public static String getDate(String format) {
		DateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(new Date());
	}

	public static String getDate() {
		return getDate("yyyyMMdd");
	}

	public static String getTime() {
		return getDate("yyyyMMdd hh:mm:ss");
	}

//	public static String getParam(String param) throws ConfigurationException,
//			IOException {
//		return (new Configuration()).getConfig(param).trim();
//	//			Constant.CONFDIRECTORY + Constant.CONFIGURATION_FNAME, param)				.trim();
//	}

	
//	public static String getParam(String confDir, String param)
//			throws ConfigurationException, IOException {
//		return Configuration.getConfig(confDir + Constant.CONFIGURATION_FNAME,
//				param).trim();
//	}

	/**
	 * @param param
	 * @param value
	 * @throws IOException
	 */
//	public static void setParam(String param, String value) throws IOException {
//		Configuration.setConfig(Constant.CONFDIRECTORY
//				+ Constant.CONFIGURATION_FNAME, param, value);
//	}

	public static boolean copyFile(String srcStr, String destStr) {
		boolean retCode = true;

		File src = new File(srcStr);
		File dest = new File(destStr);

		FileInputStream fis;
		try {
			fis = new FileInputStream(src);
			FileOutputStream fos = new FileOutputStream(dest);

			java.nio.channels.FileChannel channelSrc = fis.getChannel();
			java.nio.channels.FileChannel channelDest = fos.getChannel();

			channelSrc.transferTo(0, channelSrc.size(), channelDest);

			fis.close();
			fos.close();
		} catch (Exception exception) {
			exception.printStackTrace();
			retCode = false;
		}
		return retCode;
	}

}
