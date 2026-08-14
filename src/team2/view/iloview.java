package team2.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import team2.controller.ReviewController;
import team2.model.dto.ReivewDto;

public class iloview {

    private iloview() {
    }

    private static final iloview instance = new iloview();

    public static iloview getInstance() {
        return instance;
    }

    // private InventoryController invc = InventoryController.getInstance();

    // private ReservationController resc = ReservationController.getInstance();

    // private OrderController ordc = OrderController.getInstance();

    private ReviewController revc = ReviewController.getInstance();

    private Scanner scan = new Scanner(System.in);

    public void run() {

        while (true) {

            System.out.println("\n========== 아웃백 ==========");
            System.out.print("1주문 2재고관리 3예약 4리뷰 5시스템종료");
            System.out.println("\n===========================");
            String ch = scan.next();

            if (ch.equals("1")) {
            } else if (ch.equals("2")) {
            } else if (ch.equals("3")) {
            } else if (ch.equals("4")) {
                ReviewMenu();
            }

            else if (ch.equals("5")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("잘못된 입력입니다.");
            }

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
