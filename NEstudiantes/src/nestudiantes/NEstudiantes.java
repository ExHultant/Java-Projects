package nestudiantes;
import javax.swing.*;

public class NEstudiantes {

    public static void main(String[] args) {
        /*
        Entrevistadas N personas indique si fue o no seleccionada en base a estos requisitos:
        Estudiante de Informatica
        Disponibilidad en la mañana o en la tarde 
        promedio no menor a 15 Puntos 
        NOTA: El promedio se obtendra mediante la lectura de 5 notas que deberan estar
        en un rango de 1 a 20.
        Al finalizar mostrar total de Seleccionados y total de no Seleccionados
        */
        int totalSeleccionados = 0;
        int totalNoSeleccionados = 0;
        int personasEntrevistadas = 0;

        int N = obtenerNumeroPersonas();

        if (N <= 0) {
            JOptionPane.showMessageDialog(null, "El número de personas a entrevistar debe ser mayor que 0.");
            return;
        }

        boolean continuarEntrevista = true;

        while (personasEntrevistadas < N && continuarEntrevista) {
            String[] turnos = {"Mañana", "Tarde"};
            String[] opciones = {"Si", "No"};
            int respuestaEstudiante = JOptionPane.showOptionDialog(
                    null,
                    "¿Es estudiante de Informática?",
                    "Entrevista",
                    0,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    ""
            );

            int respuestaDisponibilidad = JOptionPane.showOptionDialog(
                    null,
                    "¿Tiene disponibilidad en la mañana o en la tarde?",
                    "Entrevista",
                    0,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    turnos,
                    ""
            );

            int sumaNotas = 0;
            for (int j = 0; j < 5; j++) {
                int nota = obtenerNota(j + 1);

                if (nota < 1 || nota > 20) {
                    JOptionPane.showMessageDialog(null, "Ingrese una nota válida entre 1 y 20.");
                    continue;
                }

                sumaNotas += nota;
            }

            double promedio = sumaNotas / 5.0;

            if (respuestaEstudiante == 0 && respuestaDisponibilidad == 0 && promedio >= 15) {
                totalSeleccionados++;
            } else {
                totalNoSeleccionados++;
            }

            personasEntrevistadas++;

            if (personasEntrevistadas < N) {
                int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea entrevistar a otra persona?");
                continuarEntrevista = (respuesta == JOptionPane.YES_OPTION);
            }
        }

        JOptionPane.showMessageDialog(null, "Total Seleccionados: " + totalSeleccionados + "\nTotal No Seleccionados: " + totalNoSeleccionados);
    }

    private static int obtenerNumeroPersonas() {
        int N;
        try {
            N = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de personas a entrevistar:"));
        } catch (NumberFormatException e) {
            N = 0; // Valor por defecto si no se ingresa un número válido
        }
        return N;
    }

    private static int obtenerNota(int numero) {
        int nota;
        try {
            nota = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nota " + numero + " (1-20):"));
        } catch (NumberFormatException e) {
            nota = 0; // Valor por defecto si no se ingresa una nota válida
        }
        return nota;
    }
    
}
