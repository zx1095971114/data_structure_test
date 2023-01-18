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
     * @exception 无
     */
    public boolean parenthesisMatch(String flow) throws Exception;
}
