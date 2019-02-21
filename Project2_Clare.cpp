#include <iostream>
#include <iomanip>
#include<math.h>
//CS255C Project02 Clare 1/29/2019
int main() {
	int sig;//significant digits
	std::cout << "Input the significant digits or 0 to quit: ";
	std::cin >> sig;
	double delta = pow(0.1,sig);//use power to calculate the delta by significant digits
	double oldpi = 0;//the result before add first term
	double newpi = 4;//the result after add first term 
	int term = 0;//number of terms
	int deno = 1;//denominator of terms
	int sign = 1;//sign of terms
	while(abs(oldpi-newpi)>delta and sig>0) {//the loop will execute until the difference between two successive approximation is less than delta
		oldpi += (4.0 / deno)*sign;//oldpi start at the first term which is 4 
		newpi += (4.0 / (deno + 2))*(sign*-1);//newpi start at the second term which is 4-4/3
		deno += 2;//denominator will increase 2 after each calculation
		sign *= -1;//sign will change after each calculation
		term += 1;//count the number of terms
		if (term < 11) {
			std::cout << "Approximation " << term << ":" << oldpi << std::endl;//print out the first 10 approximations
		}
	}
	while (!sig <= 0) {
		std::cout.precision(10);
		std::cout << "Estimated Pi to " << sig << " significant digits is " << newpi << std::endl;
		std::cout << "Number of terms in the approximation:" << term << std::endl;//print out the results
		system("pause");
	}
	return 0;
}
/*
Sample interaction:

Input the significant digits or 0 to quit: 3
Approximation 1:4
Approximation 2:2.66667
Approximation 3:3.46667
Approximation 4:2.89524
Approximation 5:3.33968
Approximation 6:2.97605
Approximation 7:3.28374
Approximation 8:3.01707
Approximation 9:3.25237
Approximation 10:3.04184
Estimated Pi to 3 significant digits is 3.142092404
Number of terms in the approximation:2000

Estimated Pi to 6 significant digits is 3.141593154
Number of terms in the approximation:2000000

Estimated Pi to 7 significant digits is 3.141592704
Number of terms in the approximation:20000000
*/