package clase.pkg2;
import javax.swing.*;

public class Clase2 {
    /*Desarrolle una aplicacion que solicitandole la carrera a un estudiante
        muestre un mensaje de seleccionado si el estudiante es de informatica*/
        
    public static boolean seleccionarEstudiante(){
        String[] car = {"Informatica", "Produccion", "Otro"};
        int resp = JOptionPane.showOptionDialog(null, "¿Que Estudia?", "Responda", 0, JOptionPane.QUESTION_MESSAGE, null, car, "" );
        if (resp == 0 ) {
        JOptionPane.showMessageDialog(null,"Usted ha Sido Seleccionado");
        } else {
        JOptionPane.showMessageDialog(null,"Usted no ha Sido Seleccionado");
        }
        int confirmar = JOptionPane.showConfirmDialog(null, "¿Otro estudiante?");
        return (confirmar == 0);
    }
    
    public static void main(String[] args) {
                
        while (seleccionarEstudiante()) {        
        
        }
    }
    
}

/*
        Entrevistadas N personas indique si fue o no seleccionada en base a estos requisitos:
        Estudiante de Informatica
        Disponibilidad en la mañana o en la tarde 
        promedio no menor a 15 Puntos 
        NOTA: El promedio se obtendra mediante la lectura de 5 notas que deberan estar
        en un rango de 1 a 20.
        Al finalizar mostrar total de Seleccionados y total de no Seleccionados
        */
        /*Leidas las 5 Notas de N estudiantes Calcule y muestre su nota final, promedio e indique 
        si aprobo o reprobo, valide la notas y que el promedio se muestre con el formato de un decimal*/
