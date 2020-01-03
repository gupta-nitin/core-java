package com.test;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;

public class GroupDemo {

	private static int xPosition = 30;
	private static int yPosition = 50;
	private static int shellWidth = 600;
	private static int shellHeight = 600;
	private static int groupWidth = 250;
	private static int groupHeight = 250;
	private static String[] countries = { "India", "Germany", "Canada", "Japan", "Sri Lanka", "Singpore", "Russia" };
	private static String[] hobbies = { "Trekking", "Movies", "Games", "Painting", "Singing", "Dancing" };

	private static void addWidgetsToShell(Display display, Shell shell) {
		Group group = new Group(shell, SWT.NONE);
		group.setBounds(10, 10, groupWidth, groupHeight);
		group.setText("Personal Information");
		
		Combo countryCombo = new Combo(group, SWT.DROP_DOWN);
		countryCombo.setItems(countries);
		countryCombo.setBounds(xPosition, yPosition, 150, 100);
		countryCombo.setText("Select Country");

		yPosition += 50;

		Combo hobbyCombo = new Combo(group, SWT.DROP_DOWN);
		hobbyCombo.setItems(hobbies);
		hobbyCombo.setBounds(xPosition, yPosition, 150, 100);
		hobbyCombo.setText("Select hobbies");

		yPosition += 50;

		Button button1 = new Button(group, SWT.PUSH);
		button1.setText("Submit");
		button1.setLocation(xPosition + 100, yPosition);
		button1.setSize(100, 20);

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
