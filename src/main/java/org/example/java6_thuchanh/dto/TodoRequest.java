package org.example.java6_thuchanh.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TodoRequest {
    private Long id;
    private String title;
    private String description;
    private boolean completed;
}
