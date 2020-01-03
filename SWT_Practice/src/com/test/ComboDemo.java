package com.test;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class ComboDemo {

	private static int xPosition = 30;
	private static int yPosition = 30;
	private static int width = 500;
	private static int height = 30;
	private static int shellWidth = 600;
	private static int shellHeight = 600;

	private static String[] countries = { "India", "Germany", "Canada", "Japan", "Sri Lanka", "Singpore", "Russia" };

	private static void addWidgetsToShell(Shell shell) {

		Label label = new Label(shell, SWT.NONE);
		label.setText("Select your Country : ");
		label.setLocation(xPosition, yPosition);
		label.setSize(150, height);

		Combo combo = new Combo(shell, SWT.DROP_DOWN);
		combo.setItems(countries);
		combo.setBounds(xPosition + 150, 20, 150, 100);
		combo.setText("Select your country");
		yPosition += 100;
		Button button1 = new Button(shell, SWT.PUSH);
		button1.setText("Submit");
		button1.setLocation(xPosition + 100, yPosition);
		button1.setSize(100, 20);
		button1.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				System.out.println("Country Selected is : " + countries[combo.getSelectionIndex()]);
			}
		});

	}

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setSize(shellWidth, shellHeight);
		addWidgetsToShell(shell);

		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
