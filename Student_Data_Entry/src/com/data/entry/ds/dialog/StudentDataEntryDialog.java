package com.data.entry.ds.dialog;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

import com.data.entry.ds.Gender;
import com.data.entry.ds.Student;
import com.data.entry.editing.GenderCellEditing2;
import com.data.entry.editing.NameEditingSupport;
import com.data.entry.provider.AddressLableProvider;
import com.data.entry.provider.AgeLableProvider;
import com.data.entry.provider.ContactLabelProvider;
import com.data.entry.provider.GenderLabelProvider;
import com.data.entry.provider.NameLableProvider;
import com.data.entry.threading.WriteThread;
import com.data.entry.utils.ValidationUtils;

public class StudentDataEntryDialog extends TitleAreaDialog {

	private String appOutputFilePath;
	private Text txtName;
	private Text txtAge;
	private Text txtContact;
	private ComboViewer combogender;
	private List<Student> studentList;
	private TableViewer studentTableViewer;
	private StyledText txtAddress;

	public StudentDataEntryDialog(Shell parentShell, String appOutputFilePath) {
		super(parentShell);
		this.appOutputFilePath = appOutputFilePath;
		this.studentList = readDataFromFile();
	}

	private List<Student> readDataFromFile() {
		
		try (FileInputStream fileInputStream = new FileInputStream(appOutputFilePath);
				ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

			Object objectInfile = objectInputStream.readObject();
			if (objectInfile != null) {
				return (List<Student>) objectInfile;
			}

		} catch (Exception exception) {
			MessageDialog.openError(getParentShell(), "Failed to Read", "Failed to read object from file. New list will be created");
		}
		return new ArrayList<Student>();
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

		new Label(container_1, SWT.NONE); //

		Composite buttonComposite = new Composite(container_1, SWT.NONE);
		GridData buttonCompositeGridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
		buttonComposite.setLayoutData(buttonCompositeGridData);
		buttonComposite.setLayout(new GridLayout(2, true));

		createSaveDataButton(buttonComposite);

		createClearDataButton(buttonComposite);

		createTableViewer(container_1);

		return mainComposite;
	}

	private void createTableViewer(Composite container_1) {
		studentTableViewer = new TableViewer(container_1){
			@Override
			public void refresh() {
				ValidationUtils.ValidateStudentList(studentList);
				super.refresh();
			}
		};
		
		
		ColumnViewerToolTipSupport.enableFor(studentTableViewer);
		Table studentTable = studentTableViewer.getTable();
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.horizontalSpan = 2;
		studentTable.setLayoutData(gridData);
		studentTable.setLinesVisible(true);
		studentTable.setHeaderVisible(true);

		TableViewerColumn nameColumnViewer = new TableViewerColumn(studentTableViewer, SWT.NONE);
		nameColumnViewer.setLabelProvider(new NameLableProvider());
		TableColumn nameColumn = nameColumnViewer.getColumn();
		nameColumn.setText("Name");
		nameColumn.setWidth(100);
		nameColumnViewer.setEditingSupport(new NameEditingSupport(nameColumnViewer.getViewer(), studentTableViewer));

		TableViewerColumn ageColumnViewer = new TableViewerColumn(studentTableViewer, SWT.NONE);
		ageColumnViewer.setLabelProvider(new AgeLableProvider());
		TableColumn ageColumn = ageColumnViewer.getColumn();
		ageColumn.setText("Age");
		ageColumn.setWidth(50);

		TableViewerColumn contactColumnViewer = new TableViewerColumn(studentTableViewer, SWT.NONE);
		contactColumnViewer.setLabelProvider(new ContactLabelProvider());
		TableColumn contactColumn = contactColumnViewer.getColumn();
		contactColumn.setText("Contact");
		contactColumn.setWidth(100);

		TableViewerColumn genderColumnViewer = new TableViewerColumn(studentTableViewer, SWT.NONE);
		genderColumnViewer.setLabelProvider(new GenderLabelProvider());
		TableColumn genderColumn = genderColumnViewer.getColumn();
		genderColumn.setText("Gender");
		genderColumn.setWidth(100);
		genderColumnViewer.setEditingSupport(new GenderCellEditing2(genderColumnViewer.getViewer(), studentTableViewer));

		TableViewerColumn addressColumnViewer = new TableViewerColumn(studentTableViewer, SWT.NONE);
		addressColumnViewer.setLabelProvider(new AddressLableProvider());
		TableColumn addressColumn = addressColumnViewer.getColumn();
		addressColumn.setText("Address");
		addressColumn.setWidth(215);

		studentTableViewer.setContentProvider(new ArrayContentProvider());
		ValidationUtils.ValidateStudentList(studentList);
		studentTableViewer.setInput(studentList);
	

	}

