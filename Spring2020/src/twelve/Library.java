package twelve;

import java.util.Iterator;
import java.util.List;

public class Library {
    private List<Shelf> shelves;

    public List<Shelf> getShelves() {
        return shelves;
    }

    public Shelf getShelf(String bookName) {
        for (Shelf s : shelves) {
            for (Book b : s.getBooks()) {
                if (b.getTitle().equals(bookName)) {
                    return s;
                }
            }
        }
        return null;
    }

    public Iterator<Book> iterator() {
        return new BookIterator();
    }

    class BookIterator implements Iterator<Book> {
        private Shelf curShelf;
        private int indexInShelf;

        public BookIterator() {
            curShelf = shelves.get(0);
            indexInShelf = 0;
        }

        @Override
        public boolean hasNext() {
            return shelves.indexOf(curShelf) == shelves.size()-1;
        }

        @Override
        public Book next() {
            if (!hasNext()) {
                return null;
            }
            if (curShelf.getBooks().size()-1 == indexInShelf) { // check if we are last book in shelf
                curShelf = shelves.get(shelves.indexOf(curShelf)+1);
            }
            indexInShelf++;
            return curShelf.getBooks().get(indexInShelf);
        }
    }
    public static void main(String[] args) {
        Library l = new Library();
        Iterator<Book> it = l.iterator();
    }
}
