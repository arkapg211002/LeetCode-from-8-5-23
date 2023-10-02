class Solution {
    public boolean winnerOfGame(String colors) {
        char[] arr = colors.toCharArray();
        int a = 0;
        int b = 0;
        int n = arr.length;
        if(n<3){
            return false;
        }
        int j = 0;
        for(int i=0;i<n;i++){
            if(arr[i]=='A'){
                int cnt = 0;
                for(j=i;j<n;j++){
                    if(arr[j]=='A'){
                        cnt++;
                    }else{
                        break;
                    }
                }
                a += Math.max(0,cnt-2);
                i = j-1;
            }
            if(arr[i]=='B'){
                int cnt = 0;
                for(j=i;j<n;j++){
                    if(arr[j]=='B'){
                        cnt++;
                    }else{
                        break;
                    }
                }
                b += Math.max(0,cnt-2);
                i = j-1;
            }
        }
        return a>b;
    }
}