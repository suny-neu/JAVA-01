package com.springboot.demo.util;

public class DBContexHolder {

    private  static final  String MASTER="master";
    private static final String SLAVE="slave";

    private static  ThreadLocal<String>  holder=new ThreadLocal<String>();



    public static void  setMaster(){
        holder.set(MASTER);
    }

    public  static void setSlave(){
        holder.set(SLAVE);
    }


    public  static String getDbType(){
        return holder.get();
    }

}
