package com.example.java8_specialty;

import jdk.management.resource.ResourceId;

import java.util.function.DoubleSupplier;

/**
 * @author：sdh
 * @description：
 * @date：2019-05-09
 * @version： 1.0
 */
public class LambdaTest {

    /**功能描述:
     * Lambda 表达式，也可称为闭包，它是推动 Java 8 发布的最重要新特性。
     *Lambda 允许把函数作为一个方法的参数（函数作为参数传递进方法中）。
     *使用 Lambda 表达式可以使代码变的更加简洁紧凑。
     * 语法格式：(parameters) -> expression 或 (parameters) ->{ statements; }
     * 重要特征:
     *可选类型声明：不需要声明参数类型，编译器可以统一识别参数值。
     *可选的参数圆括号：一个参数无需定义圆括号，但多个参数需要定义圆括号。
     *可选的大括号：如果主体包含了一个语句，就不需要使用大括号。
     *可选的返回关键字：如果主体只有一个表达式返回值则编译器会自动返回值，大括号需要指定明表达式返回了一个数值。
     * 注意：
     * lambda 表达式的局部变量可以不用声明为 final，但是必须不可被后面的代码修改（即隐性的具有 final 的语义）
     * 在 Lambda 表达式当中不允许声明一个与局部变量同名的参数或者局部变量。
     *@Author：sdh
     *@Description
     *@Param
     *@Date 2019/5/9 13:39
     *@Return
     **/

    static  LambdaTest tester = new LambdaTest();

    public static void main(String[] args) {


        tester.baseMethodTest();



    }



    void baseMethodTest(){

        // 类型声明
        MathOperation addition = (int a, int b) -> a + b;

        // 不用类型声明
        MathOperation subtraction = (a, b) -> a - b;

        // 大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> { return a * b; };

        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));

        // 不用括号
        GreetingService greetService1 = message ->
                System.out.println("Hello " + message);

        // 用括号
        GreetingService greetService2 = (message) ->
                System.out.println("Hello " + message);

        greetService1.sayMessage("Runoob");
        greetService2.sayMessage("Google");
    }

    /**定义一个函数式接口MathOperation：函数式接口为仅含有一个抽象方法的接口（如果声明了两个或两个以上的方法就不叫函数式接口）**/
    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }
}
