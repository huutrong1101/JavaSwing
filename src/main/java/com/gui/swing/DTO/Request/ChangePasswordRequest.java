package com.gui.swing.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChangePasswordRequest {
    private String userName;
    private String newPassword;
    private String confirmNewPassword;
}
