package tw.com.de.librarysystem.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tw.com.de.librarysystem.entity.impl.Book;
@Repository
public interface BookDao extends JpaRepository<tw.com.de.librarysystem.entity.impl.Book, Integer>{
	
	List<Book> findByTitleContainingOrAuthorContainingOrTechnologyContaining(String title, String author,String technology);
}
