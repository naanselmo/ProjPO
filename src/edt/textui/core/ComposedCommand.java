package edt.textui.core;

import pt.utl.ist.po.ui.Command;

public abstract class ComposedCommand<T, V> extends Command<T> {

    private V _secondEntity;

    public ComposedCommand(String name, T entity, V secondEntity) {
        super(name, entity);
        this._secondEntity = secondEntity;
    }

    public V secondEntity() {
        return _secondEntity;
    }

}