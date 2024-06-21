package com.testing.springboot.client.models;

public class PokeDex {

    public String id;
    private boolean is_default;
    private String location_area_encounters;

    private String name;
    private int order;
    private int weight;

    public PokeDex(String id) {
        this.id = id;
    }
    public PokeDex() {
    }
}
