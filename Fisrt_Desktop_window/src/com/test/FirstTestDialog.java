package com.test;


import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.DateTime;

public class FirstTestDialog extends Dialog {

	

	protected Object result;
	protected Shell shell;
	private Text text;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public FirstTestDialog(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent(), getStyle());
		shell.setSize(660, 300);
		shell.setText("Test Dialog");
		shell.setLayout(null);
		
		Composite composite = new Composite(shell, SWT.BORDER);
		composite.setBounds(10, 10, 276, 209);
		
		Label lblName = new Label(composite, SWT.NONE);
		lblName.setBounds(0, 10, 55, 15);
		lblName.setText("name ");
		
		text = new Text(composite, SWT.BORDER);
		text.setBounds(59, 10, 76, 21);
		
		Label lblGender = new Label(composite, SWT.NONE);
		lblGender.setBounds(0, 42, 55, 15);
		lblGender.setText("gender");
		
		Combo combo = new Combo(composite, SWT.NONE);
		combo.setItems(new String[] {"Male", "Female"});
		combo.setBounds(59, 37, 91, 23);
		
		Button btnMinor = new Button(composite, SWT.RADIO);
		btnMinor.setBounds(69, 69, 90, 16);
		btnMinor.setText("Minor");
		
		Button btnAdult = new Button(composite, SWT.RADIO);
		btnAdult.setBounds(172, 69, 90, 16);
		btnAdult.setText("Adult");
		
		Label lblDob = new Label(composite, SWT.NONE);
		lblDob.setBounds(0, 105, 55, 15);
		lblDob.setText("DOB");
		
		DateTime dateTime = new DateTime(composite, SWT.BORDER);
		dateTime.setBounds(55, 96, 80, 24);
		
		Button btnHavePassport = new Button(composite, SWT.CHECK);
		btnHavePassport.setText("have passport");
		btnHavePassport.setBounds(59, 137, 93, 16);
		
		Button btnSave = new Button(composite, SWT.NONE);
		btnSave.setBounds(84, 170, 75, 25);
		btnSave.setText("Save");
		
		btnSave.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("button clicked");
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				
			}
		});

	}
}
