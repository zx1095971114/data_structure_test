package com.test;

import com.utils.StackApply;
import com.utilsImp.StackApplyImp;

/**
 * @projectName: data-structure-test
 * @package: com.test
 * @className: StackApplyTest
 * @author: Zhou xiang
 * @description: 栈应用的检测
 * @date: 2023/1/18 17:18
 * @version: 1.0
 */
public class StackApplyTest {

    public static void main(String[] args) throws Exception {
        StackApply stackApply = new StackApplyImp();
        if(!stackApply.parenthesisMatch("[]asa{9(hdh})")){
            System.out.println("括号匹配1通过");
        }

        //"{fsaf}fafa(faf(gag))[(af)afdadf]"
        if(stackApply.parenthesisMatch("{fsaf}fafa(faf(gag))[(af)afdadf]")){
            System.out.println("括号匹配2通过");
        }

        String s = "((5 / (7 - (1 + 1))) * 3) - (2 + (1 + 1))";
        System.out.println(stackApply.mid2Behind(s));
        if(stackApply.mid2Behind(s).equals("5  7  1  1+-/  3*  2  1  1++-")){
            System.out.println("中缀表达式转后缀表达式测试通过");
        }

        int a = ((5 / (7 - (1 + 1))) * 3) - (2 + (1 + 1));
        System.out.println("a:" + a);
        System.out.println("calculate:" + stackApply.eval(s));
        if(stackApply.eval(s) == a){
            System.out.println("计算中缀表达式通过");
        }

    }
}
