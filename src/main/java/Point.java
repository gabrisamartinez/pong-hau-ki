import java.util.Map;

public class Point {

    public static final String PLAYER_1 = "p1";
    public static final String PLAYER_2 = "p2";

    public void movePoint(Board board) {
        Player player1 = loadMyPoint(board, PLAYER_1);

        if(player1.getPosition() == 0) {
            Movements movements = new Movements(board);
            movements.move(0, PLAYER_1, 2);
        }


    }


    public Player loadMyPoint(Board board, String player) {

        for(int i = 0; i < board.getFirstHorizontalLine().size() ; i++) {
            Map<Integer, String> firstLine = board.getSecondHorizontalLine().get(i);

            if(!firstLine.isEmpty() && firstLine.get(0).equals(player)) {
                return new Player("y1", 0);
            }

            if(!firstLine.isEmpty() && firstLine.get(2).equals(player)) {
                return new Player("y1", 1);
            }
        }

            Map<Integer, String> secondLine = board.getSecondHorizontalLine().get(2);
            if(!secondLine.isEmpty() && secondLine.get(2).equals(player)) {
                return new Player("y1", 2);
            }



        for(int i = 0; i < board.getFirstHorizontalLine().size() ; i++) {
            Map<Integer, String> thirdLine = board.getSecondHorizontalLine().get(i);

            if(!thirdLine.isEmpty() && thirdLine.get(0).equals(player)) {
                return new Player("y1", 3);
            }

            if(!thirdLine.isEmpty() && thirdLine.get(2).equals(player)) {
                return new Player("y1", 4);
            }
        }

        return null;
    }

}
