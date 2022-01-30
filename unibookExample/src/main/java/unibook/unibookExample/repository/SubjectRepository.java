package unibook.unibookExample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unibook.unibookExample.entity.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long> {

}
