package demo.springboot.starter.batchInsert;

import java.sql.*;

public class PreparedInsert {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String driver="com.mysql.cj.jdbc.Driver";
        Class.forName(driver);
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3316/shopping_1?characterEncoding=utf-8&&rewriteBatchedStatement=true&&serverTimezone=GMT%2B8","root","");
        String sql="insert into  t_order_1 values(?,?,?,?,?,?)";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        try {

            for(int i=0;i<1000000;i++){
              preparedStatement.setString(1,i+"");
              preparedStatement.setString(2,"user"+i);
              preparedStatement.setString(3,"producte"+i);
              preparedStatement.setDate(4,new Date(System.currentTimeMillis()));
              preparedStatement.setDate(5,new Date(System.currentTimeMillis()));
              preparedStatement.setInt(6,i);
              preparedStatement.addBatch();
            }
            long start=System.currentTimeMillis();
            System.out.println(start);
            preparedStatement.executeBatch();
            long end=System.currentTimeMillis();
            long time=end-start;
            System.out.println("耗时："+time);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            preparedStatement.close();
            connection.close();
        }

    }


}
