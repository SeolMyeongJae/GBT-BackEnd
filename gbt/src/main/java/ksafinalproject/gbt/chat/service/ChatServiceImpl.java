package ksafinalproject.gbt.chat.service;

import ksafinalproject.gbt.chat.model.Chat;
import ksafinalproject.gbt.chat.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j

public class ChatServiceImpl implements ChatService {

    private final ChatRepository chatRepository;

    @Override
    public int saveChat(Chat chat) {
        log.info("save chat : {}", chat);
        try {
            chatRepository.save(Chat.builder()
                    .id(chat.getId())
                    .message(chat.getMessage())
                    .created(LocalDateTime.now())
                    .userId(chat.getUserId())
                    .customId(chat.getCustomId())
                    .build());
            return 1;
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @Override
    public Optional<Chat> getChatById(Long id) {
        log.info("find chat by id : {}", id);
        try {
            return chatRepository.findById(id);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public List<Chat> getAllChat() {
        log.info("find all chat");
        try {
            return chatRepository.findAll();
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @Override
    public int deleteChatById(Long id) {
        log.info("delete chat by id : {}", id);
        try {
            chatRepository.deleteById(id);
            return 1;
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @Override
    public List<Chat> getAllChatByUserId(Long userId) {
        log.info("find all chat by user id : {}", userId);
        try {
            return chatRepository.findAllByUserId(userId);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }

    @Override
    public List<Chat> getAllChatByCustomId(Long customId) {
        log.info("find all chat by custom id : {}", customId);
        try {
            return chatRepository.findAllByCustomId(customId);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }
}
