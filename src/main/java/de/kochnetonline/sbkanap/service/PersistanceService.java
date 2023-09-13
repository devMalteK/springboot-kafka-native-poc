package de.kochnetonline.sbkanap.service;

import de.kochnetonline.sbkanap.model.persistance.PersistanceObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PersistanceService {

    /**
     * dummy method to save data
     *
     * @param persistanceObject
     */
    public void saveData(PersistanceObject persistanceObject) {
        log.info("saving Object [{}]", persistanceObject);
    }
}
