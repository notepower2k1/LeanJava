package guiBanHang;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;
import java.awt.Color;

public class BanHang_GUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<SanPham> dsSP = new ArrayList<>();
	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtName;
	JLabel lblID;
	JLabel lblName;
	JLabel lblPrice;
	JButton btnAdd;
	JButton btnUpdate;
	JButton btnDelete;
	JButton btnSearch;
	JTextArea txaShow;
	private JTextField txtPrice;
	private JLabel lblstt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BanHang_GUI frame = new BanHang_GUI();
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
	public BanHang_GUI() {
		setResizable(false);
		setTitle("Quản lý hàng hóa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 758, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblID = new JLabel("Mã sản phẩm");
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblID.setBounds(64, 40, 97, 13);
		contentPane.add(lblID);
		
		lblName = new JLabel("Tên sản phẩm");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblName.setBounds(64, 93, 97, 13);
		contentPane.add(lblName);
		
		lblPrice = new JLabel("Đơn giá");
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPrice.setBounds(64, 144, 71, 13);
		contentPane.add(lblPrice);
		
		txtID = new JTextField();
		txtID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				lblstt.setText("");
			}
		});
		txtID.setBounds(170, 33, 263, 30);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		txtName = new JTextField();
		txtName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				lblstt.setText("");
			}
		});
		txtName.setBounds(170, 85, 263, 32);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		btnAdd = new JButton("Thêm");
		
		
		btnAdd.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				if(checkEmpty())
				{
					String id = txtID.getText();			
					if(check(id) == true)
				{
					String name = txtName.getText();
					
					try	{
						float gia = Float.parseFloat(txtPrice.getText());	
						if(gia > 0)
							{
							AddSP(id, name, gia);								
							txaShow.append("Mã sản phẩm: " + id + " ------ " + "Tên sản phẩm: " + name + " ------ " + "Giá sản phẩm: " + gia + "\n");		
							reset();
							}
						else {
							lblstt.setText("Giá sản phẩm phải là số dương");
						}
					}
					catch(Exception ex)
					{
						lblstt.setText("Giá sản phẩm phải là số");
					}
					
				}
				else {
					lblstt.setText("Sản phẩm đã tồn tại!!!");
					}
				}
				else {
					lblstt.setText("Vui lòng nhập vào thông tin sản phẩm!!!");
				}
			}
		});
		btnAdd.setBounds(489, 37, 85, 21);
		contentPane.add(btnAdd);
		
		btnUpdate = new JButton("Sửa");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String id = txtID.getText();
				
				if(check(id) == false)
				{
					if(checkEmpty())
					{
						
					try {
						
						String name = txtName.getText();
					float gia = Float.parseFloat(txtPrice.getText());	
					
						if(gia > 0)
						{
							for(int i = 0 ; i < dsSP.size() ; i++)
							{
								if(dsSP.get(i).getMaSP().equals(id))
								{
									dsSP.get(i).setTenSP(name);
									dsSP.get(i).setDonGia(gia);
								}						
							}
							
							HienThi();
							reset();
						}
						else {
							lblstt.setText("Giá sản phẩm phải là số dương");
						}
					}
					catch(Exception ex)
					{
						lblstt.setText("Giá sản phẩm phải là số");

					}
						
						
					}
					else {
						lblstt.setText("Vui lòng nhập vào thông tin sản phẩm!!!");
					}
					}
				else {
					lblstt.setText("Không tìm thấy mã sản phẩm");
				}
			}
		});
		btnUpdate.setBounds(602, 90, 85, 21);
		contentPane.add(btnUpdate);
		
		btnDelete = new JButton("Xóa");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txtID.getText();
				
				if(check(id) == false)
				{
					
						for(int i = 0 ; i < dsSP.size() ; i++)
						{
							if(dsSP.get(i).getMaSP().equals(id))
							{
								dsSP.remove(i);
							}
							
							HienThi();
						}
					}
				else {
					lblstt.setText("Không tìm thấy mã sản phẩm");
				}
			}
		});
		btnDelete.setBounds(489, 90, 85, 21);
		contentPane.add(btnDelete);
		
		 btnSearch = new JButton("Tìm kiếm");
		 btnSearch.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		String id = txtID.getText();	
		 		
				if(check(id) == false)
				{
					String tensp = "";
					float giasp=0;
					
					for(int i =0 ; i < dsSP.size();i++)
					{
						if(dsSP.get(i).getMaSP().equals(id))
						{
							tensp = dsSP.get(i).getTenSP();
							giasp = dsSP.get(i).getDonGia();
						}
					
					}
					JOptionPane.showMessageDialog(BanHang_GUI.this, "Sản phẩm có mã:" + id
							+ "\n" + "Tên sản phẩm là:" + tensp + "\n" + "Giá sản phẩm là:" + giasp, "Kết quả tìm kiếm", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					lblstt.setText("Không tìm thấy mã sản phẩm");
				}
		 		
		 	}
		 });
		btnSearch.setBounds(602, 37, 85, 21);
		contentPane.add(btnSearch);
		
		txaShow = new JTextArea();
		txaShow.setForeground(Color.DARK_GRAY);
		txaShow.setFont(new Font("Monospaced", Font.BOLD, 13));
		txaShow.setEditable(false);
		txaShow.setBounds(10, 185, 724, 205);
		contentPane.add(txaShow);
		
		txtPrice = new JTextField();
		txtPrice.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				lblstt.setText("");
			}
		});
		txtPrice.setBounds(169, 137, 264, 30);
		contentPane.add(txtPrice);
		txtPrice.setColumns(10);
		
		lblstt = new JLabel("");
		lblstt.setForeground(Color.RED);
		lblstt.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblstt.setBounds(458, 127, 263, 30);
		contentPane.add(lblstt);
	}
		 void reset() {
		// TODO Auto-generated method stub
			 txtID.setText("");
			 txtName.setText("");
			 txtPrice.setText("");
	}

		boolean check (String id) {
		
		for(int i = 0 ; i < dsSP.size() ; i++)
			if(dsSP.get(i).getMaSP().equals(id)) {
				return false;
			}
		return true;
		}
		

	void AddSP(String id,String name,float gia) {
		dsSP.add(new SanPham(id,name,gia));
		lblstt.setText("Thêm thành công!!!");
	}
	
	void HienThi()
	{
		txaShow.setText("");
		for(int i =0 ;i <dsSP.size() ;i++) {
			String id = dsSP.get(i).getMaSP();
			String name = dsSP.get(i).getTenSP();
			float gia = dsSP.get(i).getDonGia();
			txaShow.append("Mã sản phẩm: " + id + " ------ " + "Tên sản phẩm: " + name + " ------ " + "Giá sản phẩm: " + gia + "\n");	
		}
	}
	
	boolean checkEmpty() {
		if(txtID.getText().equals("") || txtName.getText().equals("") || txtPrice.getText().equals(""))
		{
			return false;
		}
		return true;
	}
}
