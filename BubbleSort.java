
public class BubbleSort {

	/**
	 * @param args
	 */
	static int n=1;
	public static void bubbleSort(int[] source){
		for(int i=source.length-1;i>0;i--){
			for(int j=source.length-1;j>0;j--){
			if(source[j]<source[j-1]){
				swamp(source,j,j-1);
			}
			
					
	}
			System.out.println("第 "+n+"趟排序的结果为：");
			for(int k=0;k<source.length;k++){
				
			System.out.print(source[k]);
			
		}
			n++;			
	}
		
	}
	public static void swamp(int[] source, int x, int y) {
		// TODO Auto-generated method stub
		int temp=source[x];
		source[x]=source[y];
		source[y]=temp;
		
	}
	public static void main(String[] args) {
		int[] a ={0,4,6,3,5};
		System.out.println("输入的数组为：");
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
		
		bubbleSort(a);
		System.out.println("冒泡排序后的结果为：");
		for(int i=0;i<a.length;i++){
			
			System.out.println(a[i]);
		}
		// TODO Auto-generated method stub

	}

}
