package com.jfacetest;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class MessageDialogDemo {
	public static void main(String[] args) {

		Display display = new Display();
		Shell shell = new Shell(display);
		shell.open();

		String[] buttons = { "OK", "CANCEL", "NOT DECIDED" };
		Image IMAGE_APP_LOGO = new Image(null, "C://Users//Vivek//Desktop//temp//logo16.png");
		MessageDialog dialog = new MessageDialog(Display.getDefault().getActiveShell(), "Hello", IMAGE_APP_LOGO,
				"Hello Message", MessageDialog.INFORMATION, buttons, 2);
		int result = dialog.open();
		System.out.println("You clicked " + buttons[result]);
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
