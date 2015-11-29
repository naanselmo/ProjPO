package edt.textui.core;

import pt.utl.ist.po.ui.Command;

public abstract class ComposedCommand<V, T> extends Command<T> {

    private V _secondEntity;

    public ComposedCommand(String name, V secondEntity, T entity) {
        super(name, entity);
        this._secondEntity = secondEntity;
    }

    public V secondEntity() {
        return _secondEntity;
    }

}