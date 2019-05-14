package undo_manager.undo_manager.undo.impl;

import undo_manager.undo_manager.undo.Document;
import undo_manager.undo_manager.undo.UndoManager;
import undo_manager.undo_manager.undo.UndoManagerFactory;

public class UndoManagerFactoryImpl implements UndoManagerFactory{

	public UndoManagerFactoryImpl() {
		super();
	}

	public UndoManager createUndoManager(Document doc, int bufferSize) {
		return new UndoManagerImpl(doc, bufferSize);
	}

}
