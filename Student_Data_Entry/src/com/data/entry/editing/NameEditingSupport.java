package com.data.entry.editing;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;

import com.data.entry.ds.Student;

public class NameEditingSupport extends EditingSupport {
	
	private TextCellEditor cellEditor;
	private TableViewer tableViewer;

	public NameEditingSupport(ColumnViewer columnViewer, TableViewer tableViewer) {
		super(columnViewer);
		cellEditor = new TextCellEditor(tableViewer.getTable());
		this.tableViewer = tableViewer;
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
		Student student = (Student) element;
		return student.getName();
	}
	
	@Override
	protected void setValue(Object element, Object textboxvalue) {
		Student student = (Student) element;
		String newName = String.valueOf(textboxvalue);
		student.setName(newName);
		tableViewer.refresh();;
	}
	
}
