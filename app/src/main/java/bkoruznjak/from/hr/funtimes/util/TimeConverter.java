package bkoruznjak.from.hr.funtimes.util;

import android.util.Log;

import org.ocpsoft.prettytime.PrettyTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by bkoruznjak on 09/12/2016.
 */

public enum TimeConverter {

    INSTANCE;

    PrettyTime prettyTime = new PrettyTime();

    public String convertToPrettyTime(String dateString, SimpleDateFormat dateFormat) {
        Date date = new Date();
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException parEx) {
            Log.e("TIMES", "Parse Exception:".concat(parEx.toString()));
        }
        return prettyTime.format(date);
    }
}
