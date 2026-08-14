package team2.view;

import java.util.Scanner;

public class iloview {

    private iloview() {}
    private static final iloview instance = new iloview();
    public static iloview getInstance() { return instance; }

    private InventoryController invc = InventoryController.getInstance();

    private ReservationController resc = ReservationController.getInstance();

    private OrderController ordc = OrderController.getInstance();

    private ReviewController revc = ReviewController.getInstance();

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






















    /* ------------------------------------------------------------------------- */
    
    // [2] 재고파트 부탁드립니다.






















    /* ------------------------------------------------------------------------- */

    // [3] 예약파트 부탁드립니다.






















    /* ------------------------------------------------------------------------- */

    // [4] 리뷰파트 부탁드립니다.






















    /* ------------------------------------------------------------------------- */


}
