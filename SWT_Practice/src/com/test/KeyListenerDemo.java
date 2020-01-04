package com.test;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class KeyListenerDemo {

	private static int shellWidth = 400;
	private static int shellHeight = 400;

	private static void addWidgetsToShell(Display display, Shell shell) {

		Text text = new Text(shell, SWT.MULTI | SWT.BORDER);
		text.setBounds(10, 10, 300, 100);

		text.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				String result = "";
				switch (e.character) {
				case 0:
					result += " '\\0'";
					break;
				case SWT.BS:
					result += " '\\b'";
					break;
				case SWT.CR:
					result += " '\\r'";
					break;
				case SWT.DEL:
					result += " DEL";
					break;
				case SWT.ESC:
					result += " ESC";
					break;

				case SWT.LF:
					result += " '\\n'";
					break;
				default:
					result += " '" + e.character + "'";
					break;
				}
				System.out.println("Key Pressed ---->"+result);

			}

			@Override
			public void keyReleased(KeyEvent e) {

				if (e.stateMask == SWT.CTRL && e.keyCode != SWT.CTRL) {

					System.out.println("Command can execute here");
				}
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