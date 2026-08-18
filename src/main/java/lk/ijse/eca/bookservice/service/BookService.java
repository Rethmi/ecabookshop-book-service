package lk.ijse.eca.bookservice.service;

import lk.ijse.eca.bookservice.dto.BookDTO;

import java.util.List;

public interface BookService {
    BookDTO createBook(BookDTO dto);
    BookDTO updateBook(String bookId, BookDTO dto);
    BookDTO getBookById(String bookId);
    List<BookDTO> getAllBooks();
    void deleteBook(String bookId);
}
