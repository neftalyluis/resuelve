package mx.neftaly.resuelve

import groovy.time.TimeCategory

class DaysComparator {

    /**
     * Divides a range of dates into two, if the range of Dates is invalid the function returns a Map with two empty keys
     * @param startDate The start Date on YYYY-MM-DD format
     * @param endDate The end Date on YYYY-MM-DD format
     * @return A map with keys left and right where left is the earliest date range and right the latest, and value and Array of size 2 with the Dates on YYYY-MM-DD format
     */
    static Map divideInTwoRanges(String startDate, String endDate) {

        if (!DatesValidator.validate(startDate, endDate)) {
            return [left: [], right: []]
        }

        def start = convertToDate(startDate)
        def end = convertToDate(endDate)
        def rangeOfDays = daysBetween(start, end)

        def leftEndDate, rightStartingDate

        if (rangeOfDays % 2 == 0) {
            leftEndDate = addDaysToDate(start, rangeOfDays / 2 as Long)
            rightStartingDate = substractDaysToDate(end, (rangeOfDays / 2) - 1 as Long)
        } else {
            leftEndDate = addDaysToDate(start, rangeOfDays.intdiv(2) as Long)
            rightStartingDate = substractDaysToDate(end, rangeOfDays.intdiv(2) as Long)
        }

        return [left: [startDate, leftEndDate], right: [rightStartingDate, endDate]]
    }

    private static Long daysBetween(Date start, Date end) {
        use(TimeCategory) {
            def duration = end - start
            return duration.days
        }
    }

    private static String addDaysToDate(Date day, Long daysToAdd) {
        return convertToString(day.plus(daysToAdd as int))
    }

    private static String substractDaysToDate(Date day, Long daysToSubstract) {
        return convertToString(day.minus(daysToSubstract as int))
    }

    private static Date convertToDate(String date) {
        return new Date().parse("yyyy-MM-dd", date)
    }

    private static String convertToString(Date date) {
        return date.format("yyyy-MM-dd")
    }
}
