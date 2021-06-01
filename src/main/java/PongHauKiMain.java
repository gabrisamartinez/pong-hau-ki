import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PongHauKiMain {

  public static final String YELLOW_PLAYER_1 = "x1";
  public static final String YELLOW_PLAYER_2 = "x2";
  public static final String ORANGE_PLAYER_1 = "y1";
  public static final String ORANGE_PLAYER_2 = "y2";

  public static List<Map<Integer, String>> firstHorizontalLine = new ArrayList<>();
  public static List<Map<Integer, String>> secondHorizontalLine = new ArrayList<>();
  public static List<Map<Integer, String>> thirdHorizontalLine = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    boolean isMyTurn = Boolean.FALSE;

    showPresents();
    populateWithPlayers();

    Board board = new Board(firstHorizontalLine, secondHorizontalLine, thirdHorizontalLine);
    Movements movements = new Movements(board);
    showBoard(board);

    boolean stilPlay = Boolean.TRUE;
    while (stilPlay) {

      if(!isMyTurn) {
        System.out.println("Jogador x, você iniciará, escolha qual payer e qual posição você deseja: ");

        //le a posição do jogador!
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in)
        );

        String playerDescription  = reader.readLine();
        String [] steps = playerDescription.split(",");
        String playerPosition = steps[0];
        String playerName = steps[1];
        String positionToGo = steps[2];

        movements.move(Integer.valueOf(playerPosition), playerName, Integer.valueOf(positionToGo));
        isMyTurn = Boolean.TRUE;
      } else {
        Point point = new Point();
        Player maplayer = point.loadMyPoint(board,YELLOW_PLAYER_1);
        Integer pointToGo = movements.loadBestPointToGo(maplayer.getPosition());

        if(pointToGo != null) {
          movements.move(maplayer.getPosition(),  maplayer.getName(), pointToGo);
        } else {

          maplayer = point.loadMyPoint(board,YELLOW_PLAYER_1);
          pointToGo = movements.loadBestPointToGo(maplayer.getPosition());
          if(maplayer != null) {
            movements.move(maplayer.getPosition(),  maplayer.getName(), pointToGo);
          } else {
            stilPlay = false;
          }
        }

        isMyTurn = Boolean.TRUE;
      }
    }


  }

  public static void populateWithPlayers() {
    Map<Integer, String> firstPosition = new HashMap<>();
    Map<Integer, String> secondPosition = new HashMap<>();
    Map<Integer, String> thirdPosition = new HashMap<>();
    Map<Integer, String> fourthPosition = new HashMap<>();
    Map<Integer, String> fifthPosition = new HashMap<>();


    firstPosition.put(0, YELLOW_PLAYER_1);
    secondPosition.put(1, ORANGE_PLAYER_1);
    thirdPosition.put(2, "" );
    fourthPosition.put(3, YELLOW_PLAYER_2);
    fifthPosition.put(4, ORANGE_PLAYER_2);

    /*
    PRIMEIRA LINHA HORIZONTAL
     */
    firstHorizontalLine.add(0,firstPosition);
    firstHorizontalLine.add(1,null);
    firstHorizontalLine.add(2, secondPosition);

    /*
    SEGUNDA LINHA ORIZONTAL
     */
    secondHorizontalLine.add(0, null);
    secondHorizontalLine.add(1, thirdPosition);
    secondHorizontalLine.add(2, null);

    /*
    TERCEIRA LINHA
     */
    thirdHorizontalLine.add(0,fourthPosition);
    thirdHorizontalLine.add(1, null);
    thirdHorizontalLine.add(2, fifthPosition);
  }

  public static void showPresents() {
    System.out.println(" apenas para te mostrar algumas regras de jogo: \n" +
            " O tabuleiro abaixo é como funciona cada posição, para atacar você precisa, na sua vez de jogar enviar o seguinte comando: \n" +
            " posicao do jogado, nome, posicao para ir. \n" +
            "Ex.: 3, x2, 2 \n\n" +
            "[0]     [1] \n" +
            "    [2]    \n" +
            "[3]     [4] \n\n" +
            "------------ \n\n");
  }

  public static void showBoard(Board board) {
    String newBoard = "[" + board.getFirstHorizontalLine().get(0).get(0) + "]     [" + board.getFirstHorizontalLine().get(2).get(1) + "] \n" +
                      "    ["+ board.getSecondHorizontalLine().get(1).get(2) + "]    \n" +
                      "[" + board.getThirdHorizontalLine().get(0).get(3) + "]     [" + board.getThirdHorizontalLine().get(2).get(4) + "] \n\n" +
                      "------------ \n\n";

    System.out.println(newBoard);
  }
}
