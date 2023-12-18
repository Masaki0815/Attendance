package com.example.AttendanceManage.Controller;

import com.example.AttendanceManage.Entity.UserEntity;
import com.example.AttendanceManage.Request.UserRequest;
import com.example.AttendanceManage.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    //ログイン
    @RequestMapping({"/", "/user/login"})
    public String Login(@RequestParam(value = "error", required = false) String error, Model model) {
        if (error != null) {
            String msg = "エラー: パスワードまたはユーザーネームが間違っています";
            model.addAttribute("errorMessage", msg);
        }
        return "user/login";
    }

    //ログアウト
    @RequestMapping({"logout", "/user/logout"})
    public String Logout(Model model) {
        return "redirect:/user/login";
    }


    //メニュー
    @RequestMapping(value = "/user/index", method = RequestMethod.GET)
    public String Index() {
        return "user/index";
    }

    //リスト(user)
    @RequestMapping(value = "/user/work")
    public String Work(Model model) {
        List<UserEntity> userlist = userService.searchAll();
        model.addAttribute("userlist", userlist);
        return "user/work";
    }

    //リスト(admin)
    @RequestMapping(value = "/user/list")
    public String List(Model model) {
        List<UserEntity> userlist = userService.searchAll();
        model.addAttribute("userlist", userlist);
        return "user/list";
    }

    //追加(admin)
    @RequestMapping(value = "/user/add")
    public String Add(Model model) {
        model.addAttribute("userRequest", new UserRequest());
        return "user/add";
    }

    //出勤
    @RequestMapping(value = "/user/start_time")
    public String Start(UserRequest userRequest) {
        UserEntity userEntity = userService.FindById(userRequest.getId());
        LocalDateTime nowDate = LocalDateTime.now();
        //
        DateTimeFormatter year = DateTimeFormatter.ofPattern("yyyy年MM月dd日E曜日");
        DateTimeFormatter day = DateTimeFormatter.ofPattern("HH時mm分");
        //
        String formatNowYear = year.format(nowDate);
        String formatNowDate = day.format(nowDate);
        //
        userEntity.setYear(formatNowYear);
        userEntity.setStart_time(formatNowDate);
        userService.Start_time(userRequest);
        //
        return "redirect:/user/work";
    }

    //退勤
    @RequestMapping(value = "/user/end_time")
    public String End(UserRequest userRequest) {
        UserEntity userEntity = userService.FindById(userRequest.getId());
        LocalDateTime nowDate = LocalDateTime.now();
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH時mm分");
        String formatNowDate = dtf2.format(nowDate);
        userEntity.setEnd_time(formatNowDate);
        userService.End_time(userRequest);
        return "redirect:/user/work";
    }

    @RequestMapping(value = "/user/start_break")
    public String Start_break(UserRequest userRequest) {
        UserEntity userEntity = userService.FindById(userRequest.getId());
        LocalDateTime nowDate = LocalDateTime.now();
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH時mm分");
        String formatNowDate = dtf2.format(nowDate);
        userEntity.setStart_break(formatNowDate);
        userService.Start_break(userRequest);
        return "redirect:/user/work";
    }

    @RequestMapping(value = "/user/end_break")
    public String End_break(UserRequest userRequest) {
        UserEntity userEntity = userService.FindById(userRequest.getId());
        LocalDateTime nowDate = LocalDateTime.now();
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH時mm分");
        String formatNowDate = dtf2.format(nowDate);
        userEntity.setEnd_break(formatNowDate);
        userService.End_break(userRequest);
        return "redirect:/user/work";
    }

    //勤怠作成
    @RequestMapping(value = "/user/create")
    public String Create(@ModelAttribute UserRequest userRequest, Model model) {
        userService.Work(userRequest);
        return "redirect:/user/work";
    }




    //削除機能
    @RequestMapping(value = "/user/delete")
    public String Delete(@ModelAttribute UserRequest userRequest) {
        // ユーザー情報の削除
        userService.Delete(userRequest);
        return "redirect:/user/list";
    }
}