import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BoxLayout;

public class TongAB {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame f = new Frame("Tổng 2 số A, B");
		BoxLayout boxlayout = new BoxLayout(f, BoxLayout.Y_AXIS);
		f.setBounds(0, 0, 500, 400);
		f.setLayout(boxlayout);
		f.setVisible(true);
		
		
		//nhãn các nút
		Label lbA = new Label("Nhập số A:");
		Label lbB = new Label("Nhập số B: ");
		Label lbS = new Label("Tổng 2 số: ");
		
		TextField txtA = new TextField();
		TextField txtB = new TextField();
		TextField txtS = new TextField();
		
		//set font cho text field
		Font fieldFont = new Font("Arial", Font.PLAIN, 20);
		txtA.setFont(fieldFont);
		txtB.setFont(fieldFont);
		txtS.setFont(new Font("Arial", Font.PLAIN, 30));
		
		//set màu cho label
		lbA.setBackground(Color.black);
		lbA.setForeground(Color.white);
		lbB.setBackground(Color.black);
		lbB.setForeground(Color.white);
		lbS.setBackground(Color.black);
		lbS.setForeground(Color.white);
		
		
		//set màu chữ text field
		txtA.setForeground(Color.gray);
		txtB.setForeground(Color.gray);
		txtS.setEnabled(false);
		
		Button btnSum = new Button(" + ");
		Button btnMinus = new Button(" - ");
		Button btnMultiply = new Button(" * ");
		Button btnDivide = new Button(" / ");
		
		//set màu cho button
		btnSum.setForeground(Color.pink);
		btnSum.setFont(fieldFont);
		btnMinus.setForeground(Color.pink);
		btnMinus.setFont(fieldFont);
		btnMultiply.setForeground(Color.pink);
		btnMultiply.setFont(fieldFont);
		btnDivide.setForeground(Color.pink);
		btnDivide.setFont(fieldFont);
		
		// gan vao frame
		f.add(lbA);		f.add(txtA);
		f.add(lbB);		f.add(txtB);
		f.add(btnSum);
		f.add(btnMinus);
		f.add(btnMultiply);
		f.add(btnDivide);
		f.add(lbS);		f.add(txtS);
		
		//close 
		WindowAdapter wda = new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};
		f.addWindowListener(wda);
		
		
		//Phep Cong
		ActionListener xulycong = new ActionListener() {

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
				//tinh tong
				int c = a + b ;
				//xuat ket qua
				txtS.setText(String.valueOf(c));
				}
				catch(Exception ex) {
					txtS.setText("Dữ Liệu Sai");
				}
			}
			
		};
		//Phep Tru
		ActionListener xulytru = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//lay gia tri a , b
				String strA = txtA.getText();
				String strB= txtB.getText();
				try {
				int a = Integer.parseInt(strA);
				int b = Integer.parseInt(strB);
				int c = a - b ;
				
				txtS.setText(String.valueOf(c));
				}
				catch(Exception ex) {
					txtS.setText("Dữ Liệu Sai");
				}
			}
			
		};
		//Phep Nhan
		ActionListener xulynhan = new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//lay gia tri a , b
				String strA = txtA.getText();
				String strB= txtB.getText();
				try {
				int a = Integer.parseInt(strA);
				int b = Integer.parseInt(strB);
				
				int c = a * b ;
				//xuat ket qua
				txtS.setText(String.valueOf(c));
				}
				catch(Exception ex) {
					txtS.setText("Dữ Liệu Sai");
				}
					}
					
				};
		//Phep Chia
		ActionListener xulychia = new ActionListener() {
		@Override
				public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//lay gia tri a , b
				String strA = txtA.getText();
				String strB= txtB.getText();
				//chuyen sang so
				try {
				int a = Integer.parseInt(strA);
				int b = Integer.parseInt(strB);
			
				double c =(1.0 * a / b);
				
				
				//xuat ket qua
				txtS.setText(String.valueOf((double) Math.round(c * 1000) / 1000));
				}
				catch(Exception ex) {
					txtS.setText("Dữ Liệu Sai");
				}
				}
					
				};
		btnSum.addActionListener(xulycong);
		btnMinus.addActionListener(xulytru);
		btnMultiply.addActionListener(xulynhan);
		btnDivide.addActionListener(xulychia);
	
	}
	
}
