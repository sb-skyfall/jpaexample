package com.jpa.jpaexample.model;

public enum StrategyName {
    SearchByName("SearchByName"),
    SearchByDepartment("SearchByDepartment"),
    SearchByAll("SearchByAll");

    private String strategyName;

    StrategyName(String strategyName) {
        this.strategyName=strategyName;

    }

    public String getStrategyName() {
        return strategyName;
    }

    public static StrategyName getEnum(String value) {
        System.out.println("value = " + value);

        for(StrategyName v : values()) {
            System.out.println("Starategy Value = " + v.getStrategyName());

            if ("SearchByAll".equalsIgnoreCase(value)) {
                return StrategyName.SearchByAll;
            }
        }
        throw new IllegalArgumentException("No Argument matched with "+value);
    }


}
