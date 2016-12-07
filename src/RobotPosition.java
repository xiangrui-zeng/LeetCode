import java.util.ArrayList;
import java.util.Scanner;


public class RobotPosition {
	public static void main(String[] args) {  
		ArrayList<Integer> xAxis = new ArrayList<Integer>();
		ArrayList<Integer> yAxis = new ArrayList<Integer>();
//		ArrayList<Integer> counter = new ArrayList<Integer>();
		ArrayList<String> input = new ArrayList<String>();
		ArrayList<Integer> inputNum = new ArrayList<Integer>();
		Scanner scanner = new Scanner(System.in);
		int xStep = 0;
		int yStep = 0;
		int counter = 0;
		int tmp = 0;
		String stop = "";
		do{
			counter++;
			xStep = scanner.nextInt(); 
			if(xStep!=0){
				xAxis.add(xStep);
			}
			yStep = scanner.nextInt(); 
			if(yStep!=0){
				yAxis.add(yStep);
			}
			if(xStep!=0&&yStep!=0){
				do{
					stop = scanner.next();
					input.add(stop);
					if(stop.equals("FORWARD") || stop.equals("BACKWARD")){
						tmp = scanner.nextInt();
						inputNum.add(tmp);
					}
				}while(!stop.equals("STOP"));
			}
			
		}while(xStep!=0&&yStep!=0);
		
		//caculator
		int j = 0;
		tmp = 0;
		for(int i=0;i<counter-1;i++){
			int x = 1;
			int y = 1;
			int direction = 1;
			int face = 1;
			for(; j< input.size();j++){
				if(input.get(j).equals("STOP")){
					System.out.print(x + " ");
					System.out.println(y);
					break;
				}
				if(input.get(j).equals("RIGHT")){
					direction ++;
					if(direction>4){
						direction = 1;
					}
				}else if(input.get(j).equals("LEFT")){
					direction --;
					if(direction<1){
						direction = 4;
					}
				}
				if(input.get(j).equals("FORWARD")){
					face = 1;
				}else if(input.get(j).equals("BACKWARD")){
					face = 2;
				}
				if(input.get(j).equals("FORWARD") || input.get(j).equals("BACKWARD")){
					if(direction == 4){
						if(face == 2){
							x += inputNum.get(tmp);
							if(x>=yAxis.get(i)){
								x = xAxis.get(i);
							}
						}else{
							x -= inputNum.get(tmp);
							if(x<=1){
								x = 1;
							}
						}
					}else if(direction == 3){
						if(face == 2){
							y += inputNum.get(tmp);
							if(y>=yAxis.get(i)){
								y = yAxis.get(i);
							}
						}else{
							y -= inputNum.get(tmp);
							if(y<=1){
								y = 1;
							}
						}
					}else if(direction == 2){
						if(face == 2){
							x -= inputNum.get(tmp);
							if(x<=1){
								x = 1;
							}
						}else{
							x += inputNum.get(tmp);
							if(x>=yAxis.get(i)){
								x = xAxis.get(i);
							}
						}
					}else{
						if(face == 2){
							y -= inputNum.get(tmp);
							if(y<=1){
								y = 1;
							}
						}else{
							y += inputNum.get(tmp);
							if(y>=yAxis.get(i)){
								y = yAxis.get(i);
							}
						}
					}
					tmp++;
				}
			}
		}
	}
}
