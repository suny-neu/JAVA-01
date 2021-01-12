package com.geek.java.week01;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class HelloClassLoader1 extends ClassLoader {
    public static void main(String[] args) {
//        try {
//           Object O= new HelloClassLoader1().loadClass("Hello").newInstance();
//           System.out.println(O.getClass().getClassLoader());
//           Method[] methods=O.getClass().getDeclaredMethods();
//           for(Method m:methods){
//               System.out.println(m.toString());
//               m.invoke(O);
//           }
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
        URLClassLoader urlClassLoader=(URLClassLoader)HelloClassLoader.class.getClassLoader();
        String path="F:\\geekUniversity\\src\\com\\geek\\java\\week01\\";
        try {
            Method method=URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
            method.invoke(urlClassLoader,new File(path));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        try {
            Object klass= Class.forName("Hello").newInstance();
            Method method=klass.getClass().getDeclaredMethods("hello",true,urlClassLoader);
            method.invoke(klass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }



}
