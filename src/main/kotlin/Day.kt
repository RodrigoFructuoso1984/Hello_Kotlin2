import java.util.Calendar

fun main(args: Array<String>){
    dayOfWeek()
}

fun dayOfWeek(){
    println("Que dia é hoje?")
    val day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
    println(when(day){
        1 -> "Sunday"
        2 -> "Monday"
        3 -> "Tuesday"
        4 -> "Wednesday"
        5 -> "Thursday"
        6 -> "Friday"
        7 -> "Saturday"
        else -> println("Time has stopped")
    })

}