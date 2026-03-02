/**
 * Personal Website - Main JavaScript
 * Theme toggle, navbar, mobile menu, scroll animations, skill bars, lightbox
 */
(function () {
    "use strict";

    // ---- Theme Toggle ----
    var themeToggle = document.getElementById("themeToggle");
    if (themeToggle) {
        var prefersDark = window.matchMedia("(prefers-color-scheme: dark)").matches;
        var stored = localStorage.getItem("theme");
        var initialTheme = stored || (prefersDark ? "dark" : "light");

        function applyTheme(theme) {
            document.documentElement.setAttribute("data-theme", theme);
            themeToggle.textContent = (theme === "dark") ? "\u2600\uFE0F" : "\uD83C\uDF19";
            localStorage.setItem("theme", theme);
        }
        applyTheme(initialTheme);

        themeToggle.addEventListener("click", function (e) {
            e.preventDefault();
            var current = document.documentElement.getAttribute("data-theme");
            applyTheme(current === "dark" ? "light" : "dark");
        });
    }

    // ---- Navbar Scroll Effect ----
    var navbar = document.getElementById("navbar");
    if (navbar) {
        window.addEventListener("scroll", function () {
            navbar.classList.toggle("scrolled", window.scrollY > 10);
        });
    }

    // ---- Active Nav Link Highlight ----
    var sections = document.querySelectorAll(".section, #hero");
    var navLinks = document.querySelectorAll('.nav-links a[href^="#"]');

    if (sections.length > 0 && navLinks.length > 0) {
        function setActiveLink() {
            var current = "";
            sections.forEach(function (section) {
                var top = section.offsetTop - 100;
                if (window.scrollY >= top) {
                    current = section.getAttribute("id");
                }
            });
            navLinks.forEach(function (link) {
                link.classList.remove("active");
                if (link.getAttribute("href") === "#" + current) {
                    link.classList.add("active");
                }
            });
        }
        window.addEventListener("scroll", setActiveLink);
    }

    // ---- Mobile Menu Toggle ----
    var navToggle = document.getElementById("navToggle");
    var navLinksEl = document.getElementById("navLinks");
    if (navToggle && navLinksEl) {
        navToggle.addEventListener("click", function () {
            navToggle.classList.toggle("active");
            navLinksEl.classList.toggle("open");
        });
        navLinksEl.querySelectorAll("a").forEach(function (link) {
            link.addEventListener("click", function () {
                navToggle.classList.remove("active");
                navLinksEl.classList.remove("open");
            });
        });
    }

    // ---- Scroll Animations (Intersection Observer) ----
    function initScrollAnimations() {
        var els = document.querySelectorAll(
            ".skill-card, .project-card, .timeline-item, .about-content, .contact-content, .album-card, .album-card-large, .photo-item"
        );
        if (els.length === 0) return;
        els.forEach(function (el) { el.classList.add("fade-in"); });
        var obs = new IntersectionObserver(function (entries) {
            entries.forEach(function (entry) {
                if (entry.isIntersecting) {
                    entry.target.classList.add("visible");
                    obs.unobserve(entry.target);
                }
            });
        }, { threshold: 0.08 });
        els.forEach(function (el) { obs.observe(el); });
    }
    initScrollAnimations();

    // ---- Animate Skill Bars ----
    function initSkillBars() {
        var bars = document.querySelectorAll(".skill-fill");
        if (bars.length === 0) return;
        var obs = new IntersectionObserver(function (entries) {
            entries.forEach(function (entry) {
                if (entry.isIntersecting) {
                    entry.target.style.width = entry.target.getAttribute("data-level") + "%";
                    obs.unobserve(entry.target);
                }
            });
        }, { threshold: 0.3 });
        bars.forEach(function (bar) { obs.observe(bar); });
    }
    initSkillBars();

    // ---- Lightbox (Album page) ----
    function initLightbox() {
        var lightbox = document.getElementById("lightbox");
        var lbImg = document.getElementById("lightboxImg");
        var lbCap = document.getElementById("lightboxCaption");
        var lbClose = document.getElementById("lightboxClose");
        var lbPrev = document.getElementById("lightboxPrev");
        var lbNext = document.getElementById("lightboxNext");
        var photos = document.querySelectorAll(".photo-item");
        if (!lightbox || photos.length === 0) return;

        var idx = 0;

        function openLightbox(i) {
            idx = i;
            var item = photos[i];
            var img = item.querySelector("img");
            var cap = item.querySelector(".photo-caption span");
            if (img) lbImg.src = img.src;
            lbCap.textContent = cap ? cap.textContent : "";
            lightbox.style.display = "flex";
            document.body.style.overflow = "hidden";
        }

        function closeLightbox() {
            lightbox.style.display = "none";
            document.body.style.overflow = "";
            lbImg.src = "";
        }

        function navigateLightbox(delta) {
            idx = (idx + delta + photos.length) % photos.length;
            openLightbox(idx);
        }

        photos.forEach(function (item, i) {
            item.addEventListener("click", function () { openLightbox(i); });
        });

        if (lbClose) lbClose.addEventListener("click", closeLightbox);
        if (lbPrev) lbPrev.addEventListener("click", function () { navigateLightbox(-1); });
        if (lbNext) lbNext.addEventListener("click", function () { navigateLightbox(1); });

        document.addEventListener("keydown", function (e) {
            if (lightbox.style.display !== "flex") return;
            if (e.key === "Escape") closeLightbox();
            if (e.key === "ArrowLeft") navigateLightbox(-1);
            if (e.key === "ArrowRight") navigateLightbox(1);
        });

        lightbox.addEventListener("click", function (e) {
            if (e.target === lightbox) closeLightbox();
        });
    }
    initLightbox();

    // ---- Smooth Scroll for anchor links ----
    document.querySelectorAll('a[href^="#"]').forEach(function (anchor) {
        anchor.addEventListener("click", function (e) {
            var targetId = this.getAttribute("href");
            if (targetId === "#") return;
            var target = document.querySelector(targetId);
            if (target) {
                e.preventDefault();
                target.scrollIntoView({ behavior: "smooth" });
            }
        });
    });

})();
