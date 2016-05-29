#include <iostream>
#include "DoubleList.h"

using namespace std;
using namespace mydatastructure;

int main()
{
	doubleList<int> list1;
	list1.push_back(1);
	list1.push_back(2);
	list1.push_back(3);
	list1.push_back(4);
	list1.push_front(5);
	list1.push_front(6);
	list1.push_front(7);
	list1.push_front(8);
	list1.pop_back();
	list1.pop_back();
	list1.pop_front();
	list1.pop_front();

}
