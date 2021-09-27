package Bai1;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.BoxLayout;
public class SimpleMath extends Frame{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	TextField txtA,txtB,txtKQ;
	Label lbA,lbB,lbKQ;
	Button btnCong,btnTru,btnNhan,btnChia;
	
	
	public SimpleMath() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Color.decode("#dd9eb9"));
		setBounds(0,0,500,400);
		setVisible(true);
		setTitle("Simple Math");
		
		lbA = new Label("Nhập số A:");
		lbB = new Label("Nhập số B:");
		lbKQ = new Label("Kết Quả:");
		
		txtA = new TextField();
		txtB = new TextField();
		txtKQ = new TextField();
		
		btnCong = new Button(" + ");
		btnTru = new Button(" - ");
		btnNhan = new Button(" * ");
		btnChia = new Button(" / ");
		
		add(lbA); add(txtA);
		add(lbB); add(txtB);
		add(btnCong);
		add(btnTru);
		add(btnNhan);
		add(btnChia);
		add(lbKQ); add(txtKQ);
		
		Font fieldFont = new Font("Arial", Font.PLAIN, 20);
		txtA.setFont(fieldFont);
		txtB.setFont(fieldFont);
		txtKQ.setFont(new Font("Arial", Font.PLAIN, 30));
		
		lbA.setBackground(Color.black);
		lbA.setForeground(Color.white);
		lbB.setBackground(Color.black);
		lbB.setForeground(Color.white);
		lbKQ.setBackground(Color.black);
		lbKQ.setForeground(Color.white);
		
		txtA.setForeground(Color.gray);
		txtB.setForeground(Color.gray);
		txtKQ.setEnabled(false);
		
		btnCong.setForeground(Color.pink);
		btnCong.setFont(fieldFont);
		btnTru.setForeground(Color.pink);
		btnTru.setFont(fieldFont);
		btnNhan.setForeground(Color.pink);
		btnNhan.setFont(fieldFont);
		btnChia.setForeground(Color.pink);
		btnChia.setFont(fieldFont);
		
		addWindowListener(new XLDong());
		
		btnCong.addActionListener(new XLCong());
		btnTru.addActionListener(new XLTru());
		btnNhan.addActionListener(new XLNhan());
		btnChia.addActionListener(new XLChia());
	}
	class XLDong implements WindowListener{

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
	class XLCong implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//lay gia tri a , b
			String strA = txtA.getText();
			String strB= txtB.getText();
			try {
			//chuyen sang so
			int a = Integer.parseInt(strA);
			int b = Integer.parseInt(strB);
			int c = a + b ;
			//xuat ket qua
			txtKQ.setText(String.valueOf(c));
			}
			catch(Exception ex) {
				txtKQ.setText("Dữ Liệu Sai");
			}
		}
	}
	class XLTru implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//lay gia tri a , b
			String strA = txtA.getText();
			String strB= txtB.getText();
			try {
			//chuyen sang so
			int a = Integer.parseInt(strA);
			int b = Integer.parseInt(strB);
			int c = a - b ;
			//xuat ket qua
			txtKQ.setText(String.valueOf(c));
			}
			catch(Exception ex) {
				txtKQ.setText("Dữ Liệu Sai");
			}
		}
	}
	class XLNhan implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//lay gia tri a , b
			String strA = txtA.getText();
			String strB= txtB.getText();
			try {
			//chuyen sang so
			int a = Integer.parseInt(strA);
			int b = Integer.parseInt(strB);
			int c = a * b ;
			//xuat ket qua
			txtKQ.setText(String.valueOf(c));
			}
			catch(Exception ex) {
				txtKQ.setText("Dữ Liệu Sai");
			}
		}
	}
	class XLChia implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//lay gia tri a , b
			String strA = txtA.getText();
			String strB= txtB.getText();
			try {
			//chuyen sang so
			int a = Integer.parseInt(strA);
			int b = Integer.parseInt(strB);
			
			double c =(1.0 * a / b);
			//xuat ket qua
			txtKQ.setText(String.valueOf((double)Math.round(c * 1000) / 1000));
			}
			catch(Exception ex) {
				txtKQ.setText("Dữ Liệu Sai");
			}
		}
	}
	
}
	
