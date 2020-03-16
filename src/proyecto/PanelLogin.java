package proyecto;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelLogin extends Panel implements ActionListener, FocusListener, KeyListener{

	private Jota jota=new Jota();
	private JTextField correo=new JTextField("E-mail");
	private JTextField contra=new JTextField("Password");
	private JButton submit;
	private JButton fpass;
	private JButton cuser;
	private Image imagen;
	private Font font=new Font("Helvetica", Font.BOLD, 13);
	private String mail;
	private String password;
	private Student suser;
	private int countc=0;
	private int countp=0;

  public PanelLogin(){
	  super();
	  this.setLayout(null);
	  this.createButtons();
	  correo.addFocusListener(this);
	  correo.setBounds(getWidthLog()+148, getHeightLog()+85, 180, 20);
	  contra.addFocusListener(this);
	  contra.setBounds(getWidthLog()+148, getHeightLog()+145, 180, 20);
	  submit.addActionListener(this);
	  submit.addKeyListener(this);
	  submit.setBounds(getWidthLog()+190, getHeightLog()+175, 100, 30);
	  fpass.setBounds(getWidthLog()+70, getHeightLog()+220, 140, 20);
	  cuser.addActionListener(this);
	  cuser.setBounds(getWidthLog()+270, getHeightLog()+220, 140, 20);
	  this.add(correo);
	  this.add(contra);
	  this.add(submit);
	  this.add(fpass);
	  this.add(cuser);
  }

  public void paintComponent(Graphics g){
	  super.paintComponent(g);
	  Image imagen2;//Chequear si esto es realment necesario y si no lo es borrarlo
	  Graphics2D gr=(Graphics2D) g;
	  imagen=jota.getImage("space");
	  gr.drawImage(imagen, 0, 0, getWidthLogin(), getHeightLogin(), this);
	  //gr.drawImage(imagen2, 0, 0, this);
	  gr.setColor(Color.BLACK);
	  gr.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
	  gr.fillRect(getWidthLog(), getHeightLog(), (getWidthLogin())/2, (getHeightLogin()/2));
	  System.out.println("correo.addFocusListener(this)");
	  System.out.println("contra.addFocusListener(this)");
	  gr.setFont(font);//ACA TENGO QUE AGREGAR LA FUENTE
	  gr.setColor(Color.WHITE);
	  gr.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));
	  gr.drawString("Ingrese su correo", getWidthLog()+155, getHeightLog()+80);
	  gr.drawString("Ingrese su contraseña", getWidthLog()+135, getHeightLog()+140);
	  gr.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
  }

  private void createButtons() {
		//Creando Submit
		submit=new JButton("Submit");
		submit.setForeground(Color.WHITE);
		submit.setFont(font);
		submit.setBackground(Color.DARK_GRAY);
		//Creando Forgot
		fpass=new JButton("Forgot Password");
		fpass.setFont(font);
		fpass.setForeground(Color.white);
		fpass.setBackground(null);
		fpass.setBorderPainted(false);
		fpass.setContentAreaFilled(false);
		//Creando Create User
		cuser=new JButton("Create Account");
		cuser.setFont(font);
		cuser.setForeground(Color.white);
		cuser.setBorderPainted(false);
		cuser.setContentAreaFilled(false);
  }

  @Override
  public void focusGained(FocusEvent e) {
    // TODO Auto-generated method stub
	  if(e.getSource()==correo) {
		  if(countc==0) {
			  correo.setText(""); 
			  countc++;
		  }
	  }else if(e.getSource()==contra) {
		  if(countp==0) {
			  contra.setText("");
			  countp++;
		  }
	  }
  }

  @Override
  public void focusLost(FocusEvent e) {
    // TODO Auto-generated method stub
    if(e.getSource()==correo){
      mail=correo.getText();
    }else if(e.getSource()==contra){
      password=contra.getText();
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    if(e.getSource()==submit) {
    	Frame dashboard=new Frame();
        dashboard.setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);
        Main.marco.setDefaultCloseOperation(Frame.DISPOSE_ON_CLOSE);
        Main.marco.closeFrame();
      /*if(jota.login(mail)){
        suser=jota.getAccountInfo(mail);
        Frame dashboard=new Frame();
        dashboard.setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);
        Main.marco.setDefaultCloseOperation(Frame.DISPOSE_ON_CLOSE);
        Main.marco.closeFrame();
      }else{
        System.out.println("El correo es invalido");
      }*/
    }else if(e.getSource()==cuser) {
      Frame marco_create_user=new Frame(1,2);
      marco_create_user.setDefaultCloseOperation(Frame.DISPOSE_ON_CLOSE);
    }else if(e.getSource()==fpass){
      System.out.println("Aca ira el codigo para Forgot Password");
    }
  }

  @Override
  public void keyPressed(KeyEvent arg0) {
  	// TODO Auto-generated method stub
  	
  }

  @Override
  public void keyReleased(KeyEvent arg0) {
  	// TODO Auto-generated method stub
  	
  }

  @Override
  public void keyTyped(KeyEvent e) {
  	// TODO Auto-generated method stub
	  if(e.getSource()==submit) {
		  Frame dashboard=new Frame();
	      dashboard.setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);
	      Main.marco.setDefaultCloseOperation(Frame.DISPOSE_ON_CLOSE);
	      Main.marco.closeFrame();
	      /*if(jota.login(mail)){
	        suser=jota.getAccountInfo(mail);
	        Frame dashboard=new Frame();
	        dashboard.setDefaultCloseOperation(Frame.EXIT_ON_CLOSE);
	        Main.marco.setDefaultCloseOperation(Frame.DISPOSE_ON_CLOSE);
	        Main.marco.closeFrame();
	      }else{
	        System.out.println("El correo es invalido");
	      }*/
	    }
  }

}
