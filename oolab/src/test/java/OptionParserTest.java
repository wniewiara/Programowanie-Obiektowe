import agh.ics.oop.MapDirection;
import agh.ics.oop.MoveDirection;
import agh.ics.oop.OptionsParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OptionParserTest {
    @Test
    void optionparserTest(){
        OptionsParser optionParser=new OptionsParser();

        String[] input1 = new String[] {"b","back","dsd"};
        Assertions.assertThrows(IllegalArgumentException.class, () -> optionParser.parse(input1));

        String[] input2 = new String[] {"f","r","l","rr"};
        Assertions.assertThrows(IllegalArgumentException.class, () -> optionParser.parse(input2));

    }
}
