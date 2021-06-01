import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class Board {
    private List<Map<Integer, String>> firstHorizontalLine;
    private List<Map<Integer, String>> secondHorizontalLine;
    private List<Map<Integer, String>> thirdHorizontalLine;

}
