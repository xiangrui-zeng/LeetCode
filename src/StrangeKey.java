import java.util.ArrayList;
import java.util.Scanner;


public class StrangeKey {
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		int step = 0;
		int counter = 0;
		int tmp = 0;
		int num = 1;
		String move = "";
		ArrayList<Lattice> compareLa = new ArrayList<Lattice>();
		do{
			counter++;
			step = scanner.nextInt(); 
			if(step!=0){
				double x = 0.0;
				double y = 0.0;
				double z = 0.0;
				ArrayList<SaveStep> saveStep = new ArrayList<SaveStep>();
				Lattice lattice = new Lattice();
//				Point startPoint = new Point();
//				lattice.add(startPoint);
				for(int stringStep = 0; stringStep < step; stringStep++){
					move = scanner.next();
					if(move.equals("+x")){
						x += 1.0;
						Point tmpPoint = new Point(x-0.5,y,z);
						lattice.add(tmpPoint);
					}else if(move.equals("+y")){
						y += 1.0;
						Point tmpPoint = new Point(x,y-0.5,z);
						lattice.add(tmpPoint);
					}else if(move.equals("+z")){
						z += 1.0;
						Point tmpPoint = new Point(x,y,z-0.5);
						lattice.add(tmpPoint);
					}else if(move.equals("-x")){
						x -= 1.0;
						Point tmpPoint = new Point(x+0.5,y,z);
						lattice.add(tmpPoint);
					}else if(move.equals("-y")){
						y -= 1.0;
						Point tmpPoint = new Point(x,y+0.5,z);
						lattice.add(tmpPoint);
					}else if(move.equals("-z")){
						z -= 1.0;
						Point tmpPoint = new Point(x,y,z+0.5);
						lattice.add(tmpPoint);
					}else{
						boolean flag = true;
						for(int i = 0; i < saveStep.size(); i++){
							if(saveStep.get(i).step == Integer.parseInt(move)){
								x = saveStep.get(i).x;
								y = saveStep.get(i).y;
								z = saveStep.get(i).z;
								flag = false;
							}
						}
						if(flag){
							SaveStep tmpSave = new SaveStep(Integer.parseInt(move),x,y,z);
							saveStep.add(tmpSave);
						}
					}
				}
//				for(int i = 0; i < lattice.length; i++){
//					System.out.print(lattice.getPoint(i).x + "  ");
//					System.out.print(lattice.getPoint(i).y + "  ");
//					System.out.print(lattice.getPoint(i).z + "  ");
//				}
//				Lattice changeOrigin = new Lattice(lattice);
//				System.out.println("-------------");
//				System.out.println(changeOrigin.transformLat.size());
				compareLa.add(lattice);
				if(compareLa.size()==2){
//					System.out.println("compare");
					Lattice changeOrigin = new Lattice(compareLa.get(1));
//					for(int dd = 0;dd<changeOrigin.transformLat.size(); dd++){
//						for(int i = 0; i < changeOrigin.transformLat.get(dd).length; i++){
//							System.out.print(changeOrigin.transformLat.get(dd).getPoint(i).x + "  ");
//							System.out.print(changeOrigin.transformLat.get(dd).getPoint(i).y + "  ");
//							System.out.print(changeOrigin.transformLat.get(dd).getPoint(i).z + "  ");
//						}
//						System.out.println();
//					}
					if(compareLa.get(0).sameLattice(changeOrigin)){
//						//same
						System.out.print(num++);
						System.out.println("SAME");
					}else{
//						//diff
						System.out.print(num++);
						System.out.println("DIFFERENT");
					}
					compareLa.clear();
				}
			}
		}while(step!=0);
	}
}

class SaveStep {
	public int step;
	public double x;
	public double y;
	public double z;
	
	public SaveStep(){
		
	}
	
	public SaveStep(int step,double x,double y,double z){
		this.step = step;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void setStepPointX(double x){
		this.x = x;
	}
	
	public void setStepPointY(double y){
		this.y = y;
	}
	
	public void setStepPointZ(double z){
		this.z = z;
	}
	
	public double getStepPointX(){
		return x;
	}
	
	public double getStepPointY(){
		return y;
	}
	
	public double getStepPointZ(){
		return z;
	}
}

class Point {
	 
	public double x;
	public double y;
	public double z;

	//无参数默认原点
	public Point() {
//		this(0, 0, 0);
	}

