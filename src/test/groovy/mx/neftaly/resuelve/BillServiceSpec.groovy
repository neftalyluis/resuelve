package mx.neftaly.resuelve

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Kind of Integration Test?
 */
class BillServiceSpec extends Specification {

    @Unroll("Testing BillService HTTP Requests with #reason")
    "Tests for the HTTP Request to the Bill Service"() {
        given: "Some dates and the BillService object"
            def service = new BillService(dateStart, dateFinish)
        expect: "to have this quantity of Bills"
            service.totalBills == totalBills
        and: "have this total of HTTP requests made"
            service.totalCalls == totalCalls
        where:
            dateStart    | dateFinish   || totalBills | totalCalls | reason
            "1994-12-03" | "1994-12-03" || 0          | 1          | "a range of dates where there are 0 Bills"
            "2017-01-22" | "2017-01-22" || 5          | 1          | "a one day range"
            "2017-01-01" | "2017-01-22" || 102        | 3          | "a long range of dates"



    }
}