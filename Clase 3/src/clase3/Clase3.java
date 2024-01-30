package clase3;
import javax.swing.*;
public class Clase3 {

    public static void main(String[] args) {
 int totalSeleccionados = 0;
 int totalNoSeleccionados =0;
 
    int n = obtenerEntero("Ingrese la cantidad de personas a entrevistar:");
    
    for (int i = 0; i < n; i++) {
     String nombre = JOptionPane.showInputDialog("Ingrese el nombre del estudiante:");
            int opcionCarrera = obtenerOpcionCarrera();

            boolean esEstudianteInformatica = (opcionCarrera == 1);
            String disponibilidad = obtenerDisponibilidad("Ingrese disponibilidad (1 para Mañana, 2 para Tarde, 3 para Noche):");
            double promedio = calcularPromedio();
            String semestre = obtenerCarrera("Ingresa el semestre cursante (1 primer semestre, 2 para segundo, etc):");
            if (esEstudianteInformatica && (disponibilidad.equals("1") || disponibilidad.equals("2"))
                    && promedio >= 15) {
                JOptionPane.showMessageDialog(null, nombre + " fue seleccionado.");
                totalSeleccionados++;
            } else {
                JOptionPane.showMessageDialog(null, nombre + " no fue seleccionado.");
                totalNoSeleccionados++;
            }
        }

        JOptionPane.showMessageDialog(null, "Total seleccionados: " + totalSeleccionados
                + "\nTotal no seleccionados: " + totalNoSeleccionados);

        if (totalSeleccionados == 0) {
            JOptionPane.showMessageDialog(null, "Ningún estudiante fue seleccionado.");
        } else if (totalNoSeleccionados == 0) {
            JOptionPane.showMessageDialog(null, "Todos los estudiantes fueron seleccionados.");
        } else if (totalSeleccionados > totalNoSeleccionados) {
            JOptionPane.showMessageDialog(null, "La mayoría de los estudiantes fueron seleccionados.");
        } else {
            JOptionPane.showMessageDialog(null, "La mayoría de los estudiantes no fueron seleccionados.");
        }
    
    
            System.exit(0);
    
    }
    
    
    
    
    
    
    
    public static int obtenerEntero(String mensaje) {
        int valor = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                valor = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
                entradaValida = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un número entero válido.");
            }
        }

        return valor;
    }

    public static int obtenerOpcionCarrera() {
        int opcion = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            opcion = obtenerEntero("Seleccione la carrera:\n1. Informática\n2. Administración\n3. Otros");
            if (opcion >= 1 && opcion <= 3) {
                entradaValida = true;
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, seleccione una opción válida (1, 2 o 3).");
            }
        }

        return opcion;
    }

    public static String obtenerDisponibilidad(String mensaje) {
        String valor = "";
        boolean entradaValida = false;

        while (!entradaValida) {
            valor = JOptionPane.showInputDialog(mensaje);
            if (valor != null && (valor.equals("1") || valor.equals("2")  || valor.equals("3"))) {
                entradaValida = true;
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese una opción válida (1 para Mañana, 2 para Tarde).");
            }
        }

        return valor;
    }



        public static String obtenerCarrera(String mensaje) {
        String valor = "";
        boolean entradaValida = false;

        while (!entradaValida) {
            valor = JOptionPane.showInputDialog(mensaje);
            if (valor != null && (valor.equals("1") || valor.equals("2") || valor.equals("3") || valor.equals("4") || valor.equals("5") || valor.equals("6"))) {
                entradaValida = true;
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese una opción válida (1 primer semestre, 2 para segundo, etc):");
            }
        }

        return valor;
    }


    public static double calcularPromedio() {
        double suma = 0;

        for (int i = 0; i < 5; i++) {
            int nota = obtenerEntero("Ingrese la nota " + (i + 1) + " (1-20):");
            if (nota < 1 || nota > 20) {
                JOptionPane.showMessageDialog(null, "La nota debe estar en el rango de 1 a 20. Ingrese nuevamente.");
                i--;
            } else {
                suma += nota;
            }
        }

        return suma / 5;
    }
}
    
    //Añadirle: especificar cuantas personas en el turno de la mañana y cuantas en la tarde debe haber 
//y dar a escoger a la cantidad menor
//si quiere cambiarse de turno
    
    
    
    
/*
para proximas tareas, que un usuario pueda modificar informacion
que los bonos dependan de una variable

*/
    
    
    
    
    
    
    
    
    

