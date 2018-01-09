package mx.neftaly.resuelve

import java.text.ParseException

class DatesValidator {

    static Boolean validate(String start, String finish) {
        try {
            new Date().parse("yyyy-MM-dd", start)
            new Date().parse("yyyy-MM-dd", finish)
        } catch (ParseException | NullPointerException ex) {
            return false
        }
        return true
    }
}
