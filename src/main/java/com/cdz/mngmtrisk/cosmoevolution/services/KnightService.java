package com.cdz.mngmtrisk.cosmoevolution.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cdz.mngmtrisk.cosmoevolution.dto.KnightDTO;
import com.cdz.mngmtrisk.cosmoevolution.entity.Knight;
import com.cdz.mngmtrisk.cosmoevolution.repositories.KnightRepository;
import com.cdz.mngmtrisk.cosmoevolution.services.exceptions.DatabaseException;
import com.cdz.mngmtrisk.cosmoevolution.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

// Posso usar o Component tbm, porém Service tem uma melhor semântica
@Service
// responsável pelas regras de negócio com o BD
public class KnightService {

    @Autowired
    private KnightRepository repository;

    // retrieve one
    @Transactional(readOnly = true)
    public KnightDTO findById(Long id) {

        Knight result = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
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

        try {

            Knight entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new KnightDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }

    // deletar por id
    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {

        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }

        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }

    // copy DTO to Entity
    private void copyDtoToEntity(KnightDTO dto, Knight entity) {

        entity.setStar(dto.getStar());
        entity.setCloth(dto.getCloth());
        entity.setConstelation(dto.getConstelation());
    }
}
