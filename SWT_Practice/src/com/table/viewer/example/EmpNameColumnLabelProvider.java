package com.table.viewer.example;

import org.eclipse.jface.viewers.ColumnLabelProvider;

import com.ds.Employee;

public class EmpNameColumnLabelProvider extends ColumnLabelProvider {

	@Override
	public String getText(Object element) {
		Employee employee = (Employee) element;
		return employee.getName();
	}
	
}
