/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuancq.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import tuancq.dto.FoodDTO;
import tuancq.utils.DButils;

/**
 *
 * @author ADmin
 */
public class FoodDAO {

    public List<FoodDTO> listFood(String search) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<FoodDTO> list = new ArrayList<>();
        try {
            conn = DButils.getConnection();
            String sql = "\"SELECT id, name, description, price, cookingTime, status, createDate  "
                    + "FROM tblFoods  "
                    + "WHERE status = ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, search);
            rs = stm.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                Float price = rs.getFloat("price");
                int cookingTime = rs.getInt("cookingTime");
                boolean status = rs.getBoolean("status");
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String creationDate = sdf.format(rs.getTimestamp("createDate"));
                FoodDTO dto = new FoodDTO(id, name, description, 0, cookingTime, status, creationDate);
                list.add(dto);

            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public boolean updateFood(FoodDTO foodDTO) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        boolean row = false;
        try {
            conn = DButils.getConnection();
            String sql = "UPDATE tblFoods SET name=?,description= ?,price=?,cookingTime = ?  "
                    + "WHERE id = ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, foodDTO.getName());
            stm.setString(2, foodDTO.getDescription());
            stm.setFloat(3, foodDTO.getPrice());
            stm.setInt(4, foodDTO.getCookingTime());
            stm.setString(5, foodDTO.getId());
            row = stm.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return row;
    }

    public boolean deleteFood(String id) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        boolean row = false;
        try {
            conn = DButils.getConnection();
            String sql = "UPDATE tblFoods SET status = 'false' WHERE id = ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, id);
            row = stm.executeUpdate() > 0;
        } catch (Exception e) {
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return row;
    }

    public boolean createFood(String id, String name, String description, float price, int cookingTime, String status, Date date) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        boolean row = false;
        try {
            conn = DButils.getConnection();
            String sql = "INSERT INTO tblFoods(id,name,description,price,cookingTime,status,createDate) "
                    + "VALUE(?,?,?,?,?,?,?)";
            stm = conn.prepareStatement(sql);
            stm.setString(1, id);
            stm.setString(2, name);
            stm.setString(3, description);
            stm.setFloat(4, price);
            stm.setInt(5, cookingTime);
            stm.setString(6, status);
            stm.setTimestamp(7, new Timestamp(date.getTime()));
            row = stm.executeUpdate()> 0;
        } catch (Exception e) {
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }

        }
        return row;
    }
}
