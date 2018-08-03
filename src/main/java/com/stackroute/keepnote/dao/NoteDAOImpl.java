package com.stackroute.keepnote.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.stackroute.keepnote.model.Note;

/*
 * This class is implementing the NoteDAO interface. This class has to be annotated with @Repository
 * annotation.
 * @Repository - is an annotation that marks the specific class as a Data Access Object, thus 
 * 				 clarifying it's role.
 * @Transactional - The transactional annotation itself defines the scope of a single database 
 * 					transaction. The database transaction happens inside the scope of a persistence 
 * 					context.  
 * */
@Repository
@Transactional
public class NoteDAOImpl implements NoteDAO {
	private SessionFactory sessionFactory;

	/*
	 * Autowiring should be implemented for the SessionFactory.
	 */
	@Autowired
	public NoteDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * Save the note in the database(note) table.
	 */

	public boolean saveNote(Note note) {
		Session session = sessionFactory.getCurrentSession();
		session.save(note);
		session.flush();
		return true;

	}

	/*
	 * Remove the note from the database(note) table.
	 */

	public boolean deleteNote(int noteId) {
		boolean bool = false;
		Session session = sessionFactory.getCurrentSession();
		if (getNoteById(noteId) != null) {
			session.clear();
			session.delete(getNoteById(noteId));
			session.flush();
			bool = true;
		}
		return bool;

	}

	/*
	 * retrieve all existing notes sorted by created Date in descending
	 * order(showing latest note first)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<Note> getAllNotes() {
		String hql = "FROM Note note ORDER BY note.createdAt DESC";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.getResultList();
	}

	/*
	 * retrieve specific note from the database(note) table
	 */
	public Note getNoteById(int noteId) {
		Session session = sessionFactory.getCurrentSession();
		Note note = (Note) session.get(Note.class, noteId);
		session.flush();
		return note;

	}

	/* Update existing note */

	public boolean UpdateNote(Note note) {
		boolean bool = false;
		Session session = sessionFactory.getCurrentSession();
		if (getNoteById(note.getNoteId()) != null) {
			session.clear();
			session.update(note);
			session.flush();
			bool = true;
		}
		return bool;

	}

}
