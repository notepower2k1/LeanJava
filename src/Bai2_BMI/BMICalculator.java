package Bai2_BMI;

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

public class BMICalculator extends Frame{
	
	private static final long serialVersionUID = 1L;
	Label lbH,lbW,lbR,lbCategories,lbAdvice;
	TextField txtH,txtW,txtR;
	Button Cal;
	
	public BMICalculator() {
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		setBounds(0,0,400,400);
		setVisible(true);
		setTitle("BMI Calculator");
		lbH = new Label("Nhập chiều cao (cm)");
		lbW = new Label("Nhập cân nặng (kg)");
		lbCategories = new Label();
		
		
		lbH.setBackground(Color.black);
		lbH.setForeground(Color.white);
		lbW.setBackground(Color.black);
		lbW.setForeground(Color.white);
		lbCategories.setBackground(Color.black);
		lbCategories.setForeground(Color.white);
		
		
		txtH = new TextField();
		txtW = new TextField();
		txtR = new TextField();
		txtR.setEnabled(false);
		
		Cal = new Button("Tính Toán");
		
		Font fieldFont = new Font("Arial", Font.PLAIN, 20);
		txtH.setFont(fieldFont);
		txtW.setFont(fieldFont);
		txtR.setFont(new Font("Arial", Font.PLAIN, 30));
		
		add(lbH); add(txtH);
		add(lbW); add(txtW);
		add(Cal);
		add(txtR);
		add(lbCategories);
		
		addWindowListener(new XLDong());
		Cal.addActionListener(new XLTinh());
		
	}
	class XLDong implements WindowListener{


		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);
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
	class XLTinh implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			String strH = txtH.getText();
			String strW = txtW.getText();
		try
		{
			double H =  Double.parseDouble(strH);
			double W = Double.parseDouble(strW);
		
			if(H >=255 || H <=55 || W >= 260 || W <=5 )
			{
				throw new Exception("Exception message");
			}
			else
			{
				double BMI = W / (Math.pow(H/100,2));
				
				txtR.setText(String.valueOf("BMI =" +" " +(double)Math.round(BMI * 10) / 10));
				
				double Wmin = (18.5 - BMI) * (Math.pow(H/100,2));
				double Wmax = (BMI - 24.9) * (Math.pow(H/100,2));
				if(BMI<18.5)
	            {
					
					lbCategories.setText("Bạn bị gầy và cần tăng ít nhất " + (double)Math.round(Wmin * 10) / 10 +" kg để đạt được BMI bình thường");
					lbCategories.setForeground(Color.decode("#26baec"));
	                
	            }
	            else if(BMI >=18.5 && BMI <=24.9)
	            {
	            	lbCategories.setText("Bạn bình thường ,hãy cố gắng duy trì chỉ số BMI hiện tại");
	            	lbCategories.setForeground(Color.decode("#b2bc83"));
	            }
	            else if(BMI>=25 && BMI <=29.9)
	            {
	            	lbCategories.setText("Bạn thừa cân và cần giảm " + (double)Math.round(Wmax * 10) / 10 + " kg để đạt được BMI bình thường");
	            	lbCategories.setForeground(Color.decode("#facb11"));
	            }
	            else
	                {
	            	lbCategories.setText("Bạn béo phì và cần giảm " + (double)Math.round(Wmax * 10) / 10 +" kg để đạt được BMI bình thường");
	            	lbCategories.setForeground(Color.decode("#f39036"));
	            }
			}
		}
			catch(Exception ex) {
				txtR.setText("Sai dữ liệu");
			}
	}
		
	}
}

