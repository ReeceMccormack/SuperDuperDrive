package com.SuperDuperDrive.SuperDuperDrive.Controller;



import com.SuperDuperDrive.SuperDuperDrive.Mapper.UserMapper;
import com.SuperDuperDrive.SuperDuperDrive.Model.CredentialForm;
import com.SuperDuperDrive.SuperDuperDrive.Model.NoteForm;
import com.SuperDuperDrive.SuperDuperDrive.Model.User;
import com.SuperDuperDrive.SuperDuperDrive.Service.CredentialService;
import com.SuperDuperDrive.SuperDuperDrive.Service.FileService;
import com.SuperDuperDrive.SuperDuperDrive.Service.NoteService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    private NoteService noteService;
    private FileService fileService;
    private CredentialService credentialsService;
    private UserMapper userMapper;

    public HomeController(NoteService noteService, FileService fileService, CredentialService credentialsService, UserMapper userMapper) {
        this.noteService = noteService;
        this.fileService = fileService;
        this.credentialsService = credentialsService;
        this.userMapper = userMapper;
    }

    @GetMapping
    public String home(@ModelAttribute("note") NoteForm note, @ModelAttribute("credential") CredentialForm credentialForm, Model model, Authentication authentication) {
        String username = authentication.getName();
        User user = userMapper.getUser(username);
        if(user != null) {
            int userId = user.getUserId();
            model.addAttribute("notes", noteService.getUserNotes(userId));
            model.addAttribute("files", fileService.getUserFiles(userId));
            model.addAttribute("credentials", credentialsService.getUserCredentials(userId));
            return "home";
        }
        return "signup";
    }
}