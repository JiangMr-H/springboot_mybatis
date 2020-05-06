/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: UqCodeController
 * Author:   891649
 * Date:     2020/4/26 15:38
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.jiang.controller;

import com.jiang.Entity.Code;
import com.jiang.repository.UpCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author 891649
 * @create 2020/4/26
 * @since 1.0.0
 */
@RestController
@RequestMapping("/up")
@CrossOrigin(origins = "*", allowCredentials = "true")
public class CodeController {

    @Autowired
    private UpCodeRepository upCodeRepository;

    /**
     * 按点位查询所有信息
     *
     * @param tap
     * @return
     */
    @GetMapping("/queryCode/{tap}")
    public List<Code> queryUpCode(@PathVariable("tap") String tap) {
        return upCodeRepository.queryUpCodeByTau(tap);
    }

    /**
     * 根据tau查询
     * @param tau
     * @param model
     * @return
     */
    @GetMapping("{tau}")
    public ModelAndView queryCodeByTau(@PathVariable("tau") String tau,Model model){
        List<Code> list = upCodeRepository.queryUpCodeByTau(tau);
        model.addAttribute("codeList",list);
        model.addAttribute("title", "现场巡检");
        return new ModelAndView("up/codeList", "codeModel", model);
    }

    /**
     * 查询所有信息
     *
     * @param model
     * @return
     */
    @GetMapping
    public ModelAndView list(Model model) {
        model.addAttribute("codeAllList", upCodeRepository.findAll());
        model.addAttribute("title", "现场巡检");
        return new ModelAndView("up/codeAllList", "codeModel", model);
    }

/*    @PostMapping
    public ModelAndView saveOrUpdateCode(Code code,Model model){
        Code c = upCodeRepository.saveOrUpdateCode(code);
        return new ModelAndView("up/save","codeModel", model);

    }*/


}