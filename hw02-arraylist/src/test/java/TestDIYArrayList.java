import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import ru.otus.hw.DIYArrayList;

public class TestDIYArrayList {
    @Test
    void testAddAll() {
        var expected = IntStream.range(0, 256).boxed().toArray(Integer[]::new);
        var list = new DIYArrayList<Integer>();
        Collections.addAll(list, expected);

        Assertions.assertArrayEquals(list.toArray(), expected);
    }

    @Test
    void testCopyBelowThreshold() {
        var expected = new Integer[]{1, 2, 3, 4};
        var list = new DIYArrayList<Integer>(expected);
        var destList = Arrays.asList(0, 0, 0, 0);
        Collections.copy(destList, list);

        Assertions.assertArrayEquals(destList.toArray(), expected);
    }

    @Test
    void testCopyAboveThreshold() {
        var expected = IntStream.range(0, 256).boxed().toArray(Integer[]::new);
        var list = new DIYArrayList<Integer>(expected);
        var destList = Arrays.asList(new Integer[expected.length]);
        Collections.copy(destList, list);

        Assertions.assertArrayEquals(destList.toArray(), expected);
    }


    @Test
    void testSort() {
        var expected = IntStream.range(0, 256).boxed().collect(Collectors.toList());
        var shuffled = Arrays.asList(new Integer[expected.size()]);
        Collections.copy(shuffled, expected);
        Collections.shuffle(shuffled);
        var list = new DIYArrayList<Integer>(shuffled.toArray(Integer[]::new));
        Collections.sort(list);

        Assertions.assertArrayEquals(list.toArray(), expected.toArray());
    }
}
