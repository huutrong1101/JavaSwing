package com.gui.swing.Service.Mapper;

import com.gui.swing.DTO.Response.InfoRoomResponse;
import com.gui.swing.DTO.Response.Pair;
import com.gui.swing.Entity.Room;
import com.gui.swing.Entity.RoomInfo;
import com.gui.swing.Service.InfoRoomService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomMapper {

    @Autowired
    private ModelMapper modelMapper;

    private InfoRoomService infoRoomService;

    @Autowired
    public void setInfoRoomService(@Lazy InfoRoomService infoRoomService) {
        this.infoRoomService = infoRoomService;
    }

    public InfoRoomResponse toRoomResponse(Room room){
        InfoRoomResponse infoRoomResponse = new InfoRoomResponse();
        infoRoomResponse = modelMapper.map(room, InfoRoomResponse.class);
        infoRoomResponse.setFloorName(room.getFloor().getFloorName());
        infoRoomResponse.setRoomType(room.getType().getRoomTypeValue().name());
        List<Pair> infoRoom = new ArrayList<>();
        for (RoomInfo roomInfo : room.getRoomInfoList()){
            infoRoom.add(new Pair(roomInfo.getKeyRoomInfo(),roomInfo.getValueRoomInfo()));
        }
        infoRoomResponse.setRoomInfo(infoRoom);
        return infoRoomResponse;
    }
}
