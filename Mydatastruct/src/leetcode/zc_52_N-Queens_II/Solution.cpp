class Solution {
public:
    int totalNQueens(int n) {
        
        vector<vector<string>> result;
        vector<string> nowque(n,string(n,'.'));
        nqueens(result,nowque,0,n);
        return result.size();
    }
    

private:
    void nqueens(vector<vector<string>> & result,vector<string> &nowque,int row,int n)
    {
        if(row == n){
            result.push_back(nowque);
            return;
        }
        for(int col= 0; col < n; ++col)
            if(isValid(nowque,row,col,n)){
                nowque[row][col]='Q';
                nqueens(result,nowque,row+1,n);
                nowque[row][col]='.';
            }
    }

    bool isValid(vector<string> & nowque, int row, int col,int n)
    {
        for(int i = 0; i != row; ++i)
        {
            if(nowque[i][col]=='Q')
                return false;
        }
        for(int i = row - 1,j = col - 1; i >= 0 && j >= 0; --i,--j)
        {
            if(nowque[i][j]=='Q')
                return false;
        }
        int gap = row - col;
        for(int i = row - 1,j = col + 1; i >= 0 && j < n; --i,++j)
        {
            if(nowque[i][j]=='Q')
                return false;
        }
        return true;
    }
};