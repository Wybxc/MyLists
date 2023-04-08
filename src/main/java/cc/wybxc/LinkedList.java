package cc.wybxc;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.IntFunction;
import java.util.function.Predicate;

public class LinkedList<E> implements ICollection<E> {
    static class Node<E> {
        E value;
        @Nullable
        Node<E> next;

        Node(E value) {
            this.value = value;
            this.next = null;
        }
    }

    @NotNull
    Node<E> head;

    public LinkedList() {
        head = new Node<>(null);
    }

    /**
     * 添加元素。
     *
     * @param value 元素。
     */
    @Override
    public void add(E value) {
        var node = head;
        if (value instanceof Comparable<?>) {
            @SuppressWarnings("unchecked")
            var comparable = (Comparable<E>) value;
            while (node.next != null) {
                if (comparable.compareTo(node.next.value) < 0) {
                    break;
                }
                node = node.next;
            }
        }
        var newNode = new Node<>(value);
        newNode.next = node.next;
        node.next = newNode;
    }

    /**
     * 删除元素。
     *
     * @param predicate 删除条件。
     * @return 删除掉的元素数量。
     */
    @Override
    public int remove(@NotNull Predicate<E> predicate) {
        int removed = 0;
        var node = head;
        while (node.next != null) {
            if (predicate.test(node.next.value)) {
                node.next = node.next.next;
                removed++;
            } else {
                node = node.next;
            }
        }
        return removed;
    }

    /**
     * 删除元素。
     *
     * @param predicate 删除条件。
     * @param count     最大删除数量。
     * @return 实际删除掉的元素数量。
     */
    @Override
    public int remove(@NotNull Predicate<E> predicate, int count) {
        int removed = 0;
        var node = head;
        while (node.next != null) {
            if (predicate.test(node.next.value)) {
                node.next = node.next.next;
                removed++;
                if (removed >= count) {
                    break;
                }
            } else {
                node = node.next;
            }
        }
        return removed;
    }

    /**
     * 获取元素数量。
     *
     * @return 元素数量。
     */
    @Override
    public int size() {
        int size = 0;
        var node = head;
        while (node.next != null) {
            size++;
            node = node.next;
        }
        return size;
    }

    /**
     * 检查是否包含元素。
     *
     * @param value 元素值。
     * @return 是否包含。
     */
    @Override
    public boolean contains(E value) {
        var node = head;
        while (node.next != null) {
            if (node.next.value.equals(value)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    /**
     * 检查是否包含元素。
     *
     * @param predicate 元素条件。
     * @return 是否包含。
     */
    @Override
    public boolean contains(@NotNull Predicate<E> predicate) {
        var node = head;
        while (node.next != null) {
            if (predicate.test(node.next.value)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    /**
     * 将集合转换为数组。
     *
     * @return 数组。
     */
    @Override
    public @NotNull E[] toArray(IntFunction<E[]> generator) {
        var array = generator.apply(size());
        var node = head;
        int index = 0;
        while (node.next != null) {
            array[index++] = node.next.value;
            node = node.next;
        }
        return array;
    }
}
