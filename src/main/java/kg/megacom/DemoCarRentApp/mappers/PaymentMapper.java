package kg.megacom.DemoCarRentApp.mappers;

import kg.megacom.DemoCarRentApp.model.Payment;
import kg.megacom.DemoCarRentApp.model.dto.PaymentDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PaymentMapper {
    PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);

    PaymentDto toDto(Payment payment);

    Payment toPayment(PaymentDto paymentDto);

    List<PaymentDto> toDtoList(List<Payment> paymentList);

    List<Payment> toPaymentList(List<PaymentDto> paymentDtoList);
}