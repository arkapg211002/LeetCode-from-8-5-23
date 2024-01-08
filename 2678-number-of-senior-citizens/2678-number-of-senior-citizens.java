class Solution {
    public int countSeniors(String[] details) {
        int c=0;
        for(String id:details)
            if(Integer.parseInt(id.substring(11,13))>60) c+=1;
        return c;
    }
}