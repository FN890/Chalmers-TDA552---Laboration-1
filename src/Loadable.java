import java.util.ArrayList;

public class Loadable<T> implements ILoadable<T> {

    /**
     * The maximum capacity.
     */
    private final int maximumCapacity;

    /**
     * List containing the objects.
     */
    private final ArrayList<T> objectArrayList;

    Loadable(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
        objectArrayList = new ArrayList<>();
    }

    /**
     * @param object Loads the specific object.
     * @return True if successfully added.
     */
    @Override
    public boolean load(T object) {
        if (objectArrayList.size() < maximumCapacity) {
            for (T t : objectArrayList) {
                if (t.equals(object)) {
                    return false;
                }
            }
            objectArrayList.add(object);
            return true;
        }
        return false;
    }

    /**
     * @param object Removes the specific object.
     * @return True if successfully removed.
     */
    @Override
    public boolean unload(T object) {
        for (T t : objectArrayList) {
            if (t.equals(object)) {
                objectArrayList.remove(object);
                return true;
            }
        }
        return false;
    }

    public ArrayList<T> getObjectArrayList() {
        return objectArrayList;
    }
}


