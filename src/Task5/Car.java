package Task5;


import java.math.BigDecimal;

enum FuelType {
        PETROL,
        DIESEL,
        HYBRID,
        ELECTRIC
    }

    class Car {
        private Long id;
        private String brand;
        private String model;
        private FuelType fuelType;
        private BigDecimal price;

        public Car(Long id, String brand, String model, FuelType fuelType, BigDecimal price) {
            this.id = id;
            this.brand = brand;
            this.model = model;
            this.fuelType = fuelType;
            this.price = price;
        }

        public Long getId() {
            return id;
        }

        public String getBrand() {
            return brand;
        }

        public String getModel() {
            return model;
        }

        public FuelType getFuelType() {
            return fuelType;
        }

        public BigDecimal getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "id=" + id +
                    ", brand='" + brand + '\'' +
                    ", model='" + model + '\'' +
                    ", price=" + price +
                    '}';
        }
    }

