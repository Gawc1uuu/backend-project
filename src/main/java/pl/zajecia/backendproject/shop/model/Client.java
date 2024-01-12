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


    public Client(String name, String lastName, LocalDate birthDate, String userName, String password, String adress, String phoneNumber) {
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.userName = userName;
        this.password = password;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
    }












}
