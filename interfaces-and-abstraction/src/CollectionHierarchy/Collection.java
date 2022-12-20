package CollectionHierarchy;

import java.util.ArrayList;
import java.util.List;

public abstract class Collection {
    int maxSize = 100;
    List<String> items;

    Collection() {
        this.items = new ArrayList<>();
    }
}
