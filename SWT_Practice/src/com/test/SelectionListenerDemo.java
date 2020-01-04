package com.test;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class SelectionListenerDemo{

	private static int xPosition = 30;
	private static int yPosition = 50;

	private static int shellWidth = 400;
	private static int shellHeight = 400;

	private static String[] countries = { "India", "Germany", "Canada", "Japan", "Sri Lanka", "Singpore", "Russia" };
	private static String[] hobbies = { "Trekking", "Movies", "Games", "Painting", "Singing", "Dancing" };

	private static void addWidgetsToShell(Display display, Shell shell) {

		Combo countryCombo = new Combo(shell, SWT.DROP_DOWN);
		countryCombo.setItems(countries);
		countryCombo.setBounds(xPosition, yPosition, 150, 100);
		countryCombo.setText("Select Country");
		yPosition += 50;

		Combo hobbyCombo = new Combo(shell, SWT.DROP_DOWN);
		hobbyCombo.setItems(hobbies);
		hobbyCombo.setBounds(xPosition, yPosition, 150, 100);
		hobbyCombo.setText("Select hobbies");

		yPosition += 50;

		Button button1 = new Button(shell, SWT.PUSH);
		button1.setText("Submit");
		button1.setLocation(xPosition + 100, yPosition);
		button1.setSize(100, 20);

		button1.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				int countryIndex = countryCombo.getSelectionIndex();
				int hobbyIndex = hobbyCombo.getSelectionIndex();

				String country = "No Country Selected";
				String hobby = "No Hobby Selected";

				country = (countryIndex > -1) ? countries[countryIndex] : country;
				hobby = (hobbyIndex > -1) ? hobbies[hobbyIndex] : hobby;

				System.out.println("Country selected : " + country);
				System.out.println("Hobby selected : " + hobby);

			}
		});

	}

	public static void main(String[] args) {

		System.out.println("Program started");
		Display display = new Display();
		Shell shell = new Shell();

		System.out.println("opening a window");
		
		addWidgetsToShell(display, shell);
		shell.open();

		
		System.out.println("waiting to shell dispose");
		// event loop
		while (!shell.isDisposed()) {
			if (display.readAndDispatch()) {
				display.sleep();
			}
		}

		System.out.println("Program terminated");

	}

}