	//构造方法指定坐标
	public Point(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public void setX(double x) {//设置x坐标
		this.x = x;
	}

	public void setY(double y) {//设置y坐标
		this.y = y;
	}

	public void setZ(double z) {//设置z坐标
		this.z = z;
	}
	 
	public void setPosition(double x, double y, double z){//一次性设置三个坐标的方法
		setX(x);
		setX(y);
		setX(z);
	}
	 
	// 计算距离 x*x + y*y+z*x，然后开平方
	public double getDistance(){
		final int square = 2;//平方
		return Math.sqrt(Math.pow(x, square) + Math.pow(y, square)+ Math.pow(z, square));
	}
	 
	public String toString(){//重写输出方法
		return "(x, y, z): " + x + "," + y + "," + z; 
	}

	//判断两点是否相等
	public boolean samePoint(Point other){
		if(this.x == other.x && this.y == other.y && this.z == other.z){
			return true;
		}else{
			return false;
		}
	}
 
}

class Lattice {
	public ArrayList<Point> lattice = new ArrayList<Point>();
	public int length = 0;
	public ArrayList<Lattice> transformLat = new ArrayList<Lattice>(); 

	//构造点集
	public Lattice() {
	
	}
	
	//构造点集
	public Lattice(Lattice la) {
		changeOrigin(la);
	}

	//添加空间点到集合
	public void add(Point p) {
		lattice.add(p);
		length ++;
	}
	
	public Point getPoint(int i){
		return lattice.get(i);
	}
	 
