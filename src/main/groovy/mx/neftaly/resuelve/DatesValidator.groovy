package mx.neftaly.resuelve

import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat

class DatesValidator {

    /**
     * Validates two Dates in YYYY-MM-DD format
     * @param start a Date on "yyyy-MM-dd" format
     * @param finish another Date on "yyyy-MM-dd" format
     * @return a boolean indicating if they are valid
     */
    static Boolean validate(String start, String finish) {
        try {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd")
            format.setLenient(true)
            format.parse(start)
            format.parse(finish)

        } catch (ParseException | NullPointerException ex) {
            return false
        }
        return true
    }


}
