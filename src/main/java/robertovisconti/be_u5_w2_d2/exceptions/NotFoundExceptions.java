package robertovisconti.be_u5_w2_d2.exceptions;

public class NotFoundExceptions extends RuntimeException {
    public NotFoundExceptions(long id) {
        super("La ricerca con id: " + id + " non è stata trovata");
    }
}
