package com.codecrew.fantasticket.enums;

public enum Role {
    CUSTOMER(0),
    ADMIN(1);
    
    private Integer type;
    
    public Integer getType() {
        return type;
    }
    
    Role(Integer type){
        this.type = type;
    }
    
    public static Role get(Integer type){
        switch (type){
            case 0:
                return CUSTOMER;
            case 1:
                return ADMIN;
            default:
                throw new IllegalArgumentException("No such a type "+ type);
        }
    }
}