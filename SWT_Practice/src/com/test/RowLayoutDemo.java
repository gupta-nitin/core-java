package com.test;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class RowLayoutDemo {

	private static void addWidgetsToShell(Display display, Shell shell) {

		RowLayout rowLayout = new RowLayout();
		 rowLayout.pack = true;
		 rowLayout.wrap = true;
		 rowLayout.justify = true;
		 rowLayout.type = SWT.VERTICAL;
		 rowLayout.marginLeft = 5;
		 rowLayout.marginTop = 5;
		 rowLayout.marginRight = 5;
		 rowLayout.marginBottom = 5;
		 rowLayout.spacing = 0;

		shell.setLayout(rowLayout);

		Button b1 = new Button(shell, SWT.PUSH);
		b1.setText("File");
		Button b2 = new Button(shell, SWT.PUSH);
		b2.setText("Edit");
		Button b3 = new Button(shell, SWT.PUSH);
		b3.setText("Source");
		Button b4 = new Button(shell, SWT.PUSH);
		b4.setText("Refactor");
		Button b5 = new Button(shell, SWT.PUSH);
		b5.setText("Navigate");
		Button b6 = new Button(shell, SWT.PUSH);
		b6.setText("Search");
		Button b7 = new Button(shell, SWT.PUSH);
		b7.setText("Search");
		Button b8 = new Button(shell, SWT.PUSH);
		b8.setText("Search");
		Button b9 = new Button(shell, SWT.PUSH);
		b9.setText("Search");
		Button b10 = new Button(shell, SWT.PUSH);
		b10.setText("Search");
	}

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setSize(800, 500);
		addWidgetsToShell(display, shell);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();

	}
}