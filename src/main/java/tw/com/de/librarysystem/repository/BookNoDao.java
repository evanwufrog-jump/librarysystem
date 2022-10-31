package tw.com.de.librarysystem.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tw.com.de.librarysystem.entity.impl.BookNo;
@Repository
public interface BookNoDao extends JpaRepository<BookNo, Integer>{
	
}
