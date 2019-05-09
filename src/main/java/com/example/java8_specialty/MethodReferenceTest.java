package com.example.java8_specialty;

import java.util.Arrays;
import java.util.List;

/**
 * @author：sdh
 * @description：
 * @date：2019-05-09
 * @version： 1.0
 */
public class MethodReferenceTest {


    /**功能描述:
     * 优势：
     *方法引用通过方法的名字来指向一个方法。
     *方法引用可以使语言的构造更紧凑简洁，减少冗余代码。
     *方法引用使用一对冒号 ::
     *
     * 语法
     *1.构造器引用：它的语法是Class::new，或者更一般的Class< T >::new
     *      eg:final Car car = Car.create( Car::new );
     *         final List< Car > cars = Arrays.asList( car );
     *2.静态方法引用：它的语法是Class::static_method
     * eg：cars.forEach( Car::collide );
     *3.特定类的任意对象的方法引用：它的语法是Class::method
     **/





    @FunctionalInterface
    public interface Supplier<T> {
        T get();
    }


    public static void main(String[] args) {
        //构造器引用
        final Car car = Car.create( Car::new );
        final List< Car > cars = Arrays.asList( car );

        //静态方法引用
        cars.forEach( Car::collide );

        //特定类的任意对象的方法引用
        cars.forEach( Car::repair );


        //特定对象的方法引用
        final Car police = Car.create( Car::new );
        cars.forEach( police::follow );
    }

}
