package com.test;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class MouseListenerDemo {
	private static int shellWidth = 400;
	private static int shellHeight = 400;

	private static void addWidgetsToShell(Display display, Shell shell) {
		Text text = new Text(shell, SWT.MULTI | SWT.BORDER);
		text.setBounds(10, 10, 300, 100);
		text.setEditable(false);
		text.setText("Click me to see the affect in console");

		text.addMouseListener(new MouseListener() {

			@Override
			public void mouseDoubleClick(MouseEvent e) {
				System.out.println("Mouse double clicked");
			}

			@Override
			public void mouseDown(MouseEvent e) {
				System.out.println("Mouse pressed down");
			}

			@Override
			public void mouseUp(MouseEvent e) {
				System.out.println("Mouse is released");
			}

		});

		text.addMouseMoveListener(new MouseMoveListener() {

			@Override
			public void mouseMove(MouseEvent e) {
				System.out.println("Mouse moved");
			}

		});

		text.addMouseTrackListener(new MouseTrackListener() {

			@Override
			public void mouseEnter(MouseEvent e) {
				System.out.println("Mouse Entered");
			}

			@Override
			public void mouseExit(MouseEvent e) {
				System.out.println("Mouse Exited");
			}

			@Override
			public void mouseHover(MouseEvent e) {
				System.out.println("Mouse Hover");
			}

		});
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