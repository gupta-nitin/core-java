package com.jfacetest;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import com.ds.Student;

public class TestDialog extends Dialog{
	
	private static List<Student> listofStudents;
	private Table tableStudents;
	
	public TestDialog(Shell shell) {
		super(shell);
	}
	
	protected Composite createDialogArea(Composite parent){
		Composite mainComposite = (Composite) super.createDialogArea(parent);
		mainComposite.setLayout(new GridLayout(1,true));
		
		Composite container1 = new Composite(mainComposite, SWT.BORDER);
		container1.setLayoutData(new GridData(GridData.FILL_BOTH));
		container1.setLayout(new GridLayout(1, true));
		
		Label lblTitleForList = new Label(container1, SWT.NONE);
		lblTitleForList.setText("List of Students");
		lblTitleForList.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false));
		
		tableStudents = new Table(container1, SWT.BORDER);
		tableStudents.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		tableStudents.setLinesVisible(true);
		tableStudents.setHeaderVisible(true);
		
		TableColumn columnRollNo = new TableColumn(tableStudents, SWT.NONE);
		columnRollNo.setText("Roll No.");
		columnRollNo.setWidth(180);
		
		TableColumn columnName = new TableColumn(tableStudents, SWT.NONE);
		columnName.setText("Name");
		columnName.setWidth(180);
		
		for(Student studentObject : listofStudents){
			TableItem item = new TableItem(tableStudents, SWT.NONE);
			item.setText(new String[]{studentObject.getRollNo(), studentObject.getName()});
		}
		
		return mainComposite;
	}

	@Override
	protected void okPressed() {
		int selectedItem = tableStudents.getSelectionIndex();
		if (selectedItem > -1) {
			String message = "hello !!!! - from " + tableStudents.getItem(selectedItem).getText(1);
			String title = "Message From Student";
			MessageDialog.openInformation(new Shell(), title, message);
		}
		super.okPressed();
	}
	
	@Override
	protected Point getInitialSize() {
		return new Point(400, 300);
	}
	
	@Override
	protected void configureShell(Shell newShell) {
		newShell.setText("First JFace Dialog");
		super.configureShell(newShell);
	}
	
	public static void main(String[] args) {
		
		listofStudents = new ArrayList<>();
		
		Student student1 = new Student("101", "ABC");
		Student student2 = new Student("102", "Tom");
		Student student3 = new Student("103", "Lisa");
		Student student4 = new Student("104", "Jack");
		Student student5 = new Student("105", "XYZ");
		
		listofStudents.add(student1);
		listofStudents.add(student2);
		listofStudents.add(student3);
		listofStudents.add(student4);
		listofStudents.add(student5);
		
		TestDialog dialog = new TestDialog(new Shell());
		dialog.open();
	}
}
