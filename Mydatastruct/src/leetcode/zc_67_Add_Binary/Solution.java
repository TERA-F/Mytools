public class Solution {
    public String addBinary(String a, String b) {
		if(a.length()<b.length())return addBinary(b,a);
		
		char[] arA=a.toCharArray();
		char[] arB=b.toCharArray();
		char[] arC=new char[a.length()+1];
		
		int i=a.length()-1;
		int j=b.length()-1;
		int carry=0;
		int tempSum=0;
		while(i>=0){
		    if(j>=0){
		        tempSum=arA[i]-'0'+arB[j]-'0'+carry;
		        --j;
		    }
		    else{
		        tempSum=arA[i]-'0'+carry;
		    }
		    carry=tempSum/2;
		    arC[i+1]=(char)(tempSum%2+48);
		    --i;
		}
		arC[i+1]='1';
		
		if(carry>0){ 
		    return String.valueOf(arC);
		}
		else{
		    return String.valueOf(arC).substring(1,a.length()+1);
		}
    }
}
