package ksafinalproject.gbt;

import java.io.IOException;
import java.util.List;
import ksafinalproject.gbt.challenge.model.Challenge;
import ksafinalproject.gbt.challenge.service.ChallengeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Controller
public class HomeController {
    private final S3Uploader s3Uploader;
    private final ChallengeService challengeService;

    @GetMapping("/")
    public String main() {
        return "main";
    }

    @GetMapping("/api/admin/home")
    public String index() {
        return "home";
    }

    @GetMapping("/api/admin/challenge")
    public String test(Model model) {
        List<Challenge> challenges = challengeService.getAllChallenge();
        model.addAttribute("challenges", challengeService.getAllChallenge());

        return "challenge/challenge";
    }

    @GetMapping("/api/admin/community")
    public String community() {return "community";}

    @GetMapping("/api/admin/challenge/save")
    public String challengeSave() {
        return "challenge/challenge-save";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("files") MultipartFile file) throws IOException {
        System.out.println(s3Uploader.bucket);
        System.out.println(file.getOriginalFilename());
        s3Uploader.upload(file, "static");
        return "home";
    }
}