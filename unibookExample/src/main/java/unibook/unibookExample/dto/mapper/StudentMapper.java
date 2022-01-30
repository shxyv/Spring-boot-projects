package unibook.unibookExample.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import unibook.unibookExample.dto.StudentDto;
import unibook.unibookExample.entity.Student;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
        @Mapping(source = "name",target = "studentName")
        @Mapping(source = "age",target = "studentAge")
        @Mapping(source = "dob",target = "studentDob")
        @Mapping(source = "classes",target = "classes")
        @Mapping(source = "subjects",target = "subjects")
        StudentDto entityToDto(Student student);

        List<StudentDto> entityListToDtoList(List<Student> students);
}
