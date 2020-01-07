package com.jfacetest;

import java.util.ArrayList;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.ds.Student;

public class CustomDialog extends Dialog {
	public String name;
	public String age;
	public String gender;
	public boolean employeedInSixMonths;
	private Text text1 = null;
	private Text text2 = null;
	private Text text3 = null;
	private Button button = null;
	private Text text;

	public CustomDialog(Shell parentShell) {
		super(parentShell);
	}

	protected void okPressed() {
		// Do operations if you want, when ok button pressed
		name = text1.getText();
		age = text2.getText();
		gender = text3.getText();
		employeedInSixMonths = button.getSelection();

		super.okPressed();
	}

	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		composite.setLayout(new GridLayout(2, false));
		
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		composite.setLayout(gridLayout);

		Label label1 = new Label(composite, SWT.NONE);
		label1.setText("Name:");
		text1 = new Text(composite, SWT.BORDER);

		Label label2 = new Label(composite, SWT.NONE);
		label2.setText("Age:");
		text2 = new Text(composite, SWT.BORDER);
		Label label3 = new Label(composite, SWT.NONE);
		label3.setText("Gender:");
		text3 = new Text(composite, SWT.BORDER);

		button = new Button(composite, SWT.CHECK);
		button.setText("Have you been employed in the past six months?");

		GridData gridData1 = new GridData();
		GridData gridData2 = new GridData();
		GridData gridData3 = new GridData();

		gridData1.widthHint = 60;
		gridData2.widthHint = 60;
		gridData3.widthHint = 60;

		label1.setLayoutData(gridData1);
		label2.setLayoutData(gridData2);
		label3.setLayoutData(gridData3);

		GridData gridData4 = new GridData(GridData.FILL_HORIZONTAL);
		GridData gridData5 = new GridData(GridData.FILL_HORIZONTAL);
		GridData gridData6 = new GridData(GridData.FILL_HORIZONTAL);

		text1.setLayoutData(gridData4);
		text2.setLayoutData(gridData5);
		text3.setLayoutData(gridData6);

		GridData gridData7 = new GridData();
		gridData7.horizontalSpan = 2;
		button.setLayoutData(gridData7);

		return composite;
	}

	@Override
	 protected void configureShell(Shell newShell) {
	  super.configureShell(newShell);
	  newShell.setText("My Custom Dialog");
	 }

	 @Override
	 protected Point getInitialSize() {
	  return new Point(450, 300);
	 }

	 @Override
	 public String toString() {
	  return "CustomDialog [name=" + name + ", age=" + age + ", gender=" + gender + ", employeedInSixMonths="
	    + employeedInSixMonths + "]";
	 }


	
	public static void main(String[] args) {
		
		CustomDialog customDialog = new CustomDialog(new Shell());
		customDialog.open();
		
	}
}