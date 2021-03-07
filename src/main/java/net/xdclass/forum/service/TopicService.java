package net.xdclass.forum.service;

import net.xdclass.forum.domain.Reply;
import net.xdclass.forum.domain.Topic;
import net.xdclass.forum.domain.User;
import net.xdclass.forum.dto.PageDTO;

public interface TopicService {

    PageDTO<Topic>listTopicPageByCid(int cId,int page,int pageSize);


    Topic findById(int topicId);

    PageDTO<Reply> findReplyPageByTopicId(int topicId, int page, int pageSize);

    int addTopic(User loginUser, String title, String content, int cId);

    int replyByTopicId(User loginUser, int topicId, String content);

    void addOnePV(int topicId);
}
