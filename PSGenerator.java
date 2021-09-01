import java.awt.event.*;
import javax.swing.*;
class Frame {
   JFrame f;

   Frame(String name) {
      this.f = new JFrame(name);
      JButton b = this.addButton("Exit", 300, 300, 100, 30);
      b.addActionListener(
         e -> {
            f.dispose();
         });
      f.setSize(450, 400);
      f.setLayout(null);
      f.setVisible(true);
   }

   public JButton addButton(String bname, int x, int y, int w, int h) {
      JButton b = new JButton(bname);
      b.setBounds(x, y, w, h);
      f.add(b);
      return b;
   }

   public JTextField addTextField(int x, int y, int w, int h) {
      JTextField t = new JTextField(20);
      t.setBounds(x, y, w, h);
      f.add(t);
      return t;
   }

   public void addLabel(String lname, int x, int y, int w, int h) {
      JLabel l = new JLabel(lname);
      l.setBounds(x, y, w, h);
      f.add(l);
   }

   public JPasswordField addPasswordField(int x, int y, int w, int h) {
      JPasswordField v = new JPasswordField();
      v.setBounds(x, y, w, h);
      v.setEchoChar('*');
      f.add(v);
      return v;
   }

   public void addCheckBox(String name, int x, int y, int w, int h, JPasswordField v) {
      JCheckBox c = new JCheckBox(name);
      c.setBounds(x, y, w, h);
      c.addActionListener(
         new ActionListener() {
         
            public void actionPerformed(ActionEvent ae) {
               if (c.isSelected()) v.setEchoChar((char) 0);
               else
                  v.setEchoChar('*');
            }
         });
      f.add(c);
   }

   public JButton showImageIcon() {
      ImageIcon logo = new ImageIcon("psglogo.png");
      JButton lbutton = new JButton(logo);
      lbutton.setBounds(100, 50, 200, 200);
      f.add(lbutton);
      return lbutton;
   }
}

public class PSGenerator {
   public static void main(String[] args) {
      Frame o = new Frame("PaySlip Generator");
      JButton b1 = o.showImageIcon();
   
      b1.addActionListener(
         new ActionListener() {
         
            public void actionPerformed(ActionEvent ae) {
               Frame o = new Frame("PaySlip Generator");
               o.addLabel("Name:", 50, 50, 130, 30);
               JTextField nameTextField = o.addTextField(150, 50, 130, 30);
               o.addLabel("ID:", 50, 100, 130, 30);
               JTextField idTextField = o.addTextField(150, 100, 130, 30);
               o.addLabel("Password:", 50, 150, 130, 30);
               JPasswordField pwdField = o.addPasswordField(150, 150, 130, 30);
               o.addCheckBox("Show password", 300, 150, 130, 50, pwdField);
               JTextField pwdTextField = pwdField;
               JButton b2 = o.addButton("Submit", 250, 200, 150, 30);
               b2.addActionListener(
                  new ActionListener() {
                  
                     public void actionPerformed(ActionEvent ae) {
                        String name = nameTextField.getText();
                        String id = idTextField.getText();
                        String pwd = pwdTextField.getText();
                        if (!name.equals("") && !id.equals("") && !pwd.equals("")) {
                           Frame o = new Frame("PaySlip Generator");
                           o.addLabel("No. of days worked:", 50, 50, 130, 30);
                           JTextField dayTextField = o.addTextField(200, 50, 130, 30);
                           o.addLabel("Pay per day:", 50, 100, 130, 30);
                           JTextField paypdTextField = o.addTextField(200, 100, 130, 30);
                           o.addLabel("Add. working days:", 50, 150, 150, 30);
                           JTextField adworkdayTextField = o.addTextField(200, 150, 130, 30);
                           JButton b3 = o.addButton("Generate payslip", 250, 200, 150, 30);
                           b3.addActionListener(
                              new ActionListener() {
                              
                                 public void actionPerformed(ActionEvent ae) {
                                    if (!dayTextField.getText().equals("")
                                    && !paypdTextField.getText().equals("")
                                    && !adworkdayTextField.getText().equals("")) {
                                       Frame o = new Frame("Salary Slip");
                                       o.addLabel("NAME:       ", 50, 50, 130, 30);
                                       o.addLabel(name, 220, 50, 130, 30);
                                    
                                       o.addLabel("ID:         ", 50, 100, 130, 30);
                                       o.addLabel(id, 220, 100, 130, 30);
                                    
                                       float day = Float.parseFloat(dayTextField.getText());
                                       float pay = Float.parseFloat(paypdTextField.getText());
                                       float wday = Float.parseFloat(adworkdayTextField.getText());
                                       float sal = (day + wday) * pay;
                                       o.addLabel("NO OF DAYS: ", 50, 150, 130, 30);
                                       o.addLabel((day + wday) + "", 220, 150, 130, 30);
                                    
                                       o.addLabel("SALARY:     ", 50, 200, 130, 30);
                                       o.addLabel(sal + "", 220, 200, 130, 30);
                                    
                                    } else {
                                       Frame o = new Frame("Error");
                                       o.addLabel("PLEASE ENTER YOUR DETAILS", 100, 150, 230, 30);
                                    }
                                 
                                 }
                              });
                        } else {
                           Frame o = new Frame("Error");
                           o.addLabel("PLEASE ENTER YOUR DETAILS", 100, 150, 230, 30);
                        }
                     }
                  });
            }
         });
   }
}
