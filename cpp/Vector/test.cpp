#include <Vector.h>
#include <iostream>

using namespace std;

int main(void)
{
    Vector <int> a;
    cout << "push 5 number into a";
    for( int i = 0 ; i < 5 ; i++ )
    {
        a.push_back(i);
        cout << "a[" << i << "]:" << a[i] << "  size:" << a.size() << "  capacity:" << a.capacity () << endl;
    }
    //cout << "size:" << a.size() << endl;
    //cout << "capacity:" << a.capacity() << endl;
    cout << "pop back 1 number out of a";
    a.pop_back();
    cout << "size:" << a.size() << endl;
    cout << "capacity:" << a.capacity() << endl;
    cout << "display the back of a is: " << a.back() << endl;

    cout << "test resize method:a.resize(6)" << endl;
    a.resize(6);
    cout << "size:" << a.size() << endl;
    cout << "capacity:" << a.capacity() << endl;
    cout << "display the back of a is: " << a.back() << endl;
    cout << "test resize method:a.resize(3)" << endl;
    a.resize(3);
    cout << "size:" << a.size() << endl;
    cout << "capacity:" << a.capacity() << endl;
    cout << "display the back of a is: " << a.back() << endl;

    cout << "test reserve method:a.reserve(6)" << endl;
    a.reserve(6);
    cout << "size:" << a.size() << endl;
    cout << "capacity:" << a.capacity() << endl;
    cout << "display the back of a is: " << a.back() << endl;
    
    cout << "test reserve method:a.reserve(2)" << endl;
    a.reserve(2);
    cout << "size:" << a.size() << endl;
    cout << "capacity:" << a.capacity() << endl;
    cout << "display the back of a is: " << a.back() << endl;
    
    cout << "test operator= :" << endl;
    Vector <int> b;
    b = a;
    for(int i =a.size() ; i > 0 ; i --)
    {
        b.pop_back();
    }
    cout << "a.size:" << a.size() << endl;
    cout << "a.capacity:" << a.capacity() << endl;
    cout << "display the back of a is: " << a.back() << endl;
    cout << "b.size:" << b.size() << endl;
    cout << "b.capacity:" << b.capacity() << endl;
    cout << "display the back of b is: " << b.back() << endl;

    cout << "test iterator:";
    Vector<int>::iterator  pa = a.begin();
    cout << "a : ";
    for(;pa != a.end();pa++)
    {
        cout << *pa << " ";
    }
    cout << endl;

    return 1;

}
