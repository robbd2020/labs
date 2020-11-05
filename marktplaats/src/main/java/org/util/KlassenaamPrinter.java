package org.util;

import java.lang.reflect.ParameterizedType;

public abstract class KlassenaamPrinter<T> {
    protected String typeSimple() {
        return T().getSimpleName();
    }

    @SuppressWarnings("unchecked")
    public Class<T> T() {
        return (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

}
