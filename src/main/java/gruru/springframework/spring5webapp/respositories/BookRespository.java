package gruru.springframework.spring5webapp.respositories;

import gruru.springframework.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRespository extends CrudRepository<Book, Long> {
}
