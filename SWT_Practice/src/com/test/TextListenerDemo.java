package com.test;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class TextListenerDemo {

	private static int shellWidth = 400;
	private static int shellHeight = 400;

	private static void addWidgetsToShell(Display display, Shell shell) {

		Text text = new Text(shell, SWT.MULTI | SWT.BORDER);
		text.setBounds(10, 10, 300, 100);

		text.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				System.out.println("Updated Text : " + text.getText());
			}

		});

		text.addVerifyListener(new VerifyListener() {

			@Override
			public void verifyText(VerifyEvent e) {
				if(e.character=='#'){
					e.doit = true;
					System.out.println("# is allowed");
				}else{
					e.doit = false;
					System.out.println(e.character +" is not allowed");
				}
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