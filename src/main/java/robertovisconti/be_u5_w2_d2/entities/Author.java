package robertovisconti.be_u5_w2_d2.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Random;


@Getter
@Setter
@ToString
public class Author {
    private long id;
    private String name;
    private String surname;
    private String email;
    private LocalDate dataDiNascita;
    private String avatar;

    public Author(String name, String surname, String email, LocalDate dataDiNascita) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.dataDiNascita = dataDiNascita;
        Random random = new Random();
        this.id = random.nextInt(1, 2000);
        this.avatar = "https://ui-avatars.com/api/?name=" + name + "+" + surname;
    }
}
