package com.table.viewer.example;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;

import com.ds.Employee;

public class EmpNameColumnEditingSupport extends EditingSupport {

	private TextCellEditor textCellEditor;
	
	public EmpNameColumnEditingSupport(ColumnViewer columnViewer, TableViewer tableViewer) {
		super(columnViewer);
		textCellEditor = new TextCellEditor(tableViewer.getTable());
	}
	
	@Override
	protected CellEditor getCellEditor(Object element) {
		return textCellEditor;
	}
	
	@Override
	protected boolean canEdit(Object element) {
		return true;
	}
	
	@Override
	protected Object getValue(Object element) {
		Employee employee = (Employee) element;
		return employee.getName();
	}
	
	@Override
	protected void setValue(Object element, Object userInputValue) {
		Employee employee = (Employee) element;
		String newNameValue = (String) userInputValue;
		employee.setName(newNameValue);
		getViewer().refresh();
	}

}
