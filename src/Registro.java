import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registro {
    public JPanel panelprincipal;
    public JTextField textFieldnameusuario;
    public JTextField textFieldcedulausuario;
    public JCheckBox animalesSalvajesCheckBox;
    public JTextField textFieldnombremascotas;
    public JTextField textFieldcantidadmascotas;
    public JTextField textFieldhistoriamascota;
    public JButton finalizarButton;

    public Registro(JFrame ventanaRegistro) {  // ← recibir el JFrame que contiene el panel
        finalizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Registro finalizado");

                // Cerrar ventana actual
                ventanaRegistro.dispose();

                // Volver al menú inicial
                JFrame menuFrame = new JFrame("Menú Inicial");
                menuFrame.setContentPane(new MenuInicial().panelMenu);
                menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                menuFrame.pack();
                menuFrame.setVisible(true);
            }
        });
    }
}



