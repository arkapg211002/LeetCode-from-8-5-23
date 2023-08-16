class Solution {
    boolean validate(String s, String locked, char op) {
    int bal = 0, wild = 0, sz = s.length();
    int start = op == '(' ? 0 : sz - 1, dir = op == '(' ? 1 : - 1;
    for (int i = start; i >= 0 && i < sz && wild + bal >= 0; i += dir)
        if (locked.charAt(i) == '1')
            bal += s.charAt(i) == op ? 1 : -1;
        else
            ++wild;
    return Math.abs(bal) <= wild;
}
public boolean canBeValid(String s, String locked) {
    return s.length() % 2 == 0 && validate(s, locked, '(') && validate(s, locked, ')');
}
}