package HackerRankJavaOops;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

class Student{
    private String name;
    private String id;
    private String email;

    public String getName() {
        return name;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
public class ClassLiteral {

    public static void main(String[] args) throws ClassNotFoundException{
        Class student = Student.class;
        Method[] methods = student.getMethods();

        ArrayList<String> methodList = new ArrayList<>();
        for(Method m:methods){
            methodList.add(m.getName());
        }
        Collections.sort(methodList);
        for(String name: methodList){
            System.out.println(name);
        }
    }
}
