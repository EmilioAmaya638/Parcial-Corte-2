import javax.swing.*;

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
    public Registro () {
        finalizarButton.addActionListener(e -> JOptionPane.showMessageDialog(null, "Registro finalizado"));
    }

}
