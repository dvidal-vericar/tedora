package org.vericar.tedora.dao;

import org.vericar.tedora.model.DoiType;

import java.util.function.Function;

/**
 * DAO implementation for the Doi Type.
 *
 * @version 1.0
 */
public class DoiTypeDAO extends BaseDAO<DoiType, String, DoiTypeDAO> {
    @Override
    public DoiTypeDAO specialize() {
        return this;
    }

    @Override
    protected Function<DoiType, String> idExtractor() {
        return DoiType::getId;
    }

    @Override
    protected Class<DoiType> pojo() {
        return DoiType.class;
    }
}
