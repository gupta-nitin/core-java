package com.test;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class CompositeTest {

	private static int xPosition = 30;
	private static int yPosition = 30;

	private static int shellWidth = 600;
	private static int shellHeight = 600;

	private static int compositeWidth = 250;
	private static int compositeHeight = 250;

	private static String[] countries = { "India", "Germany", "Canada", "Japan", "Sri Lanka", "Singpore", "Russia" };

	private static void addWidgetsToShell(Display display, Shell shell) {

		Composite composite = new Composite(shell, SWT.BORDER);
		composite.setBackground(new Color(display, 102, 153, 153));
		composite.setBounds(10, 10, compositeWidth, compositeHeight);

		Combo combo = new Combo(composite, SWT.DROP_DOWN);
		combo.setItems(countries);
		combo.setBounds(xPosition, 20, 150, 100);
		combo.setText("Select your country");
		yPosition += 100;
		Button button1 = new Button(composite, SWT.PUSH);
		button1.setText("Submit");
		button1.setLocation(xPosition + 100, yPosition);
		button1.setSize(100, 20);

		button1.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				System.out.println("Country Selected is : " + countries[combo.getSelectionIndex()]);
			}
		});

		
		Label label = new Label(shell, SWT.BORDER);
		label.setText("inside shell");
		label.setLocation(xPosition , 400);
		label.setSize(100, 20);
	}

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.setSize(shellWidth, shellHeight);
		addWidgetsToShell(display, shell);

		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
