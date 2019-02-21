
#include <iostream> 
#include<stdlib.h>
#include <string>
#include<time.h>
using namespace std;
//CS255C Project03 Clare 2/1/2019
//This program is a number guessing game
int main() {
L1:  srand(time(NULL));//keep the random number different in each game
	int ran = rand() % 1001;//generate a random number between 1 and 1000
	int time = 0;
	for (int i = 0; i < 1000; i++) {
		
		int num;
		cout << "Guess a number between 1 and 1, 000" << endl;
		cin >> num;//get the number from user
		if (num > ran) {
			cout << "Your guess is MORE than the numbers" << endl;
		}//when number is too large
		if (num < ran) {
			cout << "Your guess is LESS than the numbers" << endl;
		}//when number is too small
		if (num == ran) {
			cout << "Your guess is right!" << endl;
			break;
		}//when number is correct
		time++;//calculate the times
	}

		if (time < 10) {
			cout << "Either you know the secret or you got lucky!" << endl;
		}//when the user guessed the number successfully less than 10 times
		if (time == 10) {
			cout<< "Ahah! You know the secret!"<<endl;
		}//10 times
		if (time > 10) {
			cout << "You should be able to do better!" << endl;
		}//more than 10 times
		cout << "You guessed " << time << " times!" << endl;
		cout << "Would you like to play again (Y or N)?" << endl;//ask the user whether or not want to play again

		string yorn;
		cin >> yorn;
		if (yorn == "Y") {
			goto L1;//if yes, start from the beginning
		}
		else {
			return 0;//if no, terminate.
		}
	}
/*
Sample Interaction:

Guess a number between 1 and 1, 000
500
Your guess is more than the numbers
Guess a number between 1 and 1, 000
250
Your guess is less than the numbers
Guess a number between 1 and 1, 000
375
Your guess is more than the numbers
Guess a number between 1 and 1, 000
312
Your guess is more than the numbers
Guess a number between 1 and 1, 000
281
Your guess is less than the numbers
Guess a number between 1 and 1, 000
296
Your guess is less than the numbers
Guess a number between 1 and 1, 000
304
Your guess is less than the numbers
Guess a number between 1 and 1, 000
308
Your guess is more than the numbers
Guess a number between 1 and 1, 000
306
Your guess is right!
Either you know the secret or you got lucky!
You guessed 8 times!
Would you like to play again (Y or N)?
Y
Guess a number between 1 and 1, 000
333
Your guess is less than the numbers
Guess a number between 1 and 1, 000
555
Your guess is less than the numbers
Guess a number between 1 and 1, 000
700
Your guess is less than the numbers
Guess a number between 1 and 1, 000
800
Your guess is more than the numbers
Guess a number between 1 and 1, 000
733
Your guess is less than the numbers
Guess a number between 1 and 1, 000
755
Your guess is less than the numbers
Guess a number between 1 and 1, 000
770
Your guess is more than the numbers
Guess a number between 1 and 1, 000
764
Your guess is right!
Either you know the secret or you got lucky!
You guessed 7 times!
Would you like to play again (Y or N)?
N
*/
	
