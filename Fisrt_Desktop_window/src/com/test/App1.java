package com.test;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class App1 {

	public static void main(String[] args) {
		FirstTestDialog dialog =  new FirstTestDialog(new Shell(new Display()), SWT.CLOSE);
		dialog.open();
	}
	
}
