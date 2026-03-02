package com.personal.website.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Root configuration object that maps to "site.*" in application.yml.
 * Edit application.yml to change your personal info — no Java code changes needed.
 */
public class SiteConfig {

    private Owner owner = new Owner();
    private Map<String, String> social = new HashMap<>();
    private List<Skill> skills = new ArrayList<>();
    private List<Project> projects = new ArrayList<>();
    private List<Experience> experience = new ArrayList<>();
    private List<PhotoAlbum> gallery = new ArrayList<>();

    // --- Inner class for owner info ---
    public static class Owner {
        private String name;
        private String title;
        private String tagline;
        private String bio;
        private String email;
        private String location;
        private String avatar;

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }

        public String getTagline() { return tagline; }
        public void setTagline(String tagline) { this.tagline = tagline; }

        public String getBio() { return bio; }
        public void setBio(String bio) { this.bio = bio; }

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }

        public String getLocation() { return location; }
        public void setLocation(String location) { this.location = location; }

        public String getAvatar() { return avatar; }
        public void setAvatar(String avatar) { this.avatar = avatar; }
    }

    // --- Getters & Setters ---
    public Owner getOwner() { return owner; }
    public void setOwner(Owner owner) { this.owner = owner; }

    public Map<String, String> getSocial() { return social; }
    public void setSocial(Map<String, String> social) { this.social = social; }

    public List<Skill> getSkills() { return skills; }
    public void setSkills(List<Skill> skills) { this.skills = skills; }

    public List<Project> getProjects() { return projects; }
    public void setProjects(List<Project> projects) { this.projects = projects; }

    public List<Experience> getExperience() { return experience; }
    public void setExperience(List<Experience> experience) { this.experience = experience; }

    public List<PhotoAlbum> getGallery() { return gallery; }
    public void setGallery(List<PhotoAlbum> gallery) { this.gallery = gallery; }
}
