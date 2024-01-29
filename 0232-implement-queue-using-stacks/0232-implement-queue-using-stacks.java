class MyQueue {

Stack<Integer> s1;
Stack<Integer> s2;
public MyQueue() {
    s1 = new Stack<Integer>();
    s2 = new Stack<Integer>();
}

public void push(int x) {
    if(s1.empty())
        s1.push(x);
    else
    {
        while(! s1.empty())
        {
          s2.push(s1.pop());
        }
        s1.push(x);
        while(! s2.empty())
        {
          s1.push(s2.pop());
        }
    }   
}

public int pop() {
    int x=0;
    if(! s1.empty())
        x = s1.pop();
    
    return x;
}

public int peek() {
    int x=0;
    if(! s1.empty())
        x = s1.peek();
    
    return x;
}

public boolean empty() {
    
    if(s1.empty() && s2.empty())
        return true;
    else
        return false;
    
}
}