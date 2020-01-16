package com.data.entry.editing;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ComboBoxViewerCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

import com.data.entry.ds.Gender;
import com.data.entry.ds.Student;

public class GenderCellEditing2 extends EditingSupport{

	private ComboBoxViewerCellEditor cellEditor;
	private TableViewer tableViewer;
	
	public GenderCellEditing2(ColumnViewer viewer, TableViewer tableViewer) {
		super(viewer);
		 cellEditor = new ComboBoxViewerCellEditor((Composite) getViewer().getControl(), SWT.READ_ONLY);
	        cellEditor.setLabelProvider(new LabelProvider());
	        cellEditor.setContenProvider(new ArrayContentProvider());
	        cellEditor.setInput(Gender.values());
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
		return Gender.values();
	}

	@Override
	protected void setValue(Object element, Object comoboBoxvalue) {
		Student student = (Student) element;
		if(comoboBoxvalue !=null){
		Gender gender = (Gender) comoboBoxvalue;
		student.setGender(gender);
			tableViewer.refresh();
		}
		
	}

	
	
}
