package com.jfacetest;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class Employee_Dialog extends Dialog {

	private Text txtId;
	private Text txtName;
	
	protected Employee_Dialog(Shell parentShell) {
		super(parentShell);
	}
	
	
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite mainComposite = (Composite) super.createDialogArea(parent);
		mainComposite.setLayout(new GridLayout(1, true));
		mainComposite.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		Group group_1 = new Group(mainComposite, SWT.NONE);
		group_1.setLayoutData(new GridData(GridData.FILL_BOTH));
		group_1.setText("Group-1");
		group_1.setLayout(new GridLayout(2,false));
		
		Label lblId= new Label(group_1, SWT.NONE);
		lblId.setText("Employee ID");
		GridData gridDataLblId = new GridData();
		gridDataLblId.widthHint = 100;
		lblId.setLayoutData(gridDataLblId);
		
		txtId = new Text(group_1, SWT.BORDER);
		GridData gridDataTxtId = new GridData(SWT.FILL, SWT.CENTER, true, false);
		txtId.setLayoutData(gridDataTxtId);
		
		Label lblName = new Label(group_1, SWT.NONE);
		lblName.setText("Employee Name");
		GridData gridDatalblName = new GridData();
		gridDatalblName.widthHint =100;
		lblName.setLayoutData(gridDatalblName);
		
		txtName = new Text(group_1, SWT.BORDER);
		GridData gridDataTxtName = new GridData(SWT.FILL, SWT.CENTER, true, false);
		txtName.setLayoutData(gridDataTxtName);
		
		
		return mainComposite;
	}
	
	
	@Override
	protected void okPressed() {
		String msgDialogMessage = "Employee ID = " + txtId.getText() +" having Name = "+txtName.getText()+" sucessfully inserted in file";
		String msgDialogtitle = "Employee Data";
		MessageDialog.openInformation(new Shell(), msgDialogtitle, msgDialogMessage);
		
		super.okPressed();
	}
	
	@Override
	protected Point getInitialSize() {
		return new Point(300, 200);
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		Employee_Dialog employee_Dialog = new Employee_Dialog(new Shell());
		employee_Dialog.open();
	}

}


