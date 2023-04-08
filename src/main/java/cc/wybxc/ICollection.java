package cc.wybxc;

import org.jetbrains.annotations.NotNull;

import java.util.function.IntFunction;
import java.util.function.Predicate;

/**
 * 集合接口。
 */
public interface ICollection<E> {
    /**
     * 添加元素。
     *
     * @param value 元素。
     */
    void add(E value);

    /**
     * 删除元素。
     *
     * @param predicate 删除条件。
     * @return 删除掉的元素数量。
     */
    int remove(@NotNull Predicate<E> predicate);

    /**
     * 删除元素。
     *
     * @param predicate 删除条件。
     * @param count     最大删除数量。
     * @return 实际删除掉的元素数量。
     */
    int remove(@NotNull Predicate<E> predicate, int count);

    /**
     * 获取元素数量。
     *
     * @return 元素数量。
     */
    int size();

    /**
     * 检查是否包含元素。
     *
     * @param value 元素值。
     * @return 是否包含。
     */
    boolean contains(E value);

    /**
     * 检查是否包含元素。
     *
     * @param predicate 元素条件。
     * @return 是否包含。
     */
    boolean contains(@NotNull Predicate<E> predicate);

    /**
     * 将集合转换为数组。
     *
     * @return 数组。
     */
    @NotNull E[] toArray(IntFunction<E[]> generator);
}
