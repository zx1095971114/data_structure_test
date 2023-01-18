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
}
