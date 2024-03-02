import java.util.*;

public class Vjezba {
	static Scanner sc = new Scanner(System.in);
	
	public static int maksimum(int a[]) {
		int maxi = a[0];
		for(int i = 1;i < a.length;i++) {
			maxi = Math.max(maxi, a[i]);
		}
		return maxi;
	}
	
	public static float prosjek(int a[]) {
		int sum = 0;
		for(int i = 0;i < a.length;i++)sum+=a[i];
		return (sum*1.0f/a.length);
	}
	
	public static int prebroj(int a[], int k) {
		int res = 0;
		for(int i = 0;i < a.length;i++) {
			if(a[i] > k && a[i]%2 == 0) {
				res++;
			}
		}
		return res;
	}
	
	public static int[] dupliranje() {
		int n = sc.nextInt();
		int a[] = new int[n];
		int b[] = new int[2*n];
		for(int i = 0;i < n;i++) {
			a[i] = sc.nextInt();
		}
		for(int i = 0;i < n;i++) {
			b[i*2] = a[i];
			b[i*2 + 1] = a[i];
		}
		return b;
	}
	
	public static void parniNeparni (int a[]) {
		int par = 0;
		int nepar = 0;
		for(int i = 0;i < a.length;i++) {
			if(a[i]%2 == 0) {
				par++;
			}else {
				nepar++;
			}
		}
		int b[] = new int[par];
		int c[] = new int[nepar];
		int indb = 0;
		int indc = 0;
		for(int i = 0;i < a.length;i++) {
			if(a[i]%2 == 0) {
				b[indb] = a[i];
				indb++;
			}else {
				c[indc] = a[i];
				indc++;
			}
		}
		for(int i = 0;i < par;i++) {
			System.out.print(b[i] + " ");
		}
		System.out.println();
		for(int i = 0;i < nepar;i++) {
			System.out.print(c[i] + " ");
		}
	}
	
	public static int[] nizIntervala(int a[],int b[],int x) {
		int size = 0;
		for(int i = 0;i < a.length;i++) {
			if(a[i] <= x && b[i] >= x) {
				size++;
			}
		}
		int c[] = new int[size];
		int ind = 0;
		for(int i = 0;i < a.length;i++) {
			if(a[i] <= x && b[i] >= x) {
				c[ind] = i;
				ind++;
			}
		}
		return c;
	}
	
	public static boolean sortiran (int a[]) {
		boolean sortiran1 = true;
		boolean sortiran2 = true;
		for(int i = 0;i < a.length-1;i++) {
			if(a[i] > a[i+1]) {
				sortiran1 = false;
				break;
			}
		}
		for(int i = 0;i < a.length-1;i++) {
			if(a[i] < a[i+1]) {
				sortiran2 = false;
				break;
			}
		}
		if(sortiran1) {
			if(sortiran2) {
				System.out.println("Niz je sortiran od najveceg do najmanjeg i od najmanjeg do najveceg");
			}else {
				System.out.println("Niz je sortiran od najmanjeg do najveceg");
			}
		}else if(sortiran2) {
			System.out.println("Niz je sortiran od najveceg do najmanjeg");
		}
		return sortiran1 || sortiran2;
	}
	
	public static float polinom(float a[], float x) {
		float res = 0f;
		float cur = 1.0f;
		for(int i = 0;i < a.length;i++) {
			res += a[i]*cur;
			cur *= x;
		}
		return res;
	}
	
	public static void LijevoDesno (int a[]) {
		int prefix[] = new int[a.length+1];
		for(int i = 1;i <= a.length;i++) {
			prefix[i] = prefix[i-1] + a[i-1];
		}
		int num = 0;
		for(int i = 0;i < a.length;i++) {
			if(prefix[i] - prefix[0] == prefix[a.length] - prefix[i+1]) {
				System.out.println(i);
				num++;
			}
		}
		if(num == 0)System.out.println(-1);
	}
	
	public static void rotiraj(int a[], int k) {
		int b[] = new int[a.length];
		for(int i = 0;i < a.length;i++) {
			b[i] = a[i];
		}
		k = k%a.length;
		for(int i = 0;i < a.length;i++) {
			a[i] = b[(i+k)%a.length];
		}
	}
	
	public static boolean duplikati (int a[]) {
		for(int i = 0;i < a.length-1;i++) {
			for(int j = i+1;j < a.length;j++) {
				if(a[i] == a[j]) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void faleBrojevi(int[] a) {
		boolean b[] = new boolean[a.length+1];
		for(int i = 0;i < a.length;i++) {
			if(a[i] > 0 && a[i] <= a.length) {
				b[a[i]] = true;
			}
		}
		for(int i = 1;i < b.length;i++) {
			if(!b[i])System.out.print(i + " ");
		}
	}
	
	public static void premjesti(int a[]) {
		int ind = 1;
		for(int i = 0;i < a.length && ind < a.length;i++) {
			if(a[i]%2 == 1) {
				ind = Math.max(ind, i+1);
				while(ind < a.length && a[ind]%2 == 1) {
					ind++;
				}
				if(ind >= a.length)break;
				int temp = a[i];
				a[i] = a[ind];
				a[ind] = temp;
			}
		}
	}
	
	public static void maxPodniz(int a[]) {
		int maxi = a[0];
		int len = 1;
		int start = 0;
		int curstart = 0;
		int cur = 0;
		for(int i = 0;i < a.length;i++) {
			cur += a[i];
			if(maxi < cur) {
				maxi = cur;
				start = curstart;
				len = i-start+1;
			}
			if(cur < 0) {
				cur = 0;
				curstart = i+1;
			}
		}
		for(int i = start;i < start + len;i++) {
			System.out.print(a[i] + " ");
		}
	}
	
	public static int[] ubaci(int a[], int r) {
		int b[] = new int[a.length+1];
		boolean ubacen = false;
		for(int i = 0;i < a.length;i++) {
			if(ubacen) {
				b[i+1] = a[i];
			}else {
				if(a[i] < r) {
					b[i] = a[i];
				}else {
					b[i] = r;
					b[i+1] = a[i];
					ubacen = true;
				}
			}
		}
		return b;
	}
	
	public static void main(String[] args) {
		int a[] = { 1,2,4,5,6,7,8,9,1,1,1,1,1,1,1};
		faleBrojevi(a);
	}

}