	//以每个点为原点进行坐标变换(旋转)
	//得到点阵个数 length * 6 个同构点阵
	public ArrayList<Lattice> transform(ArrayList<Lattice> la) {
		for(int laNum = 0; laNum < la.size(); laNum ++){
			double x = 0.0;
			double y = 0.0;
			double z = 0.0;
			for(int i = 1;i <= 24; i++){
				Lattice tmpLa = new Lattice();
				for(int j = 0; j < la.get(laNum).length; j ++){
					if(i == 1){
						x = la.get(laNum).getPoint(j).x;
						y = la.get(laNum).getPoint(j).y;
						z = la.get(laNum).getPoint(j).z;
					}else if(i == 2){
						x = la.get(laNum).getPoint(j).y;
						y = -la.get(laNum).getPoint(j).x;
						z = la.get(laNum).getPoint(j).z;
					}else if(i == 3){
						x = -la.get(laNum).getPoint(j).x;
						y = -la.get(laNum).getPoint(j).y;
						z = la.get(laNum).getPoint(j).z;
					}else if(i == 4){
						x = -la.get(laNum).getPoint(j).y;
						y = la.get(laNum).getPoint(j).x;
						z = la.get(laNum).getPoint(j).z;
					}else if(i == 5){
						x = -la.get(laNum).getPoint(j).z;
						y = la.get(laNum).getPoint(j).y;
						z = la.get(laNum).getPoint(j).x;
					}else if(i == 6){
						x = la.get(laNum).getPoint(j).y;
						y = la.get(laNum).getPoint(j).z;
						z = la.get(laNum).getPoint(j).x;
					}else if(i == 7){
						x = la.get(laNum).getPoint(j).z;
						y = -la.get(laNum).getPoint(j).y;
						z = la.get(laNum).getPoint(j).x;
					}else if(i == 8){
						x = -la.get(laNum).getPoint(j).y;
						y = -la.get(laNum).getPoint(j).z;
						z = la.get(laNum).getPoint(j).x;
					}else if(i == 9){
						x = la.get(laNum).getPoint(j).x;
						y = -la.get(laNum).getPoint(j).z;
						z = la.get(laNum).getPoint(j).y;
					}else if(i == 10){
						x = -la.get(laNum).getPoint(j).z;
						y = -la.get(laNum).getPoint(j).x;
						z = la.get(laNum).getPoint(j).y;
					}else if(i == 11){
						x = -la.get(laNum).getPoint(j).x;
						y = la.get(laNum).getPoint(j).z;
						z = la.get(laNum).getPoint(j).y;
					}else if(i == 12){
						x = la.get(laNum).getPoint(j).z;
						y = la.get(laNum).getPoint(j).x;
						z = la.get(laNum).getPoint(j).y;
					}else if(i == 13){
						x = -la.get(laNum).getPoint(j).x;
						y = la.get(laNum).getPoint(j).y;
						z = -la.get(laNum).getPoint(j).z;
					}else if(i == 14){
						x = la.get(laNum).getPoint(j).y;
						y = la.get(laNum).getPoint(j).x;
						z = -la.get(laNum).getPoint(j).z;
					}else if(i == 15){
						x = la.get(laNum).getPoint(j).x;
						y = -la.get(laNum).getPoint(j).y;
						z = -la.get(laNum).getPoint(j).z;
					}else if(i == 16){
						x = -la.get(laNum).getPoint(j).y;
						y = -la.get(laNum).getPoint(j).x;
						z = -la.get(laNum).getPoint(j).z;
					}else if(i == 17){
						x = la.get(laNum).getPoint(j).z;
						y = la.get(laNum).getPoint(j).y;
						z = -la.get(laNum).getPoint(j).x;
					}else if(i == 18){
						x = la.get(laNum).getPoint(j).y;
						y = -la.get(laNum).getPoint(j).z;
						z = -la.get(laNum).getPoint(j).x;
					}else if(i == 19){
						x = -la.get(laNum).getPoint(j).z;
						y = -la.get(laNum).getPoint(j).y;
						z = -la.get(laNum).getPoint(j).x;
					}else if(i == 20){
						x = -la.get(laNum).getPoint(j).y;
						y = la.get(laNum).getPoint(j).z;
						z = -la.get(laNum).getPoint(j).x;
					}else if(i == 21){
						x = la.get(laNum).getPoint(j).x;
						y = la.get(laNum).getPoint(j).z;
						z = -la.get(laNum).getPoint(j).y;
					}else if(i == 22){
						x = -la.get(laNum).getPoint(j).z;
						y = la.get(laNum).getPoint(j).x;
						z = -la.get(laNum).getPoint(j).y;
					}else if(i == 23){
						x = -la.get(laNum).getPoint(j).x;
						y = -la.get(laNum).getPoint(j).z;
						z = -la.get(laNum).getPoint(j).y;
					}else if(i == 24){
						x = la.get(laNum).getPoint(j).z;
						y = -la.get(laNum).getPoint(j).x;
						z = -la.get(laNum).getPoint(j).y;
					}
//					else if(i == 25){
//						x = la.get(laNum).getPoint(j).x;
//						y = -la.get(laNum).getPoint(j).y;
//						z = la.get(laNum).getPoint(j).z;
//					}else if(i == 26){
//						x = la.get(laNum).getPoint(j).y;
//						y = la.get(laNum).getPoint(j).x;
//						z = la.get(laNum).getPoint(j).z;
//					}else if(i == 27){
//						x = -la.get(laNum).getPoint(j).x;
//						y = la.get(laNum).getPoint(j).y;
//						z = la.get(laNum).getPoint(j).z;
//					}else if(i == 28){
//						x = -la.get(laNum).getPoint(j).y;
//						y = -la.get(laNum).getPoint(j).x;
//						z = la.get(laNum).getPoint(j).z;
//					}else if(i == 29){
//						x = -la.get(laNum).getPoint(j).z;
//						y = -la.get(laNum).getPoint(j).y;
//						z = la.get(laNum).getPoint(j).x;
//					}else if(i == 30){
//						x = -la.get(laNum).getPoint(j).y;
//						y = la.get(laNum).getPoint(j).z;
//						z = la.get(laNum).getPoint(j).x;
//					}else if(i == 31){
//						x = la.get(laNum).getPoint(j).z;
//						y = la.get(laNum).getPoint(j).y;
//						z = la.get(laNum).getPoint(j).x;
//					}else if(i == 32){
//						x = la.get(laNum).getPoint(j).y;
//						y = -la.get(laNum).getPoint(j).z;
//						z = la.get(laNum).getPoint(j).x;
//					}else if(i == 33){
//						x = -la.get(laNum).getPoint(j).x;
//						y = -la.get(laNum).getPoint(j).z;
//						z = la.get(laNum).getPoint(j).y;
//					}else if(i == 34){
//						x = -la.get(laNum).getPoint(j).z;
//						y = la.get(laNum).getPoint(j).x;
//						z = la.get(laNum).getPoint(j).y;
//					}else if(i == 35){
//						x = la.get(laNum).getPoint(j).x;
//						y = la.get(laNum).getPoint(j).z;
//						z = la.get(laNum).getPoint(j).y;
//					}else if(i == 36){
//						x = la.get(laNum).getPoint(j).z;
//						y = -la.get(laNum).getPoint(j).x;
//						z = la.get(laNum).getPoint(j).y;
//					}else if(i == 37){
//						x = la.get(laNum).getPoint(j).x;
//						y = la.get(laNum).getPoint(j).y;
//						z = -la.get(laNum).getPoint(j).z;
//					}else if(i == 38){
//						x = -la.get(laNum).getPoint(j).y;
//						y = la.get(laNum).getPoint(j).x;
//						z = -la.get(laNum).getPoint(j).z;
//					}else if(i == 39){
//						x = -la.get(laNum).getPoint(j).x;
//						y = -la.get(laNum).getPoint(j).y;
//						z = -la.get(laNum).getPoint(j).z;
//					}else if(i == 40){
//						x = la.get(laNum).getPoint(j).y;
//						y = -la.get(laNum).getPoint(j).x;
//						z = -la.get(laNum).getPoint(j).z;
//					}else if(i == 41){
//						x = la.get(laNum).getPoint(j).z;
//						y = -la.get(laNum).getPoint(j).y;
//						z = -la.get(laNum).getPoint(j).x;
//					}else if(i == 42){
//						x = -la.get(laNum).getPoint(j).y;
//						y = -la.get(laNum).getPoint(j).z;
//						z = -la.get(laNum).getPoint(j).x;
//					}else if(i == 43){
//						x = -la.get(laNum).getPoint(j).z;
//						y = la.get(laNum).getPoint(j).y;
//						z = -la.get(laNum).getPoint(j).x;
//					}else if(i == 44){
//						x = la.get(laNum).getPoint(j).y;
//						y = la.get(laNum).getPoint(j).z;
//						z = -la.get(laNum).getPoint(j).x;
//					}else if(i == 45){
//						x = la.get(laNum).getPoint(j).x;
//						y = -la.get(laNum).getPoint(j).z;
//						z = -la.get(laNum).getPoint(j).y;
//					}else if(i == 46){
//						x = -la.get(laNum).getPoint(j).z;
//						y = -la.get(laNum).getPoint(j).x;
//						z = -la.get(laNum).getPoint(j).y;
//					}else if(i == 47){
//						x = -la.get(laNum).getPoint(j).x;
//						y = la.get(laNum).getPoint(j).z;
//						z = -la.get(laNum).getPoint(j).y;
//					}else if(i == 48){
//						x = la.get(laNum).getPoint(j).z;
//						y = la.get(laNum).getPoint(j).x;
//						z = -la.get(laNum).getPoint(j).y;
//					}
					
					if(x == -x){
						x = 0.0;
					}
					if(y == -y){
						y = 0.0;
					}
					if(z == -z){
						z = 0.0;
					}
					Point tmpPoint = new Point(x,y,z);
					tmpLa.add(tmpPoint);
				}
				transformLat.add(tmpLa);
			}
		}
		return transformLat;
	}
	
