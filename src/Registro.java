import javax.swing.*;
import java.awt.*;

public class Registro {

    public JTextField textFieldnameusuario;
    public JTextField textFieldcedulausuario;
    public JCheckBox animalesSalvajesCheckBox;
    public JTextField textFieldnombremascotas;
    public JTextField textFieldcantidadmascotas;
    public JTextField textFieldhistoriamascota;
    public JButton finalizarButton;
    public JPanel panelprincipal;
    public JLabel etiquetatitulo;
    public JLabel etiquetanameusuario;
    public JLabel etiquetacedulausuario;
    public JLabel etiquetacantidadmascotas;
    public JLabel etiquetanombredemascotas;
    public JLabel etiquetahistoriamascota;
    public JButton confirmarButton;
    public JPanel panelmascotas;

    public Registro() {
        finalizarButton.addActionListener(e -> JOptionPane.showMessageDialog(null, "Registro finalizado"));
        confirmarButton.addActionListener(e -> {
            panelmascotas.removeAll();

            String texto = textFieldcantidadmascotas.getText();
            int cantidad;

            try {
                cantidad = Integer.parseInt(texto);
                if (cantidad < 0) {
                    throw new NumberFormatException("Negativo");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Por favor ingresa un número válido (0 o más).");
                return;
            }


            panelmascotas.setLayout(new BoxLayout(panelmascotas, BoxLayout.Y_AXIS));

            for (int i = 1; i <= cantidad; i++) {
                // Panel para una mascota
                JPanel fila = new JPanel(new GridLayout(2, 2, 5, 5)); // 2 filas x 2 columnas

                JLabel etiquetaNombre = new JLabel("Mascota " + i + ":");
                JTextField campoNombre = new JTextField(25);

                JLabel etiquetaHistoria = new JLabel("Historia " + i + ":");
                JTextField campoHistoria = new JTextField(40);
                fila.add(etiquetaNombre);
                fila.add(campoNombre);
                fila.add(etiquetaHistoria);
                fila.add(campoHistoria);

                panelmascotas.add(fila); // Agregamos la fila completa al panel
                panelmascotas.add(Box.createVerticalStrut(10)); // Espacio entre bloques
            }

            panelmascotas.revalidate();
            panelmascotas.repaint();
        });
    }
}