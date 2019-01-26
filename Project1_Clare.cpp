
#include <iostream> 

//CS255C Clare 1/23/2019

int main(){
	int num1 = 0;
	int num2 = 0;
	int num3 = 0;
	int min = 0;
	int max = 0;//define variables
	std::cout << "input three different integers:";
	std::cin >> num1;
	std::cin >> num2;
	std::cin >> num3;//get input from user
	int sum = num1 + num2 + num3;
	double avg = sum / 3.0;
	int product = num1 * num2*num3;//calculate the sum, average and product.
	
	if (num1 < num2)
		min = num1;
	else
		min=num2;
	if (min > num3)
		min = num3;//find the minimum number


	if (num1 > num2)
		max = num1;
	else
		max = num2;
	if (max < num3)
		max = num3;//find the maximum number
		
	std::cout << "Sum is " <<sum << std::endl;
	std::cout << "Average is " <<avg<< std::endl;
	std::cout << "Product is " <<product<< std::endl;
	std::cout << "Smallest is " <<min<< std::endl;
	std::cout << "Largest is " <<max<< std::endl;//show the result
	
	system("pause");
	return 0;

} 
