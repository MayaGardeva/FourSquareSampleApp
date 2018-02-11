package com.api.foursquare.utility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by mayagardeva on 11/02/2018.
 */

public class DateUtility {

    public static String getCurrentDateAsString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.UK);
        return simpleDateFormat.format(new Date());
    }
}
