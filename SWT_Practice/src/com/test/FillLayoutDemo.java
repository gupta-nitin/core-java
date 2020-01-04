package com.test;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class FillLayoutDemo {

	private static void addWidgetsToShell(Display display, Shell shell) {

		FillLayout fillLayout = new FillLayout();
		 fillLayout.type = SWT.VERTICAL;

		shell.setLayout(fillLayout);
		Label label0 = new Label(shell, SWT.NONE);
		label0.setText("File");
		Label label1 = new Label(shell, SWT.NONE);
		label1.setText("Edit");
		Label label2 = new Label(shell, SWT.NONE);
		label2.setText("Source");
		Label label3 = new Label(shell, SWT.NONE);
		label3.setText("Refactor");
		Label label4 = new Label(shell, SWT.NONE);

		label4.setText("Navigate");
		Label label5 = new Label(shell, SWT.NONE);
		label5.setText("Search");
		Label label6 = new Label(shell, SWT.NONE);
		label6.setText("Project");
		Label label7 = new Label(shell, SWT.NONE);
		label7.setText("Run");
		Label label8 = new Label(shell, SWT.NONE);
		label8.setText("Window");
		Label label9 = new Label(shell, SWT.NONE);
		label9.setText("Help");
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
