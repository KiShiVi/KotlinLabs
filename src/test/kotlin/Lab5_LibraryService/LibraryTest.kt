package Lab5_LibraryService

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class LibraryTest {

    @Test
    fun findBooks_test1() {
        val library: LibraryService = Library()

        library.addBook(Book("Шерлок Холмс", Author("Конан Дойль"), Genre.DETECTIVE, Year(1892)), Status.Available)
        library.addBook(Book("Шерлок Холмс", Author("Конан Дойль"), Genre.DETECTIVE, Year(1893)), Status.Available)
        library.addBook(Book("Шерлок Холмс", Author("Конан Дойль"), Genre.DETECTIVE, Year(1903)), Status.Available)
        library.addBook(Book("Человек", Author("Иоганн Ранке"), Genre.RELIGIOUS, Year(1903)), Status.Available)
        library.addBook(
            Book("Автостопом по галактике", Author("Дуглас Адамс"), Genre.FANTASY, Year(1979)),
            Status.Available
        )
        library.addBook(Book("Идиот", Author("Федор Достоевский"), Genre.NOVEL, Year(1868)), Status.Available)
        library.addBook(Book("Библия", Author("Бог"), Genre.RELIGIOUS, Year(1228)), Status.Available)
        library.addBook(Book("Чистый код", Author("Роберт Мартин"), Genre.TECHNICAL, Year(2008)), Status.Available)

        val isCorrect: List<Book> = library.findBooks(genre = Genre.RELIGIOUS)
        val correct: List<Book> = listOf(
            Book("Человек", Author("Иоганн Ранке"), Genre.RELIGIOUS, Year(1903)),
            Book("Библия", Author("Бог"), Genre.RELIGIOUS, Year(1228))
        )

        assertEquals(isCorrect, correct)
    }

    @Test
    fun findBooks_test2() {
        val library: LibraryService = Library()

        library.addBook(Book("Шерлок Холмс", Author("Конан Дойль"), Genre.DETECTIVE, Year(1892)), Status.Available)
        library.addBook(Book("Шерлок Холмс", Author("Конан Дойль"), Genre.DETECTIVE, Year(1893)), Status.Available)
        library.addBook(Book("Шерлок Холмс", Author("Конан Дойль"), Genre.DETECTIVE, Year(1903)), Status.Available)
        library.addBook(Book("Человек", Author("Иоганн Ранке"), Genre.RELIGIOUS, Year(1903)), Status.Available)
        library.addBook(
            Book("Автостопом по галактике", Author("Дуглас Адамс"), Genre.FANTASY, Year(1979)),
            Status.Available
        )
        library.addBook(Book("Идиот", Author("Федор Достоевский"), Genre.NOVEL, Year(1868)), Status.Available)
        library.addBook(Book("Библия", Author("Бог"), Genre.RELIGIOUS, Year(1228)), Status.Available)
        library.addBook(Book("Чистый код", Author("Роберт Мартин"), Genre.TECHNICAL, Year(2008)), Status.Available)

        val isCorrect: List<Book> = library.findBooks(title = "Шерлок Холмс", year = Year(1892))
        val correct: List<Book> = listOf(
            Book("Шерлок Холмс", Author("Конан Дойль"), Genre.DETECTIVE, Year(1892))
        )

        assertEquals(isCorrect, correct)
    }


    @Test
    fun getAllAvailableBooks() {
        val library: LibraryService = Library()

        library.addBook(Book("Шерлок Холмс", Author("Конан Дойль"), Genre.DETECTIVE, Year(1892)), Status.Available)
        library.addBook(Book("Шерлок Холмс", Author("Конан Дойль"), Genre.DETECTIVE, Year(1893)), Status.Available)
        library.addBook(Book("Шерлок Холмс", Author("Конан Дойль"), Genre.DETECTIVE, Year(1903)), Status.Restoration)
        library.addBook(Book("Человек", Author("Иоганн Ранке"), Genre.RELIGIOUS, Year(1903)), Status.Available)
        library.addBook(
            Book("Автостопом по галактике", Author("Дуглас Адамс"), Genre.FANTASY, Year(1979)),
            Status.Restoration
        )
        library.addBook(Book("Идиот", Author("Федор Достоевский"), Genre.NOVEL, Year(1868)), Status.Restoration)
        library.addBook(Book("Библия", Author("Бог"), Genre.RELIGIOUS, Year(1228)), Status.ComingSoon)
        library.addBook(Book("Чистый код", Author("Роберт Мартин"), Genre.TECHNICAL, Year(2008)), Status.Available)

        val isCorrect: List<Book> = library.getAllAvailableBooks()
        val correct: List<Book> = listOf(
            Book("Шерлок Холмс", Author("Конан Дойль"), Genre.DETECTIVE, Year(1892)),
            Book("Шерлок Холмс", Author("Конан Дойль"), Genre.DETECTIVE, Year(1893)),
            Book("Человек", Author("Иоганн Ранке"), Genre.RELIGIOUS, Year(1903)),
            Book("Чистый код", Author("Роберт Мартин"), Genre.TECHNICAL, Year(2008))
        )

        assertEquals(isCorrect, correct)
    }

    @Test
    fun getBookStatus() {
        val library: LibraryService = Library()

        library.addBook(Book("Шерлок Холмс", Author("Конан Дойль"), Genre.DETECTIVE, Year(1892)), Status.Available)
        library.addBook(Book("Шерлок Холмс", Author("Конан Дойль"), Genre.DETECTIVE, Year(1893)), Status.Restoration)

        val isCorrect: Status? =
            library.getBookStatus(Book("Шерлок Холмс", Author("Конан Дойль"), Genre.DETECTIVE, Year(1893)))
        val correct: Status = Status.Restoration

        assertEquals(isCorrect, correct)
    }

    @Test
    fun setBookStatus() {
        val library: LibraryService = Library()

        library.addBook(Book("Шерлок Холмс", Author("Конан Дойль"), Genre.DETECTIVE, Year(1892)), Status.Available)
        library.addBook(Book("Шерлок Холмс", Author("Конан Дойль"), Genre.DETECTIVE, Year(1893)), Status.Restoration)

        library.setBookStatus(
            Book("Шерлок Холмс", Author("Конан Дойль"), Genre.DETECTIVE, Year(1893)),
            Status.ComingSoon
        )

        val isCorrect: Status? =
            library.getBookStatus(Book("Шерлок Холмс", Author("Конан Дойль"), Genre.DETECTIVE, Year(1893)))
        val correct: Status = Status.ComingSoon

        assertEquals(isCorrect, correct)
    }
}