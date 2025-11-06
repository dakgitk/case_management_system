package com.casemanagement.system.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

import com.casemanagement.system.model.CaseType;
import com.casemanagement.system.model.CaseTypeRepository;
import com.casemanagement.system.model.ClientCase;
import com.casemanagement.system.model.ClientCaseRepository;
import com.casemanagement.system.model.ClientRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
// @ResponseBody
public class CaseController {

  @Autowired
  private ClientCaseRepository clientcaseRepos;

  @Autowired
  private CaseTypeRepository casetypeRepos;

  @Autowired
  private ClientRepository clientRepos;

  @RequestMapping("/caselist")
  public String firstMethod(Model model) {

    model.addAttribute("clientcaseRepo", clientcaseRepos.findAll());
    //model.addAttribute("casetype", new CaseType()); //newly addded
    return "caseList";
  }

  @GetMapping("/addcase")
  public String addACase(Model model) {
    model.addAttribute("addcasevari", new ClientCase());
    model.addAttribute("typevariables", casetypeRepos.findAll());
    return "addcase";
  }

  @PostMapping("/save")
  public String SaveACase(ClientCase clientcase) {

    if (clientcase.getType() != null && clientcase.getType().getTypeid() != null) {
      Long typeId = clientcase.getType().getTypeid();
      clientcase.setType(casetypeRepos.findById(typeId).orElse(null));
    }

    clientcaseRepos.save(clientcase);
    return "redirect:/caselist";
  }

  @RequestMapping(value = "/deletebyname/{caseNumber}", method = RequestMethod.GET)
  public String deleteCase(@PathVariable("caseNumber") String caseNumber, Model model) {
    clientcaseRepos.deleteByCaseNumber(caseNumber);
    return "redirect:/caselist";
  }

  // @PostMapping("/updateDate")
  // public String updateCourtDate(ClientCase updatedCase) {
  //   ClientCase existingCase = clientcaseRepos.findById(updatedCase.getId())
  //       .orElseThrow(() -> new IllegalArgumentException("Invalid case ID: " + updatedCase.getId()));

  //   existingCase.setCourtDate(updatedCase.getCourtDate()); // only update the date
  //   clientcaseRepos.save(existingCase);

  //   return "redirect:/caselist";
  // }

}
