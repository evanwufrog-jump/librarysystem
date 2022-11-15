package tw.com.de.librarysystem.model.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tw.com.de.librarysystem.model.entity.impl.BookPic;
@Repository
public interface BookPicRepository extends JpaRepository<BookPic, Integer>{

}
