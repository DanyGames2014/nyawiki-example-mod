package net.danygames2014.examplemod.item;

import net.minecraft.entity.Entity;
import net.modificationstation.stationapi.api.template.item.TemplateItem;
import net.modificationstation.stationapi.api.util.Identifier;

public class ExampleItem extends TemplateItem {
    public ExampleItem(Identifier identifier) {
        super(identifier);
    }

    @Override
    public int getAttackDamage(Entity attackedEntity) {
        return 9001;
    }
}
