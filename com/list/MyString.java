package com.list;

/**
 * @projectName: data-structure-test
 * @package: com.list
 * @className: MyString
 * @author: Zhou xiang
 * @description: 串的定义(本串属于不可变的类型)
 * @date: 2023/1/19 14:22
 * @version: 1.0
 */
public interface MyString {
    /**
     * @param :
     * @return int 字符串的长度
     * @author ZhouXiang
     * @description 获取字符串长度
     * @exception 无
     */
    public int getLength();

    /**
     * @param str: 要与之比较的字符串
     * @return boolean 比要比较的字符串大为true
     * @author ZhouXiang
     * @description 判断本串是否比给定的串大
     * @exception 无
     */
    public boolean isBigger(MyString str);

    /**
     * @param start: 开始截取的位置
     * @param len: 截取的长度
     * @return MyString 截取到的字符串,原字符串不变
     * @author ZhouXiang
     * @description 从start位置开始(包括start)截取长度为len的字符串
     * @exception 截取的位置或截取的长度不合法
     */
    public MyString subString(int start, int len) throws Exception;

    /**
     * @param str: 要拼接到后面的字符串
     * @return MyString 拼接后产生的新字符串
     * @author ZhouXiang
     * @description 将字符串拼接在原有字符串后面，生成新字符串
     * @exception 无
     */
    public MyString concat(MyString str);

    /**
     * @param str: 模式串
     * @return int 返回的子串位置，若未匹配到，则返回0
     * @author ZhouXiang
     * @description 以str为模式串，对原串进行模式匹配，返回第一个子串位置(字符下标从1开始)
     * @exception 无
     */
    public int index(MyString str) throws Exception;

    /**
     * @param :
     * @return char[] MyString对应的字符数组复制
     * @author ZhouXiang
     * @description 获取MyString对应的字符数组复制
     * @exception 无
     */
    public char[] getChars();

    /**
     * @param :
     * @return void
     * @author ZhouXiang
     * @description 打印串相关信息
     * @exception 无
     */
    public void print();
}
