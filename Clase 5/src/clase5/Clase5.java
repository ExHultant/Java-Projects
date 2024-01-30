package clase5;
import javax.swing.*;

        /*Desarrolle una Aplicacion que recorre lo que se le pagara a un docente en base
        a la siguiente categoria (200 la hora), Si labora los dias recibira un bono de 25% y si
        tiene mas de un año en la institucion reciba un bono de 20% */

public class DocenteSalaryCalculator {
    public static void main(String[] args) {
        double hourlyRate = 200;

        boolean continueCalculating = true;

        while (continueCalculating) {
            double hoursWorked = getHoursWorked();
            boolean workedOnSaturday = workedOnSaturday();
            int yearsWorked = getYearsWorked();

            double salary = calculateSalary(hourlyRate, hoursWorked, workedOnSaturday, yearsWorked);

            displayResult(salary);

            int choice = JOptionPane.showConfirmDialog(null, "¿Calcular el salario de otro docente?", "Continuar", JOptionPane.YES_NO_OPTION);
            continueCalculating = (choice == JOptionPane.YES_OPTION);
        }
    }

    public static double getHoursWorked() {
        String hoursWorkedStr = JOptionPane.showInputDialog("Ingrese las horas trabajadas:");
        return Double.parseDouble(hoursWorkedStr);
    }

    public static boolean workedOnSaturday() {
        int option = JOptionPane.showConfirmDialog(null, "¿Trabajó el sábado?", "Sábado", JOptionPane.YES_NO_OPTION);
        return (option == JOptionPane.YES_OPTION);
    }

    public static int getYearsWorked() {
        String yearsWorkedStr = JOptionPane.showInputDialog("Ingrese los años trabajados:");
        return Integer.parseInt(yearsWorkedStr);
    }

    public static double calculateSalary(double hourlyRate, double hoursWorked, boolean workedOnSaturday, int yearsWorked) {
        double salary = hourlyRate * hoursWorked;

        if (workedOnSaturday) {
            salary += salary * 0.25; // 25% de bono por trabajar el sábado
        }

        if (yearsWorked > 1) {
            salary += salary * 0.20; // 20% de bono por más de 1 año de experiencia
        }

        return salary;
    }

    public static void displayResult(double salary) {
        JOptionPane.showMessageDialog(null, "Salario: $" + salary);
    }
}

