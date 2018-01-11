package mx.neftaly.resuelve

import spock.lang.Specification
import spock.lang.Unroll

class DaysComparatorSpec extends Specification {

    @Unroll("Testing DaysComparator with #reason")
    "DaysComparator Tests"() {
        given: "Some dates"
        when: "we call the validator with those dates"
            def valid = DaysComparator.divideInTwoRanges(dateStart, dateFinish)
        then: "we get the expected result"
            leftRange == valid.left
            rightRange == valid.right
        where:
            dateStart          | dateFinish         || leftRange                    | rightRange                   | reason
            "1994-12-03"       | "1994-12-04"       || ["1994-12-03", "1994-12-03"] | ["1994-12-04", "1994-12-04"] | "Short Range of Dates"
            "1994-12-03"       | "2000-12-04"       || ["1994-12-03", "1997-12-03"] | ["1997-12-04", "2000-12-04"] | "Long Range of Dates"
            null               | null               || []                           | []                           | "Null Dates"
            "XXXX-XX-XX"       | "XXXX-XX-XX"       || []                           | []                           | "Invalid Dates"
            "LOLVERYBADSTRING" | "LOLVERYBADSTRING" || []                           | []                           | "Bad Strings"
    }

}

