package com.damianzygma.blogappweb.dto;

import com.damianzygma.blogappweb.entity.Post;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDto {

    private Long id;

    private String name;

    private String email;

    private String content;

    private LocalDateTime createdOn;

    private LocalDateTime updatedOn;

}
