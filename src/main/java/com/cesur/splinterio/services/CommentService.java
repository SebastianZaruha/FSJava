package com.cesur.splinterio.services;

import java.util.List;

import com.cesur.splinterio.models.Comment;
import com.cesur.splinterio.models.User;

public interface CommentService {

    /*
     * 1- Añadir comentario ligado a incidencia
     * 2- Consultar comentario por id
     * 3- Consultar comentarios por incidencia
     * 3- Borrar comentario
     * 4- Modificar comentario
     */

    public void addCommentToIncident(Long incidentId, User autor, String commentText);

    public Comment getComment(Long commentId);

    public List<Comment> getCommentsByIncident(Long commentId);

    public void deleteComment(Long commentId);

    public void updateComment(Long commentId, String newCommentText);

}
