package ru.geekbrains.lesson6.notes.application;

import ru.geekbrains.lesson6.notes.application.interfaces.NoteEditor;
import ru.geekbrains.lesson6.notes.application.interfaces.NotesDatabaseContext;
import ru.geekbrains.lesson6.notes.application.interfaces.NotesPresenter;
import ru.geekbrains.lesson6.notes.domain.Note;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

public class ConcreteNoteEditor implements NoteEditor {

    private final NotesDatabaseContext dbContext;
    private final NotesPresenter notesPresenter;

    public ConcreteNoteEditor(
            NotesPresenter notesPresenter,
            NotesDatabaseContext dbContext){
        this.dbContext = dbContext;
        this.notesPresenter = notesPresenter;
    }

    public void printAll(){
        notesPresenter.printAll(getAll());
    }

    @Override
    public boolean add(Note item) {
        dbContext.getAll().add(item);
        return dbContext.saveChanges();
    }

    // Реализация нового метода для добавления записи
    @Override
    public boolean addNote(String title, String details) {
        Note newNote = new Note(0, 20001, title, details, new Date());
        return add(newNote);
    }

    @Override
    public boolean edit(Note item) {
        // Реализация метода edit
    }

    @Override
    public boolean remove(Note item) {
        // Реализация метода remove
    }

    @Override
    public Optional<Note> getById(Integer integer) {
        // Реализация метода getById
    }

    @Override
    public Collection<Note> getAll() {
        return dbContext.getAll();
    }
}
