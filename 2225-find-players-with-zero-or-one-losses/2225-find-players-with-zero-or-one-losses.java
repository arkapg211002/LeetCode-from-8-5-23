class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> resultList = new ArrayList();
		
		// TreeSet will keep items in order and avoid duplications 
        TreeSet<Integer> lostZeroMatchTreeSet = new TreeSet();
        TreeSet<Integer> lostOneMatchTreeSet =  new TreeSet();
        HashMap<Integer,Integer> losersHashMap = new HashMap();
        
        for(int [] match : matches){
            losersHashMap.put(match[0],losersHashMap.getOrDefault(match[0],0));
            losersHashMap.put(match[1],losersHashMap.getOrDefault(match[1],0)+1);
        }
        
        for(int [] match: matches){
            if(losersHashMap.get(match[0]) == 0)
              lostZeroMatchTreeSet.add(match[0]);
        
            if(losersHashMap.get(match[1]) == 1)
              lostOneMatchTreeSet.add(match[1]);
        }
        
        resultList.add(new ArrayList(lostZeroMatchTreeSet));
        resultList.add( new ArrayList(lostOneMatchTreeSet));
        
        return resultList;
    }
}