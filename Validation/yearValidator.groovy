
/**
 * Created by Theodor on 2015-10-18.
 */
class YearValidator {

    def isYearString = { String year ->
        return (year.trim().length() == 4 && year.trim() ==~ /\d*/)
    }


    static def validateyearSpan(String fromString, String, toString) {
        def falseResult = { String errorMessage, String fromString, String toString -> [result: false, reason: "${errorMessage}"] }
        def from = validateYear(fromString)
        def to = validateYear(toString)
        switch([from:from, to: to]){
            case{!(it.from.result || it.to.result)}:
                return falseResult
        }

    }

    static Map validateYear(String possibleYear) {
        def falseResult = { String errorMessage -> [result: false, reason: "${errorMessage}", value:-1] }
        switch (possibleYear) {
            case { !it }:
                return falseResult("Tom sträng")
                break
            case {it.trim().length() != 4}:
                return falseResult("Årtalet måste skrivas med fyra tecken")
                break
            case { !(it.trim() ==~ /\d*/)}:
                return falseResult("Årtalet måste skrivas med enbart siffror")
                break
            case {it.toInteger()}:
                return [result: true, value: possibleYear.toInteger()]
            default:
                return falseResult("Okänt fel")
        }


    }
}
