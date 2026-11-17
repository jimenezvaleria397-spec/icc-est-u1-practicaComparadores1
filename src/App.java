
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import models.Estudiante;

public class App {

    public static void main(String[] args) {

        List<Estudiante> estudiantes = new ArrayList<>(List.of(
            new Estudiante("E014", "Ana", 20, 8.5, "Computacion"),
            new Estudiante("E003", "Luis", 19, 7.8, "Electronica"),
            new Estudiante("E018", "Maria", 21, 9.2, "Computacion"),
            new Estudiante("E007", "Pedro", 20, 8.5, "Mecatronica"),
            new Estudiante("E001", "Sofia", 18, 9.5, "Computacion"),
            new Estudiante("E012", "Diego", 22, 6.8, "Electronica"),
            new Estudiante("E005", "Ana", 19, 8.5, "Computacion"),
            new Estudiante("E020", "Carlos", 21, 7.8, "Mecatronica"),
            new Estudiante("E009", "Lucia", 20, 9.2, "Electronica"),
            new Estudiante("E016", "Mateo", 18, 7.0, "Computacion"),
            new Estudiante("E002", "Elena", 22, 8.0, "Mecatronica"),
            new Estudiante("E011", "Pablo", 21, 9.5, "Electronica"),
            new Estudiante("E006", "Sara", 19, 6.8, "Computacion"),
            new Estudiante("E019", "Juan", 20, 8.0, "Mecatronica"),
            new Estudiante("E004", "Diana", 18, 9.2, "Electronica"),
            new Estudiante("E015", "Bruno", 22, 7.0, "Computacion"),
            new Estudiante("E008", "Carla", 21, 8.5, "Mecatronica"),
            new Estudiante("E017", "Andres", 19, 9.5, "Electronica"),
            new Estudiante("E010", "Ana", 20, 8.5, "Computacion"),
            new Estudiante("E013", "Luis", 19, 7.8, "Electronica")
        ));

        // C1
        List<Estudiante> c1 = new ArrayList<>(estudiantes);
        c1.sort(null);

        System.out.println("==== C1 ====");
        for (Estudiante e : c1) {
            System.out.println(e);
        }

        // C2
        Comparator<Estudiante> compC2 = (e1, e2) -> {
            int resultado = e1.getNombre().compareTo(e2.getNombre());

            if (resultado == 0) {
                resultado = e1.getCodigo().compareTo(e2.getCodigo());
            }

            return resultado;
        };

        List<Estudiante> c2 = new ArrayList<>(estudiantes);
        c2.sort(compC2);

        System.out.println("==== C2 ====");
        for (Estudiante e : c2) {
            System.out.println(e);
        }

        // C2 con Comparator
        List<Estudiante> c2B = new ArrayList<>(estudiantes);
        c2B.sort(Comparator.comparing(Estudiante::getNombre)
                .thenComparing(Estudiante::getCodigo));

        System.out.println("\nC2 segunda forma");
        for (Estudiante e : c2B) {
            System.out.println(e);
        }

        // C3
        List<Estudiante> c3 = new ArrayList<>(estudiantes);
        c3.sort(Comparator.comparingDouble(Estudiante::getNota));

        System.out.println("\nC3");
        for (Estudiante e : c3) {
            System.out.println(e);
        }

        // C4
        List<Estudiante> c4 = new ArrayList<>(estudiantes);
        c4.sort(Comparator.comparingDouble(Estudiante::getNota)
                .reversed()
                .thenComparing(Estudiante::getNombre));

        System.out.println("\nC4");
        for (Estudiante e : c4) {
            System.out.println(e);
        }

        // C5
        List<Estudiante> c5 = new ArrayList<>(estudiantes);
        c5.sort(Comparator.comparingInt(Estudiante::getEdad)
                .thenComparing(Comparator.comparing(Estudiante::getNombre)
                .reversed()));

        System.out.println("\nC5");
        for (Estudiante e : c5) {
            System.out.println(e);
        }

        // C6
        List<Estudiante> c6 = new ArrayList<>(estudiantes);
        c6.sort(Comparator.comparing(Estudiante::getCarrera)
                .thenComparing(Comparator.comparingDouble(Estudiante::getNota)
                .reversed())
                .thenComparing(Estudiante::getNombre)
                .thenComparing(Estudiante::getCodigo));

        System.out.println("\nC6");
        for (Estudiante e : c6) {
            System.out.println(e);
        }

        // C7
        List<Estudiante> c7 = new ArrayList<>(estudiantes);

        c7.sort(Comparator.comparingDouble((Estudiante e) -> {
            if (e.getCarrera().equals("Computacion")) {
                return Math.min(10.0, e.getNota() + 0.5);
            }
            return e.getNota();
        }).reversed()
          .thenComparing(Estudiante::getNombre)
          .thenComparing(Estudiante::getCodigo));

        System.out.println("\nC7");
        for (Estudiante e : c7) {
            System.out.println(e);
        }
    }
}
