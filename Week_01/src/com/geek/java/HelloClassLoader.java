package com.geek.java.week01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class HelloClassLoader extends ClassLoader{
    static String path="F:\\geekUniversity\\src\\com\\geek\\java\\week01\\";
    static String fileName="Hello";
    public static void main(String[] args) {
        try {
            Object o=new HelloClassLoader().findClass(path+fileName).newInstance();
            Method[] methods=o.getClass().getMethods();
            Method[] declearMethods=o.getClass().getDeclaredMethods();
            for(Method m:methods){
                System.out.println("method:"+m.toString());
            }
            for(Method m:declearMethods){
                System.out.println("declaredMethod"+m.toString());
                m.invoke(o);
//                Object invoke = m.invoke(o, m);
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 对字节码做加工
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] bytes=paseFileToByte(name);
        //字节码转化为class
        return defineClass(fileName, bytes, 0, bytes.length);
    }

    /**
     * 字节码转为byte[]
     * @param name
     * @return
     */
    private byte[] paseFileToByte(String name){
        File file=new File(name+".xlass");
        if(!file.exists()){
            return null;
        }
        byte[] bytes= new byte[(int) file.length()];
        try {
            FileInputStream  fis=new FileInputStream (file);
            fis.read(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] newbytes=opsiteByte(bytes);
        return newbytes;

    }

    /**
     * 255-byte
     * @param bytes
     * @return
     */
    private byte[] opsiteByte(byte[] bytes){
        byte[] newbytes=new byte[bytes.length];
        if(bytes!=null){
            for(int i=0;i<bytes.length;i++){
               newbytes[i]=(byte) (255-bytes[i]);
            }
        }
        return newbytes;
    }

}
