package com.example.finalapp.dto.page;

import com.example.finalapp.dto.comment.CommentListDTO;
import lombok.*;

import java.util.List;

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor @Builder
public class SliceDTO<T> {
    private boolean hasNext;
    private List<T> contentList;
}
