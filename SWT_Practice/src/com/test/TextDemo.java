package com.test;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class TextDemo {

	private static int xPosition = 30;
	private static int yPosition = 30;
	private static int width = 500;
	private static int height = 30;
	private static int scrollWidth = 500;
	private static int scrollHeight = 350;


	private static void addTextToShell(Display display, Shell shell) {

		Text text1 = new Text(shell, SWT.BORDER);
		text1.setText("Bordered text box");
		text1.setBounds(xPosition, yPosition, width, height);
//		text1.setEditable(false);
//		text1.setEnabled(false);
		//text1.setTextLimit(30);
		yPosition += 40;
		Text text2 = new Text(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		text2.setText("Bordered scrolled text box");
		text2.setBounds(xPosition, yPosition, scrollWidth, scrollHeight);
	}

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setSize(600, 600);

		addTextToShell(display, shell);
		
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		display.dispose();
	}
}
