package com.data.entry.utils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.data.entry.ds.Student;
import com.data.entry.ds.ValidationKeys;

public class ValidationUtils {

	public static void ValidateStudentList(List<Student> students) {
		for (Student student : students) {
			if (checkIfNameisEmptyString(student) && checkIfNameisAlpha(student)
					&& checkIfNameisDuplicate(student, students)) {
				// do nothing
			}
		}
	}

	private static boolean checkIfNameisEmptyString(Student student) {
		if (student.getName() != null && student.getName().trim().isEmpty()) {
			student.getErrorMessages().put(ValidationKeys.NAME_ERROR, "Student name should not be blank.");
			return false;
		} else {
			student.getErrorMessages().remove(ValidationKeys.NAME_ERROR);
		}
		return true;
	}

	private static boolean checkIfNameisAlpha(Student student) {
		Pattern pattern = Pattern.compile("^[a-zA-Z]*");
		Matcher matcher = pattern.matcher(student.getName());
		if (!matcher.matches()) {
			student.getErrorMessages().put(ValidationKeys.NAME_ERROR, "Student Name shold only contains Alphabets");
			return false;
		} else {
			student.getErrorMessages().remove(ValidationKeys.NAME_ERROR);
		}
		return true;
	}

	private static boolean checkIfNameisDuplicate(Student studentToValidate, List<Student> students) {
		int count = 0;
		for (Student student : students) {
			if (student.getName().equals(studentToValidate.getName())) {
				count++;
				if (count > 1) {
					studentToValidate.getErrorMessages().put(ValidationKeys.NAME_ERROR, "Duplicate Name found");
					return false;
				}
			}
		}
		studentToValidate.getErrorMessages().remove(ValidationKeys.NAME_ERROR);
		return true;
	}

}