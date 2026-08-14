package team2.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class BaseDao {

    // 여러개 DAO 클래스들에게 JDBC 연동 인스턴스 상속

    // 1. 연동 정보
    private String url = "jdbc:mysql://127.0.0.1:3306/day28pj2";
    private String user = "root";
    private String password = "1234";

    // 2. 연동 인터페이스
    protected Connection conn;  // protected : 상속관계이면 다른 패키지도 접근 허용함.  // private 는 상속이여도 접근 못 함.

    // 3. 연동 메소드 생성
    private void connect(){

        try{
            // 3-1 : mysql Driver (동적)로드 한다.
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 3-2 : 데이터베이스 서버와 연동 시도 후에 성공하면 conn(인터페이스) 대입 성공
            conn = DriverManager.getConnection(url, user, password);
        }catch( Exception e ){ System.out.println("DB연동실패" + e); }
        
    }

    // 4. 기본 생성자에 연동 메소드 실행, 해당 클래스 상속받은 Dao 들은 자동 connect
    protected BaseDao(){ connect(); };

    
}
