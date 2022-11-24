package com.example.student.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class DateUtils {

	public String convertToSqlToUiDate(Date date) {
		SimpleDateFormat uiFormat = new SimpleDateFormat("dd-MM-yyyy");
		String dbDate = null;
		try {
			dbDate = uiFormat.format(date);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return dbDate;
	}

	public Date convertyyyymmddToDate(String stringDate) {
		Date date = null;
		try {
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			date = (Date) formatter.parse(stringDate);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}
}
