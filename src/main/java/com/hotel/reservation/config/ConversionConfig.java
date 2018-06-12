package com.hotel.reservation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import com.hotel.reservation.convertor.ReservationEntityToReservationResponseConverter;
import com.hotel.reservation.convertor.ReservationRequestToReservationEntityConverter;
import com.hotel.reservation.convertor.RoomEntityToReservableRoomResponseConverter;

import java.util.HashSet;
import java.util.Set;

@Configuration public class ConversionConfig {

        private Set<Converter> getConverters() {
                Set<Converter> converters = new HashSet<Converter>();
                converters.add(new RoomEntityToReservableRoomResponseConverter());
                converters.add(new ReservationRequestToReservationEntityConverter());
                converters.add(new ReservationEntityToReservationResponseConverter());

                return converters;
        }

        @Bean public ConversionService conversionService() {
                ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
                bean.setConverters(getConverters());
                bean.afterPropertiesSet();

                return bean.getObject();
        }
}
