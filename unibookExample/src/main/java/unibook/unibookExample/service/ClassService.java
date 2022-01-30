package unibook.unibookExample.service;

import org.springframework.stereotype.Service;
import unibook.unibookExample.entity.Class;
import unibook.unibookExample.repository.ClassRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClassService {
    private final ClassRepository classRepository;

    public ClassService(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    public void addNewClass(Class newClass) {
        Optional<Class> classOptional = classRepository.findClassByName(newClass.getName());
        if (classOptional.isPresent()) throw new IllegalStateException("Class is already exists!");
        classRepository.save(newClass);
    }

    public Class getClass(Long id) {
        Optional<Class> optionalClass = classRepository.findClassById(id);
        if (optionalClass.isPresent()) return optionalClass.get();
        else throw new IllegalStateException("Class wasn't found!");
    }

    public List<Class> getClasses() {
        return classRepository.findAll();
    }

    public void deleteClassById(Long classId) {
        Optional<Class> optionalClass = classRepository.findClassById(classId);
        if (optionalClass.isPresent()) classRepository.deleteById(classId);
        else throw new IllegalStateException("There is no class by this id!");
    }


    public Class updateClassById(Long classId, String newName) {
        Optional<Class> optionalClass = classRepository.findClassById(classId);
        if (optionalClass.isPresent()) {
            optionalClass.get().setName(newName);
            return optionalClass.get();
        } else {
            throw new IllegalStateException("Class wasn't found!");
        }


    }
}
