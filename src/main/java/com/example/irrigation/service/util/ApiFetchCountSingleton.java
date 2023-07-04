package com.example.irrigation.service.util;

public class ApiFetchCountSingleton {
    private static ApiFetchCountSingleton INSTANCE = null;
    private int fetchCount;

    public static ApiFetchCountSingleton getInstance(){

        if(INSTANCE == null){
            synchronized(ApiFetchCountSingleton.class){
                INSTANCE = new ApiFetchCountSingleton();
            }
        }
        return INSTANCE;
    }

    public void setFetchCount(int count){
        this.fetchCount = count;
    }
    public int getFetchCount(){
        return fetchCount;

    }
}