	private void createClearDataButton(Composite container_1) {
		Button clearDataButton = new Button(container_1, SWT.PUSH);
		GridData gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
		clearDataButton.setLayoutData(gridData);

		clearDataButton.setText("Clear Data");
		clearDataButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				clearWidgets();
			}
		});

	}

	private void createSaveDataButton(Composite container_1) {
		Button saveDataButton = new Button(container_1, SWT.PUSH);
		GridData gridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
		saveDataButton.setLayoutData(gridData);
		saveDataButton.setText("Save Data");

		saveDataButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String name = txtName.getText();
				int age = Integer.parseInt(txtAge.getText());
				long contact = Long.parseLong(txtContact.getText());
				Gender gender = getSelectedGender();
				String address = txtAddress.getText();
				Student student = new Student(name, age, contact,gender, address);
				studentList.add(student);
				studentTableViewer.refresh();
				clearWidgets();
				MessageDialog.openInformation(getParentShell(), "Success", "Data Added Successfully...");
			}

			private Gender getSelectedGender() {
				StructuredSelection selection =(StructuredSelection) combogender.getSelection();
				return (Gender) selection.getFirstElement();
			}
		});
	}

	private void createAddressWidgets(Composite container_1) {
		Label lblAddress = new Label(container_1, SWT.NONE);
		lblAddress.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		lblAddress.setText("Address");

		txtAddress = new StyledText(container_1, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		GridData txtAddressGridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
		txtAddressGridData.heightHint = 60;
		txtAddress.setLayoutData(txtAddressGridData);

	}

	private void createGenderWidgets(Composite container_1) {
		Label lblGender = new Label(container_1, SWT.NONE);
		lblGender.setText("Gender");
		lblGender.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));

//		combogender = new Combo(container_1, SWT.DROP_DOWN);
//		combogender.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
//		combogender.setItems(new String[] { Gender.MALE.getValue(), Gender.FEMALE.getValue(), Gender.OTher.value() });

		combogender = new ComboViewer(container_1, SWT.READ_ONLY);
		combogender.setLabelProvider(new LabelProvider());
		combogender.setContentProvider(new ArrayContentProvider());
		combogender.setInput(Gender.values());
	}

	private void createContactWidgets(Composite container_1) {
		Label lblContact = new Label(container_1, SWT.NONE);
		lblContact.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		lblContact.setText("Contact");

		txtContact = new Text(container_1, SWT.BORDER);
		txtContact.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		txtContact.setTextLimit(10);
		txtContact.addVerifyListener(new VerifyListener() {

			@Override
			public void verifyText(VerifyEvent e) {
				verifyEnteredText(e);
			}
		});

	}

	private void createAgeWidgets(Composite container_1) {

		Label lblAge = new Label(container_1, SWT.NONE);
		lblAge.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		lblAge.setText("Age");

		txtAge = new Text(container_1, SWT.BORDER);
		txtAge.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		txtAge.setTextLimit(2);
		txtAge.addVerifyListener(new VerifyListener() {

			@Override
			public void verifyText(VerifyEvent e) {
				verifyEnteredText(e);
			}
		});

	}

	private void createNameWidgets(Composite container_1) {
		Label lblName = new Label(container_1, SWT.NONE);
		lblName.setText("Name");
		GridData lblGridData = new GridData(SWT.LEFT, SWT.CENTER, false, false);
		lblGridData.widthHint = 60;
		lblName.setLayoutData(lblGridData);

		txtName = new Text(container_1, SWT.BORDER);
		txtName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
	}

	private void clearWidgets() {
		txtName.setText("");
		txtAge.setText("");
		txtContact.setText("");
		combogender.refresh();
		txtAddress.setText("");
	}

	private void verifyEnteredText(VerifyEvent e) {
		String regex = "\\d";
		String enteredCharater = e.text;
		if (enteredCharater.isEmpty() || enteredCharater.matches(regex)) {
			e.doit = true;
		} else {
			e.doit = false;
		}
	}

	@Override
	protected void okPressed() {
		writeDataToOutputFile();
		super.okPressed();

	}

	
	private void writeDataToOutputFile() {
		try {
			FileOutputStream outFileStream = new FileOutputStream(new File(appOutputFilePath));
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(outFileStream);
			objectOutputStream.writeObject(studentList);
		} catch (Exception exception) {
			MessageDialog.openError(new Shell(), "Failed",
					"Failed to write data to output file - " + exception.getMessage());
			exception.printStackTrace();
		}
	}
	
	/*private void writeDataToOutputFile() {
				Thread writethread = new WriteThread(studentList, appOutputFilePath);
				writethread.run();
	}*/	
}


//Thread writethread = new WriteThread(studentList,appOutputFilePath);
//writethread.run()