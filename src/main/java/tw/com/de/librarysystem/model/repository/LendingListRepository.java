package tw.com.de.librarysystem.model.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tw.com.de.librarysystem.model.entity.impl.LendingList;

@Repository
public interface LendingListRepository extends JpaRepository<LendingList, Integer>{
	
	@Query(nativeQuery = true,
			value =  "select * "
					+ "from LENDING_LIST l "
					+ "left join BOOK b "
					+ "on l.BOOK_ID = b.ID "
					+ "left join `MEMBER` m "
					+ "on m.ID = l.MEMBER_ID "
					+ "where MEMBER_ID = :memberId "
					+ "or 1 = 1 ")
	public List<LendingList> findByMemberId(Integer memberId);
	
	@Query(nativeQuery = true,
			value =  "select * "
					+ "from LENDING_LIST l "
					+ "left join BOOK b "
					+ "on l.BOOK_ID = b.ID "
					+ "left join `MEMBER` m "
					+ "on m.ID = l.MEMBER_ID "
					+ "where title like :title "
					+ "or 1 = 1 ")
	public List<LendingList> findByBookTitle(String title);

}
