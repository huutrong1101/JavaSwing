package com.gui.swing.Service;

import com.gui.swing.DTO.Response.InfoRoomResponse;
import com.gui.swing.Repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoService {

    @Autowired
    private RoomRepository roomRepository;

    public List<InfoRoomResponse> getAllRoomAtFloor(int floorNumber){
        return null;
    }
}
