package perriAlessandro.U5w1D1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import perriAlessandro.U5w1D1.entities.Menù;
import perriAlessandro.U5w1D1.entities.Tavolo;

import java.util.List;

@SpringBootApplication
public class U5w1D1Application {

    public static void main(String[] args) {

        SpringApplication.run(U5w1D1Application.class, args);

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(U5w1D1Application.class);

        Menù m = (Menù) ctx.getBean("menù");

        List<Tavolo> tavoli = (List<Tavolo>) ctx.getBean("tavoli");

        m.stampaMenù();
        System.out.println();
        System.out.println("------------------------------ TAVOLI -----------------------------");
        System.out.println();
        tavoli.forEach(System.out::println);
        ctx.close();
    }

}


// Si devono poter creare gli ordini inserendo i vari elementi dallo scanner