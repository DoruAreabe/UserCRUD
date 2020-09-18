package com.DoruAreabe.DAO;

import com.DoruAreabe.service.DBService;
import com.DoruAreabe.entity.User;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public static final String addSQL = "INSERT INTO User(email,userName,password) Value (?,?,?);";
    public static final String updateSQL = "UPDATE User SET email=?, username=?, password=? WHERE id=?;";
    public static final String deleteSQL = "DELETE FROM User where id = ?;";
    public static final String readSQL = "SELECT * FROM User where id = ?;";
    public static final String readAllSqL = "SELECT * FROM User;";


    public static User create(User user) {
        try (Connection con = DBService.getConection()) {
            PreparedStatement preparedStatement = con.prepareStatement(addSQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getUserName());
            preparedStatement.setString(3, BCrypt.hashpw(user.getPassword(),BCrypt.gensalt()));
            preparedStatement.executeUpdate();
            ResultSet result = preparedStatement.getGeneratedKeys();
            if (result.next()) {
                user.setId(result.getInt(1));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static User read(int id) {
        try (Connection con = DBService.getConection()) {
            User user = User.getEmptyUser();
            PreparedStatement preparedStatement = con.prepareStatement(readSQL);
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                user.setId(result.getInt(1));
                user.setEmail(result.getString(2));
                user.setUserName(result.getString(3));
                user.setPassword(result.getString(4));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public static void update(User user) {
        if (user.getId() == 0) {
            System.out.println("This user dont exist in BD");
            return;
        }
        try (Connection con = DBService.getConection()) {
            PreparedStatement preparedStatement = con.prepareStatement(updateSQL);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getUserName());
            preparedStatement.setString(3, BCrypt.hashpw(user.getPassword(),BCrypt.gensalt()));
            preparedStatement.setInt(4, user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void delete(int id) {
        try (Connection con = DBService.getConection()) {
            PreparedStatement preparedStatement = con.prepareStatement(deleteSQL);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<User> readAll() {
        List<User> listResult = new ArrayList<>();
        try (Connection con = DBService.getConection()) {
            PreparedStatement preparedStatement = con.prepareStatement(readAllSqL);
            ResultSet result = preparedStatement.executeQuery();
            while(result.next()){
                User user = User.getEmptyUser();
                user.setId(result.getInt(1));
                user.setEmail(result.getString(2));
                user.setUserName(result.getString(3));
                user.setPassword(result.getString(4));
                listResult.add(user);
            }
            return listResult;
        } catch (SQLException e){
            e.printStackTrace();
            return listResult;
        }
    }
}
