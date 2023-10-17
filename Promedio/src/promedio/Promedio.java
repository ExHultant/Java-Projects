package promedio;
import javax.swing.*;

public class Promedio {

   public static void main(String[] args) {
        int totalEstudiantes = obtenerTotalEstudiantes();

        if (totalEstudiantes <= 0) {
            JOptionPane.showMessageDialog(null, "El número de estudiantes debe ser mayor que 0.");
            return;
        }

        for (int i = 1; i <= totalEstudiantes; i++) {
            double[] notas = new double[5];
            double suma = 0;

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

            String resultado = "Estudiante #" + i + "\n";
            resultado += "Notas: ";
            for (int j = 0; j < notas.length; j++) {
                resultado += notas[j];
                if (j < notas.length - 1) {
                    resultado += ", ";
                }
            }
            resultado += "\nPromedio: " + notaFinal + "\n";

            if (notaFinal >= 10) {
                resultado += "Estado: Aprobado";
            } else {
                resultado += "Estado: Reprobado";
            }

            JOptionPane.showMessageDialog(null, resultado);
        }
    }

    private static int obtenerTotalEstudiantes() {
        int totalEstudiantes;
        try {
            totalEstudiantes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de estudiantes:"));
        } catch (NumberFormatException e) {
            totalEstudiantes = 0; // Valor por defecto si no se ingresa un número válido
        }
        return totalEstudiantes;
    }
    
}
