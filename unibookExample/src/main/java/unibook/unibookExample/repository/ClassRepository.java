package unibook.unibookExample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unibook.unibookExample.entity.Class;

import java.util.Optional;

@Repository
public interface ClassRepository extends JpaRepository<Class, Long> {
        Optional<Class> findClassByName(String name);
        Optional<Class> findClassById(Long id);
}
