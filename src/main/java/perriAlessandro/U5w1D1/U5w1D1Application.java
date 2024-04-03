package perriAlessandro.U5w1D1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import perriAlessandro.U5w1D1.entities.Menù;

@SpringBootApplication
public class U5w1D1Application {

    public static void main(String[] args) {

        SpringApplication.run(U5w1D1Application.class, args);

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(U5w1D1Application.class);

        Menù m = (Menù) ctx.getBean("menù");

        m.stampaMenù();
        ctx.close();
    }

}
