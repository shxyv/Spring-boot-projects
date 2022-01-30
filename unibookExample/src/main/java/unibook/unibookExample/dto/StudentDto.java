package unibook.unibookExample.dto;

import lombok.Data;
import unibook.unibookExample.entity.Class;
import unibook.unibookExample.entity.Subject;

import java.time.LocalDate;
import java.util.Set;

@Data
public class StudentDto {
    private String studentName;
    private Integer studentAge;
    private LocalDate studentDob;
    private Set<Class> classes;
    private Set<Subject> subjects;

}
