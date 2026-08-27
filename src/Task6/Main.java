package Task6;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static Map<String, BigDecimal> calculateWarehouseValues(List<Warehouse> warehouses) {
        return warehouses.stream()
                .collect(Collectors.toMap(Warehouse::getName, warehouse -> warehouse.getItems().stream()
                        .map(stockItem -> stockItem.getUnitPrice().multiply(
                                BigDecimal.valueOf(stockItem.getQuantity())))
                        .reduce(BigDecimal.ZERO, BigDecimal::add)));


    }

    public static Optional<Warehouse> findMostValuableWarehouse(
            List<Warehouse> warehouses) {
        return warehouses.stream()
                .max(Comparator.comparing(warehouse -> warehouse.getItems().stream()
                        .map(stockItem -> stockItem.getUnitPrice().multiply(
                                BigDecimal.valueOf(stockItem.getQuantity())))
                        .reduce(BigDecimal.ZERO, BigDecimal::add)));
    }

    public static BigDecimal calculateTotalValue(List<Warehouse> warehouses) {
        return warehouses.stream()
                .flatMap(warehouse -> warehouse.getItems().stream())
                .map(stockItem -> stockItem.getUnitPrice().multiply(
                        BigDecimal.valueOf(stockItem.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

     static void main(String[] args) {
        Warehouse a = new Warehouse(1L, "Warehouse A", List.of(
                new StockItem("Laptop", 10, BigDecimal.valueOf(1500)),
                new StockItem("Mouse", 50, BigDecimal.valueOf(30))
        ));

        Warehouse b = new Warehouse(2L, "Warehouse B", List.of(
                new StockItem("Laptop", 5, BigDecimal.valueOf(1500)),
                new StockItem("Monitor", 20, BigDecimal.valueOf(400))
        ));

        Warehouse c = new Warehouse(3L, "Warehouse C", List.of(
                new StockItem("Keyboard", 100, BigDecimal.valueOf(50))
        ));

        List<Warehouse> warehouses = List.of(a, b, c);

        Map<String, BigDecimal> warehouseValues = calculateWarehouseValues(warehouses) ;
        Optional<Warehouse> mostValuableWarehouse = findMostValuableWarehouse(warehouses);
        BigDecimal totalValue = calculateTotalValue(warehouses);

        System.out.println("Warehouse values: "+warehouseValues);
        System.out.println("Most valuable warehouse: "+mostValuableWarehouse);
        System.out.println("Total value: "+totalValue);


    }
}