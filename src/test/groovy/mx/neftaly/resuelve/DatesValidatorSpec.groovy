package mx.neftaly.resuelve

import spock.lang.Specification
import spock.lang.Unroll

class DatesValidatorSpec extends Specification {

    @Unroll("Testing DatesValidator with #reason")
    "Dates Validation Tests"() {
        given: "Some dates"
        when: "we call the validator with those dates"
            def valid = DatesValidator.validate(dateStart, dateFinish)
        then: "we get the expected result"
            valid == expectedResult
        where:
            dateStart          | dateFinish         || expectedResult | reason
            "1994-12-03"       | "1994-12-03"       || true           | "Valid Dates"
            "1994-12-00"       | "1994-12-00"       || true           | "lenient option and Invalid Dates"
            null               | null               || false          | "Null Dates"
            "XXXX-XX-XX"       | "XXXX-XX-XX"       || false          | "Invalid Dates"
            "LOLVERYBADSTRING" | "LOLVERYBADSTRING" || false          | "Bad Strings"
    }

}
