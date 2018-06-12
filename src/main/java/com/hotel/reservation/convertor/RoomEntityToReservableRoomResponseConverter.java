package com.hotel.reservation.convertor;

import org.springframework.core.convert.converter.Converter;

import com.hotel.reservation.entity.RoomEntity;
import com.hotel.reservation.model.Links;
import com.hotel.reservation.model.Self;
import com.hotel.reservation.model.response.ReservableRoomResponse;
import com.hotel.reservation.rest.ResourceConstants;

public class RoomEntityToReservableRoomResponseConverter implements Converter<RoomEntity, ReservableRoomResponse>{

	@Override
	public ReservableRoomResponse convert(RoomEntity source) {
		// TODO Auto-generated method stub
		
		ReservableRoomResponse reservationResponse = new ReservableRoomResponse();
		if(null != source.getId())
			reservationResponse.setId(source.getId());
		reservationResponse.setRoomNumber(source.getRoomNumber());
		reservationResponse.setPrice( Integer.valueOf(source.getPrice()) );
		
		Links links = new Links();
		Self self = new Self();
		self.setRef(ResourceConstants.ROOM_RESERVATION_V1 + "/" + source.getId());
		links.setSelf(self);
		
		reservationResponse.setLinks(links);
		
		return reservationResponse;
	}

	
	
}
