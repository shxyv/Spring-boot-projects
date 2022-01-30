package unibook.unibookExample.controller;

import org.springframework.web.bind.annotation.*;
import unibook.unibookExample.dto.StudentDto;
import unibook.unibookExample.entity.Student;
import unibook.unibookExample.service.StudentService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentDto> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    public void addNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @PutMapping("/{studentId}/class/{classId}")
    public void enrollStudentToClass(@PathVariable Long studentId, @PathVariable Long classId) {
        studentService.enrollStudentToClass(studentId, classId);
    }

    @PutMapping("/{studentId}")
    public Student updateStudent(@PathVariable Long studentId,
                                 @RequestParam(required = false) String name,
                                 @RequestParam(required = false) Integer age,
                                 @RequestParam(required = false) LocalDate dob) {
        return studentService.updateStudent(studentId, name, age, dob);
    }

    @GetMapping("/{studentId}")
    public StudentDto getStudent(@PathVariable Long studentId) {
        return studentService.getStudent(studentId);
    }


}
