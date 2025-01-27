package com.yacelly.notas_mvp.notes.service;

import com.yacelly.notas_mvp.auth.domain.entity.User;
import com.yacelly.notas_mvp.auth.repository.UserRepository;
import com.yacelly.notas_mvp.exception.ResourceNotFoundException;
import com.yacelly.notas_mvp.notes.domain.entity.Note;
import com.yacelly.notas_mvp.notes.dto.request.NoteRequestDTO;
import com.yacelly.notas_mvp.notes.dto.response.NoteResponseDTO;
import com.yacelly.notas_mvp.notes.mapper.NoteMapper;
import com.yacelly.notas_mvp.notes.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class NoteService {

    private final UserRepository userRepository;
    private final NoteRepository noteRepository;
    private final NoteMapper noteMapper;

    public NoteService(UserRepository userRepository, NoteRepository noteRepository, NoteMapper noteMapper) {
        this.userRepository = userRepository;
        this.noteRepository = noteRepository;
        this.noteMapper = noteMapper;
    }

    @Transactional
    public NoteResponseDTO createNote(NoteRequestDTO noteRequestDTO) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User user = userRepository.findOneByEmail(authentication.getName())
                .orElseThrow(ResourceNotFoundException::new);

        Note note = noteMapper.toEntity(noteRequestDTO);
        note.setUser(user);

        note = noteRepository.save(note);

        return noteMapper.toResponseDto(note);
    }

    @Transactional(readOnly = true)
    public Page<NoteResponseDTO> getAllNotes(Pageable pageable) {

        Page<Note> notes = noteRepository.findByStatusTrue(pageable);
        return notes.map(noteMapper::toResponseDto);
    }

    @Transactional(readOnly = true)
    public NoteResponseDTO getNoteByUuid(UUID uuid) {

        Note note = noteRepository.findByUuidAndStatusTrue(uuid)
                .orElseThrow(() -> new ResourceNotFoundException("Note not found"));

        return noteMapper.toResponseDto(note);
    }
    @Transactional
    public Note updateNote(UUID uuid, NoteRequestDTO noteRequestDTO) {
        Note note = noteRepository.findByUuidAndStatusTrue(uuid)
                .orElseThrow(() -> new ResourceNotFoundException("Note not found with UUID: " + uuid));

        // Actualizamos los campos permitidos
        note.setTitle(noteRequestDTO.getTitle());
        note.setContent(noteRequestDTO.getContent());
        note.setCategory(noteRequestDTO.getCategory());

        return noteRepository.save(note); // Guardamos los cambios
    }
    @Transactional
    public Note deleteNote(UUID uuid) {
        // Buscar la nota por UUID
        Note note = noteRepository.findByUuidAndStatusTrue(uuid)
                .orElseThrow(() -> new ResourceNotFoundException("Note not found with UUID: " + uuid));

        // Cambiar el estado de la nota a false (eliminada)
        note.setStatus(false);

        // Guardar los cambios en la base de datos
        Note updatedNote = noteRepository.save(note);

        // Retornar la nota actualizada (con el estado cambiado)
        return updatedNote;
    }
    @Transactional(readOnly = true)
    public Page<NoteResponseDTO> getNotesFilter(Boolean status, String keyword, Pageable pageable) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User user = userRepository.findOneByEmail(authentication.getName())
                .orElseThrow(ResourceNotFoundException::new);
        Page<Note> notes = noteRepository.findAllWithFilters(status, keyword, user.getId(), pageable);
        return notes.map(noteMapper::toResponseDto);
    }
}
