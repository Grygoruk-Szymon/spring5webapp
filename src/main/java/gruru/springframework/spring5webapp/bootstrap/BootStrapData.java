package gruru.springframework.spring5webapp.bootstrap;

import gruru.springframework.spring5webapp.domain.Author;
import gruru.springframework.spring5webapp.domain.Book;
import gruru.springframework.spring5webapp.domain.Publisher;
import gruru.springframework.spring5webapp.respositories.AuthorRespository;
import gruru.springframework.spring5webapp.respositories.BookRespository;
import gruru.springframework.spring5webapp.respositories.PublisherRespository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRespository authorRespository;
    private  final BookRespository bookRespository;
    private final PublisherRespository publisherRespository;

    public BootStrapData(AuthorRespository authorRespository, BookRespository bookRespository, PublisherRespository publisherRespository) {
        this.authorRespository = authorRespository;
        this.bookRespository = bookRespository;
        this.publisherRespository = publisherRespository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in BootStrap");

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");

        publisherRespository.save(publisher);

        System.out.println("Publisher count: " + publisherRespository.count());

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design","123123");

        eric.getBooks().add(ddd);
        ddd.getAuthor().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);


        authorRespository.save(eric);
        bookRespository.save(ddd);
        publisherRespository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "123123123123");

        rod.getBooks().add(noEJB);
        noEJB.getAuthor().add(rod);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRespository.save(rod);
        bookRespository.save(noEJB);
        publisherRespository.save(publisher);

        System.out.println("Number of Books: " + bookRespository.count());
        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());



    }
}
