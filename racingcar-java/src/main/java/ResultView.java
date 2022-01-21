public class ResultView {

    void printIntroResult () {
        System.out.println("실행 결과");
    }

    void printResult(int[] score) {
        for (int i = 0; i < score.length; i++) {
            printScore(score[i]);
        }
        System.out.println("");
    }

    private void printScore(int score) {
        for (int i = 0; i < score; i++) {
            System.out.print("-");
        }
        System.out.println("");
    }
}
