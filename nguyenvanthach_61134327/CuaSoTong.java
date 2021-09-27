package ntu_POHE;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BoxLayout;

public class CuaSoTong extends Frame {
	
	TextField txtA,txtB,txtKQ;
	Label lbA,lbB,lbKQ;
	Button btnCong;
	
	public CuaSoTong() {
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		setBounds(0,0,400,200);
		
		lbA = new Label("A= ");
		lbB = new Label("B= ");
		lbKQ = new Label("KQ= ");
		
		txtA = new TextField();
		txtB = new TextField();
		txtKQ = new TextField();
		
		btnCong = new Button(" + ");
		
		lbA.setBackground(Color.black);
		lbA.setForeground(Color.white);
		lbB.setBackground(Color.black);
		lbB.setForeground(Color.white);
		lbKQ.setBackground(Color.black);
		lbKQ.setForeground(Color.white);
		
		add(lbA);
		add(txtA);
		add(lbB);
		add(txtB);
		add(lbKQ);
		add(btnCong);
		add(txtKQ);
		setTitle("Tinh Tong A,B");
		setVisible(true);
		
		btnCong.addActionListener(new XLCong());
		addWindowListener(new XLDongCS());
		
		
	} 
	class XLCong implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String strA = txtA.getText();
			String strB= txtB.getText();
			try {
			//chuyen sang so
			int a = Integer.parseInt(strA);
			int b = Integer.parseInt(strB);
			//tinh tong
			int c = a + b ;
			//xuat ket qua
			txtKQ.setText(String.valueOf(c));
			}
			catch(Exception ex) {
				txtKQ.setText("ERROR!");
			}
		}
	}
	class XLDongCS implements WindowListener{
		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
				System.exit(0);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
}
	
