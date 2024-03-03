import java.util.*;

public class VjezbMatrice {

	public static void sumaMatrice(int mat[][]) {
		int sum = 0;
		for(int i = 0;i < mat.length;i++) {
			for(int j = 1;j < mat[i].length;j++) {
				sum += mat[i][j];
			}
		}
		System.out.println(sum);
	}
	
	public static void lokalniMaksimumi(int mat[][]) {
		for(int i = 0;i < mat.length;i++) {
			for(int j = 0;j < mat[i].length;j++) {
				boolean stampaj = true;
				if(i > 0 && mat[i-1][j] >= mat[i][j])stampaj = false;
				if(i < mat.length-1 && mat[i+1][j] >= mat[i][j])stampaj = false;
				if(j > 0 && mat[i][j-1] >= mat[i][j])stampaj = false;
				if(j < mat[i].length-1 && mat[i][j+1] >= mat[i][j])stampaj = false;
				
				if(stampaj) {
					System.out.println("(" + i + "," + j + ")");
				}
			}
		}
	}
	
	public static void zamijeniKolone(int mat[][], int r, int s) {
		for(int i = 0;i < mat[r].length;i++) {
			int temp = mat[i][r];
			mat[i][r] = mat[i][s];
			mat[i][s] = temp;
		}
	}
	
