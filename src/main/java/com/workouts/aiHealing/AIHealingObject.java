package com.workouts.aiHealing;

public class AIHealingObject {
    String xpath;
    String type;
    String tag;
    String id;
    String name;
    String value;

    AIHealingObject(String xpath,String tag,String type, String id, String name,String value){
        this.xpath=xpath;
        this.type=type;
        this.tag=tag;
        this.id=id;
        this.name=name;
        this.value=value;
    }

}
