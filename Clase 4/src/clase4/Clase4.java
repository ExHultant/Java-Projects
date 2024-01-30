package clase4;

import javax.swing.*;

public class Clase4 {

    public static void main(String[] args) {
        String username = null, name = null, id = null;
        int modulo = 0, desc = 0, burguer = 0, day, drinker = 0;
        double ph = 0.00, pb = 0.00, totalDayCost = 0.00;
        String[] days = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes"};
        username = JOptionPane.showInputDialog("Ingrese su nombre de usuario: ");
        JOptionPane.showMessageDialog(null, "Bienvenido " + username);
        ph = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el precio de las hamburguesas: "));
        pb = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el precio de las Bedidas: "));
        modulo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el porcentaje de Icremento: "));
        day = JOptionPane.showOptionDialog(null, "Ingrese el dia de descuento: ", "Responda", 0, JOptionPane.QUESTION_MESSAGE, null, days, "");
        if (day == 2) {
            desc = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el porcentaje de Descuento: "));
        } else {
            desc = 0;
        }

        int numClientes = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos clientes serán atendidos?"));

        for (int x = 1; x <= numClientes; x++) {
            JOptionPane.showMessageDialog(null, "Bienvenido");
            name = JOptionPane.showInputDialog("Indique su nombre: ");
            id = JOptionPane.showInputDialog("Indique su Identificacion: ");
            burguer = Integer.parseInt(JOptionPane.showInputDialog("¿Cuantas Hamburguesas Desea? \n El Precio de las Hamburguesas es: " + ph + "$"));
            drinker = Integer.parseInt(JOptionPane.showInputDialog("¿Cuantas Bebidas Desea? \n El Precio de las Hamburguesas es: " + pb + "$"));
            double totalCost = (burguer * ph + drinker * pb);
            if (day == 2) {
                totalCost -= (totalCost * desc / 100);
            }
            int paymentMethod = JOptionPane.showOptionDialog(null, "Seleccione el método de pago:",
                    "Método de Pago", 0, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Efectivo", "Tarjeta de Crédito"}, "");

            if (paymentMethod == 1) {
                totalCost += (totalCost * modulo / 100);
            }

            totalDayCost += totalCost;

            // Formatear el costo con dos decimales
            String formattedCost = String.format("%.2f", totalCost);

            JOptionPane.showMessageDialog(null, "Cliente: " + name + "\nIdentificación: " + id +
                    "\nHamburguesas: " + burguer + " x $" + ph + " = $" + (burguer * ph) +
                    "\nBebidas: " + drinker + " x $" + pb + " = $" + (drinker * pb) +
                    "\nDescuento: " + (day == 2 ? desc + "%" : "0%") +
                    "\nIncremento: " + (paymentMethod == 1 ? modulo + "%" : "0%") +
                    "\nTotal a Pagar: $" + formattedCost);
        }

        // Formatear el total acumulado del día con dos decimales
        String formattedTotalDayCost = String.format("%.2f", totalDayCost);
        JOptionPane.showMessageDialog(null, "Total acumulado del día: $" + formattedTotalDayCost);

    }

}
