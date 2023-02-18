package com.example.projet;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name= "USERS")
public class Users {
    @Id
    @SequenceGenerator(
            name = "userSequenceIncrementation",
            sequenceName = "user_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "userSequenceIncrementation"
    )
    private Integer id;

    @Column(name = "FirstName")
    private String FirstName;

    @Column(name = "LastName")
    private String LastName;

    @Column(name = "Job")
    private String Job;


    public Users() {

    }
}
