package team2.view;

import java.util.ArrayList;
import java.util.Scanner;

import team2.controller.OrderController;
import team2.model.dto.OrderDto;

public class iloview {

    private iloview() {}
    private static final iloview instance = new iloview();
    public static iloview getInstance() { return instance; }

    private OrderController oc = OrderController.getInstance();


    private Scanner scan = new Scanner(System.in);

    public void run() {

        while (true) {

            System.out.println("\n========== 아웃백 ==========");
            System.out.print("1주문 2재고관리 3예약 4리뷰 5시스템종료");
            System.out.println("\n===========================");
            String ch = scan.next();

            if (ch.equals("1")) {}
            else if (ch.equals("2")) {}
            else if (ch.equals("3")) {}
            else if (ch.equals("4")) {}

            else if (ch.equals("5")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else { System.out.println("잘못된 입력입니다."); }

        }

    }

    /* ------------------------------------------------------------------------- */

    // [1] 주문파트 부탁드립니다.


    public void orderScreen(){
        System.out.println("=============");
        System.out.println("1. 주문 2. 주문확인 3. 주문수정 4. 주문삭제 5. 돌아가기");
        System.out.print("선택: "); int ch = scan.nextInt();

        if (ch == 1){
            order();
        }
        else if (ch ==2){
            findAllOrder();
        }
        else if (ch == 3){
            updateOrder();
        }
        else if (ch == 4){
            deleteOrder();
        }
        else if (ch == 5){
            return;
        }
    }

    public void order(){
        System.out.println( "1) 메뉴 2) 메뉴 3) 메뉴 4) 메뉴" );     ////////// 메뉴 보이는 함수
        System.out.print("선택: "); int no = scan.nextInt();
        System.out.print("선택한 메뉴 수량: "); int amount = scan.nextInt();
        System.out.print("고객님 성함: "); String pname = scan.next();
        OrderDto orderDto = new OrderDto(1, no, amount, pname);
        boolean result = oc.order(orderDto);
        if (result){System.out.println("주문 완료");}
        else {System.out.println("주문실패");}
    }

    public void findAllOrder(){
        ArrayList<OrderDto> result = oc.findAll();
        for (OrderDto order: result){
            System.out.println(order);
        }
    }

    public void updateOrder(){
        System.out.println("수정한 주문 번호: "); int och = scan.nextInt();
        System.out.println("1) 메뉴 2) 메뉴 3) 메뉴 4) 메뉴");      //////////////////// 메뉴 보이는 함수
        System.out.print("선택: "); int no = scan.nextInt();
        System.out.print("선택한 메뉴 수량: "); int amount = scan.nextInt();

        OrderDto orderDto = new OrderDto(och, no, amount, null);

        // OrderControll의 update함수 실행
        boolean result = oc.update(orderDto);
        
        if (result){System.out.println("수정완료");}
        else{System.out.println("수정실패");}
    }

    public void deleteOrder(){
        System.out.print("삭제할 주문 번호: "); int no = scan.nextInt();
        boolean result = oc.delete(no);
        if (result) {System.out.println("삭제성공");}
        else {System.out.println("삭제실패");}
    }
















    /* ------------------------------------------------------------------------- */
    
    // [2] 재고파트 부탁드립니다.






















    /* ------------------------------------------------------------------------- */

    // [3] 예약파트 부탁드립니다.






















    /* ------------------------------------------------------------------------- */

    // [4] 리뷰파트 부탁드립니다.






















    /* ------------------------------------------------------------------------- */


}
