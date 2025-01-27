package com.yacelly.notas_mvp.notes.controller;

import com.yacelly.notas_mvp.notes.domain.entity.Note;
import com.yacelly.notas_mvp.notes.dto.request.NoteRequestDTO;
import com.yacelly.notas_mvp.notes.dto.response.NoteResponseDTO;
import com.yacelly.notas_mvp.notes.dto.response.MessageResponseDTO;
import com.yacelly.notas_mvp.notes.service.NoteService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/notes")
public class NoteController {
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping
    public ResponseEntity<NoteResponseDTO> createNote(@RequestBody @Validated NoteRequestDTO noteRequestDTO) {
        NoteResponseDTO noteResponse = noteService.createNote(noteRequestDTO);
        return new ResponseEntity<>(noteResponse, HttpStatus.CREATED);
    }


    @GetMapping("/page")
    public ResponseEntity<Page<NoteResponseDTO>> getAllNotes(
            @PageableDefault(size = 10) Pageable pageable) {
        Page<NoteResponseDTO> notes = noteService.getAllNotes(pageable);
        return ResponseEntity.ok(notes);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<NoteResponseDTO> getNoteByUuid(@PathVariable UUID uuid) {
        NoteResponseDTO noteResponse = noteService.getNoteByUuid(uuid);
        return ResponseEntity.ok(noteResponse);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<NoteResponseDTO> updateNote(@PathVariable UUID uuid, @RequestBody @Validated NoteRequestDTO noteRequestDTO) {
        Note updatedNote = noteService.updateNote(uuid, noteRequestDTO);
        NoteResponseDTO responseDTO = new NoteResponseDTO(updatedNote);
        return ResponseEntity.ok(responseDTO);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<MessageResponseDTO> deleteNote(@PathVariable UUID uuid) {
        Note deletedNote = noteService.deleteNote(uuid);
        // Crear una respuesta con el mensaje y la nota eliminada
        NoteResponseDTO noteResponseDTO = new NoteResponseDTO(deletedNote);  // Usar el DTO para la respuesta
        //Mensaje de respuesta para cuando se borra la nota
        MessageResponseDTO messageResponseDTO = new MessageResponseDTO("Note has been successfully deleted (status set to false)", noteResponseDTO);

        return ResponseEntity.ok(messageResponseDTO);
    }


}
