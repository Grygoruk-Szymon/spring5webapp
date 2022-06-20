package gruru.springframework.spring5webapp.respositories;

import gruru.springframework.spring5webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRespository extends CrudRepository<Publisher, Long> {
}
