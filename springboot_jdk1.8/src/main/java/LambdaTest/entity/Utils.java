package LambdaTest.entity;

public class Utils {
    public void util1(){
        System.out.println("普通方法1");
    }
    public static void util2(){
        System.out.println("静态方法1");
    }

    private String id;
    private String name;

    public Utils() {
        System.out.println("调用空参构造方法");
    }

    public Utils(String id, String name) {
        this.id = id;
        this.name = name;
        System.out.println("调用有参构造方法");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Utils{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public static String util2(String s) {
        return s;
    }
}
