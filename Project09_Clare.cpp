//CS255C program09 Clare(Mingyang) 3/20/19
//The point class, and its subclasses which use to create shapes by entering some of the points and lengths: Quadrilateral, Trapezoid, Parallelogram, Rectangle, Square. 
//These 6 classes are in a tree structure:
//Point->Rect->Square,  Point->Trap->Par,  Point->Quad. 
//The reason I design this tree is, a square is a special rect, and a par is a special trap.


#include <iostream>
using namespace std;
class Point {
public:
	double x, y;
	//default constructor
	Point() {

	}
	//setter
	void setPoint(double xPoint, double yPoint) {
		x = xPoint;
		y = yPoint;
	}
	//getter
	double getX() {
		return x;
	}
	double getY() {
		return y;
	}
	void print() {
		cout << "(" << this->x << "," << this->y << ")";
	}


};


class Rect : public Point {

public:
	Point p1, p2, p3, p4;
	Rect() {}
	//set the rect by adding length to x and adding heights to y
	void setRect(Point p, double l, double h) {
		p1.setPoint(p.x, p.y);
		p2.setPoint(p.x + l, p.y);
		p3.setPoint(p.x, p.y + h);
		p4.setPoint(p.x + l, p.y + h);
	}
	void printR() {
		cout << "Rectangle's points: " << endl;
		p1.print();
		p2.print();
		p3.print();
		p4.print();
	}


};
class Square :public Rect {
public:


	Square() {
	}
	//square has the same length and height, so using length twice
	void setSquare(Point p, double l) {
		setRect(p, l, l);

	}
	void printS() {
		cout << "Square's points: " << endl;
		p1.print();
		p2.print();
		p3.print();
		p4.print();
	}


};

