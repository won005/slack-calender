package com.example.slackVote;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;



@RestController
public class MenuController {
    @GetMapping("/slack/events")
    public String testEvents() {
        return "연결되는거지";
    }
    @PostMapping("/slack/events")
    public ResponseEntity<Map<String, Object>> handleSlackCommand(
            HttpServletRequest request) {  // 모든 데이터를 받아보자

        // 디버깅: 받은 모든 데이터 출력
        System.out.println("=== 슬랙에서 받은 데이터 ===");
        request.getParameterMap().forEach((key, value) -> {
            System.out.println(key + " = " + String.join(", ", value));
        });

        String command = request.getParameter("command");
        String userName = request.getParameter("user_name");

        Map<String, Object> response = new HashMap<>();
        response.put("response_type", "in_channel");
        response.put("text", "디버깅: " + command + " 명령어를 " + userName + "님이 실행했습니다!");

        return ResponseEntity.ok(response);
    }
}
//@RestController
//public class MenuController {
//    @PostMapping("slack/events")
//    public ResponseEntity<Map<String,Object>> handleSlackCommand(
//            @RequestParam("command") String command,
//            @RequestParam("text") String text,
//            @RequestParam("user_name") String userName
//     ){
//        if("/밥메추".equals(command)){ //작성한 커맨드가 /밥메추일 때
//            Map<String, Object> response = new HashMap<>();// json형태로 응답을 보내기 위한..
//            response.put("response_type","in_channel"); //in채널이라 다른사람들한테도 보임
//            response.put("text","안녕하세요");
//
//            return ResponseEntity.ok(response);
//        }
//        Map<String,Object> errorResponse = new HashMap<>();
//        errorResponse.put("text", "알 수 없는 명령어입니다.");
//        return ResponseEntity.ok(errorResponse);
//    }
//}
