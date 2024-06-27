package com.testing.springboot.client.models;
import java.util.*;

public class PokeDex {
    private Number id;
    private boolean is_default;
    private String location_area_encounters;
    private Object moves;
    private String name;
    private Number order;
    private Object past_abilities;
    private Object past_types;
    private Object species;

    private Object sprites;
    private Object stats;
    private Object types;
    private Number weight;

    public PokeDex(String name) {
        this.name = name;
    }
    public PokeDex() {
    }
    public Map<String, String> getPkm(){
        Map<String, String> map = new LinkedHashMap<String, String>();
        map.put("Id", id.toString());
        map.put("Is Default", is_default ? "Yes" : "No");
        map.put("Location Area Encounters", location_area_encounters);
        map.put("Moves", moves.toString());
        map.put("Name",  name);
        map.put("Order", order.toString());
        map.put("Past Abilities", past_abilities.toString());
        map.put("Past Types", past_types.toString());
        map.put("Species", species.toString());
        map.put("Sprites", sprites.toString());
        map.put("Stats", stats.toString());
        map.put("Types", types.toString());
        map.put("Weight", weight.toString());

        return map;
    }

    public Number getId() {
        return id;
    }

    public boolean isIs_default() {
        return is_default;
    }

    public String getLocation_area_encounters() {
        return location_area_encounters;
    }

    public String getName() {
        return name;
    }

    public Number getOrder() {
        return order;
    }

    public Number getWeight() {
        return weight;
    }

    public Object getSpecies() {
        return species;
    }

    public Object getSprites() {
        return sprites;
    }

    public Object getMoves() {
        return moves;
    }

    public Object getPast_abilities() {
        return past_abilities;
    }

    public Object getPast_types() {
        return past_types;
    }

    public Object getStats() {
        return stats;
    }

    public Object getTypes() {
        return types;
    }

}
