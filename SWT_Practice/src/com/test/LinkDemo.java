package com.test;

import java.awt.Desktop;
import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Shell;

public class LinkDemo {

	public static void main(String[] args) {
		Display display = new Display();
		Shell shell = new Shell(display);

		Link link = new Link(shell, SWT.NONE);
		String message = "This is a link to <a href=\"http://www.google.com/\">Google</a>";
		link.setText(message);
		link.setSize(400, 100);
		link.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("You have selected: " + e.text);
				try {
					Desktop.getDesktop().browse(java.net.URI.create(e.text));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}
