package com.table.viewer.example;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

import com.ds.Employee;

public class EmpIdColumnLabelProvider extends ColumnLabelProvider {

	@Override
	public String getText(Object element) {
		Employee employee = (Employee) element;
		return employee.getId();
	}
	

	  @Override
	  public String getToolTipText(Object element) {
	    Employee employee = (Employee)element;
	    String tooltipMessage = "Employee Id = "+ employee.getId();
	    return tooltipMessage;
	  }

	  
	  @Override
	public int getToolTipDisplayDelayTime(Object object) {
		return super.getToolTipDisplayDelayTime(object);
	}
	  
	 @Override
	public Color getForeground(Object element) {
		 return new Color(Display.getCurrent(), new RGB(0, 0, 255));
	}
	 
	 @Override
	public Color getBackground(Object element) {
		 return new Color(Display.getCurrent(), new RGB(120, 150, 170));
	}
}
