import java.util.*;

public class Priprema {

	static Scanner sc = new Scanner(System.in);
	
	public static void imaginarni() {
		int n = sc.nextInt();
		double rl[] = new double[n];
		double im[] = new double[n];
		for(int i = 0;i < n;i++) {
			rl[i] = sc.nextDouble();
		}
		for(int i = 0;i < n;i++) {
			im[i] = sc.nextDouble();
		}
		double resrl = rl[0];
		double resim = im[0];
		for(int i = 1;i < n;i++) {
			double temprl = resrl;
			double tempim = resim;
			resrl = temprl*rl[i] - tempim*im[i];
			resim = temprl*im[i] + tempim*rl[i];
		}
		System.out.println(resrl + " " + resim);
	}
	
	public static void maxtrougao() {
		int n = sc.nextInt();
		double x[] = new double[n];
		double y[] = new double[n];
		for(int i = 0;i < n;i++) {
			x[i] = sc.nextDouble();
			y[i] = sc.nextDouble();
		}
		double res = 0;
		for(int i = 0;i < n-2;i++) {
			for(int j = i+1;j < n-1;j++) {
				for(int k = j+1;k < n;k++) {
					res = Math.max(0.5*Math.abs((x[i]*(y[j]-y[k]) + x[j]*(y[k]-y[i]) + x[k]*(y[i]-y[j]))), res);
				}
			}
		}
		System.out.println(res);
	}
	
	public static void istaprava() {
		int n = sc.nextInt();
		double x[] = new double[n];
		double y[] = new double[n];
		for(int i = 0;i < n;i++) {
			x[i] = sc.nextDouble();
			y[i] = sc.nextDouble();
		}
		double k = (y[0] - y[1])/(x[0] - x[1]);
		double m = y[0] - k * x[0];
		boolean good = true;
		double epsilon = 0.00001;
		for(int i = 2;i < n;i++) {
			if(!(y[i] <= epsilon+(k*x[i])+m && y[i] >= (k*x[i])+m-epsilon)) {
				good = false;
				break;
			}
		}
		if(good) {
			System.out.println("DA");
		}else {
			System.out.println("NE");
		}
	}
	
	public static void magicnamat() {
		int n = sc.nextInt();
		int mat[][] = new int[n][n];
		for(int i = 0;i < n;i++) {
			for(int j = 0;j < n;j++) {
				mat[i][j] = sc.nextInt();
			}
		}
		int num = 0;
		boolean good = true;
		for(int i = 0;i < n;i++) {
			num += mat[i][i];
		}
		for(int i = 0;i < n;i++) {
			int hor = 0;
			int ver = 0;
			for(int j = 0;j < n;j++) {
				hor += mat[i][j];
				ver += mat[j][i];
			}
			if(hor != ver || ver != num) {
				good = false;
				break;
			}
		}
		for(int i = 0;i < n;i++) {
			num -= mat[i][n-i-1];
		}
		if(num != 0)good = false;
		if(good) {
			System.out.println("DA");
		}else {
			System.out.println("NE");
		}
	}
	
	public static void crta() {
		String s = sc.nextLine();
		String res = "";
		for(int i = 0;i < s.length();i++) {
			if(Character.isUpperCase(s.charAt(i))) {
				res += '_';
				res += Character.toLowerCase(s.charAt(i));
			}else {
				res += s.charAt(i);
			}
		}
		System.out.println(res);
	}
	
	public static void dvastringa() {
		String a = sc.nextLine();
		String b = sc.nextLine();
		int slova[] = new int[26];
		for(int i = 0;i < a.length();i++) {
			slova[a.charAt(i)-'a']++;
		}
		boolean good = true;
		for(int i = 0;i < b.length();i++) {
			slova[b.charAt(i)-'a']--;
			if(slova[b.charAt(i)-'a'] < 0) {
				good = false;
				break;
			}
		}
		if(good) {
			System.out.println("DA");
		}else {
			System.out.println("NE");
		}
	}
	
	public static void main(String[] args) {
		dvastringa();
	}

}
