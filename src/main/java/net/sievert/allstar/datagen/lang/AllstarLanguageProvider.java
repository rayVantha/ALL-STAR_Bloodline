package net.sievert.allstar.datagen.lang;


import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.sievert.allstar.registry.AllstarItems;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

public class AllstarLanguageProvider extends LanguageProvider {
    public AllstarLanguageProvider(PackOutput output) {
        super(output, "allstar", "en_us");
    }

    private final Set<String> addedKeys = new HashSet<>();


    @Override
    protected void addTranslations() {

        /*

        //Simple flipped entries
        addManualFlipped(AllstarItems.ExampleItem);

        */

        addMissingRegistryTranslations(
                AllstarItems.class,
                "item",
                addedKeys,
                Item.class,
                BuiltInRegistries.ITEM::getKey
        );

        addManual("itemGroup.allstar.allstar", "Allstar");

        add("entity.allstar.stand_arrow", "Stand Arrow");

        addManual("death.attack.stand_arrow_fail", "%1$s's soul was rejected by the Stand Arrow.");

    }

    private void addManual(Object thing, String value) {
        String key = resolveKey(thing);
        add(key, value);
        addedKeys.add(key);
    }

    private void addManualFlipped(Object thing) {
        String key = resolveKey(thing);
        String path = key.substring(key.lastIndexOf('.') + 1);
        String value = flipAndTitle(path);
        addManual(key, value);
    }

    private String resolveKey(Object thing) {
        if (thing instanceof String str) return str;

        if (thing instanceof DeferredHolder<?, ?> deferred) {
            var resourceKey = deferred.getKey();
            return resourceKey.registry().getPath() + "." +
                    resourceKey.location().getNamespace() + "." +
                    resourceKey.location().getPath();
        }

        try {
            var getMethod = thing.getClass().getMethod("get");
            Object actual = getMethod.invoke(thing);
            if (actual != null && actual != thing) return resolveKey(actual);
        } catch (Exception ignored) {}

        if (thing instanceof Item item) {
            ResourceLocation id = BuiltInRegistries.ITEM.getKey(item);
            return "item." + id.getNamespace() + "." + id.getPath();
        }

        throw new IllegalArgumentException("Unsupported or unregistered object: " + thing + " (class: " + thing.getClass() + ")");
    }

    private static String capitalize(String s) {
        if (s == null || s.isEmpty()) return s;
        return Character.toUpperCase(s.charAt(0)) + s.substring(1);
    }

    public static String toTitleCase(String path) {
        String[] words = path.split("_");
        StringBuilder result = new StringBuilder();
        for (String w : words) if (!w.isEmpty()) result.append(capitalize(w)).append(" ");
        return result.toString().trim();
    }

    public static String flipAndTitle(String path) {
        String[] words = path.split("_");
        if (words.length == 2)
            return capitalize(words[1]) + " " + capitalize(words[0]);
        return toTitleCase(path);
    }

    public <T> void addMissingRegistryTranslations(
            Class<?> registryClass,
            String type,                        // "item" or "block"
            Set<String> addedKeys,
            Class<T> entryType,
            Function<T, ResourceLocation> idGetter
    ) {
        for (Field field : registryClass.getDeclaredFields()) {
            try {
                field.setAccessible(true);
                Object obj = field.get(null);

                if (obj != null && obj.getClass().getSimpleName().startsWith("Deferred")) {
                    try {
                        obj = obj.getClass().getMethod("get").invoke(obj);
                    } catch (Exception ignored) {
                        // Not a Deferred type, use raw value
                    }
                }

                if (!entryType.isInstance(obj)) continue;

                T entry = entryType.cast(obj);
                ResourceLocation id = idGetter.apply(entry);
                if (id == null) continue;

                String key = type + "." + id.getNamespace() + "." + id.getPath();
                if (addedKeys.contains(key)) {
                    System.out.println("Skipping (already added): " + key);
                    continue;
                }

                String autoName = toTitleCase(id.getPath());
                add(key, autoName);
                addedKeys.add(key);
            } catch (Exception ignored) {}
        }
    }





}
