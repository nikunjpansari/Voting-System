import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class InvalidPasswordException extends Exception
{}

public class Login extends JFrame implements ActionListener
{
        JLabel name, pass;
        JTextField nameText;
        JPasswordField passText;
        JButton login, end;
        static int attempt=0;

        public Login()
        {
                name = new JLabel("Name:",JLabel.RIGHT);
                pass = new JLabel("Password:",JLabel.RIGHT);

                nameText = new JTextField(20);
                passText = new JPasswordField(20);

                login = new JButton("Login");
                end = new JButton("End");

                login.addActionListener(this);
                end.addActionListener(this);

                Container c = getContentPane();
                c.setLayout(new GridLayout(3,2));
                c.add(name);
                c.add(nameText);
                c.add(pass);
                c.add(passText);
                c.add(login);
                c.add(end);

                setTitle("Login Check");
                setSize(400,200);
                setLocation((800-400)/2,(600-165)/2);
                pack();
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setVisible(true);
        }

        public void actionPerformed(ActionEvent ae)
        {
                JButton btn = (JButton)ae.getSource();
                if(btn == end)
                {
                        System.exit(0);
                }
                if(btn == login)
                {
                        try
                        {
                                String user = nameText.getText();
                                String pass = new String(passText.getPassword());
                                if(user.compareTo(pass)==0)
                                {
                                        JOptionPane.showMessageDialog(null,"Login Successful","Login",JOptionPane.INFORMATION_MESSAGE);
                                        System.exit(0);
                                }
                                else
                                {
                                        throw new InvalidPasswordException();
                                }
                        }
                        catch(Exception e)
                        {
                                attempt++;
                                JOptionPane.showMessageDialog(null,"Login Failed","Login",JOptionPane.ERROR_MESSAGE);
                                nameText.setText("");
                                passText.setText("");
                                nameText.requestFocus();
                                if(attempt == 3)
                                {
                                        JOptionPane.showMessageDialog(null,"3 Attempts Over","Login",JOptionPane.ERROR_MESSAGE);
                                        System.exit(0);
                                }
                        }
                }                
        }

        public static void main(String args[])
        {
                new Login();
        }
}


