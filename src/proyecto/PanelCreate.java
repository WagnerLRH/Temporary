package proyecto;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JButton;
import javax.swing.JTextField;

public class PanelCreate extends Panel implements ActionListener, FocusListener{

  private JTextField correo=new JTextField("E-mail");
  private JTextField contra=new JTextField("Password");
  private JTextField name=new JTextField("Nombre");
  private JTextField lastname=new JTextField("Apellido");
  private JTextField user=new JTextField("Username");
  private JButton submit;
  private Image imagen;
  private String mail;
  private String password;
  private String nombre;
  private String apellido;
  private String usuario;
  private Jota jota=new Jota();

  public PanelCreate(){
    //FIX THE BOUNDS OF THE FOLLOWING
    super();
    setLayout(null);
    createButtons();
	correo.addFocusListener(this);
	correo.setBounds(getWidthLog()-10, getHeightLog()+30, 180, 25);
	contra.addFocusListener(this);
	contra.setBounds(getWidthLog()-10, getHeightLog()+65, 180, 25);
    name.addFocusListener(this);
    name.setBounds(getWidthLog()-10, getHeightLog()+100, 180, 25);
    lastname.addFocusListener(this);
    lastname.setBounds(getWidthLog()-10, getHeightLog()+135, 180, 25);
    user.addFocusListener(this);
    user.setBounds(getWidthLog()-10, getHeightLog()+170, 180, 25);
	submit.addActionListener(this);
	submit.setBounds((getWidthLog()+38)-10, getHeightLog()+210, 100, 30);
	this.add(correo);
	this.add(contra);
    this.add(name);
    this.add(lastname);
    this.add(user);
    this.add(submit);
  }

  public void paintComponent(Graphics g){
    super.paintComponent(g);
    Image imagen2;
    Graphics2D gr=(Graphics2D) g;
    imagen=jota.getImage("rocket");
    gr.drawImage(imagen, 0, 0, getWidthLogin()/2, getHeightLogin(), this);
    //gr.drawImage(imagen2, 0, 0, this);
    System.out.println("correo.addFocusListener(this)");
    gr.setColor(Color.BLACK);
    gr.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
    gr.fillRect(getWidthLog()-210, getHeightLog()-30, 400, 350);
    gr.setFont(new Font("Helvetica", Font.BOLD, 18));
    gr.setColor(Color.WHITE);
    gr.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.9f));
    gr.drawString("Ingrese su informacion de usuario", getWidthLog()-160, getHeightLog()+10);
    gr.setFont(new Font("Helvetica", Font.BOLD, 15));
    gr.drawString("Todos los campos son obligatorios*", getWidthLog()-140, getHeightLog()+270);
    gr.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
  }

  private void createButtons() {
    //Creando Submit
    submit=new JButton("Submit");
    submit.setForeground(Color.WHITE);
    submit.setFont(new Font("Helvetica", Font.BOLD, 15));
    submit.setBackground(Color.DARK_GRAY);
  }

  @Override
  public void focusGained(FocusEvent e) {
    // TODO Auto-generated method stub
	    if(e.getSource()==correo){
	        correo.setText("");
	      }else if(e.getSource()==contra){
	        contra.setText("");
	      }else if(e.getSource()==name){
	        name.setText("");
	      }else if(e.getSource()==lastname){
	        lastname.setText("");
	      }else if(e.getSource()==user){
	        user.setText("");
	      }
  }

  @Override
  public void focusLost(FocusEvent e) {
    // TODO Auto-generated method stub
    if(e.getSource()==correo){
      mail=correo.getText();
    }else if(e.getSource()==contra){
      password=contra.getText();
    }else if(e.getSource()==name){
      nombre=name.getText();
    }else if(e.getSource()==lastname){
      apellido=lastname.getText();
    }else if(e.getSource()==user){
      usuario=user.getText();
    }
  }

  public void actionPerformed(ActionEvent e){
    jota.saveCorreo(mail);
		jota.saveContra(password);
		jota.saveName(nombre);
		jota.saveLastName(apellido);
		jota.saveUser(usuario);
		jota.createUser();
  }

}
