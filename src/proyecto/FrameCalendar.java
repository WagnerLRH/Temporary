package proyecto;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JWindow;

public class FrameCalendar extends JFrame{

	static final int width=(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	static final int height=(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	
	public FrameCalendar() {
		this.setUndecorated(true);
		this.setBackground(new Color(1.0f,1.0f,1.0f,0.2f));
		this.setBounds(300, 88, width-300, height-120);
		this.add(new PanelCalendar());
		this.setVisible(true);
	}
	
}

class PanelCalendar extends JPanel{
	
	public PanelCalendar() {
		this.setVisible(true);
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D gr=(Graphics2D) g;
		gr.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));
		gr.setColor(Color.BLUE.darker().darker().darker().darker());
		gr.fillRect(0, 0, FrameCalendar.width-300, FrameCalendar.height-88);
		gr.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));
	}
	
}
