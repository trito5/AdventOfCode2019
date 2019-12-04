import java.io.File

fun main(args: Array<String>) {
    val fileName = "textFiles/Dec01.txt"
    val modules = File(fileName).readLines().map(String::toInt)
    var totalFuel = 0;
    modules.forEach{
        totalFuel += it / 3 - 2
    }
    println(totalFuel)
}
