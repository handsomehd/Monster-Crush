//玩家資料皆存於此處
public class MonsterUserdata
{
    private static String name = "Defalt Name";
    private static int score = 0;
    private static int move = 30;
    public static void setName(String username)
    {
        name = username;
    }
    public static String getName()
    {
        return name;
    }
    public static void addScore(int addscore)
    {
        score = score + addscore;
    }
    public static int getScore()
    {
        return score;
    }
    public static void setScore(int resetscore)
    {
        score = resetscore;
    }
    public static void rmMove()
    {
        move = move-1;
    }
    public static int getMove()
    {
        return move;
    }
}