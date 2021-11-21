package Lab5_LibraryService

class Library : LibraryService {
    private val users: MutableList<User> = mutableListOf()
    private val bookStatuses: MutableMap<Book, Status> = mutableMapOf()

    override fun findBooks(title: String?, author: Author?, year: Year?, genre: Genre?): List<Book> {
        var result: List<Book> = bookStatuses.keys.toList()
        for (key in bookStatuses.keys) {
            if (title != null) result = _findBooks(title = title, bookList = result)
            if (author != null) result = _findBooks(author = author, bookList = result)
            if (year != null) result = _findBooks(year = year, bookList = result)
            if (genre != null) result = _findBooks(genre = genre, bookList = result)
        }
        return result
    }

    private fun _findBooks(title: String, bookList: List<Book>?): List<Book> {
        val privateBookList: List<Book> = bookList ?: bookStatuses.keys.toList()
        val result: MutableList<Book> = mutableListOf()
        for (key in privateBookList)
            if (key.title == title) result.add(key)
        return result
    }

    private fun _findBooks(author: Author, bookList: List<Book>?): List<Book> {
        val privateBookList: List<Book> = bookList ?: bookStatuses.keys.toList()
        val result: MutableList<Book> = mutableListOf()
        for (key in privateBookList)
            if (key.author == author) result.add(key)
        return result
    }

    private fun _findBooks(year: Year, bookList: List<Book>?): List<Book> {
        val privateBookList: List<Book> = bookList ?: bookStatuses.keys.toList()
        val result: MutableList<Book> = mutableListOf()
        for (key in privateBookList)
            if (key.year == year) result.add(key)
        return result
    }

    private fun _findBooks(genre: Genre, bookList: List<Book>?): List<Book> {
        val privateBookList: List<Book> = bookList ?: bookStatuses.keys.toList()
        val result: MutableList<Book> = mutableListOf()
        for (key in privateBookList)
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

    override fun getBookStatus(book: Book): Status? {
        if (bookStatuses[book] == null)
            return null
        return bookStatuses[book]
    }

    override fun getAllBookStatuses(): Map<Book, Status> {
        return bookStatuses
    }

    override fun setBookStatus(book: Book, status: Status) {
        if (bookStatuses[book] == null)
            return
        bookStatuses[book] = status
    }

    override fun addBook(book: Book, status: Status) {
        bookStatuses[book] = status
    }

    override fun registerUser(user: User) {
        if (users.contains(user))
            return
        users.add(user)
    }

    override fun unregisterUser(user: User) {
        if (!users.contains(user))
            return
        users.remove(user)
    }

    override fun takeBook(user: User, book: Book) {
        if (!users.contains(user) || !bookStatuses.keys.contains(book))
            return
        if (bookStatuses[book] != Status.Available)
            return
        if (countOfTakenBooksByUser(user) > 3)
            return
        setBookStatus(book, Status.UsedBy(user))
    }

    override fun returnBook(book: Book) {
        if (!bookStatuses.keys.contains(book))
            return
        setBookStatus(book, Status.Available)
    }

    private fun countOfTakenBooksByUser(user: User): Int {
        var result = 0
        for (value in bookStatuses.values)
            if (value == Status.UsedBy(user)) result++
        return result
    }
}