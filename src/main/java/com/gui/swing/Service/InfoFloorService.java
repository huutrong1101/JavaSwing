package com.gui.swing.Service;

import com.gui.swing.DTO.Response.Pair;
import com.gui.swing.Entity.Floor;
import com.gui.swing.Repository.FloorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InfoFloorService {

    @Autowired
    private FloorRepository floorRepository;
    public List<Pair> getAllFloor(){
        List<Pair> result = new ArrayList<>();
        List<Floor> allFloor = floorRepository.findAll();
        for (Floor floor: allFloor){
            result.add(new Pair("Tên", floor.getFloorName()));
        }
        return result;
    }
}
