package net.danygames2014.examplemod.event;

import net.danygames2014.examplemod.ExampleMod;
import net.mine_diver.unsafeevents.listener.EventListener;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.modificationstation.stationapi.api.event.recipe.RecipeRegisterEvent;
import net.modificationstation.stationapi.api.recipe.CraftingRegistry;
import net.modificationstation.stationapi.api.recipe.SmeltingRegistry;

public class RecipeListener {
    @EventListener
    public void registerRecipes(RecipeRegisterEvent event) {
        // Getting the Event type
        RecipeRegisterEvent.Vanilla type = RecipeRegisterEvent.Vanilla.fromType(event.recipeId);

        if (type == RecipeRegisterEvent.Vanilla.CRAFTING_SHAPED) {
            // This will only fire for Shaped Crafting Recipes
            CraftingRegistry.addShapedRecipe(new ItemStack(Item.BONE, 42), "owo", "w w", "owo", 'o', new ItemStack(ExampleMod.exampleItem), 'w', new ItemStack(Block.DIAMOND_BLOCK));
        }

        if (type == RecipeRegisterEvent.Vanilla.CRAFTING_SHAPELESS) {
            // This will only fire for Shapeless Crafting Recipes
            CraftingRegistry.addShapelessRecipe(new ItemStack(Item.PAPER, 14), Item.APPLE, Block.DIAMOND_BLOCK);
        }

        if (type == RecipeRegisterEvent.Vanilla.SMELTING) {
            // This will only fire for Smelting Recipes
            SmeltingRegistry.addSmeltingRecipe(new ItemStack(Item.FLINT), new ItemStack(Block.BROWN_MUSHROOM, 8));
        }
    }
}
