package com.jfacetest;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class MessageDialogDemo2 {
	public static void main(String[] args) {
		System.out.println(System.getProperty("user.home"));

		Display display = new Display();
		Shell shell = new Shell(display);
		shell.open();

		MessageDialog.openConfirm(Display.getDefault().getActiveShell(), "Confirm Title",
				"This is Confirmation Message");
		MessageDialog.openError(Display.getDefault().getActiveShell(), "Error Title", "This is Error Message");
		MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Information Title",
				"This is Information Message");
		MessageDialog.openQuestion(Display.getDefault().getActiveShell(), "Question Title", "This is Question Message");
		MessageDialog.openWarning(Display.getDefault().getActiveShell(), "Warning Title", "This is Warning Message");

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		display.dispose();
	}
}
