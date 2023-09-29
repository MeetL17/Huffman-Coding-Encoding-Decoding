package mpr;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
	public GUI() { // GUI
		Frame s3 = new Frame("STEP 3 ");
		s3.setVisible(true);
		s3.setSize(500, 500);
		s3.setLayout(null);
		
		s3.setBackground(Color.LIGHT_GRAY);

		Button b1 = new Button("NEXT");
		b1.setBounds(400, 400, 70, 80);
		s3.add(b1);

		Label height = new Label("YOUR HUFFMAN STRING WAS : ");
		height.setBounds(60, 200, 200, 20);
		s3.add(height);

		Label l1 = new Label("Step 3");
		l1.setBounds(270, 200, 180, 20);
		s3.add(l1);

		Label finalt = new Label("ASSIGN BIT CODE :  ");
		finalt.setBounds(60, 300, 220, 20);
		s3.add(finalt);

		Label l2 = new Label("Step 3");
		l2.setBounds(60, 300, 350, 50);
		s3.add(l2);

		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
	}

	public static void main(String[] args) {
		GUI obj = new GUI();
	}
}
