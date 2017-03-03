package EE_2015.App01_Reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Игорь
 * 22.02.2017.
 */
public class App01_Reflection {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        Class<Student> studentClass = Student.class;

        Object student = studentClass.newInstance();

        Method method = studentClass.getMethod("setName", String.class);

        Object inv = method.invoke(student, "Igor");

        Student std = (Student) student;

        System.out.println(std.getName());

    }
}
