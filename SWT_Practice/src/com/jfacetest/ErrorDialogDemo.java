package com.jfacetest;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class ErrorDialogDemo {
	private static MultiStatus getMultiStatus(String msg, Throwable t) {

		List<Status> statuses = new ArrayList<Status>();
		StackTraceElement[] stackTraces = t.getStackTrace();

		for (StackTraceElement stackTrace : stackTraces) {
			Status status = new Status(IStatus.ERROR, ErrorDialogDemo.class.getName(), stackTrace.toString());
			statuses.add(status);
		}

		MultiStatus ms = new MultiStatus(ErrorDialogDemo.class.getName(), IStatus.ERROR,
				statuses.toArray(new Status[] {}), t.toString(), t);
		return ms;
	}

	public static void main(String[] args) {
		System.out.println(System.getProperty("user.home"));
		Display display = new Display();
		Shell shell = new Shell(display);
		shell.open();

		try {
			String s = null;
			s.toCharArray();
		} catch (Exception e) {
			String message = e.getMessage(); // custom message can be provided
			MultiStatus multiStatus = getMultiStatus(message, e);

			ErrorDialog dialog = new ErrorDialog(Display.getDefault().getActiveShell(), "Demo Error Dialog",
					"NullPointerException", multiStatus, IStatus.ERROR);
			dialog.open();
		}

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}

		display.dispose();
	}
}
