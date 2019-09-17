package example.presentation.programs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import example.application.queryservices.programs.ProgramQueryService;

@Controller
@RequestMapping("programs")
public class ProgramController {

    ProgramQueryService programQueryService;

    public ProgramController(ProgramQueryService programQueryService) {
        this.programQueryService = programQueryService;
    }

    @GetMapping
    public String programs(Model model) {
        var programs = programQueryService.queryAll();
        model.addAttribute(programs);
        return "programs/index";
    }
}
