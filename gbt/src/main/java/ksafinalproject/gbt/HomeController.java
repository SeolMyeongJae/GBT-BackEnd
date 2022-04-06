package ksafinalproject.gbt;

import java.io.File;
import java.io.InputStream;
import javax.swing.filechooser.FileSystemView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class HomeController {

    @GetMapping("/")
    public String main() {
        return "main";
    }

    @GetMapping("/api/admin/home")
    public String index() {
        return "home";
    }

    @GetMapping("/api/admin/challenge")
    public String test() {return "challenge";}

    @GetMapping("/api/admin/community")
    public String community() {return "community";}

    @GetMapping("/api/admin/challenge/save")
    public String challengeSave() {
        return "challenge-save";
    }

    @PostMapping("/upload")
    public String upload(String title, String name, String content, @RequestParam("files")MultipartFile file) throws Exception {
//        String rootPath = FileSystemView.getFileSystemView().getHomeDirectory().toString();
//        String basePath = rootPath + "/" + "single";
//
//        String filePath = basePath + "/" + file.getOriginalFilename();
//
//        File dest = new File(filePath);
//        file.transferTo(dest);
//        ObjectMeta
//        String fileName = file.getOriginalFilename();
//        file.getContentType();
//        InputStream inputStream = file.getInputStream();
        return "uploaded";
    }
}