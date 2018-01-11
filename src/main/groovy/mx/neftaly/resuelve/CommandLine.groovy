package mx.neftaly.resuelve

class CommandLine {
    static void main(String[] args) {
        if (args && args.size() == 2 && DatesValidator.validate(args[0], args[1])) {
            def service = new BillService(args[0], args[1])
            println "Total Bills: ${service.totalBills}"
            println "Total requests made: ${service.totalCalls}"
        } else {
            System.err << "Error: Must be two dates in YYYY-MM-DD format as arguments"
        }
    }
}
