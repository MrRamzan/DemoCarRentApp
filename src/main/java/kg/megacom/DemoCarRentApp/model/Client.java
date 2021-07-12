package kg.megacom.DemoCarRentApp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "middlename")
    private String middlename;

    private String email;

    @Column(name = "registration")
    @JsonIgnore
    private Date registrationDate;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "password")
    @JsonIgnore
    private String password;

    @Column(name = "activated", columnDefinition = "boolean default false")
    private Boolean activated;

    @Column(name = "enabled", columnDefinition = "boolean default true")
    private Boolean enabled;

    @Override
    public String toString() {
        return lastname + " " + firstname + " " + middlename;
    }
}
