package data;

public enum Calculator {
    SHIRTS("МАЙКИ, ФУФАЙКИ",
            "БЕЛАРУСЬ",
            "БЕЛОРУССКИЙ РУБЛЬ",
            "1000",
            "10000",
            "227,15 Br"),
    // 6109902000
    PANTS("БРЮКИ МУЖСКИЕ ДЕНИМ",
            "КИТАЙ",
            "ЮАНЬ",
            "82000",
            "2000",
            "55 939,24 ¥");
    // 6203423100

    private final String product;
    private final String country;
    private final String currency;
    private final String cost;
    private final String weight;
    private final String result;

    Calculator(String product, String country, String currency, String cost,
               String weight, String result) {
        this.product = product;
        this.country = country;
        this.currency = currency;
        this.cost = cost;
        this.weight = weight;
        this.result = result;
    }

    public String getProduct() {
        return product;
    }

    public String getCountry() {
        return country;
    }

    public String getCurrency() {
        return currency;
    }

    public String getCost() {
        return cost;
    }

    public String getWeight() {
        return weight;
    }

    public String getResult() {
        return result;
    }
}