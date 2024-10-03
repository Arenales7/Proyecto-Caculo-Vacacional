import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bienvenida extends JFrame implements ActionListener {

  private JTextField textfield1;
  private JLabel label1, label2, label3, label4;
  private JButton boton1;
  public static String texto = "";

  public Bienvenida() {
    setLayout(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle("Bienvenido a la Dulcería");
    getContentPane().setBackground(new Color(64, 224, 208));  // Color celeste
        
    
    
    

    // Logo de la dulcería
    ImageIcon imagen = new ImageIcon("C:\\Users\\USER\\Documents\\NetBeansProjects\\Proyecto_Sistema\\Proyecto_Sistema\\imagenes\\dulces.jpg");
    label1 = new JLabel(imagen);
    label1.setBounds(100, 20, 200, 200);  // Imagen 
    add(label1);

    // Título
    label2 = new JLabel("¡Bienvenido a la Dulceria!");
    label2.setBounds(70, 220, 400, 40);  
    label2.setFont(new Font("Comic Sans MS", 3, 22));  // Fuente
    label2.setForeground(new Color(255, 105, 180));  // Color rosa
    add(label2);

    // Subtítulo
    label3 = new JLabel("Ingrese su nombre para continuar:");
    label3.setBounds(70, 270, 300, 30);
    label3.setFont(new Font("Comic Sans MS", 1, 16));  // Fuente mediana
    label3.setForeground(new Color(255, 255, 255));
    add(label3);
    
    
    
    
    
    
    

    // Campo de texto
    textfield1 = new JTextField();
    textfield1.setBounds(70, 310, 250, 35);
    textfield1.setBackground(new Color(255, 239, 213));  // Fondo 
    textfield1.setFont(new Font("Comic Sans MS", 1, 18));
    textfield1.setForeground(new Color(219, 112, 147));  
    add(textfield1);

    // Botón de ingresar
    boton1 = new JButton("Ingresar");
    boton1.setBounds(130, 360, 150, 40);  
    boton1.setBackground(new Color(255, 182, 193));  
    boton1.setFont(new Font("Comic Sans MS", 1, 18));
    boton1.setForeground(new Color(255, 255, 255));  
    boton1.addActionListener(this);
    add(boton1);

    // Pie de página
    label4 = new JLabel("Dulceria de Ensueño, David Arenales, Programacion II, D");
    label4.setBounds(20, 420, 300, 20);
    label4.setFont(new Font("Andale Mono", 1, 12));
    label4.setForeground(new Color(000000));
    add(label4);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == boton1) {
      texto = textfield1.getText().trim();

      if (texto.equals("")) {
        JOptionPane.showMessageDialog(null, "Debes ingresar tu nombre.");
      } else {
        JOptionPane.showMessageDialog(null, "Bienvenido, " + texto + " a la Dulcería de Ensueño");
        // Abrir ventana para 
        Licencia ventanalicencia = new Licencia();
        ventanalicencia.setBounds(0, 0, 600, 360);
        ventanalicencia.setVisible(true);
        ventanalicencia.setResizable(false);
        ventanalicencia.setLocationRelativeTo(null);
        this.setVisible(false);
      }
    }
  }

  public static void main(String args[]) {
    Bienvenida ventanabienvenida = new Bienvenida();
    ventanabienvenida.setBounds(0, 0, 400, 500);  
    ventanabienvenida.setVisible(true);
    ventanabienvenida.setResizable(false);
    ventanabienvenida.setLocationRelativeTo(null);
  }
}

