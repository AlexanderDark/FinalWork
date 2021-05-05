package utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateParcer {
    public Date parcerDate (String stringDate) {

        int placeOfDash = 0;
        placeOfDash = stringDate.indexOf("-");
        int endNum = stringDate.length();
        if (placeOfDash != -1) {
            stringDate = stringDate.substring(placeOfDash+2, endNum);
        }
        DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
        Date dateFromCard = null;
        try {
            dateFromCard = dateFormat.parse(stringDate);
        } catch (ParseException e) {
            System.out.println(e);
        }
        return dateFromCard;
    }
}
