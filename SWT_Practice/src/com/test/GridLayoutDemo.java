package com.test;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class GridLayoutDemo {

	private static void addWidgetsToShell(Display display, Shell shell) {

		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		shell.setLayout(gridLayout);

		Label label1 = new Label(shell, SWT.NONE);
		label1.setText("Name:");
		Text text1 = new Text(shell, SWT.BORDER);

		Label label2 = new Label(shell, SWT.NONE);
		label2.setText("Age:");
		Text text2 = new Text(shell, SWT.BORDER);

		Label label3 = new Label(shell, SWT.NONE);
		label3.setText("Gender:");
		Text text3 = new Text(shell, SWT.BORDER);

		Button button = new Button(shell, SWT.CHECK);
		button.setText("Have you been employed in the past six months?");

		GridData gridData1 = new GridData();
		GridData gridData2 = new GridData();
		GridData gridData3 = new GridData();

		gridData1.widthHint = 60;
		gridData2.widthHint = 60;
		gridData3.widthHint = 60;

		label1.setLayoutData(gridData1);
		label2.setLayoutData(gridData2);
		label3.setLayoutData(gridData3);

		GridData text1GridData = new GridData();
		text1GridData.widthHint = 50;
		text1.setLayoutData(text1GridData);
		
		text2.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		text3.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		GridData gridData7 = new GridData();
		gridData7.horizontalSpan = 2;
		button.setLayoutData(gridData7);

		shell.open();

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