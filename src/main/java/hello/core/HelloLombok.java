package hello.core;

import lombok.Data;

@Data
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        final HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("Idooru");
        helloLombok.setAge(25);

        System.out.println("helloLombok = " + helloLombok);
    }
}