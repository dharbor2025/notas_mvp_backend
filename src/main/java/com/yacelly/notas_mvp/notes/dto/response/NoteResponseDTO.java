package com.yacelly.notas_mvp.notes.dto.response;

import com.yacelly.notas_mvp.notes.domain.entity.Note;
import com.yacelly.notas_mvp.notes.enums.Category;

import java.util.UUID;

public class NoteResponseDTO {
    private UUID uuid;
    private String title;
    private String content;
    private Boolean status;
    private Boolean isArchived;
    private Category category;

    // Constructor con parámetros
    public NoteResponseDTO(UUID uuid, String title, String content, boolean status, Category category) {
        this.uuid = uuid;
        this.title = title;
        this.content = content;
        this.status = status;
        this.category = category;
    }
    // Constructor sin argumentos (necesario para ModelMapper)
    public NoteResponseDTO() {
    }

    // Constructor que acepta una entidad Note
    public NoteResponseDTO(Note note) {
        this.uuid = note.getUuid();
        this.title = note.getTitle();
        this.content = note.getContent();
        this.status = note.isStatus();
        this.category = note.getCategory();
    }
    // Getters y Setters

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
