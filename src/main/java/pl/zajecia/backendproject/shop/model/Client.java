package pl.zajecia.backendproject.shop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    private String lastName;
    private LocalDate birthDate;
    private String userName;
    private String password;
    private String adress;
    private String phoneNumber;













}
