package com.yacelly.notas_mvp.notes.dto.response;
import com.yacelly.notas_mvp.notes.dto.response.NoteResponseDTO;

public class MessageResponseDTO {
    private  String message;
    private  NoteResponseDTO note;

    public MessageResponseDTO(String message, NoteResponseDTO note) {
        this.message = message;
        this.note = note;
    }

    public MessageResponseDTO() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NoteResponseDTO getNote() {
        return note;
    }

    public void setNote(NoteResponseDTO note) {
        this.note = note;
    }
}

