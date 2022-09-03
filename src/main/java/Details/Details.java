package Details;

import Student.Student;
import lombok.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table
public class Details {
    @Id
    @SequenceGenerator(
            name = "details_sequence",
            sequenceName = "details_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "details_sequence"
    )
    @Column(name = "id")
    private Long id;
    private String grade;
    private String year;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "details", cascade = CascadeType.ALL)
    private Student student;
}
