package com.yang.basic.oop;

class Person{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /*
    1.1构造方法必须在实例化新对象的时候调用，所以this()的语句只允许放在构造方法的前面。
    1.2构造方法互相调用时，要保证程序有出口，不能形成死循环。 //Recursive constructor invocation

    2.构造方法中可以调用普通方法，但是普通方法中不能调用构造方法。
     */

    public Person(){
        System.out.println("我们new了一个Person对象");
    }

    public Person(String name){
        this();
        setName(name);
    }
    public Person(String name, int age) {
        this(name);
        setAge(age);

    }

    public void tell(){
        System.out.println("该用户名为"+name+"，今年"+age+"岁！");
    }
}

class Emp{
    private long empno; //员工编号
    private String ename; //员工姓名
    private String dept; // 部门名称
    private double sal; // 基本工资

    @Override
    public String toString() {
        return "Emp{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", dept='" + dept + '\'' +
                ", sal=" + sal +
                '}';
    }

    public Emp(){
        this(1000, "无名氏", null, 0.0);
    }

    public Emp(long empno){
        this(empno, "新员工", "未定", 0.0);
    }

    public Emp(long empno, String ename, String dept){
        this(empno, ename, dept, 2500.0);
    }

    public Emp(long empno, String ename, String dept, double sal){
        this.empno = empno;
        this.ename = ename;
        this.dept = dept;
        this.sal = sal;
    }
}

public class ConstructorTest {
    public static void main(String[] args) {
        new Person("张三", 18).tell();
        System.out.println(new Emp(7369L, "李四", "税务部门").toString());
    }
}
