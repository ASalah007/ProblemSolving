class Solution {
  public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        var ans = new ArrayList<StringBuilder>();
        for(int i=0; i<numRows; i++){
            ans.add(new StringBuilder());

        }
        int i=0, j=1, count =0;
        while(count<s.length()){
            ans.get(i).append(s.charAt(count));
            i+=j;
            count++;
            if(i ==0 || i==numRows - 1)
                j *= -1;
        }
        StringBuilder sb = new StringBuilder();
        for(var a : ans){
            sb.append(a);
        }
        return sb.toString();
    }
}
