import java.util.Scanner;

public class Lab1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		
		System.out.print("Nhập số thứ tự của bài (1 - 4): ");
		try {
		num = sc.nextInt();	
		switch(num) {
		case 1:
			Bai1();
			break;
		case 2:
			Bai2(sc);
			break;
		case 3:
			Bai3(sc);
			break;
		case 4:
			Bai4(sc);
			break;
		default:
			System.out.print("Không có bài phù hợp");
		}
		}
		catch(Exception ex) {
			System.out.print("Dữ liệu không hợp lệ");
		}
	}
	public static void Bai1() {
		String HoTen;
		double DTB;
		Scanner scanner = new Scanner(System.in);

		System.out.print("Họ và Tên: ");
		HoTen = scanner.nextLine();
		System.out.print("Điểm trung bình: ");
		DTB = scanner.nextDouble();
		System.out.printf("%s %.3f điểm",HoTen,DTB);

		
		
		
		
	}
	
	public static void Bai2(Scanner sc) {
		double d,r,CV,DT;		
		System.out.println("---Chu vi, diện tích hình chữ nhật---");
		
		System.out.print("Nhập chiều dài: ");
		d = sc.nextDouble();
		System.out.print("Nhập chiều rộng: ");
		r = sc.nextDouble();
		
		CV = (d+r)/2;
		DT = d * r;
		System.out.printf("Chu vi hình chữ nhật là %.3f \n",CV);
		System.out.printf("Diện tích hình chữ nhật là %.3f",DT);
		
		
		
	}
	
	public static void Bai3(Scanner sc) {
		double c,TT;		
		System.out.println("---Thể tích lập phương---");
		
		System.out.print("Nhập độ dài cạnh hình lập phương: ");
		c = sc.nextDouble();
		TT = Math.pow(c,3);
		System.out.printf("Thể tích của khối lập phương là %.3f",TT);
		
		
		
	}
	
	
	public static void Bai4(Scanner sc) {
		double a,b,c,delta;		
		System.out.println("---Phương trình bậc 2---");
		
		System.out.print("Nhập a: ");
		a = sc.nextDouble();
		System.out.print("Nhập b: ");
		b = sc.nextDouble();
		System.out.print("Nhập c: ");
		c = sc.nextDouble();
		
		delta = Math.pow(b,2) - 4 * a * c;
		System.out.printf("Delta :%.3f , căn bậc hai của delta: %.3f",delta,Math.sqrt(delta));
		
		
	}

}
