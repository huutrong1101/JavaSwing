package com.gui.swing.Service;

import com.gui.swing.DTO.Request.ChangePasswordRequest;
import com.gui.swing.DTO.Request.SendEmailRequest;
import com.gui.swing.DTO.Response.GeneralResponse;
import com.gui.swing.DTO.Response.InfoRoomResponse;
import com.gui.swing.Entity.Enum.EnumTypeRent;
import com.gui.swing.Entity.Guest;
import com.gui.swing.Repository.FloorRepository;
import com.gui.swing.Repository.GuestRepository;
import com.gui.swing.Entity.RoomGuest;
import com.gui.swing.Repository.RoomGuestRepository;
import com.gui.swing.Repository.RoomRepository;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Test {

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    EmailService emailService;

    @Autowired
    InfoRoomService infoRoomService;

    @Autowired
    private RoomGuestRepository roomGuestRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private InfoFloorService infoFloorService;


    public void testLogin(){
        System.out.println(authenticationService.authentication("giangnam17122002@gmail.com","giangnam123").getMessage());

    }
    public void testSendEmail() throws MessagingException {
        Map<String,Object> context = new HashMap<>();
        context.put("text",123);
        GeneralResponse generalResponse = emailService.sendMessageUsingThymeleafTemplate(new SendEmailRequest("giangnam.17122002@gmail.com", "Confirmation code", context));
        System.out.println(generalResponse.getMessage());
    }

    public void testForgetPassword() throws MessagingException {
        GeneralResponse generalResponse = authenticationService.forgetPassword("giangnam.17122002@gmail.com");
        System.out.println(authenticationService.confirmOTPCode("giangnam.17122002@gmail.com",123456) ? "Mã xác nhận đúng" : "Mã xác nhận sai");
    }

    public void testChangePassword(){
        GeneralResponse generalResponse = authenticationService.changePassword(new ChangePasswordRequest("huutrong1101@gmail.com","Giangnam1@","Giangnam1@"));
        System.out.println(generalResponse);
    }

    public void testGetInfoRoom(){
        List<InfoRoomResponse> result = infoRoomService.getAllRoomAtFloor("Floor2", true);
        for(InfoRoomResponse room : result){
            System.out.println(room);
        }
    }

    public void testIsRoomRent(){
//        Guest guest = new Guest(2,"Vo Giang Nam", "051202007648");
//        guestRepository.save(guest);
//        RoomGuest roomGuest = new RoomGuest(1, LocalDateTime.now().minusDays(0),LocalDateTime.now().plusDays(7), EnumTypeRent.Day,roomRepository.findById(1).get(),guestRepository.findById(2).get());
//        roomGuestRepository.save(roomGuest);
        System.out.println(infoRoomService.isRoomRent(1, LocalDateTime.now().minusDays(10), LocalDateTime.now().minusDays(9)));
    }

    public void testGetAllFloor(){
        System.out.println(infoFloorService.getAllFloor());
    }
}
