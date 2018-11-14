public class TokenPass {
    private static int[] board;
    private static int currentPlayer;
    public TokenPass(int pc)
    {
        board = new int[pc];
        for(int i=0;i<board.length;i++)
        {
            board[i] = (int)(Math.random()*10)+1;
        }
        currentPlayer = (int)(Math.random()*pc);
    }
    public static void printBoard()
    {
        for(int i=0;i<board.length;i++)
        {
            System.out.println("Player " + i + " has " + board[i]+ " tokens");
        }
    }
    public static void distributeCurrentPlayerTokens()
    {
        System.out.println(currentPlayer);
        int temp = board[currentPlayer];
        board[currentPlayer] = 0;
        int maxPos = board.length;
        int next = currentPlayer+1;
        while(temp > 0)
        {
            if(next>maxPos-1)
            {
                next =0;
            }
            board[next]++;
            temp--;
            next++;
            if(next>maxPos-1)
            {
                next =0;
            }
        }
    }
    public static void nextPlayer()
    {
        currentPlayer++;
        if(currentPlayer>=board.length)
        {
            currentPlayer = 0;
        }
    }
    public static int gameOver()
    {
        for(int i=0;i<board.length;i++)
        {
            if(board[i]==0)
            {
                return 1;
            }
        }
        return -1;
    }
}
