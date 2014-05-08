/**
 * Most of the code in the Qalingo project is copyrighted Hoteia and licensed
 * under the Apache License Version 2.0 (release version 0.8.0)
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *                   Copyright (c) Hoteia, 2012-2014
 * http://www.hoteia.com - http://twitter.com/hoteia - contact@hoteia.com
 *
 */
package org.hoteia.qalingo.core.dao;

import java.util.List;

import org.hoteia.qalingo.core.domain.EngineSetting;
import org.hoteia.qalingo.core.domain.EngineSettingValue;

public interface EngineSettingDao {

    // Engine Setting
    
    EngineSetting getEngineSettingById(Long id, Object... params);

    EngineSetting getEngineSettingByCode(String code, Object... params);

    List<EngineSetting> findEngineSettings(Object... params);

    EngineSetting saveEngineSetting(EngineSetting engineSetting);

    void deleteEngineSetting(EngineSetting engineSetting);

    // Engine Setting Value
    
    EngineSettingValue getEngineSettingValueById(Long id, Object... params);

    EngineSettingValue saveOrUpdateEngineSettingValue(EngineSettingValue engineSettingValue);

    void deleteEngineSettingValue(EngineSettingValue engineSettingValue);
}
