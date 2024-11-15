import java.lang.reflect.Method;

class fgh {
    public static void main(String[] args) throws Exception {

        Class<?> cls = fgh.class;
        for (Method method : cls.getMethods()) {
            if (method.isAnnotationPresent(Test.class)) {
                Test annotation = method.getAnnotation(Test.class);

                int a = annotation.a();
                int b = annotation.b();

                method.invoke(null, a, b);
            }
        }
    }

    @Test(a = 2, b = 5)
    public static void test(int a, int b) {
        System.out.println("a = " + a + ", b = " + b);
    }
}
