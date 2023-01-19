package com.listImp;

import com.list.MyString;
import com.utils.Iterator;
import com.utilsImp.IteratorImp;

/**
 * @projectName: data-structure-test
 * @package: com.listImp
 * @className: MyHString
 * @author: Zhou xiang
 * @description: 以堆分配存储的方式实现串
 * @date: 2023/1/19 14:41
 * @version: 1.0
 */
public class MyHString implements MyString {
    private final int length;
    private final char[] chars;

    public char[] getChars() {
        return chars;
    }

    @Override
    public void print() {
        Object[] newChars = new Object[length];
        for (int i = 0; i < length; i++){
            newChars[i] = chars[i + 1];
        }
        Iterator iterator = new IteratorImp(newChars);

        iterator.print();
    }

    public MyHString(char[] chars){
        this.length = chars.length;
        char[] newChars = new char[this.length + 1];
        for (int i = 1; i < this.length + 1; i++){
            newChars[i] = chars[i - 1];
        }
        this.chars = newChars;
    }

    public MyHString(String str){
        this.length = str.length();
        this.chars = new char[length + 1];
        for(int i = 1; i < length + 1; i++){
            chars[i] = str.charAt(i - 1);
        }
    }

    public static MyString assignString(String str) {
        return new MyHString(str);
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public boolean isBigger(MyString str) {
        int i = 1;
        int j = 1;
        char[] comp = str.getChars();
        while (i <= this.getLength() && j <= str.getLength()){
            if(chars[i] < comp[j]){
                return false;
            } else if (chars[i] > comp[j]) {
                return true;
            }else {
                i++;
                j++;
            }
        }

        return length > str.getLength();
    }

    @Override
    public MyString subString(int start, int len) throws Exception {
        if(start < 1 || start > length){
            throw new Exception("起始下标超出范围");
        }

        if(start + len - 1 > length){
            throw new Exception("截取长度超限");
        }

        StringBuilder stringBuffer = new StringBuilder("");
        for(int i = start; i <= start + len - 1; i++){
            stringBuffer.append(chars[i]);
        }

        return new MyHString(stringBuffer.toString());
    }

    @Override
    public MyString concat(MyString str) {
        char[] newChars = new char[this.length + str.getLength()];
        for(int i = 0; i < newChars.length; i++){
            if(i < this.length){
                newChars[i] = this.chars[i + 1];
            }else {
                newChars[i] = str.getChars()[i - this.length + 1];
            }
        }
        return new MyHString(newChars);
    }

    //用改进的KMP算法实现
    @Override
    public int index(MyString str) throws Exception {
        int i = 1; //主串指针
        int j = 1; //模式串指针
        if(!(str instanceof MyHString)){
            throw new Exception("暂未实现不同类型串的互转");
        }
        MyHString hStr = (MyHString) str;
        int[] nextVal = hStr.getNextVal();

        while (i <= length && j <= str.getLength()){
            if(j == 0 || chars[i] == str.getChars()[j]){
                i++;
                j++;
            } else {
                j = nextVal[j];
            }
        }

        if(j > str.getLength()){
            return i - str.getLength();
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof MyHString){
            MyHString str = (MyHString) obj;
            if(length == str.getLength()){
                for (int i = 1; i <= length; i++){
                    if(chars[i] != str.getChars()[i]){
                        return false;
                    }
                }
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    /**
     * @param :
     * @return int[] 串的next数组
     * @author ZhouXiang
     * @description 获取串的next数组
     * @exception subString产生
     */
    public int[] getNext() throws Exception {
        int[] next = new int[length + 1];
        for(int i = 1; i <= length; i++){
            if(i == 1){
                next[i] = 0;
                continue;
            }

            int x = 1; //指示前缀字符串最后一个字符位置
            int y = i - 1; //指示后缀字符串的第一个字符位置
            int same = 0; //前缀和后缀相同的字符数
            while (x < i - 1){
                MyString front = this.subString(1, x);
                MyString rear = this.subString(y, x);
                if(front.equals(rear)){
                    same = x;
                }
                x++;
                y--;
            }

            next[i]  = same + 1;
        }

        return next;
    }

    /**
     * @param :
     * @return int[] 获取到的nextval数组
     * @author ZhouXiang
     * @description 获取nextval数组
     * @exception subString产生
     */
    public int[] getNextVal() throws Exception {
        int[] nextVal = new int[length + 1];
        int[] next = this.getNext();

        for(int i = 1; i < length + 1; i++){
            if(i == 1){
                nextVal[i] = 0;
                continue;
            }

            int former = next[i];
            if(chars[former] == chars[i]){
                nextVal[i] = next[former];
            }else {
                nextVal[i] = next[i];
            }
        }

        return nextVal;
    }
}
