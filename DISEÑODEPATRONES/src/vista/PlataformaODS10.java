
package vista;

import javax.swing.*;
import java.awt.*;
import controlador.ControladorNecesidad;

public class PlataformaODS10 extends JFrame {

    // Módulo 1
    private JPanel panelM1;
    private CardLayout cardM1;
    private JTextField txtNombre, txtApellidos, txtDescripcion;
    private JComboBox<String> comboGrupo;

    // Módulo 2
    private JPanel panelM2;
    private CardLayout cardM2;
    private JComboBox<String> comboTipoRecurso;
    private JTextField txtRecursoDescripcion;

    // Módulo 3
    private JPanel panelM3;
    private CardLayout cardM3;

    public PlataformaODS10() {
        setTitle("Plataforma ODS 10 - Reducción de Desigualdades Sociales");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabs = new JTabbedPane();

        // Módulo 1 - Registro de Usuario
        cardM1 = new CardLayout();
        panelM1 = new JPanel(cardM1);
        panelM1.add(m1_sub1(), "1");
        panelM1.add(m1_sub2(), "2");
        panelM1.add(m1_sub3(), "3");
        tabs.add("Registro de Usuario", panelM1);

        // Módulo 2 - Recursos y Ayudas
        cardM2 = new CardLayout();
        panelM2 = new JPanel(cardM2);
        panelM2.add(m2_sub1(), "1");
        panelM2.add(m2_sub2(), "2");
        panelM2.add(m2_sub3(), "3");
        tabs.add("Recursos y Ayudas", panelM2);

        // Módulo 3 - Seguimiento de Impacto
        cardM3 = new CardLayout();
        panelM3 = new JPanel(cardM3);
        panelM3.add(m3_sub1(), "1");
        panelM3.add(m3_sub2(), "2");
        panelM3.add(m3_sub3(), "3");
        tabs.add("Seguimiento de Impacto", panelM3);

        add(tabs);
        setVisible(true);
    }

    // ---------------- MÓDULO 1 ----------------
    private JPanel m1_sub1() {
        JPanel p = new JPanel(new GridLayout(3, 2, 10, 10));
        txtNombre = new JTextField();
        txtApellidos = new JTextField();
        p.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        p.add(new JLabel("Nombre:"));
        p.add(txtNombre);
        p.add(new JLabel("Apellidos:"));
        p.add(txtApellidos);
        JButton siguiente = new JButton("Siguiente ▶");
        siguiente.addActionListener(e -> cardM1.show(panelM1, "2"));
        p.add(siguiente);
        return p;
    }

    private JPanel m1_sub2() {
        JPanel p = new JPanel(new GridLayout(3, 2, 10, 10));
        comboGrupo = new JComboBox<>(new String[]{"Niño", "Adulto Mayor", "Discapacidad"});
        txtDescripcion = new JTextField();
        p.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        p.add(new JLabel("Grupo Vulnerable:"));
        p.add(comboGrupo);
        p.add(new JLabel("Descripción:"));
        p.add(txtDescripcion);
        JButton siguiente = new JButton("Siguiente ▶");
        siguiente.addActionListener(e -> cardM1.show(panelM1, "3"));
        p.add(siguiente);
        return p;
    }

    private JPanel m1_sub3() {
        JPanel p = new JPanel(new BorderLayout(10, 10));
        JLabel lbl = new JLabel("Presiona Finalizar para guardar en la base de datos.");
        lbl.setHorizontalAlignment(SwingConstants.CENTER);
        JButton btnFinalizar = new JButton("Finalizar ✅");
        btnFinalizar.addActionListener(e -> {
            String nombre = txtNombre.getText();
            String apellidos = txtApellidos.getText();
            String grupo = (String) comboGrupo.getSelectedItem();
            String descripcion = txtDescripcion.getText();
            ControladorNecesidad c = new ControladorNecesidad();
            c.registrar(nombre, apellidos, grupo, descripcion);
            JOptionPane.showMessageDialog(this, "Registro guardado correctamente.");
            txtNombre.setText(""); txtApellidos.setText(""); txtDescripcion.setText("");
            cardM1.show(panelM1, "1");
        });
        p.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        p.add(lbl, BorderLayout.CENTER);
        p.add(btnFinalizar, BorderLayout.SOUTH);
        return p;
    }

