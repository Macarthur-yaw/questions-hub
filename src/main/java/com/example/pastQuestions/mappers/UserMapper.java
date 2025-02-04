package com.example.pastQuestions.mappers;

import com.example.pastQuestions.dto.UserOutputDto;
import com.example.pastQuestions.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserOutputDto toDto(User user);
}
