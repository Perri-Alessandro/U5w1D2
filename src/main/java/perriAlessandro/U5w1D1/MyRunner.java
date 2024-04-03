package perriAlessandro.U5w1D1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import perriAlessandro.U5w1D1.entities.Menù;
import perriAlessandro.U5w1D1.entities.Tavolo;

import java.util.List;

@Component
public class MyRunner implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(U5w1D1Application.class);


    public Menù menù;

    @Autowired
    public List<Tavolo> tavoli;

    @Value("${ordine.costo-coperto}")
    private double costoCoperto;

    public MyRunner(Menù menù, List<Tavolo> tavoli) {
        this.menù = menù;
        this.tavoli = tavoli;
    }

    @Override
    public void run(String... args) throws Exception {
//        log.info("CIAO! SELEZIONA UN TAVOLO LIBERO TRA QUELLI VISUALIZZATI DI SEGUITO, INSERENDO IL LORO NUMERO");
        menù.stampaMenù();
        log.info("------------------------------ TAVOLI -----------------------------");
        tavoli.forEach(t -> log.info(t.toString()));
    }
}