	//根据原点变换（平移）
	public void changeOrigin(Lattice la){
		ArrayList<Lattice> transformTmp = new ArrayList<Lattice>();
		double xx = 0.0;
		double yy = 0.0;
		double zz = 0.0;
		for(int pointNum = 0; pointNum < la.length; pointNum ++){
			Lattice tmpLa = new Lattice();
			if(Math.ceil(la.getPoint(pointNum).x) == Math.floor(la.getPoint(pointNum).x)){
				xx = 0 - la.getPoint(pointNum).x;
			}else{
				if(la.getPoint(pointNum).x > 0){
					xx = -0.5 - la.getPoint(pointNum).x;
				}else{
					xx = 0.5 - la.getPoint(pointNum).x;
				}
			}
			
			if(Math.ceil(la.getPoint(pointNum).y) == Math.floor(la.getPoint(pointNum).y)){
				yy = 0 - la.getPoint(pointNum).y;
			}else{
				if(la.getPoint(pointNum).y > 0){
					yy = -0.5 - la.getPoint(pointNum).y;
				}else{
					yy = 0.5 - la.getPoint(pointNum).y;
				}
			}
			
			if(Math.ceil(la.getPoint(pointNum).z) == Math.floor(la.getPoint(pointNum).z)){
				zz = 0 - la.getPoint(pointNum).z;
			}else{
				if(la.getPoint(pointNum).z > 0){
					zz = -0.5 - la.getPoint(pointNum).z;
				}else{
					zz = 0.5 - la.getPoint(pointNum).z;
				}
			}
			
			if(pointNum == 0){
				xx = 0.0;
				yy = 0.0;
				zz = 0.0;
			}
			
			for(int j = 0; j < la.length; j ++){
				Point tmpPoint = new Point(la.getPoint(j).x + xx,la.getPoint(j).y + yy,la.getPoint(j).z + zz);
				tmpLa.add(tmpPoint);
			}
			transformTmp.add(tmpLa);
		}
		transform(transformTmp);
	}

	public boolean compare(Lattice other){
		boolean sameFlag = false;
		if(this.length != other.length){
			return false;
		}else{
			for(int j=0; j<length; j++){
				boolean pointFlag = false;
				for(int i=0;i<length;i++){
					if(lattice.get(j).samePoint(other.getPoint(i))){
						pointFlag = true;
						break;
					}
				}
				if(!pointFlag){
					return false;
				}
				sameFlag = pointFlag;
			}
			return sameFlag;
		}
	}

	//判断两个点阵是否相同是否相等
	public boolean sameLattice(Lattice other){
		for(int counter = 0; counter < other.transformLat.size(); counter++){
			if(compare(other.transformLat.get(counter))){
				return true;
			}
		}
		return false;
	}
 
}