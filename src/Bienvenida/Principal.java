import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal extends JFrame {

    // Componentes de la interfaz 
    private JTextField nombreField;
    private JTextField apellidoPField;
    private JTextField apellidoMField;
    private JComboBox<String> departamentoCombo;
    private JComboBox<String> antiguedadCombo;
    private JTextArea resultadoArea;

    public Principal() {
        // Configuración de la ventana
        setTitle("Calculadora de Vacaciones - Dulcería");
        setSize(500, 500);  
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar ventana
        setLayout(null);  
        getContentPane().setBackground(new Color(64, 224, 208));  // Fondo 

        // Inicialización de componentes

        JLabel nombreLabel = new JLabel("Nombres:");
        nombreLabel.setBounds(10, 30, 100, 30);
        nombreLabel.setFont(new Font("Comic Sans MS", 1, 16));  
        nombreLabel.setForeground(new Color(255, 105, 180));  // Color rosa
        add(nombreLabel);

        nombreField = new JTextField(20);
        nombreField.setBounds(160, 30, 300, 30);
        nombreField.setFont(new Font("Comic Sans MS", 1, 14));
        nombreField.setBackground(new Color(255, 255, 255));  // Fondo blanco
        add(nombreField);

        JLabel apellidoPLabel = new JLabel("Apellido Paterno:");
        apellidoPLabel.setBounds(10, 80, 150, 30);
        apellidoPLabel.setFont(new Font("Comic Sans MS", 1, 16));
        apellidoPLabel.setForeground(new Color(255, 105, 180));  // Color rosa
        add(apellidoPLabel);

        apellidoPField = new JTextField(20);
        apellidoPField.setBounds(160, 80, 300, 30);
        apellidoPField.setFont(new Font("Comic Sans MS", 1, 14));
        apellidoPField.setBackground(new Color(255, 255, 255));
        add(apellidoPField);

        JLabel apellidoMLabel = new JLabel("Apellido Materno:");
        apellidoMLabel.setBounds(10, 130, 150, 30);
        apellidoMLabel.setFont(new Font("Comic Sans MS", 1, 16));
        apellidoMLabel.setForeground(new Color(255, 105, 180));  // Color rosa
        add(apellidoMLabel);

        apellidoMField = new JTextField(20);
        apellidoMField.setBounds(160, 130, 300, 30);
        apellidoMField.setFont(new Font("Comic Sans MS", 1, 14));
        apellidoMField.setBackground(new Color(255, 255, 255));
        add(apellidoMField);

        // Opciones de departamento
        JLabel departamentoLabel = new JLabel("Departamento:");
        departamentoLabel.setBounds(10, 180, 150, 30);
        departamentoLabel.setFont(new Font("Comic Sans MS", 1, 16));
        departamentoLabel.setForeground(new Color(255, 105, 180));  // Color rosa
        add(departamentoLabel);

        String[] departamentos = {
            "Atención al Cliente",
            "Departamento de Paquetería",
            "Departamento de Dulces"
        };
        departamentoCombo = new JComboBox<>(departamentos);
        departamentoCombo.setBounds(160, 180, 300, 30);
        departamentoCombo.setFont(new Font("Comic Sans MS", 1, 14));
        departamentoCombo.setBackground(new Color(255, 255, 255));
        add(departamentoCombo);

        // Opciones de antigüedad
        JLabel antiguedadLabel = new JLabel("Antigüedad:");
        antiguedadLabel.setBounds(10, 230, 150, 30);
        antiguedadLabel.setFont(new Font("Comic Sans MS", 1, 16));
        antiguedadLabel.setForeground(new Color(255, 105, 180));  // Color rosa
        add(antiguedadLabel);

        String[] antiguedades = {
            "1 año de servicio",
            "2 a 6 años de servicio",
            "7 años o más de servicio"
        };
        antiguedadCombo = new JComboBox<>(antiguedades);
        antiguedadCombo.setBounds(160, 230, 300, 30);
        antiguedadCombo.setFont(new Font("Comic Sans MS", 1, 14));
        antiguedadCombo.setBackground(new Color(255, 255, 255));
        add(antiguedadCombo);

        // Botón para calcular vacaciones
        JButton calcularButton = new JButton("Calcular Vacaciones");
        calcularButton.setBounds(60, 280, 200, 40);
        calcularButton.setBackground(new Color(255, 182, 193));  // Color rosa pastel
        calcularButton.setFont(new Font("Comic Sans MS", 1, 16));
        calcularButton.setForeground(Color.WHITE);
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularVacaciones();
            }
        });
        add(calcularButton);

        // Botón para limpiar
        JButton limpiarButton = new JButton("Limpiar Datos");
        limpiarButton.setBounds(270, 280, 200, 40);
        limpiarButton.setBackground(new Color(255, 182, 193));  // Color rosa 
        limpiarButton.setFont(new Font("Comic Sans MS", 1, 16));
        limpiarButton.setForeground(Color.WHITE);
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();  // Llama al método para limpiar
            }
        });
        add(limpiarButton);

        // Área de texto para mostrar resultados
        resultadoArea = new JTextArea(3, 20);
        resultadoArea.setEditable(false);
        resultadoArea.setFont(new Font("Comic Sans MS", 1, 12));
        resultadoArea.setBackground(new Color(255, 239, 213));  // Fondo crema

        
        JScrollPane scrollPane = new JScrollPane(resultadoArea);
        scrollPane.setBounds(30, 340, 420, 100);
        add(scrollPane); 
    }

    // Método para limpiar todos los campos
    private void limpiarCampos() {
        nombreField.setText("");
        apellidoPField.setText("");
        apellidoMField.setText("");
        departamentoCombo.setSelectedIndex(0);
        antiguedadCombo.setSelectedIndex(0);
        resultadoArea.setText("");
    }

    public static void main(String[] args) {
        Principal ventanaPrincipal = new Principal();
        ventanaPrincipal.setVisible(true); 
    }

    private void calcularVacaciones() {
        String nombreTrabajador = nombreField.getText();
        String AP = apellidoPField.getText();
        String AM = apellidoMField.getText();
        String departamento = (String) departamentoCombo.getSelectedItem();
        String antiguedad = (String) antiguedadCombo.getSelectedItem();

        String resultado = calcularVacaciones(nombreTrabajador, AP, AM, departamento, antiguedad);
        resultadoArea.setText(resultado); // Mostrar resultado
    }

    public static String calcularVacaciones(String nombre, String AP, String AM, String departamento, String antiguedad) {
        String resultado = "";

        if (departamento.equals("Atención al Cliente")) {
            if (antiguedad.equals("1 año de servicio")) {
                resultado = "\nEl trabajador " + nombre + " " + AP + " " + AM +
                        "\nquien labora en " + departamento + " con " + antiguedad +
                        "\nrecibe 6 días de vacaciones.";
            } else if (antiguedad.equals("2 a 6 años de servicio")) {
                resultado = "\nEl trabajador " + nombre + " " + AP + " " + AM +
                        "\nquien labora en " + departamento + " con " + antiguedad +
                        "\nrecibe 14 días de vacaciones.";
            } else if (antiguedad.equals("7 años o más de servicio")) {
                resultado = "\nEl trabajador " + nombre + " " + AP + " " + AM +
                        "\nquien labora en " + departamento + " con " + antiguedad +
                        "\nrecibe 20 días de vacaciones.";
            }
        } else if (departamento.equals("Departamento de Paquetería")) {
            if (antiguedad.equals("1 año de servicio")) {
                resultado = "\nEl trabajador " + nombre + " " + AP + " " + AM +
                        "\nquien labora en " + departamento + " con " + antiguedad +
                        "\nrecibe 7 días de vacaciones.";
            } else if (antiguedad.equals("2 a 6 años de servicio")) {
                resultado = "\nEl trabajador " + nombre + " " + AP + " " + AM +
                        "\nquien labora en " + departamento + " con " + antiguedad +
                        "\nrecibe 15 días de vacaciones.";
            } else if (antiguedad.equals("7 años o más de servicio")) {
                resultado = "\nEl trabajador " + nombre + " " + AP + " " + AM +
                        "\nquien labora en " + departamento + " con " + antiguedad +
                        "\nrecibe 22 días de vacaciones.";
            }
        } else if (departamento.equals("Departamento de Dulces")) {
            if (antiguedad.equals("1 año de servicio")) {
                resultado = "\nEl trabajador " + nombre + " " + AP + " " + AM +
                        "\nquien labora en " + departamento + " con " + antiguedad +
                        "\nrecibe 10 días de vacaciones.";
            } else if (antiguedad.equals("2 a 6 años de servicio")) {
                resultado = "\nEl trabajador " + nombre + " " + AP + " " + AM +
                        "\nquien labora en " + departamento + " con " + antiguedad +
                        "\nrecibe 20 días de vacaciones.";
            } else if (antiguedad.equals("7 años o más de servicio")) {
                resultado = "\nEl trabajador " + nombre + " " + AP + " " + AM +
                        "\nquien labora en " + departamento + " con " + antiguedad +
                        "\nrecibe 30 días de vacaciones.";
            }
        }

        return resultado;
    }
}
