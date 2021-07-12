package kg.megacom.DemoCarRentApp.mappers;

import kg.megacom.DemoCarRentApp.model.Payment;
import kg.megacom.DemoCarRentApp.model.dto.PaymentDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PaymentMapper {
    PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);

    Payment toDto(Payment payment);

    PaymentDto toPayment(PaymentDto paymentDto);

    List<Payment> toDtoList(List<Payment> paymentList);

    List<PaymentDto> toPaymentList(List<PaymentDto> paymentDtoList);
}
