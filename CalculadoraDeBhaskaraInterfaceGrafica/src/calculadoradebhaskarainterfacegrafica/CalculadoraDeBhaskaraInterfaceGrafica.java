// Programa para calcular as raízes da equação quadrática usando a fórmula de Bhaskara
package calculadoradebhaskarainterfacegrafica;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalculadoraDeBhaskaraInterfaceGrafica extends JFrame {
    
    private JLabel titulo, rotuloA, rotuloB, rotuloC, x1, x2;
    private JTextField valA, valB, valC, valX1, valX2;
    private JButton calcular;

    public CalculadoraDeBhaskaraInterfaceGrafica () {
        super("Fórmula de Bhaskara");
        
        inicializarComponentes();
        configurarLayout();
        adicionarComponentes();
        adicionarEventos();
        
        setSize(400, 400);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void inicializarComponentes() {
        titulo = new JLabel("Fórmula de Bhaskara");
        rotuloA = new JLabel("Valor A:");
        rotuloB = new JLabel("Valor B:");
        rotuloC = new JLabel("Valor C:");
        
        valA = new JTextField(5);
        valB = new JTextField(5);
        valC = new JTextField(5);
        
        x1 = new JLabel("Valor de x':");
        x2 = new JLabel("Valor de x'':");
        
        valX1 = new JTextField(5);
        valX2 = new JTextField(5);
        
        calcular = new JButton("Calcular");
    }

    private void configurarLayout() {
        Container tela = getContentPane();
        tela.setLayout(null);
        tela.setBackground(new Color(215, 215, 200));
        
        titulo.setBounds(50, 10, 150, 30);
        rotuloA.setBounds(20, 50, 80, 30);
        rotuloB.setBounds(20, 90, 80, 30);
        rotuloC.setBounds(20, 130, 80, 30);
        
        valA.setBounds(100, 55, 60, 25);
        valB.setBounds(100, 95, 60, 25);
        valC.setBounds(100, 135, 60, 25);
        
        x1.setBounds(20, 180, 100, 30);
        x2.setBounds(20, 220, 100, 30);
        
        valX1.setBounds(120, 185, 60, 25);
        valX2.setBounds(120, 225, 60, 25);
        
        calcular.setBounds(250, 200, 90, 30);
    }

    private void adicionarComponentes() {
        Container tela = getContentPane();
        
        tela.add(titulo);
        tela.add(rotuloA);
        tela.add(rotuloB);
        tela.add(rotuloC);
        tela.add(valA);
        tela.add(valB);
        tela.add(valC);
        tela.add(calcular);
        tela.add(x1);
        tela.add(x2);
        tela.add(valX1);
        tela.add(valX2);
    }

    private void adicionarEventos() {
        calcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularBhaskara();
            }
        });
    }

    private void calcularBhaskara() {
        try {
            double a = Double.parseDouble(valA.getText());
            double b = Double.parseDouble(valB.getText());
            double c = Double.parseDouble(valC.getText());

            double delta = Math.pow(b, 2) - 4 * a * c;

            if (delta >= 0) {
                double raizDelta = Math.sqrt(delta);
                double formX1 = (-b + raizDelta) / (2 * a);
                double formX2 = (-b - raizDelta) / (2 * a);

                valX1.setText(String.valueOf(formX1));
                valX2.setText(String.valueOf(formX2));
            } else {
                valX1.setText("N/A");
                valX2.setText("N/A");
                JOptionPane.showMessageDialog(this, "Delta negativo! Raízes imaginárias.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira valores numéricos válidos.", "Erro de entrada", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        CalculadoraDeBhaskaraInterfaceGrafica app = new CalculadoraDeBhaskaraInterfaceGrafica();
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
