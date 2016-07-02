import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;

public class navigation extends JFrame{
	private static final long serialVersionUID = 1L;
	private JEditorPane display;
	private JTextField address;
	
	public navigation(){
		super("Cool Browser");
		
		//address Bar
		address = new JTextField("Enter URL");
		address.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				displaypage(event.getActionCommand());
			}
		});
		add(address,BorderLayout.NORTH);
		
		//display page on the pane
		display = new JEditorPane();
		display.setEditable(false);
		display.addHyperlinkListener(new HyperlinkListener(){
			public void hyperlinkUpdate(HyperlinkEvent event) {
				if (event.getEventType()==HyperlinkEvent.EventType.ACTIVATED){
					displaypage(event.getURL().toString());
				}
			}});
		add(new JScrollPane(display),BorderLayout.CENTER);
		setSize(500,500);
		setVisible(true);
	}
	public void displaypage(String url){
		try{
			display.setPage(url);
			address.setText(url);
		}catch(Exception e){display.setText("Crap!! :(");}
	}
}