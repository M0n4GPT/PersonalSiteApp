package com.personal.website.model;

/**
 * Represents a skill with a name and proficiency level (0-100).
 */
public class Skill {

    private String name;
    private int level;

    public Skill() {}

    public Skill(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }
}
