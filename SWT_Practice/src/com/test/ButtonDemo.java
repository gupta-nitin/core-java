package com.test;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class ButtonDemo {

	private static int xPosition = 30;
	private static int yPosition = 30;
	private static int width = 500;
	private static int height = 30;
	private static int scrollWidth = 500;
	private static int scrollHeight = 350;

	private static int shellWidth = 600;
	private static int shellHeight = 600;

	private static void addTextToShell(Display display, Shell shell) {

		Text text1 = new Text(shell, SWT.BORDER);
		text1.setText("You can't edit me");
		text1.setBounds(xPosition, yPosition, width, height);
		text1.setEditable(false);

		yPosition += 40;

		Text text2 = new Text(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		text2.setText("Bordered scrolled text box");

		text2.setBounds(xPosition, yPosition, scrollWidth, scrollHeight);

		yPosition += 80;

		Button button1 = new Button(shell, SWT.PUSH);
		button1.setText("Submit");
		button1.setLocation(xPosition + 130, yPosition + 300);
		button1.setSize(100, 20);

		button1.addSelectionListener(new SelectionAdapter() {
		
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println(" Called from submit button");
			}
		});
		
		Button button2 = new Button(shell, SWT.PUSH);
		button2.setText("Cancel");
		button2.setLocation(xPosition + 260, yPosition + 300);
		button2.setSize(100, 20);

	}

	public static void main(String[] args) {
		Display display = new Display();

		Shell shell = new Shell(display);
		shell.setSize(shellWidth, shellHeight);

		addTextToShell(display, shell);
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		display.dispose();
	}
}
