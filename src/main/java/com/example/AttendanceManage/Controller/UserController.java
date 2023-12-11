package com.example.AttendanceManage.Controller;

import com.example.AttendanceManage.Entity.UserEntity;
import com.example.AttendanceManage.Request.UserRequest;
import com.example.AttendanceManage.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    //ログイン
    @RequestMapping({"/", "/user/login"})
    public String login(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            String msg = "エラー: パスワードまたはユーザーネームが間違っています";
            model.addAttribute("errorMessage", msg);
        }
        return "user/login";
    }

    //リスト
    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public String DisplayList(Model model) {
        List<UserEntity> userlist = userService.searchAll();
        model.addAttribute("userlist", userlist);
        return "user/list";
    }

    //追加
    @RequestMapping(value = "/user/add", method = RequestMethod.GET)
    public String DisplayAdd(Model model) {
        model.addAttribute("userRequest", new UserRequest());
        return "user/add";
    }

    //出勤
    @RequestMapping(value = "/user/begin_time", method=RequestMethod.POST)
    public String Begin(@ModelAttribute UserRequest userRequest, Model model) {
        UserEntity userEntity = userService.FindById(userRequest.getId());
        LocalDateTime nowDate = LocalDateTime.now();
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH時mm分E曜日");
        String formatNowDate = dtf2.format(nowDate);
        userEntity.setBegin_time(formatNowDate);
        model.addAttribute("userRequest", userRequest);
        userService.Begin_time(userRequest);
        return "redirect:/user/list";
    }

    //退勤
    @RequestMapping(value = "/user/end_time", method=RequestMethod.POST)
    public String End(@ModelAttribute UserRequest userRequest, Model model) {
        UserEntity userEntity = userService.FindById(userRequest.getId());
        LocalDateTime nowDate = LocalDateTime.now();
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH時mm分E曜日");
        String formatNowDate = dtf2.format(nowDate);
        userEntity.setEnd_time(formatNowDate);
        model.addAttribute("userRequest", userRequest);
        userService.Begin_time(userRequest);
        return "redirect:/user/list";
    }

    //ユーザー作成
    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public String Create(@Valid @ModelAttribute UserRequest userRequest, BindingResult result, UserEntity userEntity, Model model) {
        //エラー処理
        if (result.hasErrors()) {
            List<String> errorList = new ArrayList<String>();
            for (ObjectError error : result.getAllErrors()) {
                errorList.add(error.getDefaultMessage());
            }
            model.addAttribute("validationError", errorList);
            return "user/add";
        } else {
            // ユーザー情報の登録
            userService.Create(userRequest);
            return "redirect:/user/list";
        }
    }
    //削除機能
    @RequestMapping(value = "/user/delete", method = RequestMethod.GET)
    public String Delete(@ModelAttribute UserRequest userRequest) {
        // ユーザー情報の削除
        userService.Delete(userRequest);
        return "redirect:/user/list";
    }
}