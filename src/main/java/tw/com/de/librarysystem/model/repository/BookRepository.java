package tw.com.de.librarysystem.model.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import tw.com.de.librarysystem.model.entity.impl.Book;
@Repository
public interface BookRepository extends JpaRepository<tw.com.de.librarysystem.model.entity.impl.Book, Integer>{

//	書名、作者、書本技術分類模糊查詢
	List<Book> findByTitleContainingOrAuthorContainingOrTechnologyContaining(String title, String author,
			String technology);
	
	@Modifying
	@Query("update Book b set b.status = '借出' where b.id = :id")
	void updateStatusById(@Param("id")Integer id);
	
	@Modifying
	@Query("update Book b set b.status = '上架' where b.id = :id")
	void updateStatus2ById(@Param("id")Integer id);
	
	@Modifying
	@Query("update Book b set b.status = '預約中' where b.id = :id")
	void updateStatus3ById(@Param("id")Integer id);
	
	List<Book> findByTitleContaining(String title);
}