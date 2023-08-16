import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    
    class Tag {
        String name;
        int type; //0 = start, 1 = end, 2 = cdata
        int len;
        public Tag(String name, int type, int len) {
            this.name = name;
            this.type = type;
            this.len = len;
        }
        public String toString() {
            return name + " " + type + " " + len;
        }
    }
    String cdataRegEx = "<!\\[CDATA\\[.*?\\]\\]>";
    
    public boolean isValid(String code) {
        int length = code.length();
        if (code.charAt(0) != '<' || code.charAt(length - 1) != '>') {
            return false;
        }
        int left = 0;
        Deque<String> tagStack = new LinkedList<>();
        int lastTagBorder = -1;
        while (left < length) {
            if (code.charAt(left) == '<') {
                Tag tag = getTag(code, left);
                if (tag == null) {
                    System.out.println(11);
                    return false;
                }
                if (tag.type == 0) {
                    if (tagStack.size() == 0 && left != 0) {
                        return false;
                    }
                    tagStack.addFirst(tag.name);
                } else if (tag.type == 1) {
                    if (left == 0 || tagStack.size() == 0 || !tagStack.peek().equals(tag.name)) {
                        return false;
                    }
                    tagStack.pollFirst();
                    lastTagBorder = left + tag.len;
                } else if (left == 0) {
                    return false;
                }
                left += tag.len;
            } else {
                left++;
            }
        }
        return tagStack.size() == 0 && lastTagBorder == code.length();
    }
    
    private Tag getTag(String code, int left) {
        int right = left + 1, type = 0;
        if (code.charAt(right) == '/') {
            type = 1;
        } else if (code.charAt(right) == '!') {
            type = 2;
            Pattern p = Pattern.compile(cdataRegEx);
            Matcher m = p.matcher(code.substring(left));
            if (m.lookingAt()) {
                int len = m.end();
                return new Tag("", 2, len);
            } else {
                return null;
            }
        }
        if (type == 1) {
            right++;
        }    
        while (right < code.length() && code.charAt(right) != '>') {
            char c = code.charAt(right);
            if (c < 'A' || c > 'Z') {
                return null;
            }
            right++;
        }
        if (right == code.length()) {
            return null;
        }
        int nameLen = type == 1 ? right - left - 2 : right - left - 1;
        if (nameLen < 1 || nameLen > 9) {
            return null;
        }
        String name = code.substring(type == 1 ? left + 2 : left + 1, right);
        int len = right - left + 1;
        return new Tag(name, type, len);
    }
}