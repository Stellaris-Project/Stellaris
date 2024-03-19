package com.st0x0ef.stellaris.common.entities.alien;

import com.st0x0ef.stellaris.Stellaris;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.server.packs.resources.ResourceManagerReloadListener;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades.ItemListing;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.trading.MerchantOffer;

import java.util.HashMap;
import java.util.Map;

@Mod.EventBusSubscriber(modid = Stellaris.MODID)
public class AlienTrade implements ItemListing {
	public static final int MAX_USES = 9999;
	public static final Map<VillagerProfession, Int2ObjectMap<ItemListing[]>> TRADES = new HashMap<>();

	public static void onAddReloadListener(AddReloadListenerEvent event) {
		AlienTrade.addReloadListener(event);
	}

	public static void registerTrades(RecipeManager recipeManager) {
		/*
		Map<VillagerProfession, Int2ObjectMap<List<ItemListing>>> jobMap = new HashMap<>();
		VillagerProfession[] jobs = ForgeRegistries.PROFESSIONS.getValues().toArray(new VillagerProfession[0]);

		for (VillagerProfession job : jobs) {
			jobMap.put(job, new Int2ObjectOpenHashMap<>());
		}

		for (AlienTradingRecipeType<? extends AlienTradingRecipe> type : AlienTradingRecipeType.getTypes()) {
			List<? extends AlienTradingRecipe> recipes = recipeManager.getAllRecipesFor(type);

			for (AlienTradingRecipe recipe : recipes) {
				Int2ObjectMap<List<ItemListing>> listMap = jobMap.get(recipe.getJob());
				listMap.computeIfAbsent(recipe.getLevel(), l -> new ArrayList<>()).add(new AlienTrade(recipe));
			}

		}

		Map<VillagerProfession, Int2ObjectMap<ItemListing[]>> map = AlienTrade.TRADES;
		map.clear();

		for (Entry<VillagerProfession, Int2ObjectMap<List<ItemListing>>> entry : jobMap.entrySet()) {
			Int2ObjectMap<ItemListing[]> listMap = map.computeIfAbsent(entry.getKey(), l -> new Int2ObjectOpenHashMap<>());
			Int2ObjectMap<List<ItemListing>> values = entry.getValue();

			for (int level : values.keySet()) {
				List<ItemListing> trades = values.get(level);
				listMap.put(level, trades.toArray(new ItemListing[0]));
			}

		}
*/
	}

	@SubscribeEvent
	public static void addReloadListener(AddReloadListenerEvent event) {
		if (event.getServerResources() != null) {
			RecipeManager recipeManager = event.getServerResources().getRecipeManager();

			event.addListener((ResourceManagerReloadListener) resourceManager -> AlienTrade.registerTrades(recipeManager));
		}
	}


	/*
	private AlienTradingRecipe recipe;

	private AlienTrade(AlienTradingRecipe recipe) {
		this.recipe = recipe;
	}*/

	@Override
	public MerchantOffer getOffer(Entity entity, RandomSource random) {
		//AlienTradingRecipe recipe = this.getRecipe();
		//Triple<ItemStack, ItemStack, ItemStack> trade = recipe.getTrade(entity, random);
		//return new MerchantOffer(trade.getLeft(), trade.getMiddle(), trade.getRight(), 0, recipe.getMaxUses(), recipe.getXP(), recipe.getPriceMultiplier());
		return null;
	}

	/*
	public AlienTradingRecipe getRecipe() {
		return this.recipe;
	}*/
}