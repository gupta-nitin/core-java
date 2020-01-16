package com.data.entry.threading;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

import com.data.entry.ds.Student;

public class WriteThread extends Thread {

	private List<Student> studentList;
	private String outputfilepath;

	public WriteThread(List<Student> students, String outputFilePath) {
		this.studentList = students;
		this.outputfilepath = outputFilePath;
	}

	@Override
	public void run() {
		super.run();
		writeDataToOutputFile();
	}
	
	private void writeDataToOutputFile() {
		try {
			FileOutputStream outFileStream = new FileOutputStream(new File(outputfilepath));
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(outFileStream);
			objectOutputStream.writeObject(studentList);
		} catch (Exception exception) {
			MessageDialog.openError(new Shell(), "Failed",
					"Failed to write data to output file - " + exception.getMessage());
			exception.printStackTrace();
		}
	}
}
