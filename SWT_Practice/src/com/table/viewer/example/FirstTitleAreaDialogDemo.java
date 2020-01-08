package com.table.viewer.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

import com.ds.Employee;

public class FirstTitleAreaDialogDemo extends TitleAreaDialog{

	private static List<Employee> employeeList;

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
		container1.setLayout(new GridLayout(1,false));
		
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
		});
		
		createTableViewer(container1);
		
		return mainComposite;
	}

	private void createTableViewer(Composite container1) {
		TableViewer tableViewer = new TableViewer(container1);
		Table table = tableViewer.getTable();
		table.setLayoutData(new GridData(GridData.FILL_BOTH));
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableViewerColumn idColumnViewer = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn idColumn = idColumnViewer.getColumn();
		idColumn.setText("Employee Id");
		idColumn.setWidth(240);
		idColumnViewer.setLabelProvider(new EmpIdColumnLabelProvider());
		
		TableViewerColumn nameColumnViewer = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn nameColumn = nameColumnViewer.getColumn();
		nameColumn.setText("Employee Name");
		nameColumn.setWidth(240);
		nameColumnViewer.setLabelProvider(new EmpNameColumnLabelProvider());
		
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
