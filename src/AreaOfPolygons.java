import java.util.ArrayList;
import java.util.Scanner;


public class AreaOfPolygons {
	public static void main(String[] args) {  
		ArrayList<Integer> xAxis = new ArrayList<Integer>();
		ArrayList<Integer> yAxis = new ArrayList<Integer>();
		ArrayList<Integer> counter = new ArrayList<Integer>();
		ArrayList<Double> result = new ArrayList<Double>();
		double area = 0.0;
		Scanner scanner = new Scanner(System.in);
		int x = 0;
		int y = 0;
		int tmp = 0;
		do{
			tmp = scanner.nextInt(); 
			counter.add(tmp);
			for(int i = 0; i < tmp; i ++){
				x = scanner.nextInt();
				xAxis.add(x);
				y = scanner.nextInt();
				yAxis.add(y);
			}
			
		}while(tmp!=0);
		int pre = 0;
		for(int j = 0; j < counter.size()-1; j++){
			area = 0.0;
			for(int i = 0; i < counter.get(j); i ++){
				if((i+1)>=counter.get(j)){
					area += (xAxis.get(i+pre) * yAxis.get(pre) - xAxis.get(pre) * yAxis.get(i+pre));
				}else{
					area += (xAxis.get(i+pre) * yAxis.get(i+1+pre) - xAxis.get(i+1+pre) * yAxis.get(i+pre));
				}
			}
			pre += counter.get(j);
			area = Math.abs(area);
			area = area /2;
			result.add(area);
		}
		
		for(int i=0;i<counter.size()-1;i++){
			System.out.print(i+1 + " ");
			System.out.println(result.get(i));
		}
	}
}
