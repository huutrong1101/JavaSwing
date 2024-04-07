package com.gui.swing.DTO.Response;

import lombok.Data;

import java.util.List;

@Data
public class InfoRoomResponse {

    private int roomId;

    private String floorName;

    private String roomName;

    private String roomType;

    private List<Pair> roomInfo;

    private Boolean roomIsActive;


}
