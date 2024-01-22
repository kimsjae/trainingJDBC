package dao;

import db.DBConnection;
import model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

//    public Account selectByNumber(String id) {
//        Connection conn = DBConnection.getInstance();
//        String sql = "select * from users_tb where id = ?";
//        try {
//            PreparedStatement pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1, id);
//
//            ResultSet rs = pstmt.executeQuery();
//
//            if (rs.next()) {
//                Account account = new Account(
//                        rs.getString("id"),
//                        rs.getString("pw"),
//                        rs.getInt("grade"),
//                        rs.getString("gender")
//                );
//                return account;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    public List<Account> selectAll() {
        Connection conn = DBConnection.getInstance();
        try {
            String sql = "select * from account_tb order by number desc";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery(); // 테이블형태의 데이터

            List<Account> accountList = new ArrayList<>();
            while(rs.next()) {
                Account account = new Account(
                        rs.getString("id"),
                        rs.getString("pw"),
                        rs.getInt("grade"),
                        rs.getString("gender")
                );
                accountList.add(account);
            }
            return accountList;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
