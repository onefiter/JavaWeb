package com.onefiter.junit;

import com.onefiter.junit.Cacluate;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 *
 * 使用单元测试:
 *    1. 单元测试方法的要求:
 *       1.1 必须是public
 *       1.2 必须是void
 *       1.3 必须没有参数
 *       1.4 必须添加@Test
 *    2. 三个重要注解
 *       2.1 Test注解添加在要执行的单元测试方法上
 *       2.2 Before注解添加在测试前执行的方法上
 *       2.3 After注解添加在测试后执行的方法上
 * 编程规范:
 *       1. 全部不能写中文
 *       2. 一定要用包，包名的编写: 公司域名反写.功能名
 *       3. 类名的规范:一定要以大写字母开头，多个单词之间使用驼峰命名法
 *       4. 变量名的规范: 一定要以小写字母开头，变量名尽量具备可读性，同样遵循驼峰命名法
 *       5. 常量名的规范: 全大写，多个单词之间使用下划线分割
 */
public class TestJunit {

    @Before
    public void init() {
        System.out.println("在这个方法中通常做一些全局的初始化工作...");
    }

    @Test
    public void test01(){
        System.out.println("hello world");
    }


    @Test
    public void test02(){
        int num = 10/0;
    }

    @Test
    public void test03(){
        //测试加法运算是否符合预期
        Cacluate cacluate = new Cacluate();
        int sum = cacluate.sum(1, 3);
        //判断运算结果是否符合预期
        Assert.assertEquals(4,sum);
    }

    @Test
    public void test04(){
        Cacluate cacluate = new Cacluate();
        int sub = cacluate.sub(4, 1);

        Assert.assertEquals(3,sub);
    }
    @After
    public void destroy(){
        System.out.println("在这个方法中通常做一些全局的销毁、资源回收等等工作...");
    }
}
