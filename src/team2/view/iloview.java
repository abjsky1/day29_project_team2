package team2.view;

import java.util.Scanner;

import team2.controller.InventoryController;
import team2.model.dto.InventoryDto;

public class iloview {

    private iloview() {}
    private static final iloview instance = new iloview();
    public static iloview getInstance() { return instance; }

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
            else if (ch.equals("4")) {}

            else if (ch.equals("5")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else { System.out.println("잘못된 입력입니다."); }

        }

    }

    /* ------------------------------------------------------------------------- */

    // [1] 주문파트 부탁드립니다.






















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



    // [2-3] 발주조회



    // [2-4] 발주취소

















    /* ------------------------------------------------------------------------- */

    // [3] 예약파트 부탁드립니다.






















    /* ------------------------------------------------------------------------- */

    // [4] 리뷰파트 부탁드립니다.






















    /* ------------------------------------------------------------------------- */


}
