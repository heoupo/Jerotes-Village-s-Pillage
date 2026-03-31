package com.jerotes.jerotesvillage.event;

import com.mojang.brigadier.arguments.DoubleArgumentType;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
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
				.then(Commands.literal("relationship").then(Commands.argument("player", EntityArgument.player())
								.then(Commands.literal("add")
										.then(Commands.literal("carved")
												.then(Commands.argument("number", DoubleArgumentType.doubleArg(-2000)).executes(arguments -> {
																	Entity entity = arguments.getSource().getEntity();
																	Player playerTo = EntityArgument.getPlayer(arguments, "player");
																	if (entity instanceof Player player) {
																		double n = DoubleArgumentType.getDouble(arguments, "number");
																		RelationshipEvent.AddCopperCarvedCompanyRelationship(playerTo, (int) n);
																		player.sendSystemMessage(Component.literal(String.valueOf((RelationshipEvent.GetCopperCarvedCompanyRelationship(playerTo)))).withStyle(ChatFormatting.GOLD));
																	}
																	return 0;
																}
														)
												)
										)
								)
								.then(Commands.literal("set")
										.then(Commands.literal("carved")
												.then(Commands.argument("number", DoubleArgumentType.doubleArg(-1000)).executes(arguments -> {
																	Entity entity = arguments.getSource().getEntity();
																	Player playerTo = EntityArgument.getPlayer(arguments, "player");
																	if (entity instanceof Player player) {
																		double n = DoubleArgumentType.getDouble(arguments, "number");
																		RelationshipEvent.SetCopperCarvedCompanyRelationship(playerTo, (int) n);
																		player.sendSystemMessage(Component.literal(String.valueOf((RelationshipEvent.GetCopperCarvedCompanyRelationship(playerTo)))).withStyle(ChatFormatting.GOLD));
																	}
																	return 0;
																}
														)
												)
										)
								)
								.then(Commands.literal("get")
										.then(Commands.literal("carved").executes(arguments -> {
															Entity entity = arguments.getSource().getEntity();
															Player playerTo = EntityArgument.getPlayer(arguments, "player");
															if (entity instanceof Player player) {
																player.sendSystemMessage(Component.literal(String.valueOf((RelationshipEvent.GetCopperCarvedCompanyRelationship(playerTo)))).withStyle(ChatFormatting.GOLD));
															}
															return 0;
														}
												)
										)
								)
						)
				)
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