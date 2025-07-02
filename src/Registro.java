import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registro {
    public JPanel panelprincipal;
    public JTextField textFieldnameusuario;
    public JTextField textFieldcedulausuario;
    public JCheckBox animalesSalvajesCheckBox;
    public JButton finalizarButton;
    public JLabel etiquetatitulo;
    public JLabel etiquetacedulausuario;
    public JLabel etiquetanameusuario;
    public JLabel etiquetacantidadmascotas;
    public JTextField textFieldcantidadmascotas;

    public Registro(JFrame ventanaRegistro) {
        finalizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreUsuario = textFieldnameusuario.getText();
                String cedulaUsuario = textFieldcedulausuario.getText();

                if (nombreUsuario.isEmpty() || cedulaUsuario.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor complete todos los campos.");
                    return;
                }

                JOptionPane.showMessageDialog(null, "Registro de usuario finalizado.");
                ventanaRegistro.dispose(); // Solo cierra la ventana
            }
        });
    }
}


