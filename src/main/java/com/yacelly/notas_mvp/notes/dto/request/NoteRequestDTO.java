package com.yacelly.notas_mvp.notes.dto.request;

import com.yacelly.notas_mvp.notes.enums.Category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class NoteRequestDTO {

    @NotBlank(message = "El título no puede estar vacío")
    private String title;

    @NotBlank(message = "El contenido no puede estar vacío")
    private String content;


    @NotNull(message = "La categoría no puede ser nula")
    private Category category;

    // Getters y Setters
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


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
