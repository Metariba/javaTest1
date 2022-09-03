package Details;

import Student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DetailsService {
    @Autowired
    DetailRepository detailRepository;

    public Details newDetail(Details detail) throws IllegalAccessError {
        detailRepository.save(detail);
        return detail;
    }

}
