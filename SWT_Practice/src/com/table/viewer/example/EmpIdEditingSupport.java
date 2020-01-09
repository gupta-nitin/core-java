package com.table.viewer.example;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;

import com.ds.Employee;

public class EmpIdEditingSupport extends EditingSupport {

	TextCellEditor cellEditor ;
	
	public EmpIdEditingSupport(ColumnViewer viewer, TableViewer tableViewer) {
		super(viewer);
		cellEditor = new TextCellEditor(tableViewer.getTable());
		
	}

	@Override
	protected CellEditor getCellEditor(Object element) {
		return cellEditor;
	}

	@Override
	protected boolean canEdit(Object element) {
		return true;
	}

	@Override
	protected Object getValue(Object element) {
		Employee employee = (Employee)element;
		return employee.getId();
	}
	
	@Override
	protected void setValue(Object element, Object newValue) {
		Employee employee = (Employee) element;
		String newIdValue = (String) newValue;
		employee.setId(newIdValue);
		getViewer().refresh();
	}
}
