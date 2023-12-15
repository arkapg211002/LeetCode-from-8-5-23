class Solution {
    public String destCity(List<List<String>> paths) {
        HashMap<String,Integer>hm=new HashMap<>();
        for(int i=0;i<paths.size();i++)
        {
            hm.put(paths.get(i).get(0),0);
            hm.put(paths.get(i).get(1),0);
        }
        String key="";
        for(int i=0;i<paths.size();i++)
        {
            key=paths.get(i).get(0);
            if(hm.get(key)==0)hm.put(key,1);
            else if(hm.get(key)==1)hm.put(key,0);
            key=paths.get(i).get(1);
            if(hm.get(key)==0)hm.put(key,1);
            else if(hm.get(key)==1)hm.put(key,0);
        }
        String d="";
        for(int i=0;i<paths.size();i++)
        {
            key=paths.get(i).get(1);
            if(hm.get(key)==1)
            {
                d=key;
                break;
            }
                
        }
        return d;
    }
}