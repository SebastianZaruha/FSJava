package com.cesur.splinterio.services.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cesur.splinterio.models.Comment;
import com.cesur.splinterio.models.Incidence;
import com.cesur.splinterio.models.User;
import com.cesur.splinterio.repositories.CommentRepository;
import com.cesur.splinterio.repositories.IncidenceRepository;
import com.cesur.splinterio.services.CommentService;

@Component
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private IncidenceRepository incidenceRepository;

    @Override
    public void addCommentToIncident(Long incidentId, User autor, String commentText) {
        Incidence incidence = incidenceRepository.findById(incidentId).orElse(null);
        Comment comment = new Comment();
        comment.setAutor(autor);
        comment.setIncidence(incidence);
        comment.setContent(commentText);
        comment.setCreatedAt(LocalDateTime.now());
        commentRepository.save(comment);
    }

    @Override
    public Comment getComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElse(null);
        return comment;         // Esta devolviendo una entidad
    }

    @Override
    public List<Comment> getCommentsByIncident(Long incidenceId) {
        Incidence incidence = incidenceRepository.findById(incidenceId).orElse(null);
        Comment comment = commentRepository.findById(incidenceId).orElse(null);
        List<Comment> comments = new ArrayList<>();
        for (Comment c : commentRepository.findAll()) {     // Se podría hacer con un findAllByIncidence(incidence) para no recorrer todos los comentarios
            if (c.getIncidence().equals(incidence)) {
                comments.add(c);
            }
        }
        return comments;

    }

    @Override
    public void deleteComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElse(null);
        comment.setDeletedAt(LocalDateTime.now());
        // Falta la confirmación de la eliminación

    }
    
    @Override
    public void updateComment(Long commentId, String newCommentText) {
        Comment comment = commentRepository.findById(commentId).orElse(null);
        comment.setContent(newCommentText);
        // Falta la confirmación de la actualización
        // Patch
    }

}
