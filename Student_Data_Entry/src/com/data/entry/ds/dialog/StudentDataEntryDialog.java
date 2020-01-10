package com.data.entry.ds.dialog;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;

import com.data.entry.ds.Gender;

public class StudentDataEntryDialog extends TitleAreaDialog {

	private String appOutputFilePath;
	private Text txtName;
	private Text txtAge;
	private Text txtContact;
	private Combo combogender;

	public StudentDataEntryDialog(Shell parentShell, String appOutputFilePath) {
		super(parentShell);
		this.appOutputFilePath = appOutputFilePath;
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Student Data Entry App - " + appOutputFilePath);
	}

	@Override
	public void create() {
		super.create();
		setTitle("Student Data Entry");
		setMessage("Standalone Application to record student data");
	}

	@Override
	protected Point getInitialSize() {
		return new Point(600, 700);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite mainComposite = (Composite) super.createDialogArea(parent);
		mainComposite.setLayout(new GridLayout(1, true));

		Composite container_1 = new Composite(mainComposite, SWT.BORDER);
		container_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		container_1.setLayout(new GridLayout(2, false));

		createNameWidgets(container_1);

		createAgeWidgets(container_1);

		createContactWidgets(container_1);

		createGenderWidgets(container_1);

		createAddressWidgets(container_1);
		
		createSaveDataButton(container_1);
		
		createClearDataButton(container_1);
		
		createTableViewer(container_1);
		
		return mainComposite;
	}

	private void createTableViewer(Composite container_1) {
		TableViewer studentTableViewer = new TableViewer(container_1);
		Table studentTable = studentTableViewer.getTable();
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.horizontalSpan = 2;
		studentTable.setLayoutData(gridData);
		
	}

	private void createClearDataButton(Composite container_1) {
		Button clearDataButton = new Button(container_1, SWT.PUSH);
		GridData gridData = new GridData(SWT.RIGHT, SWT.CENTER, false, false );
		gridData.widthHint = 100;
		clearDataButton.setLayoutData(gridData);
		
	}

	private void createSaveDataButton(Composite container_1) {
		Button saveDataButton = new Button(container_1, SWT.PUSH);
		GridData gridData = new GridData(SWT.RIGHT, SWT.CENTER, false, false );
		gridData.widthHint = 100;
		saveDataButton.setLayoutData(gridData);
		
	}

	private void createAddressWidgets(Composite container_1) {
		Label lblAddress = new Label(container_1, SWT.NONE);
		lblAddress.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		lblAddress.setText("Address");
		
		StyledText txtAddress = new StyledText(container_1, SWT.V_SCROLL | SWT.H_SCROLL);
		txtAddress.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		
	}

	private void createGenderWidgets(Composite container_1) {
		Label lblGender = new Label(container_1, SWT.NONE);
		lblGender.setText("Gender");
		lblGender.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));

		combogender = new Combo(container_1, SWT.DROP_DOWN);
		combogender.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		combogender.setItems(new String[] { Gender.MALE.getValue(), Gender.FEMALE.getValue() });

	}

	private void createContactWidgets(Composite container_1) {
		Label lblContact = new Label(container_1, SWT.NONE);
		lblContact.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		lblContact.setText("Contact");

		txtContact = new Text(container_1, SWT.BORDER);
		txtContact.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		txtContact.setTextLimit(10);

	}

	private void createAgeWidgets(Composite container_1) {

		Label lblAge = new Label(container_1, SWT.NONE);
		lblAge.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		lblAge.setText("Age");

		txtAge = new Text(container_1, SWT.BORDER);
		txtAge.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

	}

	private void createNameWidgets(Composite container_1) {
		Label lblName = new Label(container_1, SWT.NONE);
		lblName.setText("Name");
		GridData lblGridData = new GridData(SWT.LEFT, SWT.CENTER, false, false);
		lblGridData.widthHint = 100;
		lblName.setLayoutData(lblGridData);

		txtName = new Text(container_1, SWT.BORDER);
		txtName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
	}

}
