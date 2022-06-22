package com.google.sps.data;

public final class SenderInfo {
    long id;
    long timestamp;
    String name;
    String email;
    String message;

    public SenderInfo(long id, 
                        long timestamp, 
                        String n, 
                        String e, 
                        String m){
        this.id = id;
        this.timestamp = timestamp;
        this.name = n;
        this.email = e;
        this.message = m;
    }


    @Override
    public String toString() {
        return "id: " + id + " | timestamp: " + timestamp + " | name: " + name
                + " | email: " + email + " | message: " + message;
    }
}
