package com.personal.website.controller;

import com.personal.website.model.PhotoAlbum;
import com.personal.website.model.SiteConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

/**
 * Serves the photography gallery pages.
 */
@Controller
public class GalleryController {

    private final SiteConfig siteConfig;

    public GalleryController(SiteConfig siteConfig) {
        this.siteConfig = siteConfig;
    }

    /** Gallery overview — shows all albums */
    @GetMapping("/gallery")
    public String gallery(Model model) {
        model.addAttribute("owner", siteConfig.getOwner());
        model.addAttribute("social", siteConfig.getSocial());
        model.addAttribute("albums", siteConfig.getGallery());
        return "gallery";
    }

    /** Single album view — shows photos in one album */
    @GetMapping("/gallery/{slug}")
    public String album(@PathVariable String slug, Model model) {
        Optional<PhotoAlbum> album = siteConfig.getGallery().stream()
                .filter(a -> slug.equals(a.getSlug()))
                .findFirst();

        if (album.isEmpty()) {
            return "redirect:/gallery";
        }

        model.addAttribute("owner", siteConfig.getOwner());
        model.addAttribute("social", siteConfig.getSocial());
        model.addAttribute("album", album.get());
        model.addAttribute("albums", siteConfig.getGallery());
        return "album";
    }
}
