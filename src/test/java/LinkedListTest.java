import cc.wybxc.ICollection;
import cc.wybxc.LinkedList;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LinkedListTest {
    @Test
    void testAddString() {
        ICollection<String> list = new LinkedList<>();
        list.add("Hello");
        list.add("World");
        String[] array = list.toArray(String[]::new);
        assert array.length == 2;
        assert Arrays.asList(array).contains("Hello");
        assert Arrays.asList(array).contains("World");
    }

    @Test
    void testAddInteger() {
        ICollection<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        Integer[] array = list.toArray(Integer[]::new);
        assert array.length == 2;
        assert array[0] == 1;
        assert array[1] == 2;
        list.add(3);
        array = list.toArray(Integer[]::new);
        assert array.length == 3;
        assert array[0] == 1;
        assert array[1] == 2;
        assert array[2] == 3;
    }

    @Test
    void testRemoveString() {
        ICollection<String> list = new LinkedList<>();
        list.add("Hello");
        list.add("World");
        list.add("!");
        assert list.remove(s -> s.equals("World")) == 1;
        String[] array = list.toArray(String[]::new);
        assert array.length == 2;
        assert Arrays.asList(array).contains("Hello");
        assert Arrays.asList(array).contains("!");
        assert !Arrays.asList(array).contains("World");
    }

    @Test
    void testRemoveInteger() {
        ICollection<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        assert list.remove(i -> i == 2) == 1;
        Integer[] array = list.toArray(Integer[]::new);
        assert array.length == 2;
        assert array[0] == 1;
        assert array[1] == 3;

        list = new LinkedList<>();
        list.add(3);
        list.add(2);
        list.add(1);
        assert list.remove(i -> i == 2) == 1;
        array = list.toArray(Integer[]::new);
        assert array.length == 2;
        assert array[0] == 1;
        assert array[1] == 3;
    }

    @Test
    void testRemoveLimit() {
        ICollection<Integer> list = new LinkedList<>();
        for (int i = 0; i < 7; i++) {
            list.add(0);
        }
        assert list.remove(i -> i == 0, 5) == 5;
        assert list.size() == 2;
        assert list.remove(i -> i == 0, 5) == 2;
        assert list.size() == 0;
    }

    @Test
    void testContains() {
        ICollection<Integer> list = new LinkedList<>();
        for (int i = 0; i < 7; i++) {
            list.add(i);
        }
        assert list.contains(0);
        assert list.contains(3);
        assert list.contains(6);
        assert !list.contains(7);
        assert list.contains(i -> i > 3);
        assert !list.contains(i -> i > 7);
    }
}
