package ksafinalproject.gbt.chat.controller;

import io.swagger.annotations.Api;
import ksafinalproject.gbt.chat.model.Chat;
import ksafinalproject.gbt.chat.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api(tags = {"챗"})
@RestController
@CrossOrigin
@RequestMapping("/chat")
@RequiredArgsConstructor
@Slf4j
public class ChatController {

    private final ChatService chatService;

    @PostMapping("")
    public int chatSave(@RequestBody Chat chat) {
        try {
            return chatService.saveChat(chat);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @PutMapping("")
    public int chatUpdate(@RequestBody Chat chat) {
        try {
            return chatService.saveChat(chat);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @GetMapping("/{id}")
    public Optional<Chat> chatGetById(@PathVariable Long id) {
        try {
            return chatService.getChatById(id);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return Optional.empty();
        }
    }

    @GetMapping("/all")
    public List<Chat> chatGetAll() {
        try {
            return chatService.getAllChat();
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public int chatDeleteById(@PathVariable Long id) {
        try {
            return chatService.deleteChatById(id);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @GetMapping("/user/{userId}")
    public List<Chat> chatGetAllByUserId(@PathVariable Long userId) {
        try {
            return chatService.getAllChatByUserId(userId);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @GetMapping("/custom/{customId}")
    public List<Chat> chatGetAllByCustomId(@PathVariable Long customId) {
        try {
            return chatService.getAllChatByCustomId(customId);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }
}
