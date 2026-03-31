package com.jerotes.jvpillage.event;


import net.minecraftforge.fml.common.Mod;

import java.time.LocalDate;
import java.time.temporal.ChronoField;


@Mod.EventBusSubscriber
public class WeatherEvent {
	public static boolean isAprilFoolsDay() {
		LocalDate localDate = LocalDate.now();
		int n = localDate.get(ChronoField.DAY_OF_MONTH);
		int n2 = localDate.get(ChronoField.MONTH_OF_YEAR);
		return n2 == 4 && n == 1;
	}
}

