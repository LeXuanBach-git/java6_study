package org.example.java6_thuchanh.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomErrorDetails {
//    chua noi dung loi can xuat ra
    private LocalDateTime timestamp;
    private String message;
    private String details;
}
