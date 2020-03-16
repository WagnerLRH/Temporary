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

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelDashboard extends JPanel implements ActionListener{

  private Image imagen;
  private JButton curiosity;
  private JButton science;
  private JButton calendar;
  private Jota jota=new Jota();
  private Font font;
  
  public PanelDashboard() {
    this.setLayout(null);
    this.createButtons();
    calendar.addActionListener(this);
    this.add(curiosity);
    this.add(science);
    this.add(calendar);
    this.setVisible(true);
  }

  public void paintComponent(Graphics g){
    Graphics2D gr=(Graphics2D) g;
    //JButton
    imagen=jota.getImage("space");
    g.drawImage(imagen,0, 0, this);
    int remaining=(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()-300;
    gr.setColor(Color.gray);
    gr.fillRect(300, 0, remaining, 60);//este pedazo esta pintando la cosa gris de hasta arriba
    gr.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.6f));
    gr.setColor(Color.BLACK);
    int height=(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    gr.fillRect(0, 60, 300, height-60);
    gr.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
  }

  private void createButtons() {
    //Creando curiosity
    curiosity=new JButton("NASA Curiosity School");
    curiosity.setForeground(Color.white);
    curiosity.setFont(new Font("Helvetica", Font.BOLD, 20));
    curiosity.setBounds(0, 0, 300, 60);
    curiosity.setBackground(Color.DARK_GRAY);
    curiosity.setBorder(null);
    //Creando science
    science=new JButton("A NASA Science School");
    science.setForeground(Color.white);
    science.setFont(new Font("Helvetica", Font.BOLD, 21));
    int x=(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    science.setBounds(x-300, 0, 300, 60);
    science.setBackground(Color.BLUE.darker().darker());
    science.setBorder(null);
    //Creando calendar
    calendar=new JButton("Calendar");
    calendar.setForeground(Color.WHITE);
    calendar.setFont(new Font("Activities Calendar", Font.BOLD, 20));
    calendar.setBounds(0, 60, 300, 50);
    calendar.setContentAreaFilled(false);
  }

  public void actionPerformed(ActionEvent e){
	  if(e.getSource()==calendar) {		  
		  FrameCalendar calendario=new FrameCalendar();
		  calendario.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
	  }
  }

}
