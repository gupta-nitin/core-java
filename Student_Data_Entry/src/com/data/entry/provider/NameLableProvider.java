package com.data.entry.provider;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

import com.data.entry.ds.Student;
import com.data.entry.ds.ValidationKeys;

public class NameLableProvider extends ColumnLabelProvider {

	public String getText(Object element){
		Student student = (Student) element;
		return student.getName();
	}
	
	@Override
	public Color getBackground(Object element) {
		Student student = (Student) element;
		if(student.getErrorMessages().containsKey(ValidationKeys.NAME_ERROR)){
			return new Color(Display.getCurrent(), new RGB(250,220,220));
		}
		return super.getBackground(element);
	}

	
	@Override
	public Color getForeground(Object element) {
		Student student = (Student) element;
		if(student.getErrorMessages().containsKey(ValidationKeys.NAME_ERROR)){
			return new Color(Display.getCurrent(), new RGB(255,0,0));
		}
		return super.getForeground(element);
	}
	
	@Override
	public String getToolTipText(Object element) {
		Student student = (Student)element;
		if(student.getErrorMessages().containsKey(ValidationKeys.NAME_ERROR)){
			return student.getErrorMessages().get(ValidationKeys.NAME_ERROR);
		}
		return null;
	}
	
}
