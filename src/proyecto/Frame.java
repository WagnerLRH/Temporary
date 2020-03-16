package proyecto;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;

import javax.swing.JFrame;

public class Frame extends JFrame{

	private String title;
	private String url="C:\\Users\\wagne\\OneDrive\\Desktop\\Nasa.png";
	private Image img=Toolkit.getDefaultToolkit().getImage(url);
	private Jota jota=new Jota();

	public Frame() {
		//INSERT IMAGE TO USE LATER WITH AN ADD IMAGE OPTION
		/*try {
			jota.insertImage();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("El archivo no se encontro");
		}*/
		title="NASA Curiosity School";
		System.out.println(title);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setTitle(title);
		this.setIconImage(img);
		this.add(new PanelDashboard());
		this.setVisible(true);
	}

	public Frame(int doesnothing1) {
		title="Welcome to the NASA Curiosity School!";
		this.setTitle(title);
		this.setIconImage(img);
		int width=(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2;
		int height=(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2;
		int x=width/2;
		int y=height/2;
		this.setBounds(x, y, width, height);
		this.add(new PanelLogin());
		this.setVisible(true);
	}
	
	public Frame(int doesnothing1, int doesnothing2) {
		title="Welcome to the NASA Curiosity School!";
		this.setTitle(title);
		this.setIconImage(img);
		int width=(int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2)/2;
		int height=(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2;
		int x=width/2;
		int y=height/2;
		this.setBounds(x, y, width, height);
		this.add(new PanelCreate());
		this.setVisible(true);
	}
	
	public void closeFrame() {
		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));		
	}
}
