package unibook.unibookExample.service;

import org.springframework.stereotype.Service;
import unibook.unibookExample.dto.StudentDto;
import unibook.unibookExample.dto.mapper.StudentMapper;
import unibook.unibookExample.entity.Class;
import unibook.unibookExample.entity.Student;
import unibook.unibookExample.exception.StudentNotFoundException;
import unibook.unibookExample.repository.ClassRepository;
import unibook.unibookExample.repository.StudentRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final ClassRepository classRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, ClassRepository classRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.classRepository = classRepository;
        this.studentMapper = studentMapper;
    }

    public List<StudentDto> getStudents() {
         List<Student> students = studentRepository.findAll();
         return studentMapper.entityListToDtoList(students);
    }

    public void addNewStudent(Student student) {
        Optional<Student> optionalStudent = studentRepository.findById(student.getId());
        if (optionalStudent.isPresent()) throw new IllegalStateException("This student is already added!");
        else studentRepository.save(student);
    }

    public void enrollStudentToClass(Long studentId, Long classId) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        Optional<Class> optionalClass = classRepository.findClassById(classId);
        if (optionalStudent.isPresent() && optionalClass.isPresent()) {
            optionalStudent.get().getClasses().add(optionalClass.get());
            studentRepository.save(optionalStudent.get());
        } else {
            throw new IllegalStateException("No such student or class!");
        }
    }

    public StudentDto getStudent(Long studentId) {
        Student student = studentRepository.getById(studentId);
        return studentMapper.entityToDto(student);
    }

    @Transactional
    public Student updateStudent(Long studentId, String name, Integer age,
                                 LocalDate dob) {
        Optional<Student> optionalStudent = Optional.ofNullable(studentRepository.findById(studentId).orElseThrow(()
                -> new StudentNotFoundException("Student not found: " + studentId)));

        if (optionalStudent.isPresent() && name.length() > 0 && name != null) {
            optionalStudent.get().setName(name);
            if (age >= 18 && age != null) {
                optionalStudent.get().setAge(age);
            }
            if (dob != null) {
                optionalStudent.get().setDob(dob);
            }
        }
        return studentRepository.save(optionalStudent.get());
    }
}







