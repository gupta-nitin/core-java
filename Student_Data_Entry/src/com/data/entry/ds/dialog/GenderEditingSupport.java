package com.data.entry.ds.dialog;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;

import com.data.entry.ds.Gender;
import com.data.entry.ds.Student;

public class GenderEditingSupport extends EditingSupport {

	private ColumnViewer columnViewer;
	private TableViewer tableViewer;
	private ComboBoxCellEditor boxCellEditor;

	public GenderEditingSupport(ColumnViewer columnViewer, TableViewer tableViewer) {
		super(columnViewer);
		this.columnViewer = columnViewer;
		this.tableViewer = tableViewer;
		String[] values = new String[]{Gender.MALE.getValue(), Gender.FEMALE.getValue()};
		boxCellEditor = new ComboBoxCellEditor(tableViewer.getTable(), values);
	}
	
	
	@Override
	protected CellEditor getCellEditor(Object element) {
		return boxCellEditor;
	}

	@Override
	protected boolean canEdit(Object element) {
		return true;
	}

	@Override
	protected Object getValue(Object element) {
		Student student = (Student) element;
		return student.getGender().getValue();
	}

	@Override
	protected void setValue(Object element, Object comboboxvalue) {
		Student student = (Student) element;
		String gendervalue = String.valueOf(comboboxvalue);
		for(Gender gender : Gender.values()){
			if(gendervalue.equals(gender.getValue())){
				student.setGender(gender);
			}
		}
	}

}
