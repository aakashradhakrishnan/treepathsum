package com.aakash.treepathsum.controller;

import com.aakash.treepathsum.model.TreeSumRequest;
import com.aakash.treepathsum.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
public class TreeController {
    private TreeService treeService;

    @Autowired
    public TreeController(TreeService treeService){
        this.treeService = treeService;
    }

    @RequestMapping(value = "/calculate", method = RequestMethod.GET)
    public ModelAndView getRegForm(ModelAndView modelAndView, Model model){
        model.addAttribute("treeSumRequest", new TreeSumRequest());
        modelAndView.setViewName("calculator");
        return modelAndView;
    }

    @RequestMapping(value = "/calculate", method = RequestMethod.POST)
    public ModelAndView calculateLongestPath(ModelAndView modelAndView, @ModelAttribute("treeSumRequest") TreeSumRequest treeSumRequest, BindingResult bindingResult, Model model){
        String output = treeService.calculateLongestPath(treeSumRequest.getTree());

        modelAndView.addObject("treeSumRequest", treeSumRequest);
        modelAndView.setViewName("calculator");
        modelAndView.addObject("confirmationMessage", "Max Sum of tree is: "+output);
        return modelAndView;
    }
}
