package perriAlessandro.U5w1D1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import perriAlessandro.U5w1D1.entities.Menù;
import perriAlessandro.U5w1D1.entities.Ordine;
import perriAlessandro.U5w1D1.entities.Tavolo;

import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Component
public class MyRunner implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(U5w1D1Application.class);
    public Menù menù;
    @Autowired
    public List<Tavolo> tavoli;
    Scanner sc = new Scanner(System.in);


    public MyRunner(Menù menù, List<Tavolo> tavoli) {
        this.menù = menù;
        this.tavoli = tavoli;
    }

    @Override
    public void run(String... args) throws Exception {
        menù.stampaMenù();
        System.out.println("------------------------------ TAVOLI -----------------------------");
        System.out.println();
        tavoli.forEach(t -> log.info(t.toString()));
        System.out.println();
        List<Tavolo> free = tavoli.stream().filter(t -> t.libero).collect(Collectors.toList());
        if (free.isEmpty()) {
            log.info("Non ci sono tavoli liberi al momento.");
            return;
        } else {
            System.out.println("SELEZIONA UN TAVOLO LIBERO TRA QUELLI VISUALIZZATI DI SEGUITO, INSERENDO IL LORO NUMERO");
            for (int i = 0; i < free.size(); i++) {
                log.info((i + 1) + ": " + free.get(i).toString());
            }

            int scelta = Integer.parseInt(sc.nextLine());
            if (scelta < 1 || scelta > free.size()) {
                System.out.println("Selezione non valida.");
                return;
            }

            Tavolo tavoloSelezionato = free.get(scelta - 1);

            System.out.println("HAI SCELTO IL TAVOLO " + tavoloSelezionato);
            System.out.println();
            System.out.println("INSERISCI IL NUMERO DI COPERTI");
            int coperti = Integer.parseInt(sc.nextLine());
            System.out.println("ORDINA I TUOI PIATTI");
            Ordine ordine = new Ordine(coperti, LocalTime.now(), tavoloSelezionato, articoliOrdinati, Ordine.StatoOrdine.IN_CORSO);
            System.out.println("Ordine creato: " + ordine);

            ordine.calcolaTotale();

        }
    }
}
