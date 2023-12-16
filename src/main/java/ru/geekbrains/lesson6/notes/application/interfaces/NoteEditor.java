package ru.geekbrains.lesson6.notes.application.interfaces;

import ru.geekbrains.lesson6.notes.domain.Note;

public interface NoteEditor extends Editor<Note, Integer> {

    void printAll();

    // Новый метод для добавления записи
    boolean addNote(String title, String details);
}

