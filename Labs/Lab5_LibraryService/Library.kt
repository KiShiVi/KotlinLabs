package Lab5_LibraryService

class Library : LibraryService{
    private val bookStatuses: MutableMap<Book, Status> = mutableMapOf()

    override fun findBooks(title: String): List<Book> {
        TODO("Not yet implemented")
    }

    override fun findBooks(author: Author): List<Book> {
        TODO("Not yet implemented")
    }

    override fun findBooks(year: Year): List<Book> {
        TODO("Not yet implemented")
    }

    override fun findBooks(genre: Genre) {
        TODO("Not yet implemented")
    }

    override fun getAllBooks(): List<Book> {
        TODO("Not yet implemented")
    }

    override fun getAllAvailableBooks(): List<Book> {
        TODO("Not yet implemented")
    }

    override fun getBookStatus(book: Book): Status {
        TODO("Not yet implemented")
    }

    override fun getAllBookStatuses(): Map<Book, Status> {
        TODO("Not yet implemented")
    }

    override fun setBookStatus(book: Book, status: Status) {
        TODO("Not yet implemented")
    }

    override fun addBook(book: Book, status: Status) {
        TODO("Not yet implemented")
    }

    override fun registerUser(user: User) {
        TODO("Not yet implemented")
    }

    override fun unregisterUser(user: User) {
        TODO("Not yet implemented")
    }

    override fun takeBook(user: User, book: Book) {
        TODO("Not yet implemented")
    }

    override fun returnBook(book: Book) {
        TODO("Not yet implemented")
    }

}