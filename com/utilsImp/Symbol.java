package com.utilsImp;

import java.util.EnumSet;

/**
 * @projectName: data-structure-test
 * @package: com.utilsImp
 * @className: Symbol
 * @author: Zhou xiang
 * @description: 符号类，用以定义所有运算符
 * @date: 2023/1/18 21:00
 * @version: 1.0
 */
public enum Symbol {
    ADD(1, '+'),
    SUBTRACTION(1, '-'),
    MULTIPLE(2, '*'),
    DIVISION(2, '/'),
    LP(0, '('),
    RP(0, ')')
    ;

    private final int priority;
    private final char symbol;

    private Symbol(int priority, char symbol){
        this.priority = priority;
        this.symbol = symbol;
    }

    public int getPriority() {
        return priority;
    }

    public char getSymbol() {
        return symbol;
    }

    /**
     * @param symbol: 所给的符号字符
     * @return Symbol 返回的符号
     * @author ZhouXiang
     * @description 根据所给的符号，返回符号实例，若无定义则为null
     * @exception 无
     */
    public static Symbol getSymbol(char symbol){
        EnumSet<Symbol> allSymbol = EnumSet.allOf(Symbol.class);
        for (Symbol s : allSymbol){
            if(s.getSymbol() == symbol){
                return s;
            }
        }

        return null;
    }

    /**
     * @param left: 左操作数
     * @param right: 右操作数
     * @return int 计算结果
     * @author ZhouXiang
     * @description 二元运算符的计算
     * @exception 非二元运算符不能使用该方法
     */
    public int calculate(int left, int right) throws Exception{
        switch (this){
            case ADD:
                return left + right;
            case SUBTRACTION:
                return left - right;
            case MULTIPLE:
                return left * right;
            case DIVISION:
                return left / right;
            default:
                throw new Exception("非二元操作符无法计算");
        }
    }
}
