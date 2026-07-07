package robertovisconti.be_u5_w2_d2.payloads;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@ToString
public class AuthorPayload {
    private String name;
    private String surname;
    private String email;
    private LocalDate dataDiNascita;
}
