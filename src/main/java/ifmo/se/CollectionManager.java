package ifmo.se;

import ifmo.se.model.Flat;

import java.util.Collection;
import java.util.Date;
import java.util.Vector;
import java.util.function.Predicate;

/**
 * Класс, управляющий коллекцией
 */
public class CollectionManager {

    private Date initDate;

    private Vector<Flat> collections;

    private long lastId;

    public CollectionManager() {
        this.initDate = new Date();
        collections = new Vector<>();
    }

    public CollectionManager(Vector<Flat> collections, Date initDate) {
        this.collections = collections;
        this.initDate = initDate;
    }

    public void add(Flat flat) {
        flat.setId(lastId++);
        collections.add(flat);
    }

    public void remove(int index) {
        collections.remove(index);
    }

    public void removeAllBy(Predicate<Flat> filter) {
        collections.removeIf(filter);
    }

    public Date getInitDate() {
        return initDate;
    }

    public int getSize() {
        return collections.size();
    }

    public Vector<Flat> getCollections() {
        return collections;
    }

    public long getLastId() {
        return lastId;
    }
}
