package unibook.unibookExample.controller;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import unibook.unibookExample.entity.Class;
import unibook.unibookExample.service.ClassService;

import javax.persistence.UniqueConstraint;
import java.util.List;

@RestController
@RequestMapping(path = "/classes")
public class ClassController {
    private final ClassService classService;


    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @GetMapping
    public List<Class> getClasses() {
        return classService.getClasses();
    }

    @GetMapping("{classId}/get")
    public Class getClass(@PathVariable("classId") Long classId) {
        return classService.getClass(classId);
    }

    @PostMapping
    public void addNewSchool(@RequestBody Class newClass) {
        classService.addNewClass(newClass);
    }

    @DeleteMapping("/delete/{classId}")
    public void deleteClass(@PathVariable("classId") Long classId) {
        classService.deleteClassById(classId);
    }

    @PutMapping("/update/{classId}")
    public Class updateClass(@PathVariable Long classId, @RequestParam(name = "name") String newName) {
        return classService.updateClassById(classId, newName);
    }

}
