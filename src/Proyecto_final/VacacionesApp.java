import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class VacacionesApp {
    private JFrame frame; // ventana principal de la aplicación
    private JPanel bienvenidaPanel, principalPanel, terminosPanel; // paneles para la interfaz
    private JTextField nombreField; // campo de texto donde el usuario podrá ingresar texto
    private JComboBox<String> departamentoBox, antiguedadBox; // comboBox para seleccionar departamentos y antigüedad
    private JLabel resultadoLabel; // etiqueta para mostrar resultados

    // Constructor
    public VacacionesApp() {
        prepararVentana();
        mostrarBienvenida();
    }

    private void prepararVentana() {
        frame = new JFrame(" Iximche´");
        frame.setSize(1000, 800);//tamaño de ventana, el primero es en x 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//cierra el programa
        frame.setLocationRelativeTo(null); // centrar la pantalla al abrirse

        // Cargar la imagen del ícono y establecerla en la ventana
        try {
            Image icono = ImageIO.read(new File("imagenes/logo.png")); // Icono
            frame.setIconImage(icono);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Pantalla de bienvenida
    private void mostrarBienvenida() {
        bienvenidaPanel = new JPanel();
        bienvenidaPanel.setLayout(new BoxLayout(bienvenidaPanel, BoxLayout.Y_AXIS)); // Disposición en columna
        bienvenidaPanel.setBackground(Color.gray); // Fondo gris

        // logo
        ImageIcon originalLogo = new ImageIcon("imagenes/logo.png");//misma ruta de archivo
        Image logoImage = originalLogo.getImage().getScaledInstance(1200, 250, Image.SCALE_SMOOTH);//escala del logo
        ImageIcon scaledLogo = new ImageIcon(logoImage);
        JLabel logoLabel = new JLabel(scaledLogo);
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar el logo

        JLabel tituloLabel = new JLabel("Cervecería IXIMCHE´", SwingConstants.CENTER);//titulo inicial 
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 70));
        tituloLabel.setForeground(Color.BLACK);
        tituloLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar el título

        JLabel nombreLabel = new JLabel("Ingrese su nombre:");
        nombreLabel.setFont(new Font("Arial", Font.PLAIN, 40));
        nombreLabel.setForeground(Color.black);
        nombreLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar el texto

        nombreField = new JTextField(15); // Establecer tamaño del cuadro de texto a 15 columnas
        nombreField.setFont(new Font("Arial", Font.PLAIN, 30)); // Ajustar la fuente y el tamaño
        nombreField.setMaximumSize(new Dimension(300, 30)); // Limitar el tamaño del cuadro de texto
        nombreField.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar el cuadro de texto

        JButton continuarButton = new JButton("Ingresar");
        continuarButton.setFont(new Font("Arial", Font.PLAIN, 20)); // Cambiar la fuente y el tamaño
        continuarButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar el botón
        continuarButton.addActionListener((ActionEvent e) -> {
            if (!nombreField.getText().isEmpty()) {
                mostrarTerminosCondiciones();
            } else {
                JOptionPane.showMessageDialog(frame, "Por favor, ingrese su nombre.");
            }
        });

        JLabel footerLabel = new JLabel("©IXIMCHE´ DESDE LA MANSIÓN DE LOS DIOSES");
        footerLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        footerLabel.setForeground(Color.black);
        footerLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar el footer

        // Agregar componentes al panel
        bienvenidaPanel.add(Box.createVerticalStrut(50)); // Espaciador para mover los elementos hacia abajo
        bienvenidaPanel.add(logoLabel); // Añadir logo
        bienvenidaPanel.add(Box.createVerticalStrut(20)); // Espacio entre logo y título
        bienvenidaPanel.add(tituloLabel); // Añadir título
        bienvenidaPanel.add(Box.createVerticalStrut(20)); // Espacio entre título y nombre
        bienvenidaPanel.add(nombreLabel); // Añadir etiqueta de nombre
        bienvenidaPanel.add(Box.createVerticalStrut(10)); // Espacio antes del campo de texto
        bienvenidaPanel.add(nombreField); // Añadir campo de texto
        bienvenidaPanel.add(Box.createVerticalStrut(20)); // Espacio antes del botón
        bienvenidaPanel.add(continuarButton); // Añadir botón
        bienvenidaPanel.add(Box.createVerticalStrut(50)); // Espacio antes del texto de pie
        bienvenidaPanel.add(footerLabel); // Añadir footer

        frame.add(bienvenidaPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    // Pantalla de Términos y Condiciones
    private void mostrarTerminosCondiciones() {
        frame.remove(bienvenidaPanel);

        terminosPanel = new JPanel();
        terminosPanel.setLayout(new BoxLayout(terminosPanel, BoxLayout.Y_AXIS)); // Disposición en columna
        terminosPanel.setBackground(Color.lightGray); // Fondo gris claro

        // Usar JLabel con HTML para mostrar el texto en múltiples líneas
        JLabel terminosLabel = new JLabel("<html><div style='text-align: center;'>Términos y Condiciones<br><br>"
                +/*este signo debe ir*/ "Bienvenido a Cervecería IXIMCHE´. Estos términos regulan el cálculo vacacional.<br><br>"
                + "Se puede saber cuánto le corresponde a cada empleado según su plaza y tiempo dentro de la empresa.<br><br>"
                + "El uso del sitio web de IXIMCHE´ es para mayores de 18 años.<br><br>"
                + "Todos los productos ofrecidos en IXIMCHE´ son de consumo exclusivo para mayores de edad.<br><br>"
                + "Al realizar un pedido, aceptas que todos los detalles proporcionados son exactos.<br><br>"
                + "Para cualquier duda o consulta, puede visitarnos en nuestro perfil de Instagram:<br>"
                + "QUEDA BAJO SU ESTRICTA RESPONSABILIDAD<br>"
                + "<a href='https://www.instagram.com/iximchela'>https://www.instagram.com</a>"
                + "</div></html>", SwingConstants.CENTER);

        terminosLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        terminosLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar el JLabel

        // Aceptar Checkbox
        JCheckBox aceptarCheckBox = new JCheckBox("Acepto los Términos y Condiciones");
        aceptarCheckBox.setFont(new Font("Arial", Font.PLAIN, 20));
        aceptarCheckBox.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar el checkbox

        // Botón para continuar
        JButton continuarButton = new JButton("Continuar");
        continuarButton.setFont(new Font("Arial", Font.PLAIN, 20)); // Cambiar la fuente y el tamaño
        continuarButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar el botón
        continuarButton.addActionListener((ActionEvent e) -> {
            if (aceptarCheckBox.isSelected()) {
                mostrarPantallaPrincipal();
            } else {
                JOptionPane.showMessageDialog(frame, "Debe aceptar los términos y condiciones para continuar.");
            }
        });

        // Agregar componentes al panel
        terminosPanel.add(Box.createVerticalStrut(30)); // Espaciador para mover los elementos hacia abajo
        terminosPanel.add(terminosLabel); // Añadir el JLabel con los términos
        terminosPanel.add(Box.createVerticalStrut(20)); // Espacio antes del checkbox
        terminosPanel.add(aceptarCheckBox); // Añadir el checkbox
        terminosPanel.add(Box.createVerticalStrut(20)); // Espacio antes del botón
        terminosPanel.add(continuarButton); // Añadir el botón

        frame.add(terminosPanel, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }

    // Pantalla principal con cálculo de vacaciones
    private void mostrarPantallaPrincipal() {
        frame.remove(terminosPanel);

        principalPanel = new JPanel();
        principalPanel.setLayout(new GridLayout(11, 2, 10, 10)); // Cambié a 11 filas para acomodar el botón adicional
        principalPanel.setBackground(Color.gray); // Fondo inicial

        JLabel bienvenidoLabel = new JLabel("Bienvenido " + nombreField.getText(), SwingConstants.CENTER);
        bienvenidoLabel.setFont(new Font("Arial", Font.BOLD, 40));
        bienvenidoLabel.setForeground(Color.black);

        JLabel nombreLabel = new JLabel("Nombre completo:");
        nombreLabel.setFont(new Font("Arial", Font.PLAIN, 20)); // Cambiar la fuente y el tamaño
        JTextField nombreCompletoField = new JTextField();
        nombreCompletoField.setFont(new Font("Arial", Font.PLAIN, 20)); // Cambiar la fuente y el tamaño
        JLabel apellidoPaternoLabel = new JLabel("Apellido Paterno:");
        apellidoPaternoLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        JTextField apellidoPaternoField = new JTextField();
        apellidoPaternoField.setFont(new Font("Arial", Font.PLAIN, 20));
        JLabel apellidoMaternoLabel = new JLabel("Apellido Materno:");
        apellidoMaternoLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        JTextField apellidoMaternoField = new JTextField();
        apellidoMaternoField.setFont(new Font("Arial", Font.PLAIN, 20));
        JLabel departamentoLabel = new JLabel("Selecciona el Departamento:");
        departamentoLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        departamentoBox = new JComboBox<>(new String[]{"Atención al cliente", "Logística", "Gerente", /*"Embasador"*/});
        departamentoBox.setFont(new Font("Arial", Font.PLAIN, 18)); // Cambiar la fuente y el tamaño
        JLabel antiguedadLabel = new JLabel("Selecciona la Antigüedad:");
        antiguedadLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        antiguedadBox = new JComboBox<>(new String[]{"1", "2", "3", "4", "5", "6", "7+"});
        antiguedadBox.setFont(new Font("Arial", Font.PLAIN, 20));
        JLabel resultadoLabelTexto = new JLabel("Resultado del Cálculo:");
        resultadoLabelTexto.setFont(new Font("Arial", Font.PLAIN, 20)); // Ajustar la fuente y el tamaño
        resultadoLabel = new JLabel("Aquí aparece el resultado del cálculo de las vacaciones.", SwingConstants.CENTER);
        resultadoLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        resultadoLabel.setOpaque(true);
        resultadoLabel.setBackground(Color.LIGHT_GRAY);
        resultadoLabel.setForeground(Color.RED);

        JButton calcularButton = new JButton("Calcular");
        calcularButton.addActionListener(e -> {
            String departamento = (String) departamentoBox.getSelectedItem();
            String antiguedadSeleccionada = (String) antiguedadBox.getSelectedItem();

            int antiguedad = antiguedadSeleccionada.equals("7+") ? 7 : Integer.parseInt(antiguedadSeleccionada);
            int vacaciones = calcularVacaciones(departamento, antiguedad);
            resultadoLabel.setText("Días de vacaciones: " + vacaciones);
        });

        // Botón para mostrar información del creador
        JButton infoCreadorButton = new JButton("Información del Creador");
        infoCreadorButton.setFont(new Font("Arial", Font.PLAIN, 20));
        infoCreadorButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Creado por: Nilton Chonay \nVersión: 1.0\nContacto: niltonchonay.9@gmail.com", 
            "Información del Creador", JOptionPane.INFORMATION_MESSAGE);
        });

        principalPanel.add(bienvenidoLabel);
        principalPanel.add(new JLabel("")); // Espacio en blanco
        principalPanel.add(nombreLabel);
        principalPanel.add(nombreCompletoField);
        principalPanel.add(apellidoPaternoLabel);
        principalPanel.add(apellidoPaternoField);
        principalPanel.add(apellidoMaternoLabel);
        principalPanel.add(apellidoMaternoField);
        principalPanel.add(departamentoLabel);
        principalPanel.add(departamentoBox);
        principalPanel.add(antiguedadLabel);
        principalPanel.add(antiguedadBox);
        principalPanel.add(resultadoLabelTexto);
        principalPanel.add(resultadoLabel);
        principalPanel.add(calcularButton);

        // Agregar el botón de información del creador
        principalPanel.add(infoCreadorButton);

        JLabel footerLabel = new JLabel("©IXIMCHE´|NILTON CHONAY  PII", SwingConstants.CENTER);
        footerLabel.setForeground(Color.black);
        footerLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        principalPanel.add(footerLabel);

        frame.add(principalPanel, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }

    // Calcular vacaciones basado en el departamento y la antigüedad
    public int calcularVacaciones(String departamento, int antiguedad) {
        int diasVacaciones = 0;
        if (antiguedad < 1) {
            System.out.println("La antigüedad debe ser al menos 1 año.");//debe ser mayoy a un año
            return diasVacaciones;//de lo contraio no se tiene vacaciones
        }
        switch (departamento) {
            case "Atención al cliente"://puestos laborales
                if (antiguedad == 1) diasVacaciones = 6;//acá se cambian los intervalos 
                else if (antiguedad >= 2 && antiguedad <= 6) diasVacaciones = 14;
                else if (antiguedad >= 7) diasVacaciones = 20;
                break;
            case "Logística":
                if (antiguedad == 1) diasVacaciones = 7;
                else if (antiguedad >= 2 && antiguedad <= 6) diasVacaciones = 15;
                else if (antiguedad >= 7) diasVacaciones = 22;//tiempo de vacaciones 
                break;
            case "Gerente":
                if (antiguedad == 1) diasVacaciones = 10;
                else if (antiguedad >= 2 && antiguedad <= 6) diasVacaciones = 20;
                else if (antiguedad >= 7) diasVacaciones = 30;
                break;
            /* case "Embasador":
                if (antiguedad == 1) diasVacaciones = 10;
                else if (antiguedad >= 2 && antiguedad <= 6) diasVacaciones = 20;
                else if (antiguedad >= 7) diasVacaciones = 50;
                break;*/
            default:
                System.out.println("Departamento no reconocido.");
                break;
        }
        return diasVacaciones;
        
    }

    // Método main para ejecutar la aplicación
    public static void main(String[] args) {
        new VacacionesApp();
    }
}
