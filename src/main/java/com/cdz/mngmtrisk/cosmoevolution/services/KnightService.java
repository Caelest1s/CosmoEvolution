package com.cdz.mngmtrisk.cosmoevolution.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cdz.mngmtrisk.cosmoevolution.dto.KnightDTO;
import com.cdz.mngmtrisk.cosmoevolution.entity.Knight;
import com.cdz.mngmtrisk.cosmoevolution.repositories.KnightRepository;

public class KnightService {

    @Autowired
    private KnightRepository repository;

    // retrieve one
    @Transactional(readOnly = true)
    public KnightDTO findById(Long id) {

        Knight result = repository.findById(id).get();
        KnightDTO dto = new KnightDTO(result);
        return dto;
    }

    // retrieve ALL
    public Page<KnightDTO> findAll(Pageable pageable) {

        Page<Knight> results = repository.findAll(pageable);
        return results.map(x -> new KnightDTO());
    }

    // inserir Knight
    @Transactional
    public KnightDTO insert(KnightDTO dto) {

        Knight entity = new Knight();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new KnightDTO(entity);
    }

    // atualizar
    @Transactional()
    public KnightDTO update(Long id, KnightDTO dto) {

        Knight entity = repository.getReferenceById(id);
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new KnightDTO(entity);
    }

    // deletar por id
    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {

        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }

    private void copyDtoToEntity(KnightDTO dto, Knight entity) {

        entity.setStar(dto.getStar());
        entity.setCloth(dto.getCloth());
        entity.setConstelation(dto.getConstelation());
    }
}
