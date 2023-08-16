class Solution {
    public List<String> braceExpansionII(String A) {
        Deque<Set<String>> stack = new ArrayDeque<>();
        Deque<Character> opStack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int[] order = new int[128];
        order['x']=1; // cross product has a higher precedence, implying order[',']=0

        for (int i = 0; i < A.length(); i++){
            char ch = A.charAt(i);
            switch(ch){
                case '{' -> { addWord(sb, stack); opStack.push(ch);}
                case ',' -> { process(ch, opStack, stack, order, sb); opStack.push(ch);}
                case '}' -> { process(ch, opStack, stack, order, sb); opStack.pop();}
                default  -> { sb.append(ch);}
            }
            if (i<A.length()-1&&isCrossProduct(ch, A.charAt(i+1))){
                process('x', opStack, stack, order, sb);
                opStack.push('x');
            }
        }

        process('.', opStack, stack, order, sb); // . is just a filler, it was chosen because it has a precendence of 0
        List<String> ans = new ArrayList<>(stack.pop());
        Collections.sort(ans);
        return ans;
    }

    private boolean isCrossProduct(char a, char b){
        return Character.isLetter(a) && b == '{'
            || a == '}' && (b == '{' || Character.isLetter(b));
    }

    private void addWord(StringBuilder sb, Deque<Set<String>> stack){
        if (sb.length()>0){
            stack.push(new HashSet<>(Set.of(sb.toString())));
            sb.setLength(0);
        }
    }

    private void process(char op, Deque<Character> opStack, Deque<Set<String>> stack, int[] order, StringBuilder sb){
        addWord(sb, stack);
        while(!opStack.isEmpty() && opStack.peek()!='{' && order[opStack.peek()]>=order[op]){
            if (opStack.pop()=='x'){ // cross product
                Set<String> a = stack.pop();
                Set<String> b = stack.pop();
                Set<String> c = new HashSet<>();
                for (String aa : a){
                    for (String bb : b){
                        c.add(bb+aa);
                    }
                }
                stack.push(c);
            }else{ // merge (addition)
                Set<String> a = stack.pop();
                stack.peek().addAll(a);
            }
        }
    }
}