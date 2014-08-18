
public class SelecetSort {

	/**
	 * 选择排序，每次找到最小的，放到其正确位置
	 * @param args
	 */
	private static void selectSort(int[] source){
		for(int i=0;i<source.length;i++){
			for(int j=i;j<source.length;j++){
				if(source[i]>source[j]){
					swamp(source, i, j);
				}
			}
		}
	}
	public static void swamp(int[] a,int x,int y){
		int temp=a[x];
		a[x]=a[y];
		a[y]=temp;
	}
	public static void main(String[] args) {
		int[] a={4,3,52,5};
		selectSort(a);
		System.out.println("the result is:");
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
		// TODO Auto-generated method stub

	}

}
