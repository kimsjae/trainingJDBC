package dao;

import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public int insert(String id, String pw, int grade, String gender) {
        Connection conn = DBConnection.getInstance();

        String sql = "insert into users_tb(id, pw, grade, gender) values(?, ?, ?, ?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, pw);
            pstmt.setInt(3, grade);
            pstmt.setString(4, gender);

            int num = pstmt.executeUpdate();
            return num;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int updateByNumber(String id, String pw) {
        Connection conn = DBConnection.getInstance();

        String sql = "update users_tb set pw = ? where id = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, pw);
            pstmt.setString(2, id);

            int num = pstmt.executeUpdate();
            return num;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int deleteByNumber(String id) {
        Connection conn = DBConnection.getInstance();

        String sql = "delete from users_tb where id = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);

            int num = pstmt.executeUpdate();
            return num;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

//    public int selectByNumber(String id) {
//        Connection conn = DBConnection.getInstance();
//        String sql = "select * from users_tb where id = ?";
//        try {
//            PreparedStatement pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1, id);
//
//            ResultSet rs = pstmt.executeQuery();
//
//            if (rs.next()) {
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public int selectAll() {
//
//    }
}
