class Solution {

    public int calculate(String s) {
        var stack = new ArrayDeque<Integer>();
        var n = 0;
        var op = '+';
        
        for (var c : s.toCharArray()) {
            switch (c) {
                case '+', '-', '*', '/' -> {
                    eval(stack, n, op);
                    op = c;
                    n = 0;
                }
                case ' ' -> {}
                default -> n = n * 10 + (c - '0');
            }
        }

        // add last number
        eval(stack, n, op);

        var rez = 0;
        while (!stack.isEmpty())
            rez += stack.pop();

        return rez;
    }

    private void eval(Deque<Integer> stack, int n, char op) {
        switch (op) {
            case '-' -> stack.push(-n);
            case '*' -> stack.push(stack.pop() * n);
            case '/' -> stack.push(stack.pop() / n);
            default -> stack.push(n);
        }
    }
}