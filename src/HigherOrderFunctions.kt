import jdk.incubator.vector.Float16.divide
import jdk.incubator.vector.Float16.multiply

fun main(){
    val action1 = selectAction(1)
    println(action1(8,5))

    val action2 = selectAction(2)
    println(action2(8,5))

//    action(5,3,::sum)
//    action(5,3,::multiply)
//    action(5,3,::substract)
//    displayMessage(::morning)
//    displayMessage(::evening)
}
fun selectAction(key:Int): (Int, Int) -> Int{
    return when(key){
        1 -> ::sum
        2 -> ::substract
        3 -> ::multiply
        else -> ::empty
    }
}
fun sum(a: Int, b: Int): Int{
    return a+b
}
fun substract(a: Int, b: Int): Int{
    return a-b
}
fun multiply(a: Int, b: Int): Int{
    return a*b
}
fun empty(a: Int, b: Int): Int{
    return 0
}
//fun action(n1: Int, n2: Int, op: (Int, Int) -> Int) {
//    val result = op(n1, n2)
//    println(result)
//}


//fun displayMessage(mes: () -> Unit){
//    mes()
//}
//
//fun morning(){
//    println("Good Morning")
//}
//fun evening(){
//    println("Good Evening")
//}