    // ---------------- MÓDULO 2 ----------------
    private JPanel m2_sub1() {
        JPanel p = new JPanel(new GridLayout(2, 2, 10, 10));
        comboTipoRecurso = new JComboBox<>(new String[]{"Donación", "Voluntariado"});
        p.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        p.add(new JLabel("Tipo de ayuda:"));
        p.add(comboTipoRecurso);
        JButton siguiente = new JButton("Siguiente ▶");
        siguiente.addActionListener(e -> cardM2.show(panelM2, "2"));
        p.add(siguiente);
        return p;
    }

    private JPanel m2_sub2() {
        JPanel p = new JPanel(new GridLayout(2, 2, 10, 10));
        txtRecursoDescripcion = new JTextField();
        p.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        p.add(new JLabel("Descripción del recurso:"));
        p.add(txtRecursoDescripcion);
        JButton siguiente = new JButton("Siguiente ▶");
        siguiente.addActionListener(e -> cardM2.show(panelM2, "3"));
        p.add(siguiente);
        return p;
    }

    private JPanel m2_sub3() {
        JPanel p = new JPanel(new BorderLayout(10, 10));
        JLabel lbl = new JLabel("Presiona Guardar para registrar el recurso.");
        lbl.setHorizontalAlignment(SwingConstants.CENTER);
        JButton guardar = new JButton("Guardar recurso");
        guardar.addActionListener(e -> {
            String tipo = (String) comboTipoRecurso.getSelectedItem();
            String detalle = txtRecursoDescripcion.getText();
            JOptionPane.showMessageDialog(this,
                "Tipo: " + tipo + "\nDescripción: " + detalle,
                "Recurso registrado", JOptionPane.INFORMATION_MESSAGE);
            cardM2.show(panelM2, "1");
            txtRecursoDescripcion.setText("");
        });
        p.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        p.add(lbl, BorderLayout.CENTER);
        p.add(guardar, BorderLayout.SOUTH);
        return p;
    }

    // ---------------- MÓDULO 3 ----------------
    private JPanel m3_sub1() {
        JPanel p = new JPanel(new BorderLayout());
        JTextArea historial = new JTextArea("Historial simulado:\n- Carlos solicitó silla de ruedas\n- Ana ofreció voluntariado");
        historial.setEditable(false);
        p.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        p.add(new JScrollPane(historial), BorderLayout.CENTER);
        JButton siguiente = new JButton("Siguiente ▶");
        siguiente.addActionListener(e -> cardM3.show(panelM3, "2"));
        p.add(siguiente, BorderLayout.SOUTH);
        return p;
    }

    private JPanel m3_sub2() {
        JPanel p = new JPanel(new BorderLayout());
        JLabel lbl = new JLabel("Impacto simulado: 8 recursos entregados, 3 voluntarios activos.");
        lbl.setHorizontalAlignment(SwingConstants.CENTER);
        p.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        p.add(lbl, BorderLayout.CENTER);
        JButton siguiente = new JButton("Siguiente ▶");
        siguiente.addActionListener(e -> cardM3.show(panelM3, "3"));
        p.add(siguiente, BorderLayout.SOUTH);
        return p;
    }

    private JPanel m3_sub3() {
        JPanel p = new JPanel(new BorderLayout());
        JLabel lbl = new JLabel("¿Deseas exportar el reporte?");
        lbl.setHorizontalAlignment(SwingConstants.CENTER);
        JButton exportar = new JButton("Exportar");
        exportar.addActionListener(e -> JOptionPane.showMessageDialog(this, "Reporte exportado correctamente (simulado)."));
        p.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        p.add(lbl, BorderLayout.CENTER);
        p.add(exportar, BorderLayout.SOUTH);
        return p;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PlataformaODS10());
    }
}
