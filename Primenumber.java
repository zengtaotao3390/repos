package test;
import java.util.*;

public class Primenumber {

	public static void main(String[] args) {
		Primenumber pn = new Primenumber();
		pn.getPrimeNumber();
	}
	/**
	 * 将一个整数分解为多个素数的积，得到这个素数集合，当当前整数是素数是，结果为本身
	 */
	private void getPrimeNumber(){
		Scanner in = new Scanner(System.in);
		// 获取输入的整数
		long inNum = in.nextLong();
		// 用于循环
		long i = 2;
		// 用于存储结果集合
		ArrayList<Long> list = new ArrayList<Long>();
		long temp = 0;
		while(i <= inNum ){
			temp = inNum % i;
			if(temp == 0) {
				inNum = inNum / i;
				list.add(i);
			}else{
				i++;
			}
		}
		for(int j = 0; j < list.size(); j++) {
			System.out.println(list.get(j));
		}
	}
}
