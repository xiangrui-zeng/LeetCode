package LeetCode;

import java.util.*;
import java.util.Map.Entry;

public class BoardGame {
	public static void main(String[] args) {
		
//		if (isPalindrome2(111121111)) {
//			System.out.println("true");
//		} else {
//			System.out.println("false");
//		}
//		int[] nums = {1, 0, -1, 0, -2, 2};
//		int[] nums = {0,0,0,0};
//		int[] nums = {-2,0,5,-1,-5,5,3};
//		int[] nums = {-1,2,2,-5,0,-1,4};
//		int[] nums = {0,1,5,0,1,5,5,-4};
		
//		System.out.println(result.toString());
		Scanner sc = new Scanner(System.in);
		long startTime = System.currentTimeMillis();
        String line = sc.nextLine();
		int boradWidth = Integer.parseInt(line.split(" ")[0]);
		line = sc.nextLine();
		Point p1 = new Point(Integer.parseInt(line.split(" ")[0]), Integer.parseInt(line.split(" ")[1]));
		line = sc.nextLine();
		Point p2 = new Point(Integer.parseInt(line.split(" ")[0]), Integer.parseInt(line.split(" ")[1]));
		int turn = 1;
		int route = -1;
		int step = 1;
		while(!isOver(p1, p2, turn)) {
			if (turn == 1) {
				route = firstPointDirect(p1, p2);
				p1 = movePoint(p1, route);
				turn = 2;
				step++;
			} else {
				int p2route = secondPointDirect(boradWidth, p1, p2, route);
				p2 = movePoint(p2, p2route);
				turn = 1;
			}
		}
		
		long endTime = System.currentTimeMillis();
		long duration = (endTime - startTime);
		System.out.println(step);
		System.out.println(duration + "ms");
	}
	
	//left:0
	//right:1
	//up:2
	//down:3
	//left-up:4
	//right-up:5
	//left-down:6
	//right-down:7
	public static int firstPointDirect(Point p1, Point p2) {
		if (p1.x >= p2.x) {
			if (p1.x == p2.x) {
				if (p1.y > p2.y) {
					return 2;
				} else {
					return 3;
				}
			} else {
				if (p1.y == p2.y) {
					return 0;
				} else if (p1.y > p2.y) {
					Point p = movePoint(p1, 4);
					p = movePoint(p, 4);
					if (p.x == p2.x && p.y == p2.y) {
						return 0;
					} else {
						return 4;
					}
				} else {
					Point p = movePoint(p1, 6);
					p = movePoint(p, 6);
					if (p.x == p2.x && p.y == p2.y) {
						return 0;
					} else {
						return 6;
					}
				}
			}
		} else {
			if (p1.y == p2.y) {
				return 1;
			} else if (p1.y < p2.y) {
				Point p = movePoint(p1, 7);
				p = movePoint(p, 7);
				if (p.x == p2.x && p.y == p2.y) {
					return 1;
				} else {
					return 7;
				}
			} else {
				Point p = movePoint(p1, 5);
				p = movePoint(p, 5);
				if (p.x == p2.x && p.y == p2.y) {
					return 1;
				} else {
					return 5;
				}
			}
		}
	}
	
	public static int secondPointDirect(int boradWidth, Point p1, Point p2, int route) {
		if (isValidRoute(boradWidth, p2, route, 2)) {
			return route;
		} else {
			int [] dis = new int[4];
			for(int i = 4; i <= 7; i++) {
				if(isValidRoute(boradWidth, p2, i, 2)){
					Point p = movePoint(p2, i);
					dis[i-4] = getDistance(p1, p);
				} else {
					dis[i-4] = Integer.MIN_VALUE;
				}
			}
			int maxIndex = 0;
			for(int i = 1; i < 4; i++) {
				if(dis[i] > dis[maxIndex]) {
					maxIndex = i; 
				}
			}
			
			return maxIndex + 4;
		}
	}
	
