package com.test;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class SWT_Empty_Window {

	public static void main(String[] args) {
		
		System.out.println("Program started");
		Display display = new Display();
		Shell shell = new Shell();
		
		System.out.println("opening a window");
		
		Label label = new Label(shell, SWT.CENTER);
		label.setText("hello !!! First SWT App");
		label.setBounds(shell.getClientArea());
		
		shell.open();
		
		
		System.out.println("waiting to shell dispose");
		//event loop
		while(!shell.isDisposed()){
			if(display.readAndDispatch()){
				display.sleep();
			}
		}
		
		System.out.println("Program terminated");
		
	}
	
}
