package team2.model.dao;

import java.security.Permission;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import team2.model.dto.InventoryDto;
import team2.model.dto.OrderDto;

public class OrderDao extends BaseDao{
    private OrderDao(){};
    private static final OrderDao instance = new OrderDao();
    public static OrderDao getInstance() {return instance;}

    public boolean order(OrderDto orderDto){
        
        try{
            // 메뉴번호, 수량, 고객 성함을 매개변수로 받아 sql에 대입한다.
            String sql = "iNsErT iNtO OrDeRs(mno, amount, pname) Values(? , ? , ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, orderDto.getMno());
            ps.setInt(2, orderDto.getAmount());
            ps.setString(3, orderDto.getPname());
            // SQL 실행
            int result = ps.executeUpdate();

            if (result == 1){return true;}            
        }catch(SQLException e){System.out.println(e);}

        return false;
    } // 주문 END

    public ArrayList<OrderDto> findAll(){
        ArrayList <OrderDto> result = new ArrayList<>();

        try{
            String sql = "select * from orders";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                OrderDto orderDto = new OrderDto();

                // OrderDto에 SQL 결과를 하나씩 대입
                orderDto.setNo(rs.getInt("no"));
                orderDto.setMno(rs.getInt("mno"));
                orderDto.setAmount(rs.getInt("amount"));
                orderDto.setPname(rs.getString("pname"));

                result.add(orderDto);
            }
            
        }catch(SQLException e){System.out.println(e);}
    return result;
    } // 전체조회 END

    public boolean update(OrderDto orderDto){

        try{
            String sql = "update orders set mno = ?, amount = ? where no = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, orderDto.getMno());
            ps.setInt(2, orderDto.getAmount());
            ps.setInt(3, orderDto.getNo());
            
            int result = ps.executeUpdate();
            if (result == 1){return true;}
        } catch(SQLException e){System.out.println(e);}

        return false;
    }

    public boolean delete(int no){
        try{
            String sql = "DELETE from orders where no = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, no);

            int result = ps.executeUpdate();
            if (result == 1){return true;}            
        } catch(SQLException e){System.out.println(e);}

        return false;
    }

    public ArrayList<InventoryDto> showMenu(){
        ArrayList<InventoryDto> result = new ArrayList<>();
        try{
            String sql = "select inventory.no, menuName, menuqty from inventory join stock on inventory.no = stock.no GROUP BY no having menuqty>0;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                InventoryDto inventoryDto = new InventoryDto();
                inventoryDto.setNo(rs.getInt("no"));
                inventoryDto.setMenuName(rs.getString("menuName"));
                result.add(inventoryDto);
            }

        } catch (SQLException e){System.out.println(e);}

        return result;

    }

}