	public static boolean isOver(Point p1, Point p2, int turn) {
		if (turn == -1) return false;
		if (turn == 1) {
			if (Math.abs(p1.x - p2.x) <= 1 && Math.abs(p1.y - p2.y) <= 1) {
				return true;
			} else {
				return false;
			}
		} else {
			if (Math.abs(p1.x - p2.x) == 1 && Math.abs(p1.y - p2.y) == 1) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	public static boolean isValidRoute(int boradWidth, Point p, int route, int pointType) {
		if (route == 0) {
			if (pointType == 1) {
				if (p.x - 1 >= 0) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else if (route == 1) {
			if (pointType == 1) {
				if (p.x + 1 < boradWidth) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else if (route == 2) {
			if (pointType == 1) {
				if (p.y - 1 >= 0) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else if (route == 3) {
			if (pointType == 1) {
				if (p.y + 1 < boradWidth) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else if (route == 4) {
			if (p.y - 1 >= 0 && p.x - 1 >= 0) {
				return true;
			} else {
				return false;
			}
		} else if (route == 5) {
			if (p.x + 1 < boradWidth && p.y - 1 >= 0) {
				return true;
			} else {
				return false;
			}
		} else if (route == 6) {
			if (p.x - 1 >= 0 && p.y + 1 < boradWidth) {
				return true;
			} else {
				return false;
			}
		} else if (route == 7) {
			if (p.x + 1 < boradWidth && p.y + 1 < boradWidth) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	
	//left:0
	//right:1
	//up:2
	//down:3
	//left-up:4
	//right-up:5
	//left-down:6
	//right-down:7
	public static Point movePoint(Point p, int route) {
		Point newPoint = new Point(0,0);
		if (route == 0) {
			newPoint.x = p.x - 1;
			newPoint.y = p.y;
		} else if (route == 1) {
			newPoint.x = p.x + 1;
			newPoint.y = p.y;
		} else if (route == 2) {
			newPoint.x = p.x;
			newPoint.y = p.y - 1;
		} else if (route == 3) {
			newPoint.x = p.x;
			newPoint.y = p.y + 1;
		} else if (route == 4) {
			newPoint.x = p.x - 1;
			newPoint.y = p.y - 1;
		} else if (route == 5) {
			newPoint.x = p.x + 1;
			newPoint.y = p.y - 1;
		} else if (route == 6) {
			newPoint.x = p.x - 1;
			newPoint.y = p.y + 1;
		} else if (route == 7) {
			newPoint.x = p.x + 1;
			newPoint.y = p.y + 1;
		}
		return newPoint;
	}
	
	public static int getDistance(Point p1, Point p2) {
		int dis = 0;
		int dx = Math.abs(p1.x - p2.x);
		int dy = Math.abs(p1.y - p2.y);
		dis = Math.max(dx, dy) - 1;
		return dis;
	}
	
	//left:0
	//right:1
	//up:2
	//down:3
	//left-up:4
	//right-up:5
	//left-down:6
	//right-down:7
	public static int getValidRoute(int boradWidth, Point p1, Point p2, int pointType) {
		
		
		int route = 0;
		if (p1.x >= p2.x) {
			if (p1.x == p2.x) {
				if (p1.y > p2.y) {
					//2
					if (boradWidth - p2.x > p2.x) {
						if (isValidRoute(boradWidth, p2, 5, pointType)) {
							return 5;
						}
						if (isValidRoute(boradWidth, p2, 4, pointType)) {
							return 4;
						}
					} else {
						if (isValidRoute(boradWidth, p2, 7, pointType)) {
							return 7;
						}
						if (isValidRoute(boradWidth, p2, 6, pointType)) {
							return 6;
						}
					}
					
				} else {
					//3
					if (boradWidth - p2.x > p2.x) {
						if (isValidRoute(boradWidth, p2, 7, pointType)) {
							return 7;
						}
						if (isValidRoute(boradWidth, p2, 6, pointType)) {
							return 6;
						}
					} else {
						if (isValidRoute(boradWidth, p2, 5, pointType)) {
							return 5;
						}
						if (isValidRoute(boradWidth, p2, 4, pointType)) {
							return 4;
						}
					}
				}
			} else {
				if (p1.y == p2.y) {
					//0
					if (boradWidth - p2.y > p2.y) {
						if (isValidRoute(boradWidth, p2, 6, pointType)) {
							return 6;
						}
						if (isValidRoute(boradWidth, p2, 4, pointType)) {
							return 4;
						}
					} else {
						if (isValidRoute(boradWidth, p2, 7, pointType)) {
							return 7;
						}
						if (isValidRoute(boradWidth, p2, 5, pointType)) {
							return 5;
						}
					}
				} else if (p1.y > p2.y) {
					//4
					if (isValidRoute(boradWidth, p2, 4, pointType)) {
						return 4;
					}
					if (boradWidth - p2.x < p2.x) {
						if (isValidRoute(boradWidth, p2, 5, pointType)) {
							return 5;
						}
					} else {
						if (isValidRoute(boradWidth, p2, 6, pointType)) {
							return 6;
						}
					}
					if (isValidRoute(boradWidth, p2, 7, pointType)) {
						return 7;
					}
				} else {
					//6
					if (isValidRoute(boradWidth, p2, 6, pointType)) {
						return 6;
					}
					if (boradWidth - p2.y > p2.y) {
						if (isValidRoute(boradWidth, p2, 7, pointType)) {
							return 7;
						}
					} else {
						if (isValidRoute(boradWidth, p2, 4, pointType)) {
							return 4;
						}
					}
					
					if (isValidRoute(boradWidth, p2, 5, pointType)) {
						return 5;
					}
				}
			}
		} else {
			if (p1.y == p2.y) {
				//1
				if (boradWidth - p2.y > p2.y) {
					if (isValidRoute(boradWidth, p2, 7, pointType)) {
						return 7;
					}
					if (isValidRoute(boradWidth, p2, 5, pointType)) {
						return 5;
					}
				} else {
					if (isValidRoute(boradWidth, p2, 6, pointType)) {
						return 6;
					}
					if (isValidRoute(boradWidth, p2, 4, pointType)) {
						return 4;
					}
				}
			} else if (p1.y < p2.y) {
				//7
				if (isValidRoute(boradWidth, p2, 7, pointType)) {
					return 7;
				}
				if (boradWidth - p2.x > p2.x) {
					if (isValidRoute(boradWidth, p2, 5, pointType)) {
						return 5;
					}
				} else {
					if (isValidRoute(boradWidth, p2, 6, pointType)) {
						return 6;
					}
				}
				if (isValidRoute(boradWidth, p2, 4, pointType)) {
					return 4;
				}
			} else {
				//5
				if (isValidRoute(boradWidth, p2, 5, pointType)) {
					return 5;
				}
				if (boradWidth - p2.y > p2.y) {
					if (isValidRoute(boradWidth, p2, 7, pointType)) {
						return 7;
					}
				} else {
					if (isValidRoute(boradWidth, p2, 4, pointType)) {
						return 4;
					}
				}
				
				if (isValidRoute(boradWidth, p2, 6, pointType)) {
					return 6;
				}
			}
		}
		return -1;
		
	}
    
}




