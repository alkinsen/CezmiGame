import game.HadiCezmi;
import ui.StartFrame;

public class main {

    public static void main(String[] args) throws InterruptedException {

        HadiCezmi hadi = new HadiCezmi(1, "Player 1", "Player 2");
        new StartFrame(hadi);
        while (true){
            if(hadi.isRunningMode()) {
                hadi.move();
            }
            Thread.sleep(5);
        }
    }
}