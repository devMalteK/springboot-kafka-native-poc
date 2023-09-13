package de.kochnetonline.sbkanap.mapper;

import de.kochnetonline.sbkanap.model.kafka.MyKafkaMessage;
import de.kochnetonline.sbkanap.model.persistance.PersistanceObject;

public class PersistanceMapper {

    private PersistanceMapper() {
    }

    /**
     * maps a MyKafkaMessage to a PersistanceObject
     */
    public static PersistanceObject mapToPersistanceObject(MyKafkaMessage myKafkaMessage) {
        PersistanceObject persistanceObject = new PersistanceObject();
        persistanceObject.setValue1(myKafkaMessage.getValue1());
        persistanceObject.setValue2(myKafkaMessage.getValue2());
        return persistanceObject;
    }
}
