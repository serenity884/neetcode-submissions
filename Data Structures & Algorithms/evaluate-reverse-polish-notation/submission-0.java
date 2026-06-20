class Solution {
    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        String op = "+-*/";
        for (String t : tokens) {
            if (op.indexOf(t) != -1) {
                int op2 = stack.pop();
                int op1 = stack.pop();
                int result = 0;
                if (t.equals("+")) {
                    result = op1 + op2;
                } else if (t.equals("-")) {
                    result = op1 - op2;
                } else if (t.equals("*")) {
                    result = op1 * op2;
                } else if (t.equals("/")) {
                    result = op1 / op2;
                }
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(t));
            }
        }
        return stack.isEmpty() ? -1 : stack.peek();
    }
}
