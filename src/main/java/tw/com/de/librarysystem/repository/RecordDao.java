package tw.com.de.librarysystem.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RecordDao extends JpaRepository<Record, Integer>{

}
