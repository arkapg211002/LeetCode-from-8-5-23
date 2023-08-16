class Solution {//25/5: first read 'else' and then 'else IF'....Lets solve (H2O(He2O)3)
    public String countOfAtoms(String formula) {
        int N = formula.length();
        Stack<TreeMap<String, Integer>> stack = new Stack();
        stack.push(new TreeMap());

        for (int i = 0; i < N;) {

              //for each () combination we will have a Map which will count occurances of each character
              if(formula.charAt(i) == '('){
                  stack.push(new TreeMap());
                  i++;
               }
               //(H2O(He2O)3)
               else if(formula.charAt(i) == ')'){
                 TreeMap<String, Integer> latestMap = stack.pop();//this will give [He:2,O:1]
                 int iStart = ++i;int mult = 1;
                 while(i < N &&Character.isDigit(formula.charAt(i)))
                        i++;//eXtracted 3
                 //if it was  H2O(He2O)  ...no multiplier
                 if(i > iStart)       
                    mult = Integer.parseInt(formula.substring(iStart,i));

                 //this will give previous '(' ka map... [H:2,O:1]   
                 TreeMap<String, Integer> previousMap = stack.peek(); 
                 for(String elem : latestMap.keySet()){
                   //Update previous map...Multiple latestMap elements by 3 and add merge them to previous map
                   //[H:1 He:6 O:4] ...O = 1*3(latest map) + 1(previous map)  
                   previousMap.put(elem,previousMap.getOrDefault(elem,0) + latestMap.get(elem)*mult);
 
                 }

                }else{ //Lets focus on inner elements : He2O. Outer H20 will also have similar logic
                 int iStart = i++;
                 while(i < N &&Character.isLowerCase(formula.charAt(i)))
                        i++;
                 String element = formula.substring(iStart,i);//ELEMENT extracted : He
                 iStart = i;
                 while(i < N &&Character.isDigit(formula.charAt(i)))
                        i++;

                 //i>iStart to handle O element which has no number followed, hence should be considered 1       
                 int mult = i>iStart?Integer.parseInt(formula.substring(iStart,i)):1;//number extracted : 2 
                 TreeMap<String, Integer> map = stack.peek();
                 map.put(element,map.getOrDefault(element,0) + mult); 
                 //map:[He :2]
                 //after next iteration of O, It will become [He:2,O:1]
            }
        }
        //simple, iterate and build the final string
        StringBuilder ans = new StringBuilder();
        for (String name: stack.peek().keySet()) {
            ans.append(name);
            final int count = stack.peek().get(name);
            if (count > 1) ans.append(String.valueOf(count));
        }
        return ans.toString();
    }
}