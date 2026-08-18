package team2.view;

import team2.controller.ReservationController;
import team2.model.dto.ReservationDto;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Scanner;

import team2.controller.InventoryController;
import team2.model.dto.InventoryDto;
import team2.controller.ReviewController;
import team2.model.dto.ReivewDto;

public class iloview {

    private iloview(){}

    private static final iloview instance = new iloview();

    public static iloview getInstance() {return instance;}

    private InventoryController ic = InventoryController.getInstance();

    private ReservationController resc = ReservationController.getInstance();

    private OrderController oc = OrderController.getInstance();

    private ReviewController revc = ReviewController.getInstance();

    private Scanner scan = new Scanner(System.in);

    public void run() {

        while (true) {

            System.out.println("\n========== 아웃백 ==========");
            System.out.print("1주문 2재고관리 3예약 4리뷰 5시스템종료");
            System.out.println("\n===========================");
            String ch = scan.next();

            if (ch.equals("1")) {}
            else if (ch.equals("2")) {inventoryRun();}
            else if (ch.equals("3")) {}
            else if (ch.equals("4")) {ReviewMenu();}

            else if (ch.equals("5")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("잘못된 입력입니다.");
            }

        }

    }

    public void reservSave() {
        System.out.print("예약할 전화번호 입력 : ");
        String telNo = scan.next();
        System.out.print("예약할 인원 수 입력 : ");
        int people = scan.nextInt();
        ReservationDto reservationDto = new ReservationDto(0, telNo, people);
        boolean result = resc.reservSave(reservationDto);
        if (result){
            System.out.println("등록 성공");
        } else {
            System.out.println("등록 실패");
        }

    }

    private void reservFindAll() {
        ArrayList<ReservationDto> reservList = resc.reservFindAll();
        for (ReservationDto reserv : reservList) {
            System.out.println(reserv.getReservNo() + ". " + reserv.getTelNo() + " : " + reserv.getPeople());
        }
    }

    private void reservUpdate() {
        System.out.print("예약된 전화번호 입력 : ");
        String telNo = scan.next();
        System.out.print("수정할 인원수 입력 : ");
        int people = scan.nextInt();
        boolean result = resc.reservUpdate(telNo, people);
        if (result){
            System.out.println("수정 성공");
        } else {
            System.out.println("수정 실패");
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
        System.out.println( "1) 메뉴 2) 메뉴 3) 메뉴 4) 메뉴" );     /////////// 메뉴 보이는 함수
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

    public void inventoryRun() {

        while (true) {

            System.out.println("\n========== 재고관리 ==========");
            System.out.print("1발주넣기 2재고조회 3발주조회 4발주취소 5돌아가기");
            System.out.println("\n===========================");
            String ch = scan.next();

            if (ch.equals("1")) {inventoryOrder();}
            else if (ch.equals("2")) {}
            else if (ch.equals("3")) {}
            else if (ch.equals("4")) {}

            else if (ch.equals("5")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else { System.out.println("잘못된 입력입니다."); }

        }

    }

    // [2-1] 발주넣기

    public void inventoryOrder(){

        System.out.print("발주할 메뉴의 번호를 입력하세요. "); int menuNo = scan.nextInt();
        System.out.print("발주할 메뉴의 수량를 입력하세요. "); int qty = scan.nextInt();

        InventoryDto inventoryDto = new InventoryDto(menuNo, qty);

        boolean result = ic.inventoryOrder(inventoryDto);

        if(result){System.out.println("발주 성공");}
        else{System.out.println("발주 실패");}
    }


    // [2-2] 재고조회

    public void inventoryFindAll(){

        ArrayList<InventoryDto> result = ic.inventoryFindAll();

        for( InventoryDto dto : result ){
            System.out.printf("no. %d  ,  메뉴명 : %s  ,  재고수량 : %d", dto.getNo(), dto.getMenuName(), dto.getMenuQty());
        }


        
    }



    // [2-3] 발주조회



    // [2-4] 발주취소




    /* ------------------------------------------------------------------------- */
    
    // [3] 예약파트 부탁드립니다.

    public void reservSave() {
        System.out.print("예약할 전화번호 입력 : ");
        String telNo = scan.next();
        System.out.print("예약할 인원 수 입력 : ");
        int people = scan.nextInt();
        ReservationDto reservationDto = new ReservationDto(0, telNo, people);
        boolean result = resc.reservSave(reservationDto);
        if (result){
            System.out.println("등록 성공");
        } else {
            System.out.println("등록 실패");
        }

    }

    private void reservFindAll() {
        ArrayList<ReservationDto> reservList = resc.reservFindAll();
        for (ReservationDto reserv : reservList) {
            System.out.println(reserv.getReservNo() + ". " + reserv.getTelNo() + " : " + reserv.getPeople());
        }
    }

    private void reservUpdate() {
        System.out.print("예약된 전화번호 입력 : ");
        String telNo = scan.next();
        System.out.print("수정할 인원수 입력 : ");
        int people = scan.nextInt();
        boolean result = resc.reservUpdate(telNo, people);
        if (result){
            System.out.println("수정 성공");
        } else {
            System.out.println("수정 실패");
        }
    }

    private void reservDelete() {
        System.out.print("예약된 전화번호 입력 : ");
        String telNo = scan.next();
        boolean result = resc.reservDelete(telNo);
        if (result){
            System.out.println("삭제 성공");
        } else {
            System.out.println("삭제 실패");
        }
    }




















    /* ------------------------------------------------------------------------- */

    // [4] 리뷰파트 부탁드립니다.
    private void ReviewMenu() {
        while (true) {
            try {
                System.out.println("\n====================== 리뷰 관리 ======================");
                System.out.print("1. 리뷰등록 2. 리뷰 조회 3. 리뷰 수정 4.리뷰 삭제 5. 돌아가기");
                System.out.println("\n=====================================================");
                System.out.print("선택: ");
                int ch = scan.nextInt();
                if (ch == 1) {
                    reivSave();
                } else if (ch == 2) {

                } else if (ch == 3) {
                } else if (ch == 4) {
                } else if (ch == 5) {
                    break;
                }
            } catch (InputMismatchException e) {
                scan = new Scanner(System.in);
                System.out.println("[다시 입력]" + e);
            }
        }

    }

    public void reivSave() {
        System.out.println("메뉴선택: ");
        int mno = scan.nextInt();
        System.out.println("리뷰내용: ");
        String reivContent = scan.next();
        System.out.println("별점(1 ~ 5): ");
        int reivScope = scan.nextInt();

        ReivewDto reivewDto = new ReivewDto(mno, reivContent, reivScope);
        boolean result = revc.reivSave(reivewDto);
        if (result) {
            System.out.println("[안내] 등록성공");
        } else {
            System.out.println("[안내] 등록실패");
        }
    }
    /* ------------------------------------------------------------------------- */

}
