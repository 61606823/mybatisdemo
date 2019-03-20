package com.aska.mybatisdemo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthorBookBean {
    /**
     * 书籍Id
     */
    private String bookId;
    /**
     * 书籍名称
     */
    private String bookName;
    /**
     * 书籍价格
     */
    private BigDecimal price;
    /**
     * 作者名称
     */
    private String authorName;
}
