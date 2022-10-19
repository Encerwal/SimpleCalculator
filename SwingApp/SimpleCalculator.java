import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator extends JFrame
{
   JLabel operandOneLabel = new JLabel();
   JLabel operandTwoLabel = new JLabel();
   JLabel operatorLabel = new JLabel();
   JLabel resultLabel = new JLabel();
   
   JTextField operandOneTextField = new JTextField();
   JTextField operandTwoTextField = new JTextField();
   JTextField operatorTextField = new JTextField();
   JTextField resultTextField = new JTextField();
   
   JButton calculateButton = new JButton();
   JButton exitButton = new JButton();
   
   public SimpleCalculator()
   {
       //when closing the window
       addWindowListener(new WindowAdapter(){
           public void windowClosing(WindowEvent e){
               closeWindow(e);
           }
       });
       
       //when pressing the calculate button
       calculateButton.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               calculateButtonActionPerformed(e);
           }
       });
       
       //when pressing the exit button
       exitButton.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               exitButtonActionPerformed(e);
           }
       });
       
       setTitle("Simple Calculator");
       setSize(250, 200);
       
       getContentPane().setLayout(new GridBagLayout());
       GridBagConstraints gridConstraints = new GridBagConstraints();
       
       operandOneLabel.setText("Operand 1:      ");
       gridConstraints.gridx = 0;
       gridConstraints.gridy = 0;
       getContentPane().add(operandOneLabel, gridConstraints);
       
       operatorLabel.setText("Operator:        ");
       gridConstraints.gridx = 0;
       gridConstraints.gridy = 1;
       getContentPane().add(operatorLabel, gridConstraints);
       
       operandTwoLabel.setText("Operand 2:      ");
       gridConstraints.gridx = 0;
       gridConstraints.gridy = 2;
       getContentPane().add(operandTwoLabel, gridConstraints);
       
       resultLabel.setText("Result:             ");
       gridConstraints.gridx = 0;
       gridConstraints.gridy = 3;
       getContentPane().add(resultLabel, gridConstraints);
       
       calculateButton.setText("Calculate");
       gridConstraints.gridx = 0;
       gridConstraints.gridy = 4;
       getContentPane().add(calculateButton, gridConstraints);
       
       operandOneTextField.setText("");
       operandOneTextField.setColumns(5);
       gridConstraints.gridx = 1;
       gridConstraints.gridy = 0;
       getContentPane().add(operandOneTextField, gridConstraints);
       
       operatorTextField.setText("");
       operatorTextField.setColumns(3);
       gridConstraints.gridx = 1;
       gridConstraints.gridy = 1;
       getContentPane().add(operatorTextField, gridConstraints);
       
       operandTwoTextField.setText("");
       operandTwoTextField.setColumns(5);
       gridConstraints.gridx = 1;
       gridConstraints.gridy = 2;
       getContentPane().add(operandTwoTextField, gridConstraints);
       
       resultTextField.setText("");
       resultTextField.setColumns(5);
       gridConstraints.gridx = 1;
       gridConstraints.gridy = 3;
       getContentPane().add(resultTextField, gridConstraints);

       exitButton.setText("Exit");
       gridConstraints.gridx = 1;
       gridConstraints.gridy = 4;
       getContentPane().add(exitButton, gridConstraints);
       
              
   }
   
   private void closeWindow(WindowEvent e){
       JFrame action = new JFrame();
       JOptionPane.showMessageDialog(action, "Exitting Application..");
   }
   
   private void calculateButtonActionPerformed(ActionEvent e){
       double result, opOneValue, opTwoValue;
       JFrame action = new JFrame();
       
       result = 0;
       String operandOne = operandOneTextField.getText();
       String operandTwo = operandTwoTextField.getText();
       String operator = operatorTextField.getText();
       
       opOneValue = Double.parseDouble(operandOne);
       opTwoValue = Double.parseDouble(operandTwo);
       
       if (operator.equals("+"))
           result = opOneValue + opTwoValue;
       else if(operator.equals("-"))
           result = opOneValue - opTwoValue;
       else if(operator.equals("/"))
           result = opOneValue / opTwoValue;
       else if(operator.equals("*"))
           result = opOneValue * opTwoValue;
       else
           JOptionPane.showMessageDialog(action, "Invalid Operator!");
    
       String resultValue = String.valueOf(result);       
       resultTextField.setText(resultValue);
       
       
   }
   
   private void exitButtonActionPerformed(ActionEvent e){
       JFrame action = new JFrame();
       JOptionPane.showMessageDialog(action, "Exitting Application..");
       setVisible(false);
       
   }
   
   public static void main(String[] args)
   {
       new SimpleCalculator().show();
   }
}
