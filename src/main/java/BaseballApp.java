import baseball.Moderator;

public class BaseballApp {
    public static void main(String[] args) {
        Moderator moderator = new Moderator();
        boolean isNeedToStart = true;

        while (isNeedToStart) {
            moderator.startBaseball();
            moderator.endBaseball();
            isNeedToStart = moderator.isNeedToRestart();
        }
    }
}
