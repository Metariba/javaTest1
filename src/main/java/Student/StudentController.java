package Student;


import ch.qos.logback.core.net.SyslogOutputStream;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.element.Element;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(path = "api/student")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StudentController {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    StudentService studentService;

    @GetMapping
    public int getAllStudents() {
         return studentService.getAllStudents();
    }

    @GetMapping(path = "{studentId}")
    public void getStudentById(@PathVariable Long studentId) {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode json = objectMapper.convertValue(studentService.getStudentById(studentId), JsonNode.class);
        System.out.println(json);
    }

    @PostMapping
    public Student newStudent(@RequestBody Student student) throws IllegalAccessException {
        return studentService.newStudent(student);
    }

    @PutMapping(path = "{studentId}")
    public Student updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestBody Student student) {
        return studentService.updateStudent(studentId, student.getName(), student.getEmail());
    }

    @DeleteMapping(path = "{studentId}")
    public Long deleteStudent(
            @PathVariable("studentId") Long studentId) {
        return studentService.deleteStudent(studentId);
    }
}
