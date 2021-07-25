package kg.megacom.DemoCarRentApp.service.impl;

import kg.megacom.DemoCarRentApp.dao.TariffRepository;
import kg.megacom.DemoCarRentApp.exceptions.GeneralException;
import kg.megacom.DemoCarRentApp.mappers.TariffMapper;
import kg.megacom.DemoCarRentApp.model.Tariff;
import kg.megacom.DemoCarRentApp.model.dto.TariffDto;
import kg.megacom.DemoCarRentApp.service.TariffService;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class TariffServiceImpl implements TariffService {

    private TariffRepository tariffRepository;

    public TariffServiceImpl(TariffRepository tariffRepository) {
        this.tariffRepository = tariffRepository;
    }

    @Override
    public List<TariffDto> getAll() {
        List<Tariff> tariffs = tariffRepository.findAll();
        return TariffMapper.INSTANCE.toDtoList(tariffs);
    }

    @Override
    public TariffDto findById(Long id) {
        Tariff tariff = tariffRepository.findById(id).orElse(null);
        if (tariff == null) {
            throw new GeneralException("Tariff was not found");
        }
        return TariffMapper.INSTANCE.toDto(tariff);
    }

    @Override
    public TariffDto save(TariffDto tariffDto) {
        Tariff tariff = TariffMapper.INSTANCE.toTariff(tariffDto);
        tariff.setPriceStart(new Date());
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        calendar.setTime(date);
        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) + 975);
        Date date1 = calendar.getTime();
        tariff.setPriceEnd(date1);
        tariff.setPrice(tariffDto.getPrice());
        tariffRepository.save(tariff);
        return TariffMapper.INSTANCE.toDto(tariff);
    }

    @Override
    public TariffDto update(Long id, TariffDto tariffDto) {
        if (tariffRepository.existsById(id)) {
            Tariff tariff = tariffRepository.getById(id);
            Date date = new Date();
            tariff.setPriceEnd(new Date(date.getTime() - 1));
            tariffRepository.save(tariff);

            Tariff tariff1 = new Tariff();
            tariff1.setPriceStart(new Date());
            Calendar calendar = Calendar.getInstance();
            Date date1 = new Date();
            calendar.setTime(date1);
            calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) + 975);
            Date date2 = calendar.getTime();
            tariff1.setPriceEnd(date2);
            tariff1.setPrice(tariffDto.getPrice());
            tariffRepository.save(tariff1);
            return TariffMapper.INSTANCE.toDto(tariff);
        }
        return null;
    }

    @Override
    public int delete(Long id) {
        if (tariffRepository.existsById(id)) {
            Tariff tariff = tariffRepository.getById(id);
            tariffRepository.delete(tariff);
            return 1;
        }
        return 0;
    }
}
