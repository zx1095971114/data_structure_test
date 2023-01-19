package com.test;

import com.list.MyString;
import com.listImp.MyHString;

/**
 * @projectName: data-structure-test
 * @package: com.test
 * @className: MyStringTest
 * @author: Zhou xiang
 * @description: MyString类的检测
 * @date: 2023/1/19 20:03
 * @version: 1.0
 */
public class MyStringTest {
    public static void main(String[] args) throws Exception {
        MyString s1 = MyHString.assignString("abcd");
        s1.print();

        if(s1.getLength() == 4){
            System.out.println("长度获取测试通过");
        }

        MyString s2 = MyHString.assignString("abcde");
        if(!s1.isBigger(s2)){
            System.out.println("判断测试通过");
        }

        MyString s3 = MyHString.assignString("abcd");
        if(s1.equals(s3)){
            System.out.println("判同操作通过");
        }

        MyString s4 = MyHString.assignString("abc");
        if(s1.subString(1, 3).equals(s4)){
            System.out.println("截取操作通过");
        }

        MyString s5 = MyHString.assignString("abcdabcd");
        if(s1.concat(s1).equals(s5)){
            System.out.println("增长操作通过");
        }

        MyString s6 = MyHString.assignString("abaabaabc");
        MyString s7 =MyHString.assignString("abaabc");
        if(s6.index(s7) == 4){
            System.out.println("模式匹配操作通过");
        }
    }
}
