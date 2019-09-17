package example.presentation.holdings;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import example.domain.concerns.searchHolding.beans.ProgramHoldingBeans;
import example.application.queryservices.holdings.ProgramHoldingQueryService;
import example.domain.values.programs.ProgramCode;

import javax.validation.Valid;

@Controller
@RequestMapping("holdings")
public class HoldingController {

    ProgramHoldingQueryService programHoldingQueryService;


    public HoldingController(ProgramHoldingQueryService programHoldingQueryService) {
        this.programHoldingQueryService = programHoldingQueryService;
    }

    @GetMapping(params = "programCode")
    public String index(@ModelAttribute @Valid ProgramCode programCode,
                        Model model){

        ProgramHoldingBeans holdings = programHoldingQueryService.queryHoldings(programCode);
        model.addAttribute(holdings);

        return "holdings/index";
    }
}
