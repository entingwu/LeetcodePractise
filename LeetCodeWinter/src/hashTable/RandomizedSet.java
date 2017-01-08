package hashTable;

import java.util.*;

/** 这道题让我们在常数时间范围内实现插入删除和获得随机数操作, 用set我们无法在常数时间内实现获取随机数 */
public class RandomizedSet {

    private Map<Integer, Integer> map;
    private List<Integer> list;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element.
     * 删除操作是比较tricky的，我们还是要先判断其是否在哈希表里，如果没有，直接返回false。
     * 由于哈希表的删除是常数时间的，而数组并不是，为了使数组删除也能常数级，我们实际上将要删除的数字和数组的最后一个数字调换个位置，
     * 然后修改对应的哈希表中的值，这样我们只需要删除数组的最后一个元素即可，保证了常数时间内的删除。*/
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int delIndex = map.get(val);
        if (delIndex != list.size() - 1) {
            int lastNum = list.get(list.size() - 1);
            list.set(delIndex, lastNum);
            list.set(list.size() - 1, val);
            map.put(lastNum, delIndex);
        }

        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int randomIndex = new Random().nextInt(list.size());
        return list.get(randomIndex);
    }

    public static void main(String[] args) {
        // Init an empty set.
        RandomizedSet randomSet = new RandomizedSet();

        // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        System.out.println(randomSet.insert(1));

        // Returns false as 2 does not exist in the set.
        System.out.println(randomSet.remove(2));

        // Inserts 2 to the set, returns true. Set now contains [1,2].
        System.out.println(randomSet.insert(2));

        // getRandom should return either 1 or 2 randomly.
        System.out.println(randomSet.getRandom());

        // Removes 1 from the set, returns true. Set now contains [2].
        System.out.println(randomSet.remove(1));

        // 2 was already in the set, so return false.
        System.out.println(randomSet.insert(2));

        // Since 1 is the only number in the set, getRandom always return 1.
        System.out.println(randomSet.getRandom());
    }

    //O(n)
/*    public int getRandom() {
        Random random = new Random();
        int ranIndex = random.nextInt(set.size());
        Iterator<Integer> iterSet = set.iterator();
        int i = 0, randomNum = 0;
        while (iterSet.hasNext() && i < ranIndex) {
            randomNum = iterSet.next();
            i++;
        }
        return randomNum;
    }*/
}
