package bmiSwing;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.ImageIcon;

public class BMIGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCao;
	private JTextField txtNang;
	private JTextField txtResult;
	private JTextField txtCate;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BMIGUI frame = new BMIGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BMIGUI() {
		setTitle("BMI Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 401);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lbCao = new JLabel("Height:");
		lbCao.setHorizontalAlignment(SwingConstants.RIGHT);
		lbCao.setForeground(new Color(255, 255, 255));
		lbCao.setBackground(new Color(255, 255, 255));
		lbCao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbCao.setBounds(83, 48, 50, 20);
		contentPane.add(lbCao);
		
		txtCao = new JTextField();
		txtCao.setForeground(UIManager.getColor("Button.background"));
		txtCao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCao.setBackground(UIManager.getColor("Button.disabledForeground"));
		txtCao.setBounds(132, 48, 170, 23);
		contentPane.add(txtCao);
		txtCao.setColumns(10);
		
		JLabel lbNang = new JLabel("Weight:");
		lbNang.setHorizontalAlignment(SwingConstants.RIGHT);
		lbNang.setForeground(new Color(255, 255, 255));
		lbNang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbNang.setBounds(69, 126, 64, 13);
		contentPane.add(lbNang);
		
		txtNang = new JTextField();
		txtNang.setForeground(UIManager.getColor("Button.background"));
		txtNang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNang.setBackground(UIManager.getColor("Button.disabledForeground"));
		txtNang.setBounds(132, 121, 170, 23);
		contentPane.add(txtNang);
		txtNang.setColumns(10);
		
		JPanel panelQT = new JPanel();
		panelQT.setBorder(new TitledBorder(null, "Region", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panelQT.setBounds(69, 183, 170, 145);
		contentPane.add(panelQT);
		panelQT.setLayout(null);
		
		JRadioButton rdAsian = new JRadioButton("Asian");
		rdAsian.setFont(new Font("Tahoma", Font.PLAIN, 17));
		buttonGroup.add(rdAsian);
		rdAsian.setBounds(20, 37, 103, 21);
		panelQT.add(rdAsian);
		
		JRadioButton rdNotAsian = new JRadioButton("Non-Asian");
		rdNotAsian.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonGroup.add(rdNotAsian);
		rdNotAsian.setBounds(20, 89, 103, 21);
		panelQT.add(rdNotAsian);
		
		JButton btnTinh = new JButton("");
		btnTinh.setBackground(Color.WHITE);
		ImageIcon img = new ImageIcon(this.getClass().getResource("/calculator_math.png"));
		btnTinh.setIcon(img);
		btnTinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
				if((rdAsian.isSelected()==true)  || (rdNotAsian.isSelected()==true) || (txtCao.getText().length()==0) || (txtNang.getText().length()==0))
				{
				
					// lay gia tri
					String strC = txtCao.getText();
					String strN = txtNang.getText();
					//
					double Cao = Double.parseDouble(strC);
					double Nang = Double.parseDouble(strN);
					boolean isAsian = false;
				
				if(rdAsian.isSelected()==true) {
					isAsian = true;
				}
				else {
					isAsian = false;
				}
				//tinh BMI
				
				double BMI = Nang / (Math.pow(Cao/100,2));
				
				
				txtResult.setText(String.valueOf("BMI =" +" " +(double)Math.round(BMI * 10) / 10));
				
				if(isAsian == false) {
					
					if(BMI < 18.5) {
						txtCate.setText("Underweight");
						txtCate.setForeground(Color.decode("#59bbe2"));

					}
					
					else if(BMI >=18.5 && BMI <=24.9) {
						txtCate.setText("Normal");
						txtCate.setForeground(Color.decode("#9eb33a"));

					}
					else if(BMI >=25 && BMI <=29.9){
						txtCate.setText("Overweight");
						txtCate.setForeground(Color.decode("#f68121"));
					}
					else if(BMI >=30 && BMI <=40){
						txtCate.setText("Obese");
						txtCate.setForeground(Color.decode("#e64435"));
					}
					else if(BMI >=40.1 && BMI <=50){
						txtCate.setText("Morbid obese");
						txtCate.setForeground(Color.decode("#be3b8b"));
					}
					else{
						txtCate.setText("Super obese");
						txtCate.setForeground(Color.decode("#ed1e29"));
					}
				}
				else if (isAsian == true) {
					if(BMI < 18.5) {
						txtCate.setText("Underweight");
						txtCate.setForeground(Color.decode("#59bbe2"));

					}
					
					else if(BMI >=18.5 && BMI <=22.9) {
						txtCate.setText("Normal");
						txtCate.setForeground(Color.decode("#9eb33a"));

					}
					else if(BMI >=23 && BMI <=24.9){
						txtCate.setText("Overweight");
						txtCate.setForeground(Color.decode("#f68121"));
					}
					else if(BMI >=25 && BMI <=29.9){
						txtCate.setText("Pre-Obese");
						txtCate.setForeground(Color.decode("#caa37c"));
					}
					else if(BMI >=30 && BMI <=40){
						txtCate.setText("Obese");
						txtCate.setForeground(Color.decode("#e64435"));
					}
					else if(BMI >=40.1 && BMI <=50){
						txtCate.setText("Morbid obese");
						txtCate.setForeground(Color.decode("#be3b8b"));
					}
					else{
						txtCate.setText("Super obese");
						txtCate.setForeground(Color.decode("#ed1e29"));
					}
				}
					}
				}
				
				catch (Exception ex){
					txtResult.setText("Please provide positive value!!!");
					txtResult.setForeground(Color.decode("#f68121"));
					txtCate.setText("Error!!!!");
					txtCate.setForeground(Color.decode("#f68121"));
					
				}
			
			}
		});
		btnTinh.setBounds(415, 63, 140, 60);
		contentPane.add(btnTinh);
		
		JPanel panelResult = new JPanel();
		panelResult.setBounds(273, 190, 352, 138);
		contentPane.add(panelResult);
		panelResult.setLayout(null);
		
		txtResult = new JTextField();
		txtResult.setEditable(false);
		txtResult.setHorizontalAlignment(SwingConstants.CENTER);
		txtResult.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtResult.setBounds(10, 5, 332, 43);
		panelResult.add(txtResult);
		txtResult.setColumns(10);
		
		txtCate = new JTextField();
		txtCate.setHorizontalAlignment(SwingConstants.CENTER);
		txtCate.setFont(new Font("Tahoma", Font.BOLD, 32));
		txtCate.setEditable(false);
		txtCate.setBounds(10, 72, 332, 56);
		panelResult.add(txtCate);
		txtCate.setColumns(10);
	}
}
