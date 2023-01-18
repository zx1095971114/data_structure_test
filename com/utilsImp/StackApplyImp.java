package com.utilsImp;

import com.list.Stack;
import com.listImp.LinkedStack;
import com.utils.StackApply;

/**
 * @projectName: data-structure-test
 * @package: com.utilsImp
 * @className: StackApplyImp
 * @author: Zhou xiang
 * @description: 栈应用的实现
 * @date: 2023/1/18 16:46
 * @version: 1.0
 */
public class StackApplyImp implements StackApply {
    @Override
    public boolean parenthesisMatch(String flow) throws Exception {
        Stack stack = new LinkedStack();
        for(int i = 0; i < flow.length(); i++){
            char now = flow.charAt(i);
            if(now == '(' || now == '[' || now == '{'){
                stack.push(now);
            } else if (now == ')' || now == ']' || now == '}') {
                char top = (char) stack.pop();
                if(!isMatch(top, now)){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    /**
     * @param a: 要匹配的前一个字符
     * @param b: 要匹配的后一个字符
     * @return boolean 匹配为真
     * @author ZhouXiang
     * @description 判断两符号是否是匹配的括号
     * @exception 无
     */
    private boolean isMatch(char a, char b){
        return (a == '(' && b == ')') ||
                (a == '[' && b == ']') ||
                (a == '{' && b == '}');
    }

    @Override
    public String mid2Behind(String mid) throws Exception{
        StringBuffer behind = new StringBuffer("");
        Stack symbolStack = new LinkedStack();
        for (int i = 0; i < mid.length(); i++){
            char now = mid.charAt(i);
            Symbol symbol = Symbol.getSymbol(now);
            if(symbol == null){
                behind.append(now);
            } else if (symbol.equals(Symbol.LP)) {
                symbolStack.push(symbol);
            } else if (symbol.equals(Symbol.RP)) {
                Symbol s = (Symbol) symbolStack.pop();
                while (!s.equals(Symbol.LP)){
                    behind.append(s.getSymbol());
                    s = (Symbol) symbolStack.pop();
                }
            } else {
                Symbol s = null;
                while (!symbolStack.isEmpty()){
                    s = (Symbol) symbolStack.getTop();
                    if(s.getPriority() >= symbol.getPriority()){
                        symbolStack.pop();
                        behind.append(s.getSymbol());
                    } else {
                        symbolStack.push(symbol);
                        break;
                    }
                }
            }
        }

        while (!symbolStack.isEmpty()){
            Symbol s = (Symbol) symbolStack.pop();
            behind.append(s.getSymbol());
        }
        return behind.toString();
    }
}
