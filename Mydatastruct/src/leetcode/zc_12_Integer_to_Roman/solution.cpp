class Solution {
public:
    string intToRoman(int num) {
        string result;
        int tmp;
        int table[7] = {1000,500,100,50,10,5,1};
        char chartable[7] ={'M','D','C','L','X','V','I'};
        
        tmp = num/1000;
        num = num-tmp*1000;
        while(tmp--)
            result.append("M");//'M'can't work;
        /*
        tmp = num / 500;
        num = num - tmp * 500;
        while(tmp--)
            result.append("D");
        
        for(int i = 2; i < 5; i++){
            tmp = num / table[i];
            if((num - tmp * table[i]) < (tmp))
            num = num - tmp * table[i];
            if(num < table[i+1]){
                result.append(chartable+i);
                result.append(chartable+i-1);
            }
            else{
                while(tmp--)
                result.append(chartable+i);
            }
        }
        
        while(num--)
            result.append(chartable+6);
        */
        
        tmp = num / 100;
        num = num - tmp * 100;
        switch(tmp){
            case 4:
                result.append("CD");
                break;
            case 9:
                result.append("CM");
                break;
            case 5:
            case 6:
            case 7:
            case 8:
                result.append("D");
                tmp -= 5;
            default:
                while(tmp--)
                    result.append("C");
        }
        
        tmp = num / 10;
        num = num - tmp * 10;
        switch(tmp){
            case 4:
                result.append("XL");
                break;
            case 9:
                result.append("XC");
                break;
            case 5:
            case 6:
            case 7:
            case 8:
                result.append("L");
                tmp -= 5;
            default:
                while(tmp--)
                    result.append("X");
        }
        
        tmp = num ;
        switch(tmp){
            case 4:
                result.append("IV");
                break;
            case 9:
                result.append("IX");
                break;
            case 5:
            case 6:
            case 7:
            case 8:
                result.append("V");
                tmp -= 5;
            default:
                while(tmp--)
                    result.append("I");
        }
        return result;
    }
};