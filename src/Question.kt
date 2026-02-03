data class Question <T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty,
)

enum class Difficulty { EASY, MEDIUM, HARD }

class Quiz {
    val question1 = Question<String>(
        "Речка спятила с ума - По домам пошла сама. ___",
        "водопровод",
        Difficulty.MEDIUM)
    val question2 = Question<Boolean>(
        "Небо зелёное. Правда или ложь",
        false,
        Difficulty.EASY)
    val question3 = Question<Int>(
        "Сколько дней между полнолуниями?",
        28,
        Difficulty.HARD)
    companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
    }
}

fun main() {
    println("${Quiz.answered} of ${Quiz.total} answered.")
}