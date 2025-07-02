import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrodeMascotas {
    public JPanel panel1;
    private JTextField textField1; // Nombre de mascota
    private JTextField textField2; // Especie
    private JTextField textField3; // Historia
    private JButton finalizarButton;
    private JLabel registroDeMascotasLabel;
    private JLabel nombreDeLaMascotaLabel;
    private JLabel especieLabel;
    private JLabel historiaLabel;

    public RegistrodeMascotas(String cedula, String nombreDueño, JFrame ventana) {
        finalizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreMascota = textField1.getText();
                String especie = textField2.getText();
                String historia = textField3.getText();

                if (nombreMascota.isEmpty() || especie.isEmpty() || historia.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor complete todos los campos de la mascota.");
                    return;
                }

                GestorDeArchivos.guardarMascota(cedula, nombreDueño, nombreMascota, especie, historia);

                JOptionPane.showMessageDialog(null, "Mascota registrada correctamente.");
                ventana.dispose(); // Cierra la ventana actual
            }
        });
    }
}
