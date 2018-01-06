import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
public class GL_Test extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GL_Test().setVisible(true);
	}
	
	private GL_Test() {
		super("GL_Test!"); //sets title for the window
		setSize(1024,768);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JButton button = new JButton("Hello");
		add(button); 
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
