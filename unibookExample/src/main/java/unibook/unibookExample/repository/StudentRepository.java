package unibook.unibookExample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unibook.unibookExample.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
