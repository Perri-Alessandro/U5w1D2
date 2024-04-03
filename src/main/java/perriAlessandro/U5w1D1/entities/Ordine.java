package perriAlessandro.U5w1D1.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Ordine {

    public int nOrdine;

    public int nCoperti;

    public LocalTime oraAcquisizione;

    public Tavolo tavolo;

    public List<Item> ordine;

    private StatoOrdine stato;

    private double costoCoperto;

    public double calcolaTotale() {
        double totale = ordine.stream().mapToDouble(Item::getPrezzo).sum();
        totale += nCoperti * costoCoperto;
        return totale;
    }

    public enum StatoOrdine {
        IN_CORSO, PRONTO, SERVITO
    }

}
