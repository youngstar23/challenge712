package com.yang.basic.oop.simpleJavaClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

class Address{
    private String country;
    private String province;
    private String city;
    private String district;
    private String zipCode;

    public Address(String country, String province, String city, String district, String zipCode) {
        this.country = country;
        this.province = province;
        this.city = city;
        this.district = district;
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Employee {
    private String empno;
    private String ename;
    private double salary;
    private double rate;

    /**
     * 工资增长额度
     */
    public double salaryIncValue(){
        return salary * rate;
    }

    /**
     * 工资增长结果
     */
    public double salaryIncResult(){
        salary *= (1 + rate);
        return salary;
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Dog{
    private String name;
    private String color;
    private int age;
}

class User{
    private String uid;
    private String password;
    private static int count = 0;

    public User(){
        this("NoId", "123456");
    }
    public User(String uid){
        this(uid, "123456");
    }
    public User(String uid, String password){
        this.uid = uid;
        this.password = password;
        ++this.count;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", password='" + password + '\'' +
                ", count=" + count +
                '}';
    }
}


public class JavaDemo {
    public static void main(String[] args) {
        //System.out.println(new Address("中华人民共和国","广东省", "深圳市", "南山区", "518000"));

        /*Employee employee = new Employee("1001", "张三", 10000, 0.1);
        System.out.println(employee);
        System.out.println("进行一次工资调整，工资的增长额度为" + employee.salaryIncValue() + "，\n现阶段工资为"
                            + employee.salaryIncResult());
        System.out.println(employee);*/

        //System.out.println(new Dog("小哈", "黑色", 1));

        User user1 = new User("张三");
        System.out.println(user1);
        User user2 = new User();
        System.out.println(user2);
        User user3 = new User("王五", "abcdef");
        System.out.println(user3);
    }
}
