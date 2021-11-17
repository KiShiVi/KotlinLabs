package Lab5_LibraryService

class Library : LibraryService {
    private val users: MutableList<User> = mutableListOf()
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