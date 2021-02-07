package java0.conc0301.homework;

import java.io.Serializable;

public class Caculate  implements Serializable {
      private int a=100;
      private int b=0;

      public int getSum(){
          while (a>b){
              a--;
              b++;
          }
          return a+b;
      }

      public int returnSum(){
          return a+b;
      }
}
