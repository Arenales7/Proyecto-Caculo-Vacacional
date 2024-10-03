import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.Scanner;

public class Licencia extends JFrame implements ActionListener, ChangeListener {

    private JLabel label1, label2;
    private JCheckBox check1;
    private JButton boton1, boton2;
    private JScrollPane scrollpane1; 
    private JTextArea textarea1;
    String nombre = "";

    public Licencia() {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Licencia de uso");
getContentPane().setBackground(new Color(64, 224, 208));
        // la clase Bienvenida
        Bienvenida ventanaBienvenida = new Bienvenida();
        nombre = ventanaBienvenida.texto;

        // Ingresar nombre
        if (nombre.isEmpty()) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Por favor, ingresa tu nombre: ");
            nombre = scanner.nextLine();
            scanner.close(); // Cerrar el scanner después de su uso
        }

        // Título
        label1 = new JLabel("TÉRMINOS Y CONDICIONES");
        label1.setBounds(150, 5, 400, 30);
        label1.setFont(new Font("Comic Sans MS", 1, 22));  
        label1.setForeground(new Color(255, 105, 180));  // Color rosa
        add(label1);

        // Texto de terminos y condiciones
        textarea1 = new JTextArea();
        textarea1.setEditable(false);
        textarea1.setFont(new Font("Comic Sans MS", 0, 14));   
        textarea1.setText("Al utilizar este software, aceptas cumplir con los siguientes Términos y Condiciones." 
                + " Si no estás de acuerdo con estos términos, no debes utilizar la aplicación.");
        textarea1.setBackground(new Color(255, 239, 213));  //Fondo
        scrollpane1 = new JScrollPane(textarea1);
        scrollpane1.setBounds(10, 50, 575, 200);
        add(scrollpane1);   

        // Aceptar terminos
        check1 = new JCheckBox("Yo " + nombre + " acepto los términos y condiciones");
        check1.setBounds(10, 250, 300, 30);
        check1.setFont(new Font("Comic Sans MS", 1, 10));  
        check1.setForeground(new Color(255, 105, 180));  // Color rosa
        check1.addChangeListener(this);
        add(check1);

        // Botón "Continuar"
        boton1 = new JButton("Continuar");
        boton1.setBounds(10, 290, 150, 25);
        boton1.setBackground(new Color(255, 182, 193));  // Color rosa 
        boton1.setFont(new Font("Comic Sans MS", 2, 16));
        boton1.setForeground(new Color(255, 255, 255));  // Texto blanco
        boton1.addActionListener(this);
        boton1.setEnabled(false);
        add(boton1);

        // Botón "No Acepto"
        boton2 = new JButton("No Acepto");
        boton2.setBounds(180, 290, 150, 25);
        boton2.setBackground(new Color(255, 182, 193));  // Color rosa 
        boton2.setFont(new Font("Comic Sans MS", 1, 16));
        boton2.setForeground(new Color(255, 255, 255));  // Texto blanco
        boton2.addActionListener(this);
        boton2.setEnabled(true);
        add(boton2);

       
   }
       
    
  
    public void stateChanged(ChangeEvent e) {
        boton1.setEnabled(check1.isSelected());
        boton2.setEnabled(!check1.isSelected());
    } 

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton1) {
            Principal ventanaPrincipal = new Principal();
            ventanaPrincipal.setBounds(0, 0, 640, 535);
            ventanaPrincipal.setVisible(true);
            ventanaPrincipal.setResizable(false);
            ventanaPrincipal.setLocationRelativeTo(null);
            this.setVisible(false);
        } else if (e.getSource() == boton2) {
            Bienvenida ventanabienvenida = new Bienvenida();
            ventanabienvenida.setBounds(0, 0, 400, 500);
            ventanabienvenida.setVisible(true);
            ventanabienvenida.setResizable(false);
            ventanabienvenida.setLocationRelativeTo(null);
            this.setVisible(false);   
        } 
    }

    public static void main(String args[]) {
        Licencia ventanalicencia = new Licencia();
        ventanalicencia.setBounds(0, 0, 600, 450);  
        ventanalicencia.setVisible(true);
        ventanalicencia.setResizable(false);
        ventanalicencia.setLocationRelativeTo(null);
    }
}
