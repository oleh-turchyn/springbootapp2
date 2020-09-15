package com.turchyn.springbootapp2.repository;

import com.turchyn.springbootapp2.domain.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Long> {
    List<Message> findBytag(String tag);
}
