import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class InicioSesión {
    public JPanel panel1;
    private JTextField VerificarNombretextField1;
    private JTextField VerificarNumerodeDocumentotextField2;
    private JButton finalizarButton;
    private JButton registrarMascotasButton;
    private JButton informeDeDatosButton;
    private JButton verMascotasButton;

    public InicioSesión() {
        registrarMascotasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = VerificarNombretextField1.getText();
                String cedula = VerificarNumerodeDocumentotextField2.getText();

                if (nombre.isEmpty() || cedula.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingrese nombre y cédula.");
                    return;
                }

                JFrame mascotaFrame = new JFrame("Registro de Mascotas");
                RegistrodeMascotas registroMascota = new RegistrodeMascotas(cedula, nombre, mascotaFrame);
                mascotaFrame.setContentPane(registroMascota.panel1);
                mascotaFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                mascotaFrame.pack();
                mascotaFrame.setVisible(true);
            }
        });

        verMascotasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cedula = VerificarNumerodeDocumentotextField2.getText();
                File archivo = new File(cedula + ".txt");

                if (!archivo.exists()) {
                    JOptionPane.showMessageDialog(null, "No se encontró registro para esta cédula.");
                    return;
                }

                try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
                    StringBuilder contenido = new StringBuilder();
                    String linea;
                    while ((linea = reader.readLine()) != null) {
                        contenido.append(linea).append("\n");
                    }

                    JTextArea textArea = new JTextArea(contenido.toString());
                    textArea.setEditable(false);
                    JScrollPane scrollPane = new JScrollPane(textArea);
                    scrollPane.setPreferredSize(new java.awt.Dimension(400, 300));

                    JOptionPane.showMessageDialog(null, scrollPane, "Mascotas Registradas", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        informeDeDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File carpeta = new File(".");
                File[] archivos = carpeta.listFiles((dir, name) -> name.endsWith(".txt"));

                if (archivos == null || archivos.length == 0) {
                    JOptionPane.showMessageDialog(null, "No hay archivos de registro.");
                    return;
                }

                StringBuilder informe = new StringBuilder();

                for (File archivo : archivos) {
                    try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
                        String linea;
                        String dueño = "";
                        while ((linea = reader.readLine()) != null) {
                            if (linea.startsWith("Dueño:")) {
                                dueño = linea;
                                informe.append("\n").append(dueño).append("\n");
                            }
                            if (linea.startsWith("Nombre:") && !dueño.isEmpty()) {
                                informe.append(" - ").append(linea.substring(8)).append("\n");
                            }
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }

                JTextArea textArea = new JTextArea(informe.toString());
                textArea.setEditable(false);
                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new java.awt.Dimension(500, 400));
                JOptionPane.showMessageDialog(null, scrollPane, "Informe General de Mascotas", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        finalizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((JFrame) SwingUtilities.getWindowAncestor(panel1)).dispose();
            }
        });
    }
}
