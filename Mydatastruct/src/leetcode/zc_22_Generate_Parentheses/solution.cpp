class Solution {
public:
    vector<string> generateParenthesis(int n) {
        /*
        vector<string> retstr;
        //if(n == 0){
        //    string tmp = "";
        //    return retstr.push_back(tmp);
        //}
        string restr1 = "())";
        string restr2 = ")()";
        retstr.push_back("()");
        for(int i = 1;i<n;++i){
            int orgsize = i;
            for(int j = 0;j<orgsize;++j){
                string tmp = retstr[j];
                std::size_t found = tmp.find_first_of(")");
                cout<<"phase 1"<<endl;
                while (found!=std::string::npos)
                {
                    if(tmp.at(found-1)==')'){
                        found=retstr[j].find_first_of(")",found+1);
                        continue;
                    }
                    tmp.erase(found,1);
                    tmp.insert(found,restr1);
                    retstr.push_back(tmp);
                    cout<<")->()):  "<<tmp<<endl;
                    tmp = retstr[j];
                    found=retstr[j].find_first_of(")",found+1);
                }
                cout<<"phase 2"<<endl;
                found = tmp.find_first_of(")");
                while (found!=std::string::npos)
                {
                    if(found>2){
                        if( tmp.at(found-2)==')' ){
                            found=retstr[j].find_first_of(")",found+1);
                            continue;
                        }
                    }
                    if(tmp.at(found-1)==')'){
                            found=retstr[j].find_first_of(")",found+1);
                            continue;
                    }
                
                    tmp.erase(found,1);
                    tmp.insert(found,restr2);
                    retstr.push_back(tmp);
                    cout<<")->)():  "<<tmp<<endl;
                    tmp = retstr[j];
                    found=retstr[j].find_first_of(")",found+1);
                }
            }
            /*
            for(int j = 0;j<orgsize;++j){
                retstr.erase(retstr[j]);//wrong 
            }

            for(vector<string>::iterator itr = retstr.begin();itr != retstr.begin()+orgsize;++itr){
                cout<<"erase "<<*itr<<endl;
                retstr.erase(itr);
                
            }
            */
        /*
            retstr.erase(retstr.begin(),retstr.begin()+i);
            cout<<i<<endl;
            for(vector<string>::iterator itr = retstr.begin();itr != retstr.end();++itr){
                cout<<*itr<<", ";
            }
            cout<<endl;
        }
        return retstr;
        */
        vector<string> retstr;
        string str = "";
        if(n==0)
            return retstr;
        str.resize(2*n);
        helper(retstr,n,n,str,0);
        return retstr;
    }
    
    void helper(vector<string> & retstr, int left, int right, string & str, int position){
        if(left<0||right<left)
            return ;
        if(left==0 && right==0){
            retstr.push_back(str);
        }
        if(left>0){
            str[position]='(';
            helper(retstr,left-1,right,str,position+1);
        }
        if(right>0){
            str[position]=')';
            helper(retstr,left,right-1,str,position+1);
        }
    }
};