import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuInicial {
    public JPanel panelMenu;
    public JButton iniciarSesiónButton;
    public JButton registrarseButton;

    public MenuInicial() {
        registrarseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame registroFrame = new JFrame("Registro");
                Registro registro = new Registro(registroFrame); // ← pasar la ventana actual al constructor
                registroFrame.setContentPane(registro.panelprincipal);
                registroFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                registroFrame.pack();
                registroFrame.setVisible(true);

                // (Opcional) cerrar el menú inicial si no quieres que quede abierto
                // ((JFrame) SwingUtilities.getWindowAncestor(panelMenu)).dispose();
            }
        });
    }
}

//.