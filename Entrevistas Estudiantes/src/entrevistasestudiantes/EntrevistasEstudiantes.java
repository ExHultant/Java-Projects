package entrevistasestudiantes;
import javax.swing.*;

public class EntrevistasEstudiantes {
    public static void main(String[] args) {
        int totalEntrevistados = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número total de personas entrevistadas:"));
        int estudiantesSeleccionadosManana = 0;
        int estudiantesSeleccionadosTarde = 0;
        int estudiantesNoSeleccionados = 0;
        String[] disponibilidad = {"Mañana", "Tarde"};
        String[] car = {"Informatica", "Administración de Empresas", "Produccion", "Electronica"};

        for (int i = 0; i < totalEntrevistados; i++) {
            int resp, respCar;
            double[] notas = new double[5];
            double suma = 0;
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del estudiante " + (i + 1) + ":");
            int semestre = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el semestre de " + nombre + " (entre 1 al 6):"));            
            resp = JOptionPane.showOptionDialog(null, "Ingrese la disponibilidad de " + nombre + " (mañana/tarde):", "Responda", 0, JOptionPane.QUESTION_MESSAGE, null, disponibilidad, "");
            respCar = JOptionPane.showOptionDialog(null, "Ingrese que Carrera estudia " + nombre + ": ", "Responda", 0, JOptionPane.QUESTION_MESSAGE, null, car, "");
            for (int j = 0; j < 5; j++) {
                boolean notaValida = false;

                while (!notaValida) {
                    try {
                        notas[j] = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la nota " + (j + 1) + " (0-20):"));
                        if (notas[j] >= 0 && notas[j] <= 20) {
                            suma += notas[j];
                            notaValida = true;
                        } else {
                            JOptionPane.showMessageDialog(null, "Ingrese una nota válida entre 0 y 20.");
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Ingrese una nota válida entre 0 y 20.");
                    }
                }
            }
            double promedio = suma / 5.0;
            double notaFinal = Math.round(promedio * 10) / 10.0; // Redondea a un decimal
            //ESTA MIERDA NO ESTA VALIDANDO UN COÑO
            //MAL PARIDO JAVA
            if (semestre >= 2 && semestre <= 4 && (resp == 0 || resp == 1) && (notaFinal > 15) && (respCar == 0)) {
                if (resp == 0 )  {
                    estudiantesSeleccionadosManana++;
                } else {
                    estudiantesSeleccionadosTarde++;
                }
            } else {
                estudiantesNoSeleccionados++;
            }
        }

        JOptionPane.showMessageDialog(null, "Resultados de la selección de estudiantes:\n\n" +
                "Estudiantes seleccionados en la mañana: " + estudiantesSeleccionadosManana + "\n" +
                "Estudiantes seleccionados en la tarde: " + estudiantesSeleccionadosTarde + "\n" +
                "Estudiantes no seleccionados: " + estudiantesNoSeleccionados + "\n" +
                "Total de entrevistados: " + totalEntrevistados);    }
    
}
