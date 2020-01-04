package com.test;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class FocusListnerDemo {

	private static int shellWidth = 400;
	private static int shellHeight = 400;

	private static void addWidgetsToShell(Display display, Shell shell) {

		FocusListener focusListener = new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				System.out.println(e.widget + " got focus");
			}

			@Override
			public void focusLost(FocusEvent e) {
				System.out.println(e.widget + " lost focus");
			}

		};

		TraverseListener traverseListener = new TraverseListener() {

			@Override
			public void keyTraversed(TraverseEvent e) {
				System.out.println(e.widget + " was traversed");
			}

		};

		Button b1 = new Button(shell, SWT.PUSH);
		Button b2 = new Button(shell, SWT.PUSH);
		Button b3 = new Button(shell, SWT.PUSH);
		Button b4 = new Button(shell, SWT.PUSH);
		Button b5 = new Button(shell, SWT.PUSH);
		Button b6 = new Button(shell, SWT.PUSH);
		b1.setBounds(10, 10, 50, 50);
		b2.setBounds(100, 10, 50, 50);
		b3.setBounds(200, 10, 50, 50);
		b4.setBounds(10, 100, 50, 50);
		b5.setBounds(100, 100, 50, 50);
		b6.setBounds(200, 100, 50, 50);
		b1.setText("1");
		b2.setText("2");
		b3.setText("3");
		b4.setText("4");
		b5.setText("5");
		b6.setText("6");

		b1.addFocusListener(focusListener);
		b2.addFocusListener(focusListener);
		b3.addFocusListener(focusListener);
		b4.addFocusListener(focusListener);
		b5.addFocusListener(focusListener);
		b6.addFocusListener(focusListener);

		b1.addTraverseListener(traverseListener);
		b2.addTraverseListener(traverseListener);
		b3.addTraverseListener(traverseListener);
		b4.addTraverseListener(traverseListener);
		b5.addTraverseListener(traverseListener);
		b6.addTraverseListener(traverseListener);

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