package com.swill.lh;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(LargeHitboxesMod.MOD_ID)
public class LargeHitboxesMod {
    public static final String MOD_ID = "largehitboxes";

    public LargeHitboxesMod() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onAttack(AttackEntityEvent event) {
        Entity target = event.getTarget();
        if (target != null) {
            AABB box = target.getBoundingBox();
            double expand = 1.5;
            target.setBoundingBox(box.inflate(expand, expand, expand));
        }
    }
}
