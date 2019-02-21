#include <iostream>
#include <iomanip>
#include "mazelayout3.h"
using namespace std;
//CS255C Project04 Clare 02/06/2019
void printMaze() //a function for printing the maze
{
	for (int i = 0; i < 12; i++) {
		for (int j = 0; j < 12; j++) {
			cout << maze[i][j];
		}
		cout << endl;
	}
}
bool Solve(int r, int c)//Create a function to judge whether or not the next step is valid(is a path). 
{
	maze[r][c] = '*';//default mark the current position
	printMaze();//print the maze of each step
	if (r == endRow && c == endCol) {
		return true;//if reach the endpoint
	}
	if (maze[r][c + 1] == '.' && Solve(r, c + 1)) {
		return true;//if right path is valid
	}
	if (maze[r + 1][c] == '.' && Solve(r + 1, c)) {
		return true;//if down path is valid
	}
	if (maze[r][c - 1] == '.' && Solve(r, c - 1)) {
		return true;//if left path is valid
	}
	if (maze[r - 1][c] == '.' && Solve(r - 1, c)) {
		return true;//if up path is valid
	}
	maze[r][c] = '-';//if all the sides are invalid, then back to the turning point and mark the deadends with '-'
	return false;
}
	int main() {
		if(Solve(startRow, startCol)){
		}//iterate the function until end
		system("pause");
		return 0;
	}
