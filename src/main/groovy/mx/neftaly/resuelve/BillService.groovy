package mx.neftaly.resuelve

import groovyx.net.http.HTTPBuilder

/**
 * This class is in charge of making the requests
 */
class BillService {

    private static String id = "8672e846-9c89-4dbf-a1cc-b85a2da5abe1"
    private HTTPBuilder http = new HTTPBuilder('http://34.209.24.195')

    Long totalBills = 0
    Long totalCalls = 0

    BillService(String dateStart, String dateFinish) {
        binarySearch(dateStart, dateFinish)
    }

    private binarySearch(String dateStart, String dateFinish) {

        totalCalls++

        def result = makeRequest(dateStart, dateFinish)

        if (result == Long.MIN_VALUE) {
            def ranges = DaysComparator.divideInTwoRanges(dateStart, dateFinish)

            binarySearch(ranges.left)
            binarySearch(ranges.right)
        } else {
            totalBills += result
        }
    }

    private binarySearch(String[] dateRange) {
        binarySearch(dateRange[0], dateRange[1])
    }

    private Long makeRequest(String dateStart, String dateFinish) {
        String result = http.get(path: '/facturas', query: [start: dateStart, finish: dateFinish, id: id])
        if (result.isInteger()) {
            return result.toLong()
        } else {
            return Long.MIN_VALUE
        }
    }
}
