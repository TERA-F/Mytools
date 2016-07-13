class Solution {
 public:
   int set_bit(string& str){
     int mybits = 0;
     for (char c : str){
       mybits |= (1 << (c-'a'));
       if ((mybits == 0x3FFFFFF)) break;
     }
     return mybits;
   }

   int maxProduct(vector<string>& words) {
     int m_val = 0, w_size = words.size();
     int m[w_size], m_w_size[w_size];

     for(int i = 0; i < w_size; i++) {
       m[i] = set_bit(words[i]);
       m_w_size[i] = words[i].size();
     }

     for (int i = 0; i < w_size; i++) 
         for (int j = i+1; j < w_size; j++) 
            if ((m[i] & m[j])==0) 
                m_val = max((int)(m_w_size[i] * m_w_size[j]), m_val);

    return m_val;
  }
};