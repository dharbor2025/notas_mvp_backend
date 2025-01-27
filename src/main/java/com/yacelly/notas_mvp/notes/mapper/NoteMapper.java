package com.yacelly.notas_mvp.notes.mapper;

import com.yacelly.notas_mvp.notes.domain.entity.Note;
import com.yacelly.notas_mvp.notes.dto.request.NoteRequestDTO;
import com.yacelly.notas_mvp.notes.dto.response.NoteResponseDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
public class NoteMapper {

    private final ModelMapper modelMapper;

    public NoteMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public Note toEntity(NoteRequestDTO noteRequestDTO) {
        return modelMapper.map(noteRequestDTO,Note.class);
    }

    public NoteResponseDTO toResponseDto(Note note) {
        return modelMapper.map(note, NoteResponseDTO.class);
    }


}
