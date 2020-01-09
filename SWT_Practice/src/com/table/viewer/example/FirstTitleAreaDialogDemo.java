package com.table.viewer.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.window.ToolTip;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

import com.ds.Employee;

public class FirstTitleAreaDialogDemo extends TitleAreaDialog{

	private static List<Employee> employeeList;
	private Text txtId;
	private Text txtName;
	private TableViewer tableViewer;

	public FirstTitleAreaDialogDemo(Shell shell) {
		super(shell);
	}
	
	@Override
	public void create() {
		super.create();
		setTitle("Feedback Form");
		setMessage("Feedback Form - User can provide feedback");
		try {
			setTitleImage(new Image(getShell().getDisplay(),
					new FileInputStream("C://Users//Vivek//Desktop//temp//logo16.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected Point getInitialSize() {
		return new Point(500, 500);
	}
	
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Feedback Form");
	}
	
	protected Composite createDialogArea(Composite parent){
		Composite mainComposite = (Composite) super.createDialogArea(parent);
		mainComposite.setLayout(new GridLayout());
		
		Composite container1 = new Composite(mainComposite, SWT.BORDER);
		container1.setLayoutData(new GridData(GridData.FILL_BOTH));
		container1.setLayout(new GridLayout(2,false));
		
		
		Label lblId = new Label(container1, SWT.NONE);
		lblId.setText("Employee Id");
		GridData lblIdGridData = new GridData(SWT.LEFT, SWT.CENTER,false,false);
		lblIdGridData.widthHint = 100;
		lblId.setLayoutData(lblIdGridData);
		
		txtId = new Text(container1, SWT.BORDER);
		txtId.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		Label lblName = new Label(container1, SWT.NONE);
		lblName.setText("Employee Name");
		GridData lblNameGridData = new GridData(SWT.LEFT, SWT.CENTER, false, false);
		lblName.setLayoutData(lblNameGridData);
		
		txtName = new Text(container1, SWT.BORDER);
		GridData txtNameGridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
		txtName.setLayoutData(txtNameGridData);
		
		
		Composite btnsComposite = new Composite(container1, SWT.NONE);
		GridData btnCompositeGridData = new GridData(SWT.FILL, SWT.CENTER, true, false);
		btnCompositeGridData.horizontalSpan =2;
		btnsComposite.setLayoutData(btnCompositeGridData);
		btnsComposite.setLayout(new GridLayout(2,true));
		
		createAddEmployeeButton(btnsComposite);
		
		createResetButton(btnsComposite);
		
		/*
		Text sampleTextBox = new Text(container1, SWT.BORDER);
		sampleTextBox.setLayoutData(new GridData(SWT.FILL,SWT.CENTER,true,false));
		
		sampleTextBox.addModifyListener(new ModifyListener() {
			
			@Override
			public void modifyText(ModifyEvent e) {
				String emailAddress = sampleTextBox.getText();
				if(!emailAddress.contains("@")){
					setErrorMessage("Invalid email address, please provide valid email address.");
				}else{
					setErrorMessage(null);
				}
				
			}
		});*/
		
		createTableViewer(container1);
		
		return mainComposite;
	}

	private void createAddEmployeeButton(Composite btnsComposite) {
		Button btnSaveData = new Button(btnsComposite, SWT.PUSH);
		btnSaveData.setText("Add Employee");
		GridData btnSaveDataGridData = new GridData(SWT.RIGHT, SWT.CENTER, true, false);
		btnSaveDataGridData.widthHint = 100;
		btnSaveData.setLayoutData(btnSaveDataGridData);
		btnSaveData.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String empId = txtId.getText();
				String empName = txtName.getText();
				Employee employee = new Employee(empId, empName);
				employeeList.add(employee);
				tableViewer.refresh();
				MessageDialog.openInformation(getParentShell(), "Success", "Data Added Successfuly");
			}
		});
	}

	private void createResetButton(Composite btnsComposite) {
		Button btnReset = new Button(btnsComposite, SWT.PUSH);
		btnReset.setText("Reset Data");
		GridData btnResetGridData = new GridData(SWT.CENTER, SWT.CENTER, true, false);
		btnResetGridData.widthHint = 100;
		btnReset.setLayoutData(btnResetGridData);
		btnReset.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				txtId.setText("");
				txtName.setText("");
			}
		});
	}

	private void createTableViewer(Composite container1) {
		tableViewer = new TableViewer(container1, SWT.MULTI|SWT.FULL_SELECTION|SWT.BORDER);
		ColumnViewerToolTipSupport.enableFor(tableViewer, ToolTip.NO_RECREATE);
		
		Table table = tableViewer.getTable();
		GridData tableGridData = new GridData(GridData.FILL_BOTH);
		tableGridData.horizontalSpan = 2;
		table.setLayoutData(tableGridData);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableViewerColumn idColumnViewer = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn idColumn = idColumnViewer.getColumn();
		idColumn.setText("Employee Id");
		idColumn.setWidth(240);
		idColumnViewer.setLabelProvider(new EmpIdColumnLabelProvider());
		idColumnViewer.setEditingSupport(new EmpIdEditingSupport(idColumnViewer.getViewer(), tableViewer));
		
		TableViewerColumn nameColumnViewer = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn nameColumn = nameColumnViewer.getColumn();
		nameColumn.setText("Employee Name");
		nameColumn.setWidth(240);
		nameColumnViewer.setLabelProvider(new EmpNameColumnLabelProvider());
		nameColumnViewer.setEditingSupport(new EmpNameColumnEditingSupport(nameColumnViewer.getViewer(), tableViewer));
		
		tableViewer.setContentProvider(new ArrayContentProvider());
		tableViewer.setInput(employeeList);
	}
	
	public static void main(String[] args) {
		
		employeeList = new ArrayList<>();
		employeeList.add(new Employee("101", "Tom"));
		employeeList.add(new Employee("102", "Jack"));
		employeeList.add(new Employee("103", "Lisa"));
		employeeList.add(new Employee("104", "Ram"));
		employeeList.add(new Employee("105", "Shyam"));
		
		
		FirstTitleAreaDialogDemo dialogDemo = new FirstTitleAreaDialogDemo(new Shell());
		dialogDemo.open();
	}
}
