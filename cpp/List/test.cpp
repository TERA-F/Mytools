#include <List.h>
#include <iostream>

using namespace std;

int main(void)
{
    List <int> a;
    cout << "test push_back 5 times: " << endl;
    for( int i = 0 ; i < 5 ; i++ )
    {
        a.push_back(i);
        cout <<"a.front():"<< a.front() << "  a.end():" << a.back() << endl;
    }
    

}