	public static boolean simetricna(int mat[][]) {
		for(int i = 0;i < mat.length-1;i++) {
			for(int j = i+1;j < mat[i].length;j++) {
				if(mat[i][j] != mat[j][i]) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean toplicova(int mat[][]) {
		for(int i = 1;i < mat.length;i++) {
			for(int j = 1;j < mat[i].length;j++) {
				if(mat[i][j] != mat[i-1][j-1])return false;
			}
		}
		return true;
	}
	
	public static void rotiraj(int mat[][]) {
		for(int j = 0;j < mat.length;j++) {
			for(int i = mat.length-1;i >= 0;i--) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static int[][] popuniMatricu1(int m, int n, int k){
		int [][]mat = new int[m][n];
		Random rand = new Random();
	    for(int i = 0;i < m;i++) {
	    	for(int j = 0;j < n;j++) {
	    	    mat[i][j] = rand.nextInt((2*k) + 1) -k;
	    	}
	    }
		return mat;
	}
	
	public static int[][] popuniMatricu2(int n){
		int [][]mat = new int[n][n];
	    for(int i = 0;i < n;i++) {
	    	int cur = i+1;
	    	for(int j = 0;j < n;j++) {
	    		mat[i][j] = cur;
	    		cur %= 4;
	    		cur++;
	    	}
	    }
		return mat;
	}
	
	public static int[][] popuniMatricu3(int m,int n){
		int [][]mat = new int[m][n];
		int cur = 1;
	    for(int k = 0;k < (m+1)/2 && k < (n+1)/2;k++) {
	    	int i = k;
	    	int j = i;
	    	while(j+1 <= n-k && cur <= n*m) {
	    		mat[i][j] = cur;
	    		cur++;
	    		j++;
	    	}
	    	j--;
	    	while(i+1 < m-k && cur <= n*m) {
	    		i++;
	    		mat[i][j] = cur;
	    		cur++;
	    	}

	    	while(j-1 >= k && cur <= n*m) {
	    		j--;
	    		mat[i][j] = cur;
	    		cur++;
	    	}
	    	while(i-1 > k && cur <= n*m) {
	    		i--;
	    		mat[i][j] = cur;
	    		cur++;
	    	}
	    }
		return mat;
	}
	
	public static int kolonaRed (int mat[][]){
		for(int i = 0;i < mat.length;i++) {
			int mini = 0;
			boolean dva = false;
			for(int j = 1;j < mat[i].length;j++) {
				if(mat[i][j] < mat[i][mini]) {
					mini = j;
					dva = false;
				}else if(mat[i][j] == mat[i][mini]) {
					dva = true;
				}
			}
			if(dva)continue;
			boolean stampaj = true;
			for(int i2 = 0;i2 < mat.length;i2++) {
				if(i2 == i)continue;
				if(mat[i2][mini] >= mat[i][mini]) {
					stampaj = false;
					break;
				}
			}
			if(stampaj)return mat[i][mini];
		}
		return -1;
	}
	
	public static int server (int mat[][]) {
		boolean vis[][] = new boolean[mat.length][mat[0].length];
		int res = 0;
		for(int i = 0;i < mat.length;i++) {
			int count = 0;
			int ind1 = 0;
			for(int j = 0;j < mat[i].length;j++) {
				if(mat[i][j] == 1) {
					count++;
					if(count == 1) {
						ind1 = j;
					}else {
						vis[i][j] = true;
						vis[i][ind1] = true;
					}
				}
			}
		}
		for(int j = 0;j < mat[0].length;j++) {
			int count = 0;
			int ind1 = 0;
			for(int i = 0;i < mat.length;i++) {
				if(mat[i][j] == 1) {
					count++;
					if(count == 1) {
						ind1 = i;
					}else {
						vis[i][j] = true;
						vis[ind1][j] = true;
					}
				}
			}
		}
		for(int i = 0;i < mat.length;i++) {
			for(int j = 0;j < mat[i].length;j++) {
				if(vis[i][j])res++;
			}
		}
		return res;
	}
	
	public static void jedini(int mat[][]) {
		for(int i = 0;i < mat.length;i++) {
			int count = 0;
			int ind =0;
			for(int j = 0;j < mat[i].length;j++) {
				if(mat[i][j] == 1) {
					count++;
					ind = j;
				}
			}
			if(count == 1) {
				boolean stampaj = true;
				for(int i2 = 0;i2 < mat.length;i2++) {
					if(i2 == i)continue;
					if(mat[i2][ind] == 1) {
						stampaj = false;
						break;
					}
				}
				if(stampaj)System.out.println("(" + i + "," + ind + ")");
			}
		}
	}
	
	public static boolean validna (int mat[][]) {
		for(int i = 0;i < mat.length;i++) {
			boolean vis[] = new boolean [mat.length];
			for(int j = 0;j < mat.length;j++) {
				if(mat[i][j]-1 < 0 || mat[i][j]-1 > mat.length || vis[mat[i][j]-1])return false;
				vis[mat[i][j]-1] = true;
			}
		}
		for(int j = 0;j < mat.length;j++) {
			boolean vis[] = new boolean [mat.length];
			for(int i = 0;i < mat.length;i++) {
				if(mat[i][j]-1 < 0 || mat[i][j]-1 > mat.length || vis[mat[i][j]-1])return false;
				vis[mat[i][j]-1] = true;
			}
		}
		return true;
	}
	
	public static void filter(int[][] slika, int k) {
		int prefix2D[][] = new int[slika.length+1][slika[0].length+1];
		for(int i = 1;i < slika.length+1;i++) {
			for(int j = 1;j < slika[0].length+1;j++) {
				prefix2D[i][j] = slika[i-1][j-1] + prefix2D[i-1][j] + prefix2D[i][j-1] - prefix2D[i-1][j-1];
			}
		}
		for(int i = k;i < prefix2D.length;i++) {
			for(int j = k;j < prefix2D[0].length;j++) {
				System.out.print((prefix2D[i][j] + prefix2D[i-k][j-k] - prefix2D[i-k][j] - prefix2D[i][j-k])/(k*k));
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
	public static int[][] pomnozi(int a[][], int b[][]){
		int mat[][] = new int[a.length][b[0].length];
		
		for(int i = 0;i < a.length;i++) {
			for(int j = 0;j < b[0].length;j++) {
				int sum = 0;
				for(int k = 0;k < b.length;k++) {
					sum += a[i][k] * b[k][j];
				}
				mat[i][j] = sum;
			}
		}
		return mat;
	}
	
	public static void dijagonala(int mat[][]) {
		int i = 0;
		int j = 0;
		System.out.print(mat[0][0] + " ");
		int cur = 1;
	    while(cur < mat.length*mat.length) {
			if(j + 1 < mat.length) {
				j++;
			}else {
				i++;
			}
			while(i < mat.length && j >= 0) {
				System.out.print(mat[i][j] + " ");
				cur++;
				i++;
				j--;
			}
			i--;
			j++;
			if(i+1 < mat.length) {
				i++;
			}else {
				j++;
			}
			while(i >= 0 && j < mat.length){
				System.out.print(mat[i][j] + " ");
				cur++;
				j++;
				i--;
			}
			j--;
			i++;
		}
	}
	
	public static void lift(int mat[][],int z) {
		int n = mat.length;
		int k = mat[0].length;
		int sum = 0;
		for(int i = 0;i < n;i++) {
			for(int j = 0;j < k;j++) {
				sum += (i+1)*mat[i][j];
			}
		}
		float def = (z*1.0f)/sum;
		for(int i = 0;i < n;i++) {
			for(int j = 0;j < k;j++) {
				System.out.print(mat[i][j]*(i+1)*def + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int mat1[][] = {{1,2,3},{4,5,6},{7,8,9}};
		int mat2[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
	}

}
