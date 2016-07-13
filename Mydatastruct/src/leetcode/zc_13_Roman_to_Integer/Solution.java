class Solution {
public:
    int romanToInt(string s) {
        if(s.size() == 0)
            return 0;
        int result=0;
        for(char c:s)
        {
            switch(c)
            {
            case 'I':
                result += 1;
                break;
            case 'V':
                result += 5;
                break;
            case 'X':
                result += 10;
                break;
            case 'L':
                result += 50;
                break;
            case 'C':
                result += 100;
                break;
            case 'D':
                result += 500;
                break;
            case 'M':
                result += 1000;
                break;
            }
        }
        for(int i = 0 ; i < s.length()-1; i++)
        {
            if((s.at(i)=='I')&(s.at(i+1)=='V'|s.at(i+1)=='X'|s.at(i+1)=='L'|s.at(i+1)=='C'|s.at(i+1)=='D'|s.at(i+1)=='M'))
                result -=2;
            if((s.at(i)=='V')&(s.at(i+1)=='X'|s.at(i+1)=='L'|s.at(i+1)=='C'|s.at(i+1)=='D'|s.at(i+1)=='M'))
                result -=10;
            if((s.at(i)=='X')&(s.at(i+1)=='L'|s.at(i+1)=='C'|s.at(i+1)=='D'|s.at(i+1)=='M'))
                result -=20;
            if((s.at(i)=='L')&(s.at(i+1)=='C'|s.at(i+1)=='D'|s.at(i+1)=='M'))
                result -=100;
            if((s.at(i)=='C')&(s.at(i+1)=='D'|s.at(i+1)=='M'))
                result -=200;
            if((s.at(i)=='D')&(s.at(i+1)=='M'))
                result -=1000;
        }
        return result;
    }
};