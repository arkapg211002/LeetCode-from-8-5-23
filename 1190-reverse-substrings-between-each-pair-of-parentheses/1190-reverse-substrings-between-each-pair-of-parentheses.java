class Solution {
    public String reverseParentheses(String s) {
    Stack<Character> stack = new Stack<>();

    for (char symbol : s.toCharArray()) {
      if (symbol == ')')
        reverseLast(stack);
      else
        stack.push(symbol);
    }

    return stackToString(stack);
  }

  private void reverseLast(Stack<Character> stack) {
    StringBuilder reversed = new StringBuilder();
    while (!stack.isEmpty() && stack.peek() != '(') 
      reversed.append(stack.pop());

    stack.pop();

    for (char symbol : reversed.toString().toCharArray()) 
      stack.push(symbol);
  }

  private String stackToString(Stack<Character> stack) {
    StringBuilder result = new StringBuilder();
    
    while (!stack.isEmpty()) 
      result.insert(0, stack.pop());

    return result.toString();
  }
}