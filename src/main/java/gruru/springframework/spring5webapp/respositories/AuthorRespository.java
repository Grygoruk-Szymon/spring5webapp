package gruru.springframework.spring5webapp.respositories;

import gruru.springframework.spring5webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRespository extends CrudRepository<Author, Long> {
}
