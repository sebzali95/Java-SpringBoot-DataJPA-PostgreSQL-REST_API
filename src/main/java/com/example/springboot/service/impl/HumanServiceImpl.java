package com.example.springboot.service.impl;

import com.example.springboot.dto.HumanDto;
import com.example.springboot.entity.Address;
import com.example.springboot.entity.Human;
import com.example.springboot.repository.AddressRepository;
import com.example.springboot.repository.HumanRepository;
import com.example.springboot.service.HumanService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HumanServiceImpl implements HumanService {

    private final HumanRepository humanRepository;
    private final AddressRepository addressRepository;

    @Override
    @Transactional
    public HumanDto save(HumanDto humanDto) {
//        Assert.isNull(kisiDto.getName(),"Name must be entered!");
        Human human = new Human();
        human.setName(humanDto.getName());
        human.setSurname(humanDto.getSurname());
        final Human humanDb = humanRepository.save(human);


        List<Address> list = new ArrayList<>();
        humanDto.getAdresleri().forEach(item -> {
            Address address = new Address();
            address.setAdres(item);
            address.setAdresTip(Address.AdresTip.DIGER);
            address.setAktiv(true);
            address.setHuman(humanDb);
            list.add(address);
        });
        addressRepository.saveAll(list);
        humanDto.setId(humanDb.getId());
        return humanDto;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<HumanDto> getAll() {
        List<Human> kisiler = humanRepository.findAll();
        List<HumanDto> humanDtos = new ArrayList<>();


        kisiler.forEach(it->{
            HumanDto humanDto = new HumanDto();
            humanDto.setId(it.getId());
            humanDto.setName(it.getName());
            humanDto.setSurname(it.getSurname());
            humanDto.setAdresleri(it.getAdresleri()
                    .stream()
                    .map(Address::getAdres)
                    .collect(Collectors.toList()));
            humanDtos.add(humanDto);
        });
        return humanDtos;
    }

    @Override
    public Page<HumanDto> getAll(Pageable pageable) {
        return null;
    }
}
