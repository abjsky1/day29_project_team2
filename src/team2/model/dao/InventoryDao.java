package team2.model.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import team2.model.dto.InventoryDto;

public class InventoryDao extends BaseDao{

    private InventoryDao(){}
    private static final InventoryDao instance = new InventoryDao();
    public static InventoryDao getInstance(){ return instance; }

    public boolean inventoryOrder(InventoryDto inventoryDto){

        try{
            // 1-1. SQL 작성  ,  값에 와일드카드(?) 이용한 매개변수 대입
            String sql = "INSERT INTO request(no, requestQty) VALUES( ? , ? )";

            // 1-2. 연동된  데이터베이스에 SQL 기재
            // conn 멤버변수는 BaseDao 에게 물려받음
            PreparedStatement ps = conn.prepareStatement(sql);

            // 1-3. 기재된 SQL 문법 안에 ?(와일드카드) 매개변수 값 대입  ==>>  ps.set타입( ?번호 , 값 )
            ps.setInt(1, inventoryDto.getNo());  // 1(첫번째 ?)에 Dto content 대입
            ps.setInt(2, inventoryDto.getRequestQty());   // 2(두번째 ?)에 Dto writer 대입

            // 1-4. 기재된 SQL 실행 ,   .executeUpdate()  insert/update/delete  에서 사용
            int result = ps.executeUpdate();  // 실행 후 처리된 레코드 수 반환

            // 1-5. SQL 결과
            if(result == 1){ return true;}

        }catch( SQLException e){ System.out.println(e);}
        
        // 1.5 SQL 결과
        return false; // 실패 의미 갖는 false 반환

    }

}
