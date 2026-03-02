package com.personal.website.controller;

import com.personal.website.model.SiteConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Main controller — serves the single-page personal website.
 */
@Controller
public class HomeController {

    private final SiteConfig siteConfig;

    public HomeController(SiteConfig siteConfig) {
        this.siteConfig = siteConfig;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("owner", siteConfig.getOwner());
        model.addAttribute("social", siteConfig.getSocial());
        model.addAttribute("skills", siteConfig.getSkills());
        model.addAttribute("projects", siteConfig.getProjects());
        model.addAttribute("experience", siteConfig.getExperience());
        model.addAttribute("albums", siteConfig.getGallery());
        return "index";
    }
}
