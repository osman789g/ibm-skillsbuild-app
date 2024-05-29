package com.example.newone.controller;

//added this all
import com.example.newone.model.Review;
import com.example.newone.repos.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;

    //mapping to pass through all the reviews in the database and into the checkreviews page
    @GetMapping("/Reviewpage")
    public String CheckReview(Model model) {
        model.addAttribute("reviews", reviewRepository.findAll());
        return "CheckReviews";
    }

    @RequestMapping("/newReview")
    public String Addreview(@RequestParam("course") String coursename, Model model) {

        model.addAttribute("review", new Review());
        model.addAttribute("coursename", coursename);
        return "Reviewform";
    }

    @PostMapping("/addReview")
    public String addAgent(@ModelAttribute Review review, @RequestParam("course") String coursename) {
        review.setCoursenames(coursename);
        reviewRepository.save(review);
        return "redirect:/";
    }
}