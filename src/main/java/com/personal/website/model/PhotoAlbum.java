package com.personal.website.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a photo album / collection (e.g., "New York", "Tokyo").
 * Each album has a name, cover image, description, and list of photo entries.
 */
public class PhotoAlbum {

    private String name;
    private String slug;
    private String coverImage;
    private String description;
    private String emoji;
    private List<Photo> photos = new ArrayList<>();

    public PhotoAlbum() {}

    // --- Inner Photo class ---
    public static class Photo {
        private String src;
        private String caption;
        private String date;

        public Photo() {}

        public String getSrc() { return src; }
        public void setSrc(String src) { this.src = src; }

        public String getCaption() { return caption; }
        public void setCaption(String caption) { this.caption = caption; }

        public String getDate() { return date; }
        public void setDate(String date) { this.date = date; }
    }

    // --- Getters & Setters ---
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSlug() { return slug; }
    public void setSlug(String slug) { this.slug = slug; }

    public String getCoverImage() { return coverImage; }
    public void setCoverImage(String coverImage) { this.coverImage = coverImage; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getEmoji() { return emoji; }
    public void setEmoji(String emoji) { this.emoji = emoji; }

    public List<Photo> getPhotos() { return photos; }
    public void setPhotos(List<Photo> photos) { this.photos = photos; }
}
