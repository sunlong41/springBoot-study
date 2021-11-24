package spring.boot.spring.boot.entity;

import org.springframework.stereotype.Component;

@Component
public class Entity {
    private String a;
    private String b;
    private String c;

    @Override
    public String toString() {
        return a + b + c;
    }

    public String toString(String p) {
        return a + b + c + p;
    }

    public Entity() {
    }

    public Entity(String a, String b, String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }
}
