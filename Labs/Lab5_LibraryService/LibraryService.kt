package Lab5_LibraryService

class Book (val title: String, val author: Author, val genre: Genre, val year: Year){
    val bookList: MutableList<Book> = mutableListOf()
}
class Author (val name: String)
class User (val name: String)
class Year (val year: Int)

enum class Genre {
    DETECTIVE,
    FANTASY,
    NOVEL,
    RELIGIOUS,
    TECHNICAL
}

sealed class Status {
    object Available : Status()
    data class UsedBy(val user: User) : Status()
    object ComingSoon : Status()
    object Restoration : Status()
}


interface LibraryService {
    fun findBooks(title: String): List<Book>
    fun findBooks(author: Author): List<Book>
    fun findBooks(year: Year): List<Book>
    fun findBooks(genre: Genre)

    fun getAllBooks(): List<Book>
    fun getAllAvailableBooks(): List<Book>

    fun getBookStatus(book: Book): Status
    fun getAllBookStatuses(): Map<Book, Status>

    fun setBookStatus(book: Book, status: Status)

    fun addBook(book: Book, status: Status = Status.Available)

    fun registerUser(/* parameters */)
    fun unregisterUser(user: User)

    fun takeBook(user: User, book: Book)
    fun returnBook(book: Book)
}
