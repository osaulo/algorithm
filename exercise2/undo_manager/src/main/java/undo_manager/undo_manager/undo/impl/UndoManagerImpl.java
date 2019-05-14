package undo_manager.undo_manager.undo.impl;

import java.util.ArrayList;

import undo_manager.undo_manager.undo.Change;
import undo_manager.undo_manager.undo.Document;
import undo_manager.undo_manager.undo.UndoManager;

public class UndoManagerImpl implements UndoManager{
	
	private Document document;
	
	private ArrayList<Change> changes;
	
	private int cursor;
	
	private String type;

	public UndoManagerImpl() {
		super();
	}

	/**
	 * Construtor com document e com o tamanho do buffer
	 */
	public UndoManagerImpl(Document doc, int bufferSize) {
		this();
		changes = new ArrayList<Change>(bufferSize);
		document = doc;
		cursor = 0;
	}

	/**
	 * Metodo que registra as mudancas
	 */
	public void registerChange(Change change) {
		// deveria ser feito em change.apply
		document.insert(cursor++, type);
		document.setDot(cursor);
		
		change.apply(document);
		changes.add(change);
	}

	/**
	 * Verifica a possibilidade de desfazer as alteracoes
	 */
	public boolean canUndo() {
		boolean result = false;
		if ((cursor > 0) && (cursor <= changes.size())) {
			result = true;
		}
		return result;
	}

	/**
	 * desfaz as alteracoes
	 */
	public void undo() {
		if (this.canUndo()) {
			Change change = changes.get(cursor);
			
			// deveria ser feito em change.revert
			document.delete(cursor, type);
			document.setDot(cursor--);
			
			change.revert(document);
		}
	}

	/**
	 * Verifica a possibilidade de refazer as alteracoes
	 */
	public boolean canRedo() {
		boolean result = false;
		if ((cursor >= 0) && (cursor < changes.size())) {
			result = true;
		}
		return result;
	}

	/**
	 * refaz as alteracoes
	 */
	public void redo() {
		if (this.canRedo()) {
			Change change = changes.get(cursor);
			
			// deveria ser feito em change.apply
			document.insert(cursor, type);
			document.setDot(cursor++);
			
			change.apply(document);
		}
	}

	public void setType(String type) {
		this.type = type;
	}
}
