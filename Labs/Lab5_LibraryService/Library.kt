package Lab5_LibraryService

class Library : LibraryService{
    private val bookStatuses: MutableMap<Book, Status> = mutableMapOf()

    override fun findBooks(title: String): List<Book> {
        val result: MutableList<Book> = mutableListOf()
        for (key in bookStatuses.keys)
            if (key.title == title) result.add(key)
        return result
    }

    override fun findBooks(author: Author): List<Book> {
        val result: MutableList<Book> = mutableListOf()
        for (key in bookStatuses.keys)
            if (key.author == author) result.add(key)
        return result
    }

    override fun findBooks(year: Year): List<Book> {
        val result: MutableList<Book> = mutableListOf()
        for (key in bookStatuses.keys)
            if (key.year == year) result.add(key)
        return result
    }

    override fun findBooks(genre: Genre): List<Book> {
        val result: MutableList<Book> = mutableListOf()
        for (key in bookStatuses.keys)
            if (key.genre == genre) result.add(key)
        return result
    }

    override fun getAllBooks(): List<Book> {
        val result: MutableList<Book> = mutableListOf()
        for (key in bookStatuses.keys) result.add(key)
        return result
    }

    override fun getAllAvailableBooks(): List<Book> {
        val result: MutableList<Book> = mutableListOf()
        for ((key, value) in bookStatuses)
            if (value == Status.Available) result.add(key)
        return result
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
        bookStatuses[book] = status
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