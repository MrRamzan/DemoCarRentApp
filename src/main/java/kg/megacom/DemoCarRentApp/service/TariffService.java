package kg.megacom.DemoCarRentApp.service;

import kg.megacom.DemoCarRentApp.model.dto.TariffDto;

import java.util.List;

public interface TariffService {

    List<TariffDto> getAll();

    TariffDto findById(Long id);

    TariffDto save(TariffDto tariffDto);

    TariffDto update(Long id, TariffDto tariffDto);

    int delete(Long id);
}
