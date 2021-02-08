package com.company;

class Person{
    void anonim(){
        System.out.println("Person anonim");
    }
}

public class Main {

    public int i=8;
    static int q=5;

    static class StaticClass{ // статичный класс внутри класса Main
        void method(){
            System.out.println("StaticClass "+q);
        }
    }

    // нужен для показа анонимного класса
    static void anonimMethod(Person person){
        person.anonim();
    }

    public static void main(String[] args) { // запускается основное тело
	    StaticClass staticClass = new StaticClass();
        System.out.println("Main");
	    staticClass.method(); // 5 так как статик

	    Main main = new Main();
	    main.method(); // запускаем метод в Main
	    Inner inner = main.new Inner();
	    inner.method2();

        System.out.println("Second");
        Second second =new Second();
        second.method();

        System.out.println("Anonim");
        anonimMethod(new Person(){ //Анонимный метод
            void anonim(){ // который переопределяет метод anonim
                System.out.println("bla");
            } // и когда он вызовет метод static void anonimMethod, то он уже будет другим
        });
    }


    void method(){
        class NewInner{
            void newMethod(){
                System.out.println("Main.void method bla");
            }
        }
        System.out.println("Main.void"); //запускается 1
        inner3.method2();
        NewInner newInner = new NewInner();
        newInner.newMethod(); // выводим метод внутреннего класса NewInner
    }

    Inner inner3 = new Inner(); // можно объявлять здесь, так как всё равно внутри Main

    class Inner{
        private int k=6;
        void method2(){
            System.out.println(q);
            System.out.println(i);
        }
    }
}

class Second{
    void method(){
        Main.Inner inner = new  Main().new Inner(); //объявляется только так как, так как это класс внутри класса
        inner.method2();
    }
}