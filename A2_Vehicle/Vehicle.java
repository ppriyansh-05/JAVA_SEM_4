
    }

    // Copy Constructor
    public Vehicle(Vehicle v) {
        this.brandName = v.brandName;
        this.modelName = v.modelName;
        this.price = v.price;
        this.fuelType = v.fuelType;
    }

    // Getters
    public String getBrandName() {
        return brandName;
    }

    public String getModelName() {
        return modelName;
    }

    public double getPrice() {
        return price;
    }

    public String getFuelType() {
        return fuelType;
    }

    // Setters
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    // Methods (Same as Teacher Style)
    public void start() {
        System.out.println(brandName + " started.");
    }

    public void stop() {
        System.out.println(brandName + " stopped.");
    }

    public void drive() {
        System.out.println(brandName + " is driving.");
    }

    public float changeSpeed(float currentSpeed) {
        float newSpeed = currentSpeed + 20;
        return newSpeed;
    }

    // Modified Mileage Method (Extra Logic)
    public float calcMileage(float distance, float fuelUsed) {

        float baseMileage = distance / fuelUsed;

        if (fuelType.equalsIgnoreCase("Petrol")) {
            return baseMileage;
        }
        else if (fuelType.equalsIgnoreCase("Diesel")) {
            return baseMileage + 5;
        }
        else if (fuelType.equalsIgnoreCase("Electric")) {
            return baseMileage + 20;
        }
        else if (fuelType.equalsIgnoreCase("Hybrid")) {
            return baseMileage + 10;
        }
        else {
            return baseMileage;
        }
    }
}

