package CollectionHierarchy;

public class AddRemoveCollection extends Collection implements AddRemovable{
    @Override
    public int add(String el) {
        items.add(0, el);
        return 0;
    }

    @Override
    public String remove() {
        return items.remove(items.size() - 1);
    }
}
