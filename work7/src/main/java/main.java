


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class main {

//未完成  。。。。   从数据库得到学生id
    public static void getStudentId(){
        Connection con = JDBCUtil.getConnection();
        String sql = "selelc number from sheet ";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet re = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    //数据库中加入班级学号
private static void addClassNam(String stuNum, String classNum) {

    Connection con = JDBCUtil.getConnection();
    String sql = "UPDATE sheet SET classNum = ? WHERE number = ?";
    try {
        PreparedStatement pstmt =  con.prepareStatement(sql);
        pstmt.setString(1,classNum);
        pstmt.setString(2,stuNum);
        pstmt.executeUpdate();
        con.close();
        pstmt.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

}


//爬取班级号
    public static void temp(String studentId) throws IOException {
        String temp = "http://120.79.143.238/cqupt/query?search=" + studentId;
        try {
            URL url = new URL(temp);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            BufferedReader bReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String line = null;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = bReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            bReader.close();
            connection.disconnect();
            System.out.println(stringBuilder.toString());
            JSONObject jsonObject = JSONObject.fromObject(stringBuilder.toString());

//            System.out.println(jsonObject.get("stuNum").toString()));
//            System.out.println(jsonObject.get("classNum").toStting()));

            addClassNam(jsonObject.get("stuNum").toString()),jsonObject.get("classNum").toString())

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

}
