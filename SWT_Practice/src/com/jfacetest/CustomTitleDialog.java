package com.jfacetest;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
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

public class CustomTitleDialog extends TitleAreaDialog {

	public String name;
	public String age;
	public String gender;
	public boolean employeedInSixMonths;
	private Text text1 = null;
	private Text text2 = null;
	private Text text3 = null;
	private Button button = null;

	public CustomTitleDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	public void create() {
		super.create();
		setTitle("This is my first custom dialog Title");
		setMessage("This is a TitleAreaDialog information message", IMessageProvider.INFORMATION);
	}

	@Override
	protected void okPressed() {
		// Do operations if you want, when ok button pressed
		name = text1.getText();
		age = text2.getText();
		gender = text3.getText();
		employeedInSixMonths = button.getSelection();

		super.okPressed();
	}

	
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite composite = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(composite, SWT.NONE);

		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		container.setLayout(gridLayout);

		Label label1 = new Label(container, SWT.NONE);
		label1.setText("Name:");
		text1 = new Text(container, SWT.BORDER);

		Label label2 = new Label(container, SWT.NONE);
		label2.setText("Age:");
		text2 = new Text(container, SWT.BORDER);

		Label label3 = new Label(container, SWT.NONE);
		label3.setText("Gender:");
		text3 = new Text(container, SWT.BORDER);

		button = new Button(container, SWT.CHECK);
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
		return new Point(500, 300);
	}

	@Override
	public String toString() {
		return "CustomDialog [name=" + name + ", age=" + age + ", gender=" + gender + ", employeedInSixMonths="
				+ employeedInSixMonths + "]";
	}

	
	public static void main(String[] args) {
		CustomTitleDialog customTitleDialog = new CustomTitleDialog(new Shell());
		customTitleDialog.open();
	}
}
