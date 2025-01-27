package com.yacelly.notas_mvp.notes.repository;

import com.yacelly.notas_mvp.notes.domain.entity.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface NoteRepository extends JpaRepository<Note, Long> {
    Page<Note> findByStatusTrue(Pageable pageable);
    Optional<Note> findByUuidAndStatusTrue(UUID uuid);

}
