package com.test;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class TableDemo {

	private static int shellWidth = 1000;
	private static int shellHeight = 700;

	private static int tableWidth = 800;
	private static int tableHeight = 600;

	private static int columnWidth = 200;

	private static void addWidgetsToShell(Display display, Shell shell) {

		Table employee = new Table(shell, SWT.FULL_SELECTION | SWT.CHECK | SWT.BORDER);
		employee.setBounds(100, 10, tableWidth, tableHeight);
		employee.setHeaderVisible(true);
		employee.setLinesVisible(true);

		TableColumn id = new TableColumn(employee, SWT.LEFT);
		id.setText("Id");
		id.setWidth(columnWidth);

		TableColumn name = new TableColumn(employee, SWT.LEFT);
		name.setText("Name");
		name.setWidth(columnWidth);

		TableColumn age = new TableColumn(employee, SWT.LEFT);
		age.setText("Age");
		age.setWidth(columnWidth);

		TableColumn city = new TableColumn(employee, SWT.LEFT);
		city.setText("City");
		city.setWidth(columnWidth);

		TableItem emp1 = new TableItem(employee, SWT.NONE);
		emp1.setText(new String[] { "1", "Hari Krishna", "26", "Bangalore" });
		emp1.setChecked(true);

		TableItem emp2 = new TableItem(employee, SWT.NONE);
		emp2.setText(new String[] { "2", "Ritweek", "29", "Bangalore" });

		TableItem emp3 = new TableItem(employee, SWT.NONE);
		emp3.setText(new String[] { "3", "Kiran", "28", "Bangalore" });
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