import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class Movements {

    private Board board;

    public Board move(Integer positionPlayer, String player, Integer position) {
        if (validatePositionPlayer(positionPlayer, player) && validatePositionToGo(position, positionPlayer)) {
            sanitizeBoard(position);
            setPlayerOnBoard(positionPlayer, player);
        }

        return this.board;
    }

    public void sanitizeBoard(Integer position) {
        switch (position) {
            case 0:
                this.board.getFirstHorizontalLine().get(0).put(0, "");
            case 1:
                this.board.getFirstHorizontalLine().get(2).put(1, "");
            case 2:
                this.board.getSecondHorizontalLine().get(1).put(2, "");
            case 3:
                this.board.getThirdHorizontalLine().get(0).put(3, "");
            case 4:
                this.board.getThirdHorizontalLine().get(2).put(4, "");
        }
    }

    public void setPlayerOnBoard(Integer playerPosition, String player) {
        switch (playerPosition) {
            case 0:
                this.board.getFirstHorizontalLine().get(0).put(0, player);
            case 1:
                this.board.getFirstHorizontalLine().get(2).put(1, player);
            case 2:
                this.board.getSecondHorizontalLine().get(1).put(2, player);
            case 3:
                this.board.getThirdHorizontalLine().get(0).put(3, player);
            case 4:
                this.board.getThirdHorizontalLine().get(2).put(4, player);
        }
    }


    public Boolean validatePositionToGo(Integer positionToGo, Integer positionPlayer) {

        switch (positionToGo) {
            case 0:
                Map<Integer, String> fp = this.board.getFirstHorizontalLine().get(0);
                if(fp.isEmpty()) {
                    if(positionPlayer == 3 || positionPlayer == 2) {
                        return true;
                    }
                }
            case 1:
                Map<Integer, String>  sp = this.board.getFirstHorizontalLine().get(2);
                if(sp.isEmpty()) {
                    if(positionPlayer == 2 || positionPlayer == 4) {
                        return true;
                    }
                }
            case 2:
                Map<Integer, String>  tp = this.board.getSecondHorizontalLine().get(1);
                if(tp.isEmpty()) {
                    return true;
                }
            case 3:
                Map<Integer, String>  qp = this.board.getThirdHorizontalLine().get(0);
                if(qp.isEmpty()) {
                    if(positionPlayer == 0 || positionPlayer == 2 ) {
                        return true;
                    }
                }
            case 4:
                Map<Integer, String>  qtp = this.board.getThirdHorizontalLine().get(2);
                if(qtp.isEmpty()) {
                    if(positionPlayer == 2 || positionPlayer == 3 ) {
                        return true;
                    }
                }
        }

        return false;
    }

    public Boolean validatePositionPlayer(Integer positionPlayer, String namePlayer) {
        if(positionPlayer == 0 || positionPlayer == 1) {
            for(Map<Integer, String> positionMap : this.board.getFirstHorizontalLine()) {
                if(!positionMap.get(positionPlayer).isEmpty() && positionMap.get(positionPlayer).equals(namePlayer)) {
                    return true;
                }
            }
        }

        if(positionPlayer == 2) {
            for(Map<Integer, String> positionMap : this.board.getSecondHorizontalLine()) {
                if(!positionMap.get(positionPlayer).isEmpty() && positionMap.get(positionPlayer).equals(namePlayer)) {
                    return true;
                }
            }
        }

        if(positionPlayer == 3 || positionPlayer == 4) {
            for(Map<Integer, String> positionMap : this.board.getThirdHorizontalLine()) {
                if(!positionMap.get(positionPlayer).isEmpty() && positionMap.get(positionPlayer).equals(namePlayer)) {
                    return true;
                }
            }
        }

        return false;
    }

    public Integer loadBestPointToGo(Integer playerPosition) {
        if(playerPosition == 0 || playerPosition == 3) {
            if(validatePositionToGo(4, playerPosition)) {
               return 4;
            } else if (validatePositionToGo(2, playerPosition)) {
                return 2;
            } else if(validatePositionToGo(3, playerPosition)) {
                return 3;
            }
        }

        if(playerPosition == 1) {
            if(validatePositionToGo(2, playerPosition)) {
                return 2;
            } else {
                return 4;
            }
        }

        if(playerPosition == 4) {
            if(validatePositionToGo(2, playerPosition)) {
                return 2;
            } else if(validatePositionToGo(4, playerPosition)) {
                return 4;
            } else if(validatePositionToGo(3, playerPosition)) {
                return 3;
            }
        }

        if(playerPosition == 2) {

            if(validatePositionToGo(1, playerPosition)) {
                return 1;
            } else if(validatePositionToGo(4, playerPosition)) {
                return 4;
            } else if(validatePositionToGo(3, playerPosition)) {
                return 3;
            }
        }

        return null;
    }
}
