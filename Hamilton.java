
import java.util.*;

@SuppressWarnings("unchecked")
public class Hamilton{
	public static void main(String[] args) {
		//从特定矩阵开始[1,x,1,y]

		hamil(3,10);

	}

	public static Vector create_vec(int x1,int y1,int x2,int y2){
		Vector x = new Vector(4);
		x.addElement(x1);
		x.addElement(x2);
		x.addElement(y1);
		x.addElement(y2);
		return x;

	}

	public static void hamil(int x,int y) {
		//测试矩阵
		Vector matrix = create_vec(1,2,1,2);
		printvec(matrix);
		
		/*
		matrix.addElement(1);
		matrix.addElement(x);
		matrix.addElement(1);
		matrix.addElement(y);
		

		Vector matrix2 = new Vector(4);
		matrix2.addElement(3);
		matrix2.addElement(12);
		matrix2.addElement(1);
		matrix2.addElement(6);

		Vector matrix4 = new Vector(4);
		matrix4.addElement(12);
		matrix4.addElement(20);
		matrix4.addElement(1);
		matrix4.addElement(8);

		Vector matrix5 = new Vector(4);
		matrix5.addElement(12);
		matrix5.addElement(20);
		matrix5.addElement(8);
		matrix5.addElement(10);

		Vector matrix6 = new Vector(4);
		matrix6.addElement(3);
		matrix6.addElement(12);
		matrix6.addElement(6);
		matrix6.addElement(10);

		//all matrix
		Vector matrix3 = new Vector(4);
		matrix3.addElement(matrix);
		matrix3.addElement(matrix2);
		matrix3.addElement(matrix4);
		matrix3.addElement(matrix5);
		matrix3.addElement(matrix6);
		Vector m = (Vector)matrix3.elementAt(0);
		System.out.println(m.elementAt(3));
		printvec(matrix3);
		*/
		
		Vector path = new Vector(6);

		path.addElement(matrix);

		for(int i = 0; i < matrix3.size(); i++) {
			Vector b = (Vector)matrix3.elementAt(i);
			if(adjacent(matrix,b) == 1){
				path.addElement(b);
			}
		}
		System.out.println("all adjacent matrix for initial matrix");
		printvec(path);
		for(int i = 0; i < path.size() ; i++) {
			for(int j = 0; j!=i&&j < path.size(); j++) {
			if(adjacent((Vector)path.elementAt(i),(Vector)path.elementAt(j))!=0) {
				for(int k = 0; k < matrix3.size();k++) {
					if(!path.contains(matrix3.elementAt(k))&&adjacent((Vector)path.elementAt(i),(Vector)matrix3.elementAt(k))!=0&&adjacent((Vector)path.elementAt(j),(Vector)matrix3.elementAt(k))!=0)
					{
						path.insertElementAt((Vector)matrix3.elementAt(k),i);
					}
					}
				}

			}
		}
		
		System.out.println("the hamilton path:");
		printvec(path);

		}
		



	public static void printvec(Vector A) {
		Iterator velem = A.iterator();
		while(velem.hasNext())
			System.out.println(velem.next());
	}
	
	
	public static int adjacent(Vector A,Vector B) {
		int x1,x2,x3,x4,y1,y2,y3,y4;

		x1 = (int)A.elementAt(0);
		x2 = (int)A.elementAt(1);
		y1 = (int)A.elementAt(2);
		y2 = (int)A.elementAt(3);

		x3 = (int)B.elementAt(0);
		x4 = (int)B.elementAt(1);
		y3 = (int)B.elementAt(2);
		y4 = (int)B.elementAt(3);

		if(x2 == x3 && !(y1 >= y4) && !(y2 <= y3)) {
			return 1; //right
		}
		else if(y1 == y4 && x1 <= x4 && x2 >= x3) {
			return 2; //above
		}
		else if(y2 == y3 && x3 <= x2 && x4 >= x1) {
			return 3;//below
		}
		else if(x1 == x4 && y4 <= y1 && y3 >= y2) {
			return 5;//left
		}
		else {
			return 0;
		}

	}
}

	


