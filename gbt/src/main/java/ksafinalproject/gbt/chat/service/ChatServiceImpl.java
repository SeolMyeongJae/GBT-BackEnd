package ksafinalproject.gbt.chat.service;

import ksafinalproject.gbt.chat.dto.IChat;
import ksafinalproject.gbt.chat.model.Chat;
import ksafinalproject.gbt.chat.repository.ChatRepository;
import ksafinalproject.gbt.customChallenge.repository.CustomChallengeRepository;
import ksafinalproject.gbt.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j

public class ChatServiceImpl implements ChatService {

    private final ChatRepository chatRepository;
    private final UserRepository userRepository;
    private final CustomChallengeRepository customChallengeRepository;

    @Override
    public int saveChat(IChat iChat) {
        log.info("save chat : {}", iChat);
        try {
            chatRepository.save(Chat.builder()
                    .id(iChat.getId())
                    .message(iChat.getMessage())
                    .created(LocalDateTime.now())
                    .user(userRepository.findById(iChat.getUserId()).orElseThrow())
                    .customChallenge(customChallengeRepository.findById(iChat.getCustomChallengeId()).orElseThrow())
                    .build());
            return 1;
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return -1;
        }
    }

    @Transactional
    @Override
    public int updateChat(IChat iChat, Long id) {
        log.info("update chat : {}, id : {}", iChat, id);
        try {
            Chat chat2 = chatRepository.findById(id).orElseThrow();
            chat2.setUser(userRepository.findById(iChat.getUserId()).orElseThrow());
            chat2.setMessage(iChat.getMessage());
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
    public List<Chat> getAllChatByCustomChallengeId(Long customChallengeId) {
        log.info("find all chat by custom id : {}", customChallengeId);
        try {
            return chatRepository.findAllByCustomChallengeId(customChallengeId);
        } catch (Exception e) {
            log.error("Error : {}", e.getMessage());
            return null;
        }
    }
}
