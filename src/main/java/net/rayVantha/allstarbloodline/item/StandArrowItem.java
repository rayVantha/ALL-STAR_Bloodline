package net.rayVantha.allstarbloodline.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
// Importar StandArrowEntity y ModEntities
import net.rayVantha.allstarbloodline.entity.custom.StandArrowEntity;
import net.rayVantha.allstarbloodline.entity.ModEntities;

public class StandArrowItem extends ArrowItem {

    public StandArrowItem(Properties properties) {
        super(properties);
    }

    @Override
    public AbstractArrow createArrow(Level level, ItemStack stack, LivingEntity shooter) {
        // Utilizar el constructor de StandArrowEntity que toma EntityType, LivingEntity, Level, e ItemStack.
        // Es importante pasar una copia de la stack (stack.copy()) si la entidad puede modificarla
        // o si quieres evitar efectos secundarios si la stack original se modifica en otro lugar.
        // Si tu StandArrowEntity no necesita el ItemStack para su lógica inicial (por ejemplo, para transferir NBT),
        // podrías omitirlo y usar un constructor que no lo requiera, pero es una buena práctica incluirlo.
        StandArrowEntity arrow = new StandArrowEntity(ModEntities.STAND_ARROW_ENTITY.get(), shooter, level, stack.copy());
        // Aquí podrías configurar propiedades adicionales de la flecha si es necesario antes de devolverla.
        // Ejemplo: arrow.setSomeCustomProperty(true);
        return arrow;
    }
}
