#include<iostream>
#include "Project08_Clare.h"
using namespace std;
int main() {
	//test 
L1:Rational r1, r2;
	int n1, d1, n2, d2;

	cout << "Enter the numerator of the first fraction: " << endl;//get first rational number from user
	cin >> n1;
	cout << "Enter the denominator of the first fraction: " << endl;
	cin >> d1;
	r1.setRational(n1, d1);
	cout << "First fraction: ";
	r1.print();
	cout << endl;

	cout << "Enter the numerator of the second fraction: " << endl;
	cin >> n2;
	cout << "Enter the denominator of the second fraction: " << endl;
	cin >> d2;
	r2.setRational(n2, d2);
	cout << "Second fraction: ";
	r2.print();
	cout << endl;

	r1.print();
	cout << " + ";
	r2.print();
	cout << " = ";
	Rational r3;
	r3 = r1 + r2;
	r3.print();
	cout << " or ";
	double f3 = 0.0;
	f3 = (r3.nume*1.0) / r3.deno;
	cout << f3 << endl;

	r1.print();
	cout << " - ";
	r2.print();
	cout << " = ";
	Rational r4;
	r4 = r1 - r2;
	r4.print();
	cout << " or ";
	double f4 = 0.0;
	f4 = (r4.nume*1.0) / r4.deno;
	cout << f4 << endl;

	r1.print();
	cout << " * ";
	r2.print();
	cout << " = ";
	Rational r5;
	r5 = r1 * r2;
	r5.print();
	cout << " or ";
	double f5 = 0.0;
	f5 = (r5.nume*1.0) / r5.deno;
	cout << f5 << endl;

	r1.print();
	cout << " / ";
	r2.print();
	cout << " = ";
	Rational r6;
	r6 = r1 / r2;
	r6.print();
	cout << " or ";
	double f6 = 0.0;
	f6 = (r6.nume*1.0) / r6.deno;
	cout << f6 << endl;

	if (r1 > r2) {
		r1.print();
		cout << " is greater than ";
		r2.print();
		cout << endl;
	}
	if (r1 < r2) {
		r1.print();
		cout << " is smaller than ";
		r2.print();
		cout << endl;
	}
	if (r1 >= r2) {
		r1.print();
		cout << " is greater or equal to ";
		r2.print();
		cout << endl;
	}
	if (r1 <= r2) {
		r1.print();
		cout << " is smaller or equal to ";
		r2.print();
		cout << endl;
	}
	if (r1 == r2) {
		r1.print();
		cout << " is equal to ";
		r2.print();
		cout << endl;
	}
	if (r1 != r2) {
		r1.print();
		cout << " is not equal to ";
		r2.print();
		cout << endl;
	}

	r1.print();
	cout << " negated is ";
	Rational r7;
	r7 = -r1;
	r7.print();
	cout << endl;

	cout << "The reciprocal of ";
	r2.print();
	cout << " is ";
	Rational r8;
	r8 = !r2;
	r8.print();
	cout << endl;

	char yn;
	cout << "Would you like to enter new rational numbers? (y/n)" << endl;
	cin >> yn;
	if (yn == 'y') {
		goto L1;
	}//ask if the user wants to enter the number again
	system("pause");
}
/*Sample interaction
Enter the numerator of the first fraction:
1
Enter the denominator of the first fraction:
7
First fraction: 1/7
Enter the numerator of the second fraction:
5
Enter the denominator of the second fraction:
8
Second fraction: 5/8
1/7 + 5/8 = 43/56 or 0.767857
1/7 - 5/8 = -27/56 or -0.482143
1/7 * 5/8 = 5/56 or 0.0892857
1/7 / 5/8 = 8/35 or 0.228571
1/7 is smaller than 5/8
1/7 is smaller or equal to 5/8
1/7 is not equal to 5/8
1/7 negated is -1/7
The reciprocal of 5/8 is 8/5
Would you like to enter new rational numbers? (y/n)
y
Enter the numerator of the first fraction:
2
Enter the denominator of the first fraction:
3
First fraction: 2/3
Enter the numerator of the second fraction:
4
Enter the denominator of the second fraction:
17
Second fraction: 4/17
2/3 + 4/17 = 46/51 or 0.901961
2/3 - 4/17 = 22/51 or 0.431373
2/3 * 4/17 = 8/51 or 0.156863
2/3 / 4/17 = 17/6 or 2.83333
2/3 is greater than 4/17
2/3 is greater or equal to 4/17
2/3 is not equal to 4/17
2/3 negated is -2/3
The reciprocal of 4/17 is 17/4
Would you like to enter new rational numbers? (y/n)
n
*/