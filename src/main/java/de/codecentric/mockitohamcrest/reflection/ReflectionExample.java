package de.codecentric.mockitohamcrest.reflection;

import java.lang.reflect.Field;

/**
 * Created by apotukar on 07.11.2014.
 */
public class ReflectionExample {

    public static class InnerClass  {
        private String foo;

        private String bar;

        public String getFoo() {
            return foo;
        }

        public String getBar() { return bar; }

        public void setBar(String bar) {
            this.bar = bar;
        }
    }

    public static void main(String[] args) {
        try {
            new ReflectionExample().run();
        } catch (Exception e) {

        }
    }

    public void run() throws IllegalAccessException {
        InnerClass innerClass = new InnerClass();
        Field[] fields = innerClass.getClass().getDeclaredFields();
        for (Field field : fields) {
            System.out.println("field: " + field.getName() + "; accessible = " + field.isAccessible());
            switch (field.getName())
            {
                case "foo":
                    field.setAccessible(true);
                    field.set(innerClass, "Hallo Reflection-Welt!");
                    break;
                case "bar":
                    innerClass.setBar("Ich bin direkt gesetzt");
                    break;
                default:
                //Hier passiert nix
            }

            /* Alte Variante von Alex P.
            if (field.getName().equals("foo")) {
                field.setAccessible(true);
                field.set(innerClass, "Hallo Reflection-Welt!");
            }
            */
        }

        System.out.println("foo: " + innerClass.getFoo());
        System.out.println("bar: " + innerClass.getBar());
    }
}
