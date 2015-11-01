import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TopUI extends JFrame {
    //private ArrayList<Double> scores;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private GraphPanel gPanel;
	
	public TopUI(){
		gPanel = new GraphPanel(new ArrayList<Double>());
		 gPanel.setPreferredSize(new Dimension(300,400));

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JTextArea textArea  = new JTextArea();
		//textArea.setSize(new Dimension(500,400));
		textArea.setPreferredSize(new Dimension(300,200));
		JButton btn = new JButton();
		getContentPane().setLayout(
			    new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS)
			);
		JPanel panel =  new JPanel(new GridLayout(1,1));
		panel.add(btn);
		btn.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String text = textArea.getText();
				 ArrayList<Double> scores = convertToList(text);
				 for(int i = 0; i < scores.size(); i++){
					 System.out.println("Scores: " + scores.get(i));
				 }
				 gPanel.setScores(scores);
				 remove(gPanel);

				 add(gPanel);
				 //gPanel.revalidate();
				//add(gPanel);

			}
			
		});
		btn.setText("Generate Graph");
		//btn.setHorizontalAlignment((int) CENTER_ALIGNMENT);
	add(textArea);
	add(panel);
 add(gPanel);

		//add(new Graph());
		
	}
	
	private ArrayList<Double> convertToList(String text){
		 ArrayList<Double> scores = new ArrayList<Double>();
		 int iterator = 0;
		 int i = 0;
		 text = text.trim();
		for(i = 0; i < text.length(); i++){
			if(String.valueOf(text.charAt(i)).equals(String.valueOf(','))){
				Double num = Double.valueOf(text.substring(iterator, i ));
				System.out.println(text.substring(iterator, i));
				System.out.println(num);
				scores.add(num);
				iterator = i + 1;
			}
			
		}
		Double num = Double.valueOf(text.substring(iterator, i ));
		scores.add(num);
		return scores;
	}
}
