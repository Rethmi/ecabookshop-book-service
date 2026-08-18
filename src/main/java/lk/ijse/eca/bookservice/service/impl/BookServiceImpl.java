package lk.ijse.eca.bookservice.service.impl;

import lk.ijse.eca.bookservice.dto.BookDTO;
import lk.ijse.eca.bookservice.entity.Book;
import lk.ijse.eca.bookservice.repository.BookRepository;
import lk.ijse.eca.bookservice.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private static final Logger log = LoggerFactory.getLogger(BookServiceImpl.class);

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookDTO createBook(BookDTO dto) {
        log.info("Creating book with ID: {}", dto.getBookId());
        Book book = new Book(
                dto.getBookId(),
                dto.getTitle(),
                dto.getAuthor(),
                dto.getIsbn(),
                dto.getCategory(),
                dto.getPrice(),
                dto.getStockQuantity()
        );
        Book saved = bookRepository.save(book);
        return mapToDto(saved);
    }

    @Override
    public BookDTO updateBook(String bookId, BookDTO dto) {
        Book existing = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found with ID: " + bookId));

        existing.setTitle(dto.getTitle());
        existing.setAuthor(dto.getAuthor());
        existing.setIsbn(dto.getIsbn());
        existing.setCategory(dto.getCategory());
        existing.setPrice(dto.getPrice());
        existing.setStockQuantity(dto.getStockQuantity());

        Book updated = bookRepository.save(existing);
        return mapToDto(updated);
    }

    @Override
    public BookDTO getBookById(String bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found with ID: " + bookId));
        return mapToDto(book);
    }

    @Override
    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public void deleteBook(String bookId) {
        bookRepository.deleteById(bookId);
    }

    private BookDTO mapToDto(Book book) {
        return new BookDTO(
                book.getBookId(),
                book.getTitle(),
                book.getAuthor(),
                book.getIsbn(),
                book.getCategory(),
                book.getPrice(),
                book.getStockQuantity()
        );
    }
}
