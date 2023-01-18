package com.utils;

/**
 * @projectName: data-structure-test
 * @package: com.utils
 * @className: StackApply
 * @author: Zhou xiang
 * @description: 栈的应用
 * @date: 2023/1/18 16:40
 * @version: 1.0
 */
public interface StackApply {
    /**
     * @param flow: 要判断的表达式
     * @return boolean 符合返回真
     * @author ZhouXiang
     * @description 判断该式子的括号是否符合规则
     * @exception 栈的pop抛出异常
     */
    public boolean parenthesisMatch(String flow) throws Exception;

    /**
     * @param mid: 要转换的中缀表达式
     * @return String
     * @author ZhouXiang
     * @description 中缀表达式转为后缀表达式(不保证中缀表达式本身合法),只支持+, -, *, /, (, )
     * @exception 无
     */
    public String mid2Behind(String mid) throws Exception;
}
