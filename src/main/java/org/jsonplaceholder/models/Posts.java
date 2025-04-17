package org.jsonplaceholder.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Posts {
    private String title;
    private String body;
    private int userId;
}