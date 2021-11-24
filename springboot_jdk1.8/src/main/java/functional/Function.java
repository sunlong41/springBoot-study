package functional;

interface Function {
    /**
     * jdk 8 接口的默认方法
     * Java 8允许我们给接口添加一个非抽象的方法实现，只需要使用 default关键字即可
     * default 修饰的方法可以不用被子类继承
     */
    double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}

class Test {
    public static void main(String[] args) {
        /**
         * 实现了Function接口的子类只需要实现一个calculate方法，默认方法sqrt将在子类上可以直接使用。
         */
        Function func = new Function() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };
        System.out.println(func.sqrt(10));
    }
}