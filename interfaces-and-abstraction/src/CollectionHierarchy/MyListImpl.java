package CollectionHierarchy;

public class MyListImpl extends Collection implements MyList {
    @Override
    public int add(String el) {
        items.add(0, el);
        return 0;
    }


    @Override
    public String remove() {
        return items.remove(0);
    }

    @Override
    public int getUsed() {
        return items.size();
    }
}
