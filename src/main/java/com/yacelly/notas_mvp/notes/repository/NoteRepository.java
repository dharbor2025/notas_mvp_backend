package com.yacelly.notas_mvp.notes.repository;

import com.yacelly.notas_mvp.notes.domain.entity.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface NoteRepository extends JpaRepository<Note, Long> {
    Page<Note> findByStatusTrue(Pageable pageable);
    Optional<Note> findByUuidAndStatusTrue(UUID uuid);
    @Query("SELECT n FROM Note n " +
            "WHERE (:status IS NULL OR n.status = :status) " +
            "AND (:user_id IS NULL OR n.user.id = :user_id) " +
            "AND (:keyword IS NULL OR LOWER(n.title) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(n.content) LIKE LOWER(CONCAT('%', :keyword, '%')))")
    Page<Note> findAllWithFilters(Boolean status, String keyword, Long user_id, Pageable pageable);
}
