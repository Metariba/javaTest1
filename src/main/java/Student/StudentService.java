package Student;

import Details.DetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {


    @Autowired
    StudentRepository studentRepository;

    public int getAllStudents()  {
        System.out.println(studentRepository.findById(18L).get());

        return 1;
/*
        return studentRepository.findAll();
*/
    }

    public Student getStudentById(Long studentId) {
        return studentRepository.getById(studentId);
    }

    public Student newStudent(Student student) throws IllegalAccessError {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalAccessError("email already registered");
        }
        studentRepository.save(student);
        return student;
    }


    @Transactional
    public Student updateStudent(Long studentId, String name, String email) throws IllegalAccessError {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "student with id" + studentId + "does not exist"
                ));
        if (name != null && name.length() > 0 && !Objects.equals(name, student.getName())) {
            student.setName(name);
        }
        if (email != null && email.length() > 0 && !Objects.equals(email, student.getEmail())) {
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);
        }

        studentRepository.save(student);
        return student;
    }

    public Long deleteStudent(Long studentId) throws IllegalAccessError {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "student with id" + studentId + "does not exist"
                ));
        studentRepository.deleteById(studentId);
        return studentId;
    }
}
