package Task6;

import java.util.List;

public class Warehouse {
    private Long id;
    private String name;
    private List<StockItem> items;

    public Warehouse(Long id, String name, List<StockItem> items) {
        this.id = id;
        this.name = name;
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", items=" + items +
                '}';
    }

    public List<StockItem> getItems() {
        return items;


    }
}

