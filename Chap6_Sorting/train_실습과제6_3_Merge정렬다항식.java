package Chap6_Sorting;
/*
 * 6장 구현과제3
 */

class Polynomial3 implements Comparable<Polynomial3>{
    double coef;           // 계수
    int    exp;            // 지수

    Polynomial3(){}
    //--- 생성자(constructor) ---//
    Polynomial3(double coef, int exp) {
        this.coef = coef;  this.exp = exp; 
    }
	@Override
	public int compareTo(Polynomial3 o) {
		return exp == o.exp ? 0 : exp > o.exp ? 1 : -1;
	} 
}
public class train_실습과제6_3_Merge정렬다항식 {

	static void merge(Polynomial3[] a, int lefta, int righta, int leftb, int rightb ) {
		Polynomial3 temp[] = new Polynomial3[30];
		//구현코드
		int la = lefta;
		int lb = leftb;
		int x = 0;
		while(la <= righta && lb <= rightb) {
			if(a[la].compareTo(a[lb]) > 0) temp[x++] = a[la++];
			else temp[x++] = a[lb++];
		}		
		while(la <= righta) temp[x++] = a[la++];
		while(lb <= rightb) temp[x++] = a[lb++];
		
		for(int i = 0 ; i < x ; i++) {
			a[lefta+i] = temp[i];
		}	
		
	}

	// --- 퀵 정렬(비재귀 버전)---//
	static void MergeSort(Polynomial3[] a, int left, int right) {
		int mid = (left+right)/2;
		if (left == right) return;
		MergeSort(a, left, mid);
		MergeSort(a, mid+1, right);
		merge(a, left, mid, mid+1, right);
		return;
	}
	static void ShowPolynomial(String str, Polynomial3[] x, int count) {
	
		int n = 0;
		if (count < 0)
			n = x.length;
		else
			n = count;
		System.out.print(str);
		for(int i = 0 ; i < n-1 ; i++) {
			System.out.print(x[i].coef + "x**" + x[i].exp + " + ");		
		}
		System.out.println(x[n-1].coef + "x**" + x[n-1].exp);		
	}
	static int AddPolynomial(Polynomial3[]x,Polynomial3[]y,Polynomial3[]z) {		
		int p=0,q=0,r=0;
		int terms = 0;
		//구현코드
		while(p <= x.length-1 && q <= y.length-1) {
			if(x[p].compareTo(y[q]) > 0) {
				z[r++] = x[p++];
				terms++;
			}
			else if(x[p].compareTo(y[q]) < 0) {
				z[r++] = y[q++];
				terms++;
			}
			else {
				z[r] = new Polynomial3(x[p].coef,x[p].exp);
				p++;
				z[r++].coef += y[q++].coef;
				terms++;
			}
		}
		
		while(p <= x.length-1) {
			z[r++] = x[p++];
			terms++;
		}
		while(q <= y.length-1) {
			z[r++] = y[q++];
			terms++;
		}
		return terms;
	}
	static int addTerm(Polynomial3[]z, Polynomial3 term, int terms) {
		//구현코드
		for(int i = 0 ; i < terms ; i++) {
			if(z[i].compareTo(term) == 0) {
				z[i].coef += term.coef;
				return terms;
			}
		}
		z[terms] = term;
		return ++terms;
			
	}
	static int MultiplyPolynomial(Polynomial3[]x,Polynomial3[]y,Polynomial3[]z) {
		int p=0,q=0,r=0;
		int terms = 0;
		Polynomial3 term;
		//구현코드
		for(int i = 0 ; i < x.length ; i++) {
			for(int j = 0 ; j < y.length ; j++) {
				term = new Polynomial3(x[i].coef * y[j].coef,x[i].exp+ y[j].exp);
				terms = addTerm(z,term,terms);
			}
		}
		return terms;
	}
	static double EvaluatePolynomial(Polynomial3[]z, int zTerms, int value) {
		//zTerms는 다항식 z의 항의 수, value는 f(x)를 계산하기 위한 x 값
		//다항식 계산 결과를 double로 리턴한다 
		double result = 0.0;
		//구현 코드
		for(int i = 0 ; i < zTerms ; i++) {
			result += Math.pow(value, z[i].exp) * z[i].coef;
		}	
		return result;
	}
	public static void main(String[] args) {
		Polynomial3[] x = {
		         new Polynomial3(1.5, 3),
		         new Polynomial3(2.5, 7),
		         new Polynomial3(3.3, 2),
		         new Polynomial3(4.0, 1),
		         new Polynomial3(2.2, 0),
		         new Polynomial3(3.1, 4),
		         new Polynomial3(3.8, 5),
		     };
		Polynomial3[] y = {
		         new Polynomial3(1.5, 1),
		         new Polynomial3(2.5, 2),
		         new Polynomial3(3.3, 3),
		         new Polynomial3(4.0, 0),
		         new Polynomial3(2.2, 4),
		         new Polynomial3(3.1, 5),
		         new Polynomial3(3.8, 6),
		     };
		int nx = x.length;


		ShowPolynomial("다항식 x = ", x, -1);
		ShowPolynomial("다항식 y = ", y, -1);
		MergeSort(x, 0, x.length - 1); // 배열 x를 퀵정렬
		MergeSort(y, 0, y.length - 1); // 배열 x를 퀵정렬
		ShowPolynomial("정렬후 다항식 x = ", x, -1);
		ShowPolynomial("정렬후 다항식 y = ", y, -1);
		
		Polynomial3[] z = new Polynomial3[20];
		
		for (int i =0; i < z.length; i++)
			z[i] = new Polynomial3();
	
		int zTerms = AddPolynomial(x,y,z);//다항식 덧셈 z = x + y
		ShowPolynomial("덧셈후 다항식 z = ", z, zTerms);
		
		zTerms = MultiplyPolynomial(x,y,z);//다항식 곱셈 z = x * y
		MergeSort(z, 0, zTerms-1); // 배열 x를 퀵정렬
		ShowPolynomial("곱셈후 다항식 z = ", z, zTerms);
		double result = EvaluatePolynomial(z, zTerms, 10);//다항식 값 계산 함수 z(10) 값 계산한다 
		System.out.println(" result = " + result );
	}
}