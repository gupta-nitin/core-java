package com.data.entry.ds.main;

import java.io.File;

import org.eclipse.swt.widgets.Shell;

import com.data.entry.Constants;
import com.data.entry.ds.dialog.StudentDataEntryDialog;

public class AppLauncher {

	private static String appOutputfilePath = Constants.DEFUALT_FILE_DIRECTORY + "/" + Constants.APP_OUPUT_FILE;

	public static void main(String[] args) {

		if (args != null && args.length > 0) {
			String directoryPath = args[0];
			validateandUpdateDirectory(directoryPath);
		}
		StudentDataEntryDialog dataEntryDialog = new StudentDataEntryDialog(new Shell(), appOutputfilePath);
		dataEntryDialog.open();
	}

	/**
	 * This method checks if the directory path passed by user command line
	 * argument is valid or not, if valid it modifies filePath value
	 * 
	 * @param directoryPath
	 * 
	 */
	private static void validateandUpdateDirectory(String directoryPath) {
		if (!directoryPath.trim().isEmpty()) {
			File tempDirectoryObject = new File(directoryPath);
			if (tempDirectoryObject.isDirectory() && tempDirectoryObject.exists()) {
				appOutputfilePath = tempDirectoryObject + "/" + Constants.APP_OUPUT_FILE;
			}
		}
	}

}
