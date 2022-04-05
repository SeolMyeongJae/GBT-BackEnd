package ksafinalproject.gbt.chat.service;

import ksafinalproject.gbt.chat.model.Chat;

import java.util.List;
import java.util.Optional;

public interface ChatService {
    int saveChat(Chat chat);

    int updateChat(Chat chat, Long id);

    Optional<Chat> getChatById(Long id);

    List<Chat> getAllChat();

    int deleteChatById(Long id);

    List<Chat> getAllChatByUserId(Long userId);

    List<Chat> getAllChatByCustomId(Long customId);
}
