package CollectionHierarchy;

public class AddCollection extends Collection implements Addable{

    @Override
    public int add(String el) {
        items.add(el);
        return items.indexOf(el);
    }
}
