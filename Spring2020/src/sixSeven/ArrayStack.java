package sixSeven;
import java.util.ArrayList;
import java.util.List;

public class ArrayStack<E> {
    private List<E> arrayList;

    public ArrayStack() {
        arrayList = new ArrayList<>();
    }

    public int size() {
        return arrayList.size();
    }

    public boolean isEmpty() {
        return arrayList.size() == 0;
    }

    public void clear() {
        arrayList.clear();
    }

    public void push(E elem) {
        arrayList.add(elem);
    }

    public E peek() {
        return isEmpty() ? null : arrayList.get(size()-1);
    }

    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E elem = peek();
        arrayList.remove(size()-1);
        return elem;
    }
}
