package dominicm.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class DateUtil {

	/**
	 * Convertir une date String en Date
	 * @param _date
	 * @return
	 * @throws ParseException
	 */
	public static Date stringToDate(String _date) throws ParseException {
		// convertir la date String en Date
		DateFormat df = DateFormat.getDateInstance();
		Date date = df.parse(_date);
		return date;
	}

}