class Trap :public Point {
public:
	Point p1, p2, p3, p4;
	Trap() {}
	//set the trap by adding first length to first x and adding second length to second x.
	void setTrap(Point a, Point b, double len1, double len2) {
		p1.setPoint(a.x, a.y);
		p2.setPoint(a.x + len1, a.y);
		p3.setPoint(b.x, b.y);
		p4.setPoint(b.x + len2, b.y);
	}
	void printT() {
		cout << "Trapezoid's points: " << endl;
		p1.print();
		p2.print();
		p3.print();
		p4.print();
	}
};
class Par :public Trap {
public:
	Par() {}
	//par has the same lengths, so using length twice
	void setPar(Point a, Point b, double l) {
		setTrap(a, b, l, l);
	}
	void printP() {
		cout << "Parallelogram's points: " << endl;
		p1.print();
		p2.print();
		p3.print();
		p4.print();
	}

};
class Quad :public Point {
public:
	Point p1, p2, p3, p4;
	Quad() {}
	//quad is irregular, so all the four points need to know
	void setQuad(Point a, Point b, Point c, Point d) {
		p1 = a;
		p2 = b;
		p3 = c;
		p4 = d;
	}
	void printQ() {
		cout << "Quadrilateral's points: " << endl;
		p1.print();
		p2.print();
		p3.print();
		p4.print();
	}

};
int main() {
L1:Point p1, p2, p3, p4;
	Square s;
	Rect r;
	Par p;
	Quad q;
	Trap t;//initialize the points and shapes
	char command;//choose shape by enter the letter
	cout << "What shape would you like to create?" << endl;
	cout << "(p = parallelogram, q = quadrilateral, r = rectangle, s = square, or t = trapezoid)" << endl;
	cin >> command;
	switch (command)
	{
	case 's':
		double x1, y1, len1;
		cout << "Square selected" << endl;
		cout << "Enter point:" << endl;
		cin >> x1;
		cin >> y1;
		cout << "Enter length:" << endl;
		cin >> len1;
		p1.setPoint(x1, y1);
		s.setSquare(p1, len1);
		s.printS();
		cout << endl;
		break;
	case 'r':
		double x2, y2, height2, len2;
		cout << "Rectangle selected" << endl;
		cout << "Enter point:" << endl;
		cin >> x2;
		cin >> y2;
		cout << "Enter length:" << endl;
		cin >> len2;
		cout << "Enter height:" << endl;
		cin >> height2;
		p1.setPoint(x2, y2);
		r.setRect(p1, len2, height2);
		r.printR();
		cout << endl;
		break;
	case 'p':
		double x3, y3, x4, y4, len3;
		cout << "Parallelogram selected" << endl;
		cout << "Enter first point:" << endl;
		cin >> x3;
		cin >> y3;
		cout << "Enter second point:" << endl;
		cin >> x4;
		cin >> y4;
		cout << "Enter length:" << endl;
		cin >> len3;
		p1.setPoint(x3, y3);
		p2.setPoint(x4, y4);
		p.setPar(p1, p2, len3);
		p.printP();
		cout << endl;
		break;
	case 't':
		double x5, y5, x6, y6, len5, len6;
		cout << "Trapezoid selected" << endl;
		cout << "Enter first point:" << endl;
		cin >> x5;
		cin >> y5;
		cout << "Enter second point:" << endl;
		cin >> x6;
		cin >> y6;
		cout << "Enter length:" << endl;
		cin >> len5;
		cout << "Enter another length:" << endl;
		cin >> len6;;
		p1.setPoint(x5, y5);
		p2.setPoint(x6, y6);
		t.setTrap(p1, p2, len5, len6);
		t.printT();
		cout << endl;
		break;
	case 'q':
		double x7, x8, x9, x10, y7, y8, y9, y10;
		cout << "Quadrilateral selected" << endl;
		cout << "Enter first point:" << endl;
		cin >> x7;
		cin >> y7;
		cout << "Enter second point:" << endl;
		cin >> x8;
		cin >> y8;
		cout << "Enter third point:" << endl;
		cin >> x9;
		cin >> y9;
		cout << "Enter fourth point:" << endl;
		cin >> x10;
		cin >> y10;
		p1.setPoint(x7, y7);
		p2.setPoint(x8, y8);
		p3.setPoint(x9, y9);
		p4.setPoint(x10, y10);
		q.setQuad(p1, p2, p3, p4);
		q.printQ();
		cout << endl;
		break;
	default:
		break;
	}
	cout << "Would you like to enter another shape ? (y / n)" << endl;
	char yn;
	cin >> yn;
	if (yn == 'y') { goto L1; }
	system("pause");
}
/*Sample interaction:
What shape would you like to create?
(p = parallelogram, q = quadrilateral, r = rectangle, s = square, or t = trapezoid)
p
Parallelogram selected
Enter first point:
7 9
Enter second point:
3 10
Enter length:
5
Parallelogram's points:
(7,9)(12,9)(3,10)(8,10)Would you like to enter another shape ? (y / n)
y
What shape would you like to create?
(p = parallelogram, q = quadrilateral, r = rectangle, s = square, or t = trapezoid)
q
Quadrilateral selected
Enter first point:
2.4 6.3
Enter second point:
1.333 0.667
Enter third point:
8 5
Enter fourth point:
12 12
Quadrilateral's points:
(2.4,6.3)(1.333,0.667)(8,5)(12,12)
Would you like to enter another shape ? (y / n)
y
What shape would you like to create?
(p = parallelogram, q = quadrilateral, r = rectangle, s = square, or t = trapezoid)
r
Rectangle selected
Enter point:
3.6 2.5
Enter length:
1.78
Enter height:
1.34
Rectangle's points:
(3.6,2.5)(5.38,2.5)(3.6,3.84)(5.38,3.84)
Would you like to enter another shape ? (y / n)
y
What shape would you like to create?
(p = parallelogram, q = quadrilateral, r = rectangle, s = square, or t = trapezoid)
s
Square selected
Enter point:
8 8
Enter length:
14
Square's points:
(8,8)(22,8)(8,22)(22,22)
Would you like to enter another shape ? (y / n)
y
What shape would you like to create?
(p = parallelogram, q = quadrilateral, r = rectangle, s = square, or t = trapezoid)
t
Trapezoid selected
Enter first point:
100 200
Enter second point:
175 165
Enter length:
124
Enter another length:
111
Trapezoid's points:
(100,200)(224,200)(175,165)(286,165)
Would you like to enter another shape ? (y / n)
n
*/