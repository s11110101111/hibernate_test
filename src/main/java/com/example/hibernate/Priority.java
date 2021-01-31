package com.example.hibernate;

public enum Priority {
    LOW(1),MEDIUM(5), HIGH(10),HIGHEST(20);
Priority(int lvl){
        this.lvl=lvl;
}
    int lvl;
}
