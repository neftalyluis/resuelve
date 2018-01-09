package mx.neftaly.resuelve

class CommandLine {
    static void main(String[] args) {
        if (args) {

        } else if (args && DatesValidator.validate(args[0], args[1])) {

        } else {
            System.err << "Invalid Dates, must be in YYYY-MM-DD format"
        }
    }
}
