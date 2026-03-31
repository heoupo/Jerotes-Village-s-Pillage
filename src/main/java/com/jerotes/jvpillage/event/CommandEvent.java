package com.jerotes.jvpillage.event;

import com.mojang.brigadier.arguments.DoubleArgumentType;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Collection;

@Mod.EventBusSubscriber
public class CommandEvent {

	@SubscribeEvent
	public static void registerCommand(RegisterCommandsEvent event) {
		event.getDispatcher().register(Commands.literal("jerotes").requires(s -> s.hasPermission(4))
				//阵营关系
				//修改
				.then(Commands.literal("entity_change").then(Commands.argument("entities", EntityArgument.entities())
								.then(Commands.literal("variant_zsiein_discard")
										.then(Commands.argument("number", DoubleArgumentType.doubleArg(0)).executes(arguments -> {
															Collection<? extends Entity> entities = EntityArgument.getEntities(arguments, "entities");
															double d = DoubleArgumentType.getDouble(arguments, "number");
															for (Entity entity : entities) {
																entity.getPersistentData().putDouble("jerotesvillage_variant_zsiein_discard", d);
															}
															return 0;
														}
												)
										)
								)
						)
				)

		);
	}
}