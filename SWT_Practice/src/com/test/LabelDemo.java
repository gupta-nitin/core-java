package com.test;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class LabelDemo {

	private static int xPosition = 30;
	private static int yPosition = 30;
	private static int width = 500;
	private static int height = 20;

	private static int shellWidth = 600;
	private static int shellHeight = 300;

	private static void addSeparator(Display display, Shell shell) {
		Label sep1 = new Label(shell, SWT.SEPARATOR);
		sep1.setBounds(30, 60, 100, 20);
		sep1.setSize(500, 2);
		sep1.setLocation(xPosition, yPosition);
		sep1.setBackground(new Color(display, 200, 111, 50));
	}

	private static void addLabelsToShell(Display display, Shell shell) {
		Label labelCenter = new Label(shell, SWT.CENTER|SWT.BORDER);
		labelCenter.setText("Label Center");
		labelCenter.setBounds(shell.getClientArea());
		labelCenter.setSize(width, height);
		labelCenter.setLocation(xPosition, yPosition);
		yPosition += 30;

		addSeparator(display, shell);
		yPosition += 30;

		Label labelLeft = new Label(shell, SWT.LEFT);
		labelLeft.setText("Label left");
		labelLeft.setBounds(shell.getClientArea());
		labelLeft.setSize(width, height);
		labelLeft.setLocation(xPosition, yPosition);
		yPosition += 30;

		addSeparator(display, shell);
		yPosition += 30;

		Label labelRight = new Label(shell, SWT.RIGHT);
		labelRight.setText("Label Right");
		labelRight.setBounds(shell.getClientArea());
		labelRight.setSize(width, height);
		labelRight.setLocation(xPosition, yPosition);
		yPosition += 30;
	}

	public static void main(String[] args) {

		/* Instantiate Display object, it represents SWT session */
		Display display = new Display();
		/*
		 * Define Shell, it represent a window, You can add more than one shell
		 * to Display
		 */
		Shell shell = new Shell(display);
		shell.setSize(shellWidth, shellHeight);

		addLabelsToShell(display, shell);

		/* Open shell window */
		shell.open();
		/*
		 * Run the event dispatching loop until an exit condition occurs, which
		 * is typically when the main shell window is closed by the user.
		 */

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		/* Dispose the display */
		display.dispose();
	}
}
