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

                ventanaRegistro.dispose();

                JFrame mascotaFrame = new JFrame("Registro de Mascotas");
                RegistrodeMascotas registroMascota = new RegistrodeMascotas(cedulaUsuario, nombreUsuario);
                mascotaFrame.setContentPane(registroMascota.panel1);
                mascotaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                mascotaFrame.pack();
                mascotaFrame.setVisible(true);
            }
        });
    }
}


