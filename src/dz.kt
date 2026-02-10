class Library<T> {
    private val items: MutableList<T> = mutableListOf()

    fun add(item: T) {
        items.add(item)
    }

    fun getItems(): List<T> {
        return items.toList()
    }
}

data class Book(
    val title: String,
    val author: String,
    val year: Int,
    val isbn: String
)

data class Magazine(
    val title: String,
    val issue: Int,
    val month: String
)

data class DVD(
    val title: String,
    val director: String,
    val duration: Int
)

sealed class LibraryItem {
    data class BookItem(val book: Book) : LibraryItem()
    data class MagazineItem(val magazine: Magazine) : LibraryItem()
    data class DVDItem(val dvd: DVD) : LibraryItem()
}

fun filterByYear(items: List<LibraryItem>, year: Int): List<Book> {
    return items.filter { it is LibraryItem.BookItem }.map { it as LibraryItem.BookItem }.map { it.book }
        .filter { it.year == year }
}

fun sortByTitle(items: List<LibraryItem>): List<LibraryItem> {
    return items.sortedBy { item -> when (item) {
            is LibraryItem.BookItem -> item.book.title
            is LibraryItem.MagazineItem -> item.magazine.title
            is LibraryItem.DVDItem -> item.dvd.title
        }
    }
}

fun groupByAuthor(items: List<LibraryItem>): Map<String, List<Book>> {
    return items.filter { it is LibraryItem.BookItem }.map { it as LibraryItem.BookItem }
        .groupBy(
            keySelector = { it.book.author },
            valueTransform = { it.book }
        )
}

fun calculateTotalDuration(items: List<LibraryItem>): Int {
    return items.filter { it is LibraryItem.DVDItem }.map { it as LibraryItem.DVDItem }.sumOf { it.dvd.duration }
}

fun main() {
    val library = Library<LibraryItem>()

    library.add(LibraryItem.BookItem(Book("1984", "George Orwell", 1949, "112")))
    library.add(LibraryItem.BookItem(Book("Rapunzel", "Brothers Grimm", 1812, "211")))
    library.add(LibraryItem.MagazineItem(Magazine("National Geographic", 2024, "January")))
    library.add(LibraryItem.DVDItem(DVD("Inception", "Christopher Nolan", 148)))
    library.add(LibraryItem.DVDItem(DVD("Interstellar", "Christopher Nolan", 169)))

    val items = library.getItems()

    val books1949 = filterByYear(items, 1949)
    val sorted = sortByTitle(items)
    val byAuthor = groupByAuthor(items)
    val totalDuration = calculateTotalDuration(items)

    println("Книги 1949 года: ${books1949.size}")
    println("Отсортированные элементы: ${sorted.map {
        when (it) {
            is LibraryItem.BookItem -> it.book.title
            is LibraryItem.MagazineItem -> it.magazine.title
            is LibraryItem.DVDItem -> it.dvd.title
        }
    }}")
    println("Книги по авторам:")
    byAuthor.forEach { (author, books) ->
        println("  $author: ${books.joinToString(", ") { it.title }}")
    }
    println("Общая продолжительность DVD: $totalDuration минут")